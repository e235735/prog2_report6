package jp.ac.uryukyu.ie.e235735;

/**
 * プレイヤークラス。
 * Hand hand; //手札
 */
public class Player {
    private Hand hand;
    
    /**
     * コンストラクタ。手札を指定する。
     */
    public Player() {
        hand = new Hand();
    }

    /**
     * 手札のゲッター。
     * @return　hand; //手札
     */
    public Hand getHand() {
        return hand;
    }
}
