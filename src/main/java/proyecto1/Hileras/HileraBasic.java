package proyecto1.Hileras;

import javafx.scene.Group;
import proyecto1.Animaciones.currentClass;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.Excepciones.IndiceInvalidoException;
import proyecto1.ListasEnlazadas.ListFactory;
import proyecto1.ListasEnlazadas.Lista;

import java.io.FileNotFoundException;

/**
 * La clase Básica solo tiene una hilera de minions uniformes.
 */
public class HileraBasic implements Hilera{
    private static final ListFactory<NaveEnemiga> listFactory = new ListFactory<>();
    private final Lista<NaveEnemiga> listaBasic;
    private int x;
    private int y;
    /**
     * Instancia Case Basica
     * @param juego la ventana de juego
     * @throws FileNotFoundException  file not found exception
     */
    public HileraBasic(Group juego,int x,int y) throws FileNotFoundException{
        this.x = x;
        this.y = y;
        listaBasic = listFactory.crearLista("Simple");

        listaBasic.agregarUltimo(new NaveEnemiga(x-160, 100, juego, 0));
        listaBasic.agregarUltimo(new NaveEnemiga(x-80, 100, juego, 1));
        listaBasic.agregarUltimo(new NaveEnemiga(x, 100, juego, 2));
        listaBasic.agregarUltimo(new NaveEnemiga(x+80, 100, juego, 3));
        listaBasic.agregarUltimo(new NaveEnemiga(x+160, 100, juego, 4));

        currentClass.setClass("BA", listaBasic);
    }
    public Lista<NaveEnemiga> getLista(){
        return listaBasic;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void movimientoLateral(char Dir) throws IndiceInvalidoException {
        int tamano = listaBasic.tamanoLista();
        if (!(tamano == 0)){
        for (int i = 0; i < tamano-1;i++){
            if (Dir == 'D'){
                this.x += 1;
                listaBasic.obtenerDato(i).getImagenNave().setX(this.x);
            }else if (Dir == 'I'){
                this.x -= 1;
                listaBasic.obtenerDato(i).getImagenNave().setX(this.x);
            }
        }
        } else{
            throw new IndiceInvalidoException("ya deje de ser inutil");
        }
    }
    public void bajarHilera() throws IndiceInvalidoException {
        this.y += 1;
        int tamano = listaBasic.tamanoLista();
        if (!(tamano == 0)){
        for (int i = 0; i < tamano-1;i++){
            try{
            listaBasic.obtenerDato(i).getImagenNave().setY(this.y);
            }catch (IndiceInvalidoException e){
                e.printStackTrace();
            }
        }
        }else{
            throw new IndiceInvalidoException("pls");
        }
    }
}
