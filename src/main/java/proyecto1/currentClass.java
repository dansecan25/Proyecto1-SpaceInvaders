package proyecto1;

/**
 * The type Current class.
 */
public class currentClass {
    private static String clas = "";

    private static ListaCircular listA = new ListaCircular<>();

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
     * @param l           the l
     */
    public static void setClass(String claseActual, ListaCircular l){
        clas=claseActual;
        listA = l;
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

}
