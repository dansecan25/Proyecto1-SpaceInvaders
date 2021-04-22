package proyecto1.Animaciones;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.Hileras.HileraE;
import proyecto1.ListasEnlazadas.Lista;

/**
 * The type Animacion clase e.
 */
public class AnimacionClaseE {
    private final HileraE hileraE;
    private Task<Void> animacion;
    private double anguloActual = 0;
    private boolean pararAnimacion = false;

    /**
     * Instantiates a new Animacion clase e.
     *
     * @param hileraE the clase e
     */
    public AnimacionClaseE(HileraE hileraE) {
        this.hileraE = hileraE;
    }

    /**
     * Rotar.
     *
     * @param theta the theta
     */
    public void rotar(double theta){
        Lista<NaveEnemiga> lista = hileraE.getLista();
        int tamlista = lista.tamanoLista();
        int x = hileraE.getX();
        int y = hileraE.getY();
        int centro = tamlista/2;
        System.out.println(centro);
        double raiz2 = Math.sqrt(2);

        for (int indice = 0; indice < tamlista; indice++){
            comprobarAltura();
            int distanciaAlCentro = 80*(centro - indice);
            double rotacionX = distanciaAlCentro * Math.cos(theta);
            double rotacionY = distanciaAlCentro * Math.sin(theta);
            NaveEnemiga nave = lista.obtenerDato(indice); // type casting
            ImageView imagenNave = nave.getImagenNave();
            imagenNave.setX(x + rotacionX);
            imagenNave.setY(y + rotacionY);
            imagenNave.setY(y + 10);
            nave.toNave();
            if (indice == centro) {
                nave.toBoss();
            }
        }
    }
    private void comprobarAltura(){
        Lista<NaveEnemiga> lista = hileraE.getLista();
        NaveEnemiga ultimo = lista.obtenerDato(lista.tamanoLista()-1);
        Timeline comprobar = new Timeline(new KeyFrame(Duration.millis(100),terminar ->{
            if (ultimo.getImagenNave().getY() > 710){
                pararAnimacion = true;
            }
        }));
        comprobar.setCycleCount(Timeline.INDEFINITE);
        comprobar.play();
    }
    /**
     * Iniciar animacion.
     */

    public void iniciarAnimacion(){
        animacion = new Task<>() {
            @Override
            public Void call(){
                if (!pararAnimacion) {
                    try {
                        Thread.sleep(250);
                        anguloActual = anguloActual + Math.PI / 12;
                        if (anguloActual > Math.PI * 2) {
                            anguloActual = anguloActual - Math.PI * 2;
                        }
                        rotar(anguloActual);
                    } catch (InterruptedException e) {
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

