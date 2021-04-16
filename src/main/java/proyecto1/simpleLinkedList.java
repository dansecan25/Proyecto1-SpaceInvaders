package proyecto1;

class NodoLL<T> {

    //Atributos clase Nodo

    private T valor;
    private NodoLL<T> siguiente;
    private int posicion;

    //Constructor clase Nodo 1
    public NodoLL(){

        this.valor= null;
        this.siguiente= null;
        this.posicion= 0;

    }
    //Getter del atributo valor
    public T getDato(){
        return valor;
    }

    //Setter del atributo valor
    public void setDato(T valor){
        this.valor= valor;
    }

    //Getter del atributo siguiente.
    public NodoLL<T> getSiguiente(){
        return siguiente;
    }

    //Setter del atributo siguiente
    public void setSiguiente(NodoLL<T> nodo){
        this.siguiente= siguiente;
    }

    //Getter de la posición del nodo.
    public int getPosicion(){

        return posicion;
    }

    //Setter de la posición del nodo
    public void setPosicion(int position){

        this.posicion=position;
    }

}
//Declaración de la lista simple
public class simpleLinkedList<T>{

    //Atributos de la clase simpleLinkedList
    private NodoLL<T> primero;
    private int largo;

    //Declaratoria del constructor de simpleLinkedList
    public simpleLinkedList() {

        primero= null;
        largo=0;
    }

    //verificar si la lista está vacía. @return True or False
    public boolean estaVacia(){

        return primero==null;

    }

    //Obtener el largo de la lista
    public int getLargo(){

        return largo;
    }

    //Insertar nuevo dato al frente de la lista
    public void addFrente(T dato){

        NodoLL<T> nuevoNodo= new NodoLL<>();
        nuevoNodo.setDato(dato);

        if (estaVacia()){

            primero= nuevoNodo;
            primero.setPosicion(0);

        }
        else {

            nuevoNodo.setPosicion(0);
            nuevoNodo.setSiguiente(primero);
            primero = nuevoNodo;

        }
        NodoLL<T> aux= primero.getSiguiente();
        while (aux!=null) {

            aux.setPosicion(aux.getPosicion());
            aux= aux.getSiguiente();

        }
        largo++;

    }
    //Borrar el dato al frente de la lista
    public void deleteFrente(){

        if (estaVacia()){

            primero=null;

        }
        else {

            primero= primero.getSiguiente();
            NodoLL<T> aux= primero;

            while(aux!= null){

                aux.setPosicion(aux.getPosicion()-1);
                aux=aux.getSiguiente();

            }
        }
        largo--;
    }

    //Insertar dato al final de la lista
    public void addUltimo(T dato){

        NodoLL<T> newNodo = new NodoLL<>();
        newNodo.setDato(dato);

        if(estaVacia()){

            primero= newNodo;
            primero.setPosicion(0);

        }
        else {
            NodoLL<T> aux = new NodoLL<>();
            aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(newNodo);
            aux.getSiguiente().setPosicion(largo);
        }
        largo++;
    }
    //Borrar dato al final de la lista
    public void deleteUltimo(){
        NodoLL<T> aux= new NodoLL<>();
        aux= primero;
        if(estaVacia() || largo ==1){
            primero=null;
        }
        else{
            while(aux.getSiguiente().getSiguiente()!=null){
                aux=aux.getSiguiente();
            }
            aux.setSiguiente(null);
        }
        largo--;
    }
    //Obtener valor especifico del índice
    public T get(int i){
        if (i >= largo){
            try {
                throw new Exception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        NodoLL<T> aux= primero;
        while (aux != primero ){
            if(aux.getPosicion() == i){
                return aux.getDato();
            }
            aux= aux.getSiguiente();
        }
        return null;
    }
    //Borrar elemento específico contenido en el indice
    public void deleteElemento(T t){
        NodoLL<T> aux= new NodoLL<>();
        aux= primero;
        if (estaVacia()){
            primero=null;
        }
        else if (primero.getDato()==t){
            deleteFrente();
        }
        else{
            while (aux.getSiguiente()!=null){
                if(aux.getSiguiente().getDato()==t){
                    NodoLL<T> auxSegundo= new NodoLL<T>();
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                    auxSegundo= aux.getSiguiente();
                    while (auxSegundo!=null){
                        auxSegundo.setPosicion(auxSegundo.getPosicion()-1);
                    }
                }
                else{
                    aux=aux.getSiguiente();
                }
            }
        }largo--;
    }
    //Retornar lista
    public void getLista(){

        NodoLL<T> aux= primero;

        while(aux!=null){
            System.out.println(aux.getDato().toString());
            aux= aux.getSiguiente();

        }
    }

    //Retornar el primero elemento de la lista
    public NodoLL<T> getPrimero(){
        return primero;
    }

    //Retornar último elemento de la lista
    public NodoLL<T> getUltimo(){

        NodoLL<T> aux= primero;

        while(aux.getSiguiente()!=null){

            aux= aux.getSiguiente();
        }

        return aux;
    }

    //Saber si cierto elemento está contenido en la lista
    public boolean contains(T t){

        NodoLL<T> aux = primero;
        boolean estaContenido= false;

        while (aux!= null){

            if(aux.getDato().equals(t)){

                estaContenido= true;

            }aux= aux.getSiguiente();
        }
        return estaContenido;

    }
}