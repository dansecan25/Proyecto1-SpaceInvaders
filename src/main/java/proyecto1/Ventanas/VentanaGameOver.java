package proyecto1.Ventanas;

import javafx.scene.Scene;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Button;

import proyecto1.Imagenes.Imagenes;


import java.io.FileNotFoundException;

public class VentanaGameOver {
/**
 * Ventana GameOver
 * @throws  java.io.FileNotFoundException
 */

    public static void VentanaGameOver(Group GameOver) throws FileNotFoundException {
        Group overGroup = new Group();
        Scene overScene = new Scene(overGroup, 850, 700, Color.valueOf("#262934"));
        Stage overStage = new Stage();

        overStage.setScene(overScene);

        //Imagen de fondo
        ImageInput fondoOver = new ImageInput(Imagenes.getInstancia().getFondo());
        Rectangle rectanguloFondoOver = new Rectangle();
        fondoOver.setX(0);
        fondoOver.setY(-5);
        rectanguloFondoOver.setEffect(fondoOver);
        overGroup.getChildren().add(rectanguloFondoOver);

        //Botón para volver a la ventana principal

        ImageInput titleGameOver = new ImageInput(Imagenes.getInstancia().getGO());
        ImageView startOver = new ImageView(Imagenes.getInstancia().getBotonExit());
        Button botonReset = new Button();
        botonReset.setOnAction(event -> {
            overStage.close();
            VentanaPrincipal.getStage().show();
        });

        //Posicionamiento de los botones
        botonReset.setLayoutX(500);
        botonReset.setLayoutY(25);
        botonReset.setGraphic(startOver);
        titleGameOver.setX(167);
        titleGameOver.setY(200);


        overStage.show();
    }
}

