package edu.ntnu.idi.idatt.view;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class CardGameView extends VBox {

    public CardGameView() {
        CardGameController controller = new CardGameController();

        this.getStyleClass().add("main-background");

    CardAreaView cardAreaView= new CardAreaView();
    ControlPanelView controlPanelView = new ControlPanelView();
    VBox.setMargin(controlPanelView, new Insets(70, 0, 0, 0));

    getChildren().addAll(cardAreaView, controlPanelView);
  }

  public VBox getView() {
    return this;
  }
}
