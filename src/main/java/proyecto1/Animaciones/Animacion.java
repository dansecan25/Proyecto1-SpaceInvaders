package proyecto1.Animaciones;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.util.Duration;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.Excepciones.IndiceInvalidoException;
import proyecto1.Excepciones.InvalidDirectionException;
import proyecto1.Hileras.Hilera;
import proyecto1.ListasEnlazadas.Lista;
import proyecto1.Ventanas.VentanaDeJuego;

import java.io.FileNotFoundException;

/**
 * Clase Animación para el movimiento de las hileras de naves enemigas.
 */
public class Animacion {
    private Task<Void> animacion;
    private final Hilera hileraNaves;

    public Animacion(Hilera hilera){
        hileraNaves = hilera;
    }
    /**
     * Inicia el hilo secundario que controla en el que se maneja el movimiento de las naves
     */
    public void iniciarAnimacion(){
        animacion = new Task<>() {
            @Override
            public Void call() throws FileNotFoundException, IndiceInvalidoException {
                if (hileraNaves.getY() < 710) {
                    try {
                        moverNaves('D',hileraNaves);
                        Thread.sleep(2000);
                        moverNaves('A',hileraNaves);
                        Thread.sleep(2000);
                        moverNaves('I',hileraNaves);
                        Thread.sleep(2000);
                        moverNaves('A',hileraNaves);
                        Thread.sleep(2000);
                    } catch (InvalidDirectionException | InterruptedException e) {
                        e.printStackTrace();
                    }
                } else{
                    VentanaDeJuego.terminarJuego('L');
                }
                return null;
            }
        };
        animacion.setOnSucceeded(event -> {
            if (animacion.isDone()){
                iniciarAnimacion();
            }
        });
        new Thread(animacion).start();
    }

    /**
     * Metodo para mover una hilera
     * @param Dir Direccion del movimiento
     * @param naves Hilera de naves
     * @throws InvalidDirectionException Direccion invalida
     */
    private static void moverNaves(char Dir,Hilera naves) throws InvalidDirectionException, IndiceInvalidoException {

        Timeline movimiento = new Timeline(new KeyFrame(Duration.millis(25), m ->{
            try{
                switch (Dir){
                    case 'D' -> naves.movimientoLateral('D');
                    case 'I' -> naves.movimientoLateral('I');
                    case 'A' -> naves.bajarHilera();
                    default -> throw new InvalidDirectionException("La dirección " + String.valueOf(Dir) + " no es válida para realizar un movimiento.");
                };
            }catch( InvalidDirectionException|IndiceInvalidoException e){
                e.printStackTrace();
            }
        }));
        movimiento.setCycleCount(80);
        if (comprobarLista(naves.getLista())){
            movimiento.play();
        }else {
            throw new IndiceInvalidoException("Lista nula");
        }
    }
    private static boolean comprobarLista(Lista<NaveEnemiga> lista){
        return lista.tamanoLista() != 0;
    }
}