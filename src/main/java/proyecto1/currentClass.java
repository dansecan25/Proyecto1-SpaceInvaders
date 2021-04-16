package proyecto1;

/**
 * The type Current class.
 */
public class currentClass {
    private static String claseActual = "";
    private static ListaCircular<NaveEnemiga> listA = new ListaCircular<>();
    private static simpleLinkedList<NaveEnemiga> listaBasic= new simpleLinkedList<>();
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
    public static ListaCircular getLista(){
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
}