package project21;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ThreePlayerGame extends JPanel { //--------------------------------------------------------------
   
   private final int PANEL_WIDTH = 1600;
   private final int PANEL_HEIGHT = 1000;
   private Color color = new Color(0x176121);
   private ImageIcon project21 = new ImageIcon("project21.png"); 
   private Font font = new Font("Arial", Font.BOLD, 18);
   
   //Constructor
   public ThreePlayerGame(GameFrame parent) { //--------------------------------------------------------------
      
      this.setSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
      this.setBackground(Color.lightGray);
      this.setLayout(null);
      this.setVisible(true);
      
      
      JLabel playerOneName = new JLabel();
      playerOneName.setBounds(200, 200, 180, 20);
      playerOneName.setBackground(Color.lightGray);
      playerOneName.setFont(font);
      
      JLabel playerTwoName = new JLabel();
      playerTwoName.setBounds(200, 225, 180, 20);
      playerTwoName.setBackground(Color.lightGray);
      playerTwoName.setFont(font);
      
      JLabel playerThreeName = new JLabel();
      playerThreeName.setBounds(200, 250, 180, 20);
      playerThreeName.setBackground(Color.lightGray);
      playerThreeName.setFont(font);
      JLabel playerThreeUser = new JLabel();
      playerThreeUser.setBounds(400, 250, 180, 20);
      playerThreeUser.setBackground(Color.lightGray);
      playerThreeUser.setFont(font);
      
      this.add(playerOneName);
      this.add(playerTwoName);
      this.add(playerThreeName);
      this.add(playerThreeUser);
      
      playerOneName.setText(parent.startGamePanel.getPlayerOneName());
      playerTwoName.setText(parent.startGamePanel.getPlayerTwoName());
      playerThreeName.setText(parent.startGamePanel.getPlayerThreeName());
      playerThreeUser.setText(parent.startGamePanel.getPlayerThreeComboBox());
      
    
   }
   
} // End------------------------------------------------------------------------------------------------------