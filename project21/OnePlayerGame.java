package project21;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class OnePlayerGame extends JPanel { //----------------------------------------------------------------
   
   private final int PANEL_WIDTH = 1600;
   private final int PANEL_HEIGHT = 1000;
   private final Color background = new Color(0x176121);
   private final ImageIcon project21 = new ImageIcon("project21sm.png");
   private final ImageIcon cardBack = new ImageIcon("CardBack.png");
   private final Font font = new Font("Arial", Font.BOLD, 20);
   JPanel infoPanel = new JPanel();
   JPanel playerCards;
   JPanel dealerCards;
   JPanel buttonPanel;
   JButton dealButton;
   JButton hitButton;
   JButton stayButton;
   JLabel playerOneName;
   
   // Constructor
   public OnePlayerGame(GameFrame parent) { //--------------------------------------------------------------------------------
      
      this.setSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
      this.setBackground(background);
      this.setLayout(null);
      this.setVisible(true);

      // Project 21 Logo
      JLabel logoLabel = new JLabel(project21);
      logoLabel.setBounds(700, 360, 200, 200);

      // Card Deck - Top Right
      JLabel cardDeck = new JLabel(cardBack);
      cardDeck.setBounds(1420, 50, 120, 182);

      // Player Cards
      playerCards = new JPanel();
      playerCards.setBackground(background);
      playerCards.setBounds(400, 660, 800, 198);
      playerCards.setLayout(new FlowLayout());
      playerCards.setBorder(BorderFactory.createLineBorder(Color.black, 3));


      // Dealer Cards
      dealerCards = new JPanel();
      dealerCards.setBackground(background);
      dealerCards.setBounds(400, 50, 800, 198);
      dealerCards.setLayout(new FlowLayout());
      dealerCards.setBorder(BorderFactory.createLineBorder(Color.black, 3));


      // playerOneName should be located underneath playerOne Cards
      playerOneName = new JLabel();
      playerOneName.setBounds(400, 860, 180, 20);
      playerOneName.setBackground(Color.lightGray);
      playerOneName.setForeground(Color.lightGray);
      playerOneName.setFont(font);
      //playerOneName.setText("Lawrence");
      

      

      //String name;
      //name = parent.startGamePanel.getPlayerOneName();


      // Set up buttonPanel
      buttonPanel = new JPanel();
      buttonPanel.setLayout(null);
      buttonPanel.setBackground(Color.darkGray);
      buttonPanel.setBounds(1420, 795, 168, 130);
      buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
      dealButton = new JButton("Deal");
      dealButton.setMnemonic(KeyEvent.VK_D);
      dealButton.setBounds(10, 10, 150, 30);
      dealButton.setFont(font);
      hitButton = new JButton("Hit");
      hitButton.setMnemonic(KeyEvent.VK_H);
      hitButton.setBounds(10, 50, 150, 30);
      hitButton.setFont(font);
      stayButton = new JButton("Stay");
      stayButton.setMnemonic(KeyEvent.VK_S);
      stayButton.setBounds(10, 90, 150, 30);
      stayButton.setFont(font);
      // Add Buttons
      buttonPanel.add(dealButton);
      buttonPanel.add(hitButton);
      buttonPanel.add(stayButton);


      // Info Panel - Bottom 
      infoPanel.setBounds(0, 925, 1600, 75);
      infoPanel.setLayout(null);
      infoPanel.setBackground(Color.darkGray);
      infoPanel.setForeground(Color.lightGray);
      infoPanel.setBorder(BorderFactory.createLoweredBevelBorder());
       
      JTextField info = new JTextField("Press DEAL To Deal New Cards");
      info.setBounds(1000, 0, 585, 40);
      info.setBorder(BorderFactory.createLoweredBevelBorder());
      info.setBackground(Color.darkGray);
      info.setForeground(Color.lightGray);
      info.setFont(font);
      info.setHorizontalAlignment(SwingConstants.RIGHT);
      info.setEditable(false);
      infoPanel.add(info);
 

      // Add Components
      this.add(logoLabel);
      this.add(cardDeck);
      this.add(playerCards);
      this.add(dealerCards);
      this.add(playerOneName);
      this.add(buttonPanel);
      this.add(infoPanel);



      
      

      
      
   }

   public void setPlayerOneName(String name){
      playerOneName.setText(name);
   }
   
} // End -----------------------------------------------------------------------------------------------------