package ca.sheridancollege.project;

public class Player {

    private String name; // the unique name for this player
    private int score; // The total score of the player

    // Constructor to initialize the player's name
    public Player(String name) {
        this.name = name;
        this.score = 0; // Initialize score to 0
    }

    // Getter for player name
    public String getName() {
        return name;
    }

    // Setter for player name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for player score
    public int getScore() {
        return score;
    }

    // Method to add score (called after each round)
    public void addScore(int roundScore) {
        this.score += roundScore;
    }
}