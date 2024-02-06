package EVENTOS;

import SOFTWARE.ConectarBD;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;

public class InterfazModificarEvento extends javax.swing.JFrame {

    ConectarBD BD;
    DefaultTableModel modelo;
    ArrayList<Object[]> Clientes;
    Object[] Cliente;
    Object[] Evento;

    public InterfazModificarEvento(ConectarBD con, Object[] filas) {
        initComponents();
        BD = con;
        Evento = filas;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        MostrarCliente();
        jTable1.setModel(modelo);

    }

    public void MostrarCliente() {
        ArrayList<Object[]> filas = BD.MostrarCliente();
        Clientes = filas;

        Class[] tiposColumnas = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
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
        modelo.addColumn("IdCliente");
        modelo.addColumn("Nombre");
        modelo.addColumn("ApellidoP");
        modelo.addColumn("ApellidoM");
        modelo.addColumn("Telefono");
        modelo.addColumn("Direccion");
        modelo.addColumn("Localidad");
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
                String col7 = (String) columnas[6];
                String col8 = (String) columnas[7];

                modelo.addRow(new Object[]{col1, col2, col3, col4, col5, col6, col7, col8});
            }
        }
    }

    public void MostrarCliente(int c, String d) {
        ArrayList<Object[]> filas = BD.MostrarCliente(c, d);
        Clientes = filas;

        Class[] tiposColumnas = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
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
        modelo.addColumn("IdCliente");
        modelo.addColumn("Nombre");
        modelo.addColumn("ApellidoP");
        modelo.addColumn("ApellidoM");
        modelo.addColumn("Telefono");
        modelo.addColumn("Direccion");
        modelo.addColumn("Localidad");
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
                String col7 = (String) columnas[6];
                String col8 = (String) columnas[7];

                modelo.addRow(new Object[]{col1, col2, col3, col4, col5, col6, col7, col8});
            }
        }
    }
    
    public void MostrarDatos(){
        jtfIdCliente.setText((String) Evento[2]);
        String fechaEv = (String) Evento[3];

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date mifech = formatter.parse(fechaEv);
            jdcFecha.getDateEditor().setDate(mifech);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        jtfInvitados.setText("" + (int) Evento[4]);

        String TipoEv = ((String) Evento[5]);
        if (TipoEv.equals("BODA")) {
            jcbTipoEvento.setSelectedIndex(0);
        } else if (TipoEv.equals("XV AÑOS")) {
            jcbTipoEvento.setSelectedIndex(1);
        } else if (TipoEv.equals("BAUTIZO")) {
            jcbTipoEvento.setSelectedIndex(2);
        } else {
            jcbTipoEvento.setSelectedIndex(3);
        }

        String EstadoEv = (String) Evento[6];
        if (EstadoEv.equals("EN PROGRESO")) {
            jcbEdoEvento.setSelectedIndex(0);
        } else if (EstadoEv.equals("FINALIZADO")) {
            jcbEdoEvento.setSelectedIndex(1);
        } else if (EstadoEv.equals("COTIZADO")) {
            jcbEdoEvento.setSelectedIndex(2);
        } else if (EstadoEv.equals("NO COTIZADO")) {
            jcbEdoEvento.setSelectedIndex(3);
        } else {
            jcbEdoEvento.setSelectedIndex(4);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtfIdCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfInvitados = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jcbTipoEvento = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        jcbEdoEvento = new javax.swing.JComboBox<>();
        jComboBox7 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(251, 229, 218));

        jLabel3.setText("CLIENTE:");

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Buttershine", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(241, 172, 133));
        jLabel2.setText("Modificar Evento");

        jtfIdCliente.setEditable(false);
        jtfIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIdClienteActionPerformed(evt);
            }
        });
        jtfIdCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfIdClienteKeyTyped(evt);
            }
        });

        jLabel4.setText("NO. DE INVITADOS: ");

        jtfInvitados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfInvitadosActionPerformed(evt);
            }
        });
        jtfInvitados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfInvitadosKeyTyped(evt);
            }
        });

        jLabel5.setText("TIPO DE EVENTO: ");

        jLabel7.setText("FECHA: ");

        jButton9.setText("BUSCAR");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jcbTipoEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BODA", "XV AÑOS", "BAUTIZO", "CUMPLEAÑOS" }));
        jcbTipoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoEventoActionPerformed(evt);
            }
        });

        jLabel6.setText("ESTADO DE EVENTO: ");

        jTextField13.setColumns(10);
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        jdcFecha.setDateFormatString("yyyy-MM-dd");
        jdcFecha.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel13.setText("Buscar Cliente por:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "ApellidoP", "ApellidoM", "Telefono", "Direccion", "Localidad", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jScrollPane4.setViewportView(jScrollPane3);

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jcbEdoEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EN PROGRESO", "FINALIZADO", "COTIZADO", "NO COTIZADO", "ACEPTADO" }));
        jcbEdoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEdoEventoActionPerformed(evt);
            }
        });

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "ApellidoP", "ApellidoM", "Telefono", "Direccion", "Localidad", "Email" }));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfIdCliente)
                    .addComponent(jtfInvitados)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbTipoEvento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbEdoEvento, 0, 147, Short.MAX_VALUE))
                        .addGap(112, 112, 112))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jcbEdoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfInvitados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jcbTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton9)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnModificar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(2, 2, 2)
                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int opc = JOptionPane.showConfirmDialog(null, "¿Desea volver a la gestión de eventos?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (opc == 0) {
            this.setVisible(false);
            InterfazGestionarEventos GestionEventos = new InterfazGestionarEventos(BD);
            GestionEventos.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtfIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIdClienteActionPerformed

    private void jtfIdClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIdClienteKeyTyped
        int key = evt.getKeyChar();

        boolean n = key >= 48 && key <= 57;

        if (!n)
            evt.consume();
    }//GEN-LAST:event_jtfIdClienteKeyTyped

    private void jtfInvitadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfInvitadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfInvitadosActionPerformed

    private void jtfInvitadosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfInvitadosKeyTyped
        int key = evt.getKeyChar();

        boolean n = key >= 48 && key <= 57;

        if (!n)
            evt.consume();
    }//GEN-LAST:event_jtfInvitadosKeyTyped

    private void jcbTipoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoEventoActionPerformed

    private void jcbEdoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEdoEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbEdoEventoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jtfIdCliente.getText().isEmpty() || jtfInvitados.getText().isEmpty() || jdcFecha.getDateFormatString().isEmpty())
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los datos");
        else {
            String dia = Integer.toString(jdcFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(jdcFecha.getCalendar().get(Calendar.MONTH) + 1);
            String year = Integer.toString(jdcFecha.getCalendar().get(Calendar.YEAR));
            String fecha = (year + "-" + mes + "-" + dia);

            int cli = (int) Cliente[0];
            int inv = Integer.parseInt(jtfInvitados.getText());
            String tipoEve = jcbTipoEvento.getSelectedItem().toString();
            String EdoEve = jcbEdoEvento.getSelectedItem().toString();

            int idEv = (int) Evento[0];
            BD.ModificarEvento(idEv, cli, fecha, inv, tipoEve, EdoEve);
            this.setVisible(false);
            InterfazGestionarEventos GestionEventos = new InterfazGestionarEventos(BD);
            GestionEventos.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int indice = jTable1.rowAtPoint(evt.getPoint());
        Cliente = Clientes.get(indice);
        String cli = (String) Cliente[1];
        jtfIdCliente.setText(cli);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int c = jComboBox7.getSelectedIndex();
        String d = jTextField13.getText();
        if (d.isEmpty()) {
            MostrarCliente();
        } else {
            MostrarCliente(c, d);
        }
        jTable1.setModel(modelo);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JComboBox<String> jcbEdoEvento;
    private javax.swing.JComboBox<String> jcbTipoEvento;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTextField jtfIdCliente;
    private javax.swing.JTextField jtfInvitados;
    // End of variables declaration//GEN-END:variables
}
