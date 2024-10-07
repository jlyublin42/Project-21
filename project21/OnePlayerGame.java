package project21;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OnePlayerGame extends JPanel { //----------------------------------------------------------------
   
   private final int PANEL_WIDTH = 1600;
   private final int PANEL_HEIGHT = 1000;
   private final Color background = new Color(0x176121);
   private final ImageIcon project21 = new ImageIcon("project21sm.png");
   private final ImageIcon cardBack = new ImageIcon("CardBack.png");
   private final Font font = new Font("Arial", Font.BOLD, 20);
   private final Font font2 = new Font("Arial", Font.BOLD, 24);
   JPanel infoPanel = new JPanel();
   JPanel playerOnePanel;
   JPanel playerCards;
   JPanel dealerCards;
   JPanel buttonPanel;
   JButton dealButton;
   JButton hitButton;
   JButton stayButton;
   JLabel playerOneName;
   JLabel bankLabel;
   JLabel bankRoll;
   JLabel betLabel;
   JLabel betNumLabel;
   JButton allIn;
   JButton placeBet;
   JButton minus;
   JButton plus;
   int bet = 25;
   int bank = 500;
   
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


      // playerOnePanel should be located underneath playerOne Cards
      playerOnePanel = new JPanel();
      playerOnePanel.setLayout(null);
      playerOnePanel.setBounds(400, 858, 800, 35);
      playerOnePanel.setBackground(Color.darkGray);
      playerOnePanel.setBorder(BorderFactory.createLoweredBevelBorder());

      playerOneName = new JLabel();
      playerOneName.setBounds(5, 0, 120, 35);
      //playerOneName.setBorder(BorderFactory.createRaisedBevelBorder());
      //playerOneName.setBackground(Color.darkGray);
      playerOneName.setForeground(Color.white);
      playerOneName.setFont(font);

      bankLabel = new JLabel();
      bankLabel.setText("Bank:");
      bankLabel.setBounds(140, 2, 60, 30);
      bankLabel.setForeground(Color.lightGray);
      bankLabel.setFont(font);

      bankRoll = new JLabel();
      bankRoll.setText("$ " + bank);
      bankRoll.setBounds(200, 2, 80, 30);
      bankRoll.setBorder(BorderFactory.createLoweredBevelBorder());
      bankRoll.setBackground(Color.darkGray);
      bankRoll.setForeground(Color.white);
      bankRoll.setFont(font);





      // Bet labels and buttons

      betLabel = new JLabel();
      betLabel.setText("Bet:");
      betLabel.setBounds(560, 2, 50, 30);
      betLabel.setBackground(Color.darkGray);
      betLabel.setForeground(Color.lightGray);
      betLabel.setFont(font);

      betNumLabel = new JLabel();
      betNumLabel.setText("$ " + bet);
      betNumLabel.setBounds(605, 2, 80, 30);
      betNumLabel.setBorder(BorderFactory.createLoweredBevelBorder());
      betNumLabel.setBackground(Color.darkGray);
      betNumLabel.setForeground(Color.white);
      betNumLabel.setFont(font);

      placeBet = new JButton("Place Bet");
      placeBet.setMnemonic(KeyEvent.VK_B);
      placeBet.setBounds(420, 5, 130, 25);
      placeBet.setFont(font);

      allIn = new JButton("All In");
      allIn.setMnemonic(KeyEvent.VK_A);
      allIn.setBounds(320, 5, 90, 25);
      allIn.setFont(font);

      minus = new JButton("-");
      minus.setBounds(745, 5, 50, 25);
      minus.setFont(font2);
      plus = new JButton("+");
      plus.setBounds(690, 5, 50, 25);
      plus.setFont(font2);


      // Add Components to playerOnePanel
      playerOnePanel.add(playerOneName);
      playerOnePanel.add(bankLabel);
      playerOnePanel.add(bankRoll);
      playerOnePanel.add(betLabel);
      playerOnePanel.add(betNumLabel);
      playerOnePanel.add(minus);
      playerOnePanel.add(plus);
      playerOnePanel.add(placeBet);
      playerOnePanel.add(allIn);
      

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
      dealButton.setEnabled(false); // Disables Deal Button
      hitButton = new JButton("Hit");
      hitButton.setMnemonic(KeyEvent.VK_H);
      hitButton.setBounds(10, 50, 150, 30);
      hitButton.setFont(font);
      hitButton.setEnabled(false); // Disables Hit Button
      stayButton = new JButton("Stay");
      stayButton.setMnemonic(KeyEvent.VK_S);
      stayButton.setBounds(10, 90, 150, 30);
      stayButton.setFont(font);
      stayButton.setEnabled(false); // Disables Stay Button
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
       
      JTextField info = new JTextField("Press PLACE BET to place your bet for this hand");
      info.setBounds(1000, 0, 585, 40);
      info.setBorder(BorderFactory.createLoweredBevelBorder());
      info.setBackground(Color.darkGray);
      info.setForeground(Color.white);
      info.setFont(font);
      info.setHorizontalAlignment(SwingConstants.RIGHT);
      info.setEditable(false);
      infoPanel.add(info);
 

      // Add Components
      this.add(logoLabel);
      this.add(cardDeck);
      this.add(playerCards);
      this.add(dealerCards);
      this.add(playerOnePanel);
      this.add(buttonPanel);
      this.add(infoPanel);






      // Button ActionListeners

      plus.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
           
            if (bet < bank){
               bet+= 25;
               betNumLabel.setText("$ " + bet);
            }
         }
         
      });

      minus.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            
            if(bet > 25){
               bet-= 25;
               betNumLabel.setText("$ " + bet);
            }
         }
         
      });

      placeBet.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            
            subtractBankRoll(bet);
            setBankRoll();
            placeBet.setVisible(false);
            allIn.setVisible(false);
            plus.setEnabled(false);
            minus.setEnabled(false);
            dealButton.setEnabled(true);
            info.setText("Press DEAL to deal the cards");

         }
         
      });

      allIn.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            
            bet = bank;
            betNumLabel.setText("$ " + bet);

         }
         
      });
 
      
   } // End Constructor

   public void setPlayerOneName(String name){ //--------------------------------------------------------------------------------------------------

      playerOneName.setText(name);

   }

   public void setBankRoll(){ //----------------------------------------------------------------------------------------------------------
      bankRoll.setText("$ " + bank);
   }

   public int getBankRoll(){ //------------------------------------------------------------------------------------------------------------------
      return bank;
   }

   public void addBankRoll(int num){ //---------------------------------------------------------------------------------------------------------
      bank += num;
   }

   public void subtractBankRoll(int num){ //----------------------------------------------------------------------------------------------------
      bank -= num;
   }

   
} // End ---------------------------------------------------------------------------------------------------------------------------------------