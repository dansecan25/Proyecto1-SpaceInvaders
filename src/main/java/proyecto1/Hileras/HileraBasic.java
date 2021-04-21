package proyecto1.Hileras;

import javafx.scene.Group;
import proyecto1.Animaciones.currentClass;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.ListasEnlazadas.ListFactory;
import proyecto1.ListasEnlazadas.Lista;
import java.io.FileNotFoundException;

/**
 * La clase Básica solo tiene una hilera de minions uniformes.
 */
public class HileraBasic {
    private static final ListFactory<NaveEnemiga> listFactory = new ListFactory<>();
    /**
     * Instancia Case Basica
     * @param juego la ventana de juego
     * @throws FileNotFoundException  file not found exception
     */
    public HileraBasic(Group juego) throws FileNotFoundException{
        Lista<NaveEnemiga> listaBasic = listFactory.crearLista("Simple");
        currentClass.setClass("Basic", listaBasic);
        listaBasic.agregarUltimo(new NaveEnemiga(110, 100, juego, 0));
        listaBasic.agregarUltimo(new NaveEnemiga(220, 100, juego, 1));
        listaBasic.agregarUltimo(new NaveEnemiga(330, 100, juego, 2));
        listaBasic.agregarUltimo(new NaveEnemiga(440, 100, juego, 3));
        listaBasic.agregarUltimo(new NaveEnemiga(550, 100, juego, 4));
    }
}
