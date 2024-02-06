package COTIZACION;

import SOFTWARE.ConectarBD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfazCrearCotizacion extends javax.swing.JFrame {

    ConectarBD BD;
    DefaultTableModel modeloServicios;
    int IdEvento;
    int CantInvitados;

    public InterfazCrearCotizacion(ConectarBD con, int idev) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        BD = con;
        IdEvento = idev;
        String evser = "" + IdEvento;
        FechaActual();
        CantInvitados = BD.CantidadInvitados(IdEvento);
        MostrarCotizacionServicios();
        tablaEventoServicio.setModel(modeloServicios);
    }

    public void MostrarCotizacionServicios() {
        ArrayList<Object[]> filas = BD.MostrarCotizacionServicios(IdEvento);
        Class[] tiposColumnas = {String.class, String.class, String.class, Integer.class, Integer.class};
        modeloServicios = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int renglon, int columna) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int indiceColumna) {
                return tiposColumnas[indiceColumna];
            }
        };
        modeloServicios.addColumn("Nombre");
        modeloServicios.addColumn("ConceptoServicio");
        modeloServicios.addColumn("TipoCobro");
        modeloServicios.addColumn("Costo");
        modeloServicios.addColumn("Cantidad");

        if (!filas.isEmpty()) {
            for (int i = 0; i < filas.size(); i++) {
                Object[] columnas = filas.get(i);

                String col1 = (String) columnas[0];
                String col2 = (String) columnas[1];
                String col3 = (String) columnas[2];
                int col4 = (int) columnas[3];
                int col5 = (int) columnas[4];

                modeloServicios.addRow(new Object[]{col1, col2, col3, col4, col5});
            }
        }
    }

    public void MostrarCotizacionServicios(int c, String d) {
        ArrayList<Object[]> filas = BD.MostrarCotizacionServicios(IdEvento, c, d);
        Class[] tiposColumnas = {String.class, String.class, String.class, Integer.class, Integer.class};
        modeloServicios = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int renglon, int columna) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int indiceColumna) {
                return tiposColumnas[indiceColumna];
            }
        };
        modeloServicios.addColumn("NombreProveedor");
        modeloServicios.addColumn("ConceptoServicio");
        modeloServicios.addColumn("TipoCobro");
        modeloServicios.addColumn("Costo");
        modeloServicios.addColumn("Cantidad");

        if (!filas.isEmpty()) {
            for (int i = 0; i < filas.size(); i++) {
                Object[] columnas = filas.get(i);

                String col1 = (String) columnas[0];
                String col2 = (String) columnas[1];
                String col3 = (String) columnas[2];
                int col4 = (int) columnas[3];
                int col5 = (int) columnas[5];

                modeloServicios.addRow(new Object[]{col1, col2, col3, col4, col5});
            }
        }
    }

    public void FechaActual() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaEv = "" + dtf.format(LocalDateTime.now());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date mifech = formatter.parse(fechaEv);
            jdcFecha.getDateEditor().setDate(mifech);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcbBuscar = new javax.swing.JComboBox<>();
        jtfldBuscar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jbtnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEventoServicio = new javax.swing.JTable();
        btnCotizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(251, 229, 218));

        jcbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NombreProveedor", "ConceptoServicio", "TipoCobro", "Costo", "Cantidad" }));
        jcbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBuscarActionPerformed(evt);
            }
        });

        jtfldBuscar.setColumns(10);
        jtfldBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfldBuscarActionPerformed(evt);
            }
        });

        jLabel10.setText("Buscar Evento Servicio por:");

        jbtnBuscar.setText("BUSCAR");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });

        tablaEventoServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre Proveedor", "ConceptoServicio", "TipoCobro", "Costo", "Cantidad"
            }
        ));
        jScrollPane2.setViewportView(tablaEventoServicio);

        jScrollPane1.setViewportView(jScrollPane2);

        btnCotizar.setText("COTIZAR");
        btnCotizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCotizarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Buttershine", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(241, 172, 133));
        jLabel2.setText("Crear Cotizaciones");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel7.setText("FECHA: ");

        jdcFecha.setDateFormatString("yyyy-MM-dd");
        jdcFecha.setEnabled(false);
        jdcFecha.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(278, 278, 278)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jcbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCotizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCotizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBuscar)
                    .addComponent(jtfldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.setVisible(false);
        InterfazGestionarCotizacion GestionarCotizacion = new InterfazGestionarCotizacion(BD, IdEvento);
        GestionarCotizacion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCotizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCotizarActionPerformed
        String est, date, det;
        int cos, sub, imp, hon;

        modeloServicios.getRowCount();
        if (modeloServicios.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(this, "No hay Servicios Añadidos a este Evento");
        } else {
            String dia = Integer.toString(jdcFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(jdcFecha.getCalendar().get(Calendar.MONTH) + 1);
            String year = Integer.toString(jdcFecha.getCalendar().get(Calendar.YEAR));
            date = (year + "-" + mes + "-" + dia);
            est = "PENDIENTE";
            cos = 0;
            sub = 0;
            imp = 0;
            hon = 0;
            det = "";
            
            det += "Cotizacion realizada el dia: " + date + "\n\n";
            det += "Concepto                         Costo               Importe\n\n";
            
            for(int i = 0; i < modeloServicios.getRowCount(); i++){
                String ConceptoServicio = (String) modeloServicios.getValueAt(i,1);
                String TipoCobro = (String) modeloServicios.getValueAt(i,2);
                int Costo = (int) modeloServicios.getValueAt(i,3);
                int Cantidad = (int) modeloServicios.getValueAt(i,4);
                
                if(TipoCobro.equals("UNITARIO")){imp = Costo * CantInvitados * Cantidad;}   
                if(TipoCobro.equals("SERVICIO")){imp = Costo * Cantidad;}
                
                det += ConceptoServicio + "         $" + Costo + "         $" + imp + "\n";
                sub += imp;
            }
            hon = (int)(sub*0.1);
            cos =(int)(sub*1.1);
            det += "SubTotal         $" + sub + "\nHonorarios         $" + hon + "\nCostoTotal          $" + cos;           
            
            BD.RegistrarCotizacion(IdEvento, est, cos, date, det);
            this.setVisible(false);
            InterfazGestionarCotizacion GestionarCotizacion = new InterfazGestionarCotizacion(BD, IdEvento);
            GestionarCotizacion.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCotizarActionPerformed

    private void jcbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbBuscarActionPerformed

    private void jtfldBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfldBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfldBuscarActionPerformed

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        int c = jcbBuscar.getSelectedIndex();
        String d = jtfldBuscar.getText();
        if (d.isEmpty()) {
            MostrarCotizacionServicios();
        } else {
            MostrarCotizacionServicios(c, d);
        }
        tablaEventoServicio.setModel(modeloServicios);
    }//GEN-LAST:event_jbtnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCotizar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JComboBox<String> jcbBuscar;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTextField jtfldBuscar;
    private javax.swing.JTable tablaEventoServicio;
    // End of variables declaration//GEN-END:variables
}
