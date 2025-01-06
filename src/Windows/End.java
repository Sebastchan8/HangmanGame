
package Windows;

import DataStructures.LSEC;
import DataStructures.LSEC.Node;
import Ahorcado.Player;
import Ahorcado.SoundEffect;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class End extends javax.swing.JFrame {
    
    protected static LSEC playersList;
    protected static End end;
    protected final SoundEffect soundEnd = new SoundEffect("endG");
    
    public End() {
        Running.soundRun.stop();
        initComponents();
        GraphicsEnvironment env =
        GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        this.setResizable(false);
        
        ImageIcon titleJuego= new ImageIcon(getClass().getResource("/Images/juego_del_ahorcado.png"));
        this.titleLabel.setIcon(new ImageIcon(titleJuego.getImage().
                getScaledInstance(titleLabel.getWidth(),titleLabel.getHeight(), Image.SCALE_SMOOTH)));
        
        this.repaint();
        cleanPlayersJList();
        showPlayersScore();
        
        soundEnd.play(true);
    }
    
    private DefaultListModel cleanPlayersJList(){
        DefaultListModel model = new DefaultListModel();
        scoresPlayersJList.setModel(model);
        return model;
    }
        
    private void showPlayersScore(){
        playersList = Running.playersList;
        playersList.sortByScore();
        playersList.reverseList();
        addScoresJlist();
    }
    
    private void addScoresJlist(){
        DefaultListModel<String> model = (DefaultListModel) scoresPlayersJList.getModel();
        Node currentPlayer = playersList.head;
        for (int i = 1; i <= playersList.size; i++) {
            model.addElement(i+". "+((Player)currentPlayer.data).getName()+
                    generateSpaces(currentPlayer)+
                    ((Player)currentPlayer.data).getScore());
            currentPlayer = currentPlayer.next;
        }
        scoresPlayersJList.setModel(model);
    }
    
    private String generateSpaces(Node currentPlayer){
        int lenght = 12 - ((Player)currentPlayer.data).getName().length();
        String spaces = "      ";
        for (int i = 0; i < lenght; i++) {
            spaces += " ";
        }
        return spaces;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scoresPlayersJList = new javax.swing.JList<>();
        menuButton = new javax.swing.JButton();
        playAgainButton = new javax.swing.JButton();
        puntajeLabel = new javax.swing.JLabel();
        jugadorLabel = new javax.swing.JLabel();
        resultadosLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(6);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 920, 120));

        scoresPlayersJList.setBackground(new java.awt.Color(102, 102, 102));
        scoresPlayersJList.setFont(new java.awt.Font("OCR A Extended", 1, 48)); // NOI18N
        scoresPlayersJList.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(scoresPlayersJList);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 830, 220));

        menuButton.setBackground(new java.awt.Color(204, 0, 0));
        menuButton.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        menuButton.setForeground(new java.awt.Color(255, 255, 255));
        menuButton.setText("Menú");
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });
        jPanel1.add(menuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 700, 140, 40));

        playAgainButton.setBackground(new java.awt.Color(0, 153, 51));
        playAgainButton.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        playAgainButton.setForeground(new java.awt.Color(255, 255, 255));
        playAgainButton.setText("Volver a Jugar");
        playAgainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playAgainButtonActionPerformed(evt);
            }
        });
        jPanel1.add(playAgainButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 700, 250, 40));

        puntajeLabel.setBackground(new java.awt.Color(0, 204, 204));
        puntajeLabel.setFont(new java.awt.Font("OCR A Extended", 1, 45)); // NOI18N
        puntajeLabel.setForeground(new java.awt.Color(0, 0, 0));
        puntajeLabel.setText("   PUNTAJE");
        puntajeLabel.setOpaque(true);
        jPanel1.add(puntajeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 300, 330, 40));

        jugadorLabel.setBackground(new java.awt.Color(0, 102, 255));
        jugadorLabel.setFont(new java.awt.Font("OCR A Extended", 1, 45)); // NOI18N
        jugadorLabel.setForeground(new java.awt.Color(0, 0, 0));
        jugadorLabel.setText("     JUGADOR");
        jugadorLabel.setOpaque(true);
        jPanel1.add(jugadorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 500, 40));

        resultadosLabel.setBackground(new java.awt.Color(255, 153, 0));
        resultadosLabel.setFont(new java.awt.Font("OCR A Extended", 1, 60)); // NOI18N
        resultadosLabel.setForeground(new java.awt.Color(0, 0, 0));
        resultadosLabel.setText("RESULTADOS");
        resultadosLabel.setOpaque(true);
        jPanel1.add(resultadosLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 390, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.jpg"))); // NOI18N
        jLabel1.setAlignmentY(0.0F);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, -1, -1));

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

    private void playAgainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playAgainButtonActionPerformed
        try {
            Running.run = new Running();
        } catch (IOException ex) {
            Logger.getLogger(End.class.getName()).log(Level.SEVERE, null, ex);
        }
        Running.run.addedWordsList = new LSEC();
        setZeroScoreAll();
        soundEnd.stop();
        Running.run.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_playAgainButtonActionPerformed
    
    private void setZeroScoreAll(){
        Node currentPlayer = Running.run.playersList.head;
        int position = 1;
        do{
            ((Player)currentPlayer.data).setScore(0);
            ((Player)currentPlayer.data).setPositionNumber(position);
            currentPlayer = currentPlayer.next;
            position++;
        }while(currentPlayer != Running.run.playersList.head);
    }
    
    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        //Come back to the menu
        Start start = new Start();
        start.setVisible(true);
        soundEnd.stop();
        this.dispose();
    }//GEN-LAST:event_menuButtonActionPerformed

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
            java.util.logging.Logger.getLogger(End.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(End.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(End.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(End.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new End().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jugadorLabel;
    private javax.swing.JButton menuButton;
    private javax.swing.JButton playAgainButton;
    private javax.swing.JLabel puntajeLabel;
    private javax.swing.JLabel resultadosLabel;
    private javax.swing.JList<String> scoresPlayersJList;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}