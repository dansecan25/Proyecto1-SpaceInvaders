package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ClaseC {
    static ListaCircular l = new ListaCircular();
    public static void IniciarClase(Group juego) throws FileNotFoundException {
        Image ufo1 = new Image(new FileInputStream("Imagenes/UFO1.png"));
        ImageView nave1 = new ImageView();
        ImageView nave2 = new ImageView();
        nave1.setImage(ufo1);
        nave2.setImage(ufo1);
        nave1.setX(100);
        nave1.setY(100);
        juego.getChildren().add(nave2);
        nave2.setX(500);
        nave2.setY(100);
        juego.getChildren().add(nave1);
        l.addLast(36);
        l.addLast(55);
        l.addLast(45);
        l.addLast(48);
        l.leer();
        l.replacePos(2,234);
        l.leer();



    }
}
