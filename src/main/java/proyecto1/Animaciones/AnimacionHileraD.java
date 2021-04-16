package proyecto1.Animaciones;


import javafx.concurrent.Task;
import proyecto1.Enemigos.NaveEnemiga;
import proyecto1.Hileras.HileraD;
import proyecto1.ListasEnlazadas.ListaCircular;

public class AnimacionHileraD {
    private final HileraD hilera;
    private Task<Void> animacion;

    public AnimacionHileraD(HileraD hilera){
        this.hilera = hilera;
    }
    private int posicionObjetivo(){
        ListaCircular<NaveEnemiga> lista = this.hilera.getListaNaves();
        int posicion = 0;
        for (int i = 0; i < 5; i++){
            if (lista.obtenerDato(i).getPosicion() != i){
                posicion = Math.abs(lista.obtenerDato(i).getPosicion()-i);
            }else{
                posicion = i;
            }
        }
        return posicion;
    }
    //public void subirPosicion(ImageView nave){
    //    Timeline subirPosicion = new Timeline(new KeyFrame(Duration.millis(2),a -> {}));
    //}
}
