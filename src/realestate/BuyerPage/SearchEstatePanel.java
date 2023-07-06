package realestate.BuyerPage;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SearchEstatePanel extends javax.swing.JFrame {
    ArrayList<String> SearchedIds = new ArrayList();
    ArrayList<String> SearchedCities = new ArrayList();
    ArrayList<String> SearchedCountries = new ArrayList();
    ArrayList<String> SearchedPrices = new ArrayList();
    String MyID = "";
    /**
     * Creates new form SearchEstatePanel
     * @param id
     */
    public SearchEstatePanel(String id) {
        MyID = id;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        filterText = new javax.swing.JTextField();
        filterLabel = new javax.swing.JLabel();
        searchSubmitButton = new javax.swing.JButton();
        priceFiltersPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        filter = new javax.swing.JLabel();
        filterPriceTo = new javax.swing.JTextField();
        filterPriceFrom = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        filterOption = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 102));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        filterText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filterText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        filterLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        filterLabel.setText("Country:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filterLabel)
                .addGap(18, 18, 18)
                .addComponent(filterText, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterText)
                    .addComponent(filterLabel))
                .addContainerGap())
        );

        searchSubmitButton.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        searchSubmitButton.setText("Search");
        searchSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSubmitButtonActionPerformed(evt);
            }
        });

        priceFiltersPanel.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("from:");

        filter.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        filter.setText("to:");

        filterPriceTo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        filterPriceFrom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout priceFiltersPanelLayout = new javax.swing.GroupLayout(priceFiltersPanel);
        priceFiltersPanel.setLayout(priceFiltersPanelLayout);
        priceFiltersPanelLayout.setHorizontalGroup(
            priceFiltersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(priceFiltersPanelLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterPriceFrom, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterPriceTo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        priceFiltersPanelLayout.setVerticalGroup(
            priceFiltersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(priceFiltersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(priceFiltersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(filter)
                    .addComponent(filterPriceTo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterPriceFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        filterOption.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        filterOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "country", "city", "price" }));
        filterOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterOptionActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Search by:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(filterOption, 0, 120, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterOption, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(priceFiltersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(45, 45, 45)
                                    .addComponent(searchSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(priceFiltersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(searchSubmitButton)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filterOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterOptionActionPerformed
        String option = filterOption.getSelectedItem().toString();
        filterLabel.setVisible(true);
        filterText.setVisible(true);
        priceFiltersPanel.setVisible(false);
        switch(option) {
            case "country":
                filterLabel.setText("Country:");
                break;
            case "city":
                filterLabel.setText("City:");
                break;
            case "price":
                filterLabel.setVisible(false);
                filterText.setVisible(false);
                priceFiltersPanel.setVisible(true);
                break;
        }
    }//GEN-LAST:event_filterOptionActionPerformed

    public ArrayList getSearchedIds() {
        return SearchedIds;
    }
    
    public ArrayList getSearchedCities() {
        return SearchedCities;
    }
    
    public ArrayList getSearchedCountries() {
        return SearchedCountries;
    }
    
    public ArrayList getSearchedPrices() {
        return SearchedPrices;
    }
    
    private static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
    
    public void searchEstates(String option, String filter) {
        searchEstates(option, filter, "-1", "");
    }
    
    public void searchEstates(String option, String filter, String priceFrom, String priceTo) {
        String query = "SELECT * FROM REAL_ESTATE WHERE LOWER(COUNTRY) LIKE ?";
        if(option.equals("city")) {
            query = "SELECT * FROM REAL_ESTATE WHERE LOWER(CITY) LIKE ?";
        }
        else if(option.equals("price")) {
            query = "SELECT * FROM REAL_ESTATE WHERE PRICE >= ?";
            if(!priceTo.equals("")) {
                query = "SELECT * FROM REAL_ESTATE WHERE PRICE >= ? AND PRICE <= ?"; 
            }
        }
        try (Connection connection = db_connection.OracleSqlConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            switch(option) {
                case "country":
                case "city":
                    statement.setString(1, "%" + filter.toLowerCase() + "%");
                    break;
                case "price":
                    statement.setString(1, priceFrom);
                    if(!priceTo.equals("")) {
                        statement.setString(2, priceTo);
                    }
                    break;
            }
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                SearchedIds.add(result.getString("ESTATEID"));
                SearchedCities.add(result.getString("CITY"));
                SearchedCountries.add(result.getString("COUNTRY"));
                SearchedPrices.add(result.getString("PRICE"));
            }
        }
        catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        priceFiltersPanel.setVisible(false);
        searchSubmitButton.setText("Search \ud83d\udd0d");
    }//GEN-LAST:event_formWindowOpened

    private void searchSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSubmitButtonActionPerformed
        SearchedIds = new ArrayList();
        SearchedCities = new ArrayList();
        SearchedCountries = new ArrayList();
        SearchedPrices = new ArrayList();
        String option = filterOption.getSelectedItem().toString();
        String filterValue = filterText.getText();
        if(option.equals("price")) {
            String filterPriceFromValue = "-1";
            String filterPriceToValue = "";
            if(!filterPriceFrom.getText().equals("")) {
                filterPriceFromValue = filterPriceFrom.getText();
                if(!isInteger(filterPriceFromValue)) {
                    JOptionPane.showMessageDialog(null, "Given value is not an integer");
                    return;
                }
            }
            if(!filterPriceTo.getText().equals("")) {
                filterPriceToValue = filterPriceTo.getText();
                if(!isInteger(filterPriceToValue)) {
                    JOptionPane.showMessageDialog(null, "Given value is not an integer");
                    return;
                }
            }
            searchEstates(option, filterValue, filterPriceFromValue, filterPriceToValue);
        }
        else {
            searchEstates(option, filterValue);
        }
        SearchEstateResultWindow resultWindow = new SearchEstateResultWindow(MyID);
        resultWindow.initProperties(SearchedIds, SearchedCities, SearchedCountries, SearchedPrices);
        resultWindow.setVisible(true);
        resultWindow.pack();
            
        
    }//GEN-LAST:event_searchSubmitButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new SearchEstatePanel("").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel filter;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JComboBox<String> filterOption;
    private javax.swing.JTextField filterPriceFrom;
    private javax.swing.JTextField filterPriceTo;
    private javax.swing.JTextField filterText;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel priceFiltersPanel;
    private javax.swing.JButton searchSubmitButton;
    // End of variables declaration//GEN-END:variables
}
