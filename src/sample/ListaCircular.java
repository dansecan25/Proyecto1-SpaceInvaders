package sample;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

class Nodo{
    int dato;
    Nodo next;
    Nodo prev;
    public Nodo(int dato){
        this.dato=dato;
        this.next=null;
        this.prev=null;
    }
    public int get_value(){
        return this.dato;
    }
}

public class ListaCircular {
    private static boolean Fin = false;
    private static int largo=0;

    private Nodo first;
    private Nodo last;
    public ListaCircular(){
        this.first=null;
        this.last=null;
    }
    //E: un valor entero
    public void addFirst(int valor){
        if (this.first==null){
            this.first = new Nodo(valor);
            this.last = this.first;
            this.first.next = this.last;
            this.last.prev = this.first;
            largo+=1;

        }else {
            Nodo current= new Nodo(valor);
            current.next=this.first;
            this.first.prev=current;
            this.first=current;
            this.last.next=this.first;
            this.first.prev= this.last;
            largo+=1;
        }
    }
    //E: un valor entero
    public void addLast(int dato) {
        if (this.first == null) {
            this.first = new Nodo(dato);
            this.last = this.first;
            this.first.next = this.last;
            this.last.prev = this.first;
            largo+=1;
        }else{
            Nodo current = this.first;
            while(current.next != this.first){
                current= current.next;
            }
            Nodo tmp=this.last;
            Nodo ant = tmp;
            tmp.next= new Nodo(dato);
            tmp=tmp.next;
            tmp.prev=ant;
            this.last=tmp;
            this.last.next=this.first;
            largo+=1;
        }
    }
    public void leer(){
        Nodo current = this.first;
        if(this.first==null){
            System.out.println("Vacia");
        }
        int i=0;
        while (i != largo){
            System.out.println(current.get_value());
            current=current.next;
            i+=1;
        }
    }
    public int obtenerDato(int posicion) {
        Nodo current = this.first;
        if (this.first == null) {
            return 0;
        }
        int i = 0;
        int res = 0;
        while (i != largo) {
            if ((i + 1) == posicion) {
                res = current.get_value();
                break;
            } else {
                current = current.next;
                i += 1;
            }
        }
        return res;
    }
    public void eraseFirst(){
        if(this.first == null){
        }else{
            Nodo temp = this.first;
            this.first=temp.next;
            this.first.prev=this.last;
            temp.next = null;
            temp.prev=null;
            this.last.next=this.first;
            largo-=1;
        }

    }
    public void eraseLast(){
        if(this.first==null){
            return;
        }else{
            Nodo temp=this.last;
            this.last=temp.prev;
            this.last.next=this.first;
            temp.next=null;
            temp.prev=null;
            this.first.prev=this.last;
            largo-=1;
        }
    }
    public void erasePos(int posicion){
        int i =0;
        Nodo actual = this.first;
        if(posicion>=0) {
            if (posicion < largo) {
                while (i < largo) {
                    if (posicion == i) {
                        Nodo siguiente = actual.next;
                        Nodo anterior = actual.prev;
                        siguiente.prev = anterior;
                        anterior.next = siguiente;
                        actual.prev = null;
                        actual.next = null;
                        largo -= 1;
                        break;
                    } else {
                        actual = actual.next;
                        i+=1;
                    }
                }
            }
        }
    }
    public void replacePos(int posicion, int nuevoValor) {
        Nodo current = this.first;
        int i = 0;
        while (i < largo) {
            if (i == posicion) {
                Nodo sig = current.next;
                Nodo ant = current.prev;
                ant.next = new Nodo(nuevoValor);
                Nodo nuevo = ant.next;
                nuevo.prev = ant;
                nuevo.next = sig;
                current.next = null;
                current.prev = null;
                break;
            } else {
                current = current.next;
                i += 1;
            }
        }
    }
    public static void set_pos(float x){
        int len= largo;
        if (x>largo){
            float res;
            res = x/largo;

        }
    }
    public void setFin(boolean x){
        Fin=x;
    }
    public static boolean set_recurr() {
        return Fin;
    }
    public void inicio(){
        new ListaCircular.animar(0).start();
    }

    private static class animar extends Service<String> {
        private static final int SLEEP_TIME = 2000;
        private animar(int pos){
            setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    int res=pos+1;
                    if (!set_recurr()) {

                        new ListaCircular.animar2(res).start();
                    }else{
                        set_pos(res);
                    }
                }
            });
        }
        @Override
        protected Task<String> createTask(){
            return new Task<String>() {
                @Override
                protected String call() throws Exception {
                    Thread.sleep(SLEEP_TIME);
                    return null;
                }
            };
        }
    }
    private static class animar2 extends Service<String> {
        private static final int SLEEP_TIME = 2000;
        private animar2(int pos){
            setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    int res=pos+1;
                    if (!set_recurr()) {
                        new ListaCircular.animar(res).start();
                    }else{
                        set_pos(res);
                    }
                }
            });
        }
        @Override
        protected Task<String> createTask(){
            return new Task<String>() {
                @Override
                protected String call() throws Exception {
                    Thread.sleep(SLEEP_TIME);
                    return null;
                }
            };
        }
    }
}
