package realestate.BuyerPage;
import java.sql.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JOptionPane;
import realestate.DisplayProperties.*;

public class SearchEstateResultFormPanel extends javax.swing.JPanel {
    String MyID;
    MyPropertiesWindow myPropertiesPass;
    String EstateID;
    String Country;
    String City;
    String Price;
    ArrayList<String> PathsToPhoto = new ArrayList();
    boolean followPass;
    boolean delPass;
    int photoWidth;
    int photoHeight;
    boolean followedByMe = false;
    boolean myEstate = false;
    /**
     * Creates new form SearchEstateResultFormPanel
     * @param myId
     * @param estateId
     * @param myProperties
     * @param follow
     * @param del
     * @param photoWidthPass
     * @param photoHeightPass
     */
    public SearchEstateResultFormPanel(String myId, String estateId, MyPropertiesWindow myProperties, boolean follow, boolean del, int photoWidthPass, int photoHeightPass) {
        photoWidth = photoWidthPass;
        photoHeight = photoHeightPass;
        myPropertiesPass = myProperties;
        followPass = follow;
        delPass = del;
        MyID = myId;
        EstateID = estateId;
        initComponents();
        updateFollowsLabel();
    }
    
    public ArrayList getPathsToPhoto() {
        return PathsToPhoto;
    }
    
    public String getCity() {
        return City;
    }
    
    public String getCountry() {
        return Country;
    }
    
    public String getPrice() {
        return Price;
    }
    
    private void updateFollowsLabel() {
        if(MyID.equals("0") || !followPass) {
            followButton.setVisible(false);
        }
        countFollowersAndCheckForMine();
        if(!followedByMe) {
            followButton.setBackground(Color.red);
            followButton.setForeground(Color.white);
            followButton.setText("Follow " + "\u2665");
        }
        else {
            followButton.setBackground(Color.white);
            followButton.setForeground(Color.black);
            followButton.setText("Unfollow " + "\u2714");
        }
        if(myEstate) {
            followButton.setBackground(Color.gray);
            followButton.setVisible(false);
            followButton.setToolTipText("You can't follow your own estate");
        }
        else {
            followButton.setToolTipText("");
            followButton.setEnabled(true);
        }
    }
    
    public void countFollowersAndCheckForMine() {
        followedByMe = false;
        try(Connection connection = db_connection.OracleSqlConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT USERID FROM USER_FOLLOWS WHERE ESTATEID = ?")) {
            statement.setString(1, EstateID);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                if(result.getString("USERID").equals(MyID)) {
                    followedByMe = true;
                }
            }
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try(Connection connection = db_connection.OracleSqlConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT USERID FROM REAL_ESTATE WHERE ESTATEID = ?")) {
            statement.setString(1, EstateID);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                if(result.getString("USERID").equals(MyID)) {
                    myEstate = true;
                }
            }
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void followOrUnfollowProperty(boolean follow) {
        if (follow){
            try(Connection connection = db_connection.OracleSqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO USER_FOLLOWS (USERID, ESTATEID) VALUES (?, ?)")) {
                statement.setString(1,MyID);
                statement.setString(2,EstateID);
                statement.executeQuery();
            }
            catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        else {
            try(Connection connection = db_connection.OracleSqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM USER_FOLLOWS WHERE USERID = ? AND ESTATEID = ?")) {
                statement.setString(1,MyID);
                statement.setString(2,EstateID);
                statement.executeQuery();
            }
            catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        updateFollowsLabel();
    }
    
    public void setPhotoAndLabels(ArrayList<String> pathsToPhoto, String city, String country, String price) {
        PathsToPhoto = pathsToPhoto;
        City = city;
        Country = country;
        Price = price;
        String pathToPhoto = pathsToPhoto.get(0);
        cityLabel.setText(city);
        if(cityLabel.getText().length() > 12) {
            cityLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
            priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        }
        countryLabel.setText(country);
        ImageIcon photo = new ImageIcon(getClass().getResource("/images/" + pathToPhoto));
        double photoWidthScaled = photoWidth * 0.92;
        double photoHeightScaled = photoHeight * 0.6;
        Image scalePhoto = photo.getImage().getScaledInstance((int)photoWidthScaled, (int)photoHeightScaled,Image.SCALE_SMOOTH);
        photo.setImage(scalePhoto);
        estatePhoto.setIcon(photo);
        priceLabel.setText(price + " PLN");
        if(priceLabel.getText().length() > 12) {
            cityLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
            priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        countryLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        estatePhoto = new javax.swing.JLabel();
        followButton = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchEstateResultFormPanel.this.mouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });

        countryLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        countryLabel.setText("Country");

        cityLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cityLabel.setText("City");

        priceLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        priceLabel.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(cityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(countryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceLabel)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityLabel)
                    .addComponent(countryLabel)
                    .addComponent(priceLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        followButton.setBackground(new java.awt.Color(255, 102, 102));
        followButton.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        followButton.setText("jButton1");
        followButton.setToolTipText("Follow");
        followButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 1, true));
        followButton.setContentAreaFilled(false);
        followButton.setOpaque(true);
        followButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                followButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(estatePhoto))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(followButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(estatePhoto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(followButton)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        EstateInfo estateInfo = new EstateInfo(MyID, EstateID, PathsToPhoto, delPass, myPropertiesPass);
        estateInfo.setLabels(cityLabel.getText(), countryLabel.getText(), priceLabel.getText());
        estateInfo.setVisible(true);
    }//GEN-LAST:event_formMouseClicked

    private void mouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseEntered
        cityLabel.setForeground(Color.blue);
        countryLabel.setForeground(Color.blue);
        priceLabel.setForeground(Color.blue);
        cityLabel.setFont(new Font("Segoe UI", Font.PLAIN, cityLabel.getFont().getSize()));
        countryLabel.setFont(new Font("Segoe UI", Font.PLAIN, countryLabel.getFont().getSize()));
        priceLabel.setFont(new Font("Segoe UI", Font.PLAIN, priceLabel.getFont().getSize()));
    }//GEN-LAST:event_mouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        cityLabel.setForeground(Color.black);
        countryLabel.setForeground(Color.black);
        priceLabel.setForeground(Color.black);
        cityLabel.setFont(new Font("Segoe UI", Font.BOLD, cityLabel.getFont().getSize()));
        countryLabel.setFont(new Font("Segoe UI", Font.PLAIN, countryLabel.getFont().getSize()));
        priceLabel.setFont(new Font("Segoe UI", Font.BOLD, priceLabel.getFont().getSize()));
    }//GEN-LAST:event_jPanel2MouseExited

    private void followButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_followButtonActionPerformed
        if(MyID.equals("0")) {
            JOptionPane.showMessageDialog(null,"Log in to follow this property!");
        }
        else {
            followOrUnfollowProperty(!followedByMe);
            if(myPropertiesPass != null){
                myPropertiesPass.deleteEstate(EstateID);
            }
        }
    }//GEN-LAST:event_followButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cityLabel;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JLabel estatePhoto;
    private javax.swing.JButton followButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel priceLabel;
    // End of variables declaration//GEN-END:variables
}
