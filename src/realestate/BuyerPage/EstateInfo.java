package realestate.BuyerPage;
import java.awt.Image;
import java.io.File;
import java.nio.file.FileSystems;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import realestate.AddProperty.*;
import realestate.DisplayProperties.*;


public class EstateInfo extends javax.swing.JFrame {
    String MyID;
    String EstateID;
    boolean del;
    String city;
    String country;
    String price;
    MyPropertiesWindow myProperties;
    int currentEstatePhotoIndex;
    ArrayList<String> PathsToPhoto = new ArrayList();
    /**
     * Creates new form EstateInfo
     * @param userId
     * @param estateId
     * @param pathsToPhoto
     * @param delPass
     * @param myPropertiesPass
     */
    public EstateInfo(String userId, String estateId, ArrayList<String> pathsToPhoto, boolean delPass, MyPropertiesWindow myPropertiesPass) {
        myProperties = myPropertiesPass;
        PathsToPhoto = pathsToPhoto;
        del = delPass;
        MyID = userId;
        EstateID = estateId;
        currentEstatePhotoIndex = 0;
        initComponents();
        if(PathsToPhoto.size() < 2) {
            leftArrow.setEnabled(false);
            rightArrow.setEnabled(false);
        }
        else {
            leftArrow.setEnabled(true);
            rightArrow.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        headerEstateInfo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        currentEstatePhoto = new javax.swing.JLabel();
        rightArrow = new javax.swing.JLabel();
        leftArrow = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ownerName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        estateCountry = new javax.swing.JLabel();
        estateCity = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ownerEmail = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        estatePrice = new javax.swing.JLabel();
        labelFollowers = new javax.swing.JLabel();
        numberOfFollowers = new javax.swing.JLabel();
        purchaseOrDeleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(605, 484));

        headerEstateInfo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        headerEstateInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerEstateInfo.setText("Real estate info");

        currentEstatePhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        currentEstatePhoto.setPreferredSize(new java.awt.Dimension(400, 308));

        rightArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/RightArrow.png"))); // NOI18N
        rightArrow.setText("jLabel7");
        rightArrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rightArrow.setOpaque(true);
        rightArrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rightArrowMouseClicked(evt);
            }
        });

        leftArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LeftArrow.png"))); // NOI18N
        leftArrow.setText("jLabel9");
        leftArrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        leftArrow.setOpaque(true);
        leftArrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leftArrowMouseClicked(evt);
            }
        });

        jLabel3.setText("City:");

        ownerName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel2.setText("Owner login:");

        jLabel6.setText("Country:");

        estateCountry.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        estateCity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setText("Owner e-mail:");

        ownerEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Price:");

        estatePrice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        labelFollowers.setText("Number of followers:");

        numberOfFollowers.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ownerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estateCity, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estateCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ownerName, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(labelFollowers)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numberOfFollowers, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estatePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ownerName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(estateCountry))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelFollowers)
                            .addComponent(numberOfFollowers, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(estateCity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ownerEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(estatePrice))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(leftArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(currentEstatePhoto, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(rightArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rightArrow)
                        .addComponent(leftArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(currentEstatePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        purchaseOrDeleteButton.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        purchaseOrDeleteButton.setText("Follow");
        purchaseOrDeleteButton.setEnabled(false);
        purchaseOrDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseOrDeleteButtonActionPerformed(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        editButton.setText("Edit");
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(purchaseOrDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(headerEstateInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(purchaseOrDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(headerEstateInfo)
                    .addContainerGap(592, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 7, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setLabels(String cityPass, String countryPass, String pricePass) {
        city = cityPass;
        country = countryPass;
        price = pricePass;
        estateCity.setText(city);
        estateCountry.setText(country);
        estatePrice.setText(price);
        ImageIcon bufferIcon;
        if (del){
            purchaseOrDeleteButton.setText("Delete");
            editButton.setEnabled(true);
            purchaseOrDeleteButton.setEnabled(true);
            try(Connection connection = db_connection.OracleSqlConnector.getConnection();
                    PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM USER_FOLLOWS WHERE ESTATEID=?")){
                statement.setString(1, EstateID);
                ResultSet result = statement.executeQuery();
                while(result.next()){
                    numberOfFollowers.setText(result.getString(1));
                }
            }
            catch(SQLException e){
                System.out.println("Error: " + e);
            }
        }
        else {
            purchaseOrDeleteButton.setEnabled(false);
            purchaseOrDeleteButton.setVisible(false);
            editButton.setVisible(false);
            labelFollowers.setVisible(false);
        }
        bufferIcon = new ImageIcon(getClass().getResource("/images/" + PathsToPhoto.get(0))); 
        Image scaledPhoto = bufferIcon.getImage().getScaledInstance(400, 308, Image.SCALE_SMOOTH);
        bufferIcon.setImage(scaledPhoto);
        currentEstatePhoto.setIcon(bufferIcon);
        try(Connection connection = db_connection.OracleSqlConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM USERS WHERE USERID = (SELECT USERID FROM REAL_ESTATE WHERE ESTATEID = ?)")) {
            statement.setString(1,EstateID);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                ownerName.setText(result.getString("LOGIN"));
                ownerEmail.setText(result.getString("EMAIL"));
            }
        }
        catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void deleteEstate(){
        try(Connection connection = db_connection.OracleSqlConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM REAL_ESTATE WHERE ESTATEID = ?")) {
            statement.setString(1,EstateID);
            statement.executeQuery();
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void rightArrowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightArrowMouseClicked
        if(rightArrow.isEnabled()) {
            if(currentEstatePhotoIndex == PathsToPhoto.size() - 1) {
                currentEstatePhotoIndex = 0;
            }
            else {
                currentEstatePhotoIndex = currentEstatePhotoIndex + 1;
            }
            ImageIcon bufferIcon = new ImageIcon(getClass().getResource("/images/" + PathsToPhoto.get(currentEstatePhotoIndex)));
            Image scaledPhoto = bufferIcon.getImage().getScaledInstance(400, 308, Image.SCALE_SMOOTH);
            bufferIcon.setImage(scaledPhoto);
            currentEstatePhoto.setIcon(bufferIcon);
        }
    }//GEN-LAST:event_rightArrowMouseClicked

    private void leftArrowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftArrowMouseClicked
        if(leftArrow.isEnabled()) {
            if(currentEstatePhotoIndex == 0) {
                currentEstatePhotoIndex = PathsToPhoto.size() - 1;
            }
            else {
                currentEstatePhotoIndex = currentEstatePhotoIndex - 1;
            }
            ImageIcon bufferIcon = new ImageIcon(getClass().getResource("/images/" + PathsToPhoto.get(currentEstatePhotoIndex)));
            Image scaledPhoto = bufferIcon.getImage().getScaledInstance(400, 308, Image.SCALE_SMOOTH);
            bufferIcon.setImage(scaledPhoto);
            currentEstatePhoto.setIcon(bufferIcon);
        }
    }//GEN-LAST:event_leftArrowMouseClicked

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        EditPropertyWindow editPropertySite = new EditPropertyWindow(MyID, EstateID, city, country, price, PathsToPhoto, myProperties);
        editPropertySite.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_editButtonActionPerformed

    private void purchaseOrDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseOrDeleteButtonActionPerformed
        if (del){
            String[] options = {"No", "Yes"};
            int option = JOptionPane.showOptionDialog(null, "Are you sure you want to delete it?", "Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (option == 1){
                try(Connection connection = db_connection.OracleSqlConnector.getConnection();
                    PreparedStatement statement = connection.prepareStatement("SELECT p.COLUMN_VALUE FROM REAL_ESTATE r, TABLE(r.PATHS_TO_PHOTOS) p WHERE r.ESTATEID = ?")) {
                    statement.setString(1,EstateID);
                    ResultSet result = statement.executeQuery();
                    String photoDir = FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "/src/images/";
                    while (result.next()){
                        File f = new File(photoDir+result.getString(1));
                        f.delete();
                    }
                    deleteEstate();
                    JOptionPane.showMessageDialog(null, "Property deleted!");
                    myProperties.deleteEstate(EstateID);
                    this.dispose();
                }
                catch (Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_purchaseOrDeleteButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new EstateInfo("", "", new ArrayList<>(), false, null).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel currentEstatePhoto;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel estateCity;
    private javax.swing.JLabel estateCountry;
    private javax.swing.JLabel estatePrice;
    private javax.swing.JLabel headerEstateInfo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelFollowers;
    private javax.swing.JLabel leftArrow;
    private javax.swing.JLabel numberOfFollowers;
    private javax.swing.JLabel ownerEmail;
    private javax.swing.JLabel ownerName;
    private javax.swing.JButton purchaseOrDeleteButton;
    private javax.swing.JLabel rightArrow;
    // End of variables declaration//GEN-END:variables
}
