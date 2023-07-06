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
import realestate.BuyerPage.SearchEstateResultFormPanel;
import realestate.DisplayProperties.MyPropertiesWindow;
import siphash.SipHasher;

public class MyPropertiesTest {
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
    public void testMyProperties() {
        AddPropertyWindow addPropertyWindow = new AddPropertyWindow(userId, true);
        StringBuilder pathToPhoto = new StringBuilder();
        pathToPhoto.append("'test_photo1.jpg'");
        addPropertyWindow.insertPropertyToDatabase("Poland", "Torun", "10000", userId, pathToPhoto);
        addPropertyWindow.insertPropertyToDatabase("Poland", "Lodz", "250000", userId, pathToPhoto);
        MyPropertiesWindow myProperties = new MyPropertiesWindow(userId);
        Assert.assertTrue(myProperties.getPropertiesFromDatabase());
        HashMap<String, SearchEstateResultFormPanel> panelMap = myProperties.getPanelMap();
        Assert.assertEquals(2, panelMap.size());
        Assert.assertTrue(panelMap.entrySet().stream().anyMatch(e -> e.getValue().getCity().equals("Torun")));
        Assert.assertTrue(panelMap.entrySet().stream().anyMatch(e -> e.getValue().getCity().equals("Lodz")));
    }
}
