package edu.ntnu.idi.idatt.model.validators;

import edu.ntnu.idi.idatt.model.Card;
import edu.ntnu.idi.idatt.model.Rank;
import edu.ntnu.idi.idatt.model.Suit;
import java.util.List;

/**
 * <h3>A utility class for validating arguments passed to methods.</h3>
 *
 * @author William Holtsdalen
 */
public class ArgumentValidator {

  /**
   * Prevents instantiation of the ArgumentValidator class.
   */
  private ArgumentValidator() {
  }

  /**
   * Validates the arguments for the constructor of the Card class.
   *
   * @param suit the suit of the card
   * @param rank the rank of the card
   * @throws IllegalArgumentException if the suit or rank is null
   */
  public static void cardConstructorValidator(Suit suit, Rank rank) {
    if (suit == null) {
      throw new IllegalArgumentException("Suit cannot be null");
    }
    if (rank == null) {
      throw new IllegalArgumentException("Rank cannot be null");
    }
  }

  /**
   * Validates the arguments for the constructor of the DeckOfCards class.
   *
   * @param n the number of cards to deal
   * @throws IllegalArgumentException if the number of cards to deal is less than 1
   */
  public static void dealHandValidator(int n, int deckSize) {
    if (n < 1) {
      throw new IllegalArgumentException("Number of cards to deal must be greater than 0");
    }
    if (n > deckSize) {
      throw new IllegalArgumentException("Number of cards to deal must be less than or equal to "
          + "the number of cards in the deck");
    }
  }

  /**
   * Validates the arguments for the constructor of the HandOfCards class.
   *
   * @param cards the list of cards to initialize the hand with
   * @throws IllegalArgumentException if the list of cards is null or empty
   */
  public static void handOfCardsConstructorValidator(List<Card> cards) {
    if (cards == null) {
      throw new IllegalArgumentException("Cards cannot be null");
    }
    if (cards.isEmpty()) {
      throw new IllegalArgumentException("Cards cannot be an empty list");
    }
  }



}
