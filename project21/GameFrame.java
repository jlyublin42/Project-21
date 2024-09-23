package project21;

import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame { //--------------------------------------------------------------------
 
   private final int WINDOW_WIDTH = 1600;
   private final int WINDOW_HEIGHT = 1000;
   private Color background = new Color(0x176121);
   private ImageIcon logo = new ImageIcon("Logo21.jpg");
   
   // GameFrame will be the Parent of these panels
   StartGamePanel startGamePanel = new StartGamePanel(this); // Opens startGamePanel after initilizing GameFrame
   OnePlayerGame onePlayerGame = new OnePlayerGame(this);
   TwoPlayerGame twoPlayerGame = new TwoPlayerGame(this);
   ThreePlayerGame threePlayerGame = new ThreePlayerGame(this);

   
   // Constructor
   public GameFrame() { //------------------------------------------------------------------------------------
      
      this.setTitle("Project-21");
      this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLocationRelativeTo(null);
      this.setLayout(null);
      this.getContentPane().setBackground(background);
      this.setResizable(false);
      this.setIconImage(logo.getImage());
      
      
      // Adjusts the screens(panels) that are in GameFrame 
      startGamePanel.setBounds(400, 225, 800, 525);
      onePlayerGame.setBounds(0, 0, 1600, 1000);
      twoPlayerGame.setBounds(0, 0, 1600, 1000);
      threePlayerGame.setBounds(0, 0, 1600, 1000);
      // Hides game panels until selected later
      onePlayerGame.setVisible(false);          
      twoPlayerGame.setVisible(false);                       
      threePlayerGame.setVisible(false);                       
      
      this.add(startGamePanel);
      this.add(onePlayerGame);
      this.add(twoPlayerGame);
      this.add(threePlayerGame);
      
      
   }
   
   public void selectGame(int panel){ //----------------------------------------------------------------------
      
      startGamePanel.setVisible(false);
      
      if (panel == 1){
         onePlayerGame.setVisible(true);
      } else if (panel == 2){
         twoPlayerGame.setVisible(true);
      } else if (panel == 3){
         threePlayerGame.setVisible(true);
      }
      
   }
 
} //  End  ---------------------------------------------------------------------------------------------------
