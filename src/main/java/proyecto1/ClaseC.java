package proyecto1;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

public class ClaseC {
    static ListaCircular l = new ListaCircular();
    public static void IniciarClase(Group juego) throws FileNotFoundException {
        Image ufo = Imagenes.getInstancia().getUfo1();
        new NaveEnemiga(110, 100, juego);
        new NaveEnemiga(220, 100, juego);
        new NaveEnemiga(330, 100, juego);
        new NaveEnemiga(440, 100, juego);
        new NaveEnemiga(550, 100, juego);





    }

}
