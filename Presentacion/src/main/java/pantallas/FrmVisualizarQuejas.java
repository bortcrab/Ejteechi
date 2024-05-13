/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import dtos.QuejaDTO;
import dtos.UsuarioDTO;
import excepciones.PresentacionException;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;
import utilidades.Validador;
import visualizarQuejas.FacadeVisualizarQuejas;
import visualizarQuejas.IVisualizarQuejas;
import visualizarQuejas.VisualizarQuejasException;

/**
 *
 * @author elimo
 */
public class FrmVisualizarQuejas extends javax.swing.JFrame {

    private final IVisualizarQuejas visualizar;
    private UsuarioDTO usuario;

    /**
     * Creates new form FrmVisualizarQuejas
     */
    public FrmVisualizarQuejas(UsuarioDTO usuario) throws PresentacionException {
        initComponents();
        visualizar = new FacadeVisualizarQuejas();
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
                lblMantenimiento.setVisible(true);
                break;
        }

        formatearTabla();
    }

    private void formatearTabla() {
        // Cambiamos el color del fondo.
        tblQuejas.getTableHeader().setBackground(new Color(179, 185, 206));
        // Cambiamos la fuente y el tamaño.
        tblQuejas.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
        // Cambiamos el color de la letra.
        tblQuejas.getTableHeader().setForeground(new Color(0, 0, 0));
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
        lblHome = new javax.swing.JLabel();
        lblCerrarSesion = new javax.swing.JLabel();
        lblQuejas = new javax.swing.JLabel();
        lblAtnCliente = new javax.swing.JLabel();
        lblMantenimiento = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuejas = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        comboBoxFiltro = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnActualizarLectura = new javax.swing.JButton();
        img = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblHome.setForeground(new java.awt.Color(0, 0, 0));
        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });
        jPanel1.add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 220, 110));

        lblCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblCerrarSesion.setForeground(new java.awt.Color(0, 0, 0));
        lblCerrarSesion.setText("Cerrar sesión");
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
        jPanel1.add(lblCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 40, -1, 90));

        lblQuejas.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblQuejas.setText("Ver quejas");
        lblQuejas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQuejas.setPreferredSize(null);
        lblQuejas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuejasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuejasMouseExited(evt);
            }
        });
        lblQuejas.setVisible(false);
        jPanel1.add(lblQuejas, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, 90));

        lblAtnCliente.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAtnCliente.setText("Atención al cliente");
        lblAtnCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtnCliente.setPreferredSize(null);
        lblAtnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtnClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAtnClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAtnClienteMouseExited(evt);
            }
        });
        lblAtnCliente.setVisible(false);
        jPanel1.add(lblAtnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, -1, 90));

        lblMantenimiento.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblMantenimiento.setText("Mantenimiento");
        lblMantenimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMantenimiento.setPreferredSize(null);
        lblMantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMantenimientoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMantenimientoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMantenimientoMouseExited(evt);
            }
        });
        lblMantenimiento.setVisible(false);
        jPanel1.add(lblMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, -1, 90));

        tblQuejas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Queja", "Tipo queja", "Fecha", "Descripción", "ID cliente", "Confirmar lectura"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQuejas.setGridColor(new java.awt.Color(179, 185, 206));
        tblQuejas.setShowGrid(true);
        jScrollPane1.setViewportView(tblQuejas);
        if (tblQuejas.getColumnModel().getColumnCount() > 0) {
            tblQuejas.getColumnModel().getColumn(0).setResizable(false);
            tblQuejas.getColumnModel().getColumn(1).setResizable(false);
            tblQuejas.getColumnModel().getColumn(2).setResizable(false);
            tblQuejas.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 1000, 330));

        btnActualizar.setBackground(new java.awt.Color(0, 0, 102));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar tabla");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 580, 300, 40));

        comboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Elije uno>", "Sugerencia", "Queja por conductor", "Queja por unidad", "Queja por pasajero", "No leidos", "Leidos" }));
        jPanel1.add(comboBoxFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 310, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Filtrar por:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 100, 40));

        btnActualizarLectura.setBackground(new java.awt.Color(0, 0, 102));
        btnActualizarLectura.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnActualizarLectura.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarLectura.setText("Actualizar lectura");
        btnActualizarLectura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarLecturaActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarLectura, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, 300, 40));

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Frame 8 (2).png"))); // NOI18N
        jPanel1.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 1120, 690));

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat formato = new SimpleDateFormat("dd/MMMM/yyyy");
        if (comboBoxFiltro.getSelectedItem().equals("<Elije uno>")) {
            try {
                DefaultTableModel model = (DefaultTableModel) tblQuejas.getModel();
                model.setRowCount(0);
                if (tblQuejas.getRowCount() == 0) {
                    List<QuejaDTO> quejas = visualizar.obtenerTodasLasQuejas();

                    for (QuejaDTO queja : quejas) {

                        Object[] rowData = {
                            queja.getNoQueja(),
                            queja.getTipoQueja(),
                            formato.format(queja.getFecha()),
                            queja.getDescripcion(),
                            queja.getIdCliente(),
                            queja.isLeido()
                        };
                        model.addRow(rowData);
                    }
                }
            } catch (VisualizarQuejasException vqe) {
                JOptionPane.showMessageDialog(this, vqe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else if (!comboBoxFiltro.getSelectedItem().equals("<Elije uno>")) {
            if (!comboBoxFiltro.getSelectedItem().equals("No leidos") || !comboBoxFiltro.getSelectedItem().equals("Leidos")) {
                try {
                    DefaultTableModel model = (DefaultTableModel) tblQuejas.getModel();
                    model.setRowCount(0);
                    if (tblQuejas.getRowCount() == 0) {
                        List<QuejaDTO> quejas = visualizar.obtenerQuejasPorTipo(comboBoxFiltro.getSelectedItem().toString());

                        for (QuejaDTO queja : quejas) {

                            Object[] rowData = {
                                queja.getNoQueja(),
                                queja.getTipoQueja(),
                                formato.format(queja.getFecha()),
                                queja.getDescripcion(),
                                queja.getIdCliente(),
                                queja.isLeido()
                            };
                            model.addRow(rowData);
                        }
                    }
                } catch (VisualizarQuejasException vqe) {
                    JOptionPane.showMessageDialog(this, vqe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (comboBoxFiltro.getSelectedItem().equals("No leidos")) {
                try {
                    DefaultTableModel model = (DefaultTableModel) tblQuejas.getModel();
                    model.setRowCount(0);
                    if (tblQuejas.getRowCount() == 0) {
                        List<QuejaDTO> quejas = visualizar.obtenerQuejasPorEstado(false);

                        for (QuejaDTO queja : quejas) {

                            Object[] rowData = {
                                queja.getNoQueja(),
                                queja.getTipoQueja(),
                                formato.format(queja.getFecha()),
                                queja.getDescripcion(),
                                queja.getIdCliente(),
                                queja.isLeido()
                            };
                            model.addRow(rowData);
                        }
                    }
                } catch (VisualizarQuejasException vqe) {
                    JOptionPane.showMessageDialog(this, vqe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else if (comboBoxFiltro.getSelectedItem().equals("Leidos")) {
                try {
                    DefaultTableModel model = (DefaultTableModel) tblQuejas.getModel();
                    model.setRowCount(0);
                    if (tblQuejas.getRowCount() == 0) {
                        List<QuejaDTO> quejas = visualizar.obtenerQuejasPorEstado(true);

                        for (QuejaDTO queja : quejas) {

                            Object[] rowData = {
                                queja.getNoQueja(),
                                queja.getTipoQueja(),
                                formato.format(queja.getFecha()),
                                queja.getDescripcion(),
                                queja.getIdCliente(),
                                queja.isLeido()
                            };
                            model.addRow(rowData);
                        }
                    }
                } catch (VisualizarQuejasException vqe) {
                    JOptionPane.showMessageDialog(this, vqe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnActualizarLecturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarLecturaActionPerformed

        for (int i = 0; i < tblQuejas.getModel().getRowCount(); i++) {
            boolean confirmacion = (boolean) tblQuejas.getModel().getValueAt(i, 5); // Índice de la columna de confirmación de lectura

            // Si la confirmación de lectura está marcada como verdadera
            if (confirmacion) {
                // Obtener el ID de la queja de la fila actual
                ObjectId idQueja = (ObjectId) tblQuejas.getModel().getValueAt(i, 0); // Índice de la columna del ID de la queja

                QuejaDTO queja = new QuejaDTO();
                queja.setNoQueja(idQueja);
                try {
                    visualizar.confirmarLectura(queja);

                } catch (VisualizarQuejasException ex) {
                    Logger.getLogger(FrmVisualizarQuejas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnActualizarLecturaActionPerformed

    /**
     * Método que reacciona al evento de pasar el mouse por encima del botón de
     * quejas y cambiar su color.
     *
     * @param evt Evento al que se escucha
     */
    private void lblQuejasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuejasMouseEntered
        lblQuejas.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblQuejasMouseEntered

    /**
     * Método que reacciona al evento de que el mouse ya no esté sobre el botón
     * de quejas y cambiar su color.
     *
     * @param evt Evento al que se escucha
     */
    private void lblQuejasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuejasMouseExited
        lblQuejas.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblQuejasMouseExited

    private void lblAtnClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtnClienteMouseClicked
        try {
            FrmAtnVistaTrabajador frmAtnAlCliente = new FrmAtnVistaTrabajador(usuario);
            frmAtnAlCliente.setVisible(true);
        } catch (PresentacionException pe) {
            // Se muestra un mensaje si no se validó la sesión.
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_lblAtnClienteMouseClicked

    /**
     * Método que reacciona al evento de pasar el mouse por encima del botón de
     * atención al cliente y cambiar su color.
     *
     * @param evt Evento al que se escucha
     */
    private void lblAtnClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtnClienteMouseEntered
        lblAtnCliente.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblAtnClienteMouseEntered

    /**
     * Método que reacciona al evento de que el mouse ya no esté sobre el botón
     * de atención al cliente y cambiar su color.
     *
     * @param evt Evento al que se escucha
     */
    private void lblAtnClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtnClienteMouseExited
        lblAtnCliente.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblAtnClienteMouseExited

    /**
     * Método que reacciona al evento de dar clic en el botón para cerrar
     * sesión. Devuelve al usuario al login.
     *
     * @param evt Evento al que se escucha.
     */
    private void lblCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseClicked
        FrmLogin frmLogin = new FrmLogin();
        frmLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblCerrarSesionMouseClicked

    /**
     * Método que reacciona al evento de pasar el mouse por encima del botón de
     * cerrar sesión y cambiar su color.
     *
     * @param evt Evento al que se escucha
     */
    private void lblCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseEntered
        lblCerrarSesion.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblCerrarSesionMouseEntered

    /**
     * Método que reacciona al evento de que el mouse ya no esté sobre el botón
     * de cerrar sesión y cambiar su color.
     *
     * @param evt Evento al que se escucha
     */
    private void lblCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseExited
        lblCerrarSesion.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblCerrarSesionMouseExited

    /**
     * Método que reacciona al evento de que el mouse ya no esté sobre el botón
     * de programar mantenimiento y cambiar su color.
     *
     * @param evt Evento al que se escucha
     */
    private void lblMantenimientoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMantenimientoMouseExited
        lblMantenimiento.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblMantenimientoMouseExited

    /**
     * Método que reacciona al evento de pasar el mouse por encima del botón de
     * programar mantenimiento y cambiar su color.
     *
     * @param evt Evento al que se escucha
     */
    private void lblMantenimientoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMantenimientoMouseEntered
        lblMantenimiento.setForeground(Color.GRAY);
    }//GEN-LAST:event_lblMantenimientoMouseEntered

    /**
     * Método que reacciona al evento de dar clic en el botón para programar el
     * mantenimiento.
     *
     * @param evt Evento al que se escucha.
     */
    private void lblMantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMantenimientoMouseClicked
        try {
            FrmProgramarMantenimiento frmAtnAlCliente = new FrmProgramarMantenimiento(usuario);
            frmAtnAlCliente.setVisible(true);
        } catch (PresentacionException pe) {
            // Se muestra un mensaje si no se validó la sesión.
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_lblMantenimientoMouseClicked

    /**
     * Método que reacciona al evento de dar clic en el botón para ir a la
     * pantalla principal.
     *
     * @param evt Evento al que se escucha.
     */
    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        try {
            FrmHomeTrabajador frmHome = new FrmHomeTrabajador(usuario);
            frmHome.setVisible(true);
        } catch (PresentacionException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage(), "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_lblHomeMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizarLectura;
    private javax.swing.JComboBox<String> comboBoxFiltro;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAtnCliente;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblMantenimiento;
    private javax.swing.JLabel lblQuejas;
    private javax.swing.JTable tblQuejas;
    // End of variables declaration//GEN-END:variables
}
