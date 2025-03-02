package edu.ntnu.idi.idatt.view;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class CardGameView extends VBox {

  public CardGameView() {
    setStyle("-fx-background-color: radial-gradient(focus-distance 0% , center 50% 50% , radius 50% , rgb(22,81,93) 30%, rgb(0,52,63) 100%);");

    setPadding(new Insets(65, 65, 65, 65));
    setAlignment(Pos.CENTER);

    CardAreaView cardAreaView= new CardAreaView();
    ControlPanelView controlPanelView = new ControlPanelView();
    VBox.setMargin(controlPanelView, new Insets(70, 0, 0, 0));

    getChildren().addAll(cardAreaView, controlPanelView);
  }

  public VBox getView() {
    return this;
  }
}
