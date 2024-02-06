package COTIZACION;

import SOFTWARE.ConectarBD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfazEliminarCotizacion extends javax.swing.JFrame {

    ConectarBD BD;
    DefaultTableModel modeloCotizacion;
    int IdCotizacion;
    int IdEvento;

    public InterfazEliminarCotizacion(ConectarBD con, int idev, int idcot) {
         initComponents();
        BD = con;
        IdEvento = idev;
        IdCotizacion = idcot;
        String dato = "" + IdCotizacion;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        MostrarCotizacion(0, dato);
        tablaCotizacion.setModel(modeloCotizacion);
    }

    public void MostrarCotizacion(int c, String d) {
        ArrayList<Object[]> filas = BD.MostrarCotizacion(IdEvento, c, d);
        Class[] tiposColumnas = {Integer.class, String.class, Integer.class, String.class};
        modeloCotizacion = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int renglon, int columna) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int indiceColumna) {
                return tiposColumnas[indiceColumna];
            }
        };
        modeloCotizacion.addColumn("IdCotizacion");
        modeloCotizacion.addColumn("Estado");
        modeloCotizacion.addColumn("Costo");
        modeloCotizacion.addColumn("Fecha");

        for (int f = 0; f < modeloCotizacion.getRowCount(); f++) {
            modeloCotizacion.removeRow(f);
        }
        if (!filas.isEmpty()) {
            for (int i = 0; i < filas.size(); i++) {
                Object[] columnas = filas.get(i);

                int col1 = (int) columnas[0];
                String col2 = (String) columnas[2];
                int col3 = (int) columnas[3];
                String col4 = (String) columnas[4];

                jtfldIdCotizacion.setText("" + IdCotizacion);

                if (col2.equals("PENDIENTE")) {
                    jcbEstado.setSelectedIndex(0);
                } else if (col2.equals("FECHAZADA")) {
                    jcbEstado.setSelectedIndex(1);
                } else {
                    jcbEstado.setSelectedIndex(2);
                }

                jtfldCosto.setText("" + col3);

                String fechaEv = col4;
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date mifech = formatter.parse(fechaEv);
                    jdcFecha.getDateEditor().setDate(mifech);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                modeloCotizacion.addRow(new Object[]{col1, col2, col3, col4});
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox<>();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        btnRegresar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCotizacion = new javax.swing.JTable();
        jtfldCosto = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        jtfldIdCotizacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(251, 229, 218));

        jLabel3.setText("IDCOTIZACION:");

        jLabel4.setText("ESTADO:");

        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PENDIENTE", "RECHAZADA", "ACEPTADA" }));
        jcbEstado.setEnabled(false);

        jdcFecha.setDateFormatString("yyyy-MM-dd");
        jdcFecha.setEnabled(false);
        jdcFecha.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel7.setText("FECHA: ");

        tablaCotizacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "IdCotizacion", "CotizacionEstado", "Costo", "Fecha"
            }
        ));
        jScrollPane2.setViewportView(tablaCotizacion);

        jScrollPane1.setViewportView(jScrollPane2);

        jtfldCosto.setEditable(false);
        jtfldCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfldCostoActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jtfldIdCotizacion.setEditable(false);
        jtfldIdCotizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfldIdCotizacionActionPerformed(evt);
            }
        });

        jLabel6.setText("COSTO:");

        jLabel2.setFont(new java.awt.Font("Buttershine", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(241, 172, 133));
        jLabel2.setText("ELiminar Cotizaciones");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(103, 103, 103)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jdcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                        .addComponent(jtfldIdCotizacion)
                        .addComponent(jtfldCosto)))
                .addContainerGap(233, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar))
                    .addComponent(jLabel2))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfldIdCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtfldCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Desea Eliminar la Cotizacion Seleccionada?", "Mensaje de Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            BD.EliminarCotizacion(IdCotizacion);
            this.setVisible(false);
            InterfazGestionarCotizacion GestionarCotizacion = new InterfazGestionarCotizacion(BD, IdEvento);
            GestionarCotizacion.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jtfldIdCotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfldIdCotizacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldIdCotizacionActionPerformed

    private void jtfldCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfldCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldCostoActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.setVisible(false);
        InterfazGestionarCotizacion GestionarCotizacion = new InterfazGestionarCotizacion(BD, IdEvento);
        GestionarCotizacion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcbEstado;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTextField jtfldCosto;
    private javax.swing.JTextField jtfldIdCotizacion;
    private javax.swing.JTable tablaCotizacion;
    // End of variables declaration//GEN-END:variables
}
