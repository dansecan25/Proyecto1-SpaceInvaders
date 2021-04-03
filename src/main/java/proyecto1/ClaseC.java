package proyecto1;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Translate;

import java.io.FileNotFoundException;


public class ClaseC {
    static ListaCircular l = new ListaCircular();
    public static void IniciarClaseC(Group juego) throws FileNotFoundException {
        new NaveEnemiga(110, 100, juego);
        new NaveEnemiga(220, 100, juego);
        new NaveEnemiga(330, 100, juego);
        new NaveEnemiga(440, 100, juego);
        new NaveEnemiga(550, 100, juego);

        //System.out.println(juego.lookupAll("#ufos"));
        var m = juego.lookupAll("#ufos");
//        Translate mover = new Translate();
//        mover.setX(220);
//        mover.setY(200);
//        m.getTransforms().add(mover);

        var z= m.toArray();
        //System.out.println(z[0]);
        //l.addLast();
        //l.inicio();






    }

}
