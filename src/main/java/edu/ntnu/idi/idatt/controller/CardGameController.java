package edu.ntnu.idi.idatt.controller;

import edu.ntnu.idi.idatt.model.Card;
import edu.ntnu.idi.idatt.model.Rank;
import edu.ntnu.idi.idatt.model.Suit;
import edu.ntnu.idi.idatt.view.CardAreaView;
import edu.ntnu.idi.idatt.view.CardGameView;
import java.util.stream.Collectors;

import edu.ntnu.idi.idatt.model.DeckOfCards;
import edu.ntnu.idi.idatt.model.HandOfCards;
import edu.ntnu.idi.idatt.view.ControlPanelView;
import javafx.application.Platform;
import javafx.scene.image.Image;

public class CardGameController {
  private CardAreaView cardAreaView;
  private ControlPanelView controlPanelView;

  private DeckOfCards deck;
  private HandOfCards hand;

  public CardGameController() {
    initDeckOfCards();
  }

  public void initViews(CardGameView cardGameView) {
    this.controlPanelView = cardGameView.getControlPanelView();
    this.cardAreaView = cardGameView.getCardAreaView();
  }

  public void handleDealHandButtonClick() {
    this.hand = deck.dealHand(5);
    updateCards();
  }

  public void handleCheckHandButtonClick() {
    updateSumValueLabel();
    updateHeartsValueLabel();
    updateQueenValueLabel();
    updateFlushValueLabel();
  }

  private void initDeckOfCards() {
    this.deck = new DeckOfCards();
  }

  private void updateCards() {
    for (int i = 0; i < hand.getCards().size(); i++) {
      Card card = hand.getCards().get(i);
      int finalI = i;
      Platform.runLater(() -> cardAreaView.getCardImages().get(finalI).setImage(new Image(String.format(
              "images/%d_of_%s.png", card.rank().getValue(), card.suit().toString()
          )))
      );
    }
  }

  private void updateSumValueLabel() {
    int sum = 0;
    for (Card card : hand.getCards()) {
      sum += card.rank().getValue();
    }

    final int finalSum = sum;
    Platform.runLater(() -> controlPanelView.getSumValueLabel().setText(String.valueOf(finalSum)));
  }

  private void updateHeartsValueLabel() {
    String handString = hand.getCards().stream()
        .filter(card -> card.suit().equals(Suit.HEARTS))
        .map(card -> String.valueOf(card.suit().toString().charAt(0)) + card.rank().getValue())
        .collect(Collectors.joining(" "));

    if (handString.isEmpty()) {
      Platform.runLater(() -> controlPanelView.getHeartsValueLabel().setText("❌"));
      return;
    }
    Platform.runLater(() -> controlPanelView.getHeartsValueLabel().setText(handString));
  }

  private void updateQueenValueLabel() {
    for (Card card : hand.getCards()) {
      if (card.rank().equals(Rank.QUEEN) && card.suit().equals(Suit.SPADES)) {
        Platform.runLater(() -> controlPanelView.getQueenValueLabel().setText("✅"));
        return;
      }
      Platform.runLater(() -> controlPanelView.getQueenValueLabel().setText("❌"));
    }
  }

  private void updateFlushValueLabel() {
    if (hand.checkFlush()) {
      Platform.runLater(() -> controlPanelView.getFlushValueLabel().setText("✅"));
    } else {
      Platform.runLater(() -> controlPanelView.getFlushValueLabel().setText("❌"));
    }
  }

}
