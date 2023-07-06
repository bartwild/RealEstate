package realestate.ChangePassword;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import siphash.SipHasher;

public class ChangePassword extends javax.swing.JFrame {
    private final String MyID;
    private final byte[] key = "password16bytess".getBytes();
    /**
     * Creates new form ChangePassword
     * @param id
     */
    public ChangePassword(String id) {
        MyID = id;
        initComponents();
    }
    
    public boolean changePassword(String newPassword) {
        try(Connection connection = db_connection.OracleSqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement("UPDATE DBARTOS2.USERS SET PASSWORD = ? where USERID = ?")){
            statement.setString(1,SipHasher.toHexString(SipHasher.hash(key, newPassword.getBytes())));
            statement.setString(2, MyID);
            statement.executeUpdate();
            return true;
        }
        catch(SQLException e){
            System.out.println("ERROR: " + e.getMessage());
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        passwordPlaceholder = new javax.swing.JLabel();
        newPasswordPlaceholder = new javax.swing.JLabel();
        newPasswordPlaceholder2 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        newPasswordField = new javax.swing.JPasswordField();
        newPasswordField2 = new javax.swing.JPasswordField();
        isSureCheck = new javax.swing.JCheckBox();
        changeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        title.setFont(new java.awt.Font("Ubuntu", 3, 60)); // NOI18N
        title.setForeground(new java.awt.Color(255, 0, 0));
        title.setText("Change Password");

        passwordPlaceholder.setFont(new java.awt.Font("Ubuntu", 3, 14)); // NOI18N
        passwordPlaceholder.setForeground(new java.awt.Color(255, 0, 0));
        passwordPlaceholder.setText("Old Password");

        newPasswordPlaceholder.setFont(new java.awt.Font("Ubuntu", 3, 14)); // NOI18N
        newPasswordPlaceholder.setForeground(new java.awt.Color(255, 0, 0));
        newPasswordPlaceholder.setText("New Password");

        newPasswordPlaceholder2.setFont(new java.awt.Font("Ubuntu", 3, 14)); // NOI18N
        newPasswordPlaceholder2.setForeground(new java.awt.Color(255, 0, 0));
        newPasswordPlaceholder2.setText("Retype New Password");

        passwordField.setForeground(new java.awt.Color(153, 153, 153));
        passwordField.setText("Password");
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });

        newPasswordField.setForeground(new java.awt.Color(153, 153, 153));
        newPasswordField.setText("Password");
        newPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newPasswordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                newPasswordFieldFocusLost(evt);
            }
        });

        newPasswordField2.setForeground(new java.awt.Color(153, 153, 153));
        newPasswordField2.setText("Password");
        newPasswordField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newPasswordField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                newPasswordField2FocusLost(evt);
            }
        });

        isSureCheck.setFont(new java.awt.Font("Ubuntu", 3, 14)); // NOI18N
        isSureCheck.setForeground(new java.awt.Color(255, 0, 0));
        isSureCheck.setText("I'm sure I want to change my password");
        isSureCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isSureCheckActionPerformed(evt);
            }
        });

        changeButton.setFont(new java.awt.Font("Ubuntu", 3, 36)); // NOI18N
        changeButton.setForeground(new java.awt.Color(255, 0, 0));
        changeButton.setText("Change");
        changeButton.setEnabled(false);
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(changeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addGap(304, 304, 304))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(isSureCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(passwordPlaceholder, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newPasswordPlaceholder, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newPasswordPlaceholder2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordField)
                            .addComponent(newPasswordField)
                            .addComponent(newPasswordField2))))
                .addGap(144, 144, 144))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordPlaceholder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newPasswordField)
                    .addComponent(newPasswordPlaceholder, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newPasswordPlaceholder2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(newPasswordField2))
                .addGap(18, 18, 18)
                .addComponent(isSureCheck, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(changeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addGap(86, 86, 86))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        String password = String.valueOf(passwordField.getPassword());
        if (password.trim().toLowerCase().equals("password")){
            passwordField.setText("");
            passwordField.setForeground(Color.black);
        }
    }//GEN-LAST:event_passwordFieldFocusGained

    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
        String password = String.valueOf(passwordField.getPassword());
        if (password.trim().toLowerCase().equals("password") ||
            password.trim().equals("")){
            passwordField.setText("Password");
            passwordField.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_passwordFieldFocusLost

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        String password = String.valueOf(passwordField.getPassword());
        String newPassword = String.valueOf(newPasswordField.getPassword());
        String newPassword2 = String.valueOf(newPasswordField2.getPassword());
        String oldPass = "";
        try(Connection connection = db_connection.OracleSqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT PASSWORD FROM USERS WHERE USERID = ?");){
            statement.setString(1, MyID);
            ResultSet result = statement.executeQuery();
            if (result.next()){
                oldPass = result.getString(1);
            }
        }catch(SQLException e){
            System.out.println("ERROR: " + e.getMessage());
        }
        if(newPassword.trim().toLowerCase().equals("password") ||
                password.trim().toLowerCase().equals("password")||
                newPassword2.trim().toLowerCase().equals("password")){
            JOptionPane.showMessageDialog(null, "Fill all places first!");
        }
        else if(!oldPass.equals(SipHasher.toHexString(SipHasher.hash(key, password.getBytes())))){
            JOptionPane.showMessageDialog(null, "Password Incorrect!");
        }
        else if(newPassword.equals(password)){
            JOptionPane.showMessageDialog(null, "New password is the same as old!");
        }
        else if(!newPassword.equals(newPassword2)){
            JOptionPane.showMessageDialog(null, "New passwords must be the same!");
        }
        else if (!(isSureCheck.isSelected())){
            JOptionPane.showMessageDialog(null, "You must be sure about changing password!");
        }
        else {
            if(this.changePassword(newPassword)) {
                JOptionPane.showMessageDialog(null, "PASSWORD CHANGED SUCCESSFULLY");
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "UNEXPECTED ERROR OCCURRED");
            }
        }
    }//GEN-LAST:event_changeButtonActionPerformed

    private void newPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newPasswordFieldFocusGained
        String password = String.valueOf(newPasswordField.getPassword());
        if (password.trim().toLowerCase().equals("password")){
            newPasswordField.setText("");
            newPasswordField.setForeground(Color.black);
        }
    }//GEN-LAST:event_newPasswordFieldFocusGained

    private void newPasswordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newPasswordFieldFocusLost
        String password = String.valueOf(newPasswordField.getPassword());
        if (password.trim().toLowerCase().equals("password") ||
            password.trim().equals("")){
            newPasswordField.setText("Password");
            newPasswordField.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_newPasswordFieldFocusLost

    private void newPasswordField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newPasswordField2FocusGained
        String password = String.valueOf(newPasswordField2.getPassword());
        if (password.trim().toLowerCase().equals("password")){
            newPasswordField2.setText("");
            newPasswordField2.setForeground(Color.black);
        }
    }//GEN-LAST:event_newPasswordField2FocusGained

    private void newPasswordField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newPasswordField2FocusLost
        String password = String.valueOf(newPasswordField2.getPassword());
        if (password.trim().toLowerCase().equals("password") ||
            password.trim().equals("")){
            newPasswordField2.setText("Password");
            newPasswordField2.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_newPasswordField2FocusLost

    private void isSureCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isSureCheckActionPerformed
        if(isSureCheck.isSelected()) {
            changeButton.setEnabled(true);
        }
        else {
            changeButton.setEnabled(false);
        }
    }//GEN-LAST:event_isSureCheckActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ChangePassword("").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeButton;
    private javax.swing.JCheckBox isSureCheck;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JPasswordField newPasswordField2;
    private javax.swing.JLabel newPasswordPlaceholder;
    private javax.swing.JLabel newPasswordPlaceholder2;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordPlaceholder;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
