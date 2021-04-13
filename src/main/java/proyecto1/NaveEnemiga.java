package proyecto1;

import java.io.FileNotFoundException;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NaveEnemiga {
    ListaCircular l = new ListaCircular();
    ImageView nave;

    public NaveEnemiga(int x, int y, Group juego) throws FileNotFoundException {
        //Image imagen = Imagenes.getInstancia().getUfo1();
        //imagen = Imagenes.getInstancia().cambiarTamano(imagen);
        nave = new ImageView(Imagenes.getInstancia().getUfo1());
        nave.setX(x);
        nave.setY(y);
        nave.setId("ufos");
        juego.getChildren().add(nave);
    }

    public ImageView getImagenNave(){
        return nave;
    }
}
