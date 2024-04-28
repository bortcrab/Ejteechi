package presentacion;

import dtos.QuejaDTO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class FrmQuejas extends javax.swing.JFrame {

    private final ControlNavegacion control;

    /**
     * Creates new form FrmQuejas
     */
    public FrmQuejas() {
        initComponents();
        
        this.control = new ControlNavegacion();
        
        cargarDatos();
    }

    public void cargarDatos() {
        List<QuejaDTO> listaQuejas = new ArrayList<>();
        listaQuejas.add(new QuejaDTO("1", "12 de mayo de 2023", "No me gusta que los camiones están en condiciones."));
        listaQuejas.add(new QuejaDTO("2", "15 de mayo de 2023", "Tarda mucho en llegar la línea 10."));
        listaQuejas.add(new QuejaDTO("3", "30 de junio de 2023", "Un chofer de la línea 3 me dijo cosas feas."));
        listaQuejas.add(new QuejaDTO("4", "09 de septiembre de 2023", "No hay suficientes paradas de la línea 3."));
        listaQuejas.add(new QuejaDTO("5", "27 de octubre de 2023", "No me gusta el apartado del mapa, se me hace complicado."));

        DefaultComboBoxModel<QuejaDTO> modelo = new DefaultComboBoxModel<>();
        for (QuejaDTO queja : listaQuejas) {
            modelo.addElement(queja);
        }

        llenarTablaTarifas(listaQuejas);
    }

    private void llenarTablaTarifas(List<QuejaDTO> listaQuejas) {

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
        jLabelMapa = new javax.swing.JLabel();
        jLabelInicio = new javax.swing.JLabel();
        jLabelQuejas = new javax.swing.JLabel();
        jLabelAtnCliente = new javax.swing.JLabel();
        jLabelCerrarSesion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnAnonimo = new javax.swing.JRadioButton();
        jComboBoxTipoQueja = new javax.swing.JComboBox<>();
        img = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMapa.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelMapa.setText("Mapa");
        jLabelMapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMapaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMapaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMapaMouseExited(evt);
            }
        });
        jPanel1.add(jLabelMapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 90, 70));

        jLabelInicio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelInicio.setText("Inicio");
        jLabelInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelInicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelInicioMouseExited(evt);
            }
        });
        jPanel1.add(jLabelInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 90, 70));

        jLabelQuejas.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelQuejas.setText("Quejas");
        jLabelQuejas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelQuejasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelQuejasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelQuejasMouseExited(evt);
            }
        });
        jPanel1.add(jLabelQuejas, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 90, 70));

        jLabelAtnCliente.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelAtnCliente.setText("Atención al cliente");
        jLabelAtnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAtnClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAtnClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAtnClienteMouseExited(evt);
            }
        });
        jPanel1.add(jLabelAtnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 210, 90));

        jLabelCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelCerrarSesion.setText("Cerrar sesión");
        jLabelCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCerrarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelCerrarSesionMouseExited(evt);
            }
        });
        jPanel1.add(jLabelCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 40, 150, 90));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 690, 280));

        btnAnonimo.setText("Enviar como anónimo");
        jPanel1.add(btnAnonimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        jComboBoxTipoQueja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Elija uno>", "Sugerencia", "Queja por conductor", "Queja por unidad", "Queja por pasajero" }));
        jPanel1.add(jComboBoxTipoQueja, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 290, 220, -1));

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Frame 5 (2).png"))); // NOI18N
        jPanel1.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 700));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInicioMouseClicked
        // TODO add your handling code here:
        control.cambiarPantalla(this, new FrmHome());
        
    }//GEN-LAST:event_jLabelInicioMouseClicked

    private void jLabelQuejasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelQuejasMouseClicked
        // TODO add your handling code here:
        jLabelInicio.setForeground(Color.WHITE);
    }//GEN-LAST:event_jLabelQuejasMouseClicked

    private void jLabelAtnClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAtnClienteMouseClicked
        // TODO add your handling code here:
        control.cambiarPantalla(this, new FrmAtnAlCliente());
    }//GEN-LAST:event_jLabelAtnClienteMouseClicked

    private void jLabelCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCerrarSesionMouseClicked
        // TODO add your handling code here:
        control.cambiarPantalla(this, new FrmLogin());
        
    }//GEN-LAST:event_jLabelCerrarSesionMouseClicked

    private void jLabelInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInicioMouseEntered
        // TODO add your handling code here:
        
        jLabelInicio.setForeground(Color.GRAY);
    }//GEN-LAST:event_jLabelInicioMouseEntered

    private void jLabelMapaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMapaMouseClicked
        // TODO add your handling code here:
        control.cambiarPantalla(this, new FrmMapa());
        
    }//GEN-LAST:event_jLabelMapaMouseClicked

    private void jLabelInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInicioMouseExited
        // TODO add your handling code here:
        jLabelInicio.setForeground(Color.black);
    }//GEN-LAST:event_jLabelInicioMouseExited

    private void jLabelMapaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMapaMouseEntered
        // TODO add your handling code here:
        jLabelMapa.setForeground(Color.gray);
    }//GEN-LAST:event_jLabelMapaMouseEntered

    private void jLabelMapaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMapaMouseExited
        // TODO add your handling code here:
        jLabelMapa.setForeground(Color.black);
    }//GEN-LAST:event_jLabelMapaMouseExited

    private void jLabelQuejasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelQuejasMouseEntered
        // TODO add your handling code here:
        jLabelQuejas.setForeground(Color.GRAY);
    }//GEN-LAST:event_jLabelQuejasMouseEntered

    private void jLabelQuejasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelQuejasMouseExited
        // TODO add your handling code here:
        jLabelQuejas.setForeground(Color.black);
    }//GEN-LAST:event_jLabelQuejasMouseExited

    private void jLabelAtnClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAtnClienteMouseEntered
        // TODO add your handling code here:
         jLabelAtnCliente.setForeground(Color.GRAY);
    }//GEN-LAST:event_jLabelAtnClienteMouseEntered

    private void jLabelAtnClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAtnClienteMouseExited
        // TODO add your handling code here:
         jLabelAtnCliente.setForeground(Color.black);
    }//GEN-LAST:event_jLabelAtnClienteMouseExited

    private void jLabelCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCerrarSesionMouseEntered
        // TODO add your handling code here:
        jLabelCerrarSesion.setForeground(Color.GRAY);
    }//GEN-LAST:event_jLabelCerrarSesionMouseEntered

    private void jLabelCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCerrarSesionMouseExited
        // TODO add your handling code here:
        jLabelCerrarSesion.setForeground(Color.black);
    }//GEN-LAST:event_jLabelCerrarSesionMouseExited

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnAnonimo;
    private javax.swing.JLabel img;
    private javax.swing.JComboBox<String> jComboBoxTipoQueja;
    private javax.swing.JLabel jLabelAtnCliente;
    private javax.swing.JLabel jLabelCerrarSesion;
    private javax.swing.JLabel jLabelInicio;
    private javax.swing.JLabel jLabelMapa;
    private javax.swing.JLabel jLabelQuejas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
