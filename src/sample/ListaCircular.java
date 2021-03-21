package sample;
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
    private Nodo first;
    private Nodo prev;
    private Nodo last;
    public ListaCircular(){
        this.first=null;
        this.last=null;
    }
    public void addFirst(int valor){
        if (this.first==null){
            this.first= new Nodo(valor);
            this.last=this.first;
        }else {
        Nodo current= new Nodo(valor);
        current.next=this.first;
        this.first.prev=current;
        this.first=current;
        this.last=this.first;
        }
    }
    public void addLast(int dato){
        if(this.first==null){
            this.first=new Nodo(dato);
            this.last=this.first;
        }else{
            Nodo current = this.first;
            while(current.next != this.first){
                current = current.next;
            }
            Nodo tmp = this.last;
            Nodo ant = tmp;
            tmp.next = new Nodo(dato);
            tmp=tmp.next;
            tmp.prev=ant;
            this.last=tmp;
        }
    }
    public void leer(){
        Nodo current = this.first;
        if(this.first==this.last){
            System.out.println("Vacia");
        }
        while (current != this.last){
            System.out.println(current.get_value());
            current=current.next;
        }
    }
}
