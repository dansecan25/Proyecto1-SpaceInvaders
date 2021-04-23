package proyecto1.Hileras;

import javafx.scene.Group;
import proyecto1.Animaciones.currentClass;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.Excepciones.IndiceInvalidoException;
import proyecto1.ListasEnlazadas.ListFactory;
import proyecto1.ListasEnlazadas.Lista;

import java.io.FileNotFoundException;

/**
 * The type Clase c.
 */
public class HileraC implements Hilera{
    private static final ListFactory<NaveEnemiga> listFactory = new ListFactory<>();
    private final Lista<NaveEnemiga> listaNaves;
    private int x;
    private int y;
    /**
     * Iniciar clase c.
     *
     * @param juego the juego
     */
    public HileraC(Group juego) throws FileNotFoundException, IndiceInvalidoException {
        listaNaves = listFactory.crearLista("Circular");
        listaNaves.agregarUltimo(new NaveEnemiga(110, 100, juego, 0));
        listaNaves.agregarUltimo(new NaveEnemiga(220, 100, juego, 1));
        listaNaves.agregarUltimo(new NaveEnemiga(330, 100, juego, 2));
        listaNaves.agregarUltimo(new NaveEnemiga(440, 100, juego, 3));
        listaNaves.agregarUltimo(new NaveEnemiga(550, 100, juego, 4));

        NaveEnemiga naveBoss = listaNaves.obtenerDato(2);
        naveBoss.toBoss();

        currentClass.setClass("C", listaNaves);
    }
    public static void cambiarJefe() throws IndiceInvalidoException {
        Lista<NaveEnemiga> lista = listFactory.crearLista("Circular");
        lista = currentClass.getLista();

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
    public Lista<NaveEnemiga> getLista(){
        return listaNaves;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void movimientoLateral(char Dir){
        if (Dir == 'D'){
            this.x += 1;
        }else{
            this.x -= 1;
        }
    }
    public void bajarHilera(){
        this.y += 1;
    }
}
