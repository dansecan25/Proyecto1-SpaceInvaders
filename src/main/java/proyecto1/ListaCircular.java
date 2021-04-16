package proyecto1;
import java.io.Serializable;

/**
 * The type Nodo.
 *
 * @param <T> the type parameter
 */
class Nodo<T> implements Serializable {
    /**
     * The Sig.
     */
    Nodo<T> sig;
    /**
     * The Prev.
     */
    Nodo<T> prev;
    /**
     * The Dato.
     */
    T dato;

    /**
     * Instantiates a new Nodo.
     *
     * @param dato the dato
     */
    public Nodo(T dato){
        this.dato=dato;
        this.sig =null;
        this.prev=null;
    }

    /**
     * Get value t.
     *
     * @return the t
     */
    public T getValue(){
        return this.dato;
    }
}

/**
 * The type Lista circular.
 *
 * @param <T> the type parameter
 */
public class ListaCircular<T> implements Serializable {
    private Nodo<T> primero;

    /**
     * Instantiates a new Lista circular.
     */
    public ListaCircular(){
        primero = null;
    }

    /**
     * Agregar primero.
     *
     * @param dato the dato
     */
//E: cualquier tipo de dato
    public void agregarPrimero(T dato){
        if (primero == null){
            primero = new Nodo<T>(dato);
            primero.sig = primero;
            primero.prev = primero;
        } else {
            Nodo<T> ultimo = primero.prev;
            Nodo<T> nuevo= new Nodo<T>(dato);
            nuevo.sig = primero;
            nuevo.prev = ultimo;
            primero.prev = nuevo;
            ultimo.sig = nuevo;
            primero = nuevo;
        }
    }

    /**
     * Agregar ultimo.
     *
     * @param dato the dato
     */
//E:cualquier tipo de dato
    public void agregarUltimo(T dato) {
        if (primero == null) {
            agregarPrimero(dato);
        }else{
            Nodo<T> nuevo = new Nodo<T>(dato);
            Nodo<T> ultimo = primero.prev;
            nuevo.sig = primero;
            nuevo.prev = ultimo;
            primero.prev = nuevo;
            ultimo.sig = nuevo;
        }
    }

    /**
     * Imprimir lista.
     */
    public void imprimirLista(){
        if (primero == null) {
            System.out.println("Vacia");
        } else {
            Nodo<T> actual = primero;
            do { // se ejecuta al menos una vez
                System.out.print(actual.getValue() + ", ");
                actual = actual.sig;
            } while (actual != primero);
            System.out.println();
        }
    }

    /**
     * Tamano lista int.
     *
     * @return the int
     */
    public int tamanoLista() {
        if (primero == null) {
            return 0;
        } else {
            Nodo<T> actual = primero;
            Nodo<T> ultimo = primero.prev;
            int tamano = 0;

            do { // se ejecuta al menos una vez
                tamano++;
                actual = actual.sig;
            } while (actual != primero);
            return tamano;
        }
    }

    /**
     * Obtener dato t.
     *
     * @param posicion the posicion
     * @return the t
     */
    public T obtenerDato(int posicion) {
        if (posicion < 0 || primero == null) {
            return null;
        }
        Nodo<T> actual = primero;
        int indice = 0;
        do {
            if (indice == posicion) {
                return actual.getValue();
            }
            indice++;
            actual = actual.sig;
        } while (actual != primero);
        return null; // la posicion sobrepasa el indice
    }

    /**
     * Borrar primero.
     */
    public void borrarPrimero() {
        if (primero != null) {
            if (primero.sig == primero){
                primero = null;
            } else {
                Nodo<T> temp = primero;
                Nodo<T> ultimo = temp.prev;
                primero = temp.sig;
                primero.prev = temp.prev;
                ultimo.sig = primero;
                temp.sig = null;
                temp.prev = null;
            }
        }
    }

    /**
     * Borrar ultimo.
     */
    public void borrarUltimo() {
        if (primero != null) {
            if (primero.sig == primero){
                primero = null;
            } else {
                Nodo<T> temp = primero.prev;
                Nodo<T> ultimo = temp.prev;
                ultimo.sig = primero;
                primero.prev = ultimo;
                temp.prev = null;
                temp.sig = null;
            }
        }
    }

    public int obtenerPosicion (T elemento){
        if (primero == null) {
            return -1;
        } else {
            int indice = 0;
            Nodo<T> actual = primero;
            do { // se ejecuta al menos una vez
                if (actual.dato.equals(elemento)){
                    return  indice;
                }
                indice++;
                actual = actual.sig;
            } while (actual != primero);
            return -1;
        }
    }

    /**
     * Borrar posicion.
     *
     * @param posicion the posicion
     */
    public void borrarPosicion(int posicion){
        if (posicion >= 0) {
            if (posicion == 0) {
                borrarPrimero();
            } else {
                Nodo<T> actual = primero;
                int indice = 0;

                do {
                    if (indice == posicion) {
                        Nodo<T> nodoPrev = actual.prev;
                        Nodo<T> nodoSig = actual.sig;
                        nodoPrev.sig = nodoSig;
                        nodoSig.prev = nodoPrev;
                        actual.prev = null;
                        actual.sig = null;
                        break;
                    }
                    indice++;
                    actual = actual.sig;
                } while (actual != primero);
            }
        }
    }

    public void borrarDato(T dato) {
        int posicion = obtenerPosicion(dato);
        if (posicion >= 0){
            borrarPosicion(posicion);
        }
    }

    /**
     * Reemplazar dato.
     *
     * @param posicion  the posicion
     * @param nuevoDato the nuevo dato
     */
    public void reemplazarDato(int posicion, T nuevoDato) {
        if (posicion < 0 || primero == null) {
            return;
        }
        Nodo<T> actual = primero;
        int indice = 0;
        do {
            if (indice == posicion) {
                actual.dato = nuevoDato;
                break;
            }
            indice++;
            actual = actual.sig;
        } while (actual != primero);
    }
}

