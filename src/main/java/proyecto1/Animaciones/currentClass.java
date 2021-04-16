package proyecto1.Animaciones;

import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.ListasEnlazadas.ListaCircular;
import proyecto1.ListasEnlazadas.simpleLinkedList;

/**
 * The type Current class.
 */
public class currentClass {
    private static String claseActual = "";
    private static ListaCircular<NaveEnemiga> listCirculo = new ListaCircular<>();
    private static simpleLinkedList<NaveEnemiga> listaBasic= new simpleLinkedList<>();
    private static int nivel=1;
    /**
     * Set class.
     *
     * @param claseActual the clase actual
     * @param listaCirc           the l
     */
    public static void setClass(String claseActual, ListaCircular listaCirc, simpleLinkedList listaS){
        currentClass.claseActual =claseActual;
        if(listaCirc != null){
            listCirculo = listaCirc;
            listaBasic = null;
        }
        if(listaS!=null){
            listCirculo = null;
            listaBasic = listaS;
        }
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
    public static ListaCircular getListaCirular(){
        return listCirculo;
    }
    public static String getClase(){
        return claseActual;
    }
    public static void reordenar(){
        if(listCirculo != null){
            int i = (listCirculo.tamanoLista()-1);
            while(i!=0){

                NaveEnemiga data = listCirculo.obtenerDato(i);
                data.setPosicionLista(i);
                i-=1;
            }
        }else if(listaBasic!=null){
            int i = (listaBasic.getLargo()-1);
            while(i!=0){

                NaveEnemiga datos = listaBasic.get(i);
                datos.setPosicionLista(i);
                i-=1;
            }
        }

    }
    public static ListaCircular<NaveEnemiga> getElista(){
        ListaCircular<NaveEnemiga> lista = listCirculo;
        return lista;
    }
}