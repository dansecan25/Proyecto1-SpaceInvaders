package proyecto1.Enemigos;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import proyecto1.Animaciones.currentClass;
import proyecto1.Excepciones.IndiceInvalidoException;
import proyecto1.Hileras.HileraC;
import proyecto1.Hileras.HileraD;
import proyecto1.Imagenes.Imagenes;
import proyecto1.Ventanas.VentanaDeJuego;
import java.util.Random;

/**
 * Clase NaveEnemiga.
 */
public class NaveEnemiga {
    private final Random random = new Random();
    private final Group ventana;
    private final Timeline comprobacion;
    private final ImageView nave;
    private int posicionLista;
    private boolean isBoss;
    private int puntosMorir = 5;
    private int vida;

    /**
     * Constructor para crear instancias de  NaveEnemiga.
     * @param x     Posicion X: int
     * @param y     Posicion Y: int
     * @param juego JavaFX Group
     */
    public NaveEnemiga(int x, int y, Group juego,int pos) {
        nave = spriteNaveAleatorio();
        nave.setX(x);
        nave.setY(y);
        juego.getChildren().add(nave);
        posicionLista=pos;
        isBoss = false;
        vida = 1;
        comprobacion = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            try {
                colision();
            } catch (IndiceInvalidoException e) {
                e.printStackTrace();
            }
        }));
        comprobarColision();
        ventana = juego;

    }

    /**
     * Retorna la vida actual de la nave
     * @return vida: int
     */
    public int getVida(){
        return vida;
    }

    /**
     * Actualiza el valor de posicion en la lista
     * @param posicion posicion en la lista: int
     */
    public void setPosicionLista(int posicion){
        this.posicionLista = posicion;
    }

    /**
     * Transforma un boss en una nave normal
     */
    public void toNave(){
        isBoss = false;
        nave.setImage(Imagenes.getInstancia().getUfo2());
        nave.setX(nave.getX() + 28);
        vida = 1;
        puntosMorir = 5;
    }

    /**
     * Método para transformar la nave en un Boss
     */
    public void toBoss(){
        int randomBossSprite = random.nextInt(4);
        switch (randomBossSprite){
            case 1 -> nave.setImage(Imagenes.getInstancia().getUfoBoss2());
            case 2 -> nave.setImage(Imagenes.getInstancia().getUfoBoss3());
            case 3 -> nave.setImage(Imagenes.getInstancia().getUfoBoss4());
            default -> nave.setImage(Imagenes.getInstancia().getUfoBoss1());
        }
        nave.setX(nave.getX() - 27);
        nave.setY(nave.getY() - 29);

        int randomBonusHP = random.nextInt(5);
        vida += randomBonusHP;
        puntosMorir += 5 * randomBonusHP;
        isBoss = true;
    }

    /**
     * Método para verificar si una nave es Boss
     * @return isBoss: boolean
     */
    public boolean esBoss(){ return isBoss;}

    /**
     * Selecciona un sprite aleatorio para la nave.
     * @return sprite: ImageView
     */
    private ImageView spriteNaveAleatorio(){
        ImageView sprite;
        int spriteID = random.nextInt(3);
        switch (spriteID) {
            case 1 -> sprite = new ImageView(Imagenes.getInstancia().getUfo2());
            case 2 -> sprite = new ImageView(Imagenes.getInstancia().getUfo3());
            default -> sprite = new ImageView(Imagenes.getInstancia().getUfo1());
        }
        return sprite;
    }

    /**
     * Comprueba si la nave ha colisionado con un objeto
     * @throws IndiceInvalidoException Excepcion lanzada en caso de errores al recorrer la lista
     */
    private void colision() throws IndiceInvalidoException {
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
                currentClass.getLista().borrarDato(this);
                if(currentClass.getLista().tamanoLista()>0){
                    currentClass.reordenar(posicionLista);
                }
                ventana.getChildren().remove(nave);
                VentanaDeJuego.updatePuntos(puntosMorir);
                if(isBoss && currentClass.getClase().equals("C")){
                    HileraC.cambiarJefe();
                }else if (currentClass.getClase().equals("D")){
                    HileraD.ordenarNaves();
                }
            }
        }
    }

    /**
     * Inicia el timeline para comprobar colisiones
     */
    private void comprobarColision(){
        comprobacion.setCycleCount(Timeline.INDEFINITE);
        comprobacion.play();
    }
    public ImageView getImagenNave(){
        return nave;
    }

    /**
     * Mueve la nave hacia la derecha
     */
    public void moveRight(){
        Timeline movimientoDerecha = new Timeline(new KeyFrame(Duration.millis(25),mover -> nave.setX(nave.getX()+1)));
        movimientoDerecha.setCycleCount(80);
        movimientoDerecha.play();
    }

    /**
     * Mueve la nave hacia la izquierda
     */
    public void moveLeft(){
        Timeline movimientoIzquierda = new Timeline(new KeyFrame(Duration.millis(25),mover -> nave.setX(nave.getX()-1)));
        movimientoIzquierda.setCycleCount(80);
        movimientoIzquierda.play();
    }

    /**
     * Mueve la nave hacia abajo
     */
    public void moveDown(){
        Timeline movimientoAbajo = new Timeline(new KeyFrame(Duration.millis(25),mover -> nave.setY(nave.getY()+1)));
        movimientoAbajo.setCycleCount(80);
        movimientoAbajo.play();
    }
}
