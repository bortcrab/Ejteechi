package pantallas;

import administrarTickets.IAdministrarTickets;
import atenderTickets.IAtenderTickets;
import dtos.RespuestaDTO;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
import java.awt.Color;
import javax.swing.JOptionPane;
import excepciones.PresentacionException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JScrollBar;
import utilidades.Encriptador;
import utilidades.Validador;

public class FrmChatVistaCliente extends javax.swing.JFrame {

    private final IAdministrarTickets facadeAdministrarTickets;
    private final UsuarioDTO usuario;
    private TicketDTO ticket;

    /**
     * Creates new form FrmAtnVistaCliente
     */
    public FrmChatVistaCliente(UsuarioDTO usuario, IAdministrarTickets facadeAdministrarTickets, TicketDTO ticket) throws PresentacionException {
        initComponents();

        Validador.validarSesion(usuario, this);

        this.facadeAdministrarTickets = facadeAdministrarTickets;
        this.usuario = usuario;
        this.ticket = ticket;
        
        cargarChat();
    }

    private void cargarChat() {
        if (ticket.getEstado().equals("Resuelto")) {
            txtMensaje.setEnabled(false);
            btnEnviar.setEnabled(false);
        }
        
        jepChat.setText(null);
        String contenidoTicket = ticket.getContenido();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:MM:ss");
        String fechaTicket = formatter.format(ticket.getFecha().getTime());
        List<RespuestaDTO> respuestas = ticket.getRespuestas();
        String mensajesChat =
                """
                <html>
                    <style>
                        .cabecera-izquierda {
                            background-color: #4F5990;
                            color: white;
                            margin-right: 100px;
                            text-align: left;
                            padding: 5px;
                        }
                
                        .contenido-izquierda {
                            background-color: #C0C5D2;
                            color: black;
                            margin-right: 100px;
                            text-align: justified;
                            padding: 5px;
                        }
                
                        .cabecera-derecha {
                            background-color: #4F5990;
                            color: white;
                            margin-left: 100px;
                            text-align: right;
                            padding: 5px;
                        }

                        .contenido-derecha {
                            background-color: #C0C5D2;
                            color: black;
                            margin-left: 100px;
                            text-align: justified;
                            padding: 5px;
                        }
                    </style>
                    <body>
                        <div class="cabecera-izquierda">
                            <b>Yo <u>(%s)</u>:</b>
                        </div>
                        <div class="contenido-izquierda">
                            %s
                        </div>
                        <br>
                """
                .formatted(fechaTicket, contenidoTicket);

        for (RespuestaDTO respuesta : respuestas) {
            String fechaRespuesta = formatter.format(respuesta.getFecha().getTime());
            String contenidoRespuesta = respuesta.getContenido();
            if (respuesta.getIdEmisor().equals(usuario.getId())) {
                mensajesChat += 
                        """
                        <div class="cabecera-izquierda">
                            <b>Yo <u>(%s)</u>:</b>
                        </div>
                        <div class="contenido-izquierda">
                            %s
                        </div>
                        <br>
                        """
                        .formatted(fechaRespuesta, contenidoRespuesta);
            } else {
                String emisor = respuesta.getEmisor();
                mensajesChat +=
                        """
                        <div class="cabecera-derecha">
                            <b>%s <u>(%s)</u>:</b>
                        </div>
                        <div class="contenido-derecha">
                            %s
                        </div>
                        <br>
                        """
                        .formatted(emisor, fechaRespuesta, contenidoRespuesta);
            }
        }
        mensajesChat = mensajesChat.substring(0, mensajesChat.length() - 4);
        mensajesChat += """
                    </body>
                </html>
                """;
        jepChat.setText(mensajesChat);
    }

