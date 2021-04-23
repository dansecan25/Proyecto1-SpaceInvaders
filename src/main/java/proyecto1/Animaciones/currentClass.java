package proyecto1.Animaciones;

import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.Excepciones.IndiceInvalidoException;
import proyecto1.ListasEnlazadas.ListFactory;
import proyecto1.ListasEnlazadas.Lista;

/**
 * The type Current class.
 */
public class currentClass {
    private static String claseActual = "";
    private static final ListFactory<NaveEnemiga> listFactory = new ListFactory<>();
    private static Lista<NaveEnemiga> listaActual;
    private static int nivel=1;
    /**
     * Set class.
     *
     * @param claseActual the clase actual
     */
    public static void setClass(String claseActual,Lista<NaveEnemiga> lista) {
        System.out.println("Esto deberia correr primero");
        currentClass.claseActual = claseActual;
        listaActual = lista;
    }
    /**
     * Get simpleLinkedList.
     *
     * @return the simpleLinkedList listabasic.
     */

    public static Lista<NaveEnemiga> getLista(){
        return listaActual;
    }
    public static String getClase(){
        return claseActual;
    }
    public static void reordenar(int indice) throws IndiceInvalidoException {
            while(indice < listaActual.tamanoLista()-1){
                NaveEnemiga data = listaActual.obtenerDato(indice + 1);
                if (data != null){
                data.setPosicionLista(indice);
                }
                indice++;
            }
        }
    public static void setNivel(int niv){
        nivel = niv;
    }
    public int getNivel(){
        return nivel;
    }
}