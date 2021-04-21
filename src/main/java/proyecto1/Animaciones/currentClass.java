package proyecto1.Animaciones;

import proyecto1.Enemigos.NaveEnemiga;
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
    public static void setClass(String claseActual, Lista<NaveEnemiga> lista) {
        currentClass.claseActual = claseActual;
        switch (claseActual){
            case "A":
                listaActual = listFactory.crearLista("Simple");
                break;
            case "B":
                listaActual = listFactory.crearLista("Doble");
                break;
            case "C":
            case "D":
                listaActual = listFactory.crearLista("Circular");
                break;
            case "E":
                
        }
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
    public static void reordenar(){
        if(listaActual != null){
            int i = (listaActual.tamanoLista()-1);
            while(i!=0){

                NaveEnemiga data = (NaveEnemiga) listaActual.obtenerDato(i);
                data.setPosicionLista(i);
                i-=1;
            }
        }
    }
    public static void setNivel(int niv){
        nivel = niv;
    }
    public int getNivel(){
        return nivel;
    }
}