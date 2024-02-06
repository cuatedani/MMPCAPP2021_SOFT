package PROVEEDORES;

import SOFTWARE.ConectarBD;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfazModificarProveedor extends javax.swing.JFrame {

    ConectarBD BD;
    Object[] Proveedor;

    public InterfazModificarProveedor(ConectarBD con, Object[] fila) {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfAP = new javax.swing.JTextField();
        jtfNP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfEP = new javax.swing.JTextField();
        btnModificarP = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jtfTP = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtfDP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(251, 229, 218));

        jLabel2.setFont(new java.awt.Font("Buttershine", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(241, 172, 133));
        jLabel2.setText("Modificar Proveedor");

        jLabel4.setText("AREA DE TRABAJO: ");

        jLabel5.setText("DESCRIPCIÓN:  ");

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

        jtfNP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNPActionPerformed(evt);
            }
        });

        jLabel7.setText("EMAIL: ");

        jtfEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEPActionPerformed(evt);
            }
        });

        btnModificarP.setText("MODIFICAR");
        btnModificarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPActionPerformed(evt);
            }
        });

        jLabel8.setText("NOMBRE: ");

        jLabel6.setText("TELÉFONO: ");

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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

        jtfDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDPActionPerformed(evt);
            }
        });
        jScrollPane1.setViewportView(jtfDP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(224, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(105, 105, 105)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfNP, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(jtfEP)
                            .addComponent(jtfAP)
                            .addComponent(jtfTP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnModificarP))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtfNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtfAP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtfTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtfEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAPActionPerformed

    private void jtfNPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNPActionPerformed

    private void jtfDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDPActionPerformed

    private void jtfTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTPActionPerformed

    private void jtfEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfEPActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int opc = JOptionPane.showConfirmDialog(null, "¿Desea volver a la gestión de proveedores?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (opc == 0) {
            this.setVisible(false);
            InterfazGestionarProveedores GestionProveedor = new InterfazGestionarProveedores(BD);
            GestionProveedor.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnModificarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPActionPerformed
        if (jtfNP.getText().isEmpty() || jtfDP.getText().isEmpty() || jtfTP.getText().isEmpty() || jtfEP.getText().isEmpty() || jtfAP.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los datos");
        else {
            int id = (int) Proveedor[0];
            String nom = jtfNP.getText();
            String area = jtfAP.getText();
            String desc = jtfDP.getText();
            String tel = jtfTP.getText();
            String email = jtfEP.getText();

            BD.ModificarProveedor(id, nom, area, desc, tel, email);
            this.setVisible(false);
            InterfazGestionarProveedores GestionProveedor = new InterfazGestionarProveedores(BD);
            GestionProveedor.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnModificarPActionPerformed

    private void jtfAPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAPKeyTyped

    }//GEN-LAST:event_jtfAPKeyTyped

    private void jtfTPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTPKeyTyped
        int key = evt.getKeyChar();

        boolean n = key >= 48 && key <= 57;

        if (!n)
            evt.consume();
    }//GEN-LAST:event_jtfTPKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificarP;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtfAP;
    private javax.swing.JTextField jtfDP;
    private javax.swing.JTextField jtfEP;
    private javax.swing.JTextField jtfNP;
    private javax.swing.JTextField jtfTP;
    // End of variables declaration//GEN-END:variables
}
