package proyecto1.Ventanas;
import javafx.animation.FadeTransition;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.effect.ImageInput;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import javafx.util.Duration;
import proyecto1.Imagenes.Imagenes;
import proyecto1.Musica.ReproductorMusica;

/**
 * The type Ventana principal.
 */
public class VentanaPrincipal {
    /**
     * Ventana.
     *
     * @param Lobby the lobby
     * @throws FileNotFoundException the file not found exception
     */
    public static void ventana(Stage Lobby) throws FileNotFoundException, URISyntaxException {
        ReproductorMusica reproductorMusica = new ReproductorMusica();
        reproductorMusica.reproducir();
        Lobby.setTitle( "Space Invaders" );
        Group root = new Group(); //se crea la ventana
        Scene scene = new Scene( root,800,750,Color.valueOf("#262934")); //se liga scene al root
        Lobby.setScene( scene ); //se le da al metodo el scene
        //Imagen de fondo
        ImageInput fondo = new ImageInput(Imagenes.getInstancia().getFondo());
        Rectangle rectanguloFondo=new Rectangle();
        fondo.setX(0);
        fondo.setY(-5);
        rectanguloFondo.setEffect(fondo);
        root.getChildren().add(rectanguloFondo);
        //Imagen de creditos
        ImageInput produc = new ImageInput(Imagenes.getInstancia().getTitulo());
        Rectangle rectanguloCreditos = new Rectangle();//crea el recatangulo de la imagen con los nombres de los involucrados en el proyecto
        produc.setX(167);
        produc.setY(200);
        rectanguloCreditos.setEffect(produc); //se le da al rectangulo la imagen con el texto
        //animacion de aparición y desaparición de la imagen
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(3500)); //duración de la animación
        fade.setFromValue(-10); //valor inicial de opacidad
        fade.setToValue(10); //valor final de opacidad
        fade.setCycleCount(2); //cantidad de veces que se repite
        fade.setAutoReverse(true); //se indica que si se revierte la animación
        fade.setNode(rectanguloCreditos);
        fade.play();
        root.getChildren().add(rectanguloCreditos);

        Task<Void> ventanaPrincipal = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep(7000);
                return null;
            }
        };
        ventanaPrincipal.setOnSucceeded(event -> {
            try {
                new CargarVentanaPrincipal(root, rectanguloCreditos, Lobby, reproductorMusica);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            });
        new Thread(ventanaPrincipal).start();
        Lobby.show();
    }
}
