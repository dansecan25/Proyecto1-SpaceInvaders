package proyecto1;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

class Nodo<T extends Comparable<? super T>>{
    Object dato;
    Nodo sig;
    Nodo prev;
    public Nodo(Object dato){
        this.dato=dato;
        this.sig =null;
        this.prev=null;
    }
    public Object getValue(){
        return this.dato;
    }
}

public class ListaCircular {
    // private static boolean Fin = false;
    // private static int largo=0;

    private Nodo primero;
    // private Nodo last;

    public ListaCircular(){
        primero = null;
        // this.last=null;
    }
    //E: un dato entero
    public void agregarPrimero(Object dato){
        if (primero == null){
            primero = new Nodo(dato);
            // this.last = this.primero;
            primero.sig = primero;
            primero.prev = primero;
            // largo+=1;
        } else {
            Nodo ultimo = primero.prev;
            Nodo nuevo= new Nodo(dato);
            nuevo.sig = primero;
            nuevo.prev = ultimo;
            primero.prev = nuevo;
            ultimo.sig = nuevo;
            //this.primero.prev= this.last;
            //largo+=1;
            primero = nuevo;
        }
    }
    //E: un valor entero
    public void agregarUltimo(Object dato) {
        if (primero == null) {
            agregarPrimero(dato);
        }else{
            Nodo nuevo = new Nodo(dato);
            Nodo ultimo = primero.prev;
            nuevo.sig = primero;
            nuevo.prev = ultimo;
            primero.prev = nuevo;
            ultimo.sig = nuevo;
        }
    }
    public void imprimirLista(){
        if (primero == null) {
            System.out.println("Vacia");
        } else {
            Nodo actual = primero;

            do { // se ejecuta al menos una vez
                System.out.print(actual.getValue() + ", ");
                actual = actual.sig;
            } while (actual != primero);
            System.out.println();
        }
    }

    public int tamanoLista() {
        if (primero == null) {
            return 0;
        } else {
            Nodo actual = primero;
            Nodo ultimo = primero.prev;
            int tamano = 0;

            do { // se ejecuta al menos una vez
                tamano++;
                actual = actual.sig;
            } while (actual != primero);
            return tamano;
        }
    }

    public Object obtenerDato(int posicion) {
        if (posicion < 0 || primero == null) {
            return null;
        }

        Nodo actual = primero;
        int indice = 0;

        do {
            if (indice == posicion) {
                return actual.dato;
            }
            indice++;
            actual = actual.sig;
        } while (actual != primero);

        return null; // la posicion sobrepasa el indice
    }

    public void borrarPrimero() {
        if (primero != null) {
            if (primero.sig == primero){
                primero = null;
            } else {
                Nodo temp = primero;
                Nodo ultimo = temp.prev;
                primero = temp.sig;
                primero.prev = temp.prev;
                ultimo.sig = primero;
                temp.sig = null;
                temp.prev = null;
                // this.last.sig = this.primero;
                // largo -= 1;
            }
        }
    }
    public void borrarUltimo() {
        if (primero != null) {
            if (primero.sig == primero){
                primero = null;
            } else {
                Nodo temp = primero.prev;
                Nodo ultimo = temp.prev;
                ultimo.sig = primero;
                primero.prev = ultimo;
                temp.prev = null;
                temp.sig = null;
            }
        }
    }

    public void borrarPosicion(int posicion){
        if (posicion >= 0) {
            if (posicion == 0) {
                borrarPrimero();
            } else {
                Nodo actual = primero;
                int indice = 0;

                do {
                    if (indice == posicion) {
                        Nodo nodoPrev = actual.prev;
                        Nodo nodoSig = actual.sig;
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

    public void reemplazarDato(int posicion, Object nuevoDato) {
        if (posicion < 0 || primero == null) {
            return;
        }

        Nodo actual = primero;
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

//    public int set_pos(float x){
//        int largo = tamanoLista();
//        if (x>largo){
//            float res;
//            res = x/largo;
//            float old = res;
//            int nuevo = (int) res;
//            float resu = res-nuevo;
//            float end = largo*resu;
//            int position = (int) end;
//            return position;
//        }else return 0;
//    }
//    public void setFin(boolean x){
//        Fin=x;
//    }
//    public static boolean set_recurr() {
//        return Fin;
//    }

//    public void inicio(){
//        new ListaCircular.animar(0).start();
//    }
//
//    private static class animar extends Service<String> {
//        private static final int SLEEP_TIME = 2000;
//        private animar(int pos){
//            setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//                @Override
//                public void handle(WorkerStateEvent event) {
//                    int res=pos+1;
//                    if (!set_recurr()) {
//
//                        new ListaCircular.animar2(res).start();
//                    }else{
//                        set_pos(res);
//                    }
//                }
//            });
//        }
//        @Override
//        protected Task<String> createTask(){
//            return new Task<String>() {
//                @Override
//                protected String call() throws Exception {
//                    Thread.sleep(SLEEP_TIME);
//                    return null;
//                }
//            };
//        }
//    }
//    private static class animar2 extends Service<String> {
//        private static final int SLEEP_TIME = 2000;
//        private animar2(int pos){
//            setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//                @Override
//                public void handle(WorkerStateEvent event) {
//                    int res=pos+1;
//                    if (!set_recurr()) {
//                        new ListaCircular.animar(res).start();
//                    }else{
//                        set_pos(res);
//                    }
//                }
//            });
//        }
//        @Override
//        protected Task<String> createTask(){
//            return new Task<String>() {
//                @Override
//                protected String call() throws Exception {
//                    Thread.sleep(SLEEP_TIME);
//                    return null;
//                }
//            };
//        }
//    }

    public static void main(String[] args) {
        // pruebas
        ListaCircular lista = new ListaCircular();
        System.out.println("tam lista: " + lista.tamanoLista() );
        lista.agregarPrimero("1");
        System.out.println("tam lista: " + lista.tamanoLista() );
        lista.imprimirLista();
        lista.agregarUltimo("2");
        lista.imprimirLista();
        lista.agregarPrimero("3");
        lista.imprimirLista();
        lista.agregarUltimo("4");
        lista.imprimirLista();
        lista.borrarPosicion(2); // borrar el 2
        lista.imprimirLista();
        lista.borrarPrimero();
        lista.imprimirLista();
        lista.borrarUltimo();
        lista.imprimirLista();
        lista.reemplazarDato(0,"uno");
        lista.imprimirLista();
        lista.borrarUltimo();
        lista.imprimirLista();

    }


}

