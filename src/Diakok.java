
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;
import java.sql.DriverManager;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Diakok extends javax.swing.JFrame {

    public Diakok() {
        initComponents();
        Tablatolt(tabla);
        varosFeltolt(varosok);
        tabla.setAutoCreateRowSorter(true);

        tabla.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    try {
                        int c = tabla.getSelectedRow();
                        int g = tabla.getSelectedColumn();
                        String n = (tabla.getValueAt(c, g)).toString();
                        String a = diaksz.getText();
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/diakok", "root", "");
                        Statement smt = con.createStatement();
                        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                        int sstam = tabla.getSelectedRow();
                        System.out.println(sstam);
                        int ertek = Integer.parseInt(String.valueOf(tabla.getValueAt(sstam, 1)));
                        smt.executeUpdate("UPDATE diak SET név='" + n + "' WHERE diaksz = '" + a + "'");
                        Tablatorol(tabla);
                        Tablatolt(tabla);
                        ForName.setText(n);
                        con.close();

                    } catch (Exception b) {
                        System.out.println(b);
                    }
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        scrollPane1 = new java.awt.ScrollPane();
        list1 = new java.awt.List();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jFileChooser1 = new javax.swing.JFileChooser();
        jSpinField1 = new com.toedter.components.JSpinField();
        jLabel1 = new javax.swing.JLabel();
        ForName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        anyu = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        diaksz = new javax.swing.JTextField();
        lak = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        varosok = new javax.swing.JComboBox<>();
        szül = new com.toedter.calendar.JDateChooser();
        button1 = new java.awt.Button();
        label1 = new java.awt.Label();
        varos = new javax.swing.JTextField();
        visz = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList2);

        jTextField1.setText("jTextField1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 51));

        jLabel1.setText("DIAKOK");

        ForName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Név");

        jLabel3.setText("Diáksz");

        jLabel4.setText("Anyuka");

        jLabel5.setText("Email");

        jLabel6.setText("Lakcim");

        jLabel7.setText("Születés");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Név", "Diáksz", "Anyuka", "Email", "Lakcim", "Születés", "Város"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        tabla.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tablaInputMethodTextChanged(evt);
            }
        });
        tabla.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tablaPropertyChange(evt);
            }
        });
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        jButton1.setText("Felvitel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Törles");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Város");

        varosok.setEditable(true);

        button1.setLabel("keres");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        label1.setText("Város");

        visz.setText("VISZAJELZÉS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)
                                    .addComponent(visz))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(diaksz, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ForName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(anyu, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(email)
                                    .addComponent(lak)
                                    .addComponent(varosok, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(szül, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(130, 130, 130)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(varos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(varos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ForName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(diaksz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(anyu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(szül, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(varosok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(visz)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ForNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ForNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int id = 1;
        String n = ForName.getText();
        //int a = Integer.parseInt(diaksz.getText());
        String b = anyu.getText();
        String t = email.getText();
        String d = lak.getText();
        //String f = DateFormat.getDateInstance().format(szül.getDate());
        //String f = szül.getDateFormatString();
        int v = varosok.getSelectedIndex() + 1;
        SimpleDateFormat formatum;
        String su;
        try {
            formatum = new SimpleDateFormat("yyyy-MM-dd");
            su = formatum.format(szül.getDate());
        } catch (Exception e) {
            su = "";
            visz.setText("Rosz dátumformátum");

        }
        String di = diaksz.getText();
        long disz = 0;
        boolean diakoke = true;
        try {
            disz = Long.parseLong(di);
        } catch (Exception e) {
            diakoke = false;
            System.out.println("nem okes");
        }
        String[] inputok = {ForName.getText(), diaksz.getText(), anyu.getText(), email.getText(), lak.getText()};
        boolean urese = false;
        for (int i = 0; i < inputok.length; i++) {
            if (inputok[i].equals("")) {
                urese = true;
            }
        }
        if (urese) {
            visz.setText("Van üres mező");
        } else if (!diakoke) {
            visz.setText("A diakok. száma ne szöveg legyen");
        } else if (di.length() < 11 || di.length() > 11) {
            visz.setText("A diakok. száma pontosan 11 számjegyü legyen");
        } else if (!t.contains("@")) {
            visz.setText("Az email cím formátuma helytelen");
        } else {

            //asd
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/diakok", "root", "");
                Statement smt = con.createStatement();
                smt.executeUpdate("INSERT INTO diak(név, diaksz, Anyuka, email, Lakcim, születés,varosid) VALUES('" + n + "','" + di + "','" + b + "','" + t + "','" + d + "','" + su + "','" + v + "')");
                //ResultSet rs=smt.executeQuery("select * from diak");  
                /*while(rs.next())  
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  */

                ForName.setText("");
                diaksz.setText("");
                anyu.setText("");
                email.setText("");
                lak.setText("");
                // szül.setText("");
                varosok.setSelectedIndex(0);
                /*DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            int sorszam= model.getRowCount();
            for (int i=0;i<sorszam;i++){
                model.removeRow(0);
            }
            
            
            
            ResultSet rs = smt.executeQuery("SELECT `név`,`diaksz`,`Anyuka`,`email`,`Lakcim`,`születés` FROM `diak`");
            String[] mezon = {"név","diaksz","Anyuka","email","Lakcim","Lakcim"};
            String[] rekord = new String[6];
            while(rs.next())
            {
                for(int i=0;i<mezon.length;i++){
                    rekord[i]=rs.getString(mezon[i]);
                    
                }
                model.addRow(rekord);
            }
            con.close();
           
        }*/
                Tablatorol(tabla);
                Tablatolt(tabla);
                visz.setText("Sikeres adatbevitel!");

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String n = ForName.getText();
        int a = Integer.parseInt(diaksz.getText());
        String b = anyu.getText();
        String t = email.getText();
        String d = lak.getText();
        String f = DateFormat.getDateInstance().format(szül.getDate());
        System.out.println(f);
        int v = varosok.getSelectedIndex() + 1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/diakok", "root", "");
            Statement smt = con.createStatement();
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            int sstam = tabla.getSelectedRow();
            System.out.println(sstam);
            int ertek = Integer.parseInt(String.valueOf(tabla.getValueAt(sstam, 1)));
            smt.executeUpdate("DELETE FROM diak WHERE diaksz = '" + ertek + "'");
            Tablatorol(tabla);
            Tablatolt(tabla);
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tablaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tablaPropertyChange

    }//GEN-LAST:event_tablaPropertyChange

    private void tablaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tablaInputMethodTextChanged

    }//GEN-LAST:event_tablaInputMethodTextChanged

    private void tablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyPressed

    }//GEN-LAST:event_tablaKeyPressed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/diakok", "root", "");
            Statement smt = con.createStatement();
            ResultSet result = smt.executeQuery("SELECT * FROM diak INNER JOIN varos ON diak.varosid = varos.vid WHERE diaksz = '" + tabla.getValueAt(tabla.getSelectedRow(), 1) + "'");
            result.next();

            ForName.setText(result.getString("név"));
            diaksz.setText(result.getString("diaksz"));
            anyu.setText(result.getString("Anyuka"));
            email.setText(result.getString("email"));
            lak.setText(result.getString("Lakcim"));
            szül.setDate(result.getDate("születés"));
            varosok.setSelectedItem(result.getString("vnev"));
        } catch (Exception e) {
            System.out.println(e);
        }

        /*LocalDate localDate = LocalDate.now();
        Date datum = null;
        datum= Date.valueOf(localDate);
        szül.setDate(datum);*/

    }//GEN-LAST:event_tablaMouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        Tablatorol(tabla);
        String varoska = varos.getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/diakok", "root", "");
            Statement smt = con.createStatement();
            ResultSet result = smt.executeQuery("SELECT * FROM diak INNER JOIN varos ON diak.varosid = varos.vid ");
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            String[] mezon = {"név", "diaksz", "Anyuka", "email", "Lakcim", "születés", "vnev"};
            String[] rekord = new String[7];
            while (result.next()) {
                if (varoska.equals(result.getString("vnev"))) {
                    for (int i = 0; i < mezon.length; i++) {
                        rekord[i] = result.getString(mezon[i]);
                    }
                    model.addRow(rekord);
                } else {
                    System.out.println("valami rosz");
                }
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_button1ActionPerformed
    //tabla.addPropertyChangeListener("state", new PropertyChangeListener()) {

    public static void Tablatorol(JTable JTable) {
        DefaultTableModel model = (DefaultTableModel) JTable.getModel();
        int sorszam = model.getRowCount();
        for (int i = 0; i < sorszam; i++) {
            model.removeRow(0);
        }
    }

    public static void varosFeltolt(JComboBox belist) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/diakok", "root", "");
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("SELECT `vnev` FROM varos ORDER BY vnev");
            ArrayList<String> vok = new ArrayList<String>();
            while (rs.next()) {
                vok.add(rs.getString("vnev"));
            }
            con.close();
            for (int i = 0; i < vok.size(); i++) {
                belist.addItem(vok.get(i));
            }
            belist.setSelectedItem("Tatabánya");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Tablatolt(JTable JTable) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/diakok", "root", "");
            Statement smt = con.createStatement();
            DefaultTableModel model = (DefaultTableModel) JTable.getModel();
            ResultSet rs = smt.executeQuery("SELECT `név`,`diaksz`,`Anyuka`,`email`,`Lakcim`,`születés`,`vnev` FROM `diak` INNER JOIN varos ON diak.varosid = varos.vid");
            String[] mezon = {"név", "diaksz", "Anyuka", "email", "Lakcim", "születés", "vnev"};
            String[] rekord = new String[7];
            while (rs.next()) {
                for (int i = 0; i < mezon.length; i++) {
                    rekord[i] = rs.getString(mezon[i]);

                }
                model.addRow(rekord);
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Diakok().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ForName;
    private javax.swing.JTextField anyu;
    private java.awt.Button button1;
    private javax.swing.JTextField diaksz;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private com.toedter.components.JSpinField jSpinField1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    private javax.swing.JTextField lak;
    private java.awt.List list1;
    private java.awt.ScrollPane scrollPane1;
    private com.toedter.calendar.JDateChooser szül;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField varos;
    private javax.swing.JComboBox<String> varosok;
    private javax.swing.JLabel visz;
    // End of variables declaration//GEN-END:variables
}
