package sample;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LoadImg {
    public static Image loadImage(String archivo) throws FileNotFoundException {
        return new Image(new FileInputStream(archivo));
    }
}
