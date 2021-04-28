package proyecto1.Animaciones;


import javafx.concurrent.Task;
import proyecto1.Hileras.HileraD;

public class AnimacionHileraD {
    private final HileraD hilera;
    private Task<Void> animacion;

    public AnimacionHileraD(HileraD hilera){
        this.hilera = hilera;
    }
}
