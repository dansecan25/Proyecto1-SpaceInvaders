package proyecto1.Imagenes;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

/*
 esto solo lo puse para poder poner un fondo,
 pero en esta clase hay que hacer lo del cambio del
 fondo con el cambio de nivel
 */

/**
 * The type Fondo.
 */
public class Fondo {
    private static ImageView fond;
    /**
     * Instantiates a new Fondo.
     *
     * @param juego the juego
     */
    public Fondo(Group juego) {
        ImageView fondo = new ImageView(Imagenes.getInstancia().getFondo1());
        fondo.setX(0);
        fondo.setY(0);
        juego.getChildren().add(fondo);
        fond = fondo;
    }

    /**
     * Iniciar fondo.
     *
     * @param ventanaDeJuego the ventana de juego
     */
    public static void IniciarFondo(Group ventanaDeJuego) {
        new Fondo(ventanaDeJuego);
    }
    public static ImageView getFondo(){
        return fond;
    }
}
