/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. 
 * You should create a more specific child of this class and instantiate the methods
 * given to implement game-specific logic.
 *
 */
public abstract class Game {

    private final String name;  // The title of the game
    private ArrayList<Player> players;  // The players of the game

    /**
     * Constructor to initialize the game with a name and an empty list of players.
     *
     * @param name the title of the game
     */
    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    /**
     * @return the name of the game
     */
    public String getName() {
        return name;
    }

    /**
     * @return the list of players in the game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the list of players to set for the game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Abstract method for playing the game. To be implemented by specific games.
     */
    public abstract void play();

    /**
     * Abstract method to declare and display the winner of the game.
     * To be implemented by specific games.
     */
    public abstract void declareWinner();
}
