package edu.ntnu.idi.idatt.validators;

import edu.ntnu.idi.idatt.Suit;
import edu.ntnu.idi.idatt.Rank;

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
  public static void CardConstructorValidator(Suit suit, Rank rank) {
    if (suit == null) {
      throw new IllegalArgumentException("Suit cannot be null");
    }
    if (rank == null) {
      throw new IllegalArgumentException("Rank cannot be null");
    }
  }



}
