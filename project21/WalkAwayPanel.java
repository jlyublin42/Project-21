package project21;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WalkAwayPanel extends JPanel { //---------------------------------------------------------------
   
   private final int PANEL_WIDTH = 800;
   private final int PANEL_HEIGHT = 800;
   private final Color color = new Color(0x8c8c8c);
   private final ImageIcon project21 = new ImageIcon("project21.png");
   private final Font font = new Font("Arial", Font.BOLD, 20);
 
  
   // Constructor
   public WalkAwayPanel(GameFrame parent) { //-------------------------------------------------------------------------------
      
      this.setSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
      this.setBackground(Color.darkGray);
      this.setLayout(null);
      this.setBorder(BorderFactory.createRaisedBevelBorder());
      
      // Project-21 Logo
      JLabel logoLabel = new JLabel(project21);
      logoLabel.setBounds(250, 20, 300, 300);

      // Create start and exit buttons
      JButton nextRoundBtn = new JButton("New Round");
      nextRoundBtn.setMnemonic(KeyEvent.VK_R);
      nextRoundBtn.setBounds(250, 470, 160, 30);
      nextRoundBtn.setFont(font);
      JButton exitBtn = new JButton("Exit");
      exitBtn.setMnemonic(KeyEvent.VK_X);
      exitBtn.setBounds(430, 470, 80, 30);
      exitBtn.setFont(font);


      this.add(logoLabel);
      this.add(nextRoundBtn);
      this.add(exitBtn);



      exitBtn.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
        
          System.exit(0);
              
         }
         
      });
  
      
   } // End Constructor

   
} // ------------------------------------------------------------------------------------------------------------------------