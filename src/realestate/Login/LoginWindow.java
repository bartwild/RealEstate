package realestate.Login;
import realestate.Register.*;
import realestate.Menu.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import siphash.SipHasher;
import java.sql.*;  

public class LoginWindow extends javax.swing.JFrame {
    public LoginWindow() {
        initComponents();
        ImagePlaceholder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login_photo.jpg")));
        IconLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login_icon.jpg")));
        IconPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password_icon.jpg")));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImagePlaceholder = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        IconLogin = new javax.swing.JLabel();
        IconPassword = new javax.swing.JLabel();
        PasswordPlaceholder = new javax.swing.JPasswordField();
        LoginPlaceholder = new javax.swing.JTextField();
        LoginButton = new javax.swing.JButton();
        RegisterButton = new javax.swing.JButton();
        ContinueToMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        ImagePlaceholder.setBackground(new java.awt.Color(51, 51, 255));
        ImagePlaceholder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImagePlaceholder.setOpaque(true);

        Title.setFont(new java.awt.Font("Ubuntu", 3, 60)); // NOI18N
        Title.setForeground(new java.awt.Color(51, 51, 255));
        Title.setText(" ToDom");

        PasswordPlaceholder.setForeground(new java.awt.Color(153, 153, 153));
        PasswordPlaceholder.setText("Password");
        PasswordPlaceholder.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PasswordPlaceholderFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PasswordPlaceholderFocusLost(evt);
            }
        });

        LoginPlaceholder.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        LoginPlaceholder.setForeground(new java.awt.Color(153, 153, 153));
        LoginPlaceholder.setText("Login");
        LoginPlaceholder.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                LoginPlaceholderFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                LoginPlaceholderFocusLost(evt);
            }
        });

        LoginButton.setFont(new java.awt.Font("Fira Sans", 0, 24)); // NOI18N
        LoginButton.setText("LOGIN");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        RegisterButton.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        RegisterButton.setForeground(new java.awt.Color(51, 51, 255));
        RegisterButton.setText("Don't have account? Register now !");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        ContinueToMenu.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        ContinueToMenu.setForeground(new java.awt.Color(51, 51, 255));
        ContinueToMenu.setText("Continue without logging in");
        ContinueToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinueToMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImagePlaceholder, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IconLogin)
                                    .addComponent(IconPassword))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LoginPlaceholder)
                                    .addComponent(PasswordPlaceholder)))
                            .addComponent(LoginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ContinueToMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(RegisterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IconLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LoginPlaceholder, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IconPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(PasswordPlaceholder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RegisterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContinueToMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(LoginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addContainerGap(116, Short.MAX_VALUE))
            .addComponent(ImagePlaceholder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        String username = LoginPlaceholder.getText();
        String password = String.valueOf(PasswordPlaceholder.getPassword());
        byte[] key = "password16bytess".getBytes();
        if(username.trim().toLowerCase().equals("username") ||
            username.trim().equals("") || password.trim().equals("") ||
                password.trim().toLowerCase().equals("password")){
            JOptionPane.showMessageDialog(null, "Enter your login and password first");
        }else{
            try (Connection connection = db_connection.OracleSqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM USERS WHERE LOGIN = ? AND PASSWORD = ?")) {
                statement.setString(1, username);
                statement.setString(2, SipHasher.toHexString(SipHasher.hash(key, password.getBytes())));
                ResultSet result = statement.executeQuery();
                if (result.next()){
                    JOptionPane.showMessageDialog(null, "LOGGED SUCCESSFULLY");
                    MenuWindow menuSite = new MenuWindow(result.getString(1));
                    menuSite.loadProperties();
                    menuSite.setVisible(true);
                    menuSite.pack();
                    this.dispose();
                }else {
                    JOptionPane.showMessageDialog(null, "WRONG LOGGING CREDENTIALS");
                }
            }catch(SQLException e){
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void LoginPlaceholderFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LoginPlaceholderFocusGained
        if(LoginPlaceholder.getText().trim().toLowerCase().equals("login")){
            LoginPlaceholder.setText("");
            LoginPlaceholder.setForeground(Color.black);
        }
    }//GEN-LAST:event_LoginPlaceholderFocusGained

    private void LoginPlaceholderFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LoginPlaceholderFocusLost
        if(LoginPlaceholder.getText().trim().equals("") ||
               LoginPlaceholder.getText().trim().toLowerCase().equals("login")){
            LoginPlaceholder.setText("Login");
            LoginPlaceholder.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_LoginPlaceholderFocusLost

    private void PasswordPlaceholderFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordPlaceholderFocusGained
        String password = String.valueOf(PasswordPlaceholder.getPassword());
        if (password.trim().toLowerCase().equals("password")){
            PasswordPlaceholder.setText("");
            PasswordPlaceholder.setForeground(Color.black);
        }
        
    }//GEN-LAST:event_PasswordPlaceholderFocusGained

    private void PasswordPlaceholderFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordPlaceholderFocusLost
        String password = String.valueOf(PasswordPlaceholder.getPassword());
        if (password.trim().toLowerCase().equals("password") ||
                password.trim().equals("")){
            PasswordPlaceholder.setText("Password");
            PasswordPlaceholder.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_PasswordPlaceholderFocusLost

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        RegisterWindow registerSite = new RegisterWindow();
        registerSite.setVisible(true);
        registerSite.pack();
        this.dispose();
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void ContinueToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinueToMenuActionPerformed
        MenuWindow Menu = new MenuWindow();
        Menu.loadProperties();
        Menu.setVisible(true);
        Menu.pack();
        this.dispose();
    }//GEN-LAST:event_ContinueToMenuActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new LoginWindow().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ContinueToMenu;
    private javax.swing.JLabel IconLogin;
    private javax.swing.JLabel IconPassword;
    private javax.swing.JLabel ImagePlaceholder;
    private javax.swing.JButton LoginButton;
    private javax.swing.JTextField LoginPlaceholder;
    private javax.swing.JPasswordField PasswordPlaceholder;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JLabel Title;
    // End of variables declaration//GEN-END:variables
}
