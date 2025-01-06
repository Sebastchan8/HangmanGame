
package Windows;

import Ahorcado.*;
import DataStructures.LSEC;
import DataStructures.LSEC.Node;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Running extends javax.swing.JFrame{
    
    //Saving lists from "Options" window
    //if: list is from options or end window
    protected static Running run;
    protected static LSEC playersList;
    protected static LSEC addedWordsList;
    
    private LSEC initialWordsList = new LSEC();
    private String exitedChars[] = new String[30];
    private Node randomWordNode, currentPlayer;
    
    private int exitedCharPosition = 0,remainingLettersToGuess,
            currentRoundNumber = 1,currentPartialWord = 1,
            stickImageCounter = 0,maximumPosition = 0,
            wordTotalNumber, roundsNumber, wordsPerRound,
            coincidences[], gameMode;
    
    private final SoundEffect soundOk = new SoundEffect("ok");
    private final SoundEffect soundFail = new SoundEffect("fail");
    private final SoundEffect soundStart = new SoundEffect("startSound");
    protected static SoundEffect soundRun = new SoundEffect("runningG");
        
    public Running() throws IOException {
        Start.soundStart.stop();
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
        
        hideHealthBars();
        
        playersList = Options.playersList;
        addedWordsList = Options.addedWordsList;
        gameMode = Options.gameMode;
        
        setNameLabels();
        setScoreLabelsRunning();
        appendWordsAdedToInitialList();
        
        //Initialize
        currentPlayer = this.playersList.head;
        turnoLabel.setText(((Player)playersList.head.data).getName());
        randomWordNode = initialWordsList.randomNode();
        roundsNumber = Options.roundsNumber;
        wordsPerRound = Options.wordsPerRound;
        wordTotalNumber = roundsNumber*wordsPerRound;
        remainingLettersToGuess = ((String)randomWordNode.data).length();
        
        refreshRoundWordLabels();
        showLinesImage(((String)randomWordNode.data).length());
        
        wordToGuessFrame.setVisible(false);
        soundStart.play(false);
        letterInput.requestFocusInWindow();
        
        if(gameMode == 0){
            jLabel5.setVisible(false);
            hideHealthBars();
        }
        soundRun.play(true);
    }
    
    private void hideHealthBars(){
        HealthBar1.setVisible(false);
        HealthBar2.setVisible(false);
        HealthBar3.setVisible(false);
        HealthBar4.setVisible(false);
    }
    
    private void reset(int wordLenght){
        //Initial variables
        exitedChars = new String[30];
        exitedCharPosition = 0;
        stickImageCounter = 0;
        maximumPosition = 0;
        currentPlayer = this.playersList.head;
        remainingLettersToGuess = ((String)randomWordNode.data).length();
        
        setFullPlayersHealth();
        showStickmanImage();
        showLinesImage(wordLenght);        
        setSpaceAllLabels();
        
        turnoLabel.setText(((Player)playersList.head.data).getName());
        setFullBarHealth();
        refreshRoundWordLabels();
        
        wordToGuessFrame.setVisible(false);
        soundStart.play(false);
    }
    
    private void reset2(){
        //Initial variables
        exitedChars = new String[30];
        exitedCharPosition = 0;
        stickImageCounter = 0;
        maximumPosition = 0;
        randomWordNode = initialWordsList.randomNode();
        remainingLettersToGuess = ((String)randomWordNode.data).length();
        
        showStickmanImage();
        showLinesImage(((String)randomWordNode.data).length());        
        setSpaceAllLabels();
        
        turnoLabel.setText(((Player)currentPlayer.data).getName());
        refreshRoundWordLabels();
        
        wordToGuessFrame.setVisible(false);
        soundStart.play(false);
    }
    
    private void setSpaceAllLabels(){
        letter1.setText(" ");
        letter2.setText(" ");
        letter3.setText(" ");
        letter4.setText(" ");
        letter5.setText(" ");
        letter6.setText(" ");
        letter7.setText(" ");
        letter8.setText(" ");
        letter9.setText(" ");
        letter10.setText(" ");
        letter11.setText(" ");
        letter12.setText(" ");
    }
    
    private void setFullBarHealth(){
        HealthBar1.setValue(90);
        HealthBar2.setValue(90);
        HealthBar3.setValue(90);
        HealthBar4.setValue(90);
    }
    
    private void setFullPlayersHealth(){
        Node playerAux = this.playersList.head;
        do {
            ((Player) playerAux.data).setHealth(90);
            playerAux = playerAux.next;
        } while (playerAux != playersList.head);
    }
    
    private void appendWordsAdedToInitialList() throws IOException{
        if(gameMode == 0)
            initialWordsList = WordFile.generateInitialWordsList(26);
        else
            initialWordsList = WordFile.generateInitialWordsList(11);
        System.out.println("IMPRIMIENDO");
        initialWordsList.printList();
        initialWordsList.appendList(addedWordsList);
    }
    
    private boolean verifyAllPlayersZeroHealth(){
        Node player = this.playersList.head;
        boolean comprobation = true;
        for (int i = 0; i < playersList.size; i++) {
            comprobation = (((Player)player.data).getHealth() == 0 && comprobation);
            player = player.next;
        }
        return comprobation;
    }
    
    private boolean currentRound(Node randomWordNode, String inString){
        String currentWord = ((String)randomWordNode.data).toUpperCase();
        setInitialLetterPosition(currentWord.length());
        return game(inString, currentWord);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        wordToGuessFrame = new javax.swing.JInternalFrame();
        wordToGuessPanel = new javax.swing.JPanel();
        correctLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        wordLabel = new javax.swing.JLabel();
        HealthBarPanel = new javax.swing.JPanel();
        HealthBar1 = new javax.swing.JProgressBar();
        HealthBar2 = new javax.swing.JProgressBar();
        HealthBar3 = new javax.swing.JProgressBar();
        HealthBar4 = new javax.swing.JProgressBar();
        playerName1 = new javax.swing.JLabel();
        playerName2 = new javax.swing.JLabel();
        playerName3 = new javax.swing.JLabel();
        playerName4 = new javax.swing.JLabel();
        playerScore1 = new javax.swing.JLabel();
        playerScore2 = new javax.swing.JLabel();
        playerScore3 = new javax.swing.JLabel();
        playerScore4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        letter1 = new javax.swing.JLabel();
        letter2 = new javax.swing.JLabel();
        letter3 = new javax.swing.JLabel();
        letter4 = new javax.swing.JLabel();
        letter5 = new javax.swing.JLabel();
        letter6 = new javax.swing.JLabel();
        letter7 = new javax.swing.JLabel();
        letter8 = new javax.swing.JLabel();
        letter9 = new javax.swing.JLabel();
        letter10 = new javax.swing.JLabel();
        letter11 = new javax.swing.JLabel();
        letter12 = new javax.swing.JLabel();
        stickmanLabel = new javax.swing.JLabel();
        linesLabel = new javax.swing.JLabel();
        letterInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        turnoLabel = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(6);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 920, 120));

        wordToGuessFrame.setVisible(true);

        wordToGuessPanel.setBackground(new java.awt.Color(0, 0, 0));

        correctLabel.setFont(new java.awt.Font("OCR A Extended", 1, 48)); // NOI18N
        correctLabel.setText(" ");

        jLabel6.setFont(new java.awt.Font("OCR A Extended", 1, 40)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("La palabra era:");

        wordLabel.setFont(new java.awt.Font("OCR A Extended", 1, 110)); // NOI18N
        wordLabel.setForeground(new java.awt.Color(255, 255, 255));
        wordLabel.setText(" ");

        javax.swing.GroupLayout wordToGuessPanelLayout = new javax.swing.GroupLayout(wordToGuessPanel);
        wordToGuessPanel.setLayout(wordToGuessPanelLayout);
        wordToGuessPanelLayout.setHorizontalGroup(
            wordToGuessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wordToGuessPanelLayout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addComponent(wordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(wordToGuessPanelLayout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wordToGuessPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(correctLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        wordToGuessPanelLayout.setVerticalGroup(
            wordToGuessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wordToGuessPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(correctLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(wordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout wordToGuessFrameLayout = new javax.swing.GroupLayout(wordToGuessFrame.getContentPane());
        wordToGuessFrame.getContentPane().setLayout(wordToGuessFrameLayout);
        wordToGuessFrameLayout.setHorizontalGroup(
            wordToGuessFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(wordToGuessFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(wordToGuessFrameLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(wordToGuessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        wordToGuessFrameLayout.setVerticalGroup(
            wordToGuessFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(wordToGuessFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(wordToGuessFrameLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(wordToGuessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(wordToGuessFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, -1, -1));

        HealthBarPanel.setBackground(new java.awt.Color(51, 51, 51));

        HealthBar1.setBackground(new java.awt.Color(204, 0, 0));
        HealthBar1.setForeground(new java.awt.Color(51, 204, 0));
        HealthBar1.setMaximum(90);
        HealthBar1.setValue(90);

        HealthBar2.setBackground(new java.awt.Color(204, 0, 0));
        HealthBar2.setForeground(new java.awt.Color(51, 204, 0));
        HealthBar2.setMaximum(90);
        HealthBar2.setValue(90);

        HealthBar3.setBackground(new java.awt.Color(204, 0, 0));
        HealthBar3.setForeground(new java.awt.Color(51, 204, 0));
        HealthBar3.setMaximum(90);
        HealthBar3.setValue(90);

        HealthBar4.setBackground(new java.awt.Color(204, 0, 0));
        HealthBar4.setForeground(new java.awt.Color(51, 204, 0));
        HealthBar4.setMaximum(90);
        HealthBar4.setValue(90);

        playerName1.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        playerName1.setForeground(new java.awt.Color(255, 255, 255));

        playerName2.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        playerName2.setForeground(new java.awt.Color(255, 255, 255));

        playerName3.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        playerName3.setForeground(new java.awt.Color(255, 255, 255));

        playerName4.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        playerName4.setForeground(new java.awt.Color(255, 255, 255));

        playerScore1.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        playerScore1.setForeground(new java.awt.Color(255, 255, 255));

        playerScore2.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        playerScore2.setForeground(new java.awt.Color(255, 255, 255));

        playerScore3.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        playerScore3.setForeground(new java.awt.Color(255, 255, 255));

        playerScore4.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        playerScore4.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout HealthBarPanelLayout = new javax.swing.GroupLayout(HealthBarPanel);
        HealthBarPanel.setLayout(HealthBarPanelLayout);
        HealthBarPanelLayout.setHorizontalGroup(
            HealthBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HealthBarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HealthBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HealthBarPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(HealthBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(HealthBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HealthBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addGroup(HealthBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HealthBar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HealthBar4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(HealthBarPanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(playerName1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(playerName2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGap(24, 24, 24))
            .addGroup(HealthBarPanelLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(playerScore3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playerScore4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(HealthBarPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(playerScore1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playerScore2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
            .addGroup(HealthBarPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(playerName3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playerName4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        HealthBarPanelLayout.setVerticalGroup(
            HealthBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HealthBarPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(HealthBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(playerName2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerName1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HealthBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HealthBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HealthBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HealthBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerScore1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerScore2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(HealthBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerName3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerName4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HealthBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HealthBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HealthBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HealthBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerScore3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerScore4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel1.add(HealthBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 210, 650, 390));

        jPanel2.setOpaque(false);

        letter1.setFont(new java.awt.Font("OCR A Extended", 1, 100)); // NOI18N
        letter1.setForeground(new java.awt.Color(255, 255, 255));
        letter1.setText(" ");
        letter1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                letter1KeyTyped(evt);
            }
        });

        letter2.setFont(new java.awt.Font("OCR A Extended", 1, 100)); // NOI18N
        letter2.setForeground(new java.awt.Color(255, 255, 255));
        letter2.setText(" ");

        letter3.setFont(new java.awt.Font("OCR A Extended", 1, 100)); // NOI18N
        letter3.setForeground(new java.awt.Color(255, 255, 255));
        letter3.setText(" ");

        letter4.setFont(new java.awt.Font("OCR A Extended", 1, 100)); // NOI18N
        letter4.setForeground(new java.awt.Color(255, 255, 255));
        letter4.setText(" ");

        letter5.setFont(new java.awt.Font("OCR A Extended", 1, 100)); // NOI18N
        letter5.setForeground(new java.awt.Color(255, 255, 255));
        letter5.setText(" ");

        letter6.setFont(new java.awt.Font("OCR A Extended", 1, 100)); // NOI18N
        letter6.setForeground(new java.awt.Color(255, 255, 255));
        letter6.setText(" ");

        letter7.setFont(new java.awt.Font("OCR A Extended", 1, 100)); // NOI18N
        letter7.setForeground(new java.awt.Color(255, 255, 255));
        letter7.setText(" ");

        letter8.setFont(new java.awt.Font("OCR A Extended", 1, 100)); // NOI18N
        letter8.setForeground(new java.awt.Color(255, 255, 255));
        letter8.setText(" ");

        letter9.setFont(new java.awt.Font("OCR A Extended", 1, 100)); // NOI18N
        letter9.setForeground(new java.awt.Color(255, 255, 255));
        letter9.setText(" ");

        letter10.setFont(new java.awt.Font("OCR A Extended", 1, 100)); // NOI18N
        letter10.setForeground(new java.awt.Color(255, 255, 255));
        letter10.setText(" ");

        letter11.setFont(new java.awt.Font("OCR A Extended", 1, 100)); // NOI18N
        letter11.setForeground(new java.awt.Color(255, 255, 255));
        letter11.setText(" ");

        letter12.setFont(new java.awt.Font("OCR A Extended", 1, 100)); // NOI18N
        letter12.setForeground(new java.awt.Color(255, 255, 255));
        letter12.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(letter1)
                .addGap(55, 55, 55)
                .addComponent(letter2)
                .addGap(46, 46, 46)
                .addComponent(letter3)
                .addGap(57, 57, 57)
                .addComponent(letter4)
                .addGap(59, 59, 59)
                .addComponent(letter5)
                .addGap(57, 57, 57)
                .addComponent(letter6)
                .addGap(53, 53, 53)
                .addComponent(letter7)
                .addGap(61, 61, 61)
                .addComponent(letter8)
                .addGap(59, 59, 59)
                .addComponent(letter9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(letter10)
                .addGap(49, 49, 49)
                .addComponent(letter11)
                .addGap(58, 58, 58)
                .addComponent(letter12)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(letter6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(letter5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(letter8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(letter7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, Short.MAX_VALUE)
                        .addComponent(letter9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(letter2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(letter1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(letter4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(letter3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, Short.MAX_VALUE)
                        .addComponent(letter10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(letter12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(letter11, javax.swing.GroupLayout.PREFERRED_SIZE, 94, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, 1430, 90));
        jPanel1.add(stickmanLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 400, 370));
        jPanel1.add(linesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 730, 1430, 50));

        letterInput.setBackground(new java.awt.Color(102, 102, 102));
        letterInput.setFont(new java.awt.Font("OCR A Extended", 1, 48)); // NOI18N
        letterInput.setForeground(new java.awt.Color(0, 0, 0));
        letterInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letterInputActionPerformed(evt);
            }
        });
        letterInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                letterInputKeyTyped(evt);
            }
        });
        jPanel1.add(letterInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 550, 50, 60));

        jLabel5.setBackground(new java.awt.Color(255, 153, 0));
        jLabel5.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 160, 140, 30));

        jLabel4.setBackground(new java.awt.Color(255, 153, 0));
        jLabel4.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 160, 120, 30));

        jLabel3.setBackground(new java.awt.Color(255, 153, 0));
        jLabel3.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("   TURNO:");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, 190, 30));

        turnoLabel.setBackground(new java.awt.Color(0, 102, 204));
        turnoLabel.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        turnoLabel.setForeground(new java.awt.Color(255, 255, 255));
        turnoLabel.setOpaque(true);
        jPanel1.add(turnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 510, 190, 30));

        jButton5.setBackground(new java.awt.Color(0, 153, 153));
        jButton5.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setText("ACEPTAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 620, -1, -1));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("OCR A Extended", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Finalizar Partida");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 210, 30));

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
        
    private int setInitialLetterPosition(int wordLenght){
        showLinesImage(wordLenght);
        switch(wordLenght){
            case 6:
                return 4;
            case 7:
                return 3;
            case 8:
                return 3;
            case 9:
                return 2;
            case 10:
                return 2;
            case 11:
                return 1;
            case 12:
                return 1;
            default:
                break;
        }
        return 0;
    }
    
    private boolean verifyExitedChar(String input){
        for (int i = 0; i < exitedChars.length && exitedChars[i] != null; i++) {
            if(exitedChars[i].equals(input)) return true;
        }
        return false;
    }
    
    private void decreaseHealthBarPlayers(Node currentPlayer){
        switch(((Player)currentPlayer.data).getPositionNumber()){
            case 1:
                HealthBar1.setValue(((Player)currentPlayer.data).decreaseHealthBar());
                break;
            case 2:
                HealthBar2.setValue(((Player)currentPlayer.data).decreaseHealthBar());
                break;
            case 3:
                HealthBar3.setValue(((Player)currentPlayer.data).decreaseHealthBar());
                break;
            case 4:
                HealthBar4.setValue(((Player)currentPlayer.data).decreaseHealthBar());
                break;
            default:
                break;
        }
        checkBarToShow(currentPlayer);
    }
        
    private boolean game(String inString, String word){
        int initialPosition = setInitialLetterPosition(word.length());
        if (verifyExitedChar(inString) == false) {
            if (!inString.equals("") && maximumPosition < word.length()) {
                boolean playerGuess = checkCoincidences(word, inString, initialPosition);
                setCoincidencesLabels(inString);
                checkPlayerTry(playerGuess, inString);
                setScoreLabelsRunning();
                return true;
            }else{
                Toolkit.getDefaultToolkit().beep();
            }
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, Messages.ALERT.SAME_LETTER.tx());
            return false;
        }
        return false;
    }
    
    private boolean checkCoincidences(String word, String inString, int initialPosition){
        coincidences = new int[12];
        int currentPosCoincidences = 0;
        boolean playerGuess = false;
        for (int i = 0; i < word.length(); i++) {
            if (String.valueOf(word.charAt(i)).equals(inString)) {
                coincidences[currentPosCoincidences] = (i + initialPosition);
                currentPosCoincidences++;
                remainingLettersToGuess--;
                playerGuess = true;
            }
        }
        return playerGuess;
    }
    
    public void setCoincidencesLabels(String inString){
        for (int i = 0; i < coincidences.length; i++) {
            if (coincidences[i] != 0) {
                setLettersLabelsText(inString, coincidences[i]);
                maximumPosition++;
            }
        }
    }
    
    private void checkPlayerTry(boolean playerGuess, String inString){
        if (playerGuess) {
            ((Player) currentPlayer.data).increaseScore();
            exitedChars[exitedCharPosition] = inString;
            exitedCharPosition++;
            soundOk.play(false);
        } else {
            decreaseHealthBarPlayers(currentPlayer);
            soundFail.play(false);
        }
    }
    
    private void setLettersLabelsText(String input, int position){
        switch(position){
            case 1:
                letter1.setText(input);
                break;
            case 2:
                letter2.setText(input);
                break;
            case 3:
                letter3.setText(input);
                break;
            case 4:
                letter4.setText(input);
                break;
            case 5:
                letter5.setText(input);
                break;
            case 6:
                letter6.setText(input);
                break;
            case 7:
                letter7.setText(input);
                break;
            case 8:
                letter8.setText(input);
                break;
            case 9:
                letter9.setText(input);
                break;
            case 10:
                letter10.setText(input);
                break;
            case 11:
                letter11.setText(input);
                break;
            case 12:
                letter12.setText(input);
                break;
            default:
                break;
        }
    }
    
    private void showLinesImage(int wordLenght){            
        ImageIcon lines = new ImageIcon(getClass().getResource("/Images/lines" + wordLenght + ".png"));
        this.linesLabel.setIcon(new ImageIcon(lines.getImage().
                getScaledInstance(linesLabel.getWidth(), linesLabel.getHeight(), Image.SCALE_DEFAULT)));
    }
    
    private void showStickmanImage(){            
        if(stickImageCounter<=7){
            ImageIcon startStickman = new ImageIcon(getClass().getResource("/Images/stick" + this.stickImageCounter + ".png"));
            this.stickmanLabel.setIcon(new ImageIcon(startStickman.getImage().
                    getScaledInstance(stickmanLabel.getWidth(), stickmanLabel.getHeight(), Image.SCALE_DEFAULT)));
        }
    }
    
    private void checkBarToShow(Node player){
        if(gameMode == 1){
            if(((Player)player.data).getHealth()!= -30)
                connectStickmanBars();
        }else
            connectStickmanBars();
    }
    
    private void letter1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_letter1KeyTyped
    }//GEN-LAST:event_letter1KeyTyped

    private void letterInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_letterInputActionPerformed
    }//GEN-LAST:event_letterInputActionPerformed

    private void letterInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_letterInputKeyTyped
        char input = evt.getKeyChar();
        //Verify enter to "Accept"
        if(input==KeyEvent.VK_ENTER)
            jButton5.doClick();
        else{
            //Restricted characters number
            if (!Character.isLetter(input) || letterInput.getText().length() > 0){
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_letterInputKeyTyped
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (currentRoundNumber > roundsNumber)
            startEndWindow();
        if(gameMode == 1){
            if (!verifyAllPlayersZeroHealth() && remainingLettersToGuess != 0) {
                if (((Player) currentPlayer.data).getHealth() != 0) {
                    if (currentRound(randomWordNode, letterInput.getText().toUpperCase()) == true) {
                        currentPlayer = currentPlayer.next;
                    }
                    if (((Player) currentPlayer.data).getHealth() == 0) {
                        currentPlayer = currentPlayer.next;
                    }
                    turnoLabel.setText(((Player) currentPlayer.data).getName());
                } else {
                    currentPlayer = currentPlayer.next;
                    turnoLabel.setText(((Player) currentPlayer.data).getName());
                }
            } else endCurrentRound();
        }else{
            if (remainingLettersToGuess != 0 && stickImageCounter!=7 ) {
                currentRound(randomWordNode, letterInput.getText().toUpperCase());
                showStickmanImage();
            }else{
                currentPlayer = currentPlayer.next;
                if(currentPlayer == playersList.head)
                    currentRoundNumber++;
                reset2();
            }
            
        }
        letterInput.setText("");
        showStickmanImage();
        showWordToGuess();
        if (currentRoundNumber > roundsNumber) {
            //End all rounds
            startEndWindow();
        }else
            letterInput.requestFocusInWindow();
        refreshRoundWordLabels();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame frame = new JFrame("EXIT");
        Toolkit.getDefaultToolkit().beep();
        if(JOptionPane.showConfirmDialog(frame, Messages.ALERT.END_GAME.tx(), 
           Messages.ALERT.ALERT_.tx(),JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
            startEndWindow();
        else
            letterInput.requestFocusInWindow();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void showWordToGuess(){
        boolean playersZeroHealth;
        int stickmanImgCounter;
        if(gameMode == 0){
            playersZeroHealth = false;
            stickmanImgCounter = 7;
        }
        else{
            playersZeroHealth = verifyAllPlayersZeroHealth();
            stickmanImgCounter = 8;
        }
        if( ((remainingLettersToGuess == 0 || stickImageCounter == stickmanImgCounter ||
                playersZeroHealth )) 
                && randomWordNode != null){
            if( (gameMode == 0 && stickImageCounter == 7) || 
                    stickImageCounter == 8 || playersZeroHealth ){
                correctLabel.setText(Messages.ALERT.INCORRECT.tx());
                correctLabel.setForeground(Color.red);
            }else{
                correctLabel.setText(Messages.ALERT.CORRECT.tx());
                correctLabel.setForeground(Color.green);
            }
            wordLabel.setText(((String)randomWordNode.data).toUpperCase());
            correctLabel.setHorizontalAlignment(SwingConstants.CENTER);
            wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
            sleepWindow(1);
            wordToGuessFrame.setVisible(true);
        }
    }
    
    private void refreshRoundWordLabels(){
        jLabel4.setText(Messages.ALERT.ROUND.tx()+String.valueOf(currentRoundNumber)+
                "/"+String.valueOf(roundsNumber));
        jLabel5.setText(Messages.ALERT.WORD.tx()+String.valueOf(currentPartialWord)+
                "/"+String.valueOf(wordsPerRound));
    }
    
    private void startEndWindow(){
        sleepWindow(1);
        End.end = new End();
        End.end.setVisible(true);
        setZeroScoreAll();
        setScoreLabelsRunning();
        this.dispose();
    }
    
    private void sleepWindow(int seconds){
        try {
            for (int i = 0; i < seconds; i++) {
                Thread.sleep(1000);
            }
        }
        catch (Exception e) {
        }
    }
    
    private void connectStickmanBars(){
        showStickmanImage();
        if(this.stickImageCounter!=8)this.stickImageCounter++;
        else endCurrentRound();
    }
    
    private void endCurrentRound(){
        if(randomWordNode != null){
            randomWordNode = initialWordsList.randomNode();
            if (currentPartialWord < wordsPerRound) {
                currentPartialWord++;
            } else {
                currentRoundNumber++;
                currentPartialWord = 1;
            }
            if(randomWordNode != null)
                reset(((String) randomWordNode.data).length());
        }
    }
    
    private void setZeroScoreAll(){
        Node currentPlayer = playersList.head;
        do{
            ((Player)currentPlayer.data).setScore(0);
            currentPlayer = currentPlayer.next;
        }while(currentPlayer != playersList.head);
    }
    
    private void setNameLabels(){
        for (int i = 1; i <= this.playersList.size; i++) {
            switch(i){
                case 1:
                    this.playerName1.setText(this.playersList.getPositionName(i));
                    HealthBar1.setVisible(true);
                    break;
                case 2:
                    this.playerName2.setText(this.playersList.getPositionName(i));
                    HealthBar2.setVisible(true);
                    break;
                case 3:
                    this.playerName3.setText(this.playersList.getPositionName(i));
                    HealthBar3.setVisible(true);
                    break;
                case 4:
                    this.playerName4.setText(this.playersList.getPositionName(i));
                    HealthBar4.setVisible(true);
                    break;
                default:
                    break;
            }
        }
    }
    
    private void setScoreLabelsRunning(){
        for (int i = 1; i <= this.playersList.size; i++) {
            switch(i){
                case 1:
                    this.playerScore1.setText(String.valueOf(this.playersList.getPositionScore(i)));
                    break;
                case 2:
                    this.playerScore2.setText(String.valueOf(this.playersList.getPositionScore(i)));
                    break;
                case 3:
                    this.playerScore3.setText(String.valueOf(this.playersList.getPositionScore(i)));
                    break;
                case 4:
                    this.playerScore4.setText(String.valueOf(this.playersList.getPositionScore(i)));
                    break;
                default:
                    break;
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
            java.util.logging.Logger.getLogger(Running.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Running.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Running.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Running.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Running().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Running.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar HealthBar1;
    private javax.swing.JProgressBar HealthBar2;
    private javax.swing.JProgressBar HealthBar3;
    private javax.swing.JProgressBar HealthBar4;
    private javax.swing.JPanel HealthBarPanel;
    private javax.swing.JLabel correctLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel letter1;
    private javax.swing.JLabel letter10;
    private javax.swing.JLabel letter11;
    private javax.swing.JLabel letter12;
    private javax.swing.JLabel letter2;
    private javax.swing.JLabel letter3;
    private javax.swing.JLabel letter4;
    private javax.swing.JLabel letter5;
    private javax.swing.JLabel letter6;
    private javax.swing.JLabel letter7;
    private javax.swing.JLabel letter8;
    private javax.swing.JLabel letter9;
    private javax.swing.JTextField letterInput;
    private javax.swing.JLabel linesLabel;
    private javax.swing.JLabel playerName1;
    private javax.swing.JLabel playerName2;
    private javax.swing.JLabel playerName3;
    private javax.swing.JLabel playerName4;
    private javax.swing.JLabel playerScore1;
    private javax.swing.JLabel playerScore2;
    private javax.swing.JLabel playerScore3;
    private javax.swing.JLabel playerScore4;
    private javax.swing.JLabel stickmanLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel turnoLabel;
    private javax.swing.JLabel wordLabel;
    private javax.swing.JInternalFrame wordToGuessFrame;
    private javax.swing.JPanel wordToGuessPanel;
    // End of variables declaration//GEN-END:variables
}