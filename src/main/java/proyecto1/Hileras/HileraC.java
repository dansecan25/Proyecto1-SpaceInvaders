package proyecto1.Hileras;

import javafx.scene.Group;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.ListasEnlazadas.ListFactory;
import proyecto1.ListasEnlazadas.Lista;
import proyecto1.ListasEnlazadas.ListaCircular;
import proyecto1.Animaciones.currentClass;

import java.io.FileNotFoundException;

/**
 * The type Clase c.
 */
public class HileraC {
    ListFactory<NaveEnemiga> listFactory = new ListFactory<>();
    /**
     * Iniciar clase c.
     *
     * @param juego the juego
     */
    public HileraC(Group juego) throws FileNotFoundException {
        Lista<NaveEnemiga> listaNaves = listFactory.crearLista("Circular");
        currentClass.setClass("C", listaNaves, null, null);
        listaNaves.agregarUltimo(new NaveEnemiga(110, 100, juego, 0));
        listaNaves.agregarUltimo(new NaveEnemiga(220, 100, juego, 1));
        listaNaves.agregarUltimo(new NaveEnemiga(330, 100, juego, 2));
        listaNaves.agregarUltimo(new NaveEnemiga(440, 100, juego, 3));
        listaNaves.agregarUltimo(new NaveEnemiga(550, 100, juego, 4));

        NaveEnemiga naveBoss = listaNaves.obtenerDato(2);
        naveBoss.toBoss();

    }
    public void cambiarJefe(){
        Lista<NaveEnemiga> lista = listFactory.crearLista("Circular");
        lista = (Lista<NaveEnemiga>) currentClass.getLista();

        double pos = Math.random()*lista.tamanoLista();
        int posicion =  (int) pos;
        if (lista.tamanoLista()==1){
            posicion = 0;
        }
        //arreglar naveBoss se vuelve null

        NaveEnemiga naveBoss = lista.obtenerDato(posicion);
        if(naveBoss!=null) {
            naveBoss.toBoss();
            naveBoss.setPosicionLista(posicion);
        }
    }

}
