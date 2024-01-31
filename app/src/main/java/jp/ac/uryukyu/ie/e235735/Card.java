package jp.ac.uryukyu.ie.e235735;

/**
 * カードクラス。
 * String number; //数字
 * String suit; //マーク
 */
public class Card {
    String number;
    String suit;

    /**
     * コンストラクタ。カードの数字とマークを指定する。
     * @param number カードの数字
     * @param suit カードのマーク
     */
    public Card(String number, String suit) {
        this.number = number;
        this.suit = suit;
    }

    /**
     * toStringメソッド。
     * オブジェクトであるsuitとnumberを文字列で返す。
     */
    @Override
    public String toString() {
        return suit + " の " + number;
    }
}
