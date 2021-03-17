package sample;


import javafx.application.Application;
import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.Node;
import javafx.scene.transform.Translate;
import java.io.FileInputStream;


public class Main extends Application {
    @Override
    public void start(Stage Lobby) throws Exception{
        Lobby.setTitle( "Space Invaders" );
        Group root = new Group(); //se crea la ventana
        Scene scene = new Scene( root,800,750 ); //se liga scene al root
        Lobby.setScene( scene ); //se le da al metodo el scene
        //Se crea una imagen(Start) asi-------------------------------------------------------------------------
        FileInputStream input = new FileInputStream("Imagenes/START.png");
        Image imagen=new Image(input);
        ImageView img = new ImageView(imagen);
        //Imagen del UFO
        FileInputStream inputs = new FileInputStream("Imagenes/navecita.gif");
        Image uf = new Image(inputs);
        ImageInput ufig = new ImageInput();
        //----------------------------------------------------------------------------------------
        ufig.setSource(uf);
        ufig.setX(200);
        ufig.setY(200);
        Rectangle rect = new Rectangle();
        rect.setEffect(ufig);
        root.getChildren().add(rect);
        rect.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println(event);
            }
        });


        Button b1=new Button();
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StackPane juego= new StackPane();
                Scene game = new Scene(juego, 800, 750);
                Stage yano = new Stage();
                yano.setScene(game);
                yano.show();


            }
        });
        b1.setLayoutX(270);
        b1.setLayoutY(450);
        b1.setGraphic(img); //Se le da al boton la imagen
        b1.setWrapText(true); //La verdad no se
        root.getChildren().add(b1); //crea el boton el canvas

        Lobby.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
