package proyecto1;

import java.io.FileNotFoundException;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class NaveEnemiga{

    public NaveEnemiga(int x, int y, Group juego) throws FileNotFoundException{

        var spriteUFO = LoadImg.loadImage("/Proyecto1-SpaceInvaders/Imagenes/UFO1.png");
        ImageView nave = new ImageView();
        nave.setImage(spriteUFO);
        nave.setX(x);
        nave.setY(y);
        juego.getChildren().add(nave);
    }
}
