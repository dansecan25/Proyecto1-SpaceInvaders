package proyecto1;

/**
 * The type Current class.
 */
public class currentClass {

    private static String claseActual = "";
    private static ListaCircular<NaveEnemiga> listaActual = new ListaCircular<>();
    /**
     * Set class.
     *
     * @param claseActual the clase actual
     * @param l           the l
     */
    public static void setClass(String claseActual, ListaCircular<NaveEnemiga> l){
        currentClass.claseActual = claseActual;
        listaActual = l;
    }
    /**
     * Get lista lista circular.
     *
     * @return the lista circular
     */
    public static ListaCircular<NaveEnemiga> getLista(){
        return listaActual;
    }
    public static String getClase(){
        return claseActual;
    }
    public static void reordenar(){
        int i = (listaActual.tamanoLista()-1);
        while(i!=0){
            NaveEnemiga data = listaActual.obtenerDato(i);
            data.setPosicionLis(i);
            i-=1;
        }
    }
}