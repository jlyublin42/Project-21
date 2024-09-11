package blackjack;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.util.Vector;

import javax.swing.border.LineBorder;
import javax.swing.event.*;

public class GamePanel extends JPanel { //--------------------------------------------------------------------
   
   private final int PANEL_WIDTH = 1600;
   private final int PANEL_HEIGHT = 600;
   private Color background = new Color(0x176121);
   private ImageIcon spadeA = new ImageIcon("SpadeAsm.png");
   private ImageIcon spade2 = new ImageIcon("Spade2sm.png");
   private ImageIcon spade3 = new ImageIcon("Spade3sm.png");
   private ImageIcon spade4 = new ImageIcon("Spade4sm.png");
   private ImageIcon spadeJ = new ImageIcon("SpadeJsm.png");
   private ImageIcon club2 = new ImageIcon("Club2sm.png");
   private ImageIcon club6 = new ImageIcon("Club6sm.png");
   private ImageIcon diamond5 = new ImageIcon("Diamond5sm.png");
   private ImageIcon heartA = new ImageIcon("HeartAsm.png");
   private ImageIcon heart5 = new ImageIcon("Heart5sm.png");
   private ImageIcon heartK = new ImageIcon("HeartKsm.png");
   private ImageIcon cardBack = new ImageIcon("CardBacksm.png");
   private JPanel playerCards;
   private JPanel dealerCards;
   private JPanel buttonPanel;
   private JLabel card1 = new JLabel();
   private JLabel card2 = new JLabel();
   private JLabel card3 = new JLabel();
   private JLabel card4 = new JLabel();
   private JLabel card5 = new JLabel();
   private JLabel card6 = new JLabel();
   private JLabel card7 = new JLabel();
   private JLabel card8 = new JLabel();
   private JLabel card9 = new JLabel();
   private JLabel card10 = new JLabel();
   private JButton dealButton = new JButton("Deal");
   private JButton hitButton = new JButton("Hit");
   private JButton stayButton = new JButton("Stay");
   
   //Constructor
   public GamePanel() { //------------------------------------------------------------------------------------
      
      this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
      this.setBackground(background);
      this.setLayout(null);
      
      playerCards = new JPanel();
      playerCards.setBackground(background);
      playerCards.setBounds(350, 660, 800, 198);
      playerCards.setLayout(new FlowLayout());
      playerCards.setBorder(BorderFactory.createLineBorder(Color.black, 3));
      playerCards.add(card1); //First card dealt
      playerCards.add(card3); //Third card dealt
      playerCards.add(card5);
      playerCards.add(card6);
      playerCards.add(card7);
      
      dealerCards = new JPanel();
      dealerCards.setBackground(background);
      dealerCards.setBounds(350, 50, 800, 198);
      dealerCards.setLayout(new FlowLayout());
      dealerCards.setBorder(BorderFactory.createLineBorder(Color.black, 3));
      dealerCards.add(card2); //Second card dealt
      dealerCards.add(card4); //Fourth card dealt
      dealerCards.add(card8);
      dealerCards.add(card9);
      dealerCards.add(card10);
      
      buttonPanel = new JPanel();
      buttonPanel.setBackground(background);
      buttonPanel.setBounds(1350, 660, 200, 198);
      buttonPanel.setLayout(new FlowLayout());
      buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
      buttonPanel.add(dealButton);
      buttonPanel.add(hitButton);
      buttonPanel.add(stayButton);
      
      BettingPanel bettingPanel = new BettingPanel();
      bettingPanel.setBounds(50, 660, 200, 50);
      
      this.add(dealerCards, null);
      this.add(playerCards, null);
      this.add(buttonPanel, null);
      this.add(bettingPanel, null);
      
      
      dealButton.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            card1.setIcon(spade3);
            card2.setIcon(cardBack);
            card3.setIcon(heart5);
            card4.setIcon(spadeJ);
          
              
         }
         
      });
      
      
      hitButton.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            card5.setIcon(spade4);
            card6.setIcon(diamond5);
            card7.setIcon(club6);  
            
         }
       
      });

     
   }
   

} //  End  ---------------------------------------------------------------------------------------------------




