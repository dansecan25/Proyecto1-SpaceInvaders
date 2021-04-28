package proyecto1;

import javafx.application.Application;
import javafx.stage.Stage;
import proyecto1.Ventanas.VentanaPrincipal;


/**
 * The type Main.
 */
public class Main extends Application{
    @Override
    public void start(Stage Lobby) throws Exception{
        VentanaPrincipal.ventana(Lobby);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
