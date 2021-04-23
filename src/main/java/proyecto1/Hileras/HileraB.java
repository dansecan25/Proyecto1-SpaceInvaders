package proyecto1.Hileras;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.util.Duration;
import proyecto1.Animaciones.Animacion;
import proyecto1.Animaciones.currentClass;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.Excepciones.IndiceInvalidoException;
import proyecto1.ListasEnlazadas.ListFactory;
import proyecto1.ListasEnlazadas.Lista;

import java.io.FileNotFoundException;

public class HileraB {
    private static final ListFactory<NaveEnemiga> listFactory = new ListFactory<>();
    private static final Lista<NaveEnemiga> listaB = listFactory.crearLista("Doble");
    private static NaveEnemiga naveAnt = null;
    public static void IniciarClaseB(Group juego) throws FileNotFoundException {

        listaB.agregarUltimo(new NaveEnemiga(110, 100, juego,0));
        listaB.agregarUltimo(new NaveEnemiga(220, 100, juego,1));
        listaB.agregarUltimo(new NaveEnemiga(330, 100, juego,2));
        listaB.agregarUltimo(new NaveEnemiga(440, 100, juego,3));
        listaB.agregarUltimo(new NaveEnemiga(550, 100, juego,4));
        cambioaBoss();

        currentClass.setClass("B", listaB);
        Animacion.iniciarAnimacion(listaB);
    }
    /*
    public static void cambioaBoss(){
        Task<Void> navesAleatorio = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep(2000);
                return null;
            }
        };
        navesAleatorio.setOnSucceeded(event->{
            if(currentClass.getLista().tamanoLista()>0){
                if(naveAnt != null){
                    naveAnt.toNave();
                }
                double getRandom = Math.random()*(currentClass.getLista().tamanoLista()-1);
                int naveRandom = (int) getRandom;
                NaveEnemiga nave = listaB.obtenerDato(naveRandom);
                nave.toBoss();
                naveAnt = nave;
                cambioaBoss();
            }
        });
        new Thread(navesAleatorio).start();
    }*/
    public static void cambioaBoss(){
        Timeline navesAleatorio = new Timeline(new KeyFrame(Duration.seconds(2),aleatorio ->{
            if(currentClass.getLista().tamanoLista()>0){
                if(naveAnt != null){
                    naveAnt.toNave();
                }
                double getRandom = Math.random()*(currentClass.getLista().tamanoLista()-1);
                int naveRandom = (int) getRandom;
                NaveEnemiga nave = null;
                try {
                    nave = listaB.obtenerDato(naveRandom);
                } catch (IndiceInvalidoException e) {
                    e.printStackTrace();
                }
                if (nave != null){
                    nave.toBoss();
                }
                naveAnt = nave;
                cambioaBoss();
            }
        }));
        navesAleatorio.setCycleCount(Timeline.INDEFINITE);
        navesAleatorio.play();
    }

}
