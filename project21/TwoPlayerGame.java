package project21;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class TwoPlayerGame extends JPanel { //----------------------------------------------------------------------------------------
   
   private final int PANEL_WIDTH = 1600;
   private final int PANEL_HEIGHT = 1000;
   private Color background = new Color(0x176121);
   private final ImageIcon project21 = new ImageIcon("project21sm.png");
   private final ImageIcon cardBack = new ImageIcon("CardBacksm.png");
   private final Font font = new Font("Arial", Font.BOLD, 20);
   private final Font font2 = new Font("Arial", Font.BOLD, 18);
   private final Font font3 = new Font("Arial", Font.BOLD, 16);
   private final Font font4 = new Font("Arial", Font.BOLD, 14);
   GameFrame parent;
   Random random;
   int rdm;
   JPanel infoPanel = new JPanel();
   JPanel playerOnePanel;
   JPanel playerOneCards;
   JPanel playerTwoPanel;
   JPanel playerTwoCards;
   JPanel dealerCards;
   JPanel buttonPanel;
   JPanel buttonPanel2;
   JButton dealButton;
   JButton hitButton;
   JButton stayButton;
   JButton nextHandButton;
   JButton walkAwayButton;
   Boolean plyrTwoTurn = false;
   String comboBoxResult;
   JLabel playerOneName;
   String nameOne;
   JLabel bankLabel;
   JLabel bankRoll;
   JLabel betLabel;
   JLabel betNumLabel;
   JButton allIn;
   JButton placeBet;
   JButton minus;
   JButton plus;
   JLabel playerTwoName;
   String nameTwo;
   JLabel bankLabel2;
   JLabel bankRoll2;
   JLabel betLabel2;
   JLabel betNumLabel2;
   JButton allIn2;
   JButton placeBet2;
   JButton minus2;
   JButton plus2;
   JTextField info;
   int betOne = 25;
   int betTwo = 25;
   int bankOne = 500;
   int bankTwo = 500;
   JLabel[] cards = new JLabel[15];
   Boolean confirmed = false;
   Deck deck;
   Hand playerOneHand;
   Hand playerTwoHand;
   Hand dealerHand;
   int count = 0;
   int countChange = 0;
   int plyrOneCardValue = 0;
   int plyrTwoCardValue = 0;
   int dlrCardValue = 0;
   Card dlrFirstCard;
   int numHands = 0;
   int numWins = 0;
   int numTies = 0;
   int numLosses = 0;

   JLabel comboBox;
   
   //Constructor
   public TwoPlayerGame(GameFrame parent) { //--------------------------------------------------------------------------------------------
      
      this.setSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
      this.setBackground(background);
      this.setLayout(null);
      this.setVisible(true);
      this.parent = parent;

      random = new Random();

   } // End Constructor ------------------------------------------------------------------------------------------------------------------


   // User Game Setup
   public void userInit(){ //-------------------------------------------------------------------------------------------------------------

      // Project 21 Logo
      JLabel logoLabel = new JLabel(project21);
      logoLabel.setBounds(700, 300, 200, 200);

      // Card Deck - Top Right
      JLabel cardDeck = new JLabel(cardBack);
      cardDeck.setBounds(1420, 50, 120, 137);


      // PlayerOne Cards
      playerOneCards = new JPanel();
      playerOneCards.setBackground(background);
      playerOneCards.setBounds(50, 560, 650, 153);
      playerOneCards.setLayout(new FlowLayout());
      playerOneCards.setBorder(BorderFactory.createLineBorder(Color.black, 3));
      playerOneCards.add(cards[0] = new JLabel()); //First card dealt
      playerOneCards.add(cards[3] = new JLabel()); //Fourth card dealt
      playerOneCards.add(cards[6] = new JLabel());
      playerOneCards.add(cards[7] = new JLabel());
      playerOneCards.add(cards[8] = new JLabel()); 

      // PlayerTwo Cards
      playerTwoCards = new JPanel();
      playerTwoCards.setBackground(background);
      playerTwoCards.setBounds(890, 560, 650, 153);
      playerTwoCards.setLayout(new FlowLayout());
      playerTwoCards.setBorder(BorderFactory.createLineBorder(Color.black, 3));
      playerTwoCards.add(cards[1] = new JLabel()); //Second card dealt
      playerTwoCards.add(cards[4] = new JLabel()); //Fifth card dealt
      playerTwoCards.add(cards[9] = new JLabel());
      playerTwoCards.add(cards[10] = new JLabel());
      playerTwoCards.add(cards[11] = new JLabel()); 

      // Dealer Cards
      dealerCards = new JPanel();
      dealerCards.setBackground(background);
      dealerCards.setBounds(475, 50, 650, 153);
      dealerCards.setLayout(new FlowLayout());
      dealerCards.setBorder(BorderFactory.createLineBorder(Color.black, 3));
      dealerCards.add(cards[2] = new JLabel()); //Third card dealt
      dealerCards.add(cards[5] = new JLabel()); //Sixth card dealt
      dealerCards.add(cards[12] = new JLabel());
      dealerCards.add(cards[13] = new JLabel());
      dealerCards.add(cards[14] = new JLabel());



      // playerOnePanel should be located underneath playerOne Cards
      playerOnePanel = new JPanel();
      playerOnePanel.setLayout(null);
      playerOnePanel.setBounds(50, 713, 650, 30);
      playerOnePanel.setBackground(Color.darkGray);
      playerOnePanel.setBorder(BorderFactory.createLoweredBevelBorder());

      playerOneName = new JLabel();
      playerOneName.setBounds(5, 2, 110, 25);
      playerOneName.setForeground(Color.white);
      playerOneName.setFont(font3);

      bankLabel = new JLabel();
      bankLabel.setText("Bank:");
      bankLabel.setBounds(120, 2, 50, 25);
      bankLabel.setForeground(Color.lightGray);
      bankLabel.setFont(font3);

      bankRoll = new JLabel();
      bankRoll.setText("$ " + bankOne);
      bankRoll.setBounds(170, 2, 70, 25);
      bankRoll.setBorder(BorderFactory.createLoweredBevelBorder());
      bankRoll.setBackground(Color.darkGray);
      bankRoll.setForeground(Color.white);
      bankRoll.setFont(font3);

      // Bet labels and buttons
      betLabel = new JLabel();
      betLabel.setText("Bet:");
      betLabel.setBounds(435, 2, 35, 25);
      betLabel.setBackground(Color.darkGray);
      betLabel.setForeground(Color.lightGray);
      betLabel.setFont(font3);

      betNumLabel = new JLabel();
      betNumLabel.setText("$ " + betOne);
      betNumLabel.setBounds(475, 2, 70, 25);
      betNumLabel.setBorder(BorderFactory.createLoweredBevelBorder());
      betNumLabel.setBackground(Color.darkGray);
      betNumLabel.setForeground(Color.white);
      betNumLabel.setFont(font3);

      placeBet = new JButton("Place Bet");
      placeBet.setMnemonic(KeyEvent.VK_B);
      placeBet.setBounds(325, 5, 100, 20);
      placeBet.setFont(font4);

      allIn = new JButton("All In");
      allIn.setMnemonic(KeyEvent.VK_A);
      allIn.setBounds(250, 5, 70, 20);
      allIn.setFont(font4);

      minus = new JButton("-");
      minus.setBounds(600, 5, 45, 20);
      minus.setFont(font2);
      plus = new JButton("+");
      plus.setBounds(550, 5, 45, 20);
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





      // playerTwoPanel should be located underneath playerOne Cards
      playerTwoPanel = new JPanel();
      playerTwoPanel.setLayout(null);
      playerTwoPanel.setBounds(890, 713, 650, 30);
      playerTwoPanel.setBackground(Color.darkGray);
      playerTwoPanel.setBorder(BorderFactory.createLoweredBevelBorder());

      playerTwoName = new JLabel();
      playerTwoName.setBounds(5, 2, 110, 25);
      playerTwoName.setForeground(Color.white);
      playerTwoName.setFont(font3);

      bankLabel2 = new JLabel();
      bankLabel2.setText("Bank:");
      bankLabel2.setBounds(120, 2, 50, 25);
      bankLabel2.setForeground(Color.lightGray);
      bankLabel2.setFont(font3);

      bankRoll2 = new JLabel();
      bankRoll2.setText("$ " + bankTwo);
      bankRoll2.setBounds(170, 2, 70, 25);
      bankRoll2.setBorder(BorderFactory.createLoweredBevelBorder());
      bankRoll2.setBackground(Color.darkGray);
      bankRoll2.setForeground(Color.white);
      bankRoll2.setFont(font3);

      // Bet labels and buttons
      betLabel2 = new JLabel();
      betLabel2.setText("Bet:");
      betLabel2.setBounds(435, 2, 35, 25);
      betLabel2.setBackground(Color.darkGray);
      betLabel2.setForeground(Color.lightGray);
      betLabel2.setFont(font3);

      betNumLabel2 = new JLabel();
      betNumLabel2.setText("$ " + betTwo);
      betNumLabel2.setBounds(475, 2, 70, 25);
      betNumLabel2.setBorder(BorderFactory.createLoweredBevelBorder());
      betNumLabel2.setBackground(Color.darkGray);
      betNumLabel2.setForeground(Color.white);
      betNumLabel2.setFont(font3);

      placeBet2 = new JButton("Place Bet");
      placeBet2.setMnemonic(KeyEvent.VK_B);
      placeBet2.setBounds(325, 5, 100, 20);
      placeBet2.setFont(font4);

      allIn2 = new JButton("All In");
      allIn2.setMnemonic(KeyEvent.VK_A);
      allIn2.setBounds(250, 5, 70, 20);
      allIn2.setFont(font4);

      minus2 = new JButton("-");
      minus2.setBounds(600, 5, 45, 20);
      minus2.setFont(font2);
      plus2 = new JButton("+");
      plus2.setBounds(550, 5, 45, 20);
      plus2.setFont(font2);


      // Add Components to playerOnePanel
      playerTwoPanel.add(playerTwoName);
      playerTwoPanel.add(bankLabel2);
      playerTwoPanel.add(bankRoll2);
      playerTwoPanel.add(betLabel2);
      playerTwoPanel.add(betNumLabel2);
      playerTwoPanel.add(minus2);
      playerTwoPanel.add(plus2);
      playerTwoPanel.add(placeBet2);
      playerTwoPanel.add(allIn2);
      
      
      

      
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

      
      
      this.add(logoLabel);
      this.add(cardDeck);
      this.add(playerOneCards);
      this.add(playerTwoCards);
      this.add(dealerCards);
      this.add(playerOnePanel);
      this.add(playerTwoPanel);
      this.add(buttonPanel);
      this.add(buttonPanel2);
      this.add(infoPanel);


      // Initialize Deck and Hands
      deck = new Deck();
      playerOneHand = new Hand();
      playerTwoHand = new Hand();
      dealerHand = new Hand();



      // Button ActionListeners ---------------------------------
      //---------------------------------------------------------

      // Player One Button Listeners
      plus.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
           
            if (betOne < bankOne){
               betOne+= 25;
               betNumLabel.setText("$ " + betOne);
            }
         }
         
      });

      minus.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            
            if(betOne > 25){
               betOne-= 25;
               betNumLabel.setText("$ " + betOne);
            }
         }
         
      });

      placeBet.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            
            subtractBankRoll(betOne, 1);
            setBankRoll(1);
            placeBet.setVisible(false);
            allIn.setVisible(false);
            plus.setEnabled(false);
            minus.setEnabled(false);

            if (confirmed){
               dealButton.setEnabled(true);
               info.setText("Press DEAL to deal the cards");
               nextHandButton.setEnabled(false);
               walkAwayButton.setEnabled(false);
            } else {
               confirmed = true;
            }  

         }
         
      });

      allIn.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            
            betOne = bankOne;
            betNumLabel.setText("$ " + betOne);

         }
         
      });



      // Player Two Button Listeners
      plus2.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
           
            if (betTwo < bankTwo){
               betTwo+= 25;
               betNumLabel2.setText("$ " + betTwo);
            }
         }
         
      });

      minus2.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            
            if(betTwo > 25){
               betTwo-= 25;
               betNumLabel2.setText("$ " + betTwo);
            }
         }
         
      });

      placeBet2.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            
            subtractBankRoll(betTwo, 2);
            setBankRoll(2);
            placeBet2.setVisible(false);
            allIn2.setVisible(false);
            plus2.setEnabled(false);
            minus2.setEnabled(false);

            if (confirmed){
               dealButton.setEnabled(true);
               info.setText("Press DEAL to deal the cards");
               nextHandButton.setEnabled(false);
               walkAwayButton.setEnabled(false);
            } else {
               confirmed = true;
            }  

         }
         
      });

      allIn2.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            
            betTwo = bankTwo;
            betNumLabel2.setText("$ " + betTwo);

         }
         
      });



      dealButton.addActionListener(new ActionListener(){

         public void actionPerformed(ActionEvent e) {

            dealButton.setEnabled(false);
            hitButton.setEnabled(true);
            stayButton.setEnabled(true);
            nextHandButton.setEnabled(false);
            walkAwayButton.setEnabled(false);

            for (int i = 0; i < 6; i++){
               Card cardIdx = deck.drawCard(i);
               if (i == 2){
                  cards[i].setIcon(cardBack);
                  dlrFirstCard = cardIdx;
               } else {
                  cards[i].setIcon(deck.getIconSm(cardIdx.getCardNum()));
               }
               count++;
               if (i == 0 || i == 3){
                  playerOneHand.addCard(deck.drawCard(i));
                  plyrOneCardValue = playerOneHand.getTotalValue();
                  System.out.println(plyrOneCardValue);
                  if (plyrOneCardValue == 21){
                     hitButton.setEnabled(false);
                  }
               }else if (i == 1 || i == 4) {
                  playerTwoHand.addCard(deck.drawCard(i));
                  plyrTwoCardValue = playerTwoHand.getTotalValue();
                  System.out.println(plyrTwoCardValue);
               }else {
                  dealerHand.addCard(deck.drawCard(i));
                  dlrCardValue = dealerHand.getTotalValue();
                  System.out.println(dlrCardValue);
               }
            } 
            
            if (plyrOneCardValue == 21){
               hitButton.setEnabled(false);
               info.setText(nameOne + " You Have " + plyrOneCardValue + " Press STAY");
            } else {
               info.setText(nameOne + " You Have " + plyrOneCardValue + " Press HIT or Press STAY");
            }

            if (numHands == 0){
               numHands++;
            }

         }

      });

      hitButton.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {

            if (count == 12){
               hitButton.setEnabled(false);
            } else if (!plyrTwoTurn){
               if (plyrOneCardValue < 22){
                  plyrOneHit();
               } 
            } else if (plyrTwoTurn){
               if (plyrTwoCardValue < 22){
                  plyrTwoHit();
               }
            }  

         }
      });


      stayButton.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {

            if(!plyrTwoTurn){
               count = 9;
               plyrTwoTurn = true;
               if (plyrTwoCardValue == 21){
                  info.setText(nameTwo + " You Have " + plyrTwoCardValue + " Press STAY");
                  hitButton.setEnabled(false);
               } else {
                  hitButton.setEnabled(true);
                  info.setText(nameTwo + " You Have " + plyrTwoCardValue + " Press HIT or Press STAY");
               }
            } else {
               cards[2].setIcon(deck.getIconSm(dlrFirstCard.getCardNum()));
               dlrCardValue = dealerHand.getTotalValue();
               info.setText("Dealer Has " + dlrCardValue);
               if (dlrCardValue == 21){
                  checkWinner();
               } else {
                  for (int i = 12; i < 15; i++){
                     if (dlrCardValue < 17 && dlrCardValue < plyrOneCardValue && dlrCardValue < plyrTwoCardValue){
                        Card cardIdx = deck.drawCard(count);
                        cards[i].setIcon(deck.getIconSm(cardIdx.getCardNum()));
                        dealerHand.addCard(deck.drawCard(count));
                        dlrCardValue = dealerHand.getTotalValue();
                        if (dlrCardValue > 21){
                           info.setText("Dealer Is Bust");
                        } else{
                           info.setText("Dealer Has " + dlrCardValue);
                        }
                        System.out.println(dlrCardValue);
                        count++;
                        
                     }
                  }
                  checkWinner();
               }
               
            }
            

            //checkWinner();

         }
         
      });


      nextHandButton.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            
            minus.setEnabled(true);
            plus.setEnabled(true);
            placeBet.setVisible(true);
            allIn.setVisible(true);
            minus2.setEnabled(true);
            plus2.setEnabled(true);
            placeBet2.setVisible(true);
            allIn2.setVisible(true);
            hitButton.setEnabled(false);
            stayButton.setEnabled(false);
            info.setText("Press PLACE BET to place your bet for this hand");

            for (int i = 0; i < 15; i++){
               cards[i].setIcon(null);
            }

            count = 0;
            plyrOneCardValue = 0;
            plyrTwoCardValue = 0;
            dlrCardValue = 0;
            plyrTwoTurn = false;
            confirmed = false;

            playerOneHand.clearHand();
            playerTwoHand.clearHand();
            dealerHand.clearHand();

            if (betOne > bankOne){
               betOne = 25;
               betNumLabel.setText("$ " + betOne);
            }

            if (betTwo > bankTwo){
               betTwo = 25;
               betNumLabel2.setText("$ " + betTwo);
            }

            deck.shuffle();

         }
         
      });


   } // End userInit ----------------------------------------------------------------------------------------------------------------------




   public void plyrOneHit(){ //------------------------------------------------------------------------------------------------------------

      if ( count == 6 || count == 7){
         Card cardIdx = deck.drawCard(count);
         cards[count].setIcon(deck.getIconSm(cardIdx.getCardNum()));
         playerOneHand.addCard(deck.drawCard(count));
         plyrOneCardValue = playerOneHand.getTotalValue();
         if (plyrOneCardValue > 21){
            info.setText(nameOne + " Has Bust. " + nameTwo + " You Have " + plyrTwoCardValue + " Press HIT or Press STAY");
            plyrTwoTurn = true; 
            count = 8;
         } else if (plyrOneCardValue == 21){
            info.setText(nameOne + " You Have " + plyrOneCardValue + " Press STAY");
            hitButton.setEnabled(false);
         } else {
            info.setText(nameOne + " You Have " + plyrOneCardValue + " Press HIT or Press STAY");
            System.out.println(plyrOneCardValue);
         }
      } else if (count == 8){
         Card cardIdx = deck.drawCard(count);
         cards[count].setIcon(deck.getIconSm(cardIdx.getCardNum()));
         playerOneHand.addCard(deck.drawCard(count));
         plyrOneCardValue = playerOneHand.getTotalValue();
         if (plyrOneCardValue > 21){
            info.setText(nameOne + " Has Bust. " + nameTwo + " You Have " + plyrTwoCardValue + " Press HIT or Press STAY");
            plyrTwoTurn = true;   
         } else if (plyrOneCardValue == 21){
            info.setText(nameOne + " You Have " + plyrOneCardValue + " Press STAY");
            hitButton.setEnabled(false);
         } else {
            info.setText(nameOne + " You Have " + plyrOneCardValue + " Press STAY");
            hitButton.setEnabled(false);
            System.out.println(plyrOneCardValue);
         }
      }
      count++;

   }

   public void plyrTwoHit(){ //----------------------------------------------------------------------------------------------------------

      if (count == 9 || count == 10){
         Card cardIdx = deck.drawCard(count);
         cards[count].setIcon(deck.getIconSm(cardIdx.getCardNum()));
         playerTwoHand.addCard(deck.drawCard(count));
         plyrTwoCardValue = playerTwoHand.getTotalValue();
         if (plyrTwoCardValue > 21){
            info.setText(nameTwo + " You Have Bust.");
            hitButton.setEnabled(false);
            stayButton.setEnabled(false);
            showDealersCards();
            nextHandButton.setEnabled(true);
            checkWinner();   
            } else if (plyrTwoCardValue == 21){
               hitButton.setEnabled(false);
               info.setText(nameTwo + " You have " + plyrTwoCardValue + " Press STAY");
            } else {
               info.setText(nameTwo + " You Have " + plyrTwoCardValue + " Press HIT or Press STAY");
               System.out.println(plyrTwoCardValue);
            }
         } else if (count == 11){
            Card cardIdx = deck.drawCard(count);
            cards[count].setIcon(deck.getIconSm(cardIdx.getCardNum()));
            playerTwoHand.addCard(deck.drawCard(count));
            plyrTwoCardValue = playerTwoHand.getTotalValue();
            if (plyrTwoCardValue > 21){
               info.setText(nameTwo + " You Have Bust.");
               hitButton.setEnabled(false);
               stayButton.setEnabled(false);
               showDealersCards();
               nextHandButton.setEnabled(true);
               checkWinner();   
            } else if (plyrTwoCardValue == 21){
               hitButton.setEnabled(false);
               info.setText(nameTwo + " You have " + plyrTwoCardValue + " Press STAY");
            } else {
               info.setText(nameTwo + " You Have " + plyrTwoCardValue + " Press STAY");
               hitButton.setEnabled(false);
               System.out.println(plyrTwoCardValue);
            }
         }
      count++;

   }

   public void showDealersCards(){ //--------------------------------------------------------------------------------------------------

      count++;
      if (plyrOneCardValue > 21 && plyrTwoCardValue > 21){
         cards[2].setIcon(deck.getIconSm(dlrFirstCard.getCardNum()));
      } else {
         cards[2].setIcon(deck.getIconSm(dlrFirstCard.getCardNum()));
         dlrCardValue = dealerHand.getTotalValue();
         if (dlrCardValue == 21){
            checkWinner();
         }else{
            for (int i = 12; i < 15; i++){
               if (dlrCardValue < plyrOneCardValue || dlrCardValue < plyrTwoCardValue && dlrCardValue < 17){
                  Card cardIdx = deck.drawCard(count);
                  cards[i].setIcon(deck.getIconSm(cardIdx.getCardNum()));
                  dealerHand.addCard(deck.drawCard(count));
                  dlrCardValue = dealerHand.getTotalValue();
                  System.out.println(dlrCardValue);
                  count++;
                  }
            }
         }
         checkWinner();
      }


   }


   // AI Game Setup
   public void aiInit(){ //---------------------------------------------------------------------------------------------------------------------------

       // Project 21 Logo
       JLabel logoLabel = new JLabel(project21);
       logoLabel.setBounds(700, 300, 200, 200);
 
       // Card Deck - Top Right
       JLabel cardDeck = new JLabel(cardBack);
       cardDeck.setBounds(1420, 50, 120, 137);
 
 
       // PlayerOne Cards
       playerOneCards = new JPanel();
       playerOneCards.setBackground(background);
       playerOneCards.setBounds(50, 560, 650, 153);
       playerOneCards.setLayout(new FlowLayout());
       playerOneCards.setBorder(BorderFactory.createLineBorder(Color.black, 3));
       playerOneCards.add(cards[0] = new JLabel()); //First card dealt
       playerOneCards.add(cards[3] = new JLabel()); //Fourth card dealt
       playerOneCards.add(cards[6] = new JLabel());
       playerOneCards.add(cards[7] = new JLabel());
       playerOneCards.add(cards[8] = new JLabel()); 
 
       // PlayerTwo Cards
       playerTwoCards = new JPanel();
       playerTwoCards.setBackground(background);
       playerTwoCards.setBounds(890, 560, 650, 153);
       playerTwoCards.setLayout(new FlowLayout());
       playerTwoCards.setBorder(BorderFactory.createLineBorder(Color.black, 3));
       playerTwoCards.add(cards[1] = new JLabel()); //Second card dealt
       playerTwoCards.add(cards[4] = new JLabel()); //Fifth card dealt
       playerTwoCards.add(cards[9] = new JLabel());
       playerTwoCards.add(cards[10] = new JLabel());
       playerTwoCards.add(cards[11] = new JLabel()); 
 
       // Dealer Cards
       dealerCards = new JPanel();
       dealerCards.setBackground(background);
       dealerCards.setBounds(475, 50, 650, 153);
       dealerCards.setLayout(new FlowLayout());
       dealerCards.setBorder(BorderFactory.createLineBorder(Color.black, 3));
       dealerCards.add(cards[2] = new JLabel()); //Third card dealt
       dealerCards.add(cards[5] = new JLabel()); //Sixth card dealt
       dealerCards.add(cards[12] = new JLabel());
       dealerCards.add(cards[13] = new JLabel());
       dealerCards.add(cards[14] = new JLabel());
 
 
       
    
 
 
       // playerOnePanel should be located underneath playerOne Cards
       playerOnePanel = new JPanel();
       playerOnePanel.setLayout(null);
       playerOnePanel.setBounds(50, 713, 650, 30);
       playerOnePanel.setBackground(Color.darkGray);
       playerOnePanel.setBorder(BorderFactory.createLoweredBevelBorder());
 
       playerOneName = new JLabel();
       playerOneName.setBounds(5, 2, 110, 25);
       playerOneName.setForeground(Color.white);
       playerOneName.setFont(font3);
 
       bankLabel = new JLabel();
       bankLabel.setText("Bank:");
       bankLabel.setBounds(120, 2, 50, 25);
       bankLabel.setForeground(Color.lightGray);
       bankLabel.setFont(font3);
 
       bankRoll = new JLabel();
       bankRoll.setText("$ " + bankOne);
       bankRoll.setBounds(170, 2, 70, 25);
       bankRoll.setBorder(BorderFactory.createLoweredBevelBorder());
       bankRoll.setBackground(Color.darkGray);
       bankRoll.setForeground(Color.white);
       bankRoll.setFont(font3);
 
       // Bet labels and buttons
       betLabel = new JLabel();
       betLabel.setText("Bet:");
       betLabel.setBounds(435, 2, 35, 25);
       betLabel.setBackground(Color.darkGray);
       betLabel.setForeground(Color.lightGray);
       betLabel.setFont(font3);
 
       betNumLabel = new JLabel();
       betNumLabel.setText("$ " + betOne);
       betNumLabel.setBounds(475, 2, 70, 25);
       betNumLabel.setBorder(BorderFactory.createLoweredBevelBorder());
       betNumLabel.setBackground(Color.darkGray);
       betNumLabel.setForeground(Color.white);
       betNumLabel.setFont(font3);
 
       placeBet = new JButton("Place Bet");
       placeBet.setMnemonic(KeyEvent.VK_B);
       placeBet.setBounds(325, 5, 100, 20);
       placeBet.setFont(font4);
 
       allIn = new JButton("All In");
       allIn.setMnemonic(KeyEvent.VK_A);
       allIn.setBounds(250, 5, 70, 20);
       allIn.setFont(font4);
 
       minus = new JButton("-");
       minus.setBounds(600, 5, 45, 20);
       minus.setFont(font2);
       plus = new JButton("+");
       plus.setBounds(550, 5, 45, 20);
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
 
 
 
 
 
       // playerTwoPanel should be located underneath playerOne Cards
       playerTwoPanel = new JPanel();
       playerTwoPanel.setLayout(null);
       playerTwoPanel.setBounds(890, 713, 650, 30);
       playerTwoPanel.setBackground(Color.darkGray);
       playerTwoPanel.setBorder(BorderFactory.createLoweredBevelBorder());
 
       playerTwoName = new JLabel();
       playerTwoName.setBounds(5, 2, 190, 25);
       playerTwoName.setForeground(Color.white);
       playerTwoName.setFont(font3);
 
       bankLabel2 = new JLabel();
       bankLabel2.setText("Bank:");
       bankLabel2.setBounds(200, 2, 50, 25);
       bankLabel2.setForeground(Color.lightGray);
       bankLabel2.setFont(font3);
 
       bankRoll2 = new JLabel();
       bankRoll2.setText("$ " + bankTwo);
       bankRoll2.setBounds(250, 2, 70, 25);
       bankRoll2.setBorder(BorderFactory.createLoweredBevelBorder());
       bankRoll2.setBackground(Color.darkGray);
       bankRoll2.setForeground(Color.white);
       bankRoll2.setFont(font3);
 
       // Bet labels and buttons
       betLabel2 = new JLabel();
       betLabel2.setText("Bet:");
       betLabel2.setBounds(350, 2, 35, 25);
       betLabel2.setBackground(Color.darkGray);
       betLabel2.setForeground(Color.lightGray);
       betLabel2.setFont(font3);
 
       betNumLabel2 = new JLabel();
       betNumLabel2.setText("$ " + betTwo);
       betNumLabel2.setBounds(390, 2, 70, 25);
       betNumLabel2.setBorder(BorderFactory.createLoweredBevelBorder());
       betNumLabel2.setBackground(Color.darkGray);
       betNumLabel2.setForeground(Color.white);
       betNumLabel2.setFont(font3);
 
       
 
       // Add Components to playerOnePanel
       playerTwoPanel.add(playerTwoName);
       playerTwoPanel.add(bankLabel2);
       playerTwoPanel.add(bankRoll2);
       playerTwoPanel.add(betLabel2);
       playerTwoPanel.add(betNumLabel2);
 
       
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
 
       
       
       this.add(logoLabel);
       this.add(cardDeck);
       this.add(playerOneCards);
       this.add(playerTwoCards);
       this.add(dealerCards);
       this.add(playerOnePanel);
       this.add(playerTwoPanel);
       this.add(buttonPanel);
       this.add(buttonPanel2);
       this.add(infoPanel);
 
 
       // Initialize Deck and Hands
       deck = new Deck();
       playerOneHand = new Hand();
       playerTwoHand = new Hand();
       dealerHand = new Hand();
 
 
 
       // Button ActionListeners ---------------------------------
       //---------------------------------------------------------
 
       // Player One Button Listeners
       plus.addActionListener(new ActionListener() {
          
          public void actionPerformed(ActionEvent e) {
            
             if (betOne < bankOne){
                betOne+= 25;
                betNumLabel.setText("$ " + betOne);
             }
          }
          
       });
 
       minus.addActionListener(new ActionListener() {
          
          public void actionPerformed(ActionEvent e) {
             
             if(betOne > 25){
                betOne-= 25;
                betNumLabel.setText("$ " + betOne);
             }
          }
          
       });
 
       placeBet.addActionListener(new ActionListener() {
          
          public void actionPerformed(ActionEvent e) {
             
            subtractBankRoll(betOne, 1);
            setBankRoll(1);
            placeBet.setVisible(false);
            allIn.setVisible(false);
            plus.setEnabled(false);
            minus.setEnabled(false);
            aiBet();
            subtractBankRoll(betTwo, 2);
            setBankRoll(2);
            dealButton.setEnabled(true);
            info.setText("Press DEAL to deal the cards");
            nextHandButton.setEnabled(false);
            walkAwayButton.setEnabled(false);

          }
          
       });
 
       allIn.addActionListener(new ActionListener() {
          
          public void actionPerformed(ActionEvent e) {
             
             betOne = bankOne;
             betNumLabel.setText("$ " + betOne);
 
          }
          
       });
 
 
 
       dealButton.addActionListener(new ActionListener(){
 
          public void actionPerformed(ActionEvent e) {
 
             dealButton.setEnabled(false);
             hitButton.setEnabled(true);
             stayButton.setEnabled(true);
             nextHandButton.setEnabled(false);
             walkAwayButton.setEnabled(false);
 
             for (int i = 0; i < 6; i++){
                Card cardIdx = deck.drawCard(i);
                if (i == 2){
                   cards[i].setIcon(cardBack);
                   dlrFirstCard = cardIdx;
                } else {
                   cards[i].setIcon(deck.getIconSm(cardIdx.getCardNum()));
                }
                count++;
                if (i == 0 || i == 3){
                   playerOneHand.addCard(deck.drawCard(i));
                   plyrOneCardValue = playerOneHand.getTotalValue();
                   System.out.println(plyrOneCardValue);
                   if (plyrOneCardValue == 21){
                      hitButton.setEnabled(false);
                   }
                }else if (i == 1 || i == 4) {
                   playerTwoHand.addCard(deck.drawCard(i));
                   plyrTwoCardValue = playerOneHand.getTotalValue();
                   System.out.println(plyrTwoCardValue);
                   if (plyrTwoCardValue == 21){
                      hitButton.setEnabled(false);
                   }
                }else {
                   dealerHand.addCard(deck.drawCard(i));
                   dlrCardValue = dealerHand.getTotalValue();
                   System.out.println(dlrCardValue);
                }
             } 
             dealButton.setEnabled(false);
             info.setText("You have " + plyrOneCardValue + " Press HIT or Press STAY");
 
             if (numHands == 0){
                numHands++;
             }
 
          }
 
       });

   } // End aiInit -----------------------------------------------------------------------------------------------------------------------------------


   public void aiBet(){

      rdm = random.nextInt(20);

      if (rdm == 19){
         betTwo = bankTwo;
      } else if (rdm < 19 && rdm > 14) {
         if (bankTwo > 100){
            betTwo = 100;
         } else if (bankTwo <= 100 && bankTwo > 50){
            betTwo = 75;
         } else {
            betTwo = 25;
         }
      } else if (rdm < 15 && rdm > 7){
         if (bankTwo > 50){
            betTwo = 50;
         } else {
            betTwo = 25;
         }  
      } else if (rdm < 8){
         if (bankTwo > 0){
            betTwo = 25;
         }
      }
      setBetNum(betTwo);
   }




   public void setPlayerOneName(String name){ //------------------------------------------------------------------------------------------------------
      playerOneName.setText(name);
      nameOne = name;
   }

   public void setPlayerTwoName(String name){ //------------------------------------------------------------------------------------------------------
      playerTwoName.setText(name);
      nameTwo = name;
   }

   public void setPlayerTwoUser(String user){ //------------------------------------------------------------------------------------------------------
      comboBox.setText(user);
   }

   public void setBetNum(int num){ //-----------------------------------------------------------------------------------------------------------------
      betNumLabel2.setText("$ " + num);
   }

   public void setBankRoll(int num, int i){ //--------------------------------------------------------------------------------------------------------
      if (i == 1){
         bankRoll.setText("$ " + num);
      } else if (i == 2){
         bankRoll2.setText("$ " + num);
      }
   }

   public void setBankRoll(int i){ //------------------------------------------------------------------------------------------------------------------
      if (i == 1){
         bankRoll.setText("$ " + bankOne);
      } else if (i == 2){
         bankRoll2.setText("$ " + bankTwo);
      }
   }

   public int getBankRoll(int i){ //------------------------------------------------------------------------------------------------------------------
      int bank = 0;
      if (i == 1){
         bank = bankOne;
      } else if (i == 2){
         bank = bankTwo;
      } 
      return bank;
   }

   public void addBankRoll(int num, int i){ //---------------------------------------------------------------------------------------------------------
      if (i == 1){
         bankOne += num;
      } else if (i == 2){
         bankTwo += num;
      }
   }

   public void subtractBankRoll(int num, int i){ //----------------------------------------------------------------------------------------------------
      if (i == 1){
         bankOne -= num;
      } else if (i == 2){
         bankTwo -= num;
      }
   }


   private void checkWinner() { //-------------------------------------------------------------------------------------------------------------
      hitButton.setEnabled(false);
      stayButton.setEnabled(false);
      int plyrOneTotal = playerOneHand.getTotalValue();
      int plyrTwoTotal = playerTwoHand.getTotalValue();
      int dealerTotal = dealerHand.getTotalValue();

      if (plyrOneTotal > 21 && plyrTwoTotal > 21) {
         info.setText(nameOne + " Busted!  &  " + nameTwo + " Busted!  Dealer Wins.");
         numLosses++;
      } else if (dealerTotal > 21 && plyrOneTotal < 22 && plyrTwoTotal < 22) {
         info.setText("Dealer Busted! You Both Win.");
         numWins++;
      } else if (dealerTotal > 21 && plyrOneTotal > 21 && plyrTwoTotal < 22){
         info.setText("Dealer Busted! And " + nameOne + " Busted!  " + nameTwo + " Wins!");
      } else if (dealerTotal > 21 && plyrOneTotal < 22 && plyrTwoTotal > 21){
         info.setText("Dealer Busted! And " + nameTwo + " Busted!  " + nameOne + " Wins!");
      } else if (plyrOneTotal > dealerTotal && plyrTwoTotal > 21) {
         info.setText(nameOne + " Wins With " + plyrOneTotal + " Against " + dealerTotal + "!  " + nameTwo + " Busted!");
         numWins++;
      }  else if (plyrTwoTotal > dealerTotal && plyrOneTotal > 21) {
         info.setText(nameTwo + " Wins With " + plyrTwoTotal + " Against " + dealerTotal + "!  " + nameOne + " Busted!");
         numWins++;
      } else if (plyrOneTotal < dealerTotal && plyrTwoTotal > 21) {
         info.setText(nameOne + " Loses With " + plyrOneTotal + " Against " + dealerTotal + "!  " + nameTwo + " Busted!");
         numWins++;
      }  else if (plyrTwoTotal < dealerTotal && plyrOneTotal > 21) {
         info.setText(nameTwo + " Loses With " + plyrTwoTotal + " Against " + dealerTotal + "!  " + nameOne + " Busted!");
         numWins++;
      } else if (plyrOneTotal == dealerTotal && plyrTwoTotal > 21) {
         info.setText(nameOne + " Ties With " + plyrOneTotal + " Against " + dealerTotal + "!  " + nameTwo + " Busted!");
         numWins++;
      }  else if (plyrTwoTotal == dealerTotal && plyrOneTotal > 21) {
         info.setText(nameTwo + " Ties With " + plyrTwoTotal + " Against " + dealerTotal + "!  " + nameOne + " Busted!");
         numWins++;
      } else if (plyrOneTotal > dealerTotal && plyrTwoTotal > dealerTotal) {
         info.setText(nameOne + " Wins With " + plyrOneTotal + " And " + nameTwo + " Wins With " + plyrTwoTotal + " Against " + dealerTotal + "!");
         numWins++;
      } else if (plyrOneTotal > dealerTotal && plyrTwoTotal < dealerTotal) {
         info.setText(nameOne + " Wins With " + plyrOneTotal + " And " + nameTwo + " Loses With " + plyrTwoTotal + " Against " + dealerTotal + "!");
         numWins++;
      } else if (plyrOneTotal < dealerTotal && plyrTwoTotal > dealerTotal) {
         info.setText(nameOne + " Loses With " + plyrOneTotal + " And " + nameTwo + " Wins With " + plyrTwoTotal + " Against " + dealerTotal + "!");
         numWins++;
      } else if (plyrOneTotal > dealerTotal && plyrTwoTotal == dealerTotal) {
         info.setText(nameOne + " Wins With " + plyrOneTotal + " And " + nameTwo + " Ties With " + plyrTwoTotal + " Against " + dealerTotal + "!");
         numWins++;
      } else if (plyrOneTotal == dealerTotal && plyrTwoTotal > dealerTotal) {
         info.setText(nameOne + " Ties With " + plyrOneTotal + " And " + nameTwo + " Wins With " + plyrTwoTotal + " Against " + dealerTotal + "!");
         numWins++;
      }else if (plyrOneTotal < dealerTotal && plyrTwoTotal == dealerTotal) {
         info.setText(nameOne + " Loses With " + plyrOneTotal + " And " + nameTwo + " Ties With " + plyrTwoTotal + " Against " + dealerTotal + "!");
         numWins++;
      } else if (plyrOneTotal == dealerTotal && plyrTwoTotal < dealerTotal) {
         info.setText(nameOne + " Ties With " + plyrOneTotal + " And " + nameTwo + " Loses With " + plyrTwoTotal + " Against " + dealerTotal + "!");
         numWins++;
      } else if (plyrOneTotal < dealerTotal && plyrTwoTotal < dealerTotal) {
         info.setText(nameOne + " Loses With " + plyrOneTotal + " And " + nameTwo + " Loses With " + plyrTwoTotal + " Against " + dealerTotal + ". Dealer Wins!");
         numWins++;
      } else {
         info.setText("It's a tie!");
         System.out.println("It's a tie!");
         numTies++;
      }

   
      settleBets();
      System.out.println(numHands + " " + numWins);

   }


   private void settleBets(){ //--------------------------------------------------------------------------------------------------------------
      int plyrOneTotal = playerOneHand.getTotalValue();
      int plyrTwoTotal = playerTwoHand.getTotalValue();
      int dealerTotal = dealerHand.getTotalValue();
      int plyrOneWinnings = 0;
      int plyrTwoWinnings = 0;
         
      // Player One 
      if (plyrOneTotal > 21) {
         plyrOneWinnings = 0;
            addBankRoll(plyrOneWinnings, 1);
            setBankRoll(1);
      } else if (dealerTotal > 21) {
         if (plyrOneTotal == 21) {
            plyrOneWinnings = betOne * 3;
            addBankRoll(plyrOneWinnings, 1);
            setBankRoll(1);
         } else {
            plyrOneWinnings = betOne * 2;
            addBankRoll(plyrOneWinnings, 1);
            setBankRoll(1);
         }
      } else if (plyrOneTotal > dealerTotal && plyrOneTotal < 22) {
         if (plyrOneTotal == 21) {
            plyrOneWinnings = betOne * 3;
            addBankRoll(plyrOneWinnings,1);
            setBankRoll(1);
         } else {
            plyrOneWinnings = betOne * 2;
            addBankRoll(plyrOneWinnings, 1);
            setBankRoll(1);
         }
      } else if (plyrOneTotal < dealerTotal){
         plyrOneWinnings = 0;
         addBankRoll(plyrOneWinnings,1);
         setBankRoll(1);
      } else if (plyrOneTotal == dealerTotal){
         addBankRoll(betOne,1);
         setBankRoll(1);
      }


      // Player Two  
      if (plyrTwoTotal > 21) {
         plyrTwoWinnings = 0;
            addBankRoll(plyrTwoWinnings, 2);
            setBankRoll(2);
      } else if (dealerTotal > 21) {
         if (plyrTwoTotal == 21) {
            plyrTwoWinnings = betTwo * 3;
            addBankRoll(plyrTwoWinnings, 2);
            setBankRoll(2);
         } else {
            plyrTwoWinnings = betTwo * 2;
            addBankRoll(plyrTwoWinnings, 2);
            setBankRoll(2);
         }
      } else if (plyrTwoTotal > dealerTotal && plyrTwoTotal < 22) {
         if (plyrTwoTotal == 21) {
            plyrTwoWinnings = betTwo * 3;
            addBankRoll(plyrTwoWinnings,2);
            setBankRoll(2);
         } else {
            plyrTwoWinnings = betTwo * 2;
            addBankRoll(plyrTwoWinnings,2);
            setBankRoll(2);
         }
      } else if (plyrTwoTotal < dealerTotal){
         plyrTwoWinnings = 0;
         addBankRoll(plyrTwoWinnings,2);
         setBankRoll(2);
      } else if (plyrTwoTotal == dealerTotal){
         addBankRoll(betTwo,2);
         setBankRoll(2);
      }

      nextHandButton.setEnabled(true);
      walkAwayButton.setEnabled(true);


      /*if (bank == 0){
         nextHandButton.setEnabled(false);
         walkAwayButton.setEnabled(true);
      } else {
         nextHandButton.setEnabled(true);
         walkAwayButton.setEnabled(true);
      }*/

   }

   
} // End------------------------------------------------------------------------------------------------------