package proyecto1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import java.io.FileNotFoundException;
import java.io.Serializable;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileNotFoundException;

/**
 * The type Nave enemiga.
 */
public class NaveEnemiga {
    ImageView nave = new ImageView(Imagenes.getInstancia().getUfo1());

    public NaveEnemiga(int x, int y, Group juego) {
        this.nave.setX(x);
        this.nave.setY(y);
        this.nave.setId("ufos");
        Animacion.iniciarAnimacion(this.nave); //inicia la animación, se le manda el nodo a animar
        juego.getChildren().add(this.nave);
    }

    /**
     * Get imagen nave image view.
     *
     * @return the image view
     */
/*
    private void colision(ImageView Laser){
        if (this.nave.getBoundsInParent().intersects(Laser.getBoundsInParent())){
            Laser.setC;
        }
    }
    private void comprobarColision(ImageView Laser){
        Timeline comprobacion = new Timeline(new KeyFrame(Duration.millis(100), event -> colision(Laser)));
        comprobacion.setCycleCount(Timeline.INDEFINITE);
        comprobacion.play();
    }

//        var boundingBox = nave.getBoundsInLocal();
//        var f = boundingBox.intersects(banano.getBoundsInLocal());
        //System.out.println(f);

    private void colision(ImageView Laser){
        if (this.nave.getBoundsInParent().intersects(Laser.getBoundsInParent())){
            Laser.setC;
        }
    }
    private void comprobarColision(ImageView Laser){
        Timeline comprobacion = new Timeline(new KeyFrame(Duration.millis(100), event -> colision(Laser)));
        comprobacion.setCycleCount(Timeline.INDEFINITE);
        comprobacion.play();
    }

 */
    public ImageView getImagenNave(){
        return nave;
    }
}
