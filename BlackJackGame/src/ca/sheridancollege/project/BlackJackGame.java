package ca.sheridancollege.project;

import java.util.Scanner;

public class BlackJackGame extends Game {
    
    private int playerScore; // Tracks the total score of the player
    private int dealerScore; // Tracks the total score of the dealer
    private int roundCounter; // Keeps track of the rounds
    private Player player; // The player instance
    private GroupOfCards deck; // The deck of cards used in the game
    
    // Constructor to initialize the game with player details
    public BlackJackGame(String name, Player player) {
        super(name);
        this.player = player;
        this.roundCounter = 1;
        this.playerScore = 0;
        this.dealerScore = 0;
        this.deck = new GroupOfCards(52); // Standard deck size for Blackjack
    }

    // Method to play the game
    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (roundCounter <= 4) { // Game will last for 4 rounds
            System.out.println("Round " + roundCounter);
            playRound(); // Play each round
            roundCounter++;
        }

        // After 4 rounds, display the total scores and declare the winner
        declareWinner();
    }

    // Method to play one round of Blackjack
    private void playRound() {
        // Logic for shuffling, dealing cards, player's turn (hit/stand), dealer's turn
        // Here we can call the relevant methods like dealCards(), playerTurn(), dealerTurn(), etc.
        
        // For example:
        deck.shuffle();
        System.out.println("Shuffling the deck...");
        
        // Simulating a round where both player and dealer have a turn to play.
        // Add logic to calculate the score for the round and update playerScore and dealerScore
        
        int roundPlayerScore = simulatePlayerTurn(); // This would be a method simulating the player's moves
        int roundDealerScore = simulateDealerTurn(); // Simulating the dealer's moves
        
        playerScore += roundPlayerScore; // Add the player's round score to total score
        dealerScore += roundDealerScore; // Add the dealer's round score to total score
    }

    // Simulate the player's turn
    private int simulatePlayerTurn() {
        // Implement the logic for the player's actions during their turn (hit/stand)
        // Return the score of the round for the player
        return 21; // Placeholder value, actual logic should be here
    }

    // Simulate the dealer's turn
    private int simulateDealerTurn() {
        // Implement the dealer's turn logic (dealer draws until at least 17 points)
        return 17; // Placeholder value, actual logic should be here
    }

    // Method to declare the winner after four rounds
    @Override
    public void declareWinner() {
        System.out.println("Game Over!");
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