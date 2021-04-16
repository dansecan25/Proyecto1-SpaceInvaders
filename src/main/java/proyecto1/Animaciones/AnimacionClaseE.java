package proyecto1.Animaciones;

import javafx.scene.image.ImageView;
import javafx.concurrent.Task;
import proyecto1.Hileras.HileraE;
import proyecto1.ListasEnlazadas.ListaCircular;
import proyecto1.Enemigos.NaveEnemiga;

/**
 * The type Animacion clase e.
 */
public class AnimacionClaseE {
    private HileraE hileraE;
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
        ListaCircular lista = hileraE.getLista();
        int tamlista = lista.tamanoLista();
        int x = hileraE.getX();
        int y = hileraE.getY();
        int centro = tamlista/2;
        System.out.println(centro);
        double raiz2 = Math.sqrt(2);

        for (int indice = 0; indice < tamlista; indice++){
            int distanciaAlCentro = 80*(centro - indice);
            double rotacionX = distanciaAlCentro * Math.cos(theta);
            double rotacionY = distanciaAlCentro * Math.sin(theta);
            NaveEnemiga nave = (NaveEnemiga) lista.obtenerDato(indice); // type casting
            ImageView imagenNave = nave.getImagenNave();
            imagenNave.setX(x + rotacionX);
            imagenNave.setY(y + rotacionY);
            nave.toNave();
            if (indice == centro) {
                nave.toBossE();
            }
            //TranslateTransition girar = new TranslateTransition();
            //girar.setToX((x + rotacionX));
            //girar.setToY((y + rotacionY));
            //girar.setNode(imagenNave);
            //girar.setDuration(Duration.millis(50));
            //girar.play();
            //nave.getImagenNave().setX(x + rotacionX);
            //nave.getImagenNave().setY(y + rotacionY);
        }
    }

    /**
     * Iniciar animacion.
     */

    public void iniciarAnimacion(){
        animacion = new Task<Void>() {
            @Override
            public Void call(){
                while (!pararAnimacion) {
                    try {
                        Thread.sleep(250);
                        anguloActual = anguloActual + Math.PI / 12;
                        if (anguloActual > Math.PI * 2) {
                            anguloActual = anguloActual - Math.PI * 2;
                        }
                        rotar(anguloActual);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                return null;
            }
        };
        animacion.setOnSucceeded(event -> {
            if (animacion.isDone()){
                new Thread(animacion).start();
            }
        });
        new Thread(animacion).start();
    }

}

