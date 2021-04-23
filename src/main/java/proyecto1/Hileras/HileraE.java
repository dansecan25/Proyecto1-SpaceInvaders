package proyecto1.Hileras;

import javafx.scene.Group;
import proyecto1.Animaciones.currentClass;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.ListasEnlazadas.ListFactory;
import proyecto1.ListasEnlazadas.Lista;

import java.io.FileNotFoundException;

/**
 * La clase Clase E. las naves rotan en torno a un boss.
 */

public class HileraE {
    private final ListFactory<NaveEnemiga> listFactory = new ListFactory<>();
    private final Lista<NaveEnemiga> lista = listFactory.crearLista("Circular");
    private final int x;
    private int y;
    private final int grados = 0;

    /**
     * Instancia nueva Clase e.
     *
     * @param juego la ventana de juego
     * @param x     el parametro x
     * @param y     el paramtero y
     * @throws FileNotFoundException  file not found exception
     */
    public HileraE(Group juego, int x, int y) throws FileNotFoundException {
        this.x = x;
        this.y = y;
        currentClass.setClass("E", lista);
        lista.agregarPrimero(new NaveEnemiga(x-120, y, juego,0));
        lista.agregarPrimero(new NaveEnemiga(x-60, y, juego, 1));
        NaveEnemiga boss = new NaveEnemiga(x, y, juego,2);
        boss.toBoss();
        lista.agregarPrimero(boss);
        lista.agregarPrimero(new NaveEnemiga(x+60, y, juego,3));
        lista.agregarPrimero(new NaveEnemiga(x+120, y, juego,4));
    }

    /**
     * Obtiene lista.
     *
     * @return lista
     */
    public Lista<NaveEnemiga> getLista() {
        return lista;
    }

    /**
     * Obtiene x int.
     *
     * @return x
     */
    public int getX(){
        return x;
    }

    /**
     * Obtiene y int.
     *
     * @return y
     */
    public int getY(){
        return y;
    }

    /**
     * Baja la hilera verticalmente.
     */
    public void bajarHilera(){
        this.y += 1;
    }
}
