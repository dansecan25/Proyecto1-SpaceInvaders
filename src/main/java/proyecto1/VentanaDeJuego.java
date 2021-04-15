package proyecto1;

import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.FileNotFoundException;

/**
 * The type Ventana de juego.
 */
public class VentanaDeJuego {
    private static boolean estado = true;
    public static int pts = 0;
    private static Text valor;

    /**
     * Iniciar ventana de juego.
     *
     * @param mainStage the main stage
     * @throws FileNotFoundException the file not found exception
     */
    
    private static NaveUsuario jugador;
    public static void iniciarVentanaDeJuego(Stage mainStage) throws FileNotFoundException {
        Group ventanaDeJuego= new Group();
        Scene gameScene = new Scene(ventanaDeJuego, 850, 700, Color.valueOf("#262934"));
        Stage GameStage = new Stage();
        GameStage.setScene(gameScene);
        // Boton para destruir ventana secundaria
        Fondo.IniciarFondo(ventanaDeJuego);
        Button botonExit = new Button("Exit");
        botonExit.setOnAction(event -> {
            GameStage.close();
            mainStage.show();
        });
        botonExit.setLayoutX(750); //define la posicion en x del boton
        botonExit.setLayoutY(20); //posicion y
        //botonExit.setGraphic(Imagenes.getInstancia().);
        //botonExit.setWrapText(true);
        ventanaDeJuego.getChildren().add(botonExit);
        Fondo.IniciarFondo(ventanaDeJuego);
        setJugador(new NaveUsuario(ventanaDeJuego));
        GameStage.show(); //requerido para mostrar el stage
        crearClases(ventanaDeJuego);
        Text puntos = new Text();
        String puntaje = Integer.toString(pts);
        puntos.setText(puntaje);
        puntos.setX(105);
        puntos.setY(50);
        puntos.setFill(Color.valueOf("#55d147"));
        valor = puntos;
        double fontSize = 40;
        FontWeight fontWeight = FontWeight.BOLD;

        Font font1 = Font.font("Arial", fontWeight,fontSize);
        puntos.setFont(font1);

        ventanaDeJuego.getChildren().add(puntos);

        

    }

    /**
     * Crear clases.
     *
     * @param ventanaDeJuego the ventana de juego
     */
    public static void crearClases(Group ventanaDeJuego){
        //Hilo para generara las clases
        Task<Void> clasesAleatorias = new Task<>() {
            @Override
            protected Void call() throws Exception {
                if (currentClass.getLista().tamanoLista() > 0) {
                    estado = true; //hay enemigos en la ventana
                    System.out.println("Hay enemigos");
                    Thread.sleep(1000);
                } else {
                    estado = false; //no hay enemigos en la ventana
                }
                return null;
            }
        };
        clasesAleatorias.setOnSucceeded(event -> {
            //lo que dijo arriba
            if (!estado) {
                double hill = Math.random()*6;
                int hilera = (int) hill;
                if (hilera == 0){ //clase basic
                    try {
                        new ClaseC(ventanaDeJuego); //inicia la clase C
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if(hilera == 1){ //clase A
                    try {
                        new ClaseC(ventanaDeJuego); //inicia la clase C
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if(hilera == 2){ //clase B
                    try {
                        ClaseB.IniciarClaseB(ventanaDeJuego); //inicia la clase B
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if(hilera == 3){ //clase C
                    try {
                        new ClaseC(ventanaDeJuego); //inicia la clase C
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (hilera == 4){ //Clase D
                    try {
                        new ClaseC(ventanaDeJuego); //inicia la clase C
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if(hilera == 5){ //Clase E
                    try {
                        ClaseE claseE = new ClaseE(ventanaDeJuego, 330, 300);
                        AnimacionClaseE animacionClaseE = new AnimacionClaseE(claseE);
                        animacionClaseE.iniciarAnimacion();
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
        valor.setText(puntaje);
    }

}
