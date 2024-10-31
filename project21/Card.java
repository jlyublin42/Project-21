package project21;

public class Card {
    private String suit;
    private String rank;
    private int value;
    private int cardNum;

    public Card(String suit, String rank, int value, int cardNum) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
        this.cardNum = cardNum;
    }

    public int getValue() {
        return value;
    }

    public int getCardNum(){
        return cardNum;
    }

    public String toString() {
        return rank + " of " + suit + " Card number: " + cardNum;
    }
}
