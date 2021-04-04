package proyecto1;

import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class VentanaDeJuego {
    private static boolean estado = true;
    public static void iniciarVentanaDeJuego(Stage mainStage) throws FileNotFoundException {
        Group ventanaDeJuego= new Group();
        Scene gameScene = new Scene(ventanaDeJuego, 850, 700, Color.valueOf("#262934"));
        Stage GameStage = new Stage();
        GameStage.setScene(gameScene);
        // Boton para destruir ventana secundaria
        Fondo.IniciarFondo(ventanaDeJuego);
        Button botonExit = new Button();
        botonExit.setOnAction(event -> {
            GameStage.close();
            mainStage.show();
        });
        botonExit.setLayoutX(750); //define la posicion en x del boton
        botonExit.setLayoutY(20); //posicion y
        //botonExit.setGraphic(Imagenes.getInstancia().);
        //botonExit.setWrapText(true);
        ventanaDeJuego.getChildren().add(botonExit);



        NaveUsuario.IniciarNaveUsuario(ventanaDeJuego);
        GameStage.show(); //requerido para mostrar el stage
        crearClases(ventanaDeJuego);

    }
    public static void crearClases(Group ventanaDeJuego){
        //Hilo para generara las clases
        Task<Void> clasesAleatorias = new Task<>() {
            @Override
            protected Void call() throws Exception {
                if (currentClass.getLista().largo > 0) {
                    estado = true; //hay enemigos en la ventana
                    System.out.println("Hay enemigos");
                    Thread.sleep(1000);
                } else {
                    estado = false; //no hay enemigos en la ventana
                    System.out.println("No hay enemigos");
                }
                return null;
            }
        };
        clasesAleatorias.setOnSucceeded(event -> {

            //lo que dijo arriba
            if (!estado) {
                try {
                    ClaseC.IniciarClaseC(ventanaDeJuego); //inicia la clase C
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            crearClases(ventanaDeJuego); //vuelve a inciar el metodo que inicia el hilo
        });
        new Thread(clasesAleatorias).start();
    }
}
