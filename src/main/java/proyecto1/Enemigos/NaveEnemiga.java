package proyecto1.Enemigos;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import proyecto1.Animaciones.Animacion;
import proyecto1.Animaciones.currentClass;
import proyecto1.Hileras.HileraC;
import proyecto1.Hileras.HileraD;
import proyecto1.Imagenes.Imagenes;
import proyecto1.Ventanas.VentanaDeJuego;

import java.util.Random;

/**
 * The type Nave enemiga.
 */
public class NaveEnemiga {
    private int posicionLista;
    private final Group ventana;
    private final Timeline comprobacion;
    private final ImageView nave;
    private boolean isBoss = false;
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
        nave = spriteNaveAleatorio();
        nave.setX(x);
        nave.setY(y);
        nave.setId("ufos");
        juego.getChildren().add(nave);
        posicionLista=pos;
        vida = 1;
        Animacion.iniciarAnimacion(nave);
        comprobacion = new Timeline(new KeyFrame(Duration.millis(100), event -> colision()));
        comprobarColision();
        ventana = juego;

    }
    public void setPosicionLista(int posicion){
        this.posicionLista = posicion;
    }

    public void toNave(){
        isBoss = false;
        nave.setImage(Imagenes.getInstancia().getUfo2());
        nave.setX(nave.getX() + 28);
        vida = 1;
        puntosMorir = 5;
    }

    public void toBoss(){
        isBoss = true;
        nave.setImage(spriteBossAleatorio());
        nave.setX(nave.getX() - 28);
        vida += new Random().nextInt(4);
        puntosMorir+=10;
    }
    private ImageView spriteNaveAleatorio(){
        ImageView sprite;
        int spriteID = new Random().nextInt(3);
        sprite= switch (spriteID) {
            case 1 -> new ImageView(Imagenes.getInstancia().getUfo2());
            case 2 -> new ImageView(Imagenes.getInstancia().getUfo3());
            default -> new ImageView(Imagenes.getInstancia().getUfo1());
        };
        return sprite;
    }
    private Image spriteBossAleatorio(){
        Image sprite;
        int spriteID = new Random().nextInt(4);
        sprite = switch (spriteID) {
            case 1 -> Imagenes.getInstancia().getUfoBoss2();
            case 2 -> Imagenes.getInstancia().getUfoBoss3();
            case 3 -> Imagenes.getInstancia().getUfoBoss4();
            default -> Imagenes.getInstancia().getUfoBoss1();
        };
        return sprite;
    }
    private void colision(){
        if (!VentanaDeJuego.getJugador().getDisparo().isVisible()){
            return;
        }
        if (this.nave.getBoundsInParent().intersects(VentanaDeJuego.getJugador().getDisparo().getBoundsInParent())){
            VentanaDeJuego.getJugador().setEstadoDisparo(true);
            vida -= 1;
            if (currentClass.getClase().equals("D")){
                HileraD.ordenarNaves();
            }
            if (vida <= 0){
                currentClass.getListaCirular().borrarDato(this);
                if(currentClass.getListaCirular().tamanoLista()>0){
                    currentClass.reordenar();
                }
                ventana.getChildren().remove(nave);
                comprobacion.stop();
                VentanaDeJuego.updatePuntos(puntosMorir);
                if(isBoss && (currentClass.getClase().equals("C") || currentClass.getClase().equals("E"))){
                    HileraC.cambiarJefe();
                    //ClaseE.cambiarJefe();
                }
            }else if(currentClass.getClase().equals("D")){
                HileraD.ordenarNaves();
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
    public int getVida(){
        return vida;
    }
    public int getPosicionLista(){
        return posicionLista;
    }
}
