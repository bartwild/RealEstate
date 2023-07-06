package JUnitSampleTests;
import realestate.ChangePassword.ChangePassword;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import siphash.SipHasher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Assert;
import org.junit.Test;

public class ChangePasswordTest {
    private static final byte[] key = "password16bytess".getBytes();
    private static final String login = "login";
    private static final String password = "Kotek123";
    private static final String email = "jk@pw.edu.pl";
    private static String userId;
    @BeforeClass
    public static void setUpClass() throws Exception {
        try (Connection connection = db_connection.OracleSqlConnector.getConnection();
            Statement statement = connection.createStatement()){
            statement.executeQuery("INSERT INTO USERS(LOGIN, PASSWORD, EMAIL) VALUES ('"+login+"','"+SipHasher.toHexString(SipHasher.hash(key, password.getBytes()))+"','"+email+"')");
            ResultSet result = statement.executeQuery("SELECT USERID FROM USERS WHERE LOGIN = 'login'");
            while(result.next()) {
                userId = result.getString("USERID");
            }
            connection.close(); 
        }
        catch(SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        try (Connection connection = db_connection.OracleSqlConnector.getConnection();
            Statement statement = connection.createStatement()){
            statement.executeQuery("DELETE FROM USERS WHERE LOGIN = 'login'");
            connection.close(); 
        }
        catch(SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testConstructor() throws Exception {
        new ChangePassword(userId);
    }
    
    @Test
    public void testPasswordChange() throws Exception {
        ChangePassword changePasswordWindow = new ChangePassword(userId);
        String newPassword = "BolekLolek";
        String actualSipheredPassword = "";
        Assert.assertEquals(true, changePasswordWindow.changePassword(newPassword));
        try (Connection connection = db_connection.OracleSqlConnector.getConnection();
            Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery("SELECT * FROM USERS WHERE USERID = '"+userId+"'");
            while(result.next()) {
                actualSipheredPassword = result.getString("PASSWORD");
            }
            Assert.assertNotEquals(SipHasher.toHexString(SipHasher.hash(key, password.getBytes())),actualSipheredPassword);
            Assert.assertEquals(SipHasher.toHexString(SipHasher.hash(key, newPassword.getBytes())),actualSipheredPassword);
        }
        catch(SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
