package proyecto1.ListasEnlazadas;

import java.io.Serializable;

/**
 * Clase Nodo.
 *
 * @param <T> Tipo de dato a contener
 */
class Nodo<T> implements Serializable {
    /**
     * Siguiente Nodo.
     */
    public Nodo<T> siguiente;
    /**
     * Nodo Anterior.
     */
    public Nodo<T> anterior;
    /**
     * Dato contenido en el nodo.
     */
    public T valor;
    /**
     * Posicion del nodo en la lista que lo contiene
     */
    public int posicion;

    /**
     * Crea una instancia de Nodo. No requiere argumentos.
     */
    public Nodo(){
        this.valor = null;
        this.siguiente = null;
        this.anterior = null;
        this.posicion = 0;
    }
    /**
     * Crea una instancia de Nodo. Requiere ingresar el dato.
     *
     * @param dato Valor del nodo
     */
    public Nodo(T dato){
        this.valor = dato;
        this.siguiente = null;
        this.anterior = null;
        this.posicion = 0;
    }

    /**
     * Obtiene el dato contenido en el nodo.
     *
     * @return dato
     */
    public T getDato(){
        return this.valor;
    }
    public void setDato(T valor){this.valor = valor;}
    public Nodo<T> getSiguiente(){return this.siguiente;}
    public void setSiguiente(Nodo<T> nodo){this.siguiente = nodo;}
    public int getPosicion(){return posicion;}
    public void setPosicion(int posicion){this.posicion = posicion;}

}
