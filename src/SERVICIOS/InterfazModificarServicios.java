package SERVICIOS;

import SOFTWARE.ConectarBD;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfazModificarServicios extends javax.swing.JFrame {

    ConectarBD BD;
    DefaultTableModel modeloProveedores;
    ArrayList<Object[]> Proveedores;
    Object[] Proveedor;
    Object[] Servicio;

    public InterfazModificarServicios(ConectarBD con, Object[] filas) {
        initComponents();
        BD = con;
        Servicio = filas;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        MostrarProveedor();
        tablaPro.setModel(modeloProveedores);
        MostrarDatos();
    }

    public void MostrarProveedor() {
        ArrayList<Object[]> filas = BD.MostrarProveedor();
        Proveedores = filas;

        Class[] tiposColumnas = {String.class, Integer.class, String.class, String.class, String.class};
        modeloProveedores = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int renglon, int columna) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int indiceColumna) {
                return tiposColumnas[indiceColumna];
            }
        };
        modeloProveedores.addColumn("Nombre");
        modeloProveedores.addColumn("AreaTrabajo");
        modeloProveedores.addColumn("Descripcion");
        modeloProveedores.addColumn("Telefono");
        modeloProveedores.addColumn("Email");

        for (int f = 0; f < modeloProveedores.getRowCount(); f++) {
            modeloProveedores.removeRow(f);
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

                modeloProveedores.addRow(new Object[]{col1, col2, col3, col4, col5, col6});
            }
        }
    }

    public void MostrarProveedor(int c, String d) {
        ArrayList<Object[]> filas = BD.MostrarProveedor(c, d);
        Proveedores = filas;
        
        Class[] tiposColumnas = {String.class, String.class, String.class, String.class, String.class};
        modeloProveedores = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int renglon, int columna) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int indiceColumna) {
                return tiposColumnas[indiceColumna];
            }
        };
        modeloProveedores.addColumn("Nombre");
        modeloProveedores.addColumn("AreaTrabajo");
        modeloProveedores.addColumn("Descripcion");
        modeloProveedores.addColumn("Telefono");
        modeloProveedores.addColumn("Email");

        for (int f = 0; f < modeloProveedores.getRowCount(); f++) {
            modeloProveedores.removeRow(f);
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

                modeloProveedores.addRow(new Object[]{col1, col2, col3, col4, col5, col6});
            }
        }
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
        jButton2 = new javax.swing.JButton();
        jtfldDescS = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfldCosto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPro = new javax.swing.JTable();
        jtfldConceptoServicio = new javax.swing.JTextField();
        jtfldIdProveedor = new javax.swing.JTextField();
        jtfldRangoMaximo = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jcbTipoCobro = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfldRangoMinimo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtfldIdServicio = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfBuscar = new javax.swing.JTextField();
        jcbBuscar = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(251, 229, 218));

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

        jLabel4.setText("CONCEPTO SERVICIO:");

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

        jLabel7.setText("COSTO:");

        jLabel8.setText("RANGO MAXIMO:");

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

        jtfldIdProveedor.setEditable(false);
        jtfldIdProveedor.setBackground(new java.awt.Color(255, 255, 255));
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

        btnRegistrar.setText("MODIFICAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jcbTipoCobro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UNITARIO", "SERVICIO" }));
        jcbTipoCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoCobroActionPerformed(evt);
            }
        });

        jLabel3.setText("AREA DE TRABAJO: ");

        jLabel6.setText("DESCRIPCION:");

        jLabel11.setText("PROVEEDOR: ");

        jtfldIdServicio.setEditable(false);
        jtfldIdServicio.setBackground(new java.awt.Color(255, 255, 255));
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

        btnBuscar1.setText("BUSCAR");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        jLabel10.setText("RANGO MINIMO:");

        jLabel9.setText("Buscar por:");

        jLabel2.setFont(new java.awt.Font("Buttershine", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(241, 172, 133));
        jLabel2.setText("Modificar Servicios");

        jtfBuscar.setColumns(10);
        jtfBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarActionPerformed(evt);
            }
        });

        jcbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "AreaTrabajo", "Descripcion", "Telefono", "Email" }));
        jcbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(165, 165, 165)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel11))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jtfldIdServicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                            .addComponent(jtfldIdProveedor, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfldConceptoServicio)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel6)
                                        .addGap(26, 26, 26)
                                        .addComponent(jtfldDescS)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(9, 9, 9)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jcbTipoCobro, 0, 147, Short.MAX_VALUE)
                                                .addComponent(jtfldRangoMinimo))
                                            .addComponent(jtfldCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfldRangoMaximo))
                                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jtfldIdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jtfldIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jtfldConceptoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfldDescS, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar1))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jcbTipoCobro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtfldCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfldRangoMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtfldRangoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void jcbTipoCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoCobroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoCobroActionPerformed

    private void jtfldIdProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfldIdProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldIdProveedorActionPerformed

    private void jtfldIdProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfldIdProveedorKeyTyped

    }//GEN-LAST:event_jtfldIdProveedorKeyTyped

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

    private void jtfldConceptoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfldConceptoServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldConceptoServicioActionPerformed

    private void jtfldConceptoServicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfldConceptoServicioKeyTyped

    }//GEN-LAST:event_jtfldConceptoServicioKeyTyped

    private void jtfldRangoMaximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfldRangoMaximoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldRangoMaximoActionPerformed

    private void jtfldRangoMaximoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfldRangoMaximoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldRangoMaximoKeyTyped

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (jtfldIdProveedor.getText().isEmpty() || jtfldConceptoServicio.getText().isEmpty() || jtfldDescS.getText().isEmpty() || jtfldCosto.getText().isEmpty() || jtfldRangoMaximo.getText().isEmpty() || jtfldRangoMinimo.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los datos");
        else {
            int ser = (int) Servicio[0];
            int pro = (int) Servicio[1];
            String conc = jtfldConceptoServicio.getText();
            String desc = jtfldDescS.getText();
            String tipcob = jcbTipoCobro.getItemAt(jcbTipoCobro.getSelectedIndex());;
            int cost = Integer.parseInt(jtfldCosto.getText());
            int max = Integer.parseInt(jtfldRangoMaximo.getText());
            int min = Integer.parseInt(jtfldRangoMinimo.getText());

            BD.ModificarServicio(ser, pro, conc, desc, tipcob, cost, max, min);
            this.setVisible(false);
            InterfazGestionarServicios GestionServicios = new InterfazGestionarServicios(BD);
            GestionServicios.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jtfldIdServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfldIdServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldIdServicioActionPerformed

    private void jtfldIdServicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfldIdServicioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldIdServicioKeyTyped

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        int c = jcbBuscar.getSelectedIndex();
        String d = jtfBuscar.getText();
        if (d.isEmpty()) {
            MostrarProveedor();
        } else {
            MostrarProveedor(c, d);
        }
        tablaPro.setModel(modeloProveedores);
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void jtfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarActionPerformed

    private void jcbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbBuscarActionPerformed

    private void tablaProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProMouseClicked
        int indice = tablaPro.rowAtPoint(evt.getPoint());
        Proveedor = Proveedores.get(indice);
        jtfldIdServicio.setText("" + (int) Proveedor[1]);
        jtfldIdProveedor.setText("" + (int) Proveedor[2]);
    }//GEN-LAST:event_tablaProMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnRegistrar;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcbBuscar;
    private javax.swing.JComboBox<String> jcbTipoCobro;
    private javax.swing.JTextField jtfBuscar;
    private javax.swing.JTextField jtfldConceptoServicio;
    private javax.swing.JTextField jtfldCosto;
    private javax.swing.JTextField jtfldDescS;
    private javax.swing.JTextField jtfldIdProveedor;
    private javax.swing.JTextField jtfldIdServicio;
    private javax.swing.JTextField jtfldRangoMaximo;
    private javax.swing.JTextField jtfldRangoMinimo;
    private javax.swing.JTable tablaPro;
    // End of variables declaration//GEN-END:variables
}
