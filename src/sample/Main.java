package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.Node;

import java.io.FileInputStream;


public class Main extends Application {
    @Override
    public void start(Stage Lobby) throws Exception{
        //Se crea una imagen asi-------------------------------------------------------------------------
        FileInputStream input = new FileInputStream("Imagenes/START.png");
        Image imagen=new Image(input);
        ImageView img = new ImageView(imagen);
        //----------------------------------------------------------------------------------------

        Button b1=new Button();
        Lobby.setTitle( "Space Invaders" );

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                System.out.println("Hola mundo");
            }
        });



        b1.setLayoutX(100);
        b1.setLayoutY(300);

        Group root = new Group(); //se crea la ventana

        b1.setGraphic(img); //Se le da al boton la imagen
        b1.setWrapText(true); //La verdad no se


        root.getChildren().add(b1); //crea el boton el canvas
        Scene scene = new Scene( root,800,600 ); //se liga scene al root
        Lobby.setScene( scene ); //se le da al metodo el scene

        //Creacion de texto en el canvas
        Text texto = new Text();
        texto.setText("Hola mundo");
        texto.setX(50);
        texto.setY(50);
        root.getChildren().add(texto); //add children siempre se usa para agregar un nodo

        Lobby.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
