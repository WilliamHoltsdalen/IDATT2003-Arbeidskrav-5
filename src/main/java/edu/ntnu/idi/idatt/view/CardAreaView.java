package edu.ntnu.idi.idatt.view;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.List;

public class CardAreaView extends StackPane{

  public CardAreaView() {
    this.getStyleClass().add("card-area-table");

    StackPane greenFeltPane = new StackPane();
    greenFeltPane.getStyleClass().add("card-area-table-felt");

    // Card display area
    HBox cardBox = new HBox(10);
    cardBox.setAlignment(Pos.CENTER);
    greenFeltPane.getChildren().add(cardBox);

    List<String> cardNames = new ArrayList<>();
    cardNames.add("images/queen_of_spades.png");
    cardNames.add("images/queen_of_hearts.png");
    cardNames.add("images/queen_of_diamonds.png");
    cardNames.add("images/queen_of_clubs.png");
    cardNames.add("images/jack_of_hearts.png");
    for (String cardName : cardNames) {
      ImageView cardImage = new ImageView(cardName);
      cardImage.setFitWidth(100);
      cardImage.setPreserveRatio(true);
      cardBox.getChildren().add(cardImage);
    }

    getChildren().add(greenFeltPane);
  }
}
