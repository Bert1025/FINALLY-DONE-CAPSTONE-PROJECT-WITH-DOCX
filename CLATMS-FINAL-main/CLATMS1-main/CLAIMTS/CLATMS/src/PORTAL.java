
import General.ConnectionProvider;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.Timer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PORTAL extends javax.swing.JFrame {
     private String POSITION;
     private String ID_NUMBER;
     private String FULL_NAME;
     private String TIME_IN;
     private String TIME_OUT;
     private String DATE;
     private String PC_NUMBER;
     private String SUBJECT;  
    private boolean idSet;
    private String UNI_CODE;
    private String FACULTY_USER;
    private String USERNAME;
    private boolean componentsInitialized = false;

   
    
    
    
    
     

    /**
     * Creates new form PORTAL
     */
    public PORTAL(String username) {
      if (!componentsInitialized) {
        initComponents();
        componentsInitialized = true; // Set the flag to true after initializing components
        dt();
        times();
        uni();
    }
    
    jLabel6.setText(username);
}
    public void dt() {
        // Use java.util.Date instead of Date() constructor
        java.util.Date d = new java.util.Date();

        // Use SimpleDateFormat with "yyyy-MM-dd" pattern
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Format the date and set it to the label
        String dd = sdf.format(d);
        jLabel12.setText(dd);
    }
    
     public void uni(){
         Random rn = new Random();
         uni_field.setText(Integer.toString(rn.nextInt(100000000)));
     }

    public void times() {
        Timer t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date dt = new Date(System.currentTimeMillis());
                SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss a");
                String tt = st.format(dt);
                jLabel13.setText(tt); // Assuming you have a label l_time to display the time
            }
        });

        t.start();

    }

    
    // ======================================================= Start Function =========================================================//
      public void showportal(){
         try {
            // Create the SQL query with placeholders
            String getQuery = "SELECT * FROM portal";


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
    
    // Process the result set as needed
    if (resultSet.next()) {
        this.POSITION = resultSet.getString("POSITION");
        this.ID_NUMBER = resultSet.getString("ID_NUMBER");
        this.TIME_IN = resultSet.getString("TIME_IN");
        this.TIME_OUT = resultSet.getString("TIME_OUT");
        this.DATE = resultSet.getString("DATE");
        this.PC_NUMBER = resultSet.getString("PC_NUMBER");
        this.SUBJECT = resultSet.getString("SUBJECT");
        this.UNI_CODE= resultSet.getString("UNI_CODE");
        this.FACULTY_USER= resultSet.getString("FACULTY_USER");
        

        // Display the retrieved data
        System.out.println("POSITION: " + this.POSITION);
        System.out.println("ID_NUMBER: " + this.ID_NUMBER);
        System.out.println("FULL_NAME: " + this.FULL_NAME);
        System.out.println("TIME_IN: " + this.TIME_IN);
        System.out.println("TIME_OUT: " + this.TIME_OUT);
        System.out.println("DATE: " + this.DATE);
        System.out.println("PC_NUMBER: " + this.PC_NUMBER);
        System.out.println("SUBJECT: " + this.SUBJECT);
        System.out.println("UNI_CODE: " + this.UNI_CODE);
        System.out.println("FACULTY_USER: " + this.FACULTY_USER);
       

        // Create a table model to store data
        DefaultTableModel tableModel = new DefaultTableModel();
        jTable1.setModel(tableModel);

        // Get column names and add them to the table model
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            if (columnName.equals("POSITION") || columnName.equals("ID_NUMBER") || columnName.equals("FULL_NAME") ||
                    columnName.equals("TIME_IN") || columnName.equals("TIME_OUT") || columnName.equals("DATE")
                    || columnName.equals("PC_NUMBER") || columnName.equals("SUBJECT")|| columnName.equals("UNI_CODE")|| columnName.equals("FACULTY_USER")) {
                tableModel.addColumn(columnName);
            }
        }

        
        // Add rows to the table model
        do {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }
            tableModel.addRow(rowData);
        } while (resultSet.next());

    } else {
        System.out.println("No matching records found.");
        JOptionPane.showMessageDialog(null, "No record found!");
    }

    // Close resources
    resultSet.close();
    statement.close();
    connection.close();

            System.out.println("Retrieved Successfully!");

        } catch (ClassNotFoundException | SQLException e) {
          JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
          e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // </editor-fold>
    //===========================================================================================//
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        position_combo_box = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        id_number_field = new javax.swing.JTextField();
        full_name_field = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        time_in_field = new javax.swing.JTextField();
        time_out_field = new javax.swing.JTextField();
        date_field = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        pc_field = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        subject_field = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        searchTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        uni_field = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 102));
        jLabel1.setText("AMS PORTAL");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("POSITION");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 87, -1, -1));

        position_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TEACHER", "FACULTY", "STUDENT" }));
        position_combo_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                position_combo_boxActionPerformed(evt);
            }
        });
        jPanel1.add(position_combo_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 84, 161, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID. NO.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 127, -1, -1));

        id_number_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_number_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(id_number_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 124, 161, -1));

        full_name_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                full_name_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(full_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 164, 161, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("FULLNAME");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 167, -1, -1));

        time_in_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                time_in_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(time_in_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 204, 161, -1));

        time_out_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                time_out_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(time_out_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 245, 161, -1));

        date_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(date_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 286, 161, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PC.NO.");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 330, -1, -1));

        pc_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pc_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(pc_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 327, 161, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("SUBJECT");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 367, -1, -1));

        subject_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(subject_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 367, 161, -1));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "POSITION", "ID. NO.", "FULLNAME", "TIME IN", "TIME OUT", "DATE", "PC NO.", "SUBJECT", "UNI_CODE", "IN CHARGE"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 470));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 52, 990, 469));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 229, -1));

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 229, -1));

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("RETURN TO LOGIN");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 530, 140, -1));

        jButton5.setBackground(new java.awt.Color(0, 102, 102));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("SEARCH");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 145, -1));

        jButton6.setBackground(new java.awt.Color(0, 102, 102));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("EXIT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 10, -1, -1));

        searchTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTFActionPerformed(evt);
            }
        });
        jPanel1.add(searchTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 200, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("DATE");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 530, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("TIME");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 530, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("0");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 530, 130, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("0");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 530, 110, -1));

        jButton7.setBackground(new java.awt.Color(0, 102, 102));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("TIME IN");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 204, 82, -1));

        jButton8.setBackground(new java.awt.Color(0, 102, 102));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("TIME OUT");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 245, -1, -1));

        jButton9.setBackground(new java.awt.Color(0, 102, 102));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("DATE");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 286, 83, -1));

        jButton10.setBackground(new java.awt.Color(0, 102, 102));
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("RESET");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 229, -1));

        uni_field.setBackground(new java.awt.Color(0, 102, 102));
        uni_field.setForeground(new java.awt.Color(0, 102, 102));
        uni_field.setBorder(null);
        uni_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uni_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(uni_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 170, 30));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 260, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("IN-CHARGE DUTY:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
                        
/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void intComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        position_combo_box = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        id_number_field = new javax.swing.JTextField();
        full_name_field = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        time_in_field = new javax.swing.JTextField();
        time_out_field = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        date_field = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        pc_field = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        subject_field = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        searchTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("PORTAL");

        jLabel2.setText("POSITION");

        position_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TEACHER", "FACULTY", "STUDENT" }));

        jLabel3.setText("ID. NO.");

        jLabel4.setText("FULLNAME");

        jButton7.setText("TIME IN");

        jButton8.setText("TIME OUT");

        jButton9.setText("DATE");

        jLabel8.setText("PC.NO.");

        jLabel9.setText("SUBJECT");

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "POSITION", "ID. NO.", "FULLNAME", "TIME IN", "TIME OUT", "DATE", "PC NO.", "SUBJECT"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, 600, 470));

        jButton1.setBackground(new java.awt.Color(0, 204, 51));
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 153, 0));
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 204, 255));
        jButton4.setText("BACK TO LOGIN");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(204, 102, 0));
        jButton5.setText("search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("EXIT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jButton7)
                                    .addComponent(jButton8)
                                    .addComponent(jButton9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(position_combo_box, 0, 161, Short.MAX_VALUE)
                                    .addComponent(id_number_field)
                                    .addComponent(full_name_field)
                                    .addComponent(time_in_field)
                                    .addComponent(time_out_field)
                                    .addComponent(date_field)
                                    .addComponent(pc_field)
                                    .addComponent(subject_field)))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton6)
                        .addGap(29, 29, 29))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
                )));
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(position_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(id_number_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(full_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7)
                            .addComponent(time_in_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8)
                            .addComponent(time_out_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9)
                            .addComponent(date_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(pc_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(subject_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(8, 8, 8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>                        
  
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here 
        // Validate ID number
    String idNumber = id_number_field.getText().trim();
    String idValidationPattern = "^\\d{1,}(-\\d+)*$";

    if (!idNumber.matches(idValidationPattern)) {
        // Invalid ID number format
        JOptionPane.showMessageDialog(this, "Invalid ID number format. Please enter a valid ID number.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Stop execution if the ID is invalid
    }
    // Validate FULL_NAME
    // Validate FULL_NAME
    String fullName = full_name_field.getText().trim();
    String nameValidationPattern = "^[a-zA-Z\\s.]+$";

    if (!fullName.matches(nameValidationPattern)) {
        // Invalid FULL_NAME format
        JOptionPane.showMessageDialog(this, "Invalid name format. Please enter a valid name.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Stop execution if the FULL_NAME is invalid
    }
     String timeIn = time_in_field.getText().trim(); // Get the input text and remove leading/trailing spaces
String timeOut = time_out_field.getText().trim(); // Get the time-out input text

// Define a regular expression pattern for the allowed format (12-hour clock with AM/PM)
String pattern = "^(0[1-9]|1[0-2]):[0-5][0-9]\\s(?:AM|PM)$";

// Check if the time-in input matches the pattern
if (timeIn.matches(pattern)) {
    // Parse the hours from the time-in input
    int hoursIn = Integer.parseInt(timeIn.split(":")[0]);

    // Check if the time-in is in the morning (AM) or afternoon/evening (PM)
    if ((hoursIn >= 1 && hoursIn <= 11) && timeIn.endsWith("?:AM|PM")) {
        // Invalid input for time-in (morning time with PM)
        System.out.println("Invalid time in: " + timeIn);
        JOptionPane.showMessageDialog(this, "Invalid time format for time in. Please enter a valid time in the 00:00 AM/PM format.", "Error", JOptionPane.ERROR_MESSAGE);
        time_in_field.setText(""); // Clear the time-in input field
        return;
    }
} else {
    // Invalid input for time-in
    System.out.println("Invalid input for time in: " + timeIn);
    JOptionPane.showMessageDialog(this, "Invalid time format for time in. Please enter a valid time in the 00:00 AM/PM format.", "Error", JOptionPane.ERROR_MESSAGE);
    time_in_field.setText(""); // Clear the time-in input field
    return;
}

// Check if the time-out input matches the pattern
if (timeOut.matches(pattern)) {
    // Parse the hours from the time-out input
    int hoursOut = Integer.parseInt(timeOut.split(":")[0]);

    // Check if the time-out is in the morning (AM) or afternoon/evening (PM)
    if ((hoursOut >= 1 && hoursOut <= 11) && timeOut.endsWith("?:AM|PM")) {
        // Invalid input for time-out (morning time with PM)
        System.out.println("Invalid time out: " + timeOut);
        JOptionPane.showMessageDialog(this, "Invalid time format for time out. Please enter a valid time in the 00:00 AM/PM format.", "Error", JOptionPane.ERROR_MESSAGE);
        time_out_field.setText(""); // Clear the time-out input field
    } else {
        // You can add further processing or leave it as is
    }
} else {
    // Invalid input for time-out
    System.out.println("Invalid input for time out: " + timeOut);
    JOptionPane.showMessageDialog(this, "Invalid time format for time out. Please enter a valid time in the 00:00 AM/PM format.", "Error", JOptionPane.ERROR_MESSAGE);
    time_out_field.setText(""); // Clear the time-out input field
}
    // Validate date
    String userEnteredDate = date_field.getText();
    if (!isValidDateFormat(userEnteredDate) || !isCurrentDate(userEnteredDate)) {
        JOptionPane.showMessageDialog(this, "Please enter the current date in the format yyyy-MM-dd", "Incorrect Date", JOptionPane.ERROR_MESSAGE);
        return;
    }
     
    // Validate PC_NUMBER
    String pcText = pc_field.getText().trim();
    if (!pcText.matches("^[0-9\\p{Punct}]+$")) {
        // Invalid input for PC_NUMBER
        JOptionPane.showMessageDialog(this, "Invalid input for PC_NUMBER. Please enter only numeric characters.", "Error", JOptionPane.ERROR_MESSAGE);
        pc_field.setText(""); // Clear the pc_field input field
        return;
    }

    // Validate SUBJECT
    String subjectText = subject_field.getText().trim();
    if (!subjectText.matches("^[a-zA-Z0-9\\p{Punct}\\s]+$")) {
        // Invalid input for PURPOSE
        JOptionPane.showMessageDialog(this, "Invalid input for SUBJECT. Please enter only letters and special characters.", "Error", JOptionPane.ERROR_MESSAGE);
        subject_field.setText(""); // Clear the purpose_field input field
        return;
    }
    String existingLabel6Text = jLabel6.getText();
          try {
    // Create the SQL query with placeholders
    String insertQuery = "INSERT INTO portal (POSITION, ID_NUMBER, FULL_NAME, TIME_IN, TIME_OUT, DATE, PC_NUMBER, SUBJECT, UNI_CODE, FACULTY_USER) VALUES (?, ?, ?, ?, ?, ?, ? , ?, ?, ?)";
    
    
    // Create a connection
    ConnectionProvider dbc = new ConnectionProvider();
    String jdbcDriver = dbc.getJdbcDriver();
    String dbConnectionURL = dbc.getDbConnectionURL();
    String dbUsername = dbc.getDbUsername();
    String dbPassword = dbc.getDbPassword();
    Class.forName(jdbcDriver);
    Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

    // Create the PreparedStatement
    PreparedStatement statement = connection.prepareStatement(insertQuery);

    // Assuming student_id_field represents a string student ID
    
    statement.setString(1, String.valueOf(position_combo_box.getSelectedItem()));
    statement.setString(2, id_number_field.getText());
    statement.setString(3, full_name_field.getText());
    statement.setString(4, time_in_field.getText());  // Corrected line
    statement.setString(5, time_out_field.getText());
    statement.setString(6, date_field.getText());
    statement.setString(7, pc_field.getText());
    statement.setString(8, subject_field.getText());
    statement.setString(9, uni_field.getText());
    statement.setString(10, jLabel6.getText());
    
   
    
    statement.executeUpdate();

    // Clear the input fields
    this.position_combo_box.setSelectedItem("FACULTY");
    this.id_number_field.setText("");
    this.full_name_field.setText("");
    this.time_in_field.setText("");
    this.time_out_field.setText("");
    this.date_field.setText("");
    this.pc_field.setText("");
    this.subject_field.setText("");
    
    jLabel6.setText(this.USERNAME);
     // Set the text of jLabel6 back to its original content
    jLabel6.setText(existingLabel6Text);
    
// Display a success message
            JOptionPane.showMessageDialog(null, "Added Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

    DefaultTableModel tableModel = new DefaultTableModel();
    jTable1.setModel(tableModel);
    
    showportal();
    System.out.println("Add Successfully!");

} catch (ClassNotFoundException | SQLException e) {
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
}     
           uni();
           
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         // TODO add your handling code here:
       DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();

    // Check if the table is editable, and show a message if not
    if (!isTableEditable(RecordTable)) {
        JOptionPane.showMessageDialog(this, "TABLE IS NOT EDITED", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

     int SelectedRows = jTable1.getSelectedRow();
    position_combo_box.setSelectedItem(RecordTable.getValueAt(SelectedRows, 0).toString());
    id_number_field.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
    full_name_field.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
    time_in_field.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
    time_out_field.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
    date_field.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
    pc_field.setText(RecordTable.getValueAt(SelectedRows, 6).toString());
    subject_field.setText(RecordTable.getValueAt(SelectedRows, 7).toString());
    uni_field.setText(RecordTable.getValueAt(SelectedRows, 8).toString());
    jLabel6.setText(RecordTable.getValueAt(SelectedRows, 9).toString());
}

// Function to check if the table is editable
private boolean isTableEditable(DefaultTableModel tableModel) {
    return tableModel.isCellEditable(0, 0); // Change the indices based on your requirements

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    try {
    // Create the SQL query for update
    String updateQuery = "UPDATE portal SET TIME_OUT=? WHERE ID_NUMBER=?";
    
    // Trim input to remove leading/trailing whitespaces
    String idNumber = id_number_field.getText().trim();

    // Create a connection
    ConnectionProvider dbc = new ConnectionProvider();
    String jdbcDriver = dbc.getJdbcDriver();
    String dbConnectionURL = dbc.getDbConnectionURL();
    String dbUsername = dbc.getDbUsername();
    String dbPassword = dbc.getDbPassword();
    
    Class.forName(jdbcDriver);
    Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

    // Use PreparedStatement
    try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
        preparedStatement.setString(1, time_out_field.getText());
        preparedStatement.setString(2, idNumber);

        // Execute the UPDATE query
        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            // Clear the input fields
            this.position_combo_box.setSelectedItem("FACULTY");
            this.id_number_field.setText("");
            this.full_name_field.setText("");
            this.time_in_field.setText("");
            this.date_field.setText("");
            this.pc_field.setText("");
            this.subject_field.setText("");
            this.uni_field.setText("");
            this.jLabel6.setText("");

            JOptionPane.showMessageDialog(this, "Record has been successfully updated");
        } else {
            JOptionPane.showMessageDialog(this, "No record found with the given ID_NUMBER.");
        }

        // Refresh the table with updated data
        DefaultTableModel tableModel = new DefaultTableModel();
        jTable1.setModel(tableModel);
        showportal();

        System.out.println("Update Successfully!");
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close the connection
        if (connection != null) {
            connection.close();
        }   
    }
} catch (ClassNotFoundException | SQLException e) {
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
}
         uni(); 
         
         
         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         // TODO add your handling code here:
            try {
    // Create the SQL query with placeholders
    String searchQuery = "SELECT * FROM portal WHERE ID_NUMBER LIKE ? OR POSITION LIKE ? OR TIME_IN LIKE ? OR TIME_OUT LIKE ? OR DATE LIKE ? OR PC_NUMBER LIKE ? OR SUBJECT LIKE ? OR UNI_CODE LIKE ? OR FACULTY_USER LIKE ?";
    
    // Create a connection
    ConnectionProvider dbc = new ConnectionProvider();
    String jdbcDriver = dbc.getJdbcDriver();
    String dbConnectionURL = dbc.getDbConnectionURL();
    String dbUsername = dbc.getDbUsername();
    String dbPassword = dbc.getDbPassword();
    Class.forName(jdbcDriver);
    Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);
    
    // Create the PreparedStatement
    PreparedStatement statement = connection.prepareStatement(searchQuery);
    
    // Set search parameters
    String searchKeyword = "%" + searchTF.getText() + "%";
    for (int i = 1; i <= 9; i++) {
        statement.setString(i, searchKeyword);
    }
    
    // Execute the query
    ResultSet resultSet = statement.executeQuery();
    
    // Process the result set as needed
    if (resultSet.next()) {
        this.POSITION = resultSet.getString("POSITION");
        this.FULL_NAME = resultSet.getString("FULL_NAME");
        this.TIME_IN = resultSet.getString("TIME_IN");
        this.TIME_OUT = resultSet.getString("TIME_OUT");
        this.DATE = resultSet.getString("DATE");
        this.PC_NUMBER = resultSet.getString("PC_NUMBER");
        this.SUBJECT = resultSet.getString("SUBJECT");
        this.UNI_CODE = resultSet.getString("UNI_CODE");
        this.ID_NUMBER = resultSet.getString("ID_NUMBER");
        this.USERNAME = resultSet.getString("FACULTY_USER");

        // Display the retrieved data
        System.out.println("POSITION: " + this.POSITION);
        System.out.println("FULL_NAME: " + this.FULL_NAME);
        System.out.println("TIME_IN: " + this.TIME_IN);
        System.out.println("TIME_OUT: " + this.TIME_OUT);
        System.out.println("DATE: " + this.DATE);
        System.out.println("PC_NUMBER: " + this.PC_NUMBER);
        System.out.println("SUBJECT: " + this.SUBJECT);
        System.out.println("UNI_CODE: " + this.UNI_CODE);
        System.out.println("ID_NUMBER: " + this.ID_NUMBER);
        System.out.println("FACULTY_USER: " + this.USERNAME);
        
        jLabel6.setText(this.USERNAME);
        
        // Create a table model to store data
        DefaultTableModel tableModel = new DefaultTableModel();
        jTable1.setModel(tableModel);

        // Get column names and add them to the table model
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            if (columnName.equals("POSITION") || columnName.equals("FULL_NAME") ||
                    columnName.equals("TIME_IN") || columnName.equals("TIME_OUT") || columnName.equals("DATE")
                    || columnName.equals("PC_NUMBER") || columnName.equals("SUBJECT")|| columnName.equals("UNI_CODE")|| columnName.equals("FACULTY_USER") || columnName.equals("ID_NUMBER")) {
                tableModel.addColumn(columnName);
            }
        }

        // Add rows to the table model
        do {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }
            tableModel.addRow(rowData);
        } while (resultSet.next());

    } else {
        System.out.println("No matching records found.");
        JOptionPane.showMessageDialog(null, "No record found!");
    }

    // Close resources
    resultSet.close();
    statement.close();
    connection.close();
} catch (ClassNotFoundException | SQLException e) {
    e.printStackTrace();
}

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:       
                 Login log = new Login();
                 log.setVisible(true);
                 log.pack();
                 log.setLocationRelativeTo(null);
                 this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void id_number_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_number_fieldActionPerformed
        // TODO add your handling code here:
      // TODO add your handling code here:
String input = id_number_field.getText().trim(); // Get the input text and remove leading/trailing spaces

// Define a regular expression pattern for the allowed format
String pattern =   "^\\d{1,}(-\\d+)*$";
// Check if the ID has been set
if (!idSet) {
    // If not set, check the validity of the input
    if (input.matches(pattern)) {
        System.out.println("Valid input: " + input);
        idSet = true; // Set the flag to true, indicating that ID has been set
        id_number_field.setEditable(false); // Make the field non-editable
    } else {
        System.out.println("Invalid input: " + input);
        JOptionPane.showMessageDialog(this, "Invalid ID format. Please enter a valid ID number in the specified format.", "Error", JOptionPane.ERROR_MESSAGE);
        id_number_field.setText(""); // Clear the input field
    }
} else {
    // If ID has already been set, show an error message
    System.out.println("Attempted to update ID: " + input);
    JOptionPane.showMessageDialog(this, "ID number cannot be updated.", "Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_id_number_fieldActionPerformed

    private void full_name_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_full_name_fieldActionPerformed
        // TODO add your handling code here:
    String fullName = full_name_field.getText().trim(); // Get the input text and remove leading/trailing spaces

// Define a regular expression pattern for the allowed format
String pattern = "^[a-zA-Z\\s.]+$";

// Check if the input matches the pattern
if (fullName.matches(pattern)) {
    // Valid input
    System.out.println("Valid input: " + fullName);
    // You can add further processing or leave it as is
} else {
    // Invalid input
    System.out.println("Invalid input: " + fullName);
    // Display an error message or handle it as per your requirements
    JOptionPane.showMessageDialog(this, "Invalid name format. Please enter a valid name.", "Error", JOptionPane.ERROR_MESSAGE);
    full_name_field.setText(""); // Clear the input field
}
    }//GEN-LAST:event_full_name_fieldActionPerformed

    private void pc_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pc_fieldActionPerformed
        // TODO add your handling code here:
          String inputText = pc_field.getText().trim();

    // Validate that the input contains only numeric characters
    if (!inputText.matches("^[0-9\\p{Punct}]+$")) {
        // Invalid input (contains non-numeric characters)
        JOptionPane.showMessageDialog(this, "Invalid input. Please enter only numeric characters.", "Error", JOptionPane.ERROR_MESSAGE);
        pc_field.setText(""); // Clear the input field
    } else {
        // Valid input (contains only numeric characters)
        // You can add further processing or leave it as is
    }
    }//GEN-LAST:event_pc_fieldActionPerformed

    private void subject_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_fieldActionPerformed
        // TODO add your handling code here:
        String inputText = subject_field.getText().trim();

    // Validate that the input contains only special characters and letters (no numbers)
    if (!inputText.matches("^[a-zA-Z0-9\\p{Punct}\\s]+$")) {
        // Invalid input (contains numbers or other characters)
        JOptionPane.showMessageDialog(this, "Invalid input. Please enter only letters and special characters.", "Error", JOptionPane.ERROR_MESSAGE);
        subject_field.setText(""); // Clear the input field
    } else {
        // Valid input (contains only letters and special characters)
        // You can add further processing or leave it as is
    }
    }//GEN-LAST:event_subject_fieldActionPerformed

    private void date_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date_fieldActionPerformed
  // Get the user-entered date from the text field
        String userEnteredDate = date_field.getText();

        // Validate the entered date format
        if (!isValidDateFormat(userEnteredDate)) {
            JOptionPane.showMessageDialog(this, "Please enter the date in the format yyyy-MM-dd",
                    "Invalid Date Format", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if the entered date is the current date
        if (!isCurrentDate(userEnteredDate)) {
            JOptionPane.showMessageDialog(this, "Please enter the current date",
                    "Incorrect Date", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // If the format and date are valid, you can proceed with your logic
        // Your code here...
    }

    private boolean isValidDateFormat(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean isCurrentDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        return currentDate.equals(date);
   
    }//GEN-LAST:event_date_fieldActionPerformed

    private void time_out_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_time_out_fieldActionPerformed
        String timeOut = time_out_field.getText().trim(); // Get the input text and remove leading/trailing spaces

        // Validate TIME_OUT only if a value is provided
        if (!timeOut.isEmpty()) {
            String timeValidationPattern = "^(0[1-9]|1[0-2]):[0-5][0-9]\\s(?:AM|PM)$";

            if (!timeOut.matches(timeValidationPattern)) {
                // Invalid TIME_OUT format
                JOptionPane.showMessageDialog(this, "Invalid time format. Please enter a valid time in the 00:00 AM/PM format.", "Error", JOptionPane.ERROR_MESSAGE);
                time_out_field.setText(""); // Clear the input field
                return; // Stop execution if the TIME_OUT is invalid
            }

            // Parse the hours from the TIME_OUT input
            int hoursOut = Integer.parseInt(timeOut.split(":")[0]);

            // Check if the TIME_OUT is in the morning (AM) or afternoon/evening (PM)
            if ((hoursOut >= 1 && hoursOut <= 11) && timeOut.endsWith("?:AM|PM")) {
                // Invalid input for TIME_OUT (morning time with PM)
                JOptionPane.showMessageDialog(this, "Invalid time format for TIME_OUT. Please enter a valid time in the 00:00 AM/PM format.", "Error", JOptionPane.ERROR_MESSAGE);
                time_out_field.setText(""); // Clear the input field
                return;
            } // Validate that TIME_OUT is after TIME_IN
            String timeIn = time_in_field.getText().trim();
            if (!isTimeAfter(timeIn, timeOut)) {
                // Invalid input
                JOptionPane.showMessageDialog(this, "Invalid time. TIME_IN should be ahead of TIME_OUT.", "Error", JOptionPane.ERROR_MESSAGE);
                time_out_field.setText(""); // Clear the input field
                return; // Stop execution if TIME_OUT is not ahead of TIME_IN
            }

        }

        // If the time_out_field is empty, set TIME_OUT to NULL or an appropriate default value
        String timeOutValue = timeOut.isEmpty() ? "NULL" : "?";
        }

        // Helper method to check if time1 is after time2
        private boolean isTimeAfter(String time1, String time2) {
            try {
                SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
                java.util.Date date1 = format.parse(time1);
                java.util.Date date2 = format.parse(time2);
                return date1.after(date2);
            } catch (ParseException e) {
                e.printStackTrace();
                return false;
            }
    }//GEN-LAST:event_time_out_fieldActionPerformed

    private void time_in_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_time_in_fieldActionPerformed
        String timeIn = time_in_field.getText().trim(); // Get the input text and remove leading/trailing spaces

        // Define a regular expression pattern for the allowed format (12-hour clock with AM/PM)
        String pattern = "^(0[1-9]|1[0-2]):[0-5][0-9]\\s(?:AM|PM)$";

        // Check if the input matches the pattern
        if (timeIn.matches(pattern)) {
            // Parse the hours from the TIME_IN input
            int hoursIn = Integer.parseInt(timeIn.split(":")[0]);

            // Check if the TIME_IN is in the morning (AM) or afternoon/evening (PM)
            if ((hoursIn >= 1 && hoursIn <= 11) && timeIn.endsWith("?:AM|PM")) {
                // Invalid input for TIME_IN (morning time with PM)
                System.out.println("Invalid input: " + timeIn);
                JOptionPane.showMessageDialog(this, "Invalid time format. Please enter a valid time in the 00:00 AM/PM format.", "Error", JOptionPane.ERROR_MESSAGE);
                time_in_field.setText(""); // Clear the input field
                return;
            }

            // You can add further processing or leave it as is
        } else {
            // Invalid input
            System.out.println("Invalid input: " + timeIn);
            // Display an error message or handle it as per your requirements
            JOptionPane.showMessageDialog(this, "Invalid time format. Please enter a valid time in the 00:00 AM/PM format.", "Error", JOptionPane.ERROR_MESSAGE);
            time_in_field.setText(""); // Clear the input field
        }
    }//GEN-LAST:event_time_in_fieldActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
         // Get the current time
    Date currentTime = new Date(System.currentTimeMillis());
SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
String formattedTime = timeFormat.format(currentTime);

// Set the formatted time to the time_in_field
time_in_field.setText(formattedTime);

// Add focus listener to time_in_field
time_in_field.addFocusListener(new java.awt.event.FocusAdapter() {
    private boolean errorShown = false;

    public void focusGained(java.awt.event.FocusEvent evt) {
        // Display an error message only if it hasn't been shown yet
        if (!errorShown) {
            JOptionPane.showMessageDialog(null, "Time In field is not editable", "Error", JOptionPane.ERROR_MESSAGE);
            errorShown = true;
        }

        // Reset the focus to the component you want (e.g., jButton7)
        jButton7.requestFocusInWindow();
    }
});
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Date currentTime = new Date(System.currentTimeMillis());
SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
String formattedTime = timeFormat.format(currentTime);

// Set the formatted time to the time_out_field
time_out_field.setText(formattedTime);

// Add focus listener to time_out_field
time_out_field.addFocusListener(new java.awt.event.FocusAdapter() {
    private boolean errorShown = false;

    public void focusGained(java.awt.event.FocusEvent evt) {
        // Display an error message only if it hasn't been shown yet
        if (!errorShown) {
            JOptionPane.showMessageDialog(null, "Time Out field is not editable", "Error", JOptionPane.ERROR_MESSAGE);
            errorShown = true;
        }

        // Reset the focus to the component you want (e.g., jButton8)
        jButton8.requestFocusInWindow();
    }
});
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
         // Get the current date and time
    Date currentDate = new Date(System.currentTimeMillis());
    
    // Format the date using SimpleDateFormat
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String formattedDate = dateFormat.format(currentDate);

    // Set the formatted date to the date_field
    date_field.setText(formattedDate);

    // Make the date_field not editable
    date_field.setEditable(false);
    date_field.setText(formattedDate);
// Set the formatted date to the date_field
date_field.setText(formattedDate);

// Make the date_field not editable
date_field.setEditable(false);

// Add focus listener to date_field
date_field.addFocusListener(new java.awt.event.FocusAdapter() {
    private boolean errorShown = false;

    public void focusGained(java.awt.event.FocusEvent evt) {
        // Display an error message only if it hasn't been shown yet
        if (!errorShown) {
            JOptionPane.showMessageDialog(null, "Date field is not editable", "Error", JOptionPane.ERROR_MESSAGE);
            errorShown = true;
        }
        
        // Reset the focus to jButton9
        jButton9.requestFocusInWindow();
    }
});
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        position_combo_box.setSelectedItem(""); 
        this.id_number_field.setText("");
        this.full_name_field.setText("");
        this.time_in_field.setText("");
        this.time_out_field.setText("");
        this.date_field.setText("");
        this.pc_field.setText("");
        this.subject_field.setText("");
        
        
        
        
         clearFields();
         
    
         uni();
  
    }//GEN-LAST:event_jButton10ActionPerformed

    private void uni_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uni_fieldActionPerformed
        // TODO add your handling code here:
        uni();
       
    }//GEN-LAST:event_uni_fieldActionPerformed

    private void searchTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTFActionPerformed

    private void position_combo_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_position_combo_boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_position_combo_boxActionPerformed


    private void clearFields() {
        // Clear editable text fields
        clearTextField(time_out_field);
        clearTextField(time_in_field);
        clearTextField(date_field);
        clearTextField(pc_field);
        clearTextField(full_name_field);
        clearTextField(id_number_field);
        clearTextField(subject_field);
       
        
    }

    private void clearTextField(JTextField textField) {
        // Check if the text field is editable before setting its text to an empty string
        if (textField.isEditable()) {
            textField.setText("");
        }
}
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
            java.util.logging.Logger.getLogger(PORTAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PORTAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PORTAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PORTAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField date_field;
    private javax.swing.JTextField full_name_field;
    private javax.swing.JTextField id_number_field;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField pc_field;
    private javax.swing.JComboBox<String> position_combo_box;
    private javax.swing.JTextField searchTF;
    private javax.swing.JTextField subject_field;
    private javax.swing.JTextField time_in_field;
    private javax.swing.JTextField time_out_field;
    private javax.swing.JTextField uni_field;
    // End of variables declaration//GEN-END:variables

    
}
