import General.ConnectionProvider;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        
    }
    
    
    
    // ===================================Start Function =========================================================//
        public void showLogin(){
     try {
            // Create the SQL query with placeholders
            String getQuery = "SELECT * FROM log_in";


            // Create a connection
            ConnectionProvider dbc = new ConnectionProvider();
            String jdbcDriver = dbc.getJdbcDriver();
            String dbConnectionURL = dbc.getDbConnectionURL();
            String dbUsername = dbc.getDbUsername();
            String dbPassword = dbc.getDbPassword();
            Class.forName(jdbcDriver);
            Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

            // Create the PreparedStatement
            PreparedStatement statement = connection.prepareStatement(getQuery);

            statement.executeQuery();
           ResultSet resultSet = statement.executeQuery();
           
            // Close resources
           resultSet.close();
           statement.close();
           connection.close();
           
           // Display a success message
            JOptionPane.showMessageDialog(null, "LOGIN Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

            System.out.println("Retrieved Successfully!");

        } catch (ClassNotFoundException | SQLException e) {
          JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
          e.printStackTrace();
        }
   };
    
    
    // ===================================End Function =========================================================//
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        username_field = new javax.swing.JTextField();
        password_field = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 153));
        jLabel2.setText("FACULTY USERNAME");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 153));
        jLabel3.setText("PASSWORD");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        username_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 160, 30));
        jPanel1.add(password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 160, 30));
        password_field.getAccessibleContext().setAccessibleName("");

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 98, 38));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Create an account?");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 153));
        jLabel5.setText("LOGIN");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("SIGN UP");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 153, 153));
        jLabel6.setText("\"Use this format for Working Student 0000-0000@LASTNAME\"");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 116, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 153, 153));
        jLabel7.setText("\"Use this format for Faculty Teacher 0000-00-00-000@LASTNAME\"");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 138, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void username_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_fieldActionPerformed
        // TODO add your handling code here:
         // Get the entered username
    String username = username_field.getText();

    // Define the expected pattern using regular expression
    String pattern = "\\d{4}-\\d{4}-\\d{2}@\\w+";

    // Check if the entered username matches the pattern
    if (username.matches(pattern)) {
        // Valid username format
        System.out.println("Username is in the correct format: " + username);
    } else {
        // Invalid username format
        System.err.println("Error: Invalid username format. Please use the format 1046-2020-22@FULLNAME");
        // You can also show a message dialog or set an error label to provide feedback to the user
    }
    }//GEN-LAST:event_username_fieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          // TODO add your handling code here:
     try {
        // Your existing code inside the try block
        String getQuery = "SELECT username, password FROM log_in WHERE username = ? AND password = ?";
        ConnectionProvider dbc = new ConnectionProvider();
        String jdbcDriver = dbc.getJdbcDriver();
        String dbConnectionURL = dbc.getDbConnectionURL();
        String dbUsername = dbc.getDbUsername();
        String dbPassword = dbc.getDbPassword();

        Class.forName(jdbcDriver);
        try (Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);
                PreparedStatement statement = connection.prepareStatement(getQuery)) {
            
            // Set values for the placeholders
            statement.setString(1, username_field.getText());
            statement.setString(2, new String(password_field.getPassword())); // Use getPassword for password fields
            
            try (ResultSet resultSet = statement.executeQuery()) {
                // Process the result set
                if (resultSet.next()) {
                    PORTAL portal = new PORTAL(username_field.getText());
                    portal.setVisible(true);
                    this.dispose();
                    JOptionPane.showMessageDialog(null, "LOGIN Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("User retrieved successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("User not found");
                }
            }
        }
    } catch (ClassNotFoundException | SQLException ex) {
        // Handle exceptions here
        ex.printStackTrace();
    }
 }
     private boolean isValidUsername(String username) {
    // Define the expected pattern using regular expression
    String pattern = "\\d{4}-\\d{4}-\\d{2}@\\w+";

    // Check if the entered username matches the pattern
    return username.matches(pattern);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
          // TODO add your handling code here:
        Register res = new Register();
        res.setVisible(true);
        res.pack();
        res.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JTextField username_field;
    // End of variables declaration//GEN-END:variables

    
   
}