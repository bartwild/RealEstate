package realestate.BuyerPage;
import java.util.ArrayList;
import java.sql.*;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.*;

public class SearchEstateResultWindow extends javax.swing.JFrame {
    String MyID;
    Integer ascendingSorting = 1;
    Map<String, SearchEstateResultFormPanel> panelMap = new HashMap();
    int photoWidth = 270;
    int photoHeight = 280;
    int gap = 20;
    /**
     * Creates new form SearchEstateResultWindow
     * @param userID
     */
    public SearchEstateResultWindow(String userID) {
        MyID = userID;
        initComponents();
        sortingOption.add("");
        sortingOption.add("price");
        sortingOption.add("city");
        sortingOption.add("country");
        radioButtonGroup.add(ascButton);
        radioButtonGroup.add(descButton);
        ascButton.setVisible(false);
        descButton.setVisible(false);
    }
    
    public void initProperties(ArrayList<String> ids, ArrayList<String> cities, ArrayList<String> countries, ArrayList<String> prices) {
        ArrayList<String> pathsToPhotos;
        String query = "SELECT p.COLUMN_VALUE, r.USERID FROM REAL_ESTATE r, TABLE(r.PATHS_TO_PHOTOS) p WHERE r.ESTATEID = ?";
        try(Connection connection = db_connection.OracleSqlConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {    
            for (int i = 0; i < cities.size(); i++) {
                boolean isThisMyEstate = false;
                pathsToPhotos = new ArrayList();
                statement.setString(1, ids.get(i));
                ResultSet result = statement.executeQuery();
                while(result.next()) {
                    if (result.getString(2).equals(MyID)){
                        isThisMyEstate = true;
                        break;
                    }
                    pathsToPhotos.add(result.getString(1));
                }
                if (!isThisMyEstate){
                    SearchEstateResultFormPanel estateIcon = new SearchEstateResultFormPanel(MyID, ids.get(i), null, true, false, photoWidth, photoHeight);
                    estateIcon.setPhotoAndLabels(pathsToPhotos, cities.get(i), countries.get(i), prices.get(i));
                    panelMap.put(ids.get(i), estateIcon);
                }
            }
            displayProperties();
        }   
        catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void displayProperties(){
        int c = 0;
        var panelSize = jPanel.getSize();
        int photosPerRow = (panelSize.width - gap) / (photoWidth + gap);
        for (HashMap.Entry<String,SearchEstateResultFormPanel> entry : panelMap.entrySet()){
            entry.getValue().setBounds(gap + (c % photosPerRow) * (photoWidth + gap), gap + (c / photosPerRow) * (photoHeight + gap), photoWidth, photoHeight);
            entry.getValue().setVisible(true);
            jPanel.add(entry.getValue());
            c++;
        }
        jPanel.setPreferredSize(new java.awt.Dimension(650, (photoWidth + gap)*(c / photosPerRow + 1)));
    }

    public void boughtProperty(String estateID){
        jPanel.removeAll();
        jPanel.revalidate();
        jPanel.repaint();
        panelMap.remove(estateID);
        displayProperties();
    }

    private void sortEstates() {
        switch(sortingOption.getSelectedItem()) {
            case "price":
                panelMap = panelMap.entrySet().stream()
                    .sorted((e1,e2) -> ascendingSorting * Integer.compare(Integer.parseInt(e1.getValue().getPrice()), Integer.parseInt(e2.getValue().getPrice())))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));;
                break;
            
            case "country":
                panelMap = panelMap.entrySet().stream()
                    .sorted((e1,e2) -> ascendingSorting * e1.getValue().getCountry().compareTo(e2.getValue().getCountry()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));;
                break;
            
            case "city":
                panelMap = panelMap.entrySet().stream()
                    .sorted((e1,e2) -> ascendingSorting * e1.getValue().getCity().compareTo(e2.getValue().getCity()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));;
                break;
        }
        displayProperties();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioButtonGroup = new javax.swing.ButtonGroup();
        estatesScrollPanel = new javax.swing.JScrollPane();
        jPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        sortingOption = new java.awt.Choice();
        ascButton = new javax.swing.JRadioButton();
        descButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(980, 630));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        estatesScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel.setAutoscrolls(true);

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 802, Short.MAX_VALUE)
        );

        estatesScrollPanel.setViewportView(jPanel);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search result");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerifyInputWhenFocusTarget(false);

        jPanel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Sort by:");

        sortingOption.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        sortingOption.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sortingOptionItemStateChanged(evt);
            }
        });

        ascButton.setSelected(true);
        ascButton.setText("ascending");
        ascButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ascButtonActionPerformed(evt);
            }
        });

        descButton.setText("descending");
        descButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sortingOption, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ascButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(ascButton)
                    .addComponent(sortingOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descButton)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(estatesScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(estatesScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        jPanel.removeAll();
        jPanel.revalidate();
        jPanel.repaint();
        displayProperties();
    }//GEN-LAST:event_formComponentResized

    private void descButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descButtonActionPerformed
        ascendingSorting = -1;
        sortEstates();
    }//GEN-LAST:event_descButtonActionPerformed

    private void ascButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ascButtonActionPerformed
        ascendingSorting = 1;
        sortEstates();
    }//GEN-LAST:event_ascButtonActionPerformed

    private void sortingOptionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sortingOptionItemStateChanged
        sortEstates();
        if(sortingOption.getSelectedItem().equals("")) {
            ascButton.setVisible(false);
            descButton.setVisible(false);
        }
        else {
            ascButton.setVisible(true);
            descButton.setVisible(true);
        }
    }//GEN-LAST:event_sortingOptionItemStateChanged
   
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new SearchEstateResultWindow("").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ascButton;
    private javax.swing.JRadioButton descButton;
    private javax.swing.JScrollPane estatesScrollPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.ButtonGroup radioButtonGroup;
    private java.awt.Choice sortingOption;
    // End of variables declaration//GEN-END:variables
}
