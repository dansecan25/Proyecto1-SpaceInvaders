package proyecto1.Enemigos;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import proyecto1.Animaciones.Animacion;
import proyecto1.Animaciones.currentClass;
import proyecto1.Hileras.HileraC;
import proyecto1.Imagenes.Imagenes;
import proyecto1.Ventanas.VentanaDeJuego;

import java.util.Random;

/**
 * The type Nave enemiga.
 */
public class NaveEnemiga {
    private int posicionLis;
    private final Group ventana;
    private final Timeline comprobacion;
    /**
     * The Nave.
     */
    private final ImageView nave;
    private int puntosMorir = 5;

    private int vida;

    /**
     * Instantiates a new Nave enemiga.
     *
     * @param x     the x
     * @param y     the y
     * @param juego the juego
     */
    public NaveEnemiga(int x, int y, Group juego,int pos) {
        nave = spriteAleatorio();
        nave.setX(x);
        nave.setY(y);
        nave.setId("ufos");
        juego.getChildren().add(nave);
        posicionLis=pos;
        vida = 1;
        Animacion.iniciarAnimacion(this.nave);
        comprobacion = new Timeline(new KeyFrame(Duration.millis(100), event -> colision()));
        comprobarColision();
        ventana = juego;

    }
    public void setPosicionLis(int posicion){
        this.posicionLis = posicion;
    }

    public void toBossE() {
        nave.setImage(Imagenes.getInstancia().getUfoBoss1());
        vida = 2;
        puntosMorir = 10;
    }

    public void toNave(){
        nave.setImage(Imagenes.getInstancia().getUfo2());
        vida = 0;
        puntosMorir = 5;
    }

    public void toBoss(){
        nave.setImage(Imagenes.getInstancia().getUfoBoss1());
        vida += 2;
        puntosMorir+=10;
    }
    private ImageView spriteAleatorio(){
        ImageView sprite;
        Random random = new Random();
        int spriteID = random.nextInt(3);
        switch (spriteID) {
            case 1 -> sprite = new ImageView(Imagenes.getInstancia().getUfo2());
            case 2 -> sprite = new ImageView(Imagenes.getInstancia().getUfo3());
            default -> sprite = new ImageView(Imagenes.getInstancia().getUfo1());
        }
        return sprite;
    }
    private void colision(){
        if (!VentanaDeJuego.getJugador().getDisparo().isVisible()){
            return;
        }
        if (this.nave.getBoundsInParent().intersects(VentanaDeJuego.getJugador().getDisparo().getBoundsInParent())){
            VentanaDeJuego.getJugador().setEstadoDisparo(true);
            vida -= 1;
            if (vida <= 0){

                //currentClass.getLista().borrarPosicion(this.posicionLis);
                currentClass.getLista().borrarDato(this);
                if(currentClass.getLista().tamanoLista()>0){
                    currentClass.reordenar();
                }
                ventana.getChildren().remove(nave);
                comprobacion.stop();
                VentanaDeJuego.updatePuntos(puntosMorir);
                if(puntosMorir == 15 && currentClass.getClase().equals("C")){
                    HileraC.cambiarJefe();
                    //ClaseE.cambiarJefe();
                }
            }
        }
    }
    private void comprobarColision(){
        comprobacion.setCycleCount(Timeline.INDEFINITE);
        comprobacion.play();
    }
    public ImageView getImagenNave(){
        return nave;
    }
}
