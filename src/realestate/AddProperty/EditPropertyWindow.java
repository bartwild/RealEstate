package realestate.AddProperty;
import realestate.DisplayProperties.MyPropertiesWindow;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class EditPropertyWindow extends AddPropertyWindow {
    String estateID;
    String cityOld;
    String countryOld;
    String priceOld;
    ArrayList<String> pathsToPhotosOld;
    MyPropertiesWindow myProperties;
    /**
     * Creates new form EditEstate
     * @param id
     * @param estateIDPass
     * @param cityPass
     * @param countryPass
     * @param pricePass
     * @param pathsToPhotosPass
     * @param myPropertiesPass
     */
    public EditPropertyWindow(String id, String estateIDPass, String cityPass, String countryPass, String pricePass, ArrayList<String> pathsToPhotosPass, MyPropertiesWindow myPropertiesPass) {
        super(id, false);
        pathsToPhotosOld = new ArrayList<>();
        estateID = estateIDPass;
        cityOld = cityPass;
        countryOld = countryPass;
        priceOld = pricePass;
        pathsToPhotosOld = pathsToPhotosPass;
        myProperties = myPropertiesPass;
        if (pathsToPhotosOld.size() > 1){
            leftArrow.setEnabled(true);
            rightArrow.setEnabled(true);
        }
        loadInfo();
    }
    
    
    public boolean updatePropertyInDatabase(String country, String city, String price, StringBuilder pathsToPhotosUpdated) {
        try (Connection connection = db_connection.OracleSqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement("UPDATE DBARTOS2.REAL_ESTATE SET Country=\'"+country+"\', City=\'"+city+"\', Price="+price+", PATHS_TO_PHOTOS=string_list("+pathsToPhotosUpdated+") WHERE EstateID="+estateID)){
            try{
                for (var srcFile : getSrcFilesList()){
                    String fileName = srcFile.getName();
                    boolean checkForDuplicateFiles = new File(getPhotoDir(), fileName).exists();
                    if (!pathsToPhotosOld.contains(srcFile.getName()) && !checkForDuplicateFiles){
                        File dstFile = new File(getPhotoDir() + fileName);
                        Files.copy(srcFile.toPath(), dstFile.toPath());
                    }
                }
                statement.executeQuery();
            }
            catch(IOException | SQLException e){
                System.out.println("Error: " + e.getMessage());
                return false;
            }
        }
        catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    private void loadInfo(){
        addFiles(pathsToPhotosOld);
        header.setText("Edit property");
        confirmButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            confirmButtonClickedEdit(evt);
        });
    }
    
    private void confirmButtonClickedEdit(java.awt.event.ActionEvent evt) {
        StringBuilder pathsToPhotosUpdated = new StringBuilder();
        String countryUpdated = getCountry();
        String cityUpdated = getCity();
        String priceUpdated = getPrice();
        if (priceUpdated.trim().equals("") ||
               priceUpdated.trim().toLowerCase().equals("price")){
            String[] parts = priceOld.split(" ");
            priceUpdated = parts[0];
        }
        if (cityUpdated.trim().equals("") || cityUpdated.trim().toLowerCase().equals("city")){
            cityUpdated = cityOld;
        }
        if (countryUpdated.trim().equals("") ||
               countryUpdated.trim().toLowerCase().equals("country")){
            countryUpdated = countryOld;
        }
        if (getSrcFilesList().isEmpty()){
            pathsToPhotosUpdated.append("\'");
            for (String path : pathsToPhotosOld){
                pathsToPhotosUpdated.append(path);
                if (path.equals(pathsToPhotosOld.get(pathsToPhotosOld.size() - 1))){
                    pathsToPhotosUpdated.append("\'");
                    break;
                }
                pathsToPhotosUpdated.append("\',\'");
            }
        }
        else{
            pathsToPhotosUpdated = ArrayListToStringBuilder();
        }
        String[] options = {"No", "Yes"};
        int option = JOptionPane.showOptionDialog(null, "Is all of the updated information correct?", "Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (option == 1){
            if (updatePropertyInDatabase(countryUpdated, cityUpdated, priceUpdated, pathsToPhotosUpdated)){
                JOptionPane.showMessageDialog(null,"Property edited successfully!");
                myProperties.refreshPage();
                this.dispose();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(702, 537));
        setResizable(false);
        setSize(new java.awt.Dimension(702, 537));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 714, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new EditPropertyWindow("", "", "", "", "", new ArrayList<>(), null).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
