package proyecto1;

import javafx.scene.image.Image;
import java.io.InputStream;

/*
usar singleton para cargar cada imagen que se usa solo una vez
 */
public class Imagenes {
    private static Imagenes INSTANCIA = null;

    // imagenes disponibles
    private Image naveUsuario = null;
    private Image titulo = null;
    private Image fondo = null;
    private Image botonStart = null;
    private Image ufo1 = null;
    private Image ufo2 = null;
    private Image ufo3 = null;
    private Image ufoBoss = null;
    private Image botonConfiguracion = null;
    private Image botonMusicaON = null;

    // constructor privado para que solo exista una instancia
    private Imagenes(){
        cargarImagenes();
    }

    // metodo sincronizado para evitar problemas con hilos
    public static synchronized Imagenes getInstancia(){
        if (INSTANCIA == null){
            INSTANCIA = new Imagenes();
        }
        return INSTANCIA;
    }

    //llama a todos los cargar imagenes de todas las imagenes
    private void cargarImagenes(){
        naveUsuario = cargarImagen("/Imagenes/navecita.png");
        titulo = cargarImagen("/Imagenes/titulo.png");
        fondo = cargarImagen("/Imagenes/fondo.png");
        botonStart = cargarImagen("/Imagenes/START.png");
        ufo1 = cargarImagen("/Imagenes/UFO1.png");
        ufo2 = cargarImagen("/Imagenes/UFO2.png");
        ufo3 = cargarImagen("/Imagenes/UFO3.png");
        ufoBoss = cargarImagen("/Imagenes/boss.png");
        botonConfiguracion = cargarImagen("/Imagenes/configIC.png");
        botonMusicaON = cargarImagen("/Imagenes/sonidoON.png");

    }

    private Image cargarImagen(String nombreImagen){
        Image resultado = null;
        try {
             InputStream inputStream = this.getClass().getResourceAsStream(nombreImagen);
             resultado = new Image(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public Image getNaveUsuario() {
        return naveUsuario;
    }

    public Image getTitulo() {
        return titulo;
    }

    public Image getFondo() {
        return fondo;
    }

    public Image getBotonStart() {
        return botonStart;
    }

    public Image getUfo1() {
        return ufo1;
    }

    public Image getUfo2() {
        return ufo2;
    }

    public Image getUfo3() {
        return ufo3;
    }

    public Image getUfoBoss() {
        return ufoBoss;
    }

    public Image getBotonConfiguracion() {
        return botonConfiguracion;
    }

    public Image getBotonMusicaON(){
        return botonMusicaON;
    }
}
