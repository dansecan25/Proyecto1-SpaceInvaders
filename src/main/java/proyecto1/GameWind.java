package proyecto1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class GameWind {
    public static void juego(Stage mainStage) throws FileNotFoundException {
        Group juego= new Group();
        Scene game = new Scene(juego, 800, 750, Color.valueOf("#262934"));
        Stage yano = new Stage();
        yano.setScene(game);
        // Boton para destruir ventana secundaria
        Button b2=new Button("Exit");
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                yano.close();
                mainStage.show();
            }
        });
        b2.setLayoutX(50);
        b2.setLayoutY(50);
        juego.getChildren().add(b2);
        new NaveEnemiga(110,100, juego);
        new NaveEnemiga(220,100, juego );
        new NaveEnemiga(330,100, juego);
        new NaveEnemiga(440,100, juego);
        new NaveEnemiga(550,100, juego);
//        ClaseC.IniciarClase(juego);
        yano.show();
    }
}
