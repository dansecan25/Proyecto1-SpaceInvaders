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
     * @param claseActual the clase actual
     */
    public static void setClass(String claseActual,Lista<NaveEnemiga> lista) {
        System.out.println("Esto deberia correr primero");
        currentClass.claseActual = claseActual;
        listaActual = lista;
    }

    /**
     * Retorna la lista actual
     * @return listaActual: Lista<NaveEnemiga>
     */
    public static Lista<NaveEnemiga> getLista(){
        return listaActual;
    }

    /**
     * Retorna la clase actual
     * @return claseActual: String
     */
    public static String getClase(){
        return claseActual;
    }

    /**
     * Reordena la lista actual cuando una nave es eliminada
     * @param indice posicion en la lista de la nave eliminada
     * @throws IndiceInvalidoException Indice invalido
     */
    public static void reordenar(int indice) throws IndiceInvalidoException {
            while(indice < listaActual.tamanoLista()-1){
                NaveEnemiga data = listaActual.obtenerDato(indice + 1);
                if (data != null){
                data.setPosicionLista(indice);
                }
                indice++;
            }
        }

    /**
     * Modifica variable nivel
      * @param niv nuevo nivel: int
     */
    public static void setNivel(int niv){
        nivel = niv;
    }

    /**
     * Retorna el nivel actual
     * @return nivel: int
     */
    public int getNivel(){
        return nivel;
    }
}