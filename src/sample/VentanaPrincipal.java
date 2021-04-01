package sample;
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
import javafx.concurrent.Service;
import javafx.util.Duration;

public class VentanaPrincipal {
    public static void ventana(Stage Lobby) throws FileNotFoundException {
        Lobby.setTitle( "Space Invaders" );
        Group root = new Group(); //se crea la ventana
        Scene scene = new Scene( root,850,700,Color.valueOf("#262934")); //se liga scene al root
        Lobby.setScene( scene ); //se le da al metodo el scene

        //Imagen de fondo
        Image BG = new Image(new FileInputStream("Imagenes/fondo.png"));
        ImageInput fondo = new ImageInput();
        Rectangle mark1=new Rectangle();
        fondo.setSource(BG);
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
                    //Se crea una imagen(Start) asi-------------------------------------------------------------------------
                    FileInputStream input = null;
                    try {
                        input = new FileInputStream("Imagenes/START.png");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    Image imagen=new Image(input);
                    ImageView img = new ImageView(imagen);
                    Image TIT = null;
                    try {
                        TIT = new Image(new FileInputStream("Imagenes/titulo.png"));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    ImageInput tit = new ImageInput();
                    Rectangle mark2=new Rectangle();
                    tit.setSource(TIT);
                    tit.setX(190);
                    tit.setY(200);
                    mark2.setEffect(tit);
                    root.getChildren().add(mark2);
                    //Imagen de la nave animada--------------------------------------------------------------------------------------------------------
                    Image nave = null;
                    try {
                        nave = new Image(new FileInputStream("Imagenes/navecita.png"));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    ImageInput nav = new ImageInput();
                    Rectangle rect = new Rectangle();
                    nav.setSource(nave);
                    nav.setX(20);
                    nav.setY(550);
                    rect.setEffect(nav);
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
                    //Sound Button-------------------------------------------------------------------------------------------------------------
                    FileInputStream musicl = null;
                    try {
                        musicl = new FileInputStream("Imagenes/sonidoON.png");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    Image imo=new Image(musicl);
                    ImageView imu = new ImageView(imo);
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
                    Image produ = null;
                    try {
                        produ = new Image(new FileInputStream("Imagenes/titulo.png"));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    ImageInput produc = new ImageInput();
                    Rectangle mark3 = new Rectangle();
                    produc.setSource(produ);
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
