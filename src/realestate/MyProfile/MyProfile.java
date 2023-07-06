package realestate.MyProfile;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import realestate.ChangePassword.*;
import realestate.Menu.MenuWindow;
import realestate.DisplayProperties.MyPropertiesWindow;


public class MyProfile extends javax.swing.JFrame {
    String MyID = "";
    String Email = "";
    MenuWindow Menu;
    /**
     * Creates new form MyProfile
     * @param id
     * @param MenuWin
     */
    public MyProfile(String id, MenuWindow MenuWin) {
        MyID = id;
        getVariablesFromDb();
        initComponents();
        ID.setText(MyID);
        Mail.setText(Email);
        Menu = MenuWin;
    }
    
    private void getVariablesFromDb(){
        try(Connection connection = db_connection.OracleSqlConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT EMAIL FROM USERS WHERE USERID = ?")) {
            statement.setString(1, MyID);
                ResultSet result = statement.executeQuery();
                if (result.next()){
                    Email = result.getString(1);
                }
            }catch(SQLException e){
                System.out.println("ERROR: " + e.getMessage());
            }
    };
    
    public String getIDLabelValue() {
        return ID.getText();
    }
    
    public String getMailLabelValue() {
        return Mail.getText();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        IDPlaceholder = new javax.swing.JLabel();
        EmailPlaceholder = new javax.swing.JLabel();
        PasswordChange = new javax.swing.JButton();
        ID = new javax.swing.JLabel();
        Mail = new javax.swing.JLabel();
        MyProperties = new javax.swing.JButton();
        AccountDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        Title.setFont(new java.awt.Font("Ubuntu", 3, 60)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 0, 0));
        Title.setText(" MY PROFILE");

        IDPlaceholder.setFont(new java.awt.Font("Ubuntu", 3, 18)); // NOI18N
        IDPlaceholder.setForeground(new java.awt.Color(255, 0, 0));
        IDPlaceholder.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        IDPlaceholder.setText("ID:");

        EmailPlaceholder.setFont(new java.awt.Font("Ubuntu", 3, 18)); // NOI18N
        EmailPlaceholder.setForeground(new java.awt.Color(255, 0, 0));
        EmailPlaceholder.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        EmailPlaceholder.setText("Email:");

        PasswordChange.setFont(new java.awt.Font("Ubuntu", 3, 18)); // NOI18N
        PasswordChange.setForeground(new java.awt.Color(255, 0, 0));
        PasswordChange.setText("Change Password");
        PasswordChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordChangeActionPerformed(evt);
            }
        });

        ID.setFont(new java.awt.Font("Ubuntu", 3, 18)); // NOI18N
        ID.setText("PlaceholdingText");

        Mail.setFont(new java.awt.Font("Ubuntu", 3, 18)); // NOI18N
        Mail.setText("PlaceholdingText");

        MyProperties.setFont(new java.awt.Font("Ubuntu", 3, 18)); // NOI18N
        MyProperties.setForeground(new java.awt.Color(255, 0, 0));
        MyProperties.setText("My properties");
        MyProperties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MyPropertiesActionPerformed(evt);
            }
        });

        AccountDelete.setFont(new java.awt.Font("Ubuntu", 3, 18)); // NOI18N
        AccountDelete.setForeground(new java.awt.Color(255, 0, 0));
        AccountDelete.setText("DELETE ACCOUNT");
        AccountDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PasswordChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(572, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IDPlaceholder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EmailPlaceholder, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ID, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(Mail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(196, 196, 196))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(MyProperties, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(AccountDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 55, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IDPlaceholder, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EmailPlaceholder, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(Mail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(PasswordChange, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addComponent(AccountDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142)
                .addComponent(MyProperties, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PasswordChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordChangeActionPerformed
        ChangePassword changePassSite = new ChangePassword(MyID);
        changePassSite.setVisible(true);
    }//GEN-LAST:event_PasswordChangeActionPerformed

    private void MyPropertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MyPropertiesActionPerformed
        MyPropertiesWindow myPropertiesSite = new MyPropertiesWindow(MyID);
        myPropertiesSite.initProperties();
        myPropertiesSite.setVisible(true);
        myPropertiesSite.pack();
    }//GEN-LAST:event_MyPropertiesActionPerformed

    private void AccountDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountDeleteActionPerformed
        String[] options = {"No", "Yes"};
        int option = JOptionPane.showOptionDialog(null, "Are you sure you want to delete your account? ", "Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (option == 1){
            try(Connection connection = db_connection.OracleSqlConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM USERS WHERE USERID = ?")) {
            statement.setString(1, MyID);
                statement.executeUpdate();
            }catch(SQLException e){
                System.out.println("ERROR: " + e.getMessage());
            }
            JOptionPane.showMessageDialog(null,"Account deleted!");
            this.dispose();
            Menu.dispose();
            MenuWindow menuSite = new MenuWindow();
            menuSite.loadProperties();
            menuSite.setVisible(true);
            menuSite.pack();
        }
    }//GEN-LAST:event_AccountDeleteActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new MyProfile("ID", new MenuWindow()).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AccountDelete;
    private javax.swing.JLabel EmailPlaceholder;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel IDPlaceholder;
    private javax.swing.JLabel Mail;
    private javax.swing.JButton MyProperties;
    private javax.swing.JButton PasswordChange;
    private javax.swing.JLabel Title;
    // End of variables declaration//GEN-END:variables
}
