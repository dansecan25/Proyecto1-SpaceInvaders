package sample;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LoadImg {
    public static Image loadImage(String archivo) throws FileNotFoundException {
        Image imagen = new Image(new FileInputStream(archivo));
        return imagen;
    }
}
