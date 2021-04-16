package proyecto1.Hileras;

import javafx.scene.Group;
import proyecto1.Animaciones.currentClass;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.ListasEnlazadas.ListaCircular;

import java.io.FileNotFoundException;

public class HileraD {
    private final ListaCircular<NaveEnemiga> listaNaves;
    public HileraD(Group juego) throws FileNotFoundException {
        listaNaves = new ListaCircular<>();
        currentClass.setClass("D", listaNaves, null);
        listaNaves.agregarUltimo(new NaveEnemiga(110, 100, juego, 0));
        listaNaves.agregarUltimo(new NaveEnemiga(220, 100, juego, 1));
        listaNaves.agregarUltimo(new NaveEnemiga(330, 100, juego, 2));
        listaNaves.agregarUltimo(new NaveEnemiga(440, 100, juego, 3));
        listaNaves.agregarUltimo(new NaveEnemiga(550, 100, juego, 4));

        listaNaves.obtenerDato(0).toBoss();
        listaNaves.obtenerDato(1).toBoss();
        listaNaves.obtenerDato(2).toBoss();
        listaNaves.obtenerDato(3).toBoss();
        listaNaves.obtenerDato(4).toBoss();

        listaNaves.bubbleSort();
    }
    public ListaCircular<NaveEnemiga> getListaNaves(){
        return listaNaves;
    }
    public static void ordenarNaves(){
        double x;
        ListaCircular<NaveEnemiga> lista = currentClass.getListaCirular();
        assert lista != null;
        lista.bubbleSort();
        for (int i = 0; i < lista.tamanoLista();i++){
            if (lista.obtenerDato(i) != currentClass.getListaCirular().obtenerDato(i)){
                x = currentClass.getListaCircularNaves().obtenerDato(i).getImagenNave().getX();
                lista.obtenerDato(i).setPosicionLista(i);
                lista.obtenerDato(i).getImagenNave().setX(x);
            }
        }
    }
}
