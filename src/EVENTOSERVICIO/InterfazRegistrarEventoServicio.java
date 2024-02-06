package EVENTOSERVICIO;

import SOFTWARE.ConectarBD;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfazRegistrarEventoServicio extends javax.swing.JFrame {

    ConectarBD BD;
    DefaultTableModel modeloServicio;
    ArrayList<Object[]> Servicios;
    Object[] Servicio;
    Object[] Evento;

    public InterfazRegistrarEventoServicio(ConectarBD con, Object[] Ev) {
        initComponents();
        BD = con;
        Evento = Ev;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtfBuscar = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jtxt5 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxt3 = new javax.swing.JTextField();
        jtxt2 = new javax.swing.JTextField();
        jcbBuscar = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jtxt1 = new javax.swing.JTextField();
        jtxt8 = new javax.swing.JTextField();
        jtxt7 = new javax.swing.JTextField();
        jtxt4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxt6 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(251, 229, 218));

        jtfBuscar.setColumns(10);
        jtfBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jtxt5.setEditable(false);
        jtxt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Buttershine", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(241, 172, 133));
        jLabel2.setText(" Registrar Servicio del Evento");

        jLabel6.setText("PROVEEDOR:");

        jLabel10.setText("CANTIDAD:");

        jLabel3.setText("AREA:");

        jtxt3.setEditable(false);
        jtxt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt3ActionPerformed(evt);
            }
        });

        jtxt2.setEditable(false);
        jtxt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt2ActionPerformed(evt);
            }
        });

        jcbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proveedor", "Area", "ConceptoServicio", "Descripcion", "TipoCobro", "Costo", "RangoMaximo", "RangoMinimo" }));
        jcbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBuscarActionPerformed(evt);
            }
        });

        jLabel12.setText("Buscar Servicio por:");

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jtxt1.setEditable(false);
        jtxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt1ActionPerformed(evt);
            }
        });

        jtxt8.setEditable(false);
        jtxt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt8ActionPerformed(evt);
            }
        });

        jtxt7.setEditable(false);
        jtxt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt7ActionPerformed(evt);
            }
        });

        jtxt4.setEditable(false);
        jtxt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt4ActionPerformed(evt);
            }
        });

        jLabel5.setText("TIPO COBRO:");

        jLabel7.setText("MIN:");

        jLabel8.setText("MAX:");

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

        jLabel4.setText("SERVICIO:");

        jtxt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt6ActionPerformed(evt);
            }
        });

        jButton4.setText("Regresar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxt7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jtxt8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(279, 279, 279))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jLabel5)
                                .addGap(5, 5, 5)
                                .addComponent(jtxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtxt6))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jtxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(0, 81, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(118, 118, 118)
                                .addComponent(jButton4)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4)))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtxt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jtxt5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jtxt6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxt8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(btnRegistrar)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jtxt7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(297, 297, 297))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        InterfazGestionEventoServicio GestionarEventoServicio = new InterfazGestionEventoServicio(BD, Evento);
        GestionarEventoServicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        if (jtxt6.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los datos");
        else {
            Object[] opciones = {"Aceptar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Desea Añadir el Servicio al Evento?", "Mensaje de Confirmación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
            if (eleccion == JOptionPane.YES_OPTION) {
                int eve = (int) Evento[0];
                int ser = (int) Servicio[0];
                int cant = Integer.parseInt(jtxt6.getText());

                BD.RegistrarEventoServicio(eve, ser, cant);
                this.setVisible(false);
                InterfazGestionEventoServicio GestionarEventoServicio = new InterfazGestionEventoServicio(BD, Evento);
                GestionarEventoServicio.setVisible(true);
                this.dispose();
            } else {

            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

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
    private javax.swing.JButton btnRegistrar;
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
