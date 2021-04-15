package proyecto1;

import javafx.scene.Group;
import java.io.FileNotFoundException;

/**
 * The type Clase c.
 */
public class ClaseC {

    /**
     * Iniciar clase c.
     *
     * @param juego the juego
     */
    public ClaseC(Group juego) throws FileNotFoundException {
        ListaCircular<NaveEnemiga> listaNaves = new ListaCircular<>();
        currentClass.setClass("C", listaNaves);
        listaNaves.agregarUltimo(new NaveEnemiga(110, 100, juego, 0));
        listaNaves.agregarUltimo(new NaveEnemiga(220, 100, juego, 1));
        listaNaves.agregarUltimo(new NaveEnemiga(330, 100, juego, 2));
        listaNaves.agregarUltimo(new NaveEnemiga(440, 100, juego, 3));
        listaNaves.agregarUltimo(new NaveEnemiga(550, 100, juego, 4));

        NaveEnemiga naveBoss = listaNaves.obtenerDato(3);
        naveBoss.toBoss();
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
