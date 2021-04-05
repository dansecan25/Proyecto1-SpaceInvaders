package proyecto1;

import javafx.concurrent.Task;
import javafx.scene.Group;


import java.io.FileNotFoundException;



public class ClaseC {
    static ListaCircularImagenes l = new ListaCircularImagenes();
    private static boolean alive = true;
    public static void IniciarClaseC(Group juego) throws FileNotFoundException {
        currentClass.setClass("C", l);
        new NaveEnemiga(110, 100, juego, l);
        new NaveEnemiga(220, 100, juego, l);
        new NaveEnemiga(330, 100, juego, l);
        new NaveEnemiga(440, 100, juego, l);
        new NaveEnemiga(550, 100, juego, l);
        var naveBoss = l.obtenerDato(3);
        NaveEnemiga.toBoss(naveBoss);

        Task<Void> vivo = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                int i = 0;
                while(i<10){
                    if(i==3){
                        alive=false;
                        break;
                    }
                    i+=1;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };
        vivo.setOnSucceeded(event -> {
            if(!alive){
                double pos=Math.random()*l.largo;
                int posicion =  (int) pos;
                var nodo =l.obtenerDato(posicion);
                NaveEnemiga.toBoss(nodo);
            }
        });
        new Thread(vivo).start();


    }

}
