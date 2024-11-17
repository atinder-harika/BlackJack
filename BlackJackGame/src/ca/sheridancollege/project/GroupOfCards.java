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

    // Constructor to initialize the group of cards with a specific size
    public GroupOfCards(int size) {
    this.size = size;
    this.cards = new ArrayList<>();
    String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    for (String suit : suits) {
        for (String rank : ranks) {
            this.cards.add(new StandardCard(suit, rank));
        }
    }
    }

    // Get the group of cards as an ArrayList
    public ArrayList<Card> getCards() {
        return cards;
    }

    // Shuffle the group of cards using Collections.shuffle()
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Get the size of the group of cards
    public int getSize() {
        return size;
    }

    // Set the size of the group of cards
    public void setSize(int size) {
        this.size = size;
    }
}