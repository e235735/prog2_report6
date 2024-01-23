package jp.ac.uryukyu.ie.e235735;

public class Card {
    String number;
    String suit;

    public Card(String number, String suit) {
        this.number = number;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return suit + " の " + number;
    }
}
