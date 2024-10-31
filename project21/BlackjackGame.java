package project21;

import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private Scanner scanner;
    private int count = 0;

    // Constructor
    public BlackjackGame() {
        deck = new Deck();
        playerHand = new Hand();
        dealerHand = new Hand();
        scanner = new Scanner(System.in);
        
    }

    public void startGame() {
        for (int i = 0; i < 52; i++){
            //System.out.println(deck.getCard(i));
        }

        // Initial deal
        playerHand.addCard(deck.drawCard(count));
        count++;
        dealerHand.addCard(deck.drawCard(count));
        count++;
        playerHand.addCard(deck.drawCard(count));
        count++;
        dealerHand.addCard(deck.drawCard(count));
        count++;

        System.out.println("Welcome to Blackjack!");
        System.out.println("Dealer's hand: " + dealerHand + " [Hidden Card]");
        System.out.println("Your hand: " + playerHand + " (Total: " + playerHand.getTotalValue() + ")");
        

        playerTurn();
        if (playerHand.getTotalValue() <= 21) {
            dealerTurn();
        }

        checkWinner();
    }

    private void playerTurn() {
        while (true) {
            System.out.print("Do you want to hit or stand? (h/s): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("h")) {
                playerHand.addCard(deck.drawCard(count));
                count++;
                System.out.println("Your hand: " + playerHand + " (Total: " + playerHand.getTotalValue() + ")");

                if (playerHand.getTotalValue() > 21) {
                    System.out.println("You busted! Game over.");
                    return;
                }
            } else if (choice.equalsIgnoreCase("s")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'h' or 's'.");
            }
        }
    }

    private void dealerTurn() {
        System.out.println("Dealer's hand: " + dealerHand + " (Total: " + dealerHand.getTotalValue() + ")");
        while (dealerHand.getTotalValue() < 17) {
            dealerHand.addCard(deck.drawCard(count));
            count++;
            System.out.println("Dealer draws a card. Hand: " + dealerHand + " (Total: " + dealerHand.getTotalValue() + ")");
        }

        if (dealerHand.getTotalValue() > 21) {
            System.out.println("Dealer busts! You win.");
        }
    }

    private void checkWinner() {
        int playerTotal = playerHand.getTotalValue();
        int dealerTotal = dealerHand.getTotalValue();

        if (playerTotal > 21) {
            System.out.println("You busted! Dealer wins.");
        } else if (dealerTotal > 21) {
            System.out.println("Dealer busted! You win.");
        } else if (playerTotal > dealerTotal) {
            System.out.println("You win with " + playerTotal + " against " + dealerTotal + "!");
        } else if (playerTotal < dealerTotal) {
            System.out.println("Dealer wins with " + dealerTotal + " against " + playerTotal + ".");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
        game.startGame();
    }
}