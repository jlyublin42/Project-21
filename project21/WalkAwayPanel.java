package project21;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WalkAwayPanel extends JPanel { //---------------------------------------------------------------
   
   private final int PANEL_WIDTH = 800;
   private final int PANEL_HEIGHT = 800;
   private final Color color = new Color(0x8c8c8c);
   private final ImageIcon project21 = new ImageIcon("project21.png");
   private final Font font = new Font("Arial", Font.BOLD, 20);
   private final Font font2 = new Font("Arial", Font.BOLD, 16);
   int numHands;
   int numWins;
   int numTies;
   int numLosses;
   int bank;
   JLabel name;
   JLabel startBank;
   JLabel endBank;
   JLabel numHandsLbl;
   JLabel numWinsLbl;
   JLabel numTiesLbl;
   JLabel numLossesLbl;
   String playerName;
   GameFrame parent;

 
  
   // Constructor
   public WalkAwayPanel(GameFrame parent) { //-------------------------------------------------------------------------------
      
      this.setSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
      this.setBackground(Color.darkGray);
      this.setLayout(null);
      this.setBorder(BorderFactory.createRaisedBevelBorder());
      this.parent = parent;
      
      // Project-21 Logo
      JLabel logoLabel = new JLabel(project21);
      logoLabel.setBounds(250, 10, 300, 300);


      // Labels
      JPanel labelPanel = new JPanel();
      labelPanel.setBounds(210, 320, 380, 100);
      labelPanel.setLayout(null);
      labelPanel.setBackground(Color.darkGray);
      labelPanel.setBorder(BorderFactory.createLoweredBevelBorder());

      //playerName = parent.startGamePanel.getPlayerOneName();
      name = new JLabel("Name: ");
      name.setBounds(10, 10, 170, 20);
      name.setFont(font2);
      name.setBackground(Color.darkGray);
      name.setForeground(Color.black);

      endBank = new JLabel("Bank: $");
      endBank.setBounds(200, 10, 170, 20);
      endBank.setFont(font2);
      endBank.setBackground(Color.darkGray);
      endBank.setForeground(Color.black);

      numHandsLbl = new JLabel("Number of Hands: ");
      numHandsLbl.setBounds(10, 40, 170, 20);
      numHandsLbl.setFont(font2);
      numHandsLbl.setBackground(Color.darkGray);
      numHandsLbl.setForeground(Color.black);

      numWinsLbl = new JLabel("Number of Wins: ");
      numWinsLbl.setBounds(200, 40, 170, 20);
      numWinsLbl.setFont(font2);
      numWinsLbl.setBackground(Color.darkGray);
      numWinsLbl.setForeground(Color.black);

      numTiesLbl = new JLabel("Number of Ties: ");
      numTiesLbl.setBounds(10, 70, 170, 20);
      numTiesLbl.setFont(font2);
      numTiesLbl.setBackground(Color.darkGray);
      numTiesLbl.setForeground(Color.black);

      numLossesLbl = new JLabel("Number of Losses: "); 
      numLossesLbl.setBounds(200, 70, 170, 20);
      numLossesLbl.setFont(font2);
      numLossesLbl.setBackground(Color.darkGray);
      numLossesLbl.setForeground(Color.black);

      // Add Labels to labelPanel
      labelPanel.add(name);
      labelPanel.add(endBank);
      labelPanel.add(numHandsLbl);
      labelPanel.add(numWinsLbl);
      labelPanel.add(numTiesLbl);
      labelPanel.add(numLossesLbl);


      // Create start and exit buttons
      JButton nextRoundBtn = new JButton("New Round");
      nextRoundBtn.setMnemonic(KeyEvent.VK_R);
      nextRoundBtn.setBounds(250, 470, 160, 30);
      nextRoundBtn.setFont(font);
      JButton exitBtn = new JButton("Exit");
      exitBtn.setMnemonic(KeyEvent.VK_X);
      exitBtn.setBounds(430, 470, 80, 30);
      exitBtn.setFont(font);


      this.add(logoLabel);
      this.add(labelPanel);
      this.add(nextRoundBtn);
      this.add(exitBtn);


      nextRoundBtn.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
  
            parent.onePlayerGame.newRound();
            parent.walkAwayPanel.setVisible(false); 
              
         }
         
      });


      exitBtn.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
        
          System.exit(0);
              
         }
         
      });
  
      
   } // End Constructor


   public void updateData(){

      playerName = parent.startGamePanel.getPlayerOneName();
      name.setText("Name: " + playerName);
      bank = parent.onePlayerGame.getBankRoll();
      endBank.setText("Bank: $" + bank);
      numHands = parent.onePlayerGame.getNumHands();
      numHandsLbl.setText("Number of Hands: " + numHands);
      numWins = parent.onePlayerGame.getNumWins();
      numWinsLbl.setText("Number of Wins: " + numWins);
      numTies = parent.onePlayerGame.getNumTies();
      numTiesLbl.setText("Number of Ties: " + numTies);
      numLosses = parent.onePlayerGame.getNumLosses();
      numLossesLbl.setText("Number of Losses: " + numLosses);

   }
   
} // ------------------------------------------------------------------------------------------------------------------------