package JUnitSampleTests;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import realestate.AddProperty.AddPropertyWindow;
import realestate.BuyerPage.*;
import realestate.DisplayProperties.FollowedPropertiesWindow;
import siphash.SipHasher;

public class FollowPropertyTest {
    private static final byte[] key = "password16bytess".getBytes();
    private static final String login = "login";
    private static final String password = "Kotek123";
    private static final String email = "jk@pw.edu.pl";
    private static String userId;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        try (Connection connection = db_connection.OracleSqlConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO USERS(LOGIN, PASSWORD, EMAIL) VALUES (?,?,?)");
            PreparedStatement statement2 = connection.prepareStatement("SELECT USERID FROM USERS WHERE LOGIN = login")){
            statement.setString(1, login);
            statement.setString(2, SipHasher.toHexString(SipHasher.hash(key, password.getBytes())));
            statement.setString(3, email);
            statement.executeUpdate();
            ResultSet result = statement2.executeQuery();
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
            PreparedStatement statement = connection.prepareStatement("DELETE FROM USERS WHERE LOGIN = ?");
            PreparedStatement statement2 = connection.prepareStatement("DELETE FROM REAL_ESTATE WHERE USERID = ?")){
            statement.setString(1, login);
            statement2.setString(1, userId);
            statement2.executeUpdate();
            statement.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
    @Test
    public void testFollowProperty() {
        try (Connection connection = db_connection.OracleSqlConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO REAL_ESTATE VALUES(1, \'Poland\', \'Torun\', 100000,"+userId+",string_list(\'test_photo1.jpg\'))");
        PreparedStatement statement2 = connection.prepareStatement("INSERT INTO USER_FOLLOWS VALUES(1,"+userId+")")){
            statement.executeQuery();
            statement2.executeQuery();
            FollowedPropertiesWindow followedProperties = new FollowedPropertiesWindow(userId);
            Assert.assertTrue(followedProperties.getPropertiesFromDatabase());
            HashMap<String, SearchEstateResultFormPanel> panelMap = followedProperties.getPanelMap();
            Assert.assertEquals(1, panelMap.size());
            Assert.assertTrue(panelMap.entrySet().stream().anyMatch(e -> e.getValue().getCity().equals("Torun")));
        }
        catch(SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
