package USUARIOS;

import SOFTWARE.ConectarBD;
import SOFTWARE.InterfacePrincipalAdministrador;
import USUARIOS.InterfaceEliminarUsuario;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InterfaceGestionUsuario extends javax.swing.JFrame {

    ConectarBD BD;
    DefaultTableModel modelo;
    ArrayList<Object[]> Usuarios;
    Object[] Usuario;
    

    public InterfaceGestionUsuario(ConectarBD con) {
        initComponents();
        BD = con;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        MostrarUsuario();
        jTable1.setModel(modelo);
    }
    

    public void MostrarUsuario() {
        ArrayList<Object[]> filas = BD.MostrarUsuario();
        Usuarios = filas;
        
        Class[] tiposColumnas = {String.class, String.class, String.class, Integer.class};
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
        modelo.addColumn("Clave");
        modelo.addColumn("Permiso");
        modelo.addColumn("Creador");
        
        for (int f = 0; f < modelo.getRowCount(); f++) {
            modelo.removeRow(f);
        }
        if (!filas.isEmpty()) {
            for (int i = 0; i < filas.size(); i++) {
                Object[] columnas = filas.get(i);

                String col1 = (String) columnas[1];
                String col2 = (String) columnas[2];
                String col3 = (String) columnas[3];
                String col4 = (String) columnas[4];
                
                modelo.addRow(new Object[]{col1, col2, col3, col4});
            }
        }
    }
    
    public void MostrarUsuario(int c, String d) {
        ArrayList<Object[]> filas = BD.MostrarUsuario(c,d);
        Usuarios = filas;
        
        Class[] tiposColumnas = {Integer.class, String.class, String.class, String.class, Integer.class};
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
        modelo.addColumn("Clave");
        modelo.addColumn("Permiso");
        modelo.addColumn("Creador");
        
        for (int f = 0; f < modelo.getRowCount(); f++) {
            modelo.removeRow(f);
        }
        if (!filas.isEmpty()) {
            for (int i = 0; i < filas.size(); i++) {
                Object[] columnas = filas.get(i);

                String col1 = (String) columnas[1];
                String col2 = (String) columnas[2];
                String col3 = (String) columnas[3];
                String col4 = (String) columnas[4];
                
                modelo.addRow(new Object[]{col1, col2, col3, col4});
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcbBuscar = new javax.swing.JComboBox<>();
        btnBuscar3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRegresar2 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jtfBuscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(251, 229, 218));

        jcbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Clave", "Permisos", "Registro" }));
        jcbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBuscarActionPerformed(evt);
            }
        });

        btnBuscar3.setText("BUSCAR");
        btnBuscar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar3ActionPerformed(evt);
            }
        });

        jLabel9.setText("Buscar por:");

        jLabel2.setFont(new java.awt.Font("Buttershine", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(241, 172, 133));
        jLabel2.setText(" Gestionar Usuarios");

        btnRegresar2.setText("REGRESAR");
        btnRegresar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar2ActionPerformed(evt);
            }
        });

        jButton2.setText("MODIFICAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("REGISTRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jtfBuscar.setColumns(10);
        jtfBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(251, 229, 218));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Clave", "Permisos", "Registro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188)
                        .addComponent(btnRegresar2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar3))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(btnRegresar2))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar3)
                    .addComponent(jcbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(Usuario != null ){
            this.setVisible(false);
            InterfaceModificarUsuario ModificarUsuario = new InterfaceModificarUsuario(BD,Usuario);
            ModificarUsuario.setVisible(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Primero Selecciona un Usuario");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        InterfaceRegistrarUsuario RegistrarUsuario = new InterfaceRegistrarUsuario(BD);
        RegistrarUsuario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(Usuario != null ){
            this.setVisible(false);
            InterfaceEliminarUsuario EliminarUsuario = new InterfaceEliminarUsuario(BD,Usuario);
            EliminarUsuario.setVisible(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Primero Selecciona un Usuario");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnRegresar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar2ActionPerformed
        int opc = JOptionPane.showConfirmDialog(null, "¿Desea volver a la pantalla principal?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (opc == 0) {
            this.setVisible(false);
            InterfacePrincipalAdministrador PantallaPrincipal = new InterfacePrincipalAdministrador(BD);
            PantallaPrincipal.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnRegresar2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int indice = jTable1.rowAtPoint(evt.getPoint());
        Usuario = Usuarios.get(indice);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnBuscar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar3ActionPerformed
        int c = jcbBuscar.getSelectedIndex();
        String d = jtfBuscar.getText();
        if (d.isEmpty()) {
            MostrarUsuario();
        } else {
            MostrarUsuario(c, d);
        }
        jTable1.setModel(modelo);
    }//GEN-LAST:event_btnBuscar3ActionPerformed

    private void jtfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarActionPerformed

    private void jcbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar3;
    private javax.swing.JButton btnRegresar2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcbBuscar;
    private javax.swing.JTextField jtfBuscar;
    // End of variables declaration//GEN-END:variables
}
