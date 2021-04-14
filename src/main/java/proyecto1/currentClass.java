package proyecto1;

public class currentClass {
    private static String clas = "";
    private static ListaCircular listA = new ListaCircular<>();
    private static ListaCircular listaNodos = new ListaCircular<>();
    public static String currentClassActual(){
        String clase = clas;
        return clase;
    }
    public static void setClass(String claseActual, ListaCircular l){
        clas=claseActual;
        listA = l;
    }
    public static ListaCircular getLista(){
        return listA;
    }
    public static ListaCircular getListaBoundings(){
        return listaNodos;
    }
}
