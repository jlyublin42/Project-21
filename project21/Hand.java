
package project21;

import java.util.ArrayList;

public class Hand { //---------------------------------------------------------------------------------------------------

    private ArrayList<Card> cards;

    // Constructor
    public Hand() { //----------------------------------------------------------------------------------------------------

        cards = new ArrayList<>();

    } // End Constructor

    public void addCard(Card card) { //-----------------------------------------------------------------------------------
        cards.add(card);
    }

    public int getTotalValue() { //---------------------------------------------------------------------------------------
        int total = 0;
        int aceCount = 0;

        for (Card card : cards) {
            total += card.getValue();
            if (card.getValue() == 11) {
                aceCount++;
            }
        }

        // Adjust for aces
        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }

        return total;
    }

    public void clearHand(){ //-------------------------------------------------------------------------------------------
        cards.clear();
    }

    public String toString() { //-----------------------------------------------------------------------------------------
        return cards.toString();
    }


} // End -----------------------------------------------------------------------------------------------------------------

