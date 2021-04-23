package proyecto1.Hileras;

import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.Excepciones.IndiceInvalidoException;
import proyecto1.ListasEnlazadas.Lista;

public interface Hilera {
    Lista<NaveEnemiga> getLista();
    int getX();
    int getY();
    void movimientoLateral(char Dir) throws IndiceInvalidoException;
    void bajarHilera() throws IndiceInvalidoException;
}
