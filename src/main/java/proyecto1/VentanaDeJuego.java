package proyecto1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class VentanaDeJuego {
    public static void iniciarVentanaDeJuego(Stage mainStage) throws FileNotFoundException {
        Group ventanaDeJuego= new Group();
        Scene gameScene = new Scene(ventanaDeJuego, 850, 700, Color.valueOf("#262934"));
        Stage GameStage = new Stage();
        GameStage.setScene(gameScene);
        // Boton para destruir ventana secundaria
        Button botonExit = new Button("Exit");
        botonExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GameStage.close();
                mainStage.show();
            }
        });
        botonExit.setLayoutX(50); //define la posicion en x del boton
        botonExit.setLayoutY(50); //posicion y
        ventanaDeJuego.getChildren().add(botonExit);
        Fondo.IniciarFondo(ventanaDeJuego);
        ClaseC.IniciarClaseC(ventanaDeJuego); //inicia la clase C, luego se cambiara en un loop aleatorio, esto es solo para probarlo
        NaveUsuario.IniciarNaveUsuario(ventanaDeJuego);
        GameStage.show(); //requerido para mostrar el stage
    }
}
