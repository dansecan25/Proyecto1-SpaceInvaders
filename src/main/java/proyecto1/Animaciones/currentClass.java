package proyecto1.Animaciones;

import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.ListasEnlazadas.ListaCircular;
import proyecto1.ListasEnlazadas.simpleLinkedList;

/**
 * The type Current class.
 */
public class currentClass {
    private static String claseActual = "";
    private static ListaCircular<NaveEnemiga> listA = new ListaCircular<>();
    private static simpleLinkedList<NaveEnemiga> listaBasic= new simpleLinkedList<>();
    private static int nivel=1;
    private static int puntaje;
    /**
     * Set class.
     *
     * @param claseActual the clase actual
     * @param listaCirc           the l
     */
    public static void setClass(String claseActual, ListaCircular listaCirc, simpleLinkedList listaS){
        currentClass.claseActual =claseActual;
        if(listaCirc != null){
            listA = listaCirc;
            listaBasic = null;
        }
        if(listaS!=null){
            listA = null;
            listaBasic = listaS;
        }

    }
    /**
     * Get simpleLinkedList.
     *
     * @return the simpleLinkedList listabasic.
     */

    public static simpleLinkedList getListaBasic(){
        if(listaBasic == null){
            return null;
        }else return listaBasic;

    }
    /**
     * Get lista lista circular.
     *
     * @return the lista circular
     */
    public static ListaCircular<NaveEnemiga> getLista(){
        if(listA == null){
            return null;
        }else return listA;

    }

    public static String getClase(){
        return claseActual;
    }
    public static void reordenar(){
        if(listA != null){
            int i = (listA.tamanoLista()-1);
            while(i!=0){

                NaveEnemiga data = listA.obtenerDato(i);
                data.setPosicionLis(i);
                i-=1;
            }
        }else if(listaBasic!=null){
            int i = (listaBasic.getLargo()-1);
            while(i!=0){

                NaveEnemiga datos = listaBasic.get(i);
                datos.setPosicionLis(i);
                i-=1;
            }
        }

    }
    public static void setNivel(int niv){
        nivel = niv;
    }
    public static int getNivel(){
        return nivel;
    }
//    public static void setPuntos(int puntos){
//        puntaje = puntos;
//    }
//    public static int getPuntaje(){
//        return puntaje;
//    }
}