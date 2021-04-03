package proyecto1;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

/*
 esto solo lo puse para poder poner un fondo,
 pero en esta clase hay que hacer lo del cambio del
 fondo con el cambio de nivel
 */

public class Fondo {
    public Fondo(Group juego) {
        ImageView fondo = new ImageView(Imagenes.getInstancia().getFondo1());
        fondo.setX(0);
        fondo.setY(0);
        juego.getChildren().add(fondo);
    }

    public static void IniciarFondo(Group ventanaDeJuego) {
        new Fondo(ventanaDeJuego);
    }
}
