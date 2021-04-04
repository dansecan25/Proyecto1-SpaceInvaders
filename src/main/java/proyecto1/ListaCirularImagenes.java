package proyecto1;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;

class Node{
    ImageView dato;
    Node next;
    Node prev;
    public Node(ImageView dato){
        this.dato=dato;
        this.next=null;
        this.prev=null;
    }
    public ImageView get_value(){ return this.dato;}
}

class ListaCircularImagenes {
    boolean Fin= false;
    public int largo=0;
    int position=0;

    private Node first;
    private Node last;
    public ListaCircularImagenes(){
        this.first=null;
        this.last=null;
    }
    //E: un valor entero
    public void addFirst(ImageView valor){
        if (this.first==null){
            this.first = new Node(valor);
            this.last = this.first;
            this.first.next = this.last;
            this.last.prev = this.first;
            largo+=1;

        }else {
            Node current= new Node(valor);
            current.next=this.first;
            this.first.prev=current;
            this.first=current;
            this.last.next=this.first;
            this.first.prev= this.last;
            largo+=1;
        }
    }
    //E: un valor entero
    public void addLast(ImageView dato) {
        if (this.first == null) {
            this.first = new Node(dato);
            this.last = this.first;
            this.first.next = this.last;
            this.last.prev = this.first;
            largo+=1;
        }else{
            Node current = this.first;
            while(current.next != this.first){
                current= current.next;
            }
            Node tmp=this.last;
            Node ant = tmp;
            tmp.next= new Node(dato);
            tmp=tmp.next;
            tmp.prev=ant;
            this.last=tmp;
            this.last.next=this.first;
            largo+=1;
        }
    }
    public void leer(){
        Node current = this.first;
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
    public ImageView obtenerDato(double posicion) {
        Node current = this.first;
        if (this.first == null) {
            return null;
        }
        int i = 0;
        ImageView res = null;
        while (i != largo) {
            if (i == posicion) {
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
            Node temp = this.first;
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
            Node temp=this.last;
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
        Node actual = this.first;
        if(posicion>=0) {
            if (posicion < largo) {
                while (i < largo) {
                    if (posicion == i) {
                        Node siguiente = actual.next;
                        Node anterior = actual.prev;
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
    public void replacePos(double posicion, ImageView nuevoValor) {
        Node current = this.first;
        int i = 0;
        while (i < largo) {
            if (i == posicion) {
                Node sig = current.next;
                Node ant = current.prev;
                ant.next = new Node(nuevoValor);
                Node nuevo = ant.next;
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
    public void setFin(boolean x){
        Fin=x;
    }
    public void setPosicion(int pos){
        position = pos;
    }
    public ImageView nuevoJefe(){
        int res;
        Thread posicion = new Thread(()->{
            int i=0;
            while(!Fin){ //fin es cuando muere el jefe
                i+=1;
                if(i>=largo){ //compara si el indice es mayor a largo
                    i=0;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        posicion.start();
        res=position;
        return obtenerDato(res);
    }
}

