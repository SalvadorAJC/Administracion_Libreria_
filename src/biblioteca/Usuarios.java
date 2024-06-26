/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Ghost
 */
public class Usuarios extends javax.swing.JFrame {
private Connection conexion;
String sql = "";
Statement st;
    /**
     * Creates new form Clientes
     */
    public Usuarios() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void conection(){
        try{            
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Biblioteca;integratedSecurity=true;");
        JOptionPane.showMessageDialog(null,"Conectado");            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"No Conectado");
        }
    }
    public void consulta(){
        DefaultTableModel tabla = (DefaultTableModel) tabla1.getModel();
        tabla.addColumn("Nombre");
        tabla.addColumn("id");
        tabla.addColumn("Estado");

       String instruccion = "select*from usuario";
       tabla.setRowCount(0);
        try {            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Biblioteca;integratedSecurity=true;");
            System.out.println("Conectado");          
            Statement stmt = conexion.createStatement();
            stmt.executeQuery(instruccion);
            ResultSet rs = stmt.getResultSet();
            if (rs != null) {
                while (rs.next()) {
                  Vector v = new Vector();
                  v.add(rs.getString(1));
                  v.add(rs.getString(2));
                  v.add(rs.getString(3));         
                  tabla.addRow(v);
                }
            }
        } catch (Exception ex) {         
        } 
    }
    
    public void registro()
    {
        String instruction;
        try{
            conection();
            instruction = "insert into usuario values(?,?,?)";
            PreparedStatement s = conexion.prepareStatement(instruction);
            s.setString(1, nombre.getText());
            s.setString(2, id.getText());
            s.setString(3, estado.getText());
            s.executeUpdate();            
            JOptionPane.showMessageDialog(null,"Registro Guardado");
            nombre.setText("");
            id.setText("");
            estado.setText("");            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        estado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        modificar = new javax.swing.JButton();
        consulta = new javax.swing.JButton();
        agregar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        limpiar8 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, 520, 107));
        getContentPane().add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 1, 60, -1));

        jLabel3.setText("Estado");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 4, -1, -1));

        jLabel2.setText("ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 4, -1, -1));

        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, -1, -1));

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 1, 60, -1));
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 1, 60, -1));

        modificar.setText("Actualizar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        getContentPane().add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 29, -1, -1));

        consulta.setText("Consulta");
        consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaActionPerformed(evt);
            }
        });
        getContentPane().add(consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 29, -1, -1));

        agregar.setText("Insertar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        getContentPane().add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 29, -1, -1));

        jLabel4.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jLabel4.setText("Registro de Usuarios");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 58, -1, 19));

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 0, -1, -1));

        limpiar8.setText("Limpiar Tabla");
        limpiar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar8ActionPerformed(evt);
            }
        });
        getContentPane().add(limpiar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 29, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Registro Usuarios.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked
        // TODO add your handling code here:
        nombre.setText(tabla1.getValueAt(tabla1.getSelectedRow(),0).toString());
        id.setText(tabla1.getValueAt(tabla1.getSelectedRow(),1).toString());
        estado.setText(tabla1.getValueAt(tabla1.getSelectedRow(),2).toString());
    }//GEN-LAST:event_tabla1MouseClicked

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        String instruccion;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Biblioteca;integratedSecurity=true;");
            JOptionPane.showMessageDialog(null, "Conectado");

            instruccion = "{call modificarUs(?,?,?)}";
            PreparedStatement s = conexion.prepareStatement(instruccion);
            s.setString(1, nombre.getText());
            s.setString(2, id.getText());
            s.setString(3, estado.getText());

            s.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro modificado");
            nombre.setText("");
            id.setText("");
            estado.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "NO Conectado " + ex);
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaActionPerformed
        // TODO add your handling code here:
        consulta();
    }//GEN-LAST:event_consultaActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        // TODO add your handling code here:
        registro();
    }//GEN-LAST:event_agregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MenuSeleccion M =new MenuSeleccion();
        this.setVisible(false);
        M.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void limpiar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar8ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tabla2 = (DefaultTableModel) tabla1.getModel();
        for(int i=0;i<tabla2.getRowCount();i++){
            tabla2.removeRow(i);
            tabla2.setColumnCount(0);
        }
    }//GEN-LAST:event_limpiar8ActionPerformed

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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton consulta;
    private javax.swing.JTextField estado;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar8;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nombre;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
