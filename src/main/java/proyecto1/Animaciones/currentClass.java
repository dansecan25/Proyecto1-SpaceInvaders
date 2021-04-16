package proyecto1.Animaciones;

import proyecto1.ListasEnlazadas.ListaCircular;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.ListasEnlazadas.simpleLinkedList;

/**
 * The type Current class.
 */
public class currentClass {
    private static String clas = "";

    private static ListaCircular<NaveEnemiga> listA = new ListaCircular<>();
    private static simpleLinkedList<NaveEnemiga> listaBasic= new simpleLinkedList<>();

    /**
     * Current class actual string.
     *
     * @return the string
     */
    public static String currentClassActual(){
        String clase = clas;
        return clase;
    }
    /**
     * Set class.
     *
     * @param claseActual the clase actual
     * @param b           the listaBasic
     */
        public static void setClass2(String claseActual, simpleLinkedList b){
        clas=claseActual;
        listaBasic=b;

    }
    /**
     * Set class.
     *
     * @param claseActual the clase actual
     * @param l           the l
     */
    public static void setClass(String claseActual, ListaCircular l){
        clas=claseActual;
        listA = l;
    }
    /**
     * Get simpleLinkedList.
     *
     * @return the simpleLinkedList listabasic.
     */

    public static simpleLinkedList getListaBasic(){
        return listaBasic;

    }
    /**
     * Get lista lista circular.
     *
     * @return the lista circular
     */
    public static ListaCircular getLista(){
        return listA;
    }

    public static String getClase(){
        return clas;
    }
    public static void reordenar(){
        int i = (listA.tamanoLista()-1);
        while(i!=0){

            NaveEnemiga data = listA.obtenerDato(i);
            data.setPosicionLis(i);
            i-=1;


        }
    }

}
