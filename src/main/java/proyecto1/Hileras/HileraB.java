package proyecto1.Hileras;

import javafx.concurrent.Task;
import javafx.scene.Group;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.ListasEnlazadas.ListaCircular;
import proyecto1.Animaciones.currentClass;

import java.io.FileNotFoundException;

public class HileraB {
    private static Task<Void> navesAleatorio;
    private static ListaCircular<NaveEnemiga> listaB = new ListaCircular<>();
    private static NaveEnemiga naveAnt = null;
    public static void IniciarClaseB(Group juego) throws FileNotFoundException {

        currentClass.setClass("B", listaB, null);
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
            if(currentClass.getListaCirular().tamanoLista()>0){
                if(naveAnt != null){
                    naveAnt.toNave();
                }
                double getRandom = Math.random()*(currentClass.getListaCirular().tamanoLista()-1);
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
