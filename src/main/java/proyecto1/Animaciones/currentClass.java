package proyecto1.Animaciones;

import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.ListasEnlazadas.ListaCircular;
import proyecto1.ListasEnlazadas.doubleLinkedList;
import proyecto1.ListasEnlazadas.simpleLinkedList;

import java.io.Serializable;

/**
 * The type Current class.
 */
public class currentClass <T extends Serializable> {
    private static String claseActual = "";
    private static ListaCircular<NaveEnemiga> listCirculo = new ListaCircular<>();
    private static simpleLinkedList<NaveEnemiga> listaBasic= new simpleLinkedList<>();
    private static int nivel=1;
    private static doubleLinkedList<NaveEnemiga> listaDoble = new doubleLinkedList<>();
    /**
     * Set class.
     *
     * @param claseActual the clase actual
     * @param listaCirc           the l
     */
    public static void setClass(String claseActual, ListaCircular listaCirc, simpleLinkedList listaS, doubleLinkedList listaDob ){
        currentClass.claseActual =claseActual;
        listaDoble = listaDob;
        listCirculo = listaCirc;
        listaBasic = listaS;
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
    public static doubleLinkedList getListaDoble(){
        return listaDoble;
    }
    public static String getClase(){
        return claseActual;
    }
    public static void reordenar(){
        if(listCirculo != null){
            int i = (listCirculo.tamanoLista()-1);
            while(i!=0){

                NaveEnemiga data = listCirculo.obtenerDato(i);
                data.setPosicionLis(i);
                i-=1;
            }
        }else if(listaBasic!=null){
            int i = (listaBasic.tamanoLista()-1);
            while(i!=0){

                NaveEnemiga datos = listaBasic.get(i);
                datos.setPosicionLis(i);
                i-=1;
            }
        }

    }
    public static ListaCircular<NaveEnemiga> getElista(){
        ListaCircular<NaveEnemiga> lista = listCirculo;
        return lista;
    }
    public static void setNivel(int niv){
        nivel = niv;
    }
    public static int getNivel(){
        return nivel;
    }
    public static T getLista(){
        if(getListaCirular()!=null){
            return (T)getListaCirular();
        }else if(getListaBasic()!=null){
            return (T)getListaBasic();
        }else return (T) getListaDoble();
    }
}