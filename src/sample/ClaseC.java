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
        l.addFirst(25);
        l.addFirst(36);
        l.addFirst(66);
        //l.addLast(95);
        l.leer();
        l.obtenerDato(2);



    }
}
