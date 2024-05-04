package presentacion;

import crearCuenta.CrearCuentaClienteException;
import crearCuenta.FacadeCrearCuentaCliente;
import crearCuenta.ICrearCuentaCliente;
import dtos.UsuarioDTO;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class FrmRegistrar extends javax.swing.JFrame {
    
    private final ICrearCuentaCliente facadeCrearCuentaCliente;
    
    /** Creates new form FrmRegistrar */
    public FrmRegistrar() {
        initComponents();
        
        this.facadeCrearCuentaCliente = new FacadeCrearCuentaCliente();
    }
    
    private void crearCuenta() {
        String correo = txtCorreo.getText().trim();
        String contrasenia1 = new String(pwdContrasenia.getPassword()).trim();
        String contrasenia2 = new String(pwdConfirmarContrasena.getPassword()).trim();
        
        Validador validador = new Validador();
        try {
            validador.validarCorreo(correo);
            validador.validarContrasenia(contrasenia1);
            validador.validarConfirmarContrasenia(contrasenia1, contrasenia2);
            
            UsuarioDTO usuario = new UsuarioDTO(correo, contrasenia1, "cliente");
            
            usuario = facadeCrearCuentaCliente.crearCuenta(usuario);
            
            FrmHomeCliente frmHome = new FrmHomeCliente(usuario);
            frmHome.setVisible(true);
            this.dispose();
            JOptionPane.showMessageDialog(this, "¡Cuenta creada con éxito!", "¡Yippee!", JOptionPane.INFORMATION_MESSAGE);
        } catch (PresentacionException | CrearCuentaClienteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCorreo = new javax.swing.JTextField();
        pwdConfirmarContrasena = new javax.swing.JPasswordField();
        pwdContrasenia = new javax.swing.JPasswordField();
        btnCrearCuenta = new javax.swing.JButton();
        btnYaTengoCuenta = new javax.swing.JLabel();
        img = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCorreo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 420, 70));
        jPanel1.add(pwdConfirmarContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 420, 70));
        jPanel1.add(pwdContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 420, 70));

        btnCrearCuenta.setBackground(new java.awt.Color(133, 175, 218));
        btnCrearCuenta.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCrearCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearCuenta.setText("Crear cuenta");
        btnCrearCuenta.setBorder(null);
        btnCrearCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearCuentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearCuentaMouseExited(evt);
            }
        });
        btnCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrearCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 540, 420, 70));

        btnYaTengoCuenta.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btnYaTengoCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnYaTengoCuenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnYaTengoCuenta.setText("Ya tengo una cuenta");
        btnYaTengoCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnYaTengoCuentaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnYaTengoCuentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnYaTengoCuentaMouseExited(evt);
            }
        });
        jPanel1.add(btnYaTengoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 630, 240, 30));
        btnYaTengoCuenta.setBorder(BorderFactory.createMatteBorder(0,0,2,0, java.awt.Color.WHITE));

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Frame 2 (3).png"))); // NOI18N
        jPanel1.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 690));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 690));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaActionPerformed
        crearCuenta();
    }//GEN-LAST:event_btnCrearCuentaActionPerformed

    private void btnCrearCuentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearCuentaMouseEntered
        // TODO add your handling code here:
        btnCrearCuenta.setForeground(Color.darkGray);
    }//GEN-LAST:event_btnCrearCuentaMouseEntered

    private void btnCrearCuentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearCuentaMouseExited
        // TODO add your handling code here:
        btnCrearCuenta.setForeground(Color.white);
    }//GEN-LAST:event_btnCrearCuentaMouseExited

    private void btnYaTengoCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnYaTengoCuentaMouseClicked
        FrmLogin frmLogin = new FrmLogin();
        frmLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnYaTengoCuentaMouseClicked

    private void btnYaTengoCuentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnYaTengoCuentaMouseEntered
        // TODO add your handling code here:
        btnYaTengoCuenta.setForeground(Color.BLACK);
        btnYaTengoCuenta.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.BLACK));
    }//GEN-LAST:event_btnYaTengoCuentaMouseEntered

    private void btnYaTengoCuentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnYaTengoCuentaMouseExited
        // TODO add your handling code here:
        btnYaTengoCuenta.setForeground(Color.WHITE);
        btnYaTengoCuenta.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.WHITE));
    }//GEN-LAST:event_btnYaTengoCuentaMouseExited

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JLabel btnYaTengoCuenta;
    private javax.swing.JLabel img;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pwdConfirmarContrasena;
    private javax.swing.JPasswordField pwdContrasenia;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables

}
