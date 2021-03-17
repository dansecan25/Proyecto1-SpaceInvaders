package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameWind {
    public static void juego(Stage mainStage){
        Group juego= new Group();
        Scene game = new Scene(juego, 800, 750);
        Stage yano = new Stage();
        yano.setScene(game);
        // Boton para destruir ventana secundaria
        Button b2=new Button("Exit");
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                yano.close();
                mainStage.show();
            }
        });
        b2.setLayoutX(50);
        b2.setLayoutY(50);
        juego.getChildren().add(b2);
        yano.show();
    }
}
