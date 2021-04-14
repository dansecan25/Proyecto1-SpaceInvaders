package proyecto1;

import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class NaveUsuario {
    private double posicionX = 200;
    private double posicionY = 600;
    private double posicionYLaser = 550;
    private ImageView user = new ImageView(Imagenes.getInstancia().getNaveUsuario());
    private ImageView laser = new ImageView(Imagenes.getInstancia().getLaser());
    private Task<Void> animacionLaser;
    private boolean pararAnimacion = false;
    private boolean disparoAcertado = false;

    public NaveUsuario(Group juego) {
        user.setX(posicionX);
        user.setY(posicionY);
        juego.getChildren().add(user);
        laser.setX(0);
        laser.setY(0);
        laser.setVisible(false);
        juego.getChildren().add(laser);
        configuracionMouseX(juego);
        dispararLaser(juego);
        animacionLaser();
    }

    public static void IniciarNaveUsuario(Group ventanaDeJuego) {
        new NaveUsuario(ventanaDeJuego);
    }

    public void configuracionMouseX(Group juego) {
        juego.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double posicionMouseX = event.getX();
                // System.out.println(posicionMouseX);
                user.setX(posicionMouseX - 70);
            }
        });
    }

    public void dispararLaser(Group juego) {
        juego.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!laser.isVisible()) {
                    laser.setX(event.getX() - 26);
                    laser.setY(posicionYLaser);
                    laser.setVisible(true);
                }
            }
        });
    }
    public void setAcierto(){
        this.disparoAcertado = true;
    }
    public void animacionLaser(){
        animacionLaser = new Task<Void>() {
            @Override
            public Void call(){
                while (!pararAnimacion) {
                    try {
                        Thread.sleep(250);
                        if (laser.getY() > 75) {
                            laser.setY(laser.getY() - 30);
                        }else{
                            laser.setVisible(false);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                return null;
            }
        };
        animacionLaser.setOnSucceeded(event -> {
            if (animacionLaser.isDone()){
                new Thread(animacionLaser).start();
            }
        });
        new Thread(animacionLaser).start();
    }

}
