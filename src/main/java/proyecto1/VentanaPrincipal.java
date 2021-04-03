package proyecto1;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.FileNotFoundException;

import javafx.concurrent.Service;
import javafx.util.Duration;

public class VentanaPrincipal {
    public static void ventana(Stage Lobby) throws FileNotFoundException {
        Lobby.setTitle( "Space Invaders" );
        Group root = new Group(); //se crea la ventana
        Scene scene = new Scene( root,800,750,Color.valueOf("#262934")); //se liga scene al root
        Lobby.setScene( scene ); //se le da al metodo el scene

        //Imagen de fondo
        ImageInput fondo = new ImageInput(Imagenes.getInstancia().getFondo());
        Rectangle mark1=new Rectangle();
        fondo.setX(0);
        fondo.setY(-5);
        mark1.setEffect(fondo);
        mark1.setId("move"); //id del fondo, por el momento es solo para probar los ids, se eliminará luego
        root.getChildren().add(mark1);
        scene.lookup("move");


        //Imagen titulo
        new mostrarCreditos(root, Lobby).start();

        Lobby.show();
    }
    // nadie me toque esto!!!!!!!!----------------------------------------------------------------------------------------------------
    private static class MostrarVentanaPrincipal extends Service<String> {
        private static final int SLEEP_TIME = 10000;
        private MostrarVentanaPrincipal(Group root, Stage Lobby){
            setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    //Se crea imagen Start
                    ImageView img = new ImageView(Imagenes.getInstancia().getBotonStart());

                    //Se crea imagen Titulo
                    ImageInput titulo = new ImageInput(Imagenes.getInstancia().getTitulo());
                    titulo.setX(190);
                    titulo.setY(200);

                    Rectangle mark2= new Rectangle();
                    mark2.setEffect(titulo);
                    root.getChildren().add(mark2);

                    //Imagen de la nave animada--------------------------------------------------------------------------------------------------------
                    ImageInput naveUsuario = new ImageInput(Imagenes.getInstancia().getNaveUsuario());
                    Rectangle rect = new Rectangle(); //crea un rectangulo, nodo donde se insertará la imagen
                    naveUsuario.setX(20); //posicione en x
                    naveUsuario.setY(550); //posicion en y
                    rect.setEffect(naveUsuario); //se le da al rectangulo la imagen

                    TranslateTransition translate = new TranslateTransition(); //se inicia a crear la animacion
                    translate.setByX(600); //destino final de la nave al moverse
                    translate.setDuration(Duration.millis(1200)); //tiempo que dura trasladandose
                    translate.setCycleCount(500); //cantitad de veces que se repite el traslado
                    translate.setAutoReverse(true); //se regresa a la posicion original
                    translate.setNode(rect); //se le asigna al rectangulo el efecto de animacion translate
                    translate.play(); //se le da inicio a la animacion
                    root.getChildren().add(rect);

                    //Game window button------------------------------------------------------------------------------------------------------
                    Button juegoInicia=new Button();
                    juegoInicia.setOnAction(e -> {
                        Lobby.hide(); //se esconde la ventana principal
                        try {
                            VentanaDeJuego.iniciarVentanaDeJuego(Lobby); //se abre la ventana de juego
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                    });
                    juegoInicia.setLayoutX(270);
                    juegoInicia.setLayoutY(420);
                    juegoInicia.setGraphic(img); //Se le da al boton la imagen
                    juegoInicia.setWrapText(true); //La verdad no se
                    root.getChildren().add(juegoInicia); //crea el boton el canvas

                    // crear boton sonido

                    ImageView imu = new ImageView(Imagenes.getInstancia().getBotonMusicaON());
                    Button music = new Button();
                    music.setOnAction(e->{
                        //Musica.play();
                        System.out.println("playing");
                    });
                    music.setLayoutY(10);
                    music.setLayoutX(10);
                    music.setGraphic(imu);
                    root.getChildren().add(music);
                }
            });
        }
        @Override
        protected Task<String> createTask(){
            return new Task<String>(){
                @Override
                protected String call() throws InterruptedException{
                    Thread.sleep(SLEEP_TIME);
                    return null;
                }
            };
        }
    }
    //eliminar el titulo
    private static class eliminarTitulo extends Service<String> {
        private static final int SLEEP_TIME = 10000;
        private eliminarTitulo(Group t, Rectangle m){
            setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    t.getChildren().remove(m);
                }//se encarga de remover el objeto/nodo de la ventana
            });
        }
        @Override
        protected Task<String> createTask(){
            return new Task<String>(){
                @Override
                protected String call() throws InterruptedException{
                    Thread.sleep(SLEEP_TIME);
                    return null;
                }
            };
        }
    }
    //creacion inical del titulo
    private static class mostrarCreditos extends Service<String> {
        private static final int SLEEP_TIME = 1000;
        private mostrarCreditos(Group t, Stage Lobby){
            setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    ImageInput produc = new ImageInput(Imagenes.getInstancia().getTitulo());
                    Rectangle mark3 = new Rectangle();//crea el recatangulo de la imagen con los nombres de los involucrados en el proyecto
                    produc.setX(190);
                    produc.setY(200);
                    mark3.setEffect(produc); //se le da al rectangulo la imagen con el texto
                    //animacion de aparición y desaparición de la imagen
                    FadeTransition fade = new FadeTransition();
                    fade.setDuration(Duration.millis(5000)); //duración de la animación
                    fade.setFromValue(-10); //valor inicial de opacidad
                    fade.setToValue(10); //valor final de opacidad
                    fade.setCycleCount(800); //duración antes de revertirse
                    fade.setAutoReverse(true); //se indica que si se revierte la animación
                    fade.setNode(mark3);
                    fade.play();
                    t.getChildren().add(mark3);

                    new eliminarTitulo(t,mark3).start();
                    new MostrarVentanaPrincipal(t, Lobby).start();

                }
            });
        }
        @Override
        protected Task<String> createTask(){
            return new Task<String>(){
                @Override
                protected String call() throws InterruptedException{
                    Thread.sleep(SLEEP_TIME);
                    return null;
                }
            };
        }
    }

    //-----------------------------------------------------------------------------------

}
