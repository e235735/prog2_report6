package jp.ac.uryukyu.ie.e235735;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    /**
     * デッキがシャッフルされているか検証。
     * (1)二つのデッキを準備
     * (2)その二つのデッキが一致していないことを期待
     */
    @Test
    public void testDeckShuffle() {
        Deck originalDeck = new Deck();
        Deck shuffledDeck = new Deck();

        assertNotEquals(originalDeck.drawCard().toString(), shuffledDeck.drawCard().toString());
    }
}