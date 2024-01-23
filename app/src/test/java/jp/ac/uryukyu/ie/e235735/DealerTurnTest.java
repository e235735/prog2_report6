package jp.ac.uryukyu.ie.e235735;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DealerTurnTest {
    @Test
    public void testDealerTurn() {
        // ゲームの初期化
        BlackjackGame game = new BlackjackGame();
        game.dealInitialCards();

        // ディーラーのターンを実行
        game.dealerTurn();

        // ディーラーの手札の合計が17以上になっていることを確認
        assertTrue(game.getDealerHand().calculateHandValue() >= 17);
    }
}
