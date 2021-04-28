package proyecto1.Animaciones;

import javafx.concurrent.Task;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.Excepciones.InvalidDirectionException;
import proyecto1.ListasEnlazadas.Lista;
import proyecto1.Ventanas.VentanaDeJuego;

/**
 * Clase Animación para el movimiento de las hileras de naves enemigas.
 */
public class Animacion {
    private static Task<Void> animacion;

    /**
     * Inicia el hilo secundario que controla en el que se maneja el movimiento de las naves
     * @param naves Lista que contiene las naves
     */
    public static void iniciarAnimacion(Lista<NaveEnemiga> naves){
        animacion = new Task<>() {
            @Override
            public Void call() {
                if (naves.obtenerDato(0).getImagenNave().getY() < 710) {
                    try {
                        moverNaves('D', naves);
                        Thread.sleep(2000);
                        moverNaves('A', naves);
                        Thread.sleep(2000);
                        moverNaves('I', naves);
                        Thread.sleep(2000);
                        moverNaves('A', naves);
                        Thread.sleep(2000);
                    } catch (InvalidDirectionException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                } else{
//                    VentanaDeJuego.terminarJuego('L');
//                }
                return null;
            }
        };
        animacion.setOnSucceeded(event -> {
            if (animacion.isDone()){
                iniciarAnimacion(naves);
            }
        });
        new Thread(animacion).start();
    }

    /**
     * Método para mover una hilera de naves al mismo tiempo
     * @param Dir Dirección en la que se moverán las naves
     * @param listaNaves Lista que contiene las naves enemigas
     * @throws InvalidDirectionException Excepción que indica que la dirección ingresada es inválida
     */
    private static void moverNaves(char Dir,Lista<NaveEnemiga> listaNaves) throws InvalidDirectionException {
        for (int i = listaNaves.tamanoLista()-1; i >= 0; i--){
            NaveEnemiga nave = listaNaves.obtenerDato(i);
            switch (Dir){
                case 'D' -> nave.moveRight();
                case 'I' -> nave.moveLeft();
                case 'A' -> nave.moveDown();
                default -> throw new InvalidDirectionException("La dirección " + String.valueOf(Dir) + " no es válida para realizar un movimiento.");
            };
        }
    }
}