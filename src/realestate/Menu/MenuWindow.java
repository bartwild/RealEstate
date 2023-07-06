package realestate.Menu;
import java.sql.*;
import java.util.ArrayList;
import realestate.Login.*;
import realestate.AddProperty.*;
import realestate.BuyerPage.SearchEstatePanel;
import realestate.MyProfile.*;
import realestate.DisplayProperties.*;
import java.util.Random;
import javax.swing.JOptionPane;
import realestate.BuyerPage.SearchEstateResultFormPanel;

public final class MenuWindow extends javax.swing.JFrame {
    String MyID;
    int photoWidth;
    int photoHeight;
    int gap;
    
    /**
     * Creates new form MenuWindow
     * @param id
     */
    public MenuWindow(String id) {
        MyID = id;
        photoWidth = 405;
        photoHeight = 375;
        gap = 80;
        initComponents();
    }
    
    public MenuWindow() {
        this("0");
        logOut.setText("Log in");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        panel = new javax.swing.JPanel();
        myProfile = new javax.swing.JButton();
        searchProperty = new javax.swing.JButton();
        addProperty = new javax.swing.JButton();
        propertyGallery = new javax.swing.JButton();
        appName = new javax.swing.JLabel();
        logOut = new javax.swing.JButton();
        myProperties = new javax.swing.JButton();
        followedProperties = new javax.swing.JButton();
        photosPanel = new javax.swing.JPanel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel.setPreferredSize(new java.awt.Dimension(300, 1080));

        myProfile.setText("My profile");
        myProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myProfileActionPerformed(evt);
            }
        });

        searchProperty.setLabel("Search for properties");
        searchProperty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPropertyActionPerformed(evt);
            }
        });

        addProperty.setText("\u2795 Add a property");
        addProperty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPropertyActionPerformed(evt);
            }
        });

        propertyGallery.setLabel("Gallery of properties");
        propertyGallery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertyGalleryActionPerformed(evt);
            }
        });

        appName.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        appName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appName.setText("ToDom");
        appName.setVerifyInputWhenFocusTarget(false);

        logOut.setLabel("Log out");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });

        myProperties.setText("My properties");
        myProperties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myPropertiesActionPerformed(evt);
            }
        });

        followedProperties.setText("\u2764 Followed properties");
        followedProperties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                followedPropertiesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(appName, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(searchProperty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(propertyGallery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addProperty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myProperties, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(followedProperties, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(appName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(myProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(myProperties, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(followedProperties, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addProperty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchProperty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(propertyGallery, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 685, Short.MAX_VALUE)
                .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        searchProperty.getAccessibleContext().setAccessibleDescription("");

        photosPanel.setPreferredSize(new java.awt.Dimension(1620, 0));

        javax.swing.GroupLayout photosPanelLayout = new javax.swing.GroupLayout(photosPanel);
        photosPanel.setLayout(photosPanelLayout);
        photosPanelLayout.setHorizontalGroup(
            photosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1620, Short.MAX_VALUE)
        );
        photosPanelLayout.setVerticalGroup(
            photosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(photosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(photosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1074, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   public void loadProperties(){
        var panelSize = photosPanel.getSize();
        int photosPerRow = (panelSize.width - gap) / (photoWidth + gap);
        ArrayList<String> estates = new ArrayList<>();
        ArrayList<String> cities = new ArrayList<>();
        ArrayList<String> countries = new ArrayList<>();
        ArrayList<String> prices = new ArrayList<>();
        try(Connection connection = db_connection.OracleSqlConnector.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM REAL_ESTATE")){            
            ResultSet result = statement.executeQuery();
            while(result.next()){
                if(!result.getString(5).equals(MyID)){
                    estates.add(result.getString(1));
                    countries.add(result.getString(2));
                    cities.add(result.getString(3));
                    prices.add(result.getString(4));
                }
            }
        }
        catch(SQLException e){
            System.out.println("Error: " + e);
        }
        int limit = Math.min(estates.size(), 6);
        Random randomGenerator = new Random();
        for(int i = 0; i < limit; i++){
            int index = randomGenerator.nextInt(estates.size());
            ArrayList<String> pathsToPhotos = new ArrayList<String>();
            try(Connection connection = db_connection.OracleSqlConnector.getConnection();
                    PreparedStatement statement = connection.prepareStatement("SELECT p.COLUMN_VALUE FROM DBARTOS2.REAL_ESTATE r, TABLE(r.PATHS_TO_PHOTOS) p WHERE r.ESTATEID = " + estates.get(index))){
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    pathsToPhotos.add(result.getString(1));
                }
                SearchEstateResultFormPanel estateIcon;
                if (MyID.equals("0")){
                    estateIcon = new SearchEstateResultFormPanel(MyID, estates.get(index), null, false, false, photoWidth, photoHeight);
                }
                else{
                    estateIcon = new SearchEstateResultFormPanel(MyID, estates.get(index), null, false, false, photoWidth, photoHeight);
                }
                estateIcon.setPhotoAndLabels(pathsToPhotos, cities.get(index), countries.get(index), prices.get(index));
                estateIcon.setBounds(gap + (i % photosPerRow) * (photoWidth + gap), gap + (i / photosPerRow) * (photoHeight + gap), photoWidth, photoHeight);
                estateIcon.setVisible(true);
                photosPanel.add(estateIcon);
            }
            catch(SQLException e){
                System.out.println("Error: " + e);
            }
            estates.remove(index);
            cities.remove(index);
            countries.remove(index);
            prices.remove(index);
        }
   }
    
    private void myProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myProfileActionPerformed
        if (MyID.equals("0")){
            JOptionPane.showMessageDialog(null,"Log in to see your profile!");
        }
        else{
            MyProfile profileSite = new MyProfile(MyID, this);
            profileSite.setVisible(true);
        }
    }//GEN-LAST:event_myProfileActionPerformed

    private void addPropertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPropertyActionPerformed
        if (MyID.equals("0")){
            JOptionPane.showMessageDialog(null,"Log in to add a property!");
        }
        else{
            AddPropertyWindow addPropertySite = new AddPropertyWindow(MyID, true);
            addPropertySite.setVisible(true);
        }
    }//GEN-LAST:event_addPropertyActionPerformed

    private void propertyGalleryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertyGalleryActionPerformed
       PropertyGalleryWindow gallerySite = new PropertyGalleryWindow(MyID);
       gallerySite.initProperties();
       gallerySite.setVisible(true);
       gallerySite.pack();
    }//GEN-LAST:event_propertyGalleryActionPerformed

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        LoginWindow loginSite = new LoginWindow();
        loginSite.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logOutActionPerformed

    private void searchPropertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPropertyActionPerformed
        SearchEstatePanel searchEstate = new SearchEstatePanel(MyID);
        searchEstate.setVisible(true);
        searchEstate.pack();
    }//GEN-LAST:event_searchPropertyActionPerformed

    private void myPropertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myPropertiesActionPerformed
        if (MyID.equals("0")){
            JOptionPane.showMessageDialog(null,"Log in to see your properties!");
        }
        else{
            MyPropertiesWindow myPropertiesSite = new MyPropertiesWindow(MyID);
            myPropertiesSite.initProperties();
            myPropertiesSite.setVisible(true);
            myPropertiesSite.pack();
        }
    }//GEN-LAST:event_myPropertiesActionPerformed

    private void followedPropertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_followedPropertiesActionPerformed
        if (MyID.equals("0")){
            JOptionPane.showMessageDialog(null,"Log in to see followed properties!");
        }
        else{
            FollowedPropertiesWindow followedPropertiesSite = new FollowedPropertiesWindow(MyID);
            followedPropertiesSite.initProperties();
            followedPropertiesSite.setVisible(true);
        }
    }//GEN-LAST:event_followedPropertiesActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            MenuWindow menuWindow = new MenuWindow();
            menuWindow.loadProperties();
            menuWindow.setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProperty;
    private javax.swing.JLabel appName;
    private javax.swing.JButton followedProperties;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton logOut;
    private javax.swing.JButton myProfile;
    private javax.swing.JButton myProperties;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel photosPanel;
    private javax.swing.JButton propertyGallery;
    private javax.swing.JButton searchProperty;
    // End of variables declaration//GEN-END:variables
}
