package proyecto1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class NaveEnemiga {
    ImageView nave;

    public NaveEnemiga(int x, int y, Group juego) {
        nave = new ImageView(Imagenes.getInstancia().getUfo1());
        nave.setX(x);
        nave.setY(y);
        nave.setId("ufos");
        juego.getChildren().add(nave);
        comprobarColision();
    }
    private void colision(){
        if (this.nave.getBoundsInParent().intersects(VentanaDeJuego.getJugador().getDisparo().getBoundsInParent())){
            VentanaDeJuego.getJugador().setEstadoDisparo(true);
            System.out.println("Colision detectada");
        }
    }
    private void comprobarColision(){
        Timeline comprobacion = new Timeline(new KeyFrame(Duration.millis(100), event -> colision()));
        comprobacion.setCycleCount(Timeline.INDEFINITE);
        comprobacion.play();
    }
    public ImageView getImagenNave(){
        return nave;
    }
}
