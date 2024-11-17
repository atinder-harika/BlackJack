package ca.sheridancollege.project;

import java.util.Scanner;

public class BlackJackGame extends Game {

    private int playerScore;      // Tracks the total score of the player
    private int dealerScore;      // Tracks the total score of the dealer
    private int roundCounter;     // Keeps track of the rounds
    private Player player;        // The player instance
    private GroupOfCards deck;    // The deck of cards used in the game

    // Constructor to initialize the game
    public BlackJackGame(String name) {
        super(name);
        this.roundCounter = 1;
        this.playerScore = 0;
        this.dealerScore = 0;
        this.player = new Player("Player 1"); // Default player
        this.deck = new GroupOfCards(52);    // Standard 52-card deck
    }

    // Main method to start the game
    public static void main(String[] args) {
        BlackJackGame game = new BlackJackGame("Blackjack");
        game.play(); // Start the game
    }

    // Method to play the game
    @Override
    public void play() {
        // Initialize and shuffle the deck
        System.out.println("Initializing the deck...");
        deck.shuffle();

        // Run four rounds of Blackjack
        while (roundCounter <= 4) {
            System.out.println("\nRound " + roundCounter);
            playRound(); // Play each round
            roundCounter++;
        }

        // After 4 rounds, display the total scores and declare the winner
        declareWinner();
    }

    // Method to play one round of Blackjack
    private void playRound() {
        // Simulating player and dealer turns
        int roundPlayerScore = simulatePlayerTurn();
        int roundDealerScore = simulateDealerTurn();

        // Update total scores
        playerScore += roundPlayerScore;
        dealerScore += roundDealerScore;

        System.out.println("End of Round " + roundCounter);
        System.out.println("Player's Total Score: " + playerScore);
        System.out.println("Dealer's Total Score: " + dealerScore);
    }

    // Simulate the player's turn
    private int simulatePlayerTurn() {
        System.out.println("Player draws a card...");
        int cardValue = (int) (Math.random() * 11) + 1; // Random value between 1-11
        System.out.println("Player drew a card worth " + cardValue + " points.");
        return cardValue;
    }

    // Simulate the dealer's turn
    private int simulateDealerTurn() {
        System.out.println("Dealer draws a card...");
        int cardValue = (int) (Math.random() * 11) + 1; // Random value between 1-11
        System.out.println("Dealer drew a card worth " + cardValue + " points.");
        return cardValue;
    }

    // Method to declare the winner after four rounds
    @Override
    public void declareWinner() {
        System.out.println("\nGame Over!");
        System.out.println("Player Total Score: " + playerScore);
        System.out.println("Dealer Total Score: " + dealerScore);

        if (playerScore > dealerScore) {
            System.out.println("Player wins!");
        } else if (playerScore < dealerScore) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
