package proyecto1.Hileras;

import javafx.concurrent.Task;
import javafx.scene.Group;
import proyecto1.Animaciones.currentClass;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.ListasEnlazadas.ListFactory;
import proyecto1.ListasEnlazadas.Lista;

import java.io.FileNotFoundException;

public class HileraB {
    private static final ListFactory<NaveEnemiga> listFactory = new ListFactory<>();
    private static Task<Void> navesAleatorio;
    private static Lista<NaveEnemiga> listaB = listFactory.crearLista("Doble");
    private static NaveEnemiga naveAnt = null;
    public HileraB(Group juego) throws FileNotFoundException {

        currentClass.setClass("B", listaB);
        listaB.agregarUltimo(new NaveEnemiga(110, 100, juego,0));
        listaB.agregarUltimo(new NaveEnemiga(220, 100, juego,1));
        listaB.agregarUltimo(new NaveEnemiga(330, 100, juego,2));
        listaB.agregarUltimo(new NaveEnemiga(440, 100, juego,3));
        listaB.agregarUltimo(new NaveEnemiga(550, 100, juego,4));
        cambioaBoss();
    }
    public static void cambioaBoss(){
        navesAleatorio = new Task<Void>() {
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
    }

}
