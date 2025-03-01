package edu.ntnu.idi.idatt.view;

import edu.ntnu.idi.idatt.controller.CardGameController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CardGameView {
  private VBox root;
  private Button button;
  private Label buttonLabel;
  private CardGameController controller;

  public CardGameView() {
    // UI components
    button = new Button("Clickable button");
    buttonLabel = new Label("Button not clicked");

    controller = new CardGameController(this);

    root = new VBox(15, buttonLabel, button);
    root.setAlignment(Pos.CENTER);

    button.setOnAction(e -> controller.handleButtonClick());
  }

  public VBox getView() {
    return root;
  }

  public Label getButtonLabel() {
    return buttonLabel;
  }
}
