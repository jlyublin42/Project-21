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
   private final Font font2 = new Font("Arial", Font.BOLD, 20);
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
      this.setBackground(Color.darkGray);
      this.setLayout(null);
      this.setBorder(BorderFactory.createRaisedBevelBorder());
      
      // Project-21 Logo
      JLabel logoLabel = new JLabel(project21);
      logoLabel.setBounds(250, 20, 300, 300);
      
      
      // Create the three radio buttons and add to group
      onePlayer = new JRadioButton();
      onePlayer.setBounds(240, 340, 20, 20);
      onePlayer.setBackground(Color.darkGray);
      onePlayer.setSelected(true);
      playerOneName = new JTextField("One Player");
      playerOneName.setBounds(264, 334, 140, 30);
      playerOneName.setBorder(BorderFactory.createLoweredBevelBorder());
      playerOneName.setBackground(Color.darkGray);
      playerOneName.setForeground(Color.white);
      playerOneName.setFont(font);
      int caretPosition = playerOneName.getCaretPosition();
      String currentText = playerOneName.getText();
      playerOneName.requestFocus();
      playerOneName.setCaretPosition(caretPosition + currentText.length());
      //playerOneName.setEditable(false);
      
      twoPlayer = new JRadioButton();
      twoPlayer.setBounds(240, 380, 20, 20);
      twoPlayer.setBackground(Color.darkGray);
      playerTwoName = new JTextField("Two Players");
      playerTwoName.setBounds(264, 374, 140, 30);
      playerTwoName.setBorder(BorderFactory.createLoweredBevelBorder());
      playerTwoName.setBackground(Color.darkGray);
      playerTwoName.setForeground(Color.white);
      playerTwoName.setFont(font);
      playerTwoName.setEditable(false);
      
      threePlayer = new JRadioButton();
      threePlayer.setBounds(240, 420, 20, 20);
      threePlayer.setBackground(Color.darkGray);
      playerThreeName = new JTextField("Three Players");
      playerThreeName.setBounds(264, 414, 140, 30);
      playerThreeName.setBorder(BorderFactory.createLoweredBevelBorder());
      playerThreeName.setBackground(Color.darkGray);
      playerThreeName.setForeground(Color.white);
      playerThreeName.setFont(font);
      playerThreeName.setEditable(false);
      
      bg = new ButtonGroup();
      bg.add(onePlayer);
      bg.add(twoPlayer);
      bg.add(threePlayer);

      // Disable Two and Three player games
      //twoPlayer.setEnabled(false);
      //playerTwoName.setEditable(false);
      //threePlayer.setEnabled(false);
      //playerThreeName.setEditable(false);

      
      
      // Create the two combo boxes with the choices Human or AI
      twoPlayerCB = new JComboBox();
      twoPlayerCB.addItem("User");
      twoPlayerCB.addItem("AI");
      twoPlayerCB.setBounds(420, 375, 120, 30);
      twoPlayerCB.setFont(font);
      twoPlayerCB.setBackground(Color.darkGray);
      twoPlayerCB.setForeground(Color.white);
      twoPlayerCB.setEnabled(false);
      
      threePlayerCB = new JComboBox();
      threePlayerCB.addItem("User");
      threePlayerCB.addItem("AI");
      threePlayerCB.setBounds(420, 415, 120, 30);
      threePlayerCB.setFont(font);
      threePlayerCB.setBackground(Color.darkGray);
      threePlayerCB.setForeground(Color.white);
      threePlayerCB.setEnabled(false);
      
      
      // Create start and exit buttons
      startBtn = new JButton("Start Game");
      startBtn.setMnemonic(KeyEvent.VK_S);
      startBtn.setBounds(270, 470, 140, 30);
      startBtn.setFont(font);
      exitBtn = new JButton("Exit");
      exitBtn.setMnemonic(KeyEvent.VK_X);
      exitBtn.setBounds(430, 470, 80, 30);
      exitBtn.setFont(font);
   
     
      
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
            playerOneName.setEditable(true);
            playerTwoName.setEditable(false);
            playerThreeName.setEditable(false);
            selectedButton();
            int caretPosition = playerOneName.getCaretPosition();
            String currentText = playerOneName.getText();
            playerOneName.requestFocus();
            playerOneName.setCaretPosition(caretPosition + currentText.length());
            
         } 
      });

      twoPlayer.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
        
            playerOneName.setEditable(true);
            playerTwoName.setEditable(true);
            playerThreeName.setEditable(false);
            selectedButton();
            int caretPosition = playerOneName.getCaretPosition();
            String currentText = playerOneName.getText();
            playerOneName.requestFocus();
            playerOneName.setCaretPosition(caretPosition + currentText.length());
            
                   
         } 
      });
      
      threePlayer.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            
            playerOneName.setEditable(true);
            playerTwoName.setEditable(true);
            playerThreeName.setEditable(true);
            selectedButton();
            int caretPosition = playerOneName.getCaretPosition();
            String currentText = playerOneName.getText();
            playerOneName.requestFocus();
            playerOneName.setCaretPosition(caretPosition + currentText.length());
            
                   
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
               parent.twoPlayerGame.setPlayerTwoUser(getPlayerTwoComboBox());
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
      
      
   } // End Constructor
   
   
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
   
   public String getPlayerTwoComboBox(){ //-------------------------------------------------------------------
      int num = twoPlayerCB.getSelectedIndex();
      System.out.println(num);
      
      return twoPlayerCB.getSelectedItem().toString();
   }

   public String getPlayerThreeComboBox(){ //-----------------------------------------------------------------
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
            threePlayerCB.setEnabled(false);
         } else if (threePlayer.isSelected()){
            twoPlayerCB.setEnabled(true);
            threePlayerCB.setEnabled(true);
         }
      
   }
   
   
   
} // End -----------------------------------------------------------------------------------------------------