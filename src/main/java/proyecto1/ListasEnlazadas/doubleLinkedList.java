package proyecto1.ListasEnlazadas;

class NodoDLL<T>{

    //Atributos clase nodo
    private T valor;
    NodoDLL<T> siguiente;
    NodoDLL<T> anterior;
    int posicion;

    //Constructor nodo DLL
    public NodoDLL(){
        this.valor=null;
        this.siguiente=null;
        this.anterior=null;
        this.posicion=0;
    }
    //Getter del atributo valor
    public T getDato(){
        return valor;
    }
    //Setter del atributo valor
    public void setDato(T valor){
        this.valor=valor;
    }
    //Getter del atributo siguiente
    public NodoDLL<T> getSiguiente(){
        return siguiente;
    }
    //Setter del atributo siguiente
    public void setSiguiente(NodoDLL<T> nodoDLL){
        this.siguiente=siguiente;
    }
    //Getter de la posicón del nodo.
    public int getPosicion(){
        return posicion;
    }
    //Setter posicion del nodo.
    public void setPosicion(int posicion){
        this.posicion=posicion;
    }
}

//Declaracion lista doble
public class doubleLinkedList<T> {

    //Atributos de la clase doubleLinkedList
    private NodoDLL<T> primero;
    private NodoDLL<T> ultimo;

    public doubleLinkedList(){

        this.primero = null;
        this.ultimo = null;
    }

    //Agregar un nodo a la cabeza
    public void addPrimero(T dato) {
        if (this.primero == null) {
            this.primero = new NodoDLL<T>();
            this.ultimo = this.primero;
        } else {
            NodoDLL<T> actual = new NodoDLL<T>();
            actual.siguiente = this.primero;
            this.primero.anterior = actual;
            this.primero = actual;
        }
    }

    //Agregar un nodo a la cola
    public void addUltimo(T dato) {
        if (this.primero == null) {
            this.primero = new NodoDLL<T>();
            this.ultimo = this.primero;
        } else {
            NodoDLL<T> actual = this.primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            NodoDLL<T> temporal = this.ultimo;
            NodoDLL<T> anterior = temporal;
            temporal.siguiente = new NodoDLL<T>();
            temporal = temporal.siguiente;
            temporal.anterior = anterior;
            this.ultimo = temporal;
        }
    }

    //Borrar primero
    public void deletePrimero() {
        if (this.primero == null) {
            return;
        } else {
            NodoDLL<T> temporal = this.primero;
            this.primero = temporal.siguiente;
            this.primero.anterior = null;
            temporal.siguiente = null;
        }
    }

    //Borrar ultimo
    public void deleteUltimo() {
        if (this.primero == null) {
            return;
        } else {
            NodoDLL<T> temporal = this.ultimo;
            this.primero = temporal.anterior;
            this.ultimo.siguiente = null;
            temporal.siguiente = null;
        }
    }

    //Borrar dato en indice específico
    public void borrarIndice(T t) {
        if (this.primero == null) {
            return;
        }
        NodoDLL<T> nodo = this.primero;
        if (nodo.getDato() == t) {
            this.primero = this.primero.siguiente;
        } else {
            boolean estaContenido = false;
            NodoDLL<T> temporal = this.primero;
            while (temporal.siguiente != null) {
                if (temporal.siguiente.getDato() == t) {
                    estaContenido = true;
                    NodoDLL<T> ante = temporal.siguiente.siguiente;
                    temporal.siguiente = temporal.siguiente.siguiente;
                    ante.anterior = ante.anterior.anterior;
                    break;
                } else {
                    temporal = temporal.siguiente;
                }
            }
        }
    }
}





















