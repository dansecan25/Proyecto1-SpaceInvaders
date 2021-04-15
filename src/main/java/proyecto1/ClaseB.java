package proyecto1;

import javafx.scene.Group;

import java.io.FileNotFoundException;
import java.util.List;

public class ClaseB {
    static ListaCircular listaB = new ListaCircular();
    public static void IniciarClaseB(Group juego) throws FileNotFoundException {
        currentClass.setClass("B", listaB);
        listaB.agregarUltimo(new NaveEnemiga(110, 100, juego));
        listaB.agregarUltimo(new NaveEnemiga(220, 100, juego));
        listaB.agregarUltimo(new NaveEnemiga(330, 100, juego));
        listaB.agregarUltimo(new NaveEnemiga(440, 100, juego));
        listaB.agregarUltimo(new NaveEnemiga(550, 100, juego));
    }
}
