package proyecto1.Animaciones;

import javafx.concurrent.Task;
import javafx.scene.image.ImageView;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.Excepciones.IndiceInvalidoException;
import proyecto1.Hileras.HileraE;
import proyecto1.ListasEnlazadas.Lista;
import proyecto1.Ventanas.VentanaDeJuego;

import java.io.FileNotFoundException;

/**
 * Animación especial para la hilera tipo E.
 */
public class AnimacionClaseE {
    private final HileraE hileraE;
    private Task<Void> animacion;
    private double anguloActual = 0;
    private boolean pararAnimacion = false;

    /**
     * Constructor para instancias de AnimacionClaseE.
     * @param hileraE the clase e
     */
    public AnimacionClaseE(HileraE hileraE) {
        this.hileraE = hileraE;
    }

    /**
     * Método para hacer rotar la hilera de naves.
     * @param theta Angulo.
     */
    public void rotar(double theta) throws IndiceInvalidoException, FileNotFoundException {
        Lista<NaveEnemiga> lista = hileraE.getLista();
        int tamlista = lista.tamanoLista();
        int x = hileraE.getX();
        int y = hileraE.getY();
        int centro = tamlista/2;
        System.out.println("Centro " + centro);
        double raiz2 = Math.sqrt(2);

        for (int indice = 0; indice < tamlista; indice++){
            comprobarAltura();
            int distanciaAlCentro = 85*(centro - indice);
            double rotacionX = distanciaAlCentro * Math.cos(theta);
            double rotacionY = distanciaAlCentro * Math.sin(theta);
            NaveEnemiga nave = lista.obtenerDato(indice); // type casting
            ImageView imagenNave = nave.getImagenNave();
            imagenNave.setX(x + rotacionX);
            imagenNave.setY(y + rotacionY);
            if (indice == centro && !nave.esBoss()) {
                nave.toBoss();
            }
        }
    }

    /**
     * Método que comprueba la altura de la hilera
     * @throws FileNotFoundException Archivo no encontrado
     */
    private void comprobarAltura() throws FileNotFoundException {
        if (hileraE.getY() > 710){
            pararAnimacion = true;
            VentanaDeJuego.terminarJuego('L');
        }
    }
    /**
     * Método para iniciar la animacion.
     */
    public void iniciarAnimacion() {
        animacion = new Task<>() {
            @Override
            public Void call(){
                if (!pararAnimacion) {
                    try {
                        anguloActual = anguloActual + Math.PI / 12;
                        if (anguloActual > Math.PI * 2) {
                            anguloActual = anguloActual - Math.PI * 2;
                        }
                        rotar(anguloActual);
                        hileraE.bajarHilera();
                        Thread.sleep(50);
                    }catch (InterruptedException | IndiceInvalidoException | FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
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
}

