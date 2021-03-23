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
    int largo=0;
    private Nodo first;
    private Nodo last;
    public ListaCircular(){
        this.first=null;
        this.last=null;
    }
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
        System.out.println(res);
        return res;

    }
    public void eraseFirst(){

    }
    public void eraseLast(){

    }
    public void erasePos(int posicion){

    }
}
