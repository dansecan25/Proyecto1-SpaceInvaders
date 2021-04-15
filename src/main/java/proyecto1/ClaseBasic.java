package proyecto1;


import javafx.scene.Group;
import java.io.FileNotFoundException;

/**
 * La clase Básica solo tiene una hilera de minions uniformes.
 */
public class ClaseBasic {
    /**
     * Instancia Case Basica
     * @param juego la ventana de juego
     * @throws FileNotFoundException  file not found exception
     */
    public ClaseBasic(Group juego) throws FileNotFoundException{
        simpleLinkedList<NaveEnemiga> listaBasic= new simpleLinkedList<NaveEnemiga>();

        currentClass.setClass2("Basic", listaBasic);
        listaBasic.addFrente(new NaveEnemiga(110, 100, juego, 0));
        listaBasic.addFrente(new NaveEnemiga(220, 100, juego, 1));
        listaBasic.addFrente(new NaveEnemiga(330, 100, juego, 2));
        listaBasic.addFrente(new NaveEnemiga(440, 100, juego, 3));
        listaBasic.addFrente(new NaveEnemiga(550, 100, juego, 4));

    }


}
