package pantallas;

import administrarQuejas.IAdministrarQuejas;
import administrarTickets.FacadeAdministrarTickets;
import administrarTickets.IAdministrarTickets;
import atenderTickets.FacadeAtenderTickets;
import atenderTickets.IAtenderTickets;
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

public class FrmAtnVistaTrabajador extends javax.swing.JFrame {

    private final IAdministrarTickets facadeAdministrarTickets;
    private final IAtenderTickets facadeAtenderTickets;
    private final UsuarioDTO usuario;
    private List<TicketDTO> listaTickets;

    /**
     * Creates new form FrmAtnAlCliente
     */
    public FrmAtnVistaTrabajador(UsuarioDTO usuario) throws PresentacionException {
        initComponents();

        this.facadeAdministrarTickets = new FacadeAdministrarTickets();
        this.facadeAtenderTickets = new FacadeAtenderTickets();
        this.usuario = usuario;

        Validador.validarSesion(usuario, this);
        
        switch (usuario.getTipo()) {
            case "AACC":
                lblQuejas.setVisible(true);
                lblAtnCliente.setVisible(true);
                break;
            case "GERE":
                lblQuejas.setVisible(true);
                lblAtnCliente.setVisible(true);
                lblMantenimiento1.setVisible(true);
                break;
        }

        // Mandamos a formatear la tabla y a cargar los datos.
        formatearTabla();
        cargarTickets();
    }

    /**
     * Método para cargar los datos de los trámites.
     */
    private void cargarTickets() {
        // Obtenemos la lista de trámites.
        listaTickets = facadeAtenderTickets.obtenerTodosTickets(usuario.getId());
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
            fila[0] = ticket.getId().toString();
            fila[1] = ticket.getContenido();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:MM:ss");
            String fecha = formatter.format(ticket.getFecha().getTime());
            fila[2] = fecha;
            fila[3] = ticket.getEstado();

            modeloTabla.addRow(fila);
        }
        
        tblTickets.setModel(modeloTabla);
    }

    /**
     * Método para darle formato a la tabla.
     */
    private void formatearTabla() {
        // Cambiamos el color del fondo.
        tblTickets.getTableHeader().setBackground(new Color(79,89,144));
        // Cambiamos la fuente y el tamaño.
        tblTickets.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 24));
        // Cambiamos el color de la letra.
        tblTickets.getTableHeader().setForeground(new Color(255, 255, 255));
        
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
            FrmChatVistaTrabajador frmChatTicket = new FrmChatVistaTrabajador(usuario, facadeAtenderTickets, ticket);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTickets = new javax.swing.JTable();
        lblCerrarSesion = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        lblQuejas = new javax.swing.JLabel();
        lblAtnCliente = new javax.swing.JLabel();
        lblMantenimiento1 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1120, 690));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 80));

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
        tblTickets.setGridColor(new java.awt.Color(79, 89, 144));
        tblTickets.setMaximumSize(new java.awt.Dimension(2147483647, 420));
        tblTickets.setShowGrid(true);
        tblTickets.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblTickets);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 940, 420));

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

        lblHome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblHome.setForeground(new java.awt.Color(0, 0, 0));
        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });
        getContentPane().add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 230, 100));

        lblQuejas.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblQuejas.setText("Ver quejas");
        lblQuejas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQuejas.setPreferredSize(null);
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
        lblQuejas.setVisible(false);
        getContentPane().add(lblQuejas, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, 100));

        lblAtnCliente.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAtnCliente.setText("Atención al cliente");
        lblAtnCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtnCliente.setPreferredSize(null);
        lblAtnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAtnClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAtnClienteMouseExited(evt);
            }
        });
        lblAtnCliente.setVisible(false);
        getContentPane().add(lblAtnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, 100));

        lblMantenimiento1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblMantenimiento1.setText("Mantenimiento");
        lblMantenimiento1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMantenimiento1.setPreferredSize(null);
        lblMantenimiento1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMantenimiento1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMantenimiento1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMantenimiento1MouseExited(evt);
            }
        });
        lblMantenimiento1.setVisible(false);
        getContentPane().add(lblMantenimiento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, 100));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoTicketsTrabajador.png"))); // NOI18N
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
            FrmHomeTrabajador frmHome = new FrmHomeTrabajador(usuario);
            frmHome.setVisible(true);
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblQuejasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuejasMouseClicked
        try {
            FrmVisualizarQuejas frmAtnAlCliente = new FrmVisualizarQuejas(usuario);
            frmAtnAlCliente.setVisible(true);
        } catch (PresentacionException pe) {
            // Se muestra un mensaje si no se validó la sesión.
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

    private void lblAtnClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtnClienteMouseEntered
        lblAtnCliente.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblAtnClienteMouseEntered

    private void lblAtnClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtnClienteMouseExited
        lblAtnCliente.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblAtnClienteMouseExited

    private void lblMantenimiento1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMantenimiento1MouseClicked
        try {
            FrmProgramarMantenimiento frmAtnAlCliente = new FrmProgramarMantenimiento(usuario);
            frmAtnAlCliente.setVisible(true);
        } catch (PresentacionException pe) {
            // Se muestra un mensaje si no se validó la sesión.
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_lblMantenimiento1MouseClicked

    private void lblMantenimiento1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMantenimiento1MouseEntered
        lblMantenimiento1.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblMantenimiento1MouseEntered

    private void lblMantenimiento1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMantenimiento1MouseExited
        lblMantenimiento1.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblMantenimiento1MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAtnCliente;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblMantenimiento1;
    private javax.swing.JLabel lblQuejas;
    private javax.swing.JTable tblTickets;
    // End of variables declaration//GEN-END:variables

}
