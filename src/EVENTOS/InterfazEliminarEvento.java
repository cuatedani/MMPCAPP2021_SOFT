package EVENTOS;

import SOFTWARE.ConectarBD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfazEliminarEvento extends javax.swing.JFrame {

    ConectarBD BD;
    Object[] Evento;

    public InterfazEliminarEvento(ConectarBD con, Object[] filas) {
        initComponents();
        BD = con;
        Evento = filas;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        MostrarDatos();
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
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfInvitados = new javax.swing.JTextField();
        jcbTipoEvento = new javax.swing.JComboBox<>();
        jtfIdCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcbEdoEvento = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(251, 229, 218));

        jLabel5.setText("NO. DE INVITADOS: ");

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Buttershine", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(241, 172, 133));
        jLabel2.setText("Eliminar Evento");

        jButton1.setText("ELIMINAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("FECHA: ");

        jLabel8.setText("TIPO DE EVENTO: ");

        jtfInvitados.setEditable(false);
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

        jcbTipoEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BODA", "XV AÑOS", "BAUTIZO", "CUMPLEAÑOS" }));
        jcbTipoEvento.setEnabled(false);
        jcbTipoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoEventoActionPerformed(evt);
            }
        });

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

        jLabel4.setText("CLIENTE: ");

        jcbEdoEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EN PROGRESO", "FINALIZADO", "COTIZADO", "NO COTIZADO", "ACEPTADO" }));
        jcbEdoEvento.setEnabled(false);
        jcbEdoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEdoEventoActionPerformed(evt);
            }
        });

        jLabel6.setText("ESTADO DE EVENTO: ");

        jdcFecha.setDateFormatString("yyyy-MM-dd");
        jdcFecha.setEnabled(false);
        jdcFecha.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(142, 142, 142)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfIdCliente)
                            .addComponent(jcbTipoEvento, 0, 174, Short.MAX_VALUE)
                            .addComponent(jtfInvitados))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jcbEdoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbEdoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jtfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jcbTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfInvitados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButton1)))
                .addContainerGap(70, Short.MAX_VALUE))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int opc = JOptionPane.showConfirmDialog(null, "¿Desea volver a la gestión de eventos?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (opc == 0) {
            this.setVisible(false);
            InterfazGestionarEventos GestionEventos = new InterfazGestionarEventos(BD);
            GestionEventos.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int id = (int) Evento[0];
        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Desea Eliminar Evento seleccionado?", "Mensaje de Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            BD.EliminarEvento(id);
            this.setVisible(false);
            InterfazGestionarEventos GestionEventos = new InterfazGestionarEventos(BD);
            GestionEventos.setVisible(true);
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jcbEdoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEdoEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbEdoEventoActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcbEdoEvento;
    private javax.swing.JComboBox<String> jcbTipoEvento;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTextField jtfIdCliente;
    private javax.swing.JTextField jtfInvitados;
    // End of variables declaration//GEN-END:variables
}
