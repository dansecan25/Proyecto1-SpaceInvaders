package proyecto1.ListasEnlazadas;

import proyecto1.Excepciones.IndiceInvalidoException;

public interface Lista<T> {
    T obtenerDato(int posicion) throws IndiceInvalidoException;
    void borrarDato(T dato);
    int tamanoLista();
    void agregarPrimero(T dato);
    void agregarUltimo(T dato);
    void bubbleSort();
}
