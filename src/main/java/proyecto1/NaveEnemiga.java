package proyecto1;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class NaveEnemiga {
    int x;
    int y;
    ImageView nave = new ImageView(Imagenes.getInstancia().getUfo1());

    public NaveEnemiga(int x, int y, Group juego) {
        this.nave.setX(x);
        this.nave.setY(y);
        this.x = x;
        this.y = y;
        Animacion.iniciarAnimacion(this.nave); //inicia la animación, se le manda el nodo a animar
        juego.getChildren().add(this.nave);
    }
}
