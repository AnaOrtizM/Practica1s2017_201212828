/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import ListaSimplePalabras.LSPalabras;
import ColaFichas.CFichas;
import ListaCircularJugadores.LCJugadores;
import ListaSimpleMano.LSMano;
import MatrizTablero.Ficha;
import MatrizTablero.MTablero;
import Utils.XMLParser;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author ana_j
 */
public class JFTablero extends javax.swing.JFrame {

    /**
     * Creates new form JFTablero
     */
    public LCJugadores lcj = JFIngresoJugadores.lcj;
    public static CFichas cfichas;
    public static LSMano lsmano;
    public static MTablero matriz;
    public LSPalabras lsp = XMLParser.lsp;

    public final int TAM_TAB_X = 10;
    public final int TAM_TAB_Y = 10;
    public final int POS_TAB_X = 10;
    public final int POS_TAB_Y = 10;
    public final int TAM_FIC_X = 50;
    public final int TAM_FIC_Y = 50;
    public final int POS_FIC_X = 50;
    public final int POS_FIC_Y = 20;

    JPanel paneltablero;

    public JFTablero() {
        initComponents();
        initComponentsTablero();

        /**
         * ******** Cambiar la imagen del icono *********
         */
        URL url = getClass().getResource("/Imagenes/icon.jpg");
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());

