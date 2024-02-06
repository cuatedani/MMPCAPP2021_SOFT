package PROVEEDORES;

import SOFTWARE.ConectarBD;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfazEliminarProveedor extends javax.swing.JFrame {

    ConectarBD BD;
    Object[] Proveedor;

    public InterfazEliminarProveedor(ConectarBD con, Object[] fila) {
        initComponents();
        BD = con;
        Proveedor = fila;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        MostrarDatos();
    }
    
    public void MostrarDatos(){
        String nom = (String) Proveedor[1];
        String area = (String) Proveedor[2];
        String desc = (String) Proveedor[3];
        String tel = (String) Proveedor[4];
        String mail = (String) Proveedor[5];
        
        jtfNP.setText(nom);
        jtfAP.setText(area);
        jtfDP.setText(desc);
        jtfTP.setText(tel);
        jtfEP.setText(mail);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtfAP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtfDP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfEP = new javax.swing.JTextField();
        jtfNP = new javax.swing.JTextField();
        jtfTP = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(251, 229, 218));

        jtfAP.setEditable(false);
        jtfAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAPActionPerformed(evt);
            }
        });
        jtfAP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAPKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Buttershine", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(241, 172, 133));
        jLabel2.setText("Eliminar Proveedor");

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setText("NOMBRE: ");

        jLabel4.setText("AREA DE TRABAJO: ");

        jLabel5.setText("DESCRIPCIÓN:  ");

        jtfDP.setEditable(false);
        jtfDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDPActionPerformed(evt);
            }
        });
        jScrollPane3.setViewportView(jtfDP);

        jLabel7.setText("EMAIL: ");

        jLabel6.setText("TELÉFONO: ");

        jtfEP.setEditable(false);
        jtfEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEPActionPerformed(evt);
            }
        });

        jtfNP.setEditable(false);
        jtfNP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNPActionPerformed(evt);
            }
        });

        jtfTP.setEditable(false);
        jtfTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTPActionPerformed(evt);
            }
        });
        jtfTP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTPKeyTyped(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfNP)
                                .addComponent(jtfAP)
                                .addComponent(jtfEP, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtfTP, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(101, 101, 101)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtfNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jtfAP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
            int id = (int) Proveedor[0];
            BD.EliminarProveedor(id);
            this.setVisible(false);
            InterfazGestionarProveedores GestionProveedor = new InterfazGestionarProveedores(BD);
            GestionProveedor.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int opc = JOptionPane.showConfirmDialog(null, "¿Desea volver a la gestión de proveedores?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (opc == 0) {
            this.setVisible(false);
            InterfazGestionarProveedores GestionProveedor = new InterfazGestionarProveedores(BD);
            GestionProveedor.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtfNPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNPActionPerformed

    private void jtfTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTPActionPerformed

    private void jtfTPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTPKeyTyped
        int key = evt.getKeyChar();

        boolean n = key >= 48 && key <= 57;

        if (!n)
            evt.consume();
    }//GEN-LAST:event_jtfTPKeyTyped

    private void jtfEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfEPActionPerformed

    private void jtfDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDPActionPerformed

    private void jtfAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAPActionPerformed

    private void jtfAPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAPKeyTyped

    }//GEN-LAST:event_jtfAPKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jtfAP;
    private javax.swing.JTextField jtfDP;
    private javax.swing.JTextField jtfEP;
    private javax.swing.JTextField jtfNP;
    private javax.swing.JTextField jtfTP;
    // End of variables declaration//GEN-END:variables
}
