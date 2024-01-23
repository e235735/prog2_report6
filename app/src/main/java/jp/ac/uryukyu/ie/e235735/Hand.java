package jp.ac.uryukyu.ie.e235735;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public List<Card> getHand() {
        return cards;
    }    

    public void addCard(Card card) {
        cards.add(card);
    }

    public int calculateHandValue() {
        int value = 0;
        int numAces = 0;

        for (Card card : cards) {
            String number = card.number;
            if (number.equals("A")) { //エースを11と数えてエースの数を計測する
                numAces++;
                value += 11;
            } else if (number.equals("K") || number.equals("Q") || number.equals("J")) { //J,Q,Kは10と計算する
                value += 10;
            } else {
                value += Integer.parseInt(number);
            }
        }

        while (numAces > 0 && value > 21) { //エースは1点か11点と数えるため、バストする場合には1点で数える
            value -= 10;
            numAces--;
        }

        return value;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
