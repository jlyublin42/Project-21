package blackjack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BettingPanel extends JPanel {
   
   private final int PANEL_WIDTH = 200;
   private final int PANEL_HEIGHT = 200;
   private Font font = new Font("Verdana", Font.BOLD, 24);
   private int bet = 5;
   
   
   public BettingPanel() {
     
      this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
      this.setBackground(Color.darkGray);
      this.setBorder(BorderFactory.createLoweredBevelBorder());
      
      JTextField wager = new JTextField("$ " + bet);
      wager.setPreferredSize(new Dimension(80,32));
      wager.setFont(font);
      wager.setBackground(Color.darkGray);
      wager.setForeground(Color.lightGray);
      
      JButton increaseBet = new JButton(" + ");
      JButton decreaseBet = new JButton(" - ");
      
      this.add(wager);
      this.add(increaseBet);
      this.add(decreaseBet);
      
      
      increaseBet.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            
            bet+= 5;
            wager.setText("$ " + bet);
            
         }
         
      });
      
      decreaseBet.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
        
            if (bet > 5){
               bet-= 5;
               wager.setText("$ " + bet);
            }
         }
         
      });
      
 
      
      
   }
}
