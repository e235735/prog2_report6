package jp.ac.uryukyu.ie.e235735;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 山札クラス。
 * List<Card> cards; //複数のカードをまとめたリスト
 */
public class Deck {
    private List<Card> cards;

    /**
     * コンストラクタ。makeDeckメソッドとshuffleメソッドを持つ。
     */
    public Deck() {
        makeDeck();
        shuffle();
    }
    
    /**
     * 山札を準備するメソッド。
     * ArrayListのcardsを準備し、すべての数字とマークの組み合わせのカードをcardsに追加する。
     */
    private void makeDeck() {
        cards = new ArrayList<>();
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"ハート", "ダイヤ", "クラブ", "スペード"};

        for (String suit : suits) {
            for (String number : numbers) {
                cards.add(new Card(number, suit));
            }
        }
    }

    /**
     * 山札をシャッフルするメソッド。
     * Collectionsクラスのshuffleメソッドを使い、makeDeckメソッドで準備した山札をシャッフルする。
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * 手札を引いて山札からそのカードを削除するメソッド。
     * 一番最初にあるカードを削除する。
     * @return
     */
    public Card drawCard() {
        return cards.remove(0);
    }
}
