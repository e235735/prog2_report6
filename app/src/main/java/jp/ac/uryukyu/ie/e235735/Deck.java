package jp.ac.uryukyu.ie.e235735;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        makeDeck();
        shuffle();
    }
    
    private void makeDeck() { //52枚のトランプのデッキを準備
        cards = new ArrayList<>();
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"ハート", "ダイヤ", "クラブ", "スペード"};

        for (String suit : suits) {
            for (String number : numbers) {
                cards.add(new Card(number, suit));
            }
        }
    }

    public void shuffle() { //デッキをシャッフルする
        Collections.shuffle(cards);
    }

    public Card drawCard() { //手札を引いてデッキからそのカードを削除する
        return cards.remove(0);
    }
}
