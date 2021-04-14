package proyecto1;

import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.concurrent.Task;
import javafx.animation.TranslateTransition;

public class Animacion {
    public static void iniciarAnimacion(ImageView nodo){
        Task<Void> animacion = new Task<>() {
            @Override
            public Void call() {
                if (nodo.getY() < 1200) {
                    try {
                        moveRight(nodo);
                        Thread.sleep(2000);
                        moveDown(nodo);
                        Thread.sleep(2000);
                        moveLeft(nodo);
                        Thread.sleep(2000);
                        moveDown(nodo);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };
        new Thread(animacion).start();
        animacion.setOnSucceeded(event -> {
            if (animacion.isDone()){
                new Thread(animacion).start();
            }
        });
    }
    public static void moveRight(ImageView nodo){
        TranslateTransition moverDerecha = new TranslateTransition();
        moverDerecha.setByX(80); //esto indica cuantos pixeles se vana a mover
        moverDerecha.setDuration(Duration.millis(2000));
        moverDerecha.setNode(nodo); //le aplica al nodo la animación
        moverDerecha.play(); //incia la animacion
    }
    public static void moveDown(ImageView nodo){
        TranslateTransition moverAbajo = new TranslateTransition();
        moverAbajo.setByY(40); //esto indica cuantos pixeles se vana a mover
        moverAbajo.setDuration(Duration.millis(2000));
        moverAbajo.setNode(nodo); //le aplica al nodo la animación
        moverAbajo.play(); //incia la animacion
    }
    public static void moveLeft(ImageView nodo){
        TranslateTransition moverIzquierda = new TranslateTransition();
        moverIzquierda.setByX(-80); //esto indica cuantos pixeles se vana a mover
        moverIzquierda.setDuration(Duration.millis(2000));
        moverIzquierda.setNode(nodo); //le aplica al nodo la animación
        moverIzquierda.play(); //incia la animacion
    }

}
