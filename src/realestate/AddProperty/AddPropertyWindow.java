package realestate.AddProperty;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class AddPropertyWindow extends javax.swing.JFrame {
    String MyID;
    String price;
    String city;
    String country;
    String photoDir = FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "/src/images/";
    File currentlyShownPhoto = null;
    public ArrayList<File> srcFilesList;

    /**
     * Creates new form AddPropertyWindow
     * @param id
     * @param setButton
     */
    public AddPropertyWindow(String id, boolean setButton) {
        srcFilesList = new ArrayList<>();
        MyID = id;
        initComponents();
        if (setButton){
            confirmButton.addActionListener((java.awt.event.ActionEvent evt) -> {
                confirmButtonClickedAdd(evt);
            });
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choosePhoto = new javax.swing.JButton();
        priceField = new javax.swing.JTextField();
        countryField = new javax.swing.JTextField();
        cityField = new javax.swing.JTextField();
        selectedPhoto = new javax.swing.JLabel();
        header = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        leftArrow = new javax.swing.JLabel();
        rightArrow = new javax.swing.JLabel();
        photoName = new javax.swing.JLabel();
        deletePhoto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        choosePhoto.setText("Add photo");
        choosePhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosePhotoActionPerformed(evt);
            }
        });

        priceField.setForeground(new java.awt.Color(153, 153, 153));
        priceField.setText("price");
        priceField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                priceFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                priceFieldFocusLost(evt);
            }
        });

        countryField.setForeground(new java.awt.Color(153, 153, 153));
        countryField.setText("country");
        countryField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                countryFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                countryFieldFocusLost(evt);
            }
        });

        cityField.setForeground(new java.awt.Color(153, 153, 153));
        cityField.setText("city");
        cityField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cityFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cityFieldFocusLost(evt);
            }
        });

        header.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setText("Add a property");

        confirmButton.setText("Confirm");

        leftArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LeftArrow.png"))); // NOI18N
        leftArrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        leftArrow.setEnabled(false);
        leftArrow.setOpaque(true);
        leftArrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leftArrowMouseClicked(evt);
            }
        });

        rightArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/RightArrow.png"))); // NOI18N
        rightArrow.setText("jLabel7");
        rightArrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rightArrow.setEnabled(false);
        rightArrow.setOpaque(true);
        rightArrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rightArrowMouseClicked(evt);
            }
        });

        deletePhoto.setText("Delete photo");
        deletePhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePhotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deletePhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(choosePhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countryField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(leftArrow)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(photoName, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rightArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(selectedPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
            .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(header)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(selectedPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(photoName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(leftArrow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(rightArrow))
                        .addGap(18, 18, 18)
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(countryField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deletePhoto)
                        .addGap(18, 18, 18)
                        .addComponent(choosePhoto)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getMyID(){
        return MyID;
    }
    
    public String getPrice(){
        return priceField.getText();
    }
    
    public String getCountry(){
        return countryField.getText();
    }
    
    public String getCity(){
        return cityField.getText();
    }
    
    public ArrayList<File> getSrcFilesList(){
        return srcFilesList;
    }
    
    public String getPhotoDir(){
        return photoDir;
    }
    
    public boolean insertPropertyToDatabase(String country, String city, String price, String id, StringBuilder pathsToPhotos) {
        try (Connection connection = db_connection.OracleSqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO REAL_ESTATE(Country, City, Price, UserID, PATHS_TO_PHOTOS) VALUES (?, ?, ?, ?, string_list("+pathsToPhotos+"))")){
            statement.setString(1, country);
            statement.setString(2, city);
            statement.setInt(3, Integer.parseInt(price));
            statement.setInt(4, Integer.parseInt(id));
            try{
                for (var srcFile : srcFilesList){
                    String fileName = srcFile.getName();
                    boolean checkForDuplicates = new File(photoDir, fileName).exists();
                    if (!checkForDuplicates){
                        File dstFile = new File(photoDir + fileName);
                        Files.copy(srcFile.toPath(), dstFile.toPath());
                    }
                }
                statement.executeQuery();
                return true;
            }
            catch(IOException | SQLException e){
                System.out.println("Error: " + e.getMessage());
                return false;
            }
        }
        catch(HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
            return false;
        }
    }
    
    public void addFiles(ArrayList<String> pathsToFiles){
        for (String path : pathsToFiles){
            File f = new File(photoDir + path);
            srcFilesList.add(f);
        }
        showPhoto(srcFilesList.get(0));
    }
    
    public void showPhoto(File srcFile){
        ImageIcon bufferIcon = new ImageIcon(srcFile.getAbsolutePath());
        Image scaledPhoto = bufferIcon.getImage().getScaledInstance(400, 308, Image.SCALE_SMOOTH);
        bufferIcon.setImage(scaledPhoto);
        selectedPhoto.setIcon(bufferIcon);
        photoName.setText(srcFile.getName());
        currentlyShownPhoto = srcFile;
    }
    
    protected StringBuilder ArrayListToStringBuilder(){
        StringBuilder pathsToPhotos = new StringBuilder();
        pathsToPhotos.append("\'");
        for (var srcFile : srcFilesList){
            String fileName = srcFile.getName();
            pathsToPhotos.append(fileName);
            if (srcFile == srcFilesList.get(srcFilesList.size() - 1)){
                pathsToPhotos.append("\'");
                break;
            }
            pathsToPhotos.append("\',\'");
        }
        return pathsToPhotos;
    }
    
    private void confirmButtonClickedAdd(java.awt.event.ActionEvent evt){
        country = countryField.getText();
        city = cityField.getText();
        price = priceField.getText();
        if (price.trim().equals("") ||
               price.trim().toLowerCase().equals("price") ||
               city.trim().equals("") ||
               city.trim().toLowerCase().equals("city") ||
               country.trim().equals("") ||
               country.trim().toLowerCase().equals("country") ||
               srcFilesList.isEmpty()){
            JOptionPane.showMessageDialog(null, "Missing information!");
        }
        else {
            String[] options = {"No", "Yes"};
            int option = JOptionPane.showOptionDialog(null, "Is all of the information correct?", "Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (option == 1){
                if(insertPropertyToDatabase(country, city, price, MyID, ArrayListToStringBuilder())) {
                    JOptionPane.showMessageDialog(null,"Property added successfully!");
                    this.dispose();
                }
            }
        }
    }
    
    private void choosePhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosePhotoActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        try{
            File srcFile = chooser.getSelectedFile();
            if (srcFile == null){
                return;
            }
            String fileName = srcFile.getName();
            if (!fileName.contains(".png") & !fileName.contains(".jpg") & !fileName.contains(".gif") & !fileName.contains(".jpeg")){
                JOptionPane.showMessageDialog(null,"Unsupported photo format!" );
                return;
            }
            for (var file : srcFilesList){
                if (file.getName().equals(fileName)){
                    JOptionPane.showMessageDialog(null, "File has been already chosen!");
                    return;
                }
            }
            srcFilesList.add(srcFile);
            if(srcFilesList.size() < 2) {
                leftArrow.setEnabled(false);
                rightArrow.setEnabled(false);
            }
            else {
                leftArrow.setEnabled(true);
                rightArrow.setEnabled(true);
            }
            showPhoto(srcFile);
        }
        catch(HeadlessException e){
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_choosePhotoActionPerformed

    private void priceFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_priceFieldFocusGained
        if(priceField.getText().trim().toLowerCase().equals("price")){
            priceField.setText("");
            priceField.setForeground(Color.black);
        }
    }//GEN-LAST:event_priceFieldFocusGained

    private void priceFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_priceFieldFocusLost
        if((priceField.getText().trim().equals("") ||
               priceField.getText().trim().toLowerCase().equals("price"))){
            priceField.setText("price");
            priceField.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_priceFieldFocusLost

    private void cityFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cityFieldFocusGained
        if(cityField.getText().trim().toLowerCase().equals("city")){
            cityField.setText("");
            cityField.setForeground(Color.black);
        }
    }//GEN-LAST:event_cityFieldFocusGained

    private void cityFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cityFieldFocusLost
        if((cityField.getText().trim().equals("") ||
                cityField.getText().trim().toLowerCase().equals("city"))){
            cityField.setText("city");
            cityField.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_cityFieldFocusLost

    private void countryFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_countryFieldFocusGained
       if(countryField.getText().trim().toLowerCase().equals("country")){
            countryField.setText("");
            countryField.setForeground(Color.black);
        }
    }//GEN-LAST:event_countryFieldFocusGained

    private void countryFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_countryFieldFocusLost
        if((countryField.getText().trim().equals("") ||
               countryField.getText().trim().toLowerCase().equals("country"))){
            countryField.setText("country");
            countryField.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_countryFieldFocusLost

    
    private void rightArrowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightArrowMouseClicked
        if(rightArrow.isEnabled() && currentlyShownPhoto != null) {
            int i = srcFilesList.indexOf(currentlyShownPhoto);
            if (i != srcFilesList.size()-1){
                i++;
            }
            else{
                i = 0;
            }
            currentlyShownPhoto = srcFilesList.get(i);
            showPhoto(currentlyShownPhoto);
        }
    }//GEN-LAST:event_rightArrowMouseClicked

    private void leftArrowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftArrowMouseClicked
        if(leftArrow.isEnabled() && currentlyShownPhoto != null) {
            int i = srcFilesList.indexOf(currentlyShownPhoto);
            if (i != 0){
                i--;
            }
            else{
                i = srcFilesList.size()-1;
            }
            currentlyShownPhoto = srcFilesList.get(i);
            showPhoto(currentlyShownPhoto);
        }
    }//GEN-LAST:event_leftArrowMouseClicked

    private void deletePhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePhotoActionPerformed
        if (srcFilesList.size() > 1){
            int i = srcFilesList.indexOf(currentlyShownPhoto);
            if (i == srcFilesList.size()- 1){
                i--;
            }
            srcFilesList.remove(currentlyShownPhoto);
            currentlyShownPhoto = srcFilesList.get(i);
            showPhoto(currentlyShownPhoto);
        }
        else if(srcFilesList.size() == 1){
            selectedPhoto.setIcon(null);
            photoName.setText("");
            srcFilesList.remove(currentlyShownPhoto);
            currentlyShownPhoto = null;
        }
        if(srcFilesList.size() < 2) {
            leftArrow.setEnabled(false);
            rightArrow.setEnabled(false);
        }
        else {
            leftArrow.setEnabled(true);
            rightArrow.setEnabled(true);
        }
    }//GEN-LAST:event_deletePhotoActionPerformed

    public static void main(String args[]) {      
        java.awt.EventQueue.invokeLater(() -> {
            new AddPropertyWindow("", false).setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton choosePhoto;
    private javax.swing.JTextField cityField;
    public javax.swing.JButton confirmButton;
    private javax.swing.JTextField countryField;
    private javax.swing.JButton deletePhoto;
    public javax.swing.JLabel header;
    protected javax.swing.JLabel leftArrow;
    private javax.swing.JLabel photoName;
    private javax.swing.JTextField priceField;
    protected javax.swing.JLabel rightArrow;
    private javax.swing.JLabel selectedPhoto;
    // End of variables declaration//GEN-END:variables
}
