package edu.ntnu.idi.idatt.controller;

import edu.ntnu.idi.idatt.model.Card;
import edu.ntnu.idi.idatt.model.DeckOfCards;
import edu.ntnu.idi.idatt.model.HandOfCards;
import edu.ntnu.idi.idatt.model.Rank;
import edu.ntnu.idi.idatt.model.Suit;
import edu.ntnu.idi.idatt.view.CardAreaView;
import edu.ntnu.idi.idatt.view.CardGameView;
import edu.ntnu.idi.idatt.view.ControlPanelView;
import java.util.stream.Collectors;
import javafx.scene.image.Image;

/**
 * <h3>Controller for the card game.</h3>
 *
 * @author William Holtsdalen
 */
public class CardGameController {
  private CardAreaView cardAreaView;
  private ControlPanelView controlPanelView;

  private DeckOfCards deck;
  private HandOfCards hand;

  /**
   * Constructs a new card game controller.
   */
  public CardGameController() {
    initDeckOfCards();
  }

  /**
   * Initializes the views in the card game view.
   *
   * @param cardGameView the card game view
   */
  public void initViews(CardGameView cardGameView) {
    this.controlPanelView = cardGameView.getControlPanelView();
    this.cardAreaView = cardGameView.getCardAreaView();
  }

  /**
   * Handles the click event for the deal hand button.
   */
  public void handleDealHandButtonClick() {
    this.hand = deck.dealHand(5);
    updateCards();
  }

  /**
   * Handles the click event for the check hand button.
   */
  public void handleCheckHandButtonClick() {
    updateSumValueLabel();
    updateHeartsValueLabel();
    updateQueenValueLabel();
    updateFlushValueLabel();
  }

  /**
   * Initializes the deck of cards.
   */
  private void initDeckOfCards() {
    this.deck = new DeckOfCards();
  }

  /**
   * Updates the cards in the card area view.
   */
  private void updateCards() {
    for (int i = 0; i < hand.getCards().size(); i++) {
      Card card = hand.getCards().get(i);
      cardAreaView.getCardImages().get(i).setImage(new Image(String.format(
              "images/%d_of_%s.png", card.rank().getValue(), card.suit().toString()
          )));
    }
  }

  /**
   * Updates the sum value label in the control panel view.
   */
  private void updateSumValueLabel() {
    int sum = 0;
    for (Card card : hand.getCards()) {
      sum += card.rank().getValue();
    }

    final int finalSum = sum;
    controlPanelView.getSumValueLabel().setText(String.valueOf(finalSum));
  }

  /**
   * Updates the hearts value label in the control panel view.
   */
  private void updateHeartsValueLabel() {
    String handString = hand.getCards().stream()
        .filter(card -> card.suit().equals(Suit.HEARTS))
        .map(card -> String.valueOf(card.suit().toString().charAt(0)) + card.rank().getValue())
        .collect(Collectors.joining(" "));

    if (handString.isEmpty()) {
      controlPanelView.getHeartsValueLabel().setText("❌");
      return;
    }
    controlPanelView.getHeartsValueLabel().setText(handString);
  }

  /**
   * Updates the queen value label in the control panel view.
   */
  private void updateQueenValueLabel() {
    for (Card card : hand.getCards()) {
      if (card.rank().equals(Rank.QUEEN) && card.suit().equals(Suit.SPADES)) {
        controlPanelView.getQueenValueLabel().setText("✅");
        return;
      }
      controlPanelView.getQueenValueLabel().setText("❌");
    }
  }

  /**
   * Updates the flush value label in the control panel view.
   */
  private void updateFlushValueLabel() {
    if (hand.checkFlush()) {
      controlPanelView.getFlushValueLabel().setText("✅");
    } else {
      controlPanelView.getFlushValueLabel().setText("❌");
    }
  }

}
