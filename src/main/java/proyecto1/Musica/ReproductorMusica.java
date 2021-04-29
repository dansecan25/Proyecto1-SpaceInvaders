package proyecto1.Musica;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.InputStream;
import java.net.URISyntaxException;

/**
 * La clase Reproductor musica para reproducir musica de fondo.
 */
public class ReproductorMusica {
    private MediaPlayer mediaPlayer;
    /**
     * Instancia  nuevo Reproductor Musica.
     *
     * @throws URISyntaxException uri syntax exception
     */
    public ReproductorMusica() throws URISyntaxException {
        Media media = new Media(getClass().getResource("/Musica/8bitKirby.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(media);

    }

    public void reproducir(){
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
        mediaPlayer.setVolume(0.06);
        mediaPlayer.setAutoPlay(true);
    }

    public void detener(){
        mediaPlayer.setVolume(0);
    }

}
