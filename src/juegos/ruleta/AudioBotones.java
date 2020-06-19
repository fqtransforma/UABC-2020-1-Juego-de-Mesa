package juegos.ruleta;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class AudioBotones {
    //private Clip clip;

    public void audio(String name) {
        try {
            Clip sonido = AudioSystem.getClip();
            File a = new File(name);
            sonido.open(AudioSystem.getAudioInputStream(a));
            sonido.start();
            System.out.println("Reproduciendo 10s. de sonido...");
            Thread.sleep(1000); // 10000 milisegundos (10 segundos)
            sonido.close();
        } catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }

}
