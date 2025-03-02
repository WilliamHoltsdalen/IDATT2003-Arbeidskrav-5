package edu.ntnu.idi.idatt.view;

import edu.ntnu.idi.idatt.controller.CardGameController;
import javafx.geometry.Insets;
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
    this.setMaxWidth(USE_PREF_SIZE);
    this.setPrefWidth(USE_COMPUTED_SIZE);
    this.setMinWidth(USE_PREF_SIZE);
    this.setSpacing(30);
    this.setAlignment(Pos.CENTER);
    this.setPadding(new Insets(10, 30, 10, 30));
    this.setStyle("-fx-background-color: #6A4515; -fx-background-radius: 12; -fx-box-shadow: black 0 0 10;");


    Button dealHandButton = new Button("Deal hand");
    dealHandButton.setStyle("-fx-background-color: #00C4D2; -fx-text-fill: black; -fx-font-size: 16; -fx-font-weight: 700;");
    dealHandButton.setPrefWidth(135);
    Button checkHandButton = new Button("Check hand");
    checkHandButton.setStyle("-fx-background-color: rgba(246, 255, 0, 0.77); -fx-text-fill: black; -fx-font-size: 16; -fx-font-weight: 700;");
    checkHandButton.setPrefWidth(135);


    Label sumTextLabel = new Label("Σ Sum of the faces");
    Label heartsTextLabel = new Label("♥ Cards of hearts");
    Label queenTextLabel = new Label("♠ Queen of spades");
    Label flushTextLabel = new Label("♦ Flush");
    sumTextLabel.setStyle("-fx-font-size: 14; -fx-text-fill: white;");
    heartsTextLabel.setStyle("-fx-font-size: 14; -fx-text-fill: white;");
    queenTextLabel.setStyle("-fx-font-size: 14; -fx-text-fill: white;");
    flushTextLabel.setStyle("-fx-font-size: 14; -fx-text-fill: white;");


    sumValueLabel = new Label("0");
    heartsValueLabel = new Label("H11 H12");
    queenValueLabel = new Label("X");
    flushValueLabel = new Label("X");
    sumValueLabel.setStyle("-fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: white;");
    heartsValueLabel.setStyle("-fx-font-size: 14; -fx-text-fill: green;");
    queenValueLabel.setStyle("-fx-font-size: 14; -fx-text-fill: red;");
    flushValueLabel.setStyle("-fx-font-size: 14; -fx-text-fill: red;");


    GridPane statsPane = new GridPane();
    statsPane.setHgap(18);
    statsPane.setVgap(15);
    statsPane.add(sumTextLabel, 0, 0);
    statsPane.add(sumValueLabel, 1, 0);
    statsPane.add(heartsTextLabel, 0, 1);
    statsPane.add(heartsValueLabel, 1, 1);
    statsPane.add(queenTextLabel, 0, 2);
    statsPane.add(queenValueLabel, 1, 2);
    statsPane.add(flushTextLabel, 0, 3);
    statsPane.add(flushValueLabel, 1, 3);


    VBox buttonBox = new VBox(30);
    buttonBox.setAlignment(Pos.CENTER);
    buttonBox.getChildren().addAll(dealHandButton, checkHandButton);


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
