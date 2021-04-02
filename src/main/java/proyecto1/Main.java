package proyecto1;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application{
    @Override
    public void start(Stage Lobby) throws Exception{
        VentanaPrincipal.ventana(Lobby);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
