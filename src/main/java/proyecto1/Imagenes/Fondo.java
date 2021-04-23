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
    private static ImageView fondo;
    /**
     * Instantiates a new Fondo.
     *
     * @param juego the juego
     */
    public Fondo(Group juego) {
        //ImageView fondo = new ImageView(Imagenes.getInstancia().getFondo1());
        fondo = new ImageView(Imagenes.getInstancia().getFondo1());
        fondo.setX(0);
        fondo.setY(0);
        juego.getChildren().add(fondo);
    }

    /**
     * Iniciar fondo.
     *
     * @param ventanaDeJuego the ventana de juego
     */
    public static void IniciarFondo(Group ventanaDeJuego) {
        new Fondo(ventanaDeJuego);
    }

    /**
     * Retorna el fondo
     * @return fondo: ImageView
     */
    public static ImageView getFondo(){
        return fondo;
    }

    /**
     * Cambia el fondo dependiendo del nivel
     * @param nivel: int
     */
    public static void setFondo(int nivel){
        if (nivel ==2){
            fondo.setImage(Imagenes.getInstancia().getFondo2());
        }
        if (nivel ==3){
            fondo.setImage(Imagenes.getInstancia().getFondo3());
        }
        if (nivel ==4){
            fondo.setImage(Imagenes.getInstancia().getFondo4());
        }
        if (nivel ==5){
            fondo.setImage(Imagenes.getInstancia().getFondo5());
        }

    }
}
