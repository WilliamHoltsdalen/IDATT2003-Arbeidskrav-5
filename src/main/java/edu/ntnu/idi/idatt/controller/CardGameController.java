package edu.ntnu.idi.idatt.controller;

import edu.ntnu.idi.idatt.view.ControlPanelView;
import javafx.application.Platform;

public class CardGameController {
  private final ControlPanelView view;

  public CardGameController(ControlPanelView view) {
    this.view = view;
  }

  public void handleDealHandButtonClick() {
    Platform.runLater(() -> view.getSumValueLabel().setText(
        String.valueOf(Integer.parseInt(view.getSumValueLabel().getText()) + 1)));
  }
}
