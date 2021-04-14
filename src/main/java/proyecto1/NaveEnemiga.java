package proyecto1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class NaveEnemiga {
    ListaCircular l = new ListaCircular();
    ImageView nave;

    public NaveEnemiga(int x, int y, Group juego) throws FileNotFoundException {
        //Image imagen = Imagenes.getInstancia().getUfo1();
        //imagen = Imagenes.getInstancia().cambiarTamano(imagen);
        nave = new ImageView(Imagenes.getInstancia().getUfo1());
        nave.setX(x);
        nave.setY(y);
        nave.setId("ufos");
        l.agregarUltimo(nave);
        juego.getChildren().add(nave);
    }
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
