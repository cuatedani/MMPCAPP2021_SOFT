package REPORTES;
import SOFTWARE.ConectarBD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfazGenerarFormatoReportes extends javax.swing.JFrame {
    ConectarBD BD;
    DefaultTableModel modelo;
    Object[] Reporte;
    
    public InterfazGenerarFormatoReportes(ConectarBD con, Object[] fila) {
        initComponents();
        BD = con;
        fila = Reporte;
        CrearFormato();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
     
    public void CrearFormato(){
        String form = "";
        ArrayList<Object[]> filas = BD.MostrarFormatoReporte((int) Reporte[0]);
        Object[] columnas = filas.get(0);
        String Fecha = (String) columnas[0];
        String Asunto = (String) columnas[1];
        String Descripcion = (String) columnas[2];
        String Documento = (String) columnas[3];
        String FechaEvento = (String) columnas[4];
        String EventoTipo = (String) columnas[5];
        String EventoEstado = (String) columnas[6];
        String Nombre = (String) columnas[7];
        String Email = (String) columnas[8];
        
        form += "email: " + Email + "\n\n";
        form += "Asunto: " + Asunto + "\n\n";
        form += "Contenido:\n";
        form += "Estimad@: " + Nombre + "\n";
        form += "Me comunico por este medio para darle a conocer que el dia " + Fecha +"\n";
        form += "se realizo " + Descripcion + " correspondiente a\n";
        form += "el evento de " + EventoTipo + " que tiene como fecha el dia\n";
        form += FechaEvento + " el cual se encuentra en el estado de " + EventoEstado + "\n";
        form += "asi como tambien le hago llegar el enlace al documento de comprobante" + Documento + "\n\n";
        form += "De parte de Marina Mesa Wedding y Planing\n";
        
        jtaFormato.setText(form);
    };
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jtaFormato = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(251, 229, 218));

        jLabel2.setFont(new java.awt.Font("Buttershine", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(241, 172, 133));
        jLabel2.setText("Formato De Reporte");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jtaFormato.setEditable(false);
        jtaFormato.setBackground(new java.awt.Color(255, 255, 255));
        jtaFormato.setColumns(20);
        jtaFormato.setRows(5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtaFormato, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(107, 107, 107)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(btnRegresar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jtaFormato, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
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
    int opc = JOptionPane.showConfirmDialog(null, "¿Desea volver a la gestión de Reportes?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (opc == 0) {
            this.setVisible(false);
            InterfazGestionarReportes GestionRepo = new InterfazGestionarReportes (BD);
            GestionRepo.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void tablaRepoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRepoMouseClicked
   
    }//GEN-LAST:event_tablaRepoMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextArea jtaFormato;
    // End of variables declaration//GEN-END:variables
}
