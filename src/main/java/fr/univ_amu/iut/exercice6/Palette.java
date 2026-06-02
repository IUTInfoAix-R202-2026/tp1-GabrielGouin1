package fr.univ_amu.iut.exercice6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Exercice 6 - Palette de couleurs (capstone).
 *
 * <p>Dernier exercice du TP : synthèse des concepts vus jusqu'ici (layout, boutons, événements,
 * mise à jour d'un label) sur une petite application autonome.
 *
 * <h3>Comportement attendu</h3>
 *
 * <pre>
 * ┌──────────────────────────────┐
 * │ [Rouge] [Vert] [Bleu]        │  ← HBox de 3 boutons
 * ├──────────────────────────────┤
 * │                              │
 * │     (zone de couleur)        │  ← Pane "#zone" dont le fond change
 * │                              │
 * ├──────────────────────────────┤
 * │ Rouge: 0  Vert: 0  Bleu: 0   │  ← Label "#compteurs"
 * └──────────────────────────────┘
 * </pre>
 *
 * <p>Chaque clic sur un bouton :
 *
 * <ul>
 *   <li>change la couleur de fond de la zone centrale ;
 *   <li>incrémente le compteur correspondant dans le label du bas.
 * </ul>
 *
 * <p>Les trois compteurs sont indépendants : cliquer "Rouge" n'affecte pas les compteurs "Vert" et
 * "Bleu".
 */
public class Palette extends Application {

  @Override
  public void start(Stage primaryStage) {
    int[] compteurs = {0, 0, 0};

    Button btnRouge = new Button("Rouge");
    btnRouge.setId("btn-rouge");
    Button btnVert = new Button("Vert");
    btnVert.setId("btn-vert");
    Button btnBleu = new Button("Bleu");
    btnBleu.setId("btn-bleu");

    Pane zone = new Pane();
    zone.setId("zone");
    zone.setMinSize(300, 200);
    zone.setStyle("-fx-background-color: white;");

    Label compteursLabel = new Label("Rouge: 0  Vert: 0  Bleu: 0");
    compteursLabel.setId("compteurs");

    HBox boutons = new HBox(10, btnRouge, btnVert, btnBleu);
    BorderPane root = new BorderPane();
    root.setTop(boutons);
    root.setCenter(zone);
    root.setBottom(compteursLabel);

    btnRouge.setOnAction(
        e -> {
          compteurs[0]++;
          zone.setStyle("-fx-background-color: red;");
          compteursLabel.setText(
              "Rouge: " + compteurs[0] + "  Vert: " + compteurs[1] + "  Bleu: " + compteurs[2]);
        });

    btnVert.setOnAction(
        e -> {
          compteurs[1]++;
          zone.setStyle("-fx-background-color: green;");
          compteursLabel.setText(
              "Rouge: " + compteurs[0] + "  Vert: " + compteurs[1] + "  Bleu: " + compteurs[2]);
        });

    btnBleu.setOnAction(
        e -> {
          compteurs[2]++;
          zone.setStyle("-fx-background-color: blue;");
          compteursLabel.setText(
              "Rouge: " + compteurs[0] + "  Vert: " + compteurs[1] + "  Bleu: " + compteurs[2]);
        });

    Scene scene = new Scene(root, 400, 320);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
