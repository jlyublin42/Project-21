package blackjack;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class GameFrame extends JFrame { //--------------------------------------------------------------------
 
   private final int WINDOW_WIDTH = 1600;
   private final int WINDOW_HEIGHT = 1000;

   
   // Constructor
   public GameFrame() { //------------------------------------------------------------------------------------
      
      this.setTitle("BlackJack");
      this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLocationRelativeTo(null);
      this.setLayout(new BorderLayout());
      this.getContentPane().setBackground(Color.lightGray);
      this.setResizable(false);
      // this.setIconImage(logo.getImage());
      
      
      GamePanel gamePanel = new GamePanel();
      InfoPanel infoPanel = new InfoPanel();
      
      JPanel bottomPanel = new JPanel();
      bottomPanel.setPreferredSize(new Dimension (1600, 50));
      bottomPanel.setBackground(Color.darkGray);
      bottomPanel.setLayout(new BorderLayout());
      bottomPanel.setBorder(BorderFactory.createLoweredBevelBorder());     
      
      
      this.add(gamePanel, BorderLayout.CENTER);
      this.add(infoPanel, BorderLayout.SOUTH);
      
   }
 
} //  End  ---------------------------------------------------------------------------------------------------
