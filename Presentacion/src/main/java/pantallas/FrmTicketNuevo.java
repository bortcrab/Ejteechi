package pantallas;

<<<<<<<< HEAD:Presentacion/src/main/java/pantallas/FrmTicketNuevo.java
import administrarTickets.IAdministrarTickets;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
import excepciones.AdministrarTicketsException;
import java.awt.Color;
import javax.swing.JOptionPane;
import excepciones.PresentacionException;
import java.util.ArrayList;
import java.util.Date;
import org.bson.types.ObjectId;
import utilidades.Validador;

public class FrmTicketNuevo extends javax.swing.JFrame {
    
    private final IAdministrarTickets facadeAdministrarTickets;
    private final UsuarioDTO usuario;
    
    /** Creates new form FrmAtnVistaCliente */
    public FrmTicketNuevo(UsuarioDTO usuario, IAdministrarTickets facadeAdministrarTickets) throws PresentacionException {
        initComponents();
        
        this.facadeAdministrarTickets = facadeAdministrarTickets;
        this.usuario = usuario;
        
        Validador.validarSesion(usuario, this);
    }
    
    private void enviarTicket() {
        try {
            String contenido = areaTicket.getText();
            String emisor = usuario.getNombres() + " " + usuario.getApellidoPaterno();
            ObjectId idUsuario = usuario.getId();
            
            Validador validador = new Validador();
            
            validador.validarTicket(contenido);
            
            TicketDTO ticket = new TicketDTO(
                    contenido,
                    new Date(), 
                    "Pendiente", 
                    idUsuario, 
                    emisor, 
                    new ArrayList<>());
            facadeAdministrarTickets.enviarTicket(ticket);
            
            
            FrmAtnVistaCliente frmAtnAlCliente = new FrmAtnVistaCliente(usuario);
            frmAtnAlCliente.setVisible(true);
            this.dispose();
            JOptionPane.showMessageDialog(this, "¡Ticket enviado!", "¡Yippee!", JOptionPane.INFORMATION_MESSAGE);
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
========
import administrarTickets.FacadeAdministrarTickets;
import administrarTickets.IAdministrarTickets;
import dtos.TicketDTO;
import dtos.UsuarioDTO;
import java.awt.Color;
import javax.swing.JOptionPane;
import excepciones.PresentacionException;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import utilidades.JButtonCellEditor;
import utilidades.JButtonRenderer;
import utilidades.Validador;

public class FrmAtnAlCliente extends javax.swing.JFrame {

    private final IAdministrarTickets facadeAdministrarTickets;
    private final UsuarioDTO usuario;
    private List<TicketDTO> listaTickets;

    /**
     * Creates new form FrmAtnAlCliente
     */
    public FrmAtnAlCliente(UsuarioDTO usuario) throws PresentacionException {
        initComponents();

        this.facadeAdministrarTickets = new FacadeAdministrarTickets();
        this.usuario = usuario;

        Validador.validarSesion(usuario, this);

        // Mandamos a formatear la tabla y a cargar los datos.
        formatearTabla();
        cargarDatos();
    }

    /**
     * Método para cargar los datos de los trámites.
     */
    private void cargarDatos() {
        // Obtenemos la lista de trámites.
        listaTickets = facadeAdministrarTickets.obtenerTickets(usuario);
        llenarTabla(listaTickets);
    }

    /**
     * Método para llenar la tabla de trámites.
     *
     * @param listaTramites Lista de trámites con la que se llenará la tabla.
     */
    private void llenarTabla(List<TicketDTO> listaTickets) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tblTickets.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        for (TicketDTO ticket : listaTickets) {
            Object[] fila = new Object[4];
            fila[0] = ticket.getId();
            fila[1] = ticket.getContenido();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:MM:ss");
            String fecha = formatter.format(ticket.getFecha().getTime());
            fila[2] = fecha;
            fila[3] = ticket.getEstado();

            modeloTabla.addRow(fila);
>>>>>>>> origin/Francisco-Valdez:Presentacion/src/main/java/pantallas/FrmAtnAlCliente.java
        }
        
        tblTickets.setModel(modeloTabla);
    }

    /**
     * Método para darle formato a la tabla.
     */
    private void formatearTabla() {
        // Cambiamos el color del fondo.
        tblTickets.getTableHeader().setBackground(new Color(106, 27, 49));
        // Cambiamos la fuente y el tamaño.
        tblTickets.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 24));
        // Cambiamos el color de la letra.
        tblTickets.getTableHeader().setForeground(new Color(188, 149, 92));
        
        // Creamos el evento de cuando le pican al botón para ver el historial
        // de una persona.
        ActionListener onEditarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Metodo para seleccionar una persona.
                seleccionarTicket();
            }
        };
        int indiceColumnaSeleccionar = 4;
        TableColumnModel modeloColumnas = this.tblTickets.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaSeleccionar).setCellRenderer(new JButtonRenderer("Seleccionar"));
        modeloColumnas.getColumn(indiceColumnaSeleccionar).setCellEditor(new JButtonCellEditor("Seleccionar", onEditarClickListener));
    }
    
    /**
     * Método para seleccionar a una persona de la tabla.
     */
    private void seleccionarTicket() {
        try {
            TicketDTO ticket = listaTickets.get(this.tblTickets.getSelectedRow());
            System.out.println(ticket.getId());
            System.out.println(ticket.getContenido());
            System.out.println(ticket.getFecha());
            System.out.println(ticket.getEstado());
            System.out.println(ticket.getIdUsuario());
            FrmChatTicket frmChatTicket = new FrmChatTicket(usuario, facadeAdministrarTickets, ticket);
            frmChatTicket.setVisible(true);
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

<<<<<<<< HEAD:Presentacion/src/main/java/pantallas/FrmTicketNuevo.java
        jScrollPane2 = new javax.swing.JScrollPane();
        areaTicket = new javax.swing.JTextArea();
        btnCancelar = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
========
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTickets = new javax.swing.JTable();
        btnNuevoTicket = new javax.swing.JButton();
>>>>>>>> origin/Francisco-Valdez:Presentacion/src/main/java/pantallas/FrmAtnAlCliente.java
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

        areaTicket.setColumns(20);
        areaTicket.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        areaTicket.setForeground(new java.awt.Color(0, 0, 0));
        areaTicket.setLineWrap(true);
        areaTicket.setRows(5);
        areaTicket.setWrapStyleWord(true);
        jScrollPane2.setViewportView(areaTicket);

<<<<<<<< HEAD:Presentacion/src/main/java/pantallas/FrmTicketNuevo.java
        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 940, 420));

        btnCancelar.setBackground(new java.awt.Color(255, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar.setFocusable(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 140, 50));

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
        getContentPane().add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 160, 130, 50));
