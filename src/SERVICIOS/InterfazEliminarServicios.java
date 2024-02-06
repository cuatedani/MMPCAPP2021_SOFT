package SERVICIOS;

import SOFTWARE.ConectarBD;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfazEliminarServicios extends javax.swing.JFrame {

    ConectarBD BD;
    Object[] Servicio;

    public InterfazEliminarServicios(ConectarBD con, Object[] filas) {
        initComponents();
        BD = con;
        Servicio = filas;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        MostrarDatos();
    }

    public void MostrarDatos() {
        String nom = (String) Servicio[0];
        String are = (String) Servicio[1];
        String conc = (String) Servicio[2];
        String desc = (String) Servicio[3];
        String tipcob = (String) Servicio[4];
        int cost = (int) Servicio[5];
        int max = (int) Servicio[6];
        int min = (int) Servicio[7];

        jtfldIdServicio.setText("" + nom);
        jtfldIdProveedor.setText("" + are);
        jtfldConceptoServicio.setText(conc);
        jtfldDescS.setText(desc);
        if (tipcob.equals("UNITARIO")) {
            jcbTipoCobro.setSelectedIndex(0);
        }
        if (tipcob.equals("SERVICIO")) {
            jcbTipoCobro.setSelectedIndex(1);
        }
        jtfldCosto.setText("" + cost);
        jtfldRangoMaximo.setText("" + max);
        jtfldRangoMinimo.setText("" + min);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfldIdServicio = new javax.swing.JTextField();
        jtfldConceptoServicio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jtfldDescS = new javax.swing.JTextField();
        jtfldIdProveedor = new javax.swing.JTextField();
        jcbTipoCobro = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtfldCosto = new javax.swing.JTextField();
        jtfldRangoMinimo = new javax.swing.JTextField();
        jtfldRangoMaximo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(251, 229, 218));

        jLabel7.setText("COSTO:");

        jLabel2.setFont(new java.awt.Font("Buttershine", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(241, 172, 133));
        jLabel2.setText("Eliminar Servicios");

        jLabel3.setText("ID DE PROVEEDOR: ");

        jtfldIdServicio.setEditable(false);
        jtfldIdServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfldIdServicioActionPerformed(evt);
            }
        });
        jtfldIdServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfldIdServicioKeyTyped(evt);
            }
        });

        jtfldConceptoServicio.setEditable(false);
        jtfldConceptoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfldConceptoServicioActionPerformed(evt);
            }
        });
        jtfldConceptoServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfldConceptoServicioKeyTyped(evt);
            }
        });

        jLabel5.setText("TIPO DE COBRO:");

        jLabel8.setText("RANGO MAXIMO:");

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("CONCEPTO SERVICIO:");

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel10.setText("RANGO MINIMO:");

        jtfldDescS.setEditable(false);
        jtfldDescS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfldDescSActionPerformed(evt);
            }
        });

        jtfldIdProveedor.setEditable(false);
        jtfldIdProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfldIdProveedorActionPerformed(evt);
            }
        });
        jtfldIdProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfldIdProveedorKeyTyped(evt);
            }
        });

        jcbTipoCobro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UNITARIO", "SERVICIO" }));
        jcbTipoCobro.setEnabled(false);
        jcbTipoCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoCobroActionPerformed(evt);
            }
        });

        jLabel6.setText("DESCRIPCION:");

        jLabel11.setText("ID DE SERVICIO: ");

        jtfldCosto.setEditable(false);
        jtfldCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfldCostoActionPerformed(evt);
            }
        });
        jtfldCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfldCostoKeyTyped(evt);
            }
        });

        jtfldRangoMinimo.setEditable(false);

        jtfldRangoMaximo.setEditable(false);
        jtfldRangoMaximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfldRangoMaximoActionPerformed(evt);
            }
        });
        jtfldRangoMaximo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfldRangoMaximoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel6)))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jtfldConceptoServicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(jtfldIdServicio, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfldIdProveedor, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfldDescS))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbTipoCobro, 0, 147, Short.MAX_VALUE)
                                    .addComponent(jtfldCosto)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfldRangoMaximo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfldRangoMinimo))
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel2)
                        .addGap(142, 142, 142)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jcbTipoCobro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtfldCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfldRangoMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jtfldIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jtfldIdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtfldConceptoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtfldRangoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(btnEliminar))
                    .addComponent(jtfldDescS, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int opc = JOptionPane.showConfirmDialog(null, "¿Desea volver a la gestión de Servicios?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (opc == 0) {
            this.setVisible(false);
            InterfazGestionarServicios GestionServicios = new InterfazGestionarServicios(BD);
            GestionServicios.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtfldConceptoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfldConceptoServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldConceptoServicioActionPerformed

    private void jtfldConceptoServicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfldConceptoServicioKeyTyped

    }//GEN-LAST:event_jtfldConceptoServicioKeyTyped

    private void jtfldIdServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfldIdServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldIdServicioActionPerformed

    private void jtfldIdServicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfldIdServicioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldIdServicioKeyTyped

    private void jtfldRangoMaximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfldRangoMaximoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldRangoMaximoActionPerformed

    private void jtfldRangoMaximoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfldRangoMaximoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldRangoMaximoKeyTyped

    private void jtfldCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfldCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldCostoActionPerformed

    private void jtfldCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfldCostoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldCostoKeyTyped

    private void jcbTipoCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoCobroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoCobroActionPerformed

    private void jtfldDescSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfldDescSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldDescSActionPerformed

    private void jtfldIdProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfldIdProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldIdProveedorActionPerformed

    private void jtfldIdProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfldIdProveedorKeyTyped

    }//GEN-LAST:event_jtfldIdProveedorKeyTyped

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int ser = (int) Servicio[0];
        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Desea Eliminar Servicio Seleccionado?", "Mensaje de Confirmación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            BD.EliminarServicio(ser);
            this.setVisible(false);
            InterfazGestionarServicios GestionServicios = new InterfazGestionarServicios(BD);
            GestionServicios.setVisible(true);
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcbTipoCobro;
    private javax.swing.JTextField jtfldConceptoServicio;
    private javax.swing.JTextField jtfldCosto;
    private javax.swing.JTextField jtfldDescS;
    private javax.swing.JTextField jtfldIdProveedor;
    private javax.swing.JTextField jtfldIdServicio;
    private javax.swing.JTextField jtfldRangoMaximo;
    private javax.swing.JTextField jtfldRangoMinimo;
    // End of variables declaration//GEN-END:variables
}
