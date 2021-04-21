package proyecto1.Hileras;

import javafx.scene.Group;
import proyecto1.Animaciones.currentClass;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.ListasEnlazadas.ListFactory;
import proyecto1.ListasEnlazadas.Lista;



public class HileraA {
    private static final ListFactory<NaveEnemiga> listFactory = new ListFactory<>();
    public HileraA(Group juego){
        Lista<NaveEnemiga> listaA= listFactory.crearLista("Simple");

        currentClass.setClass("A", listaA);
        listaA.agregarUltimo(new NaveEnemiga(110, 100, juego, 0));
        listaA.agregarUltimo(new NaveEnemiga(220, 100, juego, 1));
        listaA.agregarUltimo(new NaveEnemiga(330, 100, juego, 2));
        listaA.agregarUltimo(new NaveEnemiga(440, 100, juego, 3));
        listaA.agregarUltimo(new NaveEnemiga(550, 100, juego, 4));
        double posBoss= Math.random()*4;
        int posJefe= (int) posBoss;

        NaveEnemiga naveJefe= listaA.obtenerDato(posJefe);
        naveJefe.toBossA();

    }




}
