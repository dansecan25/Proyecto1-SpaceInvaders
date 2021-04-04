package proyecto1;

import javafx.concurrent.Task;
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
    private static boolean alive = true;
    public static void IniciarClaseC(Group juego) throws FileNotFoundException {
        currentClass.setClass("A", l);
        new NaveEnemiga(110, 100, juego, l);
        new NaveEnemiga(220, 100, juego, l);
        new NaveEnemiga(330, 100, juego, l);
        new NaveEnemiga(440, 100, juego, l);
        new NaveEnemiga(550, 100, juego, l);
        Task<Void> vivo = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                int i = 0;
                while(i<10){
                    if(i==5){
                        alive=false;
                        break;
                    }
                    i+=1;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };
        vivo.setOnSucceeded(event -> {
            if(!alive){
                double pos=Math.random()*l.largo;
                int posicion =  (int) pos;


                var nodo =l.obtenerDato(posicion);
                double x = nodo.getX();
                double y = nodo.getY();
                juego.getChildren().remove(nodo);
                nodo = new ImageView(Imagenes.getInstancia().getUfoBoss());
                nodo.setX(x);
                nodo.setY(y);
                l.replacePos(posicion,nodo);
                new animation(nodo);
                juego.getChildren().add(nodo);
            }
        });
        new Thread(vivo).start();


    }

}
