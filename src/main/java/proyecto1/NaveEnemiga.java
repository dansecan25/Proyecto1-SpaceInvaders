package proyecto1;

import java.io.FileNotFoundException;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NaveEnemiga {
    ListaCircular l = new ListaCircular();
    ListaCircular m = new ListaCircular();
    ImageView nave;

    public NaveEnemiga(int x, int y, Group juego) throws FileNotFoundException {
        //Image imagen = Imagenes.getInstancia().getUfo1();
        //imagen = Imagenes.getInstancia().cambiarTamano(imagen);
        nave = new ImageView(Imagenes.getInstancia().getUfo1());
        nave.setX(x);
        nave.setY(y);
        nave.setId("ufos");
        juego.getChildren().add(nave);
//        var boundingBox = nave.getBoundsInLocal();
//        var f = boundingBox.intersects(banano.getBoundsInLocal());
        //System.out.println(f);
    }

    public ImageView getImagenNave(){
        return nave;
    }
}
