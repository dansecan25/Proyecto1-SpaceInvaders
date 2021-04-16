package proyecto1.Hileras;


import javafx.scene.Group;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.Animaciones.currentClass;
import proyecto1.ListasEnlazadas.simpleLinkedList;

import java.io.FileNotFoundException;

/**
 * La clase Básica solo tiene una hilera de minions uniformes.
 */
public class HileraBasic {
    /**
     * Instancia Case Basica
     * @param juego la ventana de juego
     * @throws FileNotFoundException  file not found exception
     */
    public HileraBasic(Group juego) throws FileNotFoundException{
        simpleLinkedList<NaveEnemiga> listaBasic= new simpleLinkedList<>();

        currentClass.setClass("Ba", null,listaBasic);
        listaBasic.addUltimo(new NaveEnemiga(110, 100, juego, 0));
        listaBasic.addUltimo(new NaveEnemiga(220, 100, juego, 1));
        listaBasic.addUltimo(new NaveEnemiga(330, 100, juego, 2));
        listaBasic.addUltimo(new NaveEnemiga(440, 100, juego, 3));
        listaBasic.addUltimo(new NaveEnemiga(550, 100, juego, 4));

    }




}
