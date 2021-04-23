package proyecto1.Imagenes;

import javafx.scene.image.Image;

import java.io.InputStream;

/*
usar singleton para cargar cada imagen que se usa solo una vez
 */

/**
 * La clase Imagenes, un Singleton para cargar las imagenes utilizadas solo una vez.
 */
public class Imagenes{
    private static Imagenes INSTANCIA = null;

    // imagenes disponibles
    private Image naveUsuario = null;
    private Image titulo = null;
    private Image fondo = null;
    private Image botonStart = null;
    private Image ufo1 = null;
    private Image ufo2 = null;
    private Image ufo3 = null;
    private Image ufoBoss1 = null;
    private Image ufoBoss2 = null;
    private Image ufoBoss3 = null;
    private Image ufoBoss4 = null;
    private Image botonConfiguracion = null;
    private Image botonMusicaON = null;
    private Image fondo1 = null;
    private Image fondo2 = null;
    private Image fondo3 = null;
    private Image fondo4 = null;
    private Image fondo5 = null;
    private Image GO= null;
    private Image laser = null;
    private Image explosion = null;
    private Image botonExit = null;
    private Image naveAnimacion=null;

    //private double parametroEncoger = 0.8;


    // constructor privado para que solo exista una instancia
    private Imagenes(){
        cargarImagenes();
    }

    /**
     * Obtener instancia imagenes.
     *
     * @return imagenes
     */
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
        ufoBoss1 = cargarImagen("/Imagenes/boss.png");
        ufoBoss2 = cargarImagen("/Imagenes/boss2.png");
        ufoBoss3 = cargarImagen("/Imagenes/boss3.png");
        ufoBoss4 = cargarImagen("/Imagenes/boss4.png");
        botonConfiguracion = cargarImagen("/Imagenes/configIC.png");
        botonMusicaON = cargarImagen("/Imagenes/sonidoON.png");
        fondo1 = cargarImagen("/Imagenes/fondo1.png");
        fondo2 = cargarImagen("/Imagenes/fondo2.png");
        fondo3 = cargarImagen("/Imagenes/fondo3.png");
        fondo4 = cargarImagen("/Imagenes/fondo4.png");
        fondo5 = cargarImagen("/Imagenes/fondo5.png");
        GO= cargarImagen("/Imagenes/GO.png");
        laser = cargarImagen("/Imagenes/laser.png");
        explosion = cargarImagen("/Imagenes/explosion.png");
        botonExit = cargarImagen("/Imagenes/botonEXIT.png");
        naveAnimacion = cargarImagen("/Imagenes/navePantallaPrincipal.png");
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

//    public Image cambiarTamano(Image image) {
//        ImageView imageView = new ImageView(image);
//        imageView.setPreserveRatio(true);
//        imageView.setFitWidth(image.getWidth()* parametroEncoger);
//        imageView.setFitHeight(image.getHeight()* parametroEncoger);
//        return imageView.snapshot(null, null);
//    }

    /**
     * Obtener nave usuario.
     *
     * @return  nave usuario
     */
    public Image getNaveUsuario() {
        return naveUsuario;
    }

    /**
     * Obtener titulo.
     *
     * @return  titulo
     */
    public Image getTitulo() {
        return titulo;
    }

    /**
     * Obtener fondo.
     *
     * @return fondo
     */
    public Image getFondo() {
        return fondo;
    }


    /**
     * Obtener GameOver.
     *
     * @return GO
     */
    public Image getGO(){return GO;}


    /**
     * Obtener boton start.
     *
     * @return boton start
     */
    public Image getBotonStart() {
        return botonStart;
    }

    /**
     * Obtnener ufo 1.
     *
     * @return ufo 1
     */
    public Image getUfo1() {
        return ufo1;
    }

    /**
     * Obtener ufo 2.
     *
     * @return ufo 2
     */
    public Image getUfo2() {
        return ufo2;
    }

    /**
     * Obtener ufo 3.
     *
     * @return ufo 3
     */
    public Image getUfo3() {
        return ufo3;
    }

    /**
     * Obtener ufo boss.
     *
     * @return ufo boss
     */
    public Image getUfoBoss1() {
        return ufoBoss1;
    }

    public Image getUfoBoss2() {
        return ufoBoss2;
    }

    public Image getUfoBoss3() {
        return ufoBoss3;
    }

    public Image getUfoBoss4() {
        return ufoBoss4;
    }

    /**
     * Obtener boton configuracion.
     *
     * @return boton configuracion
     */



    public Image getBotonConfiguracion() {
        return botonConfiguracion;
    }

    /**
     * Obtener boton musica on image.
     *
     * @return botonMusicaON
     */
    public Image getBotonMusicaON(){
        return botonMusicaON;
    }

    /**
     * Obtener fondo 1.
     *
     * @return fondo 1
     */
    public Image getFondo1() {
        return fondo1;
    }

    /**
     * Obtiene fondo 2.
     *
     * @return fondo 2
     */
    public Image getFondo2() {
        return fondo1;
    }

    /**
     * Obtiene fondo 3.
     *
     * @return fondo 3
     */
    public Image getFondo3() {
        return fondo1;
    }

    /**
     * Obtiene fondo 4.
     *
     * @return fondo 4
     */
    public Image getFondo4() {
        return fondo1;
    }

    /**
     * Obtiene fondo 5.
     *
     * @return fondo 5
     */
    public Image getFondo5() {
        return fondo1;
    }

    /**
     * Obtiene laser.
     *
     * @return laser
     */
    public Image getLaser() { return laser; }

    /**
     * Obtiene explosion.
     *
     * @return explosion
     */
    public Image getExplosion() {return explosion;}


    /** Obtiene explosion.
            *
            * @return explosion
     */
    public Image getBotonExit() {return botonExit;}

    public Image getNaveAnimacion(){return naveAnimacion;}
}

