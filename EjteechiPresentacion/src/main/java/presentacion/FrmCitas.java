package presentacion;

import dto.CitaDTO;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 * @author Juventino López García - 00000248547
 */
public class FrmCitas extends javax.swing.JFrame {

    private final ControlNavegacion control;

    /**
     * Creates new form FrmCItas
     */
    public FrmCitas() {
        initComponents();
        
        this.control = new ControlNavegacion();
        
        cargarDatos();
    }

    public void cargarDatos() {
        List<CitaDTO> listaCitas = new ArrayList<>();
        listaCitas.add(new CitaDTO("1", "12 de mayo de 2024", "INE, Comprobante domicilio", "Juan López"));
        listaCitas.add(new CitaDTO("2", "15 de mayo de 2024", "INE, Comprobante domicilio", "Luisa García"));
        listaCitas.add(new CitaDTO("3", "30 de junio de 2024", "INE", "Juan Pérez"));
        listaCitas.add(new CitaDTO("4", "09 de septiembre de 2024", "Nada", "Raúl Manjarrez"));
        listaCitas.add(new CitaDTO("5", "27 de octubre de 2024", "Comprobante domicilio", "Francisca Torres"));

        DefaultComboBoxModel<CitaDTO> modelo = new DefaultComboBoxModel<>();
        for (CitaDTO cita : listaCitas) {
            modelo.addElement(cita);
        }

        llenarTablaTarifas(listaCitas);
    }

    private void llenarTablaTarifas(List<CitaDTO> listaCitas) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tblCitas.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (listaCitas != null) {
            listaCitas.forEach(row -> {
                Object[] fila = new Object[4];
                fila[0] = row.getNoCita();
                fila[1] = row.getFecha();
                fila[2] = row.getDocumentos();
                fila[3] = row.getAsesor();

                modeloTabla.addRow(fila);
            });
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

        pnlPrincipal = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCitas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        pnlHeader = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblMapa = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblQuejas = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblAtnAlCliente = new javax.swing.JLabel();
        lblCerrarSesion = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnCitas = new javax.swing.JPanel();
        lblCitas = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlPrincipal.setBackground(new java.awt.Color(224, 207, 163));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 72)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Agenda de citas");

        jScrollPane3.setBorder(null);
        jScrollPane3.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(224, 207, 163));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("SansSerif", 0, 30)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(2);
        jTextArea1.setText("Agenda una cita para tramitar o renovar tu tarjeta UNE.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        jTextArea1.setFocusable(false);
        jScrollPane3.setViewportView(jTextArea1);

        tblCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Número de cita", "Fecha", "Documentos", "Asesor"
            }
        ));
        jScrollPane1.setViewportView(tblCitas);

        jButton1.setBackground(new java.awt.Color(34, 34, 34));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(224, 207, 163));
        jButton1.setText("Agendar");

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88))
        );

        getContentPane().add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 48, 1200, 650));

        pnlHeader.setBackground(new java.awt.Color(34, 34, 34));
        pnlHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(224, 207, 163));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlHeader.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 10, 50));

        lblMapa.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblMapa.setForeground(new java.awt.Color(224, 207, 163));
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
        pnlHeader.add(lblMapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 70, 50));

        jPanel3.setBackground(new java.awt.Color(224, 207, 163));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlHeader.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 10, 50));

        lblQuejas.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblQuejas.setForeground(new java.awt.Color(224, 207, 163));
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
        pnlHeader.add(lblQuejas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 90, 50));

        jPanel5.setBackground(new java.awt.Color(224, 207, 163));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlHeader.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 10, 50));

        lblAtnAlCliente.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblAtnAlCliente.setForeground(new java.awt.Color(224, 207, 163));
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
        pnlHeader.add(lblAtnAlCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 210, 50));

        lblCerrarSesion.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblCerrarSesion.setForeground(new java.awt.Color(224, 207, 163));
        lblCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
        pnlHeader.add(lblCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, 160, 50));

        jPanel6.setBackground(new java.awt.Color(224, 207, 163));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlHeader.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 10, 50));

        jPanel7.setBackground(new java.awt.Color(224, 207, 163));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlHeader.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 10, 50));

        jPanel4.setBackground(new java.awt.Color(224, 207, 163));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlHeader.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, 10, 50));

        btnCitas.setBackground(new java.awt.Color(34, 34, 34));
        btnCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCitasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCitasMouseExited(evt);
            }
        });
        btnCitas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCitas.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(224,207,163)));
        lblCitas.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblCitas.setForeground(new java.awt.Color(224, 207, 163));
        lblCitas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCitas.setText("Citas");
        lblCitas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCitas.add(lblCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 70, 30));

        pnlHeader.add(btnCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 70, 50));

        lblHome.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblHome.setForeground(new java.awt.Color(224, 207, 163));
        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setText("Home");
        lblHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHomeMouseExited(evt);
            }
        });
        pnlHeader.add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 50));

        getContentPane().add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblMapaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMapaMouseClicked
        control.cambiarPantalla(this, new FrmMapa());
    }//GEN-LAST:event_lblMapaMouseClicked

    private void lblMapaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMapaMouseEntered
        lblMapa.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblMapaMouseEntered

    private void lblMapaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMapaMouseExited
        lblMapa.setForeground(new Color(224, 207, 163));
    }//GEN-LAST:event_lblMapaMouseExited

    private void lblQuejasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuejasMouseClicked
        control.cambiarPantalla(this, new FrmQuejas());
    }//GEN-LAST:event_lblQuejasMouseClicked

    private void lblQuejasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuejasMouseEntered
        lblQuejas.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblQuejasMouseEntered

    private void lblQuejasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuejasMouseExited
        lblQuejas.setForeground(new Color(224, 207, 163));
    }//GEN-LAST:event_lblQuejasMouseExited

    private void lblAtnAlClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtnAlClienteMouseClicked
        control.cambiarPantalla(this, new FrmAtnAlCliente());
    }//GEN-LAST:event_lblAtnAlClienteMouseClicked

    private void lblAtnAlClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtnAlClienteMouseEntered
        lblAtnAlCliente.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblAtnAlClienteMouseEntered

    private void lblAtnAlClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtnAlClienteMouseExited
        lblAtnAlCliente.setForeground(new Color(224, 207, 163));
    }//GEN-LAST:event_lblAtnAlClienteMouseExited

    private void lblCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseClicked
        control.cambiarPantalla(this, new FrmLogin());
    }//GEN-LAST:event_lblCerrarSesionMouseClicked

    private void lblCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseEntered
        lblCerrarSesion.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblCerrarSesionMouseEntered

    private void lblCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseExited
        lblCerrarSesion.setForeground(new Color(224, 207, 163));
    }//GEN-LAST:event_lblCerrarSesionMouseExited

    private void btnCitasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCitasMouseEntered
        lblCitas.setForeground(Color.WHITE);
        lblCitas.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, java.awt.Color.WHITE));
    }//GEN-LAST:event_btnCitasMouseEntered

    private void btnCitasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCitasMouseExited
        lblCitas.setForeground(new Color(224, 207, 163));
        lblCitas.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(224, 207, 163)));
    }//GEN-LAST:event_btnCitasMouseExited

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        control.cambiarPantalla(this, new FrmHome());
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseEntered
        lblHome.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblHomeMouseEntered

    private void lblHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseExited
        lblHome.setForeground(new Color(224, 207, 163));
    }//GEN-LAST:event_lblHomeMouseExited

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnCitas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblAtnAlCliente;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblCitas;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblMapa;
    private javax.swing.JLabel lblQuejas;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTable tblCitas;
    // End of variables declaration//GEN-END:variables

}