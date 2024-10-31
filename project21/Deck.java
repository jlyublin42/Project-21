package project21;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

public class Deck { //---------------------------------------------------------------------------------------------------------------
   
    private ArrayList<Card> cards = new ArrayList<>();
    ImageIcon spadeA = new ImageIcon("SpadeA.png");
    ImageIcon spade2 = new ImageIcon("Spade2.png");
    ImageIcon spade3 = new ImageIcon("Spade3.png");
    ImageIcon spade4 = new ImageIcon("Spade4.png");
    ImageIcon spade5 = new ImageIcon("Spade5.png");
    ImageIcon spade6 = new ImageIcon("Spade6.png");
    ImageIcon spade7 = new ImageIcon("Spade7.png");
    ImageIcon spade8 = new ImageIcon("Spade8.png");
    ImageIcon spade9 = new ImageIcon("Spade9.png");
    ImageIcon spade10 = new ImageIcon("Spade10.png");
    ImageIcon spadeJ = new ImageIcon("SpadeJ.png");
    ImageIcon spadeQ = new ImageIcon("SpadeQ.png");
    ImageIcon spadeK = new ImageIcon("SpadeK.png");
    ImageIcon diamondA = new ImageIcon("DiamondA.png");
    ImageIcon diamond2 = new ImageIcon("Diamond2.png");
    ImageIcon diamond3 = new ImageIcon("Diamond3.png");
    ImageIcon diamond4 = new ImageIcon("Diamond4.png");
    ImageIcon diamond5 = new ImageIcon("Diamond5.png");
    ImageIcon diamond6 = new ImageIcon("Diamond6.png");
    ImageIcon diamond7 = new ImageIcon("Diamond7.png");
    ImageIcon diamond8 = new ImageIcon("Diamond8.png");
    ImageIcon diamond9 = new ImageIcon("Diamond9.png");
    ImageIcon diamond10 = new ImageIcon("Diamond10.png");
    ImageIcon diamondJ = new ImageIcon("DiamondJ.png");
    ImageIcon diamondQ = new ImageIcon("DiamondQ.png");
    ImageIcon diamondK = new ImageIcon("DiamondK.png");
    ImageIcon clubA = new ImageIcon("ClubA.png");
    ImageIcon club2 = new ImageIcon("Club2.png");
    ImageIcon club3 = new ImageIcon("Club3.png");
    ImageIcon club4 = new ImageIcon("Club4.png");
    ImageIcon club5 = new ImageIcon("Club5.png");
    ImageIcon club6 = new ImageIcon("Club6.png");
    ImageIcon club7 = new ImageIcon("Club7.png");
    ImageIcon club8 = new ImageIcon("Club8.png");
    ImageIcon club9 = new ImageIcon("Club9.png");
    ImageIcon club10 = new ImageIcon("Club10.png");
    ImageIcon clubJ = new ImageIcon("ClubJ.png");
    ImageIcon clubQ = new ImageIcon("ClubQ.png");
    ImageIcon clubK = new ImageIcon("ClubK.png");
    ImageIcon heartA = new ImageIcon("HeartA.png");
    ImageIcon heart2 = new ImageIcon("Heart2.png");
    ImageIcon heart3 = new ImageIcon("Heart3.png");
    ImageIcon heart4 = new ImageIcon("Heart4.png");
    ImageIcon heart5 = new ImageIcon("Heart5.png");
    ImageIcon heart6 = new ImageIcon("Heart6.png");
    ImageIcon heart7 = new ImageIcon("Heart7.png");
    ImageIcon heart8 = new ImageIcon("Heart8.png");
    ImageIcon heart9 = new ImageIcon("Heart9.png");
    ImageIcon heart10 = new ImageIcon("Heart10.png");
    ImageIcon heartJ = new ImageIcon("HeartJ.png");
    ImageIcon heartQ = new ImageIcon("HeartQ.png");
    ImageIcon heartK = new ImageIcon("HeartK.png");
    ImageIcon cardBack = new ImageIcon("CardBack.png");


    // Constructor
    public Deck() { //-------------------------------------------------------------------------------------------------------
        cards = new ArrayList<>();
        String[] suits = {"Spades", "Diamonds", "Clubs", "Hearts"};
        String[] ranks = {"Ace","2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        int[] values = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        int cardIdx = 0;

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards.add(new Card(suit, ranks[i], values[i], cardIdx));
                cardIdx ++;
            }
        }

        shuffle();

    }  // End Constructor 

    public void shuffle() { //-----------------------------------------------------------------------------------------------
        Collections.shuffle(cards);
    }

    public Card drawCard(int i) { //-----------------------------------------------------------------------------------------
        return cards.get(i);
    }

    public ImageIcon getIcon(int cardNum){ //--------------------------------------------------------------------------------
      
        ImageIcon card = spadeA;
        
        switch (cardNum) {
              case 0:
                System.out.println("SpadeA");
                card = spadeA; 
                break;
              case 1:
                System.out.println("Spade2");
                 card = spade2;
                break;
              case 2:
                System.out.println("Spade3");
                 card = spade3;
                break;
              case 3:
                System.out.println("Spade4");
                 card = spade4;
                break;
              case 4:
                System.out.println("Spade5");
                 card = spade5;
                break;
              case 5:
                System.out.println("Spade6");
                 card = spade6;
                break;
              case 6:
                System.out.println("Spade7");
                 card = spade7;
                break;
              case 7:
                System.out.println("Spade8");
                 card = spade8;
                break;
              case 8:
                 System.out.println("Spade9");
                 card = spade9;
              break;
              case 9:
                 System.out.println("Spade10");
                 card = spade10;
              break;
              case 10:
                 System.out.println("SpadeJ");
                 card = spadeJ;
              break;
              case 11:
                 System.out.println("SpadeQ");
                 card = spadeQ;
              break;
              case 12:
                 System.out.println("SpadeK");
                 card = spadeK;
              break;
              case 13:
                 System.out.println("DiamondA");
                 card = diamondA; 
              break;
              case 14:
                 System.out.println("Diamond2");
                 card = diamond2;
              break;
              case 15:
                 System.out.println("Diamond3");
                 card = diamond3;
              break;
              case 16:
                 System.out.println("Diamond4");
                 card = diamond4;
              break;
              case 17:
                 System.out.println("Diamond5");
                 card = diamond5;
              break;
              case 18:
                 System.out.println("Diamond6");
                 card = diamond6;
              break;
              case 19:
                 System.out.println("Diamond7");
                 card = diamond7;
              break;
              case 20:
                 System.out.println("Diamond8");
                 card = diamond8;
              break;
              case 21:
                 System.out.println("Diamond9");
                 card = diamond9;
              break;
              case 22:
                 System.out.println("Diamond10");
                 card = diamond10;
              break;
              case 23:
                 System.out.println("DiamondJ");
                 card = diamondJ;
              break;
              case 24:
                 System.out.println("DiamondQ");
                 card = diamondQ;
              break;
              case 25:
                 System.out.println("DiamondK");
                 card = diamondK;
              break;
              case 26:
                 System.out.println("ClubA");
                 card = clubA; 
              break;
              case 27:
                 System.out.println("Club2");
                 card = club2;
              break;
              case 28:
                 System.out.println("Club3");
                 card = club3;
              break;
              case 29:
                 System.out.println("Club4");
                 card = club4;
              break;
              case 30:
                 System.out.println("Club5");
                 card = club5;
              break;
              case 31:
                 System.out.println("Club6");
                 card = club6;
              break;
              case 32:
                 System.out.println("Club7");
                 card = club7;
              break;
              case 33:
                 System.out.println("Club8");
                 card = club8;
              break;
              case 34:
                 System.out.println("Club9");
                 card = club9;
              break;
              case 35:
                 System.out.println("Club10");
                 card = club10;
              break;
              case 36:
                 System.out.println("ClubJ");
                 card = clubJ;
              break;
              case 37:
                 System.out.println("ClubQ");
                 card = clubQ;
              break;
              case 38:
                 System.out.println("ClubK");
                 card = clubK;
              break;
              case 39:
                 System.out.println("HeartA");
                 card = heartA; 
              break;
              case 40:
                 System.out.println("Heart2");
                 card = heart2;
              break;
              case 41:
                 System.out.println("Heart3");
                 card = heart3;
              break;
              case 42:
                 System.out.println("Heart4");
                 card = heart4;
              break;
              case 43:
                 System.out.println("Heart5");
                 card = heart5;
              break;
              case 44:
                 System.out.println("Heart6");
                 card = heart6;
              break;
              case 45:
                 System.out.println("Heart7");
                 card = heart7;
              break;
              case 46:
                 System.out.println("Heart8");
                 card = heart8;
              break;
              case 47:
                 System.out.println("Heart9");
                 card = heart9;
              break;
              case 48:
                 System.out.println("Heart10");
                 card = heart10;
              break;
              case 49:
                 System.out.println("HeartJ");
                 card = heartJ;
              break;
              case 50:
                 System.out.println("HeartQ");
                 card = heartQ;
              break;
              case 51:
                 System.out.println("HeartK");
                 card = heartK;
              break;
        }
        
        return card;
        
        
     }



} // End ---------------------------------------------------------------------------------------------------------------------