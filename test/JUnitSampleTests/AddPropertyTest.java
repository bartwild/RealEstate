package JUnitSampleTests;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import realestate.AddProperty.AddPropertyWindow;
import siphash.SipHasher;

public class AddPropertyTest {
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
        try (Connection connection = db_connection.OracleSqlConnector.getConnection();
            Statement statement = connection.createStatement()){
            statement.executeQuery("DELETE FROM REAL_ESTATE WHERE USERID IN (SELECT USERID FROM USERS WHERE LOGIN = 'login')");
        }
        catch(SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
    @Test
    public void testConstructor() throws Exception {
        new AddPropertyWindow(userId, true);
        new AddPropertyWindow(userId, false);
    }
    
    @Test
    public void testPropertyWithNoPhotoAdding() throws Exception {
        AddPropertyWindow addPropertyWindow = new AddPropertyWindow(userId, true);
        Assert.assertEquals(true, addPropertyWindow.insertPropertyToDatabase("Poland", "Torun", "10000", userId, new StringBuilder()));
        try (Connection connection = db_connection.OracleSqlConnector.getConnection();
            Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery("SELECT * FROM REAL_ESTATE ORDER BY ESTATEID DESC FETCH FIRST 1 ROWS ONLY");
            while(result.next()) {
                Assert.assertEquals("Poland", result.getString("COUNTRY"));
                Assert.assertEquals("Torun", result.getString("CITY"));
                Assert.assertEquals("10000", result.getString("PRICE"));
            }
        }
        catch(SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
    @Test
    public void testPropertyWithPhotoAdding() throws Exception {
        String estateId = "";
        AddPropertyWindow addPropertyWindow = new AddPropertyWindow(userId, true);
        StringBuilder pathToPhoto = new StringBuilder();
        pathToPhoto.append("'test_photo1.jpg'");
        Assert.assertEquals(true, addPropertyWindow.insertPropertyToDatabase("Poland", "Torun", "10000", userId, pathToPhoto));
        try (Connection connection = db_connection.OracleSqlConnector.getConnection();
            Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery("SELECT * FROM REAL_ESTATE ORDER BY ESTATEID DESC FETCH FIRST 1 ROWS ONLY");
            while(result.next()) {
                estateId = result.getString("ESTATEID");
                Assert.assertEquals("Poland", result.getString("COUNTRY"));
                Assert.assertEquals("Torun", result.getString("CITY"));
                Assert.assertEquals("10000", result.getString("PRICE"));
            }
            result = statement.executeQuery("SELECT p.COLUMN_VALUE FROM REAL_ESTATE r, TABLE(r.PATHS_TO_PHOTOS) p WHERE\n" +
"r.ESTATEID = '"+estateId+"'");
            while(result.next()) {
                Assert.assertEquals("test_photo1.jpg", result.getString(1));
            }
        }
        catch(SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