    private void enviarRespuesta() {
        try {
            String mensaje = txtMensaje.getText();

            Validador validador = new Validador();

            validador.validarRespuesta(mensaje);
            RespuestaDTO respuesta = new RespuestaDTO(
                    mensaje,
                    new Date(),
                    usuario.getNombres() + " " + usuario.getApellidoPaterno(),
                    usuario.getId());
            ticket = facadeAdministrarTickets.enviarRespuesta(ticket.getId(), respuesta);
            txtMensaje.setText("");
            this.cargarChat();
            JScrollBar scrollBar = jScrollPane1.getVerticalScrollBar();
            scrollBar.setValue(scrollBar.getMaximum());
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jepChat = new javax.swing.JEditorPane("text/html", "");
        jPanel1 = new javax.swing.JPanel();
        txtMensaje = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCerrarSesion = new javax.swing.JLabel();
        lblQuejas = new javax.swing.JLabel();
        lblMapa2 = new javax.swing.JLabel();
        lblAtnAlCliente = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1120, 690));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jepChat.setEditable(false);
        jepChat.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jScrollPane1.setViewportView(jepChat);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 940, 340));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMensajeActionPerformed(evt);
            }
        });
        jPanel1.add(txtMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, 940, 40));

        btnEnviar.setBackground(new java.awt.Color(79, 89, 144));
        btnEnviar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviar.setText("Enviar");
        btnEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEnviar.setFocusable(false);
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 610, 120, 40));

        btnCancelar.setBackground(new java.awt.Color(255, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Volver");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar.setFocusable(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 610, 110, 40));

        lblCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblCerrarSesion.setForeground(new java.awt.Color(0, 0, 0));
        lblCerrarSesion.setText("       Cerrar sesión");
        lblCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseExited(evt);
            }
        });
        getContentPane().add(lblCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 200, 100));

        lblQuejas.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblQuejas.setForeground(new java.awt.Color(0, 0, 0));
        lblQuejas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuejas.setText("Quejas");
        lblQuejas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQuejas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuejasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuejasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuejasMouseExited(evt);
            }
        });
        getContentPane().add(lblQuejas, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 90, 80));

        lblMapa2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblMapa2.setForeground(new java.awt.Color(0, 0, 0));
        lblMapa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMapa2.setText("Mapa");
        lblMapa2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMapa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMapa2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMapa2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMapa2MouseExited(evt);
            }
        });
        getContentPane().add(lblMapa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 90, 80));

        lblAtnAlCliente.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAtnAlCliente.setForeground(new java.awt.Color(0, 0, 0));
        lblAtnAlCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAtnAlCliente.setText("Atención al cliente");
        lblAtnAlCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtnAlCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAtnAlClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAtnAlClienteMouseExited(evt);
            }
        });
        getContentPane().add(lblAtnAlCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 210, 80));

        lblHome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblHome.setForeground(new java.awt.Color(0, 0, 0));
        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });
        getContentPane().add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 220, 100));

        fondo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        fondo.setForeground(new java.awt.Color(0, 0, 0));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ticketChat.png"))); // NOI18N
        fondo.setText("jLabel3");
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 690));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseClicked
        FrmLogin frmLogin = new FrmLogin();
        frmLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblCerrarSesionMouseClicked

    private void lblCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseEntered
        lblCerrarSesion.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblCerrarSesionMouseEntered

    private void lblCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseExited
        lblCerrarSesion.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblCerrarSesionMouseExited

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        try {
            FrmHomeCliente frmHome = new FrmHomeCliente(usuario);
            frmHome.setVisible(true);
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_lblHomeMouseClicked

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        enviarRespuesta();
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            if (usuario.getTipo().equals("cliente")) {
                FrmAtnVistaCliente frmAtnAlCliente = new FrmAtnVistaCliente(usuario);
                frmAtnAlCliente.setVisible(true);
            } else {
                FrmAtnVistaTrabajador frmAtnAlCliente = new FrmAtnVistaTrabajador(usuario);
                frmAtnAlCliente.setVisible(true);
            }
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMensajeActionPerformed
        enviarRespuesta();
    }//GEN-LAST:event_txtMensajeActionPerformed

    private void lblQuejasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuejasMouseClicked
        try {
            FrmQuejas frmQuejas = new FrmQuejas(usuario);
            frmQuejas.setVisible(true);
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_lblQuejasMouseClicked

    private void lblQuejasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuejasMouseEntered
        lblQuejas.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblQuejasMouseEntered

    private void lblQuejasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuejasMouseExited
        lblQuejas.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblQuejasMouseExited

    private void lblMapa2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMapa2MouseClicked
        try {
            FrmMapa frmMapa = new FrmMapa(usuario);
            frmMapa.setVisible(true);
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_lblMapa2MouseClicked

    private void lblMapa2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMapa2MouseEntered
        lblMapa.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblMapa2MouseEntered

    private void lblMapa2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMapa2MouseExited
        lblMapa.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblMapa2MouseExited

    private void lblAtnAlClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtnAlClienteMouseEntered
        lblAtnAlCliente.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblAtnAlClienteMouseEntered

    private void lblAtnAlClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtnAlClienteMouseExited
        lblAtnAlCliente.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblAtnAlClienteMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane jepChat;
    private javax.swing.JLabel lblAtnAlCliente;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblMapa;
    private javax.swing.JLabel lblMapa1;
    private javax.swing.JLabel lblMapa2;
    private javax.swing.JLabel lblQuejas;
    private javax.swing.JTextField txtMensaje;
    // End of variables declaration//GEN-END:variables

}
