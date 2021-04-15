package proyecto1;

import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.image.ImageView;


import java.io.FileNotFoundException;


/**
 * The type Clase c.
 */
public class ClaseC {
    /**
     * The L.
     */
    static ListaCircular listaC = new ListaCircular();
    private static boolean alive = true;

    /**
     * Iniciar clase c.
     *
     * @param juego the juego
     * @throws FileNotFoundException the file not found exception
     */
    public static void IniciarClaseC(Group juego) throws FileNotFoundException {
        currentClass.setClass("C", listaC);
        listaC.agregarUltimo(new NaveEnemiga(110, 100, juego));
        listaC.agregarUltimo(new NaveEnemiga(220, 100, juego));
        listaC.agregarUltimo(new NaveEnemiga(330, 100, juego));
        listaC.agregarUltimo(new NaveEnemiga(440, 100, juego));
        listaC.agregarUltimo(new NaveEnemiga(550, 100, juego));

//        var naveBoss = l.obtenerDato(3);
        //NaveEnemiga.toBoss((ImageView) naveBoss);
//
//        Task<Void> vivo = new Task<Void>() {
//            @Override
//            protected Void call() throws Exception {
//                int i = 0;
//                while(i<10){
//                    if(i==3){
//
//                        break;
//                    }
//                    i+=1;
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                return null;
//            }
//        };
//        vivo.setOnSucceeded(event -> {
//            if(!alive){
//                double pos=Math.random()*l.tamanoLista();
//                int posicion =  (int) pos;
//                var nodo =l.obtenerDato(posicion);
//                //NaveEnemiga.toBoss((ImageView) nodo);
//            }
//        });
//        new Thread(vivo).start();
    }

}
