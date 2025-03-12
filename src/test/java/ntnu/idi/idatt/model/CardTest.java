package ntnu.idi.idatt.model;

import edu.ntnu.idi.idatt.model.Card;
import edu.ntnu.idi.idatt.model.Rank;
import edu.ntnu.idi.idatt.model.Suit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CardTest {

  @Nested
  class PositiveTests {
    @DisplayName("Test creating a card with a valid suit and rank")
    @Test
    void testCreateCardWithValidSuitAndRank() {
      Card card = new Card(Suit.CLUBS, Rank.ACE);
      assertEquals(Suit.CLUBS, card.suit());
      assertEquals(Rank.ACE, card.rank());
    }
  }

  @Nested
  class NegativeTests {
    @DisplayName("Test creating a card object with a null suit")
    @Test
    void testCreateCardWithInvalidSuit() {
      assertThrows(IllegalArgumentException.class, () -> new Card(null, Rank.ACE));
    }

    @DisplayName("Test creating a card object with a null rank")
    @Test
    void testCreateCardWithInvalidRank() {
      assertThrows(IllegalArgumentException.class, () -> new Card(Suit.CLUBS, null));
    }

    @DisplayName("Test creating a card object with a null suit and rank")
    @Test
    void testCreateCardWithNullSuitAndRank() {
      assertThrows(IllegalArgumentException.class, () -> new Card(null, null));
    }
  }
}
