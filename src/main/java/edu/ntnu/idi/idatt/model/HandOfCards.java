package edu.ntnu.idi.idatt.model;

import static edu.ntnu.idi.idatt.model.validators.ArgumentValidator.handOfCardsConstructorValidator;
import java.util.List;

/**
 * Represents a hand of playing cards. A hand of playing cards consists of a list of cards.
 * The hand can be checked for a flush.
 *
 * @see Card
 *
 * @author William Holtsdalen
 */
public class HandOfCards {
  private List<Card> cards;

  /**
   * Constructs a new hand of cards with the given list of cards. The list of cards is
   * validated using the {@code handOfCardsConstructorValidator} method.
   *
   * @param cards the list of cards to initialize the hand with
   */
  public HandOfCards(List<Card> cards) {
    handOfCardsConstructorValidator(cards);
  }

  /**
   * Returns a list of the cards in the hand.
   *
   * @return a list of the cards in the hand
   */
  public List<Card> getCards() {
    return cards;
  }

  /**
   * Initializes the hand with the given list of cards.
   *
   * @param cards the list of cards to initialize the hand with
   */
  public void initializeHand(List<Card> cards) {
    this.cards = new java.util.ArrayList<>();
    this.cards.addAll(cards);
  }

  /**
   * Checks if the hand has a flush.
   *
   * @return true if the hand has a flush, false otherwise
   */
  public boolean checkFlush() {
    Suit firstSuit = this.cards.getFirst().suit();
    for (Card card : cards) {
      Suit cardSuit = card.suit();
      if (cardSuit != firstSuit) {
        return false;
      }
    }
    return true;
  }
}
