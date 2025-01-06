
package Windows;

import Ahorcado.Messages;
import Ahorcado.SoundEffect;
import DataStructures.LSEC;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Start extends javax.swing.JFrame {
    
    protected static SoundEffect soundStart = new SoundEffect("startG");
    
    public Start() {
        //Maximized Window
        initComponents();
        GraphicsEnvironment env =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        this.setResizable(false);
        ImageIcon titleJuego= new ImageIcon(getClass().getResource("/Images/juego_del_ahorcado.png"));
        this.titleLabel.setIcon(new ImageIcon(titleJuego.getImage().
                getScaledInstance(titleLabel.getWidth(),titleLabel.getHeight(), Image.SCALE_SMOOTH)));
        
        ImageIcon startStickman= new ImageIcon(getClass().getResource("/Images/stick7.png"));
        this.startStickmanLabel.setIcon(new ImageIcon(startStickman.getImage().
                getScaledInstance(startStickmanLabel.getWidth(),startStickmanLabel.getHeight(), Image.SCALE_DEFAULT)));
        
        this.repaint();
        soundStart.play(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        startStickmanLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        salirButton = new javax.swing.JButton();
        jugarButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(6);
        setPreferredSize(new java.awt.Dimension(2560, 1440));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(startStickmanLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 360, 370));
        jPanel1.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 920, 120));

        salirButton.setBackground(new java.awt.Color(255, 51, 51));
        salirButton.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        salirButton.setText("SALIR");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });
        jPanel1.add(salirButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 720, 160, 50));

        jugarButton.setBackground(new java.awt.Color(255, 153, 51));
        jugarButton.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        jugarButton.setText("JUGAR");
        jugarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(jugarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 620, 160, 50));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.jpg"))); // NOI18N
        background.setAlignmentY(0.0F);
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
    }// </editor-fold>//GEN-END:initComponents
    
    private void jugarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarButtonActionPerformed
        resetOptionsWindow();
        resetRunningWindow();
        resetEndWindow();
        this.dispose(); //Close window and any memory it consumes will be
                        //returned to the OS
    }//GEN-LAST:event_jugarButtonActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        JFrame frame = new JFrame("EXIT");
        if(JOptionPane.showConfirmDialog(frame, Messages.ALERT.EXIT.tx(), 
           Messages.ALERT.ALERT_.tx(),JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
            System.exit(0);
    }//GEN-LAST:event_salirButtonActionPerformed
    
    private void resetOptionsWindow(){
        Options.options = new Options();
        Options.options.setVisible(true);
        Options.playersList = new LSEC();
        Options.addedWordsList = new LSEC();
    }
    
    private void resetRunningWindow(){
        Running.playersList = new LSEC();
        Running.addedWordsList = new LSEC();
    }
    
    private void resetEndWindow(){
        End.playersList = new LSEC();
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
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jugarButton;
    private javax.swing.JButton salirButton;
    private javax.swing.JLabel startStickmanLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
