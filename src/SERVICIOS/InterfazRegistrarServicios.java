package SERVICIOS;

import EVENTOS.InterfazGestionarEventos;
import SOFTWARE.ConectarBD;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfazRegistrarServicios extends javax.swing.JFrame {

    ConectarBD BD;
    DefaultTableModel modelo;
    ArrayList<Object[]> Proveedores;
    Object[] Proveedor;

    public InterfazRegistrarServicios(ConectarBD con) {
        initComponents();
        BD = con;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        MostrarProveedor();
        tablaPro.setModel(modelo);
    }

    public void MostrarProveedor() {
        ArrayList<Object[]> filas = BD.MostrarProveedor();
        Proveedores = filas;
        
        Class[] tiposColumnas = {Integer.class, String.class, Integer.class, String.class, String.class, String.class};
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int renglon, int columna) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int indiceColumna) {
                return tiposColumnas[indiceColumna];
            }
        };
        modelo.addColumn("Nombre");
        modelo.addColumn("AreaTrabajo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Email");

        for (int f = 0; f < modelo.getRowCount(); f++) {
            modelo.removeRow(f);
        }
        if (!filas.isEmpty()) {
            for (int i = 0; i < filas.size(); i++) {
                Object[] columnas = filas.get(i);

                int col1 = (int) columnas[0];
                String col2 = (String) columnas[1];
                String col3 = (String) columnas[2];
                String col4 = (String) columnas[3];
                String col5 = (String) columnas[4];
                String col6 = (String) columnas[5];

                modelo.addRow(new Object[]{col1, col2, col3, col4, col5, col6});
            }
        }
    }

    public void MostrarProveedor(int c, String d) {
        ArrayList<Object[]> filas = BD.MostrarProveedor(c, d);
        Class[] tiposColumnas = {Integer.class, String.class, String.class, String.class, String.class, String.class};
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int renglon, int columna) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int indiceColumna) {
                return tiposColumnas[indiceColumna];
            }
        };
        modelo.addColumn("Nombre");
        modelo.addColumn("AreaTrabajo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Email");

        for (int f = 0; f < modelo.getRowCount(); f++) {
            modelo.removeRow(f);
        }
        if (!filas.isEmpty()) {
            for (int i = 0; i < filas.size(); i++) {
                Object[] columnas = filas.get(i);

                int col1 = (int) columnas[0];
                String col2 = (String) columnas[1];
                String col3 = (String) columnas[2];
                String col4 = (String) columnas[3];
                String col5 = (String) columnas[4];
                String col6 = (String) columnas[5];

                modelo.addRow(new Object[]{col1, col2, col3, col4, col5, col6});
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfIdConceptoServicio = new javax.swing.JTextField();
        jcbTipoCobro = new javax.swing.JComboBox<>();
        jtfIdProveedor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPro = new javax.swing.JTable();
        jtfldCosto = new javax.swing.JTextField();
        jtfIdRangoMinimo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jtfldDescS = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfIdRangoMaximo = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnBuscar1 = new javax.swing.JButton();
        jcbBuscar = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jtfBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(251, 229, 218));

        jLabel4.setText("CONCEPTO SERVICIO:");

        jLabel2.setFont(new java.awt.Font("Buttershine", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(241, 172, 133));
        jLabel2.setText("Registrar Servicios");

        jtfIdConceptoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIdConceptoServicioActionPerformed(evt);
            }
        });
        jtfIdConceptoServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfIdConceptoServicioKeyTyped(evt);
            }
        });

        jcbTipoCobro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UNITARIO", "SERVICIO" }));
        jcbTipoCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoCobroActionPerformed(evt);
            }
        });

        jtfIdProveedor.setEditable(false);
        jtfIdProveedor.setBackground(new java.awt.Color(255, 255, 255));
        jtfIdProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIdProveedorActionPerformed(evt);
            }
        });
        jtfIdProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfIdProveedorKeyTyped(evt);
            }
        });

        jLabel5.setText("TIPO DE COBRO:");

        tablaPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "AreaTrabajo", "Descripción", "Teléfono", "Email"
            }
        ));
        tablaPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaPro);

        jScrollPane1.setViewportView(jScrollPane2);

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

        jLabel8.setText("RANGO MAXIMO:");

        jLabel6.setText("DESCRIPCION:");

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jtfldDescS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfldDescSActionPerformed(evt);
            }
        });

        jLabel7.setText("COSTO:");

        jtfIdRangoMaximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIdRangoMaximoActionPerformed(evt);
            }
        });
        jtfIdRangoMaximo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfIdRangoMaximoKeyTyped(evt);
            }
        });

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel3.setText("PROVEEDOR: ");

        jLabel10.setText("RANGO MINIMO:");

        btnBuscar1.setText("BUSCAR");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        jcbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "AreaTrabajo", "Descripcion", "Telefono", "Email" }));
        jcbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBuscarActionPerformed(evt);
            }
        });

        jLabel9.setText("Buscar por:");

        jtfBuscar.setColumns(10);
        jtfBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(249, 249, 249)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jcbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfIdProveedor)
                            .addComponent(jtfIdConceptoServicio, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfldDescS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfIdRangoMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfldCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbTipoCobro, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfIdRangoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jtfIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(92, 92, 92))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jtfIdRangoMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnRegistrar))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jtfIdConceptoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfldDescS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(14, 14, 14))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jcbTipoCobro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfldCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jtfIdRangoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(69, 69, 69)))))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar1)
                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
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

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (jtfIdProveedor.getText().isEmpty() || jtfIdConceptoServicio.getText().isEmpty() || jtfldDescS.getText().isEmpty() || jtfldCosto.getText().isEmpty() || jtfIdRangoMaximo.getText().isEmpty() || jtfIdRangoMinimo.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los datos");
        else {
            int pro = (int) Proveedor[0];
            String conc = jtfIdConceptoServicio.getText();
            String desc = jtfldDescS.getText();
            String tipcob = jcbTipoCobro.getItemAt(jcbTipoCobro.getSelectedIndex());;
            int cost = Integer.parseInt(jtfldCosto.getText());
            int max = Integer.parseInt(jtfIdRangoMaximo.getText());
            int min = Integer.parseInt(jtfIdRangoMinimo.getText());

            BD.RegistrarServicio(pro, conc, desc, tipcob, cost, max, min);
            this.setVisible(false);
            InterfazGestionarServicios GestionServicios = new InterfazGestionarServicios(BD);
            GestionServicios.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jtfIdProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIdProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIdProveedorActionPerformed

    private void jtfIdProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIdProveedorKeyTyped

    }//GEN-LAST:event_jtfIdProveedorKeyTyped

    private void jtfIdConceptoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIdConceptoServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIdConceptoServicioActionPerformed

    private void jtfIdConceptoServicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIdConceptoServicioKeyTyped

    }//GEN-LAST:event_jtfIdConceptoServicioKeyTyped

    private void jcbTipoCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoCobroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoCobroActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int opc = JOptionPane.showConfirmDialog(null, "¿Desea volver a la gestión de Servicios?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (opc == 0) {
            this.setVisible(false);
            InterfazGestionarServicios GestionServicios = new InterfazGestionarServicios(BD);
            GestionServicios.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtfldDescSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfldDescSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldDescSActionPerformed

    private void jtfldCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfldCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldCostoActionPerformed

    private void jtfldCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfldCostoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldCostoKeyTyped

    private void jtfIdRangoMaximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIdRangoMaximoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIdRangoMaximoActionPerformed

    private void jtfIdRangoMaximoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIdRangoMaximoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIdRangoMaximoKeyTyped

    private void tablaProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProMouseClicked
        int indice = tablaPro.rowAtPoint(evt.getPoint());
        Proveedor = Proveedores.get(indice);
        jtfIdProveedor.setText("" + (int) Proveedor[0]);
    }//GEN-LAST:event_tablaProMouseClicked

    private void jcbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbBuscarActionPerformed

    private void jtfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        int c = jcbBuscar.getSelectedIndex();
        String d = jtfBuscar.getText();
        if (d.isEmpty()) {
            MostrarProveedor();
        } else {
            MostrarProveedor(c, d);
        }
        tablaPro.setModel(modelo);
    }//GEN-LAST:event_btnBuscar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcbBuscar;
    private javax.swing.JComboBox<String> jcbTipoCobro;
    private javax.swing.JTextField jtfBuscar;
    private javax.swing.JTextField jtfIdConceptoServicio;
    private javax.swing.JTextField jtfIdProveedor;
    private javax.swing.JTextField jtfIdRangoMaximo;
    private javax.swing.JTextField jtfIdRangoMinimo;
    private javax.swing.JTextField jtfldCosto;
    private javax.swing.JTextField jtfldDescS;
    private javax.swing.JTable tablaPro;
    // End of variables declaration//GEN-END:variables
}
