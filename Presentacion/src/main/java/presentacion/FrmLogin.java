package presentacion;

import dtos.ClienteDTO;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class FrmLogin extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public FrmLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRegistrate = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        img = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrate.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btnRegistrate.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegistrate.setText("Registrate");
        btnRegistrate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrateMouseExited(evt);
            }
        });
        jPanel1.add(btnRegistrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 500, 120, 30));
        btnRegistrate.setBorder(BorderFactory.createMatteBorder(0,0,2,0, java.awt.Color.WHITE));

        txtCorreo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 440, 60));

        btnIngresar.setBackground(new java.awt.Color(133, 175, 218));
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setBorder(null);
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresarMouseExited(evt);
            }
        });
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 440, 60));

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 440, 60));

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Group 18 (2).png"))); // NOI18N
        jPanel1.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        ClienteDTO cliente = null;
        FrmHome frmHome = new FrmHome(cliente);
        frmHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseEntered
        // TODO add your handling code here:
        btnIngresar.setForeground(Color.darkGray);
    }//GEN-LAST:event_btnIngresarMouseEntered

    private void btnIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseExited
        // TODO add your handling code here:
        btnIngresar.setForeground(Color.white);
    }//GEN-LAST:event_btnIngresarMouseExited

    private void btnRegistrateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrateMouseClicked
        FrmRegistrar frmRegistrar = new FrmRegistrar();
        frmRegistrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrateMouseClicked

    private void btnRegistrateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrateMouseEntered
        // TODO add your handling code here:
        btnRegistrate.setForeground(Color.BLACK);
        btnRegistrate.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
    }//GEN-LAST:event_btnRegistrateMouseEntered

    private void btnRegistrateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrateMouseExited
        // TODO add your handling code here:
        btnRegistrate.setForeground(Color.WHITE);
        btnRegistrate.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
    }//GEN-LAST:event_btnRegistrateMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel btnRegistrate;
    private javax.swing.JLabel img;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables

}
