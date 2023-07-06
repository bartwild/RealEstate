package realestate.DisplayProperties;
import java.sql.*;
import java.util.ArrayList;
import realestate.BuyerPage.SearchEstateResultFormPanel;

public class FollowedPropertiesWindow extends MyPropertiesWindow {

    /**
     * Creates new form FollowedPropertiesWindow
     * @param id
     */
    public FollowedPropertiesWindow(String id) {
        super(id);
        windowHeader.setText("Followed properties");
    }
    
    @Override
    public boolean getPropertiesFromDatabase(){
        try(Connection connection = db_connection.OracleSqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT ESTATEID FROM USER_FOLLOWS WHERE USERID=?");
                PreparedStatement statement2 = connection.prepareStatement("SELECT * FROM REAL_ESTATE WHERE ESTATEID=?");
                PreparedStatement statement3 = connection.prepareStatement("SELECT p.COLUMN_VALUE FROM REAL_ESTATE r, TABLE(r.PATHS_TO_PHOTOS) p WHERE r.ESTATEID=?")){
            statement.setString(1, MyID);
            ResultSet result = statement.executeQuery();
            ResultSet result2;
            while(result.next()){
                statement2.setString(1, result.getString(1));
                result2 = statement2.executeQuery();
                ResultSet result3;
                while (result2.next()){
                    pathsToPhotos = new ArrayList<>();
                    String estateID = result2.getString(1);
                    statement3.setString(1, estateID);
                    result3 = statement3.executeQuery();
                    while (result3.next()){
                        pathsToPhotos.add(result3.getString(1));
                    }
                    String country = result2.getString(2);
                    String city = result2.getString(3);
                    String price = result2.getString(4);
                    SearchEstateResultFormPanel estateIcon = new SearchEstateResultFormPanel(MyID, estateID, this, true, false, photoWidth, photoHeight);
                    estateIcon.setPhotoAndLabels(pathsToPhotos, city, country, price);
                    panelMap.put(estateID, estateIcon);
                }
            }
        }
        catch(Exception e){
            System.out.println("Error: " + e);
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new FollowedPropertiesWindow("").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
