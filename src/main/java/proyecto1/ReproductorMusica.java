package proyecto1;

//import com.sun.glass.ui.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.InputStream;
import java.net.URISyntaxException;

/**
 * La clase Reproductor musica para reproducir musica de fondo.
 */
public class ReproductorMusica {
    /**
     * Instancia  nuevo Reproductor Musica.
     *
     * @throws URISyntaxException uri syntax exception
     */
    public ReproductorMusica() throws URISyntaxException {
        Media media = new Media(getClass().getResource("/Musica/8bitKirby.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
        mediaPlayer.setAutoPlay(true);
        System.out.println("Playing...");
    }

}
