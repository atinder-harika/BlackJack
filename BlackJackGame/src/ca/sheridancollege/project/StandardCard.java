/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author atind
 */
public class StandardCard extends Card {
    private String suit;
    private String rank;

    public StandardCard(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue() {
        switch (rank) {
            case "Jack":
            case "Queen":
            case "King":
                return 10;
            case "Ace":
                return 11; // Default value; adjust for score later
            default:
                return Integer.parseInt(rank); // Numeric cards
        }
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

