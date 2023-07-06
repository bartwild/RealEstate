package JUnitSampleTests;
import realestate.Register.RegisterWindow;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import siphash.SipHasher;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Assert;
import org.junit.Test;

public class RegisterTest {
    private static final byte[] key = "password16bytess".getBytes();
    private static final String login = "login";
    private static final String password = "Kotek123";
    private static final String email = "jk@pw.edu.pl";
    private static int userId;

    
    @BeforeClass
    public static void setUpClass() throws Exception {
        try (Connection connection = db_connection.OracleSqlConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM USERS WHERE LOGIN = ?")){
            statement.setString(1, "login");
            statement.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        try (Connection connection = db_connection.OracleSqlConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM USERS WHERE LOGIN = ?")){
            statement.setString(1, "login");
            statement.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
    @Test
    public void testConstructor() {
        new RegisterWindow();
    }
    
    @Test
    public void testInsertingUserToDatabase() {
        RegisterWindow registerWindow = new RegisterWindow();
        Assert.assertEquals(true, registerWindow.insertUserToDatabase(login, password, email));
        try (Connection connection = db_connection.OracleSqlConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM USERS ORDER BY USERID DESC FETCH FIRST 1 ROWS ONLY")){
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                Assert.assertEquals("login", result.getString("LOGIN"));
                Assert.assertNotEquals("Kotek123", result.getString("PASSWORD"));
                Assert.assertEquals(SipHasher.toHexString(SipHasher.hash(key, password.getBytes())), result.getString("PASSWORD"));
                Assert.assertEquals("jk@pw.edu.pl", result.getString("EMAIL"));
            }
        }
        catch(SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
