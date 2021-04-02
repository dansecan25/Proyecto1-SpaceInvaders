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
        Scene gameScene = new Scene(juego, 800, 750, Color.valueOf("#262934"));
        Stage GameStage = new Stage();
        GameStage.setScene(gameScene);
        // Boton para destruir ventana secundaria
        Button b2=new Button("Exit");
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GameStage.close();
                mainStage.show();
            }
        });
        b2.setLayoutX(50); //define la posicion en x del boton
        b2.setLayoutY(50); //posicion y
        juego.getChildren().add(b2);
        ClaseC.IniciarClase(juego); //inicia la clase C, luego se cambiara en un loop aleatorio, esto es solo para probarlo
        GameStage.show(); //requerido para mostrar el stage
    }
}
