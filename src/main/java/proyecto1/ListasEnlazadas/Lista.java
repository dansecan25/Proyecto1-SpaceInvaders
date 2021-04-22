package proyecto1.ListasEnlazadas;

public interface Lista<T> {
    T obtenerDato(int posicion);
    void borrarDato(T dato);
    int tamanoLista();
    void agregarPrimero(T dato);
    void agregarUltimo(T dato);
}
