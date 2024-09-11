package blackjack;

import java.awt.*;
import javax.swing.*;

public class InfoPanel extends JPanel {
   
   private final int PANEL_WIDTH = 1600;
   private final int PANEL_HEIGHT = 50;
   private Font font = new Font("Verdana", Font.BOLD, 24);
   
   
   public InfoPanel() {
     
      this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
      this.setBackground(Color.darkGray);
      this.setLayout(new BorderLayout());
      this.setBorder(BorderFactory.createLoweredBevelBorder());     
      
      JTextField text = new JTextField("  Hit or Stay?  ");
      text.setFont(font);
      text.setBackground(Color.darkGray);
      text.setForeground(Color.lightGray);
      text.setBorder(BorderFactory.createLoweredBevelBorder());
      
      JTextField money = new JTextField("  Player 1:  $ 200  ");
      money.setFont(font);
      money.setBackground(Color.darkGray);
      money.setForeground(Color.lightGray);
      money.setBorder(BorderFactory.createLoweredBevelBorder());
      
      this.add(text, BorderLayout.EAST);
      this.add(money, BorderLayout.WEST);
     
   }
   
   
}
