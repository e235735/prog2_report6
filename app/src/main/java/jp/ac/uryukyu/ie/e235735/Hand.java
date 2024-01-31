package jp.ac.uryukyu.ie.e235735;

import java.util.ArrayList;
import java.util.List;

/**
 * 手札クラス。
 * List<Card> hands; //複数のカードのリスト
 */
public class Hand {
    private List<Card> hands;

    /**
     * コンストラクタ。hands（持っているカード）をArrayListで指定する。
     */
    public Hand() {
        hands = new ArrayList<>();
    }

    /**
     * getHandメソッド。
     * hands（手札）を返す。
     * @return 手札
     */
    public List<Card> getHand() {
        return hands;
    }    

    /**
     * addCardメソッド。
     * 手札にcardを追加する。
     * @param card 引いたカード
     */
    public void addCard(Card card) {
        hands.add(card);
    }

    /**
     * 手札の点数を計算するメソッド。
     * エースを1点か11点で数えるかを判断し、J,Q,Kを10点で計算する。
     * @return 点数の合計
     */
    public int calculateHandValue() {
        int value = 0;
        int numAces = 0;

        for (Card card : hands) {
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

    /**
     * toStringメソッド。
     * 手札を文字列として返す。
     */
    @Override
    public String toString() {
        return hands.toString();
    }
}
