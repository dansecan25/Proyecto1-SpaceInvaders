package proyecto1.Hileras;

import java.io.FileNotFoundException;
import javafx.scene.Group;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.ListasEnlazadas.simpleLinkedList;
import proyecto1.Animaciones.currentClass;



public class HileraA {

    public HileraA(Group juego) throws FileNotFoundException{
        simpleLinkedList<NaveEnemiga> listaA= new simpleLinkedList<>();

        currentClass.setClass("A", null, listaA );
        listaA.addUltimo(new NaveEnemiga(110, 100, juego, 0));
        listaA.addUltimo(new NaveEnemiga(220, 100, juego, 1));
        listaA.addUltimo(new NaveEnemiga(330, 100, juego, 2));
        listaA.addUltimo(new NaveEnemiga(440, 100, juego, 3));
        listaA.addUltimo(new NaveEnemiga(550, 100, juego, 4));
        double posBoss= Math.random()*4;
        int posJefe= (int) posBoss;

        NaveEnemiga naveJefe= listaA.get(posJefe);
        naveJefe.toBoss();

    }




}
