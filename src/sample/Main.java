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
import javafx.scene.layout.VBox;
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

import java.io.File;
import java.io.FileInputStream;


public class Main extends Application {
    @Override
    public void start(Stage Lobby) throws Exception{
        Lobby.setTitle( "Space Invaders" );
        Group root = new Group(); //se crea la ventana
        Scene scene = new Scene( root,850,700,Color.valueOf("#262934")); //se liga scene al root
        Lobby.setScene( scene ); //se le da al metodo el scene
        //Se crea una imagen(Start) asi-------------------------------------------------------------------------
        FileInputStream input = new FileInputStream("Imagenes/START.png");
        Image imagen=new Image(input);
        ImageView img = new ImageView(imagen);
        //Imagen de fondo
        Image BG = new Image(new FileInputStream("Imagenes/fondo.png"));
        ImageInput fondo = new ImageInput();
        Rectangle mark1=new Rectangle();
        fondo.setSource(BG);
        fondo.setX(0);
        fondo.setY(-5);
        mark1.setEffect(fondo);
        root.getChildren().add(mark1);
        //Imagen titulo
        Image TIT = new Image(new FileInputStream("Imagenes/titulo.png"));
        ImageInput tit = new ImageInput();
        Rectangle mark2=new Rectangle();
        tit.setSource(TIT);
        tit.setX(190);
        tit.setY(200);
        mark2.setEffect(tit);
        root.getChildren().add(mark2);

        //Imagen de la nave animada
        Image nave = new Image(new FileInputStream("Imagenes/navecita.png"));
        ImageInput nav = new ImageInput();
        Rectangle rect = new Rectangle();
        nav.setSource(nave);
        nav.setX(20);
        nav.setY(550);
        rect.setEffect(nav);
        root.getChildren().add(rect);




        //----------------------------------------------------------------------------------------
/*
        root.getChildren().add(recta);
        recta.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                var cosa = event.getText();
                System.out.println(cosa);
            }
        });
*/
        //Game window button------------------------------------------------------------------------------------------------------
        Button b1=new Button();
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Lobby.hide();
                GameWind.juego(Lobby);
            }
        });
        b1.setLayoutX(270);
        b1.setLayoutY(420);
        b1.setGraphic(img); //Se le da al boton la imagen
        b1.setWrapText(true); //La verdad no se
        root.getChildren().add(b1); //crea el boton el canvas
        //-------------------------------------------------------------------------------------------------------------------------
        Lobby.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
