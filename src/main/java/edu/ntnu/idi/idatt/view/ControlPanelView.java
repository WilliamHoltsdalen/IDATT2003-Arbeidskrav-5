package edu.ntnu.idi.idatt.view;

import edu.ntnu.idi.idatt.controller.CardGameController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ControlPanelView extends HBox {
  private final Label sumValueLabel;
  private final Label heartsValueLabel;
  private final Label queenValueLabel;
  private final Label flushValueLabel;

  private final CardGameController controller;

  public ControlPanelView() {
    controller = new CardGameController(this);

    setSpacing(10);
    setAlignment(Pos.CENTER);
    setStyle("-fx-background-color: #8B4513; -fx-padding: 10; -fx-background-radius: 5;");

    Button dealHandButton = new Button("Deal hand");
    dealHandButton.setStyle("-fx-background-color: #00CED1; -fx-text-fill: black;");
    Button checkHandButton = new Button("Check hand");
    checkHandButton.setStyle("-fx-background-color: #FFFF00; -fx-text-fill: black;");

    // Create labels for statistics
    Label sumTextLabel = new Label("Σ Sum of the faces");
    Label heartsTextLabel = new Label("♥ Cards of hearts");
    Label queenTextLabel = new Label("♠ Queen of spades");
    Label flushTextLabel = new Label("♦ Flush");

    sumValueLabel = new Label("0");
    heartsValueLabel = new Label("0");
    queenValueLabel = new Label("X");
    flushValueLabel = new Label("X");

    // Stats panel
    GridPane statsPane = new GridPane();
    statsPane.setHgap(10);
    statsPane.setVgap(5);
    statsPane.setStyle("-fx-background-color: #8B4513; -fx-padding: 10; -fx-background-radius: 5;");
    statsPane.add(sumTextLabel, 0, 0);
    statsPane.add(sumValueLabel, 1, 0);
    statsPane.add(heartsTextLabel, 0, 1);
    statsPane.add(heartsValueLabel, 1, 1);
    statsPane.add(queenTextLabel, 0, 2);
    statsPane.add(queenValueLabel, 1, 2);
    statsPane.add(flushTextLabel, 0, 3);
    statsPane.add(flushValueLabel, 1, 3);

    // Button container
    VBox buttonBox = new VBox(10);
    buttonBox.setAlignment(Pos.CENTER);
    buttonBox.getChildren().addAll(dealHandButton, checkHandButton);

    // Event handlers
    dealHandButton.setOnAction(e -> controller.handleDealHandButtonClick());

    getChildren().addAll(buttonBox, statsPane);
  }

  public Label getSumValueLabel() {
    return sumValueLabel;
  }

  public Label getHeartsValueLabel() {
    return heartsValueLabel;
  }

  public Label getQueenValueLabel() {
    return queenValueLabel;
  }

  public Label getFlushValueLabel() {
    return flushValueLabel;
  }
}
