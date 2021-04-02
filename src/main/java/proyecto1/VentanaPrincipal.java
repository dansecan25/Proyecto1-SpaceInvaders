package proyecto1;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javafx.concurrent.Service;
import javafx.util.Duration;

public class VentanaPrincipal {
    public static void ventana(Stage Lobby) throws FileNotFoundException {
        Lobby.setTitle( "Space Invaders" );
        Group root = new Group(); //se crea la ventana
        Scene scene = new Scene( root,850,700,Color.valueOf("#262934")); //se liga scene al root
        Lobby.setScene( scene ); //se le da al metodo el scene

        //Imagen de fondo
        ImageInput fondo = new ImageInput(Imagenes.getInstancia().getFondo());
        Rectangle mark1=new Rectangle();
        fondo.setX(0);
        fondo.setY(-5);
        mark1.setEffect(fondo);
        mark1.setId("move");
        root.getChildren().add(mark1);
        scene.lookup("move");

        //Imagen titulo
        new VentanaPrincipal.crearProd(root, Lobby).start();

        Lobby.show();
    }
    // nadie me toque esto!!!!!!!!----------------------------------------------------------------------------------------------------
    private static class SleepServ extends Service<String> {
        private static final int SLEEP_TIME = 10000;
        private SleepServ(Group root, Stage Lobby){
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
                    Rectangle rect = new Rectangle();
                    naveUsuario.setX(20);
                    naveUsuario.setY(550);
                    rect.setEffect(naveUsuario);

                    TranslateTransition translate = new TranslateTransition();
                    translate.setByX(650);
                    translate.setDuration(Duration.millis(1200));
                    translate.setCycleCount(500);
                    translate.setAutoReverse(true);
                    translate.setNode(rect);
                    translate.play();
                    root.getChildren().add(rect);

                    //Game window button------------------------------------------------------------------------------------------------------
                    Button b1=new Button();
                    b1.setOnAction(e -> {
                        Lobby.hide();
                        try {
                            GameWind.juego(Lobby);
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                    });
                    b1.setLayoutX(270);
                    b1.setLayoutY(420);
                    b1.setGraphic(img); //Se le da al boton la imagen
                    b1.setWrapText(true); //La verdad no se
                    root.getChildren().add(b1); //crea el boton el canvas

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
    private static class Destro extends Service<String> {
        private static final int SLEEP_TIME = 10000;
        private Destro(Group t, Rectangle m){
            setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    t.getChildren().remove(m);
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
    //creacion inical del titulo
    private static class crearProd extends Service<String> {
        private static final int SLEEP_TIME = 1000;
        private crearProd(Group t, Stage Lobby){
            setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    ImageInput produc = new ImageInput(Imagenes.getInstancia().getTitulo());
                    Rectangle mark3 = new Rectangle();
                    produc.setX(190);
                    produc.setY(200);
                    mark3.setEffect(produc);

                    FadeTransition fade = new FadeTransition();
                    fade.setDuration(Duration.millis(5000));
                    fade.setFromValue(-10);
                    fade.setToValue(10);
                    fade.setCycleCount(800);
                    fade.setAutoReverse(true);
                    fade.setNode(mark3);
                    fade.play();
                    t.getChildren().add(mark3);

                    new Destro(t,mark3).start();
                    new SleepServ(t, Lobby).start();

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