        /**
         * ******** Colocar una imagen de fondo *********
         */
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Imagenes/dark-green.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);;
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
    }

    public void initComponentsTablero() {
        matriz = new MTablero(15, 15);

        //Iniciamos la cola
        cfichas = new CFichas();
        cfichas.Fichas();
        lsmano = new LSMano();

        paneltablero = new JPanel();
        paneltablero.setLayout(null);
        Border outsideBorder = new LineBorder(Color.black);
        paneltablero.setBorder(outsideBorder);
        paneltablero.setBounds(POS_TAB_X, POS_TAB_Y, matriz.x * Ficha.TAM_FICHA, matriz.y * Ficha.TAM_FICHA + Ficha.TAM_FICHA * 3);

        pintarFichasJugador();
        matriz.pintarTablero(paneltablero);
        this.add(paneltablero);
    }

    public void pintarFichasJugador() {

        for (int i = 0; i < 7; i++) {
            Ficha f = cfichas.Pop();
            f.getLabelFicha().setLabelBounds(i + 1, matriz.y + 1);
            lsmano.insertarFinal(f);
        }

        lsmano.pintarFichasTablero(paneltablero);
    }

    public void masFichasJugador() {

        for (int i = lsmano.tam; i < 7; i++) {
            Ficha f = cfichas.Pop();
            f.getLabelFicha().setLabelBounds(i + 1, matriz.y + 1);
            lsmano.insertarFinal(f);
        }
        lsmano.pintarFichasTablero(paneltablero);
        paneltablero.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMostrarReportes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPalabraNueva = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnValidarTiro = new javax.swing.JButton();
        btnPedirFichas = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblRPalabras = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblRJugadores = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lblRFichas = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lblRMano = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lblRMatriz = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCRABBLE");
        setExtendedState(6);

        btnMostrarReportes.setBackground(new java.awt.Color(255, 153, 153));
        btnMostrarReportes.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnMostrarReportes.setText("MOSTRAR REPORTES");
        btnMostrarReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarReportesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("TURNO:");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 204));
        jLabel2.setText("PUNTUACIÓN:");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 204));
        jLabel3.setText("NUEVA PALABRA");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtPalabraNueva.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        btnAgregar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnValidarTiro.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnValidarTiro.setText("VALIDAR TIRO");
        btnValidarTiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarTiroActionPerformed(evt);
            }
        });

        btnPedirFichas.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnPedirFichas.setText("PEDIR MAS FICHAS");
        btnPedirFichas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedirFichasActionPerformed(evt);
            }
        });

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        lblRPalabras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane1.setViewportView(lblRPalabras);

        jTabbedPane1.addTab("Lista Palabras", jScrollPane1);

        lblRJugadores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane2.setViewportView(lblRJugadores);

        jTabbedPane1.addTab("Lista Jugadores", jScrollPane2);

        lblRFichas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRFichas.setToolTipText("");
        jScrollPane3.setViewportView(lblRFichas);

        jTabbedPane1.addTab("Cola Fichas", jScrollPane3);

        lblRMano.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane4.setViewportView(lblRMano);

        jTabbedPane1.addTab("Lista Mano", jScrollPane4);

        lblRMatriz.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane5.setViewportView(lblRMatriz);

        jTabbedPane1.addTab("Matriz Tablero", jScrollPane5);

        jMenu1.setText("Ayuda");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1487488768_Info_Circle_Symbol_Information_Letter.png"))); // NOI18N
        jMenuItem1.setText("Valor Fichas");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(213, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnValidarTiro, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtPalabraNueva, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPedirFichas))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnMostrarReportes)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(btnMostrarReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPalabraNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addComponent(btnValidarTiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPedirFichas))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTabbedPane1)))
                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarReportesActionPerformed
        // TODO add your handling code here:
        lcj.Graficar();
        cfichas.Graficar();
        lsmano.Graficar();
        lsp.Graficar();
        matriz.graficarMatriz();
    }//GEN-LAST:event_btnMostrarReportesActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        lsp.insertarFinal(txtPalabraNueva.getText());
        txtPalabraNueva.setText("");
        lsp.Mostrar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnValidarTiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarTiroActionPerformed
        // TODO add your handling code here:
        lsmano.ValidarTiro();
    }//GEN-LAST:event_btnValidarTiroActionPerformed

    private void btnPedirFichasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedirFichasActionPerformed
        // TODO add your handling code here:
        this.masFichasJugador();
    }//GEN-LAST:event_btnPedirFichasActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        mostrarReportes();
    }//GEN-LAST:event_jTabbedPane1StateChanged

    public void mostrarReportes() {
        System.out.println(this.jTabbedPane1.getSelectedIndex() + "--");
        int pestaña = this.jTabbedPane1.getSelectedIndex();

        /**
         * velocidad en segundos *
         */
        int velocidad = 5;

        /**
         * velocidad en milisegundos *
         */
        int velMili = velocidad * 1000;

        Timer timer;
        TimerTask tarea;

        tarea = new TimerTask() {
            @Override
            public void run() {

                switch (pestaña) {
                    case 0:
                        lsp.Graficar();
                         {
                            try {
                                lblRPalabras.setIcon(new ImageIcon(ImageIO.read(new File(System.getProperty("user.home") + File.separator + "SalidasDot" + File.separator + "LSPalabras.png"))));
                            } catch (IOException ex) {
                                Logger.getLogger(JFTablero.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    case 1:
                        lcj.Graficar();
                         {
                            try {
                                lblRJugadores.setIcon(new ImageIcon(ImageIO.read(new File(System.getProperty("user.home") + File.separator + "SalidasDot" + File.separator + "LCJugadores.png"))));
                            } catch (IOException ex) {
                                Logger.getLogger(JFTablero.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    case 2:
                        cfichas.Graficar();
                         {
                            try {
                                lblRFichas.setIcon(new ImageIcon(ImageIO.read(new File(System.getProperty("user.home") + File.separator + "SalidasDot" + File.separator + "CFichas.png"))));
                            } catch (IOException ex) {
                                Logger.getLogger(JFTablero.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    case 3:
                        lsmano.Graficar();
                         {
                            try {
                                lblRMano.setIcon(new ImageIcon(ImageIO.read(new File(System.getProperty("user.home") + File.separator + "SalidasDot" + File.separator + "LSMano.png"))));
                            } catch (IOException ex) {
                                Logger.getLogger(JFTablero.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    case 4:
                        matriz.graficarMatriz();
                         {
                            try {
                                lblRMatriz.setIcon(new ImageIcon(ImageIO.read(new File(System.getProperty("user.home") + File.separator + "SalidasDot" + File.separator + "MTablero.png"))));
                            } catch (IOException ex) {
                                Logger.getLogger(JFTablero.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                }
            }
        };

        timer = new Timer();
        timer.scheduleAtFixedRate(tarea, velMili, velMili);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFTablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnMostrarReportes;
    private javax.swing.JButton btnPedirFichas;
    private javax.swing.JButton btnValidarTiro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblRFichas;
    private javax.swing.JLabel lblRJugadores;
    private javax.swing.JLabel lblRMano;
    private javax.swing.JLabel lblRMatriz;
    private javax.swing.JLabel lblRPalabras;
    private javax.swing.JTextField txtPalabraNueva;
    // End of variables declaration//GEN-END:variables
}
