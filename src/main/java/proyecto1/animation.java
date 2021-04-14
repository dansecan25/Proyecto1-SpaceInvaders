package proyecto1;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Translate;
import javafx.util.Duration;
//como todos los nodos son nave, entonces todos se usan como 1
public class animation {
    public animation(ImageView nodo){
    moveRight(nodo);
    }
    public void moveRight(ImageView nodo){
        TranslateTransition moverDer = new TranslateTransition();
        moverDer.setByX(20); //esto indica cuantos pixeles se vana a mover
        moverDer.setDuration(Duration.millis(10000));
        moverDer.setCycleCount(1); //cuantas veces se repite la animación
        moverDer.setAutoReverse(false); //si fuera true, se devuelve a la posicion incial como se movio de la inicial al final
        moverDer.setNode(nodo); //le aplica al nodo la animación
        moverDer.play(); //incia la animacion
    }
}
