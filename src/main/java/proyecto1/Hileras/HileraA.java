package proyecto1.Hileras;

import javafx.scene.Group;
import proyecto1.Animaciones.currentClass;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.Excepciones.IndiceInvalidoException;
import proyecto1.ListasEnlazadas.ListFactory;
import proyecto1.ListasEnlazadas.Lista;
import java.io.FileNotFoundException;
import java.util.Random;


public class HileraA {
    private static final ListFactory<NaveEnemiga> listFactory = new ListFactory<>();
    private final Random random = new Random();
    /**
     * Instancia Clase Hilera A
     * @param juego la ventana de juego
     * @throws FileNotFoundException  file not found exception
     */
    public HileraA(Group juego) throws FileNotFoundException, IndiceInvalidoException {
        Lista<NaveEnemiga> listaA= listFactory.crearLista("Simple");

        currentClass.setClass("A", listaA);
        listaA.agregarUltimo(new NaveEnemiga(110, 100, juego, 0));
        listaA.agregarUltimo(new NaveEnemiga(220, 100, juego, 1));
        listaA.agregarUltimo(new NaveEnemiga(330, 100, juego, 2));
        listaA.agregarUltimo(new NaveEnemiga(440, 100, juego, 3));
        listaA.agregarUltimo(new NaveEnemiga(550, 100, juego, 4));
        int posicionBoss= random.nextInt(4);

        NaveEnemiga naveJefe= listaA.obtenerDato(posicionBoss);
        if (naveJefe != null){
            naveJefe.toBoss();
        }

    }




}
