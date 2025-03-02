package edu.ntnu.idi.idatt.view;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.List;

public class CardAreaView extends StackPane{

  public CardAreaView() {
    setStyle("-fx-background-color: #6A4515; -fx-padding: 20; -fx-background-radius: 15; -fx-box-shadow: black 0 0 10;");

    StackPane greenFeltPane = new StackPane();
    greenFeltPane.setStyle("-fx-background-color: #006400; -fx-padding: 35; -fx-background-radius: 10;");

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
