package realestate.DisplayProperties;
import java.sql.*;
import java.util.ArrayList;
import realestate.BuyerPage.SearchEstateResultFormPanel;

public class PropertyGalleryWindow extends MyPropertiesWindow {
    
    public PropertyGalleryWindow(String id) {
        super(id);
        windowHeader.setText("Gallery of properties");
    }
    
    @Override
    public boolean getPropertiesFromDatabase(){
        try(Connection connection = db_connection.OracleSqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM REAL_ESTATE");
                PreparedStatement statement2 = connection.prepareStatement("SELECT p.COLUMN_VALUE FROM REAL_ESTATE r, TABLE(r.PATHS_TO_PHOTOS) p WHERE r.ESTATEID = ?")){
            String estateID;
            String city;
            String country;
            String price;
            ResultSet result = statement.executeQuery();
            while(result.next()){
                ArrayList<String> pathsToPhotos = new ArrayList<String>();
                estateID = result.getString(1);
                country = result.getString(2);
                city = result.getString(3);
                price = result.getString(4);
                statement2.setString(1, estateID);
                ResultSet result2 = statement2.executeQuery();
                while(result2.next()){
                    pathsToPhotos.add(result2.getString(1));
                }
                SearchEstateResultFormPanel estateIcon = new SearchEstateResultFormPanel(MyID, estateID, null, true, false, photoWidth, photoHeight);
                estateIcon.setPhotoAndLabels(pathsToPhotos, city, country, price);
                panelMap.put(estateID, estateIcon);
            }
            displayProperties();
        }
        catch(SQLException e){
            System.out.println("Error: " + e);
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new PropertyGalleryWindow("").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
