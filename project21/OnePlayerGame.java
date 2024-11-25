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
   JPanel buttonPanel2;
   JButton dealButton;
   JButton hitButton;
   JButton stayButton;
   JButton nextHandButton;
   JButton walkAwayButton;
   JLabel playerOneName;
   JLabel bankLabel;
   JLabel bankRoll;
   JLabel betLabel;
   JLabel betNumLabel;
   JTextField info;
   JButton allIn;
   JButton placeBet;
   JButton minus;
   JButton plus;
   int bet = 25;
   int bank = 500;
   JLabel[] cards = new JLabel[10];
   Deck deck;
   Hand playerOneHand;
   Hand dealerHand;
   int count = 0;
   int plyrCardValue = 0;
   int dlrCardValue = 0;
   Card dlrFirstCard;
   int numHands = 0;
   int numWins = 0;
   int numTies = 0;
   int numLosses = 0;
   
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
      playerCards.add(cards[0] = new JLabel()); //First card dealt
      playerCards.add(cards[2] = new JLabel()); //Third card dealt
      playerCards.add(cards[4] = new JLabel());
      playerCards.add(cards[5] = new JLabel());
      playerCards.add(cards[6] = new JLabel()); 


      // Dealer Cards
      dealerCards = new JPanel();
      dealerCards.setBackground(background);
      dealerCards.setBounds(400, 50, 800, 198);
      dealerCards.setLayout(new FlowLayout());
      dealerCards.setBorder(BorderFactory.createLineBorder(Color.black, 3));
      dealerCards.add(cards[1] = new JLabel()); //Second card dealt
      dealerCards.add(cards[3] = new JLabel()); //Fourth card dealt
      dealerCards.add(cards[7] = new JLabel());
      dealerCards.add(cards[8] = new JLabel());
      dealerCards.add(cards[9] = new JLabel());


      // playerOnePanel should be located underneath playerOne Cards
      playerOnePanel = new JPanel();
      playerOnePanel.setLayout(null);
      playerOnePanel.setBounds(400, 858, 800, 35);
      playerOnePanel.setBackground(Color.darkGray);
      playerOnePanel.setBorder(BorderFactory.createLoweredBevelBorder());

      playerOneName = new JLabel();
      playerOneName.setBounds(5, 0, 120, 35);
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

      // Set up buttonPanel2
      buttonPanel2 = new JPanel();
      buttonPanel2.setLayout(null);
      buttonPanel2.setBackground(Color.darkGray);
      buttonPanel2.setBounds(-3, 835, 168, 90);
      buttonPanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
      nextHandButton = new JButton("Next Hand");
      nextHandButton.setMnemonic(KeyEvent.VK_X);
      nextHandButton.setBounds(10, 10, 150, 30);
      nextHandButton.setFont(font);
      nextHandButton.setEnabled(false); // Disables NextHand Button
      walkAwayButton = new JButton("Walk Away");
      walkAwayButton.setMnemonic(KeyEvent.VK_W);
      walkAwayButton.setBounds(10, 50, 150, 30);
      walkAwayButton.setFont(font);
      // Add Buttons
      buttonPanel2.add(nextHandButton);
      buttonPanel2.add(walkAwayButton);


      // Info Panel - Bottom 
      infoPanel.setBounds(0, 925, 1600, 75);
      infoPanel.setLayout(null);
      infoPanel.setBackground(Color.darkGray);
      infoPanel.setForeground(Color.lightGray);
      infoPanel.setBorder(BorderFactory.createLoweredBevelBorder());
       
      info = new JTextField("Press PLACE BET to place your bet for this hand");
      info.setBounds(0, 0, 1585, 40);
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
      this.add(buttonPanel2);
      this.add(infoPanel);
      


      // Initialize Deck and Hands
      deck = new Deck();
      playerOneHand = new Hand();
      dealerHand = new Hand();



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
            nextHandButton.setEnabled(false);
            walkAwayButton.setEnabled(false);

         }
         
      });

      allIn.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            
            bet = bank;
            betNumLabel.setText("$ " + bet);

         }
         
      });

      dealButton.addActionListener(new ActionListener(){

         public void actionPerformed(ActionEvent e) {

            dealButton.setEnabled(false);
            hitButton.setEnabled(true);
            stayButton.setEnabled(true);
            nextHandButton.setEnabled(false);
            walkAwayButton.setEnabled(false);

            for (int i = 0; i < 4;i++){
               Card cardIdx = deck.drawCard(i);
               if (i == 1){
                  cards[i].setIcon(cardBack);
                  dlrFirstCard = cardIdx;
               } else {
                  cards[i].setIcon(deck.getIcon(cardIdx.getCardNum()));
               }
               count++;
               if (i == 0 || i == 2){
                  playerOneHand.addCard(deck.drawCard(i));
                  plyrCardValue = playerOneHand.getTotalValue();
                  System.out.println(plyrCardValue);
                  if (plyrCardValue == 21){
                     hitButton.setEnabled(false);
                  }
               }else {
                  dealerHand.addCard(deck.drawCard(i));
                  dlrCardValue = dealerHand.getTotalValue();
                  System.out.println(dlrCardValue);
               }
            } 
            dealButton.setEnabled(false);
            info.setText("You have " + plyrCardValue + " Press HIT or Press STAY");

           
            numHands++;
            

         }

      });

      hitButton.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {

            if (count == 7){
               hitButton.setEnabled(false);
            } else if (plyrCardValue < 22){
               Card cardIdx = deck.drawCard(count);
               cards[count].setIcon(deck.getIcon(cardIdx.getCardNum()));
               if ( count == 4 || count == 5 || count == 6){
                  playerOneHand.addCard(deck.drawCard(count));
                  plyrCardValue = playerOneHand.getTotalValue();
                  info.setText("You have " + plyrCardValue + " Press HIT or Press STAY");
                  System.out.println(plyrCardValue);
                  if (plyrCardValue > 21){
                     cards[1].setIcon(deck.getIcon(dlrFirstCard.getCardNum()));
                     nextHandButton.setEnabled(true);
                     checkWinner();   
                  } else if (plyrCardValue == 21){
                     hitButton.setEnabled(false);
                     info.setText("You have " + plyrCardValue + " Press STAY");
                  }
               } 
               count++;
            }
         }
      });


      stayButton.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            
            cards[1].setIcon(deck.getIcon(dlrFirstCard.getCardNum()));
            for (int i = 7; i < 10; i++){
               if (dlrCardValue < plyrCardValue && dlrCardValue < 17){
                  Card cardIdx = deck.drawCard(count);
                  cards[i].setIcon(deck.getIcon(cardIdx.getCardNum()));
                  dealerHand.addCard(deck.drawCard(count));
                  dlrCardValue = dealerHand.getTotalValue();
                  System.out.println(dlrCardValue);
                  count++;
               }
            }

            checkWinner();

         }
         
      });


      nextHandButton.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            
            minus.setEnabled(true);
            plus.setEnabled(true);
            placeBet.setVisible(true);
            allIn.setVisible(true);
            hitButton.setEnabled(false);
            stayButton.setEnabled(false);
            info.setText("Press PLACE BET to place your bet for this hand");

            for (int i = 0; i < 10; i++){
               cards[i].setIcon(null);
            }

            count = 0;
            plyrCardValue = 0;
            dlrCardValue = 0;

            playerOneHand.clearHand();
            dealerHand.clearHand();

            if (bet > bank){
               bet = 25;
               betNumLabel.setText("$ " + bet);
            }

            deck.shuffle();

         }
         
      });


      walkAwayButton.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            
            parent.walkAwayPanel.updateData();
            parent.walkAwayPanel.setVisible(true);
            
         }
         
      });
 
      
   } // End Constructor -------------------------------------------------------------------------------------------------------------------------


   public void setPlayerOneName(String name){ //--------------------------------------------------------------------------------------------------
      playerOneName.setText(name);
   }

   public void setBankRoll(int num){ //-----------------------------------------------------------------------------------------------------------
      bankRoll.setText("$ " + num);
   }

   public void setBankRoll(){ //------------------------------------------------------------------------------------------------------------------
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

   private void checkWinner() { //-------------------------------------------------------------------------------------------------------------
      hitButton.setEnabled(false);
      stayButton.setEnabled(false);
      int playerTotal = playerOneHand.getTotalValue();
      int dealerTotal = dealerHand.getTotalValue();

      if (playerTotal > 21) {
         info.setText("You busted! Dealer wins.");
         System.out.println("You busted! Dealer wins.");
         numLosses++;
      } else if (dealerTotal > 21) {
         info.setText("Dealer busted! You win.");
         System.out.println("Dealer busted! You win.");
         numWins++;
      } else if (playerTotal > dealerTotal) {
         info.setText("You win with " + playerTotal + " against " + dealerTotal + "!");
         System.out.println("You win with " + playerTotal + " against " + dealerTotal + "!");
         numWins++;
      } else if (playerTotal < dealerTotal) {
         info.setText("Dealer wins with " + dealerTotal + " against " + playerTotal + ".");
         System.out.println("Dealer wins with " + dealerTotal + " against " + playerTotal + ".");
         numLosses++;
      } else {
         info.setText("It's a tie!");
         System.out.println("It's a tie!");
         numTies++;
      }

   
      settleBets();
      System.out.println(numHands + " " + numWins);

   }


   private void settleBets(){ //--------------------------------------------------------------------------------------------------------------
      int playerTotal = playerOneHand.getTotalValue();
      int dealerTotal = dealerHand.getTotalValue();
      int winnings = 0;
         
      
      if (playerTotal > 21) {
            winnings = 0;
            addBankRoll(winnings);
            setBankRoll();
      } else if (dealerTotal > 21) {
         if (playerTotal == 21) {
            winnings = bet * 3;
            addBankRoll(winnings);
            setBankRoll();
         } else {
            winnings = bet * 2;
            addBankRoll(winnings);
            setBankRoll();
         }
      } else if (playerTotal > dealerTotal && playerTotal < 22) {
         if (playerTotal == 21) {
            winnings = bet * 3;
            addBankRoll(winnings);
            setBankRoll();
         } else {
            winnings = bet * 2;
            addBankRoll(winnings);
            setBankRoll();
         }
      } else if (playerTotal < dealerTotal){
         winnings = 0;
         addBankRoll(winnings);
         setBankRoll();
      } else if (playerTotal == dealerTotal){
         addBankRoll(bet);
         setBankRoll();
      }

      if (bank == 0){
         nextHandButton.setEnabled(false);
         walkAwayButton.setEnabled(true);
      } else {
         nextHandButton.setEnabled(true);
         walkAwayButton.setEnabled(true);
      }

   }

   public void newRound(){ //-----------------------------------------------------------------------------------------------------------------

      minus.setEnabled(true);
      plus.setEnabled(true);
      placeBet.setVisible(true);
      allIn.setVisible(true);
      hitButton.setEnabled(false);
      stayButton.setEnabled(false);
      info.setText("Press PLACE BET to place your bet for this hand");

      for (int i = 0; i < 10; i++){
               cards[i].setIcon(null);
      }

      count = 0;
      plyrCardValue = 0;
      dlrCardValue = 0;
      numHands = 0;
      numWins = 0;
      numTies = 0;
      numLosses = 0;

      playerOneHand.clearHand();
      dealerHand.clearHand();

      bank = 500;
      setBankRoll(500);
      bet = 25;
      betNumLabel.setText("$ " + bet);
      

      deck.shuffle();
     

   }


   public int getNumHands(){ //----------------------------------------------------------------------------------------------------------------
      return numHands;
   }

   public void setNumHands(int num){ //--------------------------------------------------------------------------------------------------------
      numHands = num;
   }

   public int getNumWins(){ //-----------------------------------------------------------------------------------------------------------------
      return numWins;
   }

   public void setNumWins(int num){ //---------------------------------------------------------------------------------------------------------
      numWins = num;
   }

   public int getNumTies(){ //------------------------------------------------------------------------------------------------------------------
      return numTies;
   }

   public void setNumTies(int num){ //----------------------------------------------------------------------------------------------------------
      numTies = num;
   }

   public int getNumLosses(){ //----------------------------------------------------------------------------------------------------------------
      return numLosses;
   }

   public void setNumLosses(int num){ //--------------------------------------------------------------------------------------------------------
      numLosses = num;
   }


   
} // End ---------------------------------------------------------------------------------------------------------------------------------------