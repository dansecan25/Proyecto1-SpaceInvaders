package proyecto1;

import javafx.scene.image.ImageView;

import static javafx.application.Application.launch;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;


public class NaveUsuario {
    double posicionX = 200;
    double posicionY = 600;
    public NaveUsuario(Group juego) {
        ImageView user = new ImageView(Imagenes.getInstancia().getNaveUsuario());
        user.setX(posicionX);
        user.setY(posicionY);
        juego.getChildren().add(user);
        configuracionMouseX(juego);
    }

    public static void IniciarNaveUsuario(Group ventanaDeJuego) {
        new NaveUsuario(ventanaDeJuego);
    }

    public void configuracionMouseX(Group juego) {
        juego.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double posicionMouseX = event.getX();
                System.out.println(posicionMouseX);
            }
        });
    }

    public static void dispararLaser() {

    }

}
