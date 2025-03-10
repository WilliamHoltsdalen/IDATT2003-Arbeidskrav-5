# Card Game (IDATT2003 Arbeidskrav 5)

This is a **mini-project in Java**, created for a mandatory assignment that is part of the course **IDATT2003 at NTNU**.

## 📌 Project Description  
The program allows the user to draw a hand of cards and check various properties of the hand, such as:  
-  Sum of all the card ranks  
-  Whether the hand contains any cards of suit 'hearts' (and which ones)
-  Whether the hand contains the card 'queen of spades'
-  Whether the hand forms a flush  

The **GUI** displays the cards and includes buttons for drawing a hand and checking the hand's properties.

## 🛠 Technologies and Tools  
- **Java** 
- **JavaFX** (for GUI)  
- **Maven** (for project structure and build management)  
- **Git** (for version control)  

## 📂 Project Structure  
```
src/
 ├── main/
 │   ├── java/
 │   │   ├── edu.ntnu.idi.idatt/
 │   │   │   ├── controller/    # Handles GUI interactivity and provides functionality.
 │   │   │   ├── model/         # Data models/entities
 │   │   │   │   └── validators # Validator utilities for models
 │   │   │   ├── view/          # JavaFX views for the GUI
 │   │   │   └── CardGame.java  # Entry point of the application.
 │   └── resources/             # Resources such as images and stylesheets
 └── test/                      # Unit tests
 ```

## 🚀 Running the application with Maven
```sh
mvn clean install
mvn javafx:run
```



