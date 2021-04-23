package proyecto1.Ventanas;

import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import proyecto1.Animaciones.Animacion;
import proyecto1.Animaciones.AnimacionClaseE;
import proyecto1.Animaciones.currentClass;
import proyecto1.Hileras.*;
import proyecto1.Imagenes.Fondo;
import proyecto1.Imagenes.Imagenes;
import proyecto1.Usuario.NaveUsuario;


import java.io.FileNotFoundException;

/**
 * The type Ventana de juego.
 */
public class VentanaDeJuego {
    private static boolean estado = true;
    public static int pts = 0;
    public static String clase = "Basic";
    private static final Text puntos = new Text();
    private static final Text cla = new Text();
    private static NaveUsuario jugador;
    /**
     * Iniciar ventana de juego.
     *
     * @param mainStage the main stage
     * @throws FileNotFoundException the file not found exception
     */
    public static void iniciarVentanaDeJuego(Stage mainStage) throws FileNotFoundException {
        Group ventanaDeJuego= new Group();
        Scene gameScene = new Scene(ventanaDeJuego, 850, 700, Color.valueOf("#262934"));
        Stage GameStage = new Stage();
        GameStage.setScene(gameScene);

        // Boton para destruir ventana secundaria
        Fondo.IniciarFondo(ventanaDeJuego);
        ImageView EXIT = new ImageView(Imagenes.getInstancia().getBotonExit());

        Button botonExit = new Button();
        botonExit.setOnAction(event -> {
            GameStage.close();
            mainStage.show();
        });
        botonExit.setLayoutX(765); //define la posicion en x del boton
        botonExit.setLayoutY(8); //posicion y
        botonExit.setGraphic(EXIT);
        botonExit.setWrapText(true);
        ventanaDeJuego.getChildren().add(botonExit);

        setJugador(new NaveUsuario(ventanaDeJuego));
        GameStage.show(); //requerido para mostrar el stage

        //new HileraBasic(ventanaDeJuego);
        HileraE hileraE = new HileraE(ventanaDeJuego, 330, 300);
        AnimacionClaseE animacionClaseE = new AnimacionClaseE(hileraE);
        animacionClaseE.iniciarAnimacion();
        setCLASE();
        crearClases(ventanaDeJuego);
        String puntaje = Integer.toString(pts);
        puntos.setText(puntaje);
        puntos.setX(105);
        puntos.setY(50);
        puntos.setFill(Color.valueOf("#55d147"));
        double fontSize = 40;
        FontWeight fontWeight = FontWeight.BOLD;
        Font font1 = Font.font("Arial", fontWeight,fontSize);
        puntos.setFont(font1);
        cla.setText(clase);
        cla.setY(185);
        cla.setX(750);
        cla.setFill(Color.valueOf("#55d147"));
        double fontSize2 = 75;
        FontWeight fontWeight1 = FontWeight.BOLD;
        Font font2 = Font.font("Arial", fontWeight1,fontSize2);
        cla.setFont(font2);
        ventanaDeJuego.getChildren().add(cla);
        ventanaDeJuego.getChildren().add(puntos);
    }
    /**
     * Crear clases.
     *
     * @param ventanaDeJuego the ventana de juego
     */
    public static void crearClases(Group ventanaDeJuego){
        //Hilo para generar las clases
        Task<Void> clasesAleatorias = new Task<>() {
            @Override
            protected Void call() throws Exception {
                System.out.println("Inicia el hilo");
                System.out.println("Lista: "+currentClass.getLista());
                if (pts>250){
                    cambiarNivel(2);
                }
                if (pts>=750){
                    cambiarNivel(3);
                }
                if (pts>=1500){
                    cambiarNivel(4);
                }
                if (pts>=2750){
                    cambiarNivel(5);
                }
                System.out.println("Lista*: " + currentClass.getLista());
                if (currentClass.getLista().tamanoLista() > 0) {
                    estado = true; //hay enemigos en la ventana
                    Thread.sleep(1000);
                } else {
                    estado = false; //no hay enemigos en la ventana
                }
                return null;
            }
        };
        clasesAleatorias.setOnSucceeded(event -> {
            System.out.println("Estado: "+estado);
            if (!estado) {
                double hill = Math.random()*6;
                int hilera = (int) hill;
                System.out.println("Hilera: "+hilera);
                if (hilera == 0){ //clase basic
                    try {
                        HileraBasic naves = new HileraBasic(ventanaDeJuego); //inicia la clase Basic
                        Animacion.iniciarAnimacion(currentClass.getLista());
                        setCLASE();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if(hilera == 1){ //clase A
                    new HileraA(ventanaDeJuego); //inicia la clase C
                    Animacion.iniciarAnimacion(currentClass.getLista());
                    setCLASE();
                }
                if(hilera == 2){ //clase B
                    try {
                        new HileraB(ventanaDeJuego); //inicia la clase B
                        Animacion.iniciarAnimacion(currentClass.getLista());
                        setCLASE();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if(hilera == 3){ //clase C
                    try {
                        new HileraC(ventanaDeJuego); //inicia la clase C
                        Animacion.iniciarAnimacion(currentClass.getLista());
                        setCLASE();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (hilera == 4){ //Clase D
                    try {
                        new HileraC(ventanaDeJuego); //inicia la clase C
                        Animacion.iniciarAnimacion(currentClass.getLista());
                        setCLASE();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if(hilera == 5){ //Clase E
                    try {
                        HileraE hileraE = new HileraE(ventanaDeJuego, 330, 300);
                        AnimacionClaseE animacionClaseE = new AnimacionClaseE(hileraE);
                        animacionClaseE.iniciarAnimacion();
                        setCLASE();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
            crearClases(ventanaDeJuego); //vuelve a inciar el metodo que inicia el hilo
        });
        new Thread(clasesAleatorias).start();
    }
    public static NaveUsuario getJugador(){
        return jugador;
    }
    private static void setJugador(NaveUsuario naveJugador){
        jugador = naveJugador;
    }
    public static void updatePuntos(int suma){
        pts = pts+suma;
        var puntaje = Integer.toString(pts);
        puntos.setText(puntaje);
    }
    public static void setCLASE(){
        cla.setText(currentClass.getClase());
    }
    public static void cambiarNivel(int nivel){
        currentClass.setNivel(nivel);
        if(nivel==2){
            var fondo = Fondo.getFondo();
            fondo.setImage(Imagenes.getInstancia().getFondo2());
        }else if(nivel == 3){
            var fondo = Fondo.getFondo();
            fondo.setImage(Imagenes.getInstancia().getFondo4());

        }else if(nivel == 4){
            var fondo = Fondo.getFondo();
            fondo.setImage(Imagenes.getInstancia().getFondo3());
        }else if(nivel==5){
            var fondo = Fondo.getFondo();
            fondo.setImage(Imagenes.getInstancia().getFondo5());
        }
    }

}
