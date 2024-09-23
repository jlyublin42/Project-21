package project21;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartGamePanel extends JPanel { //---------------------------------------------------------------
   
   private final int PANEL_WIDTH = 800;
   private final int PANEL_HEIGHT = 800;
   private final Color color = new Color(0x8c8c8c);
   private final ImageIcon project21 = new ImageIcon("project21.png");
   private final Font font = new Font("Arial", Font.BOLD, 18);
   private JRadioButton onePlayer;
   private JRadioButton twoPlayer;
   private JRadioButton threePlayer;
   private ButtonGroup bg;
   JTextField playerOneName;
   JTextField playerTwoName;
   JTextField playerThreeName;
   JComboBox twoPlayerCB;
   JComboBox threePlayerCB;
   JButton startBtn;
   JButton exitBtn;
   
  
   // Constructor
   public StartGamePanel(GameFrame parent) { //-------------------------------------------------------------------------------
      
      this.setSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
      this.setBackground(Color.lightGray);
      this.setLayout(null);
      this.setBorder(BorderFactory.createRaisedBevelBorder());
      
      // Project-21 Logo
      JLabel logoLabel = new JLabel(project21);
      logoLabel.setBounds(250, 20, 300, 300);
      
      
      // Create the three radio buttons and add to group
      onePlayer = new JRadioButton();
      onePlayer.setBounds(240, 340, 20, 20);
      onePlayer.setBackground(Color.lightGray);
      playerOneName = new JTextField("One Player");
      playerOneName.setBounds(264, 334, 140, 30);
      playerOneName.setBorder(BorderFactory.createLoweredBevelBorder());
      playerOneName.setBackground(Color.lightGray);
      playerOneName.setFont(font);
      
      twoPlayer = new JRadioButton();
      twoPlayer.setBounds(240, 380, 20, 20);
      twoPlayer.setBackground(Color.lightGray);
      playerTwoName = new JTextField("Two Players");
      playerTwoName.setBounds(264, 374, 140, 30);
      playerTwoName.setBorder(BorderFactory.createLoweredBevelBorder());
      playerTwoName.setBackground(Color.lightGray);
      playerTwoName.setFont(font);
      
      threePlayer = new JRadioButton();
      threePlayer.setBounds(240, 420, 20, 20);
      threePlayer.setBackground(Color.lightGray);
      playerThreeName = new JTextField("Three Players");
      playerThreeName.setBounds(264, 414, 140, 30);
      playerThreeName.setBorder(BorderFactory.createLoweredBevelBorder());
      playerThreeName.setBackground(Color.lightGray);
      playerThreeName.setFont(font);
      
      bg = new ButtonGroup();
      bg.add(onePlayer);
      bg.add(twoPlayer);
      bg.add(threePlayer);

      // Disable Two and Three player games
      twoPlayer.setEnabled(false);
      playerTwoName.setEditable(false);
      threePlayer.setEnabled(false);
      playerThreeName.setEditable(false);

      
      
      // Create the two combo boxes with the choices Human or AI
      twoPlayerCB = new JComboBox();
      twoPlayerCB.addItem("User");
      twoPlayerCB.addItem("AI");
      twoPlayerCB.setBounds(420, 375, 120, 30);
      twoPlayerCB.setFont(font);
      twoPlayerCB.setEnabled(false);
      
      threePlayerCB = new JComboBox();
      threePlayerCB.addItem("User");
      threePlayerCB.addItem("AI");
      threePlayerCB.setBounds(420, 415, 120, 30);
      threePlayerCB.setFont(font);
      threePlayerCB.setEnabled(false);
      
      
      // Create start and exit buttons
      startBtn = new JButton("Start Game");
      startBtn.setMnemonic(KeyEvent.VK_S);
      startBtn.setBounds(310, 470, 100, 30);
      exitBtn = new JButton("Exit");
      exitBtn.setMnemonic(KeyEvent.VK_X);
      exitBtn.setBounds(430, 470, 60, 30);
   
     
      
      // Add components to the panel
      this.add(logoLabel);
      this.add(onePlayer);
      this.add(twoPlayer);
      this.add(threePlayer); 
      this.add(playerOneName);
      this.add(playerTwoName);
      this.add(playerThreeName);
      this.add(twoPlayerCB);
      this.add(threePlayerCB);
      this.add(startBtn);
      this.add(exitBtn);
      
      
      // Radio Button action listeners
      onePlayer.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
        
            int caretPosition = playerOneName.getCaretPosition();
            String currentText = playerOneName.getText();
            playerOneName.requestFocus();
            playerOneName.setCaretPosition(caretPosition + currentText.length());
            selectedButton();
                   
         } 
      });
      
      playerOneName.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
        
            int caretPosition = playerOneName.getCaretPosition();
            String currentText = playerOneName.getText();
            playerOneName.requestFocus();
            playerOneName.setCaretPosition(caretPosition + currentText.length());
            onePlayer.setSelected(true);
                   
         } 
      });

      twoPlayer.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
        
            int caretPosition = playerOneName.getCaretPosition();
            String currentText = playerOneName.getText();
            playerOneName.requestFocus();
            playerOneName.setCaretPosition(caretPosition + currentText.length());
            selectedButton();
                   
         } 
      });
      
      threePlayer.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
        
            int caretPosition = playerOneName.getCaretPosition();
            String currentText = playerOneName.getText();
            playerOneName.requestFocus();
            playerOneName.setCaretPosition(caretPosition + currentText.length());
            selectedButton();
                   
         } 
      });
      
      
      
      // Start and Exit button action listeners
      startBtn.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
        
            if (onePlayer.isSelected()) {
               parent.onePlayerGame.setPlayerOneName(getPlayerOneName()); // Passes Name into OnePlayerGame
               parent.selectGame(1);
            } else if (twoPlayer.isSelected()){
               parent.twoPlayerGame.setPlayerOneName(getPlayerOneName());
               parent.twoPlayerGame.setPlayerTwoName(getPlayerTwoName());
               parent.selectGame(2);
            } else if (threePlayer.isSelected()){
               parent.threePlayerGame.setPlayerOneName(getPlayerOneName());
               parent.threePlayerGame.setPlayerTwoName(getPlayerTwoName());
               parent.threePlayerGame.setPlayerThreeName(getPlayerThreeName());
               parent.selectGame(3);
            }
              
         }
         
      });
      
      exitBtn.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
        
          System.exit(0);
              
         }
         
      });
      
      
   }
   
   
   public void selectPlayerOne(){ //--------------------------------------------------------------------------
      
   }
   
   public String getPlayerOneName(){ //-----------------------------------------------------------------------
      return playerOneName.getText();
   }
   
   public String getPlayerTwoName(){ //-----------------------------------------------------------------------
      return playerTwoName.getText();
   }
   
   public String getPlayerThreeName(){ //---------------------------------------------------------------------
      return playerThreeName.getText();
   }
   
   public String getPlayerThreeComboBox(){
      int num = threePlayerCB.getSelectedIndex();
      System.out.println(num);
      
      return threePlayerCB.getSelectedItem().toString();
   }
   
   
   public void selectedButton(){
      
         if (onePlayer.isSelected()) {
            twoPlayerCB.setEnabled(false);
            threePlayerCB.setEnabled(false);
         } else if (twoPlayer.isSelected()){
            twoPlayerCB.setEnabled(true);
         } else if (threePlayer.isSelected()){
            twoPlayerCB.setEnabled(true);
            threePlayerCB.setEnabled(true);
         }
      
   }
   
   
   
} // End -----------------------------------------------------------------------------------------------------