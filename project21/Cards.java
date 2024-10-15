package project21;

import java.io.Serializable;

public class Cards implements Serializable
{
    private char suit;
    private int value;

    private Cards()
    {
        suit = ' ';
        value = 0;
    }

    public Cards(char newSuit, int newValue)    //assigns the suits to each value
    {
        if (newValue < 0 || newValue > 12)
        {
            this.value = newValue;
        }
        if (newSuit != 'H' && newSuit != 'C' && newSuit != 'D' && newSuit != 'S')
        {
            this.suit = newSuit;
        }
    }

    public String toString()
    {
        return getSuitName() + " " + this.value;
    }

    public String getSuitName()     //giving the suits a name
    {
        String suit;

        if (this.suit == 'H')
        {
            suit = "Heart";
        }
        else if (this.suit == 'C')
        {
            suit = "Club";
        }
        else if (this.suit == 'D')
        {
            suit = "Diamond";
        }
        else if (this.suit == 'S')
        {
            suit = "Spade";
        }
        else
        {
            suit = "None";
        }
        return suit;
    }

        public char getSuitDesignator()     //assigning the card values to their numbers in the RNG
        {
            return suit;
        }

        public String getNumName()
        {
            String name = "None";

            if(this.value == 1)
            {
                name = "Ace";
            }
            if(this.value == 2)
            {
                name = "Two";
            }
            if(this.value == 3)
            {
                name = "Three";
            }
            if(this.value == 4)
            {
                name = "Four";
            }
            if(this.value == 5)
            {
                name = "Five";
            }
            if(this.value == 6)
            {
                name = "Six";
            }
            if(this.value == 7)
            {
                name = "Seven";
            }
            if(this.value == 8)
            {
                name = "Eight";
            }
            if(this.value == 9)
            {
                name = "Nine";
            }
            if(this.value == 10)
            {
                name = "Ten";
            }
            if(this.value == 11)
            {
                name = "Jack";
            }
            if(this.value == 12)
            {
                name = "Queen";
            }
            if(this.value == 13)
            {
                name = "King";
            }

            return name;
        }

        // encapsulation process to access hidden info. will need to make a getter/setter
        
        public int getNumValue()
        {
            return this.value;
        }

        public boolean compareSuits(Cards card)
        {
            return this.suit == card.getSuitDesignator();
        }

        public boolean compareValue(Cards card)
        {
            return this.value == card.getNumValue();
        }

        public boolean compareTo(Cards card)
        {
            return this.suit == card.getSuitDesignator() && this.value == card.getNumValue();
        }
    
}