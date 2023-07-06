package realestate.Register;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import realestate.Login.LoginWindow;
import siphash.SipHasher;


public class RegisterWindow extends javax.swing.JFrame {
    public RegisterWindow() {
        initComponents();
        ImagePlaceholder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/register_photo.jpg")));
        Mail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mail.jpg")));
        Login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/register_user_icon.jpg")));
        Password1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/register_password_icon.jpg")));
        Password2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/register_password_icon.jpg")));
    }
    
    public boolean insertUserToDatabase(String login, String password, String email) {
        byte[] key = "password16bytess".getBytes();
        try (Connection connection = db_connection.OracleSqlConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO USERS(LOGIN, PASSWORD, EMAIL) VALUES (?, ?, ?)")) {
            statement.setString(1, login);
            statement.setString(2, SipHasher.toHexString(SipHasher.hash(key, password.getBytes())));
            statement.setString(3, email);
            statement.executeUpdate();
            return true;
        }
        catch(SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            return false;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImagePlaceholder = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        Login = new javax.swing.JLabel();
        Mail = new javax.swing.JLabel();
        Password1 = new javax.swing.JLabel();
        Password2 = new javax.swing.JLabel();
        EmailField = new javax.swing.JTextField();
        LoginField = new javax.swing.JTextField();
        PasswordField1 = new javax.swing.JPasswordField();
        PasswordField2 = new javax.swing.JPasswordField();
        RODO = new javax.swing.JCheckBox();
        Regulations = new javax.swing.JCheckBox();
        Register = new javax.swing.JButton();
        LoginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        ImagePlaceholder.setBackground(new java.awt.Color(204, 255, 204));
        ImagePlaceholder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImagePlaceholder.setToolTipText("");
        ImagePlaceholder.setOpaque(true);

        Title.setFont(new java.awt.Font("Ubuntu", 3, 60)); // NOI18N
        Title.setForeground(new java.awt.Color(102, 255, 102));
        Title.setText("Register");

        EmailField.setForeground(new java.awt.Color(153, 153, 153));
        EmailField.setText("Email");
        EmailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmailFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmailFieldFocusLost(evt);
            }
        });

        LoginField.setForeground(new java.awt.Color(153, 153, 153));
        LoginField.setText("Login");
        LoginField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                LoginFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                LoginFieldFocusLost(evt);
            }
        });

        PasswordField1.setForeground(new java.awt.Color(153, 153, 153));
        PasswordField1.setText("Password");
        PasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PasswordField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PasswordField1FocusLost(evt);
            }
        });

        PasswordField2.setForeground(new java.awt.Color(153, 153, 153));
        PasswordField2.setText("Password");
        PasswordField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PasswordField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PasswordField2FocusLost(evt);
            }
        });

        RODO.setText("I consent to the processing personal data");

        Regulations.setText("I have read the regulations and accept them");

        Register.setFont(new java.awt.Font("Fira Sans", 0, 24)); // NOI18N
        Register.setText("Register");
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });

        LoginButton.setFont(new java.awt.Font("Fira Sans", 1, 13)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(51, 51, 255));
        LoginButton.setText("Already Registered? Go to the login page");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ImagePlaceholder, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Login)
                    .addComponent(Mail)
                    .addComponent(Password1)
                    .addComponent(Password2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Regulations, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                            .addComponent(RODO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PasswordField2, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                            .addComponent(PasswordField1)
                            .addComponent(EmailField, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                            .addComponent(LoginField, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                            .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LoginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                            .addComponent(Register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ImagePlaceholder, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EmailField)
                    .addComponent(Mail, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LoginField, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PasswordField1)
                    .addComponent(Password1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Password2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(PasswordField2))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(RODO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Regulations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Register, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LoginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmailFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailFieldFocusGained
        if(EmailField.getText().trim().toLowerCase().equals("email")){
            EmailField.setText("");
            EmailField.setForeground(Color.black);
        }
    }//GEN-LAST:event_EmailFieldFocusGained

    private void EmailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailFieldFocusLost
        if(EmailField.getText().trim().equals("") ||
               EmailField.getText().trim().toLowerCase().equals("email")){
            EmailField.setText("Email");
            EmailField.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_EmailFieldFocusLost

    private void LoginFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LoginFieldFocusGained
        if(LoginField.getText().trim().toLowerCase().equals("login")){
            LoginField.setText("");
            LoginField.setForeground(Color.black);
        }
    }//GEN-LAST:event_LoginFieldFocusGained

    private void LoginFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LoginFieldFocusLost
        if(LoginField.getText().trim().equals("") ||
               LoginField.getText().trim().toLowerCase().equals("login")){
            LoginField.setText("Login");
            LoginField.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_LoginFieldFocusLost

    private void PasswordField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordField1FocusGained
        String password = String.valueOf(PasswordField1.getPassword());
        if (password.trim().toLowerCase().equals("password")){
            PasswordField1.setText("");
            PasswordField1.setForeground(Color.black);
        }
    }//GEN-LAST:event_PasswordField1FocusGained

    private void PasswordField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordField1FocusLost
        String password = String.valueOf(PasswordField1.getPassword());
        if (password.trim().toLowerCase().equals("password") ||
                password.trim().equals("")){
            PasswordField1.setText("Password");
            PasswordField1.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_PasswordField1FocusLost

    private void PasswordField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordField2FocusGained
        String password = String.valueOf(PasswordField2.getPassword());
        if (password.trim().toLowerCase().equals("password")){
            PasswordField2.setText("");
            PasswordField2.setForeground(Color.black);
        }
    }//GEN-LAST:event_PasswordField2FocusGained

    private void PasswordField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordField2FocusLost
        String password = String.valueOf(PasswordField2.getPassword());
        if (password.trim().toLowerCase().equals("password") ||
                password.trim().equals("")){
            PasswordField2.setText("Password");
            PasswordField2.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_PasswordField2FocusLost

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
        String password1 = String.valueOf(PasswordField1.getPassword());
        String password2 = String.valueOf(PasswordField2.getPassword());
        String email = String.valueOf(EmailField.getText());
        String login = String.valueOf(LoginField.getText());
        if(login.trim().toLowerCase().equals("username") ||
            login.trim().equals("") || password1.trim().equals("") ||
                password1.trim().toLowerCase().equals("password") ||
                password2.trim().equals("") ||
                password2.trim().toLowerCase().equals("password")||
                email.trim().toLowerCase().equals("email") ||
            email.trim().equals("")){
            JOptionPane.showMessageDialog(null, "Enter all the data first");
        }
        else if (!password1.equals(password2)){
            JOptionPane.showMessageDialog(null, "Passwords must be the same!");
        }
        else if (!(RODO.isSelected() && Regulations.isSelected())){
            JOptionPane.showMessageDialog(null, "Without contentions and regulations read you can't use our program.");
        } else {
            try (Connection connection = db_connection.OracleSqlConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM USERS WHERE LOGIN = ?");
                PreparedStatement statement2 = connection.prepareStatement("SELECT * FROM USERS WHERE EMAIL = ?")){
                statement.setString(1, login);
                ResultSet result = statement.executeQuery();
                statement2.setString(1, email);
                ResultSet result2 = statement2.executeQuery();
                if (result.next()){
                    JOptionPane.showMessageDialog(null, "LOGIN IS ALREADY USED");
                }else if (result2.next()) {
                    JOptionPane.showMessageDialog(null, "EMAIL IS ALREADY USED");
                }else {
                    if(this.insertUserToDatabase(login, password1, email)) {
                        JOptionPane.showMessageDialog(null, "Registered successfully!");
                        LoginWindow loginSite = new LoginWindow();
                        loginSite.setVisible(true);
                        loginSite.pack();
                        this.dispose();
                    }
                }
            }catch(SQLException e){
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_RegisterActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        LoginWindow loginSite = new LoginWindow();
        loginSite.setVisible(true);
        loginSite.pack();
        this.dispose();
    }//GEN-LAST:event_LoginButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new RegisterWindow().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EmailField;
    private javax.swing.JLabel ImagePlaceholder;
    private javax.swing.JLabel Login;
    private javax.swing.JButton LoginButton;
    private javax.swing.JTextField LoginField;
    private javax.swing.JLabel Mail;
    private javax.swing.JLabel Password1;
    private javax.swing.JLabel Password2;
    private javax.swing.JPasswordField PasswordField1;
    private javax.swing.JPasswordField PasswordField2;
    private javax.swing.JCheckBox RODO;
    private javax.swing.JButton Register;
    private javax.swing.JCheckBox Regulations;
    private javax.swing.JLabel Title;
    // End of variables declaration//GEN-END:variables
}
