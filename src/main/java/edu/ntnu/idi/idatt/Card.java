package edu.ntnu.idi.idatt;

import static edu.ntnu.idi.idatt.validators.ArgumentValidator.CardConstructorValidator;

/**
 * <h3>Represents a playing card.
 *
 * <p>
 * The card is represented by a suit and a rank.
 *
 * @author William Holtsdalen
 */
public class Card {
  private final Suit suit;
  private final Rank rank;

  /**
   * Creates a new card with the given suit and rank.
   *
   * @param suit the suit of the card
   * @param rank the rank of the card
   */
  public Card(Suit suit, Rank rank) {
    CardConstructorValidator(suit, rank);
    this.suit = suit;
    this.rank = rank;
  }

  /**
   * Returns the suit of the card.
   *
   * @return the suit of the card
   */
  public Suit getSuit() {
    return suit;
  }

  /**
   * Returns the rank of the card.
   *
   * @return the rank of the card
   */
  public Rank getRank() {
    return rank;
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
