package project21;

import java.awt.*;
import javax.swing.*;

public class TwoPlayerGame extends JPanel { //----------------------------------------------------------------
   
   private final int PANEL_WIDTH = 1600;
   private final int PANEL_HEIGHT = 1000;
   private Color color = new Color(0x176121);
   private ImageIcon project21 = new ImageIcon("project21.png");
   private Font font = new Font("Arial", Font.BOLD, 18);
   JLabel playerOneName;
   JLabel playerTwoName;
   
   //Constructor
   public TwoPlayerGame(GameFrame parent) { //----------------------------------------------------------------
      
      this.setSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
      this.setBackground(Color.lightGray);
      this.setLayout(null);
      this.setVisible(true);
      
      
      playerOneName = new JLabel();
      playerOneName.setBounds(200, 200, 180, 20);
      playerOneName.setBackground(Color.lightGray);
      playerOneName.setFont(font);
      
      playerTwoName = new JLabel();
      playerTwoName.setBounds(200, 225, 180, 20);
      playerTwoName.setBackground(Color.lightGray);
      playerTwoName.setFont(font);
      
      this.add(playerOneName);
      this.add(playerTwoName);
      
   }

   public void setPlayerOneName(String name){ //---------------------------------------------------------------
      playerOneName.setText(name);
   }

   public void setPlayerTwoName(String name){ //---------------------------------------------------------------
      playerTwoName.setText(name);
   }
   
} // End------------------------------------------------------------------------------------------------------