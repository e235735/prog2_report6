package jp.ac.uryukyu.ie.e235735;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    @Test
    public void testDeckShuffle() {
        Deck originalDeck = new Deck();
        Deck shuffledDeck = new Deck();

        // デッキがシャッフルされていることを確認
        assertNotEquals(originalDeck.drawCard().toString(), shuffledDeck.drawCard().toString());
    }
}