package edu.ntnu.idi.idatt.view;
import edu.ntnu.idi.idatt.controller.CardGameController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class CardGameView extends VBox {
    private final CardAreaView cardAreaView;
    private final ControlPanelView controlPanelView;

    public CardGameView() {
        CardGameController controller = new CardGameController();

        this.getStyleClass().add("main-background");

        setPadding(new Insets(65, 65, 65, 65));
        setAlignment(Pos.CENTER);

        cardAreaView = new CardAreaView();
        controlPanelView = new ControlPanelView(controller);
        VBox.setMargin(controlPanelView, new Insets(70, 0, 0, 0));

        controller.initViews(this);
        getChildren().addAll(cardAreaView, controlPanelView);
    }

    public VBox getView() {
        return this;
    }

    public ControlPanelView getControlPanelView() {
        return controlPanelView;
    }

    public CardAreaView getCardAreaView() {
        return cardAreaView;
    }
}
