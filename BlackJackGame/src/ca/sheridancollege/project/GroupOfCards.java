/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents a group of cards for a game.
 * The group of cards has a flexible size, and it can be shuffled as needed.
 */
public class GroupOfCards {

    private ArrayList<Card> cards;  // The group of cards stored in an ArrayList
    private int size;  // The size of the group of cards

    /**
     * Constructor to initialize the group of cards with a specific size.
     *
     * @param size the maximum size of the group of cards
     */
    public GroupOfCards(int size) {
        this.size = size;
    }

    /**
     * @return the group of cards as an ArrayList
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Shuffles the group of cards using Collections.shuffle().
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size sets the size of the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }
}