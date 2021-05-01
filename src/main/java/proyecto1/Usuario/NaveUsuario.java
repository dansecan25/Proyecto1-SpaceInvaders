package proyecto1.Usuario;

import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import proyecto1.Imagenes.Imagenes;


/**
 * La clase Nave usuario, la nave del usuario que puede mover y disparar.
 */
public class NaveUsuario {
    private double posicionX = 200;
    private double posicionY = 600;
    private double posicionYLaser = 550;
    private ImageView user = new ImageView(Imagenes.getInstancia().getNaveUsuario());
    private ImageView laser = new ImageView(Imagenes.getInstancia().getLaser());
    private Task<Void> animacionLaser;
    private boolean pararAnimacion = false;
    private boolean disparoAcertado;

    /**
     * Instancia nueva Nave usuario.
     *
     * @param juego the juego
     */
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
        disparoAcertado = false;
    }

    /**
     * Configuracion mouse x, permite qe el usuario pueda mover
     * la nave mediante el mouse.
     *
     * @param juego la ventana de juego
     */
    public void configuracionMouseX(Group juego) {
        juego.setOnMouseMoved(new EventHandler<>() {
            @Override
            public void handle(MouseEvent event) {
                double posicionMouseX = event.getX();
                // System.out.println(posicionMouseX);
                user.setX(posicionMouseX - 50);
            }
        });
    }

    public ImageView getDisparo(){
            return laser;
        }
        
    /**
     * Disparar laser, permite que el usuario dispare el laser con el
     * clic del mouse.
     *
     * @param juego la ventana de juego
     */
    
    public void dispararLaser(Group juego) {
        juego.setOnMouseClicked(new EventHandler<>() {
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

    /**
     * Set acierto.
     */
    public void setEstadoDisparo(boolean Valor){

        disparoAcertado = Valor;
    }

    /**
     * Animacion laser, para que el laser se mueva en el
     * eje y hasta que llege al final o colisione.
     */
    public void animacionLaser(){
        animacionLaser = new Task<>() {
            @Override
            public Void call() {
                while (!pararAnimacion) {
                    try {
                        Thread.sleep(150);
                        if (laser.getY() > 75 && !disparoAcertado && laser.isVisible()) {
                            laser.setY(laser.getY() - 30);
                        } else {
                            disparoAcertado = false;
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
