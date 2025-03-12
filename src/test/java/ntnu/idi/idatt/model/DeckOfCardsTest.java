package ntnu.idi.idatt.model;

import edu.ntnu.idi.idatt.model.Card;
import edu.ntnu.idi.idatt.model.DeckOfCards;
import edu.ntnu.idi.idatt.model.HandOfCards;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class DeckOfCardsTest {

  @Nested
  class PositiveTests {

    @DisplayName("Test creating a deck of cards")
    @Test
    void testCreateDeckOfCards() {
      DeckOfCards deck = new DeckOfCards();
      assertEquals(52, deck.getCards().size());
    }

    @DisplayName("Test shuffling a deck of cards")
    @Test
    void testShuffleDeckOfCards() {
      DeckOfCards deck = new DeckOfCards();
      List<Card> deckPreShuffle = List.copyOf(deck.getCards());
      deck.shuffleDeck();
      List<Card> deckPostShuffle = deck.getCards();

      assertNotEquals(deckPreShuffle, deckPostShuffle);
    }

    @DisplayName("Test dealing a hand deals correct number of cards")
    @Test
    void testDealHandFromDeckOfCards() {
      DeckOfCards deck = new DeckOfCards();
      deck.shuffleDeck();
      HandOfCards hand = deck.dealHand(5);
      assertEquals(5, hand.getCards().size());
    }

    @DisplayName("Test dealing a hand deals valid cards")
    @Test
    void testDealHandFromDeckOfCardsWithValidCards() {
      DeckOfCards deck = new DeckOfCards();
      deck.shuffleDeck();
      HandOfCards hand = deck.dealHand(5);
      hand.getCards().forEach(card -> assertTrue(deck.getCards().contains(card)));
    }
  }

  @Nested
  class NegativeTests {

    @DisplayName("Test dealing a hand with a zero cards throws an exception")
    @Test
    void testDealHandFromDeckOfCardsWithZeroCardsThrowsException() {
      DeckOfCards deck = new DeckOfCards();
      assertThrows(IllegalArgumentException.class, () -> deck.dealHand(0));
    }

    @DisplayName("Test dealing a hand with a negative number of cards throws an exception")
    @Test
    void testDealHandFromDeckOfCardsWithNegativeNumberOfCardsThrowsException() {
      DeckOfCards deck = new DeckOfCards();
      assertThrows(IllegalArgumentException.class, () -> deck.dealHand(-1));
    }

    @DisplayName("Test dealing a hand with a number of cards greater than the number of cards in the deck throws an exception")
    @Test
    void testDealHandFromDeckOfCardsWithNumberOfCardsGreaterThanDeckThrowsException() {
      DeckOfCards deck = new DeckOfCards();
      assertThrows(IllegalArgumentException.class, () -> deck.dealHand(53));
    }
  }
}
