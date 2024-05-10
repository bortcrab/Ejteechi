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

public class FrmChatTicket extends javax.swing.JFrame {

    private final IAdministrarTickets facadeAdministrarTickets;
    private final IAtenderTickets facadeAtenderTickets;
    private final UsuarioDTO usuario;
    private TicketDTO ticket;

    /**
     * Creates new form FrmAtnVistaCliente
     */
    public FrmChatTicket(UsuarioDTO usuario, IAdministrarTickets facadeAdministrarTickets, IAtenderTickets facadeAtenderTickets, TicketDTO ticket) throws PresentacionException {
        initComponents();

        Validador.validarSesion(usuario, this);

        this.facadeAdministrarTickets = facadeAdministrarTickets;
        this.facadeAtenderTickets = facadeAtenderTickets;
        this.usuario = usuario;
        this.ticket = ticket;

        if (usuario.getTipo().equals("cliente")) {
            btnEstado.setEnabled(false);
            btnEstado.setVisible(false);
            lblAtencionClienteTrabajador.setVisible(false);
        } else {
            lblMapa.setVisible(false);
            lblCitas.setVisible(false);
            lblQuejas.setVisible(false);
            lblAtnAlCliente.setVisible(false);
        }
        
        if (ticket.getEstado().equals("Pendiente")) {
            btnEstado.setText("Marcar como resuelto");
        } else {
            btnEstado.setText("Marcar como pendiente");
            txtMensaje.setEnabled(false);
            btnEnviar.setEnabled(false);
        }

        cargarChat();
    }

    private void cargarChat() {
        jepChat.setText(null);
        String contenidoTicket = ticket.getContenido();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:MM:ss");
        String fechaTicket = formatter.format(ticket.getFecha().getTime());
        List<RespuestaDTO> respuestas = ticket.getRespuestas();
        Encriptador e = new Encriptador();
        String mensajesChat = """
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
                """;

        if (usuario.getTipo().equals("cliente")) {
            mensajesChat
                    += """
                        <div class="cabecera-izquierda">
                            <b>Yo <u>(%s)</u>:</b>
                        </div>
                        <div class="contenido-izquierda">
                            %s
                        </div>
                        <br>
                    """
                            .formatted(fechaTicket, contenidoTicket);
        } else {
            String correoCliente = e.desencriptar(ticket.getUsuario().getCorreo());
            mensajesChat
                    += """
                        <div class="cabecera-derecha">
                            <b>%s <u>(%s)</u>:</b>
                        </div>
                        <div class="contenido-derecha">
                            %s
                        </div>
                        <br>
                    """
                            .formatted(correoCliente, fechaTicket, contenidoTicket);
        }

        for (RespuestaDTO respuesta : respuestas) {
            UsuarioDTO emisor = respuesta.getUsuario();
            String nombreEmisor;
            String fechaRespuesta = formatter.format(respuesta.getFecha().getTime());
            String contenidoRespuesta = respuesta.getContenido();
            String tipoUsuario = usuario.getTipo();
            String tipoEmisor = emisor.getTipo();
            if ((tipoUsuario.equals("cliente") && tipoEmisor.equals("cliente"))
                    || (!tipoUsuario.equals("cliente") && !tipoEmisor.equals("cliente"))) {
                nombreEmisor = "Yo";
                mensajesChat
                        += """
                                <div class="cabecera-izquierda">
                                    <b>%s <u>(%s)</u>:</b>
                                </div>
                                <div class="contenido-izquierda">
                                    %s
                                </div>
                                <br>
                        """
                                .formatted(nombreEmisor, fechaRespuesta, contenidoRespuesta);
            } else {
                if (tipoEmisor.equals("cliente")) {
                    nombreEmisor = e.desencriptar(ticket.getUsuario().getCorreo());
                } else {
                    nombreEmisor = emisor.getNombres() + " " + emisor.getApellidoPaterno();
                }
                mensajesChat
                        += """
                                <div class="cabecera-derecha">
                                    <b>%s <u>(%s)</u>:</b>
                                </div>
                                <div class="contenido-derecha">
                                    %s
                                </div>
                                <br>
                        """
                                .formatted(nombreEmisor, fechaRespuesta, contenidoRespuesta);
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
                    usuario);
            ticket = facadeAdministrarTickets.enviarRespuesta(ticket.getId(), respuesta);
            txtMensaje.setText("");
            this.cargarChat();
            JScrollBar scrollBar = jScrollPane1.getVerticalScrollBar();
            scrollBar.setValue(scrollBar.getMaximum());
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cambiarEstado() {
        if (ticket.getEstado().equals("Pendiente")) { // Si actualmente está pendiente.
            ticket.setEstado("Resuelto");
            facadeAtenderTickets.cambiarEstado(ticket);
            FrmAtnVistaTrabajador frmAtnAlCliente;
            try {
                frmAtnAlCliente = new FrmAtnVistaTrabajador(usuario);
                frmAtnAlCliente.setVisible(true);
            } catch (PresentacionException pe) {
                JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
        } else {                                      // Si actualmente está resuelto.
            ticket.setEstado("Pendiente");
            facadeAtenderTickets.cambiarEstado(ticket);
            btnEstado.setText("Marcar como pendiente");
            txtMensaje.setEnabled(true);
            btnEnviar.setEnabled(true);
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
        btnEstado = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblAtencionClienteTrabajador = new javax.swing.JLabel();
        lblCerrarSesion = new javax.swing.JLabel();
        lblAtnAlCliente = new javax.swing.JLabel();
        lblQuejas = new javax.swing.JLabel();
        lblCitas = new javax.swing.JLabel();
        lblMapa = new javax.swing.JLabel();
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

        btnEstado.setBackground(new java.awt.Color(79, 89, 144));
        btnEstado.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEstado.setForeground(new java.awt.Color(255, 255, 255));
        btnEstado.setText("Marcar como");
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 610, 330, 40));

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

        lblAtencionClienteTrabajador.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAtencionClienteTrabajador.setText("Atención al cliente");
        lblAtencionClienteTrabajador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtencionClienteTrabajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtencionClienteTrabajadorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAtencionClienteTrabajadorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAtencionClienteTrabajadorMouseExited(evt);
            }
        });
        getContentPane().add(lblAtencionClienteTrabajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, 90));

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

        lblAtnAlCliente.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAtnAlCliente.setForeground(new java.awt.Color(0, 0, 0));
        lblAtnAlCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAtnAlCliente.setText("Atención al cliente");
        lblAtnAlCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtnAlCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtnAlClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAtnAlClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAtnAlClienteMouseExited(evt);
            }
        });
        getContentPane().add(lblAtnAlCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 210, 90));

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
        getContentPane().add(lblQuejas, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 90, 70));

        lblCitas.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblCitas.setForeground(new java.awt.Color(0, 0, 0));
        lblCitas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCitas.setText("Citas");
        lblCitas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCitasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCitasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCitasMouseExited(evt);
            }
        });
        getContentPane().add(lblCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 100, 70));

        lblMapa.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblMapa.setForeground(new java.awt.Color(0, 0, 0));
        lblMapa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMapa.setText("Mapa");
        lblMapa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMapaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMapaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMapaMouseExited(evt);
            }
        });
        getContentPane().add(lblMapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 90, 70));

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

    private void lblAtnAlClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtnAlClienteMouseEntered
        lblAtnAlCliente.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblAtnAlClienteMouseEntered

    private void lblAtnAlClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtnAlClienteMouseExited
        lblAtnAlCliente.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblAtnAlClienteMouseExited

    private void lblQuejasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuejasMouseEntered
        lblQuejas.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblQuejasMouseEntered

    private void lblQuejasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuejasMouseExited
        lblQuejas.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblQuejasMouseExited

    private void lblCitasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCitasMouseEntered
        lblCitas.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblCitasMouseEntered

    private void lblCitasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCitasMouseExited
        lblCitas.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblCitasMouseExited

    private void lblMapaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMapaMouseClicked
        try {
            FrmMapa frmMapa = new FrmMapa(usuario);
            frmMapa.setVisible(true);
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_lblMapaMouseClicked

    private void lblMapaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMapaMouseEntered
        lblMapa.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblMapaMouseEntered

    private void lblMapaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMapaMouseExited
        lblMapa.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblMapaMouseExited

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        try {
            FrmHomeCliente frmHome = new FrmHomeCliente(usuario);
            frmHome.setVisible(true);
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCitasMouseClicked
        try {
            FrmCitas frmCitas = new FrmCitas(usuario);
            frmCitas.setVisible(true);
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_lblCitasMouseClicked

    private void lblQuejasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuejasMouseClicked
        try {
            FrmQuejas frmQuejas = new FrmQuejas(usuario);
            frmQuejas.setVisible(true);
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_lblQuejasMouseClicked

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

    private void lblAtnAlClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtnAlClienteMouseClicked
        try {
            FrmAtnVistaCliente frmAtnAlCliente = new FrmAtnVistaCliente(usuario);
            frmAtnAlCliente.setVisible(true);
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_lblAtnAlClienteMouseClicked

    private void txtMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMensajeActionPerformed
        enviarRespuesta();
    }//GEN-LAST:event_txtMensajeActionPerformed

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed
        cambiarEstado();
    }//GEN-LAST:event_btnEstadoActionPerformed

    private void lblAtencionClienteTrabajadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtencionClienteTrabajadorMouseClicked
        try {
            FrmAtnVistaTrabajador frmAtnAlCliente = new FrmAtnVistaTrabajador(usuario);
            frmAtnAlCliente.setVisible(true);
        } catch (PresentacionException pe) {
            // Se muestra un mensaje si no se validó la sesión.
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_lblAtencionClienteTrabajadorMouseClicked

    private void lblAtencionClienteTrabajadorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtencionClienteTrabajadorMouseEntered
        lblAtencionClienteTrabajador.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblAtencionClienteTrabajadorMouseEntered

    private void lblAtencionClienteTrabajadorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtencionClienteTrabajadorMouseExited
        lblAtencionClienteTrabajador.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblAtencionClienteTrabajadorMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnEstado;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane jepChat;
    private javax.swing.JLabel lblAtencionClienteTrabajador;
    private javax.swing.JLabel lblAtnAlCliente;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblCitas;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblMapa;
    private javax.swing.JLabel lblQuejas;
    private javax.swing.JTextField txtMensaje;
    // End of variables declaration//GEN-END:variables

}
