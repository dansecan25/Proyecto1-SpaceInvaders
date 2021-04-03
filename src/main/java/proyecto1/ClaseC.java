package proyecto1;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Translate;

import java.io.FileNotFoundException;
import java.util.Set;


public class ClaseC {
    static ListaCircularImagenes l = new ListaCircularImagenes();
    public static void IniciarClaseC(Group juego) throws FileNotFoundException {
        new NaveEnemiga(110, 100, juego);
        new NaveEnemiga(220, 100, juego);
        new NaveEnemiga(330, 100, juego);
        new NaveEnemiga(440, 100, juego);
        new NaveEnemiga(550, 100, juego);
//        Set<Node> listaNodos = juego.lookupAll("#ufos");
//        Object[] z= listaNodos.toArray();
//        int largo = z.length;
//        int i =0;
//        while (i<largo){
//            l.addLast(z[i]);
//            i+=1;
//        }
//        Thread animacion = new Thread(() -> {
//
//        });
//        animacion.start();

//        Translate mover = new Translate();
//        mover.setX(220);
//        mover.setY(200);
//        m.getTransforms().add(mover);







    }

}
