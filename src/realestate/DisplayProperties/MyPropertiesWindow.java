package realestate.DisplayProperties;
import realestate.BuyerPage.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MyPropertiesWindow extends javax.swing.JFrame {
    String MyID;
    int photoWidth = 280;
    int photoHeight = 280;
    int gap = 30;
    ArrayList<String> pathsToPhotos = new ArrayList<>();
    HashMap<String, SearchEstateResultFormPanel> panelMap = new HashMap<>();

    /**
     * Creates new form MyProperties
     * @param userID
     */
    public MyPropertiesWindow(String userID) {
        MyID = userID;
        initComponents();
    }
    
    public HashMap getPanelMap() {
        return panelMap;
    }
    
    public boolean getPropertiesFromDatabase() {
        String estateID;
        String city;
        String country;
        String price;
        try(Connection connection = db_connection.OracleSqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM REAL_ESTATE WHERE USERID=" + MyID);
                PreparedStatement statement2 = connection.prepareStatement("SELECT p.COLUMN_VALUE FROM REAL_ESTATE r, TABLE(r.PATHS_TO_PHOTOS) p WHERE r.ESTATEID =?")){
            ResultSet result = statement.executeQuery();
            ResultSet result2;
            while (result.next()){
                pathsToPhotos = new ArrayList<>();
                estateID = result.getString(1);
                statement2.setString(1, estateID);
                result2 = statement2.executeQuery();
                while (result2.next()){
                    pathsToPhotos.add(result2.getString(1));
                }
                country = result.getString(2);
                city = result.getString(3);
                price = result.getString(4);
                SearchEstateResultFormPanel estateIcon = new SearchEstateResultFormPanel(MyID, estateID, this, false, true, photoWidth, photoHeight);
                estateIcon.setPhotoAndLabels(pathsToPhotos, city, country, price);
                panelMap.put(estateID, estateIcon);
            }
        }
        catch(SQLException e){
            System.out.println("Error: "+e);
            return false;
        }
        return true;
    }
    
    public void initProperties(){
        if(getPropertiesFromDatabase()) {
            displayProperties();
        }
    }

    public void deleteEstate(String estateID){
        jPanel.removeAll();
        jPanel.revalidate();
        jPanel.repaint();
        panelMap.remove(estateID);
        displayProperties();
    }
    
    public void refreshPage(){
        jPanel.removeAll();
        jPanel.revalidate();
        jPanel.repaint();
        initProperties();
        displayProperties();
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
        jPanel.setPreferredSize(new java.awt.Dimension(660, (photoWidth + gap)*(c / photosPerRow + 1)));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        jPanel = new javax.swing.JPanel();
        windowHeader = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setPreferredSize(new java.awt.Dimension(980, 630));

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        jScrollPane.setViewportView(jPanel);

        windowHeader.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        windowHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        windowHeader.setText("My properties");
        windowHeader.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        windowHeader.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(windowHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(windowHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        jPanel.removeAll();
        jPanel.revalidate();
        jPanel.repaint();
        displayProperties();
    }//GEN-LAST:event_formComponentResized

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new MyPropertiesWindow("").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane;
    protected javax.swing.JLabel windowHeader;
    // End of variables declaration//GEN-END:variables
}
