package proyecto1.Hileras;

import javafx.scene.Group;
import proyecto1.ListasEnlazadas.ListaCircular;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.Animaciones.currentClass;

import java.io.FileNotFoundException;

public class HileraB {

    public static void IniciarClaseB(Group juego) throws FileNotFoundException {
        ListaCircular<NaveEnemiga> listaB = new ListaCircular<>();
        currentClass.setClass("B", listaB);
        listaB.agregarUltimo(new NaveEnemiga(110, 100, juego,0));
        listaB.agregarUltimo(new NaveEnemiga(220, 100, juego,1));
        listaB.agregarUltimo(new NaveEnemiga(330, 100, juego,2));
        listaB.agregarUltimo(new NaveEnemiga(440, 100, juego,3));
        listaB.agregarUltimo(new NaveEnemiga(550, 100, juego,4));
        NaveEnemiga naveBoss = listaB.obtenerDato(2);
        naveBoss.toBoss();
    }
}
