package proyecto1.ListasEnlazadas;

import proyecto1.Excepciones.IndiceInvalidoException;

import java.io.Serializable;

//Declaracion lista doble
public class doubleLinkedList<T> implements Serializable,Lista<T>{

    //Atributos de la clase doubleLinkedList
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int largo;
    //Constructor lista doble
    public doubleLinkedList(){

        this.primero = null;
        this.ultimo = null;
        largo=0;
    }

    //Obtener largo de la lista Doble
    public int tamanoLista(){
        return largo;
    }

    //Agregar un nodo a la cabeza
    public void agregarPrimero(T dato) {
        if (this.primero == null) {
            this.primero = new Nodo<>();
            this.ultimo = this.primero;
        } else {
            Nodo<T> actual = new Nodo<>();
            actual.siguiente = this.primero;
            this.primero.anterior = actual;
            this.primero = actual;
        }
        largo++;
    }


    //Agregar un nodo a la cola
    public void agregarUltimo(T dato) {
        if (this.primero == null) {
            this.primero = new Nodo<>();
            this.ultimo = this.primero;
        } else {
            Nodo<T> actual = this.primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            Nodo<T> temporal = this.ultimo;
            Nodo<T> anterior = temporal;
            temporal.siguiente = new Nodo<>();
            temporal = temporal.siguiente;
            temporal.anterior = anterior;
            this.ultimo = temporal;
        }
        largo++;
    }

    //Borrar primero
    public void deletePrimero() {
        if (this.primero == null) {
            return;
        } else {
            Nodo<T> temporal = this.primero;
            this.primero = temporal.siguiente;
            this.primero.anterior = null;
            temporal.siguiente = null;
        }
        largo--;
    }

    //Borrar ultimo
    public void deleteUltimo() {
        if (this.primero == null) {
            return;
        } else {
            Nodo<T> temporal = this.ultimo;
            this.primero = temporal.anterior;
            this.ultimo.siguiente = null;
        }
        largo--;
    }

    public T obtenerDato(int posicion) throws IndiceInvalidoException {
        throw new IndiceInvalidoException("holi");
    }

    //Borrar dato en indice específico
    public void borrarDato(T t) {
        if (this.primero == null) {
            return;
        }
        Nodo<T> nodo = this.primero;
        if (nodo.getDato() == t) {
            this.primero = this.primero.siguiente;
        } else {
            boolean estaContenido = false;
            Nodo<T> temporal = this.primero;
            while (temporal.siguiente != null) {
                if (temporal.siguiente.getDato() == t) {
                    estaContenido = true;
                    Nodo<T> ante = temporal.siguiente.siguiente;
                    temporal.siguiente = temporal.siguiente.siguiente;
                    ante.anterior = ante.anterior.anterior;
                    break;
                } else {
                    temporal = temporal.siguiente;
                }
            }
        }largo--;
    }

    public void bubbleSort(){
        System.out.println("Bubble sort innecesario");
    }
}