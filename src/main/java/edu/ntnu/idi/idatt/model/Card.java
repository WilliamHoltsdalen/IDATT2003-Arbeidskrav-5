package edu.ntnu.idi.idatt.model;

import static edu.ntnu.idi.idatt.model.validators.ArgumentValidator.cardConstructorValidator;

/**
 * <h3>Represents a playing card.</h3>
 *
 * <p>The card is represented by a suit and a rank.
 *
 * @author William Holtsdalen
 */
public record Card(Suit suit, Rank rank) {

  /**
   * Creates a new card with the given suit and rank.
   *
   * @param suit the suit of the card
   * @param rank the rank of the card
   */
  public Card {
    cardConstructorValidator(suit, rank);
  }

  /**
   * Returns a string representation of the card in the format "rank of suit".
   *
   * @return a string representation of the card
   */
  @Override
  public String toString() {
    return String.format("%s of %s", rank, suit);
  }
}
