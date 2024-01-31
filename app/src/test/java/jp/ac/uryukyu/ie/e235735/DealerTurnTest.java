package jp.ac.uryukyu.ie.e235735;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DealerTurnTest {
    /**
     * ディーラーの手札が必ず17点以上になるか検証。
     * (1)最初の手札を準備
     * (2)ディーラーのターンを実行する
     * (3)ディーラーのターンが17点以上になっていることを期待
     */
    @Test
    public void testDealerTurn() {
        BlackjackGame game = new BlackjackGame();
        game.dealInitialCards();

        game.dealerTurn();

        assertTrue(game.getDealerHand().calculateHandValue() >= 17);
    }
}
