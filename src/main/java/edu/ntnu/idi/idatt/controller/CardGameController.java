package edu.ntnu.idi.idatt.controller;

import edu.ntnu.idi.idatt.view.CardGameView;
import javafx.application.Platform;

public class CardGameController {
  private final CardGameView view;

  public CardGameController(CardGameView view) {
    this.view = view;
  }

  public void handleButtonClick() {
    if (view.getButtonLabel().getText().equals("Button clicked")) {
      Platform.runLater((() -> view.getButtonLabel().setText("Button not clicked")));
      return;
    }
    Platform.runLater((() -> view.getButtonLabel().setText("Button clicked")));
  }
}
