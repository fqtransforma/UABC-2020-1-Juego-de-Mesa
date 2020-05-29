package juegos.ruletaF;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class WindowApp extends JFrame {

    public Thread audio;

    public WindowApp(String title)  {

        audio = new Thread(new Runnable() {
            public void run() {
                try {
                    Clip sound = AudioManager.GenerateAudioClip("ruletaF_src/audio/musica/MusicaFondo.wav");
                    sound.start();

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        });

        setTitle(title);

        setSize(Toolkit.getDefaultToolkit().getScreenSize()); //Toma el tamaño de la pantalla  de usuario
        setUndecorated(true);
        setLocationRelativeTo(null);
        Home screenHome = new Home(this, getWidth(), getHeight());
        add(screenHome);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
}