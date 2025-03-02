package edu.ntnu.idi.idatt;


import edu.ntnu.idi.idatt.view.CardGameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main class of the card game application.
 */
public class CardGame extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    CardGameView cardGameView = new CardGameView();

    Scene scene = new Scene(cardGameView.getView(), 800, 600);
    scene.getStylesheets().add("stylesheets/project.css");
    primaryStage.setTitle("Card Game");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}