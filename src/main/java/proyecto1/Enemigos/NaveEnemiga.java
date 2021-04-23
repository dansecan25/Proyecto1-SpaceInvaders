package proyecto1.Enemigos;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
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
    Random random = new Random();
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
        comprobacion = new Timeline(new KeyFrame(Duration.millis(100), event -> colision()));
        comprobarColision();
        ventana = juego;
    }

    /**
     * Retorna la vida
     * @return vida: int
     */
    public int getVida(){
        return vida;
    }

    /**
     * Cambia la variable que indica la posicion de la nave en la lista
     * @param posicion: int
     */
    public void setPosicionLista(int posicion){
        this.posicionLista = posicion;
    }

    /**
     * Convierte un boss en una nave normal
     */
    public void toNave(){
        isBoss = false;
        nave.setImage(Imagenes.getInstancia().getUfo2());
        nave.setX(nave.getX() + 28);
        vida = 1;
        puntosMorir = 5;
    }

    /**
     * Convierte una nave en un boss
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

        int randomBonusHP = random.nextInt(4) + 1;
        vida = randomBonusHP;
        puntosMorir += 5 * randomBonusHP;
        isBoss = true;
    }

    /**
     * Comprueba si la nave es un boss
     * @return isBoss: boolean
     */
    public boolean esBoss(){ return isBoss;}

    /**
     * Asigna un sprite (imagen) aleatorio a la nave
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
     * Detecta colisiones
     */
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
                currentClass.getLista().borrarDato(this);
                if(currentClass.getLista().tamanoLista()>0){
                    currentClass.reordenar(posicionLista);
                }
                ventana.getChildren().remove(nave);
                comprobacion.stop();
                VentanaDeJuego.updatePuntos(puntosMorir);
                if(isBoss && (currentClass.getClase().equals("C") || currentClass.getClase().equals("E"))){
                    HileraC.cambiarJefe();
                    //ClaseE.cambiarJefe();
                }
                if(isBoss && (currentClass.getClase().equals("A"))){
                    //
                }
            }else if(currentClass.getClase().equals("D")){
                HileraD.ordenarNaves();
            }
        }
    }

    /**
     * Inicia el timeline que comprueba colisiones
     */
    private void comprobarColision(){
        comprobacion.setCycleCount(Timeline.INDEFINITE);
        comprobacion.play();
    }

    /**
     * Retorna la imagen de la nave
     * @return nave: ImageView
     */
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
