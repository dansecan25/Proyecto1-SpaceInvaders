package proyecto1;

import javafx.scene.Group;
import java.io.FileNotFoundException;

/**
 * La clase Clase E. las naves rotan en torno a un boss.
 */

public class ClaseE {
    private ListaCircular lista = new ListaCircular();
    private int x;
    private int y;
    private int grados = 0;

    /**
     * Instancia nueva Clase e.
     *
     * @param juego la ventana de juego
     * @param x     el parametro x
     * @param y     el paramtero y
     * @throws FileNotFoundException  file not found exception
     */
    public ClaseE(Group juego, int x, int y) throws FileNotFoundException {
        this.x = x;
        this.y = y;
        ListaCircular<NaveEnemiga> lista = new ListaCircular<>();
        currentClass.setClass("E", lista);
        lista.agregarPrimero(new NaveEnemiga(x-120, y, juego,0));
        lista.agregarPrimero(new NaveEnemiga(x-60, y, juego, 1));
        lista.agregarPrimero(new NaveEnemiga(x, y, juego,2));
        lista.agregarPrimero(new NaveEnemiga(x+60, y, juego,3));
        lista.agregarPrimero(new NaveEnemiga(x+120, y, juego,4));
        //NaveEnemiga naveBoss = lista.obtenerDato(2);
        //naveBoss.toBoss();

    }
//    public static void cambiarJefe(){
//        ListaCircular<NaveEnemiga> lista = currentClass.getLista();
//
//        double pos = Math.random()*lista.tamanoLista();
//        int posicion =  (int) pos;
//        if (lista.tamanoLista()==1){
//            posicion = 0;
//        }
//        //arreglar naveBoss se vuelve null
//
//        NaveEnemiga naveBoss = lista.obtenerDato(posicion);
//        if(naveBoss!=null) {
//            naveBoss.toBoss();
//            naveBoss.setPosicionLis(posicion);
//        }
//    }

    /**
     * Obtiene lista.
     *
     * @return lista
     */
    public ListaCircular getLista() {
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
}
