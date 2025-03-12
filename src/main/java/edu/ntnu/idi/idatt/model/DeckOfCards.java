package edu.ntnu.idi.idatt.model;

import static edu.ntnu.idi.idatt.model.validators.ArgumentValidator.dealHandValidator;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a deck of playing cards. The deck has 52 cards of the Card record. There are methods
 * to shuffle the deck and to deal cards from the deck.
 *
 * @see Card
 * @author William Holtsdalen
 */
public class DeckOfCards {
  private final List<Card> cards;
  private final Random random;

  /**
   * Creates a new deck of cards, and shuffles it.
   */
  public DeckOfCards() {
    cards = new ArrayList<>();
    random = new Random();

    initializeDeck();
    shuffleDeck();
  }

  /**
   * Returns a list of the cards in the deck.
   *
   * @return a list of the cards in the deck
   */
  public List<Card> getCards()   {
    return cards;
  }

  /**
   * Creates 52 unique cards and adds them to the deck.
   * <p>
   * The cards are created by iterating over the Suit and Rank enums.
   *
   * @see Suit
   * @see Rank
   * @see Card
   */
  private void initializeDeck() {
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        this.cards.add(new Card(suit, rank));
      }
    }
  }

  /**
   * Shuffles the deck of cards using the Collections.shuffle method.
   */
  public void shuffleDeck() {
    Collections.shuffle(cards);
  }

  /**
   * Deals a hand of cards from the deck of cards. Takes a number of cards to deal as a parameter.
   * The method validates the number of cards to deal using the {@code dealHandValidator} method.
   *
   * @see HandOfCards
   * @param n the number of cards to deal
   * @return a HandOfCards object containing the dealt cards
   */
  public HandOfCards dealHand(int n) {
    dealHandValidator(n, cards.size());

    List<Card> handCards = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      handCards.add(this.cards.get(random.nextInt(this.cards.size())));
    }
    return new HandOfCards(handCards);
  }
}
