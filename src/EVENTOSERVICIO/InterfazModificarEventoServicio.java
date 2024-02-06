package EVENTOSERVICIO;

import SOFTWARE.ConectarBD;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfazModificarEventoServicio extends javax.swing.JFrame {

    ConectarBD BD;
    DefaultTableModel modeloServicio;
    ArrayList<Object[]> Servicios;
    Object[] Servicio;
    Object[] EventoServicio;
    Object[] Evento;

    public InterfazModificarEventoServicio(ConectarBD con, Object[] Ev, Object[] EvSe) {
        initComponents();
        BD = con;
        Evento = Ev;
        EventoServicio = EvSe;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        MostrarDatos();
        MostrarServicio();
        tablaServicios.setModel(modeloServicio);
    }

    public void MostrarServicio() {
        ArrayList<Object[]> filas = BD.MostrarServicio();
        Servicios = filas;

        Class[] tiposColumnas = {String.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, Integer.class};
        modeloServicio = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int renglon, int columna) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int indiceColumna) {
                return tiposColumnas[indiceColumna];
            }
        };
        modeloServicio.addColumn("Proveedor");
        modeloServicio.addColumn("Area");
        modeloServicio.addColumn("Servicio");
        modeloServicio.addColumn("Descripcion");
        modeloServicio.addColumn("TipoCobro");
        modeloServicio.addColumn("Costo");
        modeloServicio.addColumn("Min");
        modeloServicio.addColumn("Max");

        for (int f = 0; f < modeloServicio.getRowCount(); f++) {
            modeloServicio.removeRow(f);
        }
        if (!filas.isEmpty()) {
            for (int i = 0; i < filas.size(); i++) {
                Object[] columnas = filas.get(i);

                String col1 = (String) columnas[2];
                String col2 = (String) columnas[3];
                String col3 = (String) columnas[4];
                String col4 = (String) columnas[5];
                String col5 = (String) columnas[6];
                int col6 = (int) columnas[7];
                int col7 = (int) columnas[9];
                int col8 = (int) columnas[8];

                modeloServicio.addRow(new Object[]{col1, col2, col3, col4, col5, col6, col7, col8});
            }
        }
    }

    public void MostrarServicio(int c, String d) {
        ArrayList<Object[]> filas = BD.MostrarServicio(c, d);
        Servicios = filas;

        Class[] tiposColumnas = {String.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, Integer.class};
        modeloServicio = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int renglon, int columna) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int indiceColumna) {
                return tiposColumnas[indiceColumna];
            }
        };
        modeloServicio.addColumn("Proveedor");
        modeloServicio.addColumn("Area");
        modeloServicio.addColumn("Servicio");
        modeloServicio.addColumn("Descripcion");
        modeloServicio.addColumn("TipoCobro");
        modeloServicio.addColumn("Costo");
        modeloServicio.addColumn("Min");
        modeloServicio.addColumn("Max");

        for (int f = 0; f < modeloServicio.getRowCount(); f++) {
            modeloServicio.removeRow(f);
        }
        if (!filas.isEmpty()) {
            for (int i = 0; i < filas.size(); i++) {
                Object[] columnas = filas.get(i);

                String col1 = (String) columnas[2];
                String col2 = (String) columnas[3];
                String col3 = (String) columnas[4];
                String col4 = (String) columnas[5];
                String col5 = (String) columnas[6];
                int col6 = (int) columnas[7];
                int col7 = (int) columnas[9];
                int col8 = (int) columnas[8];

                modeloServicio.addRow(new Object[]{col1, col2, col3, col4, col5, col6, col7, col8});
            }
        }
    }

    public void MostrarDatos() {
        jtxt1.setText((String) EventoServicio[3]);
        jtxt2.setText((String) EventoServicio[4]);
        jtxt3.setText((String) EventoServicio[5]);
        jtxt4.setText((String) EventoServicio[6]);
        jtxt5.setText((String) EventoServicio[7]);
        jtxt6.setText((String) EventoServicio[8]);
        jtxt7.setText((String) EventoServicio[9]);
        jtxt8.setText((String) EventoServicio[10]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtxt6 = new javax.swing.JTextField();
        jtxt7 = new javax.swing.JTextField();
        jcbBuscar = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jtfBuscar = new javax.swing.JTextField();
        jtxt2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxt1 = new javax.swing.JTextField();
        jtxt5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxt4 = new javax.swing.JTextField();
        jtxt3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxt8 = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(251, 229, 218));

        jLabel4.setText("SERVICIO:");

        jLabel5.setText("TIPO COBRO:");

        jLabel10.setText("CANTIDAD:");

        jButton4.setText("Regresar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(241, 172, 133));
        jLabel2.setFont(new java.awt.Font("Buttershine", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(241, 172, 133));
        jLabel2.setText("Modificar Servicio de Evento");

        jtxt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt6ActionPerformed(evt);
            }
        });

        jtxt7.setEditable(false);
        jtxt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt7ActionPerformed(evt);
            }
        });

        jcbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proveedor", "Area", "ConceptoServicio", "Descripcion", "TipoCobro", "Costo", "RangoMaximo", "RangoMinimo" }));
        jcbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBuscarActionPerformed(evt);
            }
        });

        jLabel6.setText("PROVEEDOR:");

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel12.setText("Buscar Servicio por:");

        jtfBuscar.setColumns(10);
        jtfBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarActionPerformed(evt);
            }
        });

        jtxt2.setEditable(false);
        jtxt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt2ActionPerformed(evt);
            }
        });

        tablaServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Proveedor", "Area", "Servicio", "Descripcion", "TipoCobro", "Costo", "Min", "Max"
            }
        ));
        tablaServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaServiciosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaServicios);

        jScrollPane1.setViewportView(jScrollPane2);

        jLabel9.setText("COSTO:");

        jLabel3.setText("AREA:");

        jtxt1.setEditable(false);
        jtxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt1ActionPerformed(evt);
            }
        });

        jtxt5.setEditable(false);
        jtxt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt5ActionPerformed(evt);
            }
        });

        jLabel8.setText("MAX:");

        jtxt4.setEditable(false);
        jtxt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt4ActionPerformed(evt);
            }
        });

        jtxt3.setEditable(false);
        jtxt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt3ActionPerformed(evt);
            }
        });

        jLabel7.setText("MIN:");

        jtxt8.setEditable(false);
        jtxt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt8ActionPerformed(evt);
            }
        });

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(151, 151, 151)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscar))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxt5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxt6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxt7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jtxt8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4)))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtxt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jtxt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtxt5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jtxt6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jtxt7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jtxt8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(jcbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        InterfazGestionEventoServicio GestionarEventoServicio = new InterfazGestionEventoServicio(BD, Evento);
        GestionarEventoServicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jtxt6.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los datos");
        else {
            Object[] opciones = {"Aceptar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Desea Añadir el Servicio al Evento?", "Mensaje de Confirmación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
            if (eleccion == JOptionPane.YES_OPTION) {
                int eveser = (int) EventoServicio[0];
                int eve = (int) EventoServicio[1];
                int ser;
                if (Servicio[0] != null ) {
                    ser = (int) Servicio[0];
                } else {
                    ser = (int) EventoServicio[2];
                }
                int cant = Integer.parseInt(jtxt6.getText());

                BD.ModificarEventoServicio(eveser, eve, ser, cant);
                this.setVisible(false);
                InterfazGestionEventoServicio GestionarEventoServicio = new InterfazGestionEventoServicio(BD, Evento);
                GestionarEventoServicio.setVisible(true);
                this.dispose();
            } else {

            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jtxt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt6ActionPerformed

    private void jtxt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt3ActionPerformed

    private void jtxt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt4ActionPerformed

    private void jtxt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt7ActionPerformed

    private void jtxt8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt8ActionPerformed

    private void jtxt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt5ActionPerformed

    private void jtxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt1ActionPerformed

    private void jtxt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt2ActionPerformed

    private void tablaServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaServiciosMouseClicked
        int indice = tablaServicios.rowAtPoint(evt.getPoint());
        Servicio = Servicios.get(indice);
        jtxt1.setText((String) EventoServicio[2]);
        jtxt2.setText((String) EventoServicio[3]);
        jtxt3.setText((String) EventoServicio[4]);
        jtxt4.setText((String) EventoServicio[6]);
        jtxt5.setText((String) EventoServicio[7]);
        jtxt7.setText((String) EventoServicio[9]);
        jtxt8.setText((String) EventoServicio[8]);
    }//GEN-LAST:event_tablaServiciosMouseClicked

    private void jcbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbBuscarActionPerformed

    private void jtfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int c = jcbBuscar.getSelectedIndex();
        String d = jtfBuscar.getText();
        if (d.isEmpty()) {
            MostrarServicio();
        } else {
            MostrarServicio(c, d);
        }
        tablaServicios.setModel(modeloServicio);
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTextField jtfBuscar;
    private javax.swing.JTextField jtxt1;
    private javax.swing.JTextField jtxt2;
    private javax.swing.JTextField jtxt3;
    private javax.swing.JTextField jtxt4;
    private javax.swing.JTextField jtxt5;
    private javax.swing.JTextField jtxt6;
    private javax.swing.JTextField jtxt7;
    private javax.swing.JTextField jtxt8;
    private javax.swing.JTable tablaServicios;
    // End of variables declaration//GEN-END:variables
}
