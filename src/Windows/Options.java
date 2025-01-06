
package Windows;

import Ahorcado.Messages;
import DataStructures.LSEC;
import Ahorcado.Player;
import Ahorcado.WordFile;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.Normalizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Options extends javax.swing.JFrame {
    
    //Return lists data to Running Window
    protected static LSEC playersList = new LSEC();
    protected static LSEC addedWordsList = new LSEC();
    protected static Options options;
    protected static int roundsNumber = 0, wordsPerRound = 0, gameMode;
    private int remainingCounterTotal = -1;
    
    public Options() {
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
        
        cleanPlayersJList(); //Important
        cleanWordsJList();
        jLabel4.setVisible(false);
        palabrasRonda.setVisible(false);        
        addWordsFrame.setVisible(false); //Adding words internal Window
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        addWordsFrame = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        textAddingWord = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        wordsJList = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        addWord = new javax.swing.JButton();
        deleteWord = new javax.swing.JButton();
        remainingWordsLabel = new javax.swing.JLabel();
        verifyWords = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        playersJList = new javax.swing.JList<>();
        addPlayer = new javax.swing.JButton();
        deletePlayer = new javax.swing.JButton();
        modifyPlayer = new javax.swing.JButton();
        textAddingPlayer = new javax.swing.JTextField();
        palabrasRonda = new javax.swing.JComboBox<>();
        backButton = new javax.swing.JButton();
        jugarButton = new javax.swing.JButton();
        numeroRondas = new javax.swing.JComboBox<>();
        modeCbox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(6);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 920, 120));

        addWordsFrame.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addWordsFrame.setVisible(true);

        textAddingWord.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textAddingWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAddingWordActionPerformed(evt);
            }
        });
        textAddingWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textAddingWordKeyTyped(evt);
            }
        });

        wordsJList.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(wordsJList);

        jLabel5.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("AGREGANDO PALABRAS");

        addWord.setText("Agregar");
        addWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWordActionPerformed(evt);
            }
        });

        deleteWord.setText("Eliminar");
        deleteWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteWordActionPerformed(evt);
            }
        });

        remainingWordsLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        remainingWordsLabel.setText("Palabras necesarias restantes:");

        verifyWords.setText("Aceptar");
        verifyWords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyWordsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(addWord, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(141, 141, 141))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(remainingWordsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAddingWord, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteWord, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(verifyWords, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(remainingWordsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textAddingWord)
                    .addComponent(deleteWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(verifyWords)
                .addContainerGap())
        );

        javax.swing.GroupLayout addWordsFrameLayout = new javax.swing.GroupLayout(addWordsFrame.getContentPane());
        addWordsFrame.getContentPane().setLayout(addWordsFrameLayout);
        addWordsFrameLayout.setHorizontalGroup(
            addWordsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addWordsFrameLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        addWordsFrameLayout.setVerticalGroup(
            addWordsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addWordsFrameLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(addWordsFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 540, 390));

        playersJList.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(playersJList);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 290, 170, 100));

        addPlayer.setBackground(new java.awt.Color(51, 204, 0));
        addPlayer.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        addPlayer.setText("Agregar");
        addPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlayerActionPerformed(evt);
            }
        });
        jPanel1.add(addPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 100, 40));

        deletePlayer.setBackground(new java.awt.Color(255, 0, 0));
        deletePlayer.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        deletePlayer.setText("Eliminar");
        deletePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePlayerActionPerformed(evt);
            }
        });
        jPanel1.add(deletePlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 200, 110, 40));

        modifyPlayer.setBackground(new java.awt.Color(255, 204, 0));
        modifyPlayer.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        modifyPlayer.setForeground(new java.awt.Color(0, 0, 0));
        modifyPlayer.setText("Modificar");
        modifyPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyPlayerActionPerformed(evt);
            }
        });
        jPanel1.add(modifyPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, -1, 30));

        textAddingPlayer.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        textAddingPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAddingPlayerActionPerformed(evt);
            }
        });
        textAddingPlayer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textAddingPlayerKeyTyped(evt);
            }
        });
        jPanel1.add(textAddingPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 200, 40));

        palabrasRonda.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        palabrasRonda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        palabrasRonda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palabrasRondaActionPerformed(evt);
            }
        });
        jPanel1.add(palabrasRonda, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 630, 80, 30));

        backButton.setBackground(new java.awt.Color(51, 102, 255));
        backButton.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        backButton.setText("VOLVER");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 150, -1, -1));

        jugarButton.setBackground(new java.awt.Color(255, 153, 51));
        jugarButton.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        jugarButton.setText("INICIAR PARTIDA");
        jugarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(jugarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 710, -1, 70));

        numeroRondas.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        numeroRondas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        numeroRondas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroRondasActionPerformed(evt);
            }
        });
        jPanel1.add(numeroRondas, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 540, 80, 30));

        modeCbox.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        modeCbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Caos" }));
        modeCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeCboxActionPerformed(evt);
            }
        });
        jPanel1.add(modeCbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 440, 160, 30));

        jLabel4.setFont(new java.awt.Font("OCR A Extended", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Palabras por ronda");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 590, -1, -1));

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Modo de Juego");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, -1, -1));

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("JUGADORES");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("OCR A Extended", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Número de rondas");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 490, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.jpg"))); // NOI18N
        jLabel1.setAlignmentY(0.0F);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void deletePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePlayerActionPerformed
        try {
            deleteOnePlayerJList();            
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_deletePlayerActionPerformed

    private void addPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlayerActionPerformed
        //Players number
        if(this.playersJList.getModel().getSize()<4)
            addToPlayersJList();
        else{
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, Messages.ALERT.MAX_PLAYERS.tx());
        }
        textAddingPlayer.setText("");
    }//GEN-LAST:event_addPlayerActionPerformed

    private void textAddingPlayerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAddingPlayerKeyTyped
        char input = evt.getKeyChar();
        //Verify enter to "Accept"
        if(input==KeyEvent.VK_ENTER)
            addPlayer.doClick();
        else{
            //Restricted characters number = 12
            if(textAddingPlayer.getText().length() > 11){
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_textAddingPlayerKeyTyped
    
    private void jugarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarButtonActionPerformed
        //Save lists and run "Running" Window
        if(this.playersJList.getModel().getSize()!=0 && 
                (this.remainingCounterTotal == 0 ||
                this.remainingCounterTotal == -1)){
            savePlayersList();
            saveAddedWordsList();
            saveWordsNumberSend();
            gameMode = modeCbox.getSelectedIndex();
            try {            
                Running.run = new Running();
            } catch (IOException ex) {
                Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
            }
            Running.run.setVisible(true);
            this.setVisible(false);
        }else{
            Toolkit.getDefaultToolkit().beep();
            if(this.remainingCounterTotal == 0)
                JOptionPane.showMessageDialog(null, Messages.ALERT.IN_REMAIN_WORDS.tx());
            if(this.playersJList.getModel().getSize() == 0)
                JOptionPane.showMessageDialog(null, Messages.ALERT.MIN_PLAYERS.tx());
        }
    }//GEN-LAST:event_jugarButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        //Come back to the menu
        Start start = new Start();
        start.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void textAddingPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAddingPlayerActionPerformed
    }//GEN-LAST:event_textAddingPlayerActionPerformed

    private void numeroRondasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroRondasActionPerformed
        addingWords();
    }//GEN-LAST:event_numeroRondasActionPerformed

    private void textAddingWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAddingWordActionPerformed
    }//GEN-LAST:event_textAddingWordActionPerformed

    private void addWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWordActionPerformed
        if(this.remainingCounterTotal != 0){
            try {
                addToWordsJList();
            } catch (IOException ex) {
            }
            this.remainingWordsLabel.setText(Messages.ALERT.REMAINING_WORDS.tx()
                    +remainingCounterTotal);
        }else{
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, Messages.ALERT.MAX_WORDS.tx());
        }
        textAddingWord.setText("");
    }//GEN-LAST:event_addWordActionPerformed

    private void verifyWordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyWordsActionPerformed
        if(this.remainingCounterTotal == 0){
            numeroRondas.setVisible(true);
            addWordsFrame.setVisible(false);
        }else{
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, Messages.ALERT.IN_REMAIN_WORDS.tx());
        } 
    }//GEN-LAST:event_verifyWordsActionPerformed

    private void deleteWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteWordActionPerformed
        try {
            deleteOneWordJList();            
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_deleteWordActionPerformed

    private void palabrasRondaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palabrasRondaActionPerformed
        addingWords();
    }//GEN-LAST:event_palabrasRondaActionPerformed

    private void textAddingWordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAddingWordKeyTyped
        char input = evt.getKeyChar();
        //Verify enter to "Accept"
        if(input==KeyEvent.VK_ENTER)
            addWord.doClick();
        else{
            if(textAddingWord.getText().length() > 11){
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_textAddingWordKeyTyped

    private void modeCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeCboxActionPerformed
        if(modeCbox.getSelectedIndex() == 0){
            jLabel4.setVisible(false);
            palabrasRonda.setVisible(false);
        }else{
            jLabel4.setVisible(true);
            palabrasRonda.setVisible(true);
        }
    }//GEN-LAST:event_modeCboxActionPerformed

    private void modifyPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyPlayerActionPerformed
        try {
            if(!playersJList.isSelectionEmpty()){
                String newPlayer = JOptionPane.showInputDialog(Messages.ALERT.NEW_NAME.tx());
                int initialLenght = playersJList.getModel().getSize();
                if(newPlayer.length() > 12)
                    newPlayer = newPlayer.substring(0, 12);
                textAddingPlayer.setText(newPlayer);
                addToPlayersJList();
                if(initialLenght != playersJList.getModel().getSize())
                    deleteOnePlayerJList();
                textAddingPlayer.setText("");
            }else
                Toolkit.getDefaultToolkit().beep();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_modifyPlayerActionPerformed
    
    private DefaultListModel cleanPlayersJList(){
        DefaultListModel model = new DefaultListModel();
        playersJList.setModel(model);
        return model;
    }
    
    private DefaultListModel cleanWordsJList(){
        DefaultListModel model = new DefaultListModel();
        wordsJList.setModel(model);
        return model;
    }
    
    private DefaultListModel addToPlayersJList(){
        DefaultListModel model = (DefaultListModel) playersJList.getModel();
        if(!textAddingPlayer.getText().equals("") && 
                verifyFollowedSpaces(textAddingPlayer.getText())){
            if(verifyNonExistentString(model, cleanString(textAddingPlayer.getText().trim())))
                model.addElement(cleanString(textAddingPlayer.getText().trim()));
            else{
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, Messages.ALERT.EXISTENT_PLA.tx());
            }
        }
        return model;
    }
    
    private boolean verifyFollowedSpaces(String text){
        for(int i =0; i<text.length(); i++){
            if(text.charAt(i) != ' ')
                return true;            
        }
        return false;
    }
    
    private boolean verifyNonExistentString(DefaultListModel model, String text){
        for (int i = 0; i < model.getSize(); i++) {
            if(model.getElementAt(i).equals(text))
                return false;
        }
        return true;
    }
    
    public String cleanString(String text) {
        text = Normalizer.normalize(text, Normalizer.Form.NFD);
        text = text.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return text;
    }
    
    private DefaultListModel addToWordsJList() throws IOException{
        DefaultListModel model = (DefaultListModel) wordsJList.getModel();
        if(!textAddingWord.getText().equals("")){
            if (textAddingWord.getText().length() > 5 && 
                    verifyFollowedSpaces(textAddingWord.getText())){
                String word = cleanString(textAddingWord.getText().trim()).toLowerCase();
                boolean realWord = WordFile.verifyRealWord(word);
                if(verifyNonExistentString(model, word) && realWord){
                    model.addElement(word);
                    this.remainingCounterTotal--;
                }
                else{
                    Toolkit.getDefaultToolkit().beep();
                    if(!realWord)
                        JOptionPane.showMessageDialog(null, Messages.ALERT.FAKE_WORD.tx());
                    else
                        JOptionPane.showMessageDialog(null, Messages.ALERT.EXISTENT_WOR.tx());
                }
            } 
            else{
                textAddingWord.setText("");
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, Messages.ALERT.MIN_LETTERS.tx());
            }
        }
        return model;
    }
    
    private DefaultListModel deleteOnePlayerJList(){
        DefaultListModel model = (DefaultListModel) playersJList.getModel();
        model.remove(playersJList.getSelectedIndex());
        return model;
    }
    
    private DefaultListModel deleteOneWordJList(){
        DefaultListModel model = (DefaultListModel) wordsJList.getModel();
        model.remove(wordsJList.getSelectedIndex());
        this.remainingCounterTotal++;
        this.remainingWordsLabel.setText(Messages.ALERT.REMAINING_WORDS.tx()+remainingCounterTotal);
        return model;
    }
    
    private void savePlayersList(){
        for (int i = 0; i < this.playersJList.getModel().getSize(); i++) {
            playersList.append(new Player(this.playersJList.getModel().getElementAt(i), (i+1)));
        }
    }
    
    private void saveAddedWordsList(){
        for (int i = 0; i < this.wordsJList.getModel().getSize(); i++) {
            addedWordsList.append(this.wordsJList.getModel().getElementAt(i));
        }
    }
    
    private void saveWordsNumberSend(){
        if(wordsPerRound == 0 && roundsNumber == 0){
            wordsPerRound = palabrasRonda.getSelectedIndex()+1;
            roundsNumber = numeroRondas.getSelectedIndex()+1;
            remainingCounterTotal = 0;
        }
    }
    
    private void addingWords(){
        // getSelectedIndex() begins from "0", so +1 return de combobox number
        if(remainingCounterTotal == -1){
            int wordsCounter = (palabrasRonda.getSelectedIndex()+1)*(numeroRondas.getSelectedIndex()+1);        
            wordsPerRound = (palabrasRonda.getSelectedIndex()+1);
            roundsNumber = (numeroRondas.getSelectedIndex()+1);
            if(wordsCounter>10){
                remainingCounterTotal = wordsCounter-10;
                remainingWordsLabel.setText(Messages.ALERT.REMAINING_WORDS.tx()+remainingCounterTotal);
                addWordsFrame.setVisible(true);
                numeroRondas.setVisible(false);
            }
        }else{
            JFrame frame = new JFrame("Alerta");
            if(JOptionPane.showConfirmDialog(frame, Messages.ALERT.WORDS_AGAIN.tx(), 
               Messages.ALERT.ALERT_.tx(),JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
                remainingCounterTotal = -1;
                cleanWordsJList();
                addingWords();
            }else{
                palabrasRonda.setSelectedIndex(wordsPerRound-1);
                numeroRondas.setSelectedIndex(roundsNumber-1);
            }
        }
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
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Options().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPlayer;
    private javax.swing.JButton addWord;
    private javax.swing.JInternalFrame addWordsFrame;
    private javax.swing.JButton backButton;
    private javax.swing.JButton deletePlayer;
    private javax.swing.JButton deleteWord;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jugarButton;
    private javax.swing.JComboBox<String> modeCbox;
    private javax.swing.JButton modifyPlayer;
    private javax.swing.JComboBox<String> numeroRondas;
    private javax.swing.JComboBox<String> palabrasRonda;
    private javax.swing.JList<String> playersJList;
    private javax.swing.JLabel remainingWordsLabel;
    private javax.swing.JTextField textAddingPlayer;
    private javax.swing.JTextField textAddingWord;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton verifyWords;
    private javax.swing.JList<String> wordsJList;
    // End of variables declaration//GEN-END:variables
}