========
        tblTickets.setAutoCreateRowSorter(true);
        tblTickets.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tblTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Folio", "Contenido", "Fecha", "Estado", "Acción"
            }
        ));
        tblTickets.setMaximumSize(new java.awt.Dimension(2147483647, 420));
        tblTickets.setShowGrid(true);
        tblTickets.setShowHorizontalLines(true);
        tblTickets.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblTickets);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 720, 420));

        btnNuevoTicket.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        btnNuevoTicket.setBorder(null);
        btnNuevoTicket.setContentAreaFilled(false);
        btnNuevoTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoTicketActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevoTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 440, 200, 230));
>>>>>>>> origin/Francisco-Valdez:Presentacion/src/main/java/pantallas/FrmAtnAlCliente.java

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

<<<<<<<< HEAD:Presentacion/src/main/java/pantallas/FrmTicketNuevo.java
        fondo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        fondo.setForeground(new java.awt.Color(0, 0, 0));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ticketNuevo.png"))); // NOI18N
========
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoTickets.png"))); // NOI18N
>>>>>>>> origin/Francisco-Valdez:Presentacion/src/main/java/pantallas/FrmAtnAlCliente.java
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

<<<<<<<< HEAD:Presentacion/src/main/java/pantallas/FrmTicketNuevo.java
    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        enviarTicket();
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            FrmAtnVistaCliente frmAtnAlCliente = new FrmAtnVistaCliente(usuario);
            frmAtnAlCliente.setVisible(true);
========
    private void btnNuevoTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoTicketActionPerformed
        try {
            FrmTicketNuevo frmTicketNuevo = new FrmTicketNuevo(usuario, facadeAdministrarTickets);
            frmTicketNuevo.setVisible(true);
>>>>>>>> origin/Francisco-Valdez:Presentacion/src/main/java/pantallas/FrmAtnAlCliente.java
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
<<<<<<<< HEAD:Presentacion/src/main/java/pantallas/FrmTicketNuevo.java
    }//GEN-LAST:event_btnCancelarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTicket;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane2;
========
    }//GEN-LAST:event_btnNuevoTicketActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevoTicket;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
>>>>>>>> origin/Francisco-Valdez:Presentacion/src/main/java/pantallas/FrmAtnAlCliente.java
    private javax.swing.JLabel lblAtnAlCliente;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblCitas;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblMapa;
    private javax.swing.JLabel lblQuejas;
    // End of variables declaration//GEN-END:variables

}
