package proyecto1;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

public class ClaseC {
    static ListaCircular l = new ListaCircular();
    public static void IniciarClase(Group juego) throws FileNotFoundException {
        var ufo = LoadImg.loadImage("Imagenes/UFO1.png");
        ImageView nave1 = new ImageView();
        ImageView nave2 = new ImageView();
        ImageView nave3 = new ImageView();
        ImageView nave4 = new ImageView();
        ImageView nave5 = new ImageView();
        nave1.setImage(ufo);
        nave2.setImage(ufo);
        nave3.setImage(ufo);
        nave4.setImage(ufo);
        nave5.setImage(ufo);
        int x = 110;
        nave1.setX(x);
        nave1.setY(100);
        juego.getChildren().add(nave1);

        int x2=x+110;
        nave2.setX(x2);
        nave2.setY(100);
        juego.getChildren().add(nave2);
        nave3.setX(330);
        nave3.setY(100);
        juego.getChildren().add(nave3);
        nave4.setX(440);
        nave4.setY(100);
        juego.getChildren().add(nave4);
        nave5.setX(550);
        nave5.setY(100);
        juego.getChildren().add(nave5);
        int i=0;




    }

}
