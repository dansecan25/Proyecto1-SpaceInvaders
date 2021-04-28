package proyecto1.ListasEnlazadas;

public class ListFactory<T>{
    public Lista<T> crearLista(String tipoLista){
        if (tipoLista == null){
            return null;
        }else if ("Simple".equalsIgnoreCase(tipoLista)){
            return new simpleLinkedList<>();
        }else if ("Doble".equalsIgnoreCase(tipoLista)){
            return new doubleLinkedList<>();
        }else if ("Circular".equalsIgnoreCase(tipoLista)){
            return new ListaCircular<>();
        }
        return null;
    }
}
