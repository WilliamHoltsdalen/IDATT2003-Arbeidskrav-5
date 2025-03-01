package edu.ntnu.idi.idatt.view;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.layout.VBox;

public class CardGameView extends VBox {

  public CardGameView() {
    setPadding(new Insets(65, 65, 65, 65));
    setAlignment(Pos.CENTER);

    CardAreaView cardAreaView= new CardAreaView();
    ControlPanelView controlPanelView = new ControlPanelView();

    getChildren().addAll(cardAreaView, controlPanelView);
  }

  public VBox getView() {
    return this;
  }
}
