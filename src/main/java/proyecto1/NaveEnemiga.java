package proyecto1;

import java.io.FileNotFoundException;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class NaveEnemiga {
    public NaveEnemiga(int x, int y, Group juego, ListaCircularImagenes l) throws FileNotFoundException {
        ImageView nave = new ImageView(Imagenes.getInstancia().getUfo1());
        nave.setX(x);
        nave.setY(y);
        l.addLast(nave);
        new animation(nave); //inicia la animación, se le manda el nodo a animar
        juego.getChildren().add(nave);
    }
    public static void toBoss(ImageView nodo){
        double x = nodo.getX();
        nodo.setImage(Imagenes.getInstancia().getUfoBoss());
        nodo.setX(x-10);
    }
}
