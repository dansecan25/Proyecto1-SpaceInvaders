package proyecto1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Animacion {
    public static void iniciarAnimacion(ImageView nodo){
        Task<Void> animacion = new Task<>() {
            @Override
            public Void call() {
                if (nodo.getY() < 710) {
                    try {
                        moveRight(nodo);
                        Thread.sleep(2000);
                        moveDown(nodo);
                        System.out.println(nodo.getY());
                        Thread.sleep(2000);
                        moveLeft(nodo);
                        Thread.sleep(2000);
                        moveDown(nodo);
                        System.out.println(nodo.getY());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };
        animacion.setOnSucceeded(event -> {
            if (animacion.isDone()){
                iniciarAnimacion(nodo);
            }
        });
        new Thread(animacion).start();
    }
    private static void moveRight(ImageView nodo){
        Timeline movimientoDerecha = new Timeline(new KeyFrame(Duration.millis(25),mover -> nodo.setX(nodo.getX()+1)));
        movimientoDerecha.setCycleCount(80);
        movimientoDerecha.play();
    }
    private static void moveLeft(ImageView nodo){
        Timeline movimientoIzquierda = new Timeline(new KeyFrame(Duration.millis(25),mover -> nodo.setX(nodo.getX()-1)));
        movimientoIzquierda.setCycleCount(80);
        movimientoIzquierda.play();
    }
    private static void moveDown(ImageView nodo){
        Timeline movimientoAbajo = new Timeline(new KeyFrame(Duration.millis(25),mover -> nodo.setY(nodo.getY()+1)));
        movimientoAbajo.setCycleCount(80);
        movimientoAbajo.play();
    }
}
