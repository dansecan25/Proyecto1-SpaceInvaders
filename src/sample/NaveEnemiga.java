package sample;

import java.io.FileNotFoundException;
import javafx.scene.image.ImageView;

public class NaveEnemiga{

    public NaveEnemiga(int x, int y) throws FileNotFoundException{
        var spriteUFO = LoadImg.loadImage("Imagenes/UF01.png");
        ImageView nave = new ImageView();
        nave.setImage(spriteUFO);
        nave.setX(x);
        nave.setY(y);
    }
}
