package ca.sheridancollege.project;

import java.util.Scanner;

public class BlackJackGame extends Game {

    private Player player;      // The player instance
    private GroupOfCards deck;  // The deck of cards used in the game
    
    public Player getPlayer() {
        return player;
    }

    public GroupOfCards getDeck() {
        return deck;
    }

    public BlackJackGame(String name) {
        super(name);
        this.player = new Player(""); // Player name will be set during registration
        this.deck = new GroupOfCards(52); // Standard 52-card deck
    }

    public static void main(String[] args) {
        BlackJackGame game = new BlackJackGame("Blackjack");
        game.registerPlayer();
        game.play();
    }

    // Player registration with interactive input
    public void registerPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name to start the game: ");
        String playerName = scanner.nextLine();
        player.setName(playerName);
        System.out.println("Welcome, " + playerName + "! Let's play Blackjack.");
    }
    
    public void registerPlayerForTest(String playerName) {
        player.setName(playerName);
    }


    @Override
    public void play() {
        deck.shuffle();
        boolean continuePlaying = true;

        while (continuePlaying) {
            System.out.println("\nDealing cards...");
            Player dealer = new Player("Dealer");
            playRound(player, dealer);

            System.out.println("\nDo you want to play another round? (yes/no): ");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine().trim().toLowerCase();
            continuePlaying = response.equals("yes");
        }

        System.out.println("Thank you for playing, " + player.getName() + "!");
    }

    private void playRound(Player player, Player dealer) {
        // Deal initial cards
        int playerScore = dealInitialCards(player);
        int dealerScore = dealInitialCards(dealer);

        // Player's turn
        while (playerScore < 21 && promptPlayerChoice()) {
            playerScore += drawCard(player);
        }

        if (playerScore > 21) {
            System.out.println("You busted with a score of " + playerScore + ". Dealer wins!");
            return;
        }

        // Dealer's turn
        while (dealerScore < 17) {
            dealerScore += drawCard(dealer);
        }

        // Determine winner
        determineWinner(playerScore, dealerScore);
    }

    private int dealInitialCards(Player player) {
        int score = 0;
        for (int i = 0; i < 2; i++) {
            score += drawCard(player);
        }
        return score;
    }

    private int drawCard(Player player) {
        Card card = deck.getCards().remove(0);
        int cardValue = ((StandardCard) card).getValue();
        System.out.println(player.getName() + " drew " + card + " (Value: " + cardValue + ")");
        return cardValue;
    }

    private boolean promptPlayerChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to hit or stand? (hit/stand): ");
        String choice = scanner.nextLine().trim().toLowerCase();
        return choice.equals("hit");
    }

    private void determineWinner(int playerScore, int dealerScore) {
        System.out.println("\nPlayer Score: " + playerScore);
        System.out.println("Dealer Score: " + dealerScore);

        if (playerScore > dealerScore || dealerScore > 21) {
            System.out.println("Congratulations! You win!");
        } else if (playerScore < dealerScore) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    @Override
    public void declareWinner() {
        // No longer used, but kept for abstract method compliance.
    }
}
