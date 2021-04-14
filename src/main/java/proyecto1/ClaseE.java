package proyecto1;

import javafx.scene.Group;

import java.io.FileNotFoundException;

public class ClaseE {
    private ListaCircular lista = new ListaCircular();
    private int x;
    private int y;
    private int grados = 0;

    public ClaseE(Group juego, int x, int y) throws FileNotFoundException {
        this.x = x;
        this.y = y;
        lista.agregarPrimero(new NaveEnemiga(x-120, y, juego));
        lista.agregarPrimero(new NaveEnemiga(x-60, y, juego));
        lista.agregarPrimero(new NaveEnemiga(x, y, juego));
        lista.agregarPrimero(new NaveEnemiga(x+60, y, juego));
        lista.agregarPrimero(new NaveEnemiga(x+120, y, juego));
    }

    public ListaCircular getLista() {
        return lista;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
