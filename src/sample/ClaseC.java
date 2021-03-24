package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ClaseC {
    static ListaCircular l = new ListaCircular();
    public static void IniciarClase(Group juego) throws FileNotFoundException {
        var ufo = LoadImg.loadImage("Imagenes/UFO1.png");
        ImageView nave1 = new ImageView();
        ImageView nave2 = new ImageView();
        ImageView nave3 = new ImageView();
        nave1.setImage(ufo);
        nave2.setImage(ufo);
        nave1.setX(100);
        nave1.setY(100);
        juego.getChildren().add(nave2);
        nave2.setX(110);
        nave2.setY(100);
        juego.getChildren().add(nave1);




    }
}
