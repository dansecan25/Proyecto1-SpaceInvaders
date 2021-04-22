package proyecto1.ListasEnlazadas;

import java.io.Serializable;

/**
 * The type Lista circular.
 *
 * @param <T> the type parameter
 */
public class ListaCircular<T> implements Serializable,Lista<T> {
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
            primero = new Nodo<>(dato);
            primero.siguiente = primero;
            primero.anterior = primero;
        } else {
            Nodo<T> ultimo = primero.anterior;
            Nodo<T> nuevo= new Nodo<>(dato);
            nuevo.siguiente = primero;
            nuevo.anterior = ultimo;
            primero.anterior = nuevo;
            ultimo.siguiente = nuevo;
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
            Nodo<T> nuevo = new Nodo<>(dato);
            Nodo<T> ultimo = primero.anterior;
            nuevo.siguiente = primero;
            nuevo.anterior = ultimo;
            primero.anterior = nuevo;
            ultimo.siguiente = nuevo;
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
                System.out.print(actual.getDato() + ", ");
                actual = actual.siguiente;
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
            Nodo<T> ultimo = primero.anterior;
            int tamano = 0;

            do { // se ejecuta al menos una vez
                tamano++;
                actual = actual.siguiente;
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
                return actual.getDato();
            }
            indice++;
            actual = actual.siguiente;
        } while (actual != primero);
        return null; // la posicion sobrepasa el indice
    }

    /**
     * Borrar primero.
     */
    public void borrarPrimero() {
        if (primero != null) {
            if (primero.siguiente == primero){
                primero = null;
            } else {
                Nodo<T> temp = primero;
                Nodo<T> ultimo = temp.anterior;
                primero = temp.siguiente;
                primero.anterior = temp.anterior;
                ultimo.siguiente = primero;
                temp.siguiente = null;
                temp.anterior = null;
            }
        }
    }

    /**
     * Borrar ultimo.
     */
    public void borrarUltimo() {
        if (primero != null) {
            if (primero.siguiente == primero){
                primero = null;
            } else {
                Nodo<T> temp = primero.anterior;
                Nodo<T> ultimo = temp.anterior;
                ultimo.siguiente = primero;
                primero.anterior = ultimo;
                temp.anterior = null;
                temp.siguiente = null;
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
                if ( (T) actual.getDato() == elemento){
                    return  indice;
                }
                indice++;
                actual = actual.siguiente;
            } while (actual != primero);
        }
        return -1;
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
                        Nodo<T> nodoPrev = actual.anterior;
                        Nodo<T> nodoSig = actual.siguiente;
                        nodoPrev.siguiente = nodoSig;
                        nodoSig.anterior = nodoPrev;
                        actual.anterior = null;
                        actual.siguiente = null;
                        break;
                    }
                    indice++;
                    actual = actual.siguiente;
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
                actual.setDato(nuevoDato);
                break;
            }
            indice++;
            actual = actual.siguiente;
        } while (actual != primero);
    }
}

