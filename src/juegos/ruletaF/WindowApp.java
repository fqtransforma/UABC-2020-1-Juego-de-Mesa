package juegos.ruletaF;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class WindowApp extends JFrame {


    public WindowApp(String title)  {


        setTitle(title);

        setSize(Toolkit.getDefaultToolkit().getScreenSize()); //Toma el tamaño de la pantalla  de usuario
        setUndecorated(true);
        setLocationRelativeTo(null);
        Home screenHome = new Home(this, getWidth(), getHeight());
        add(screenHome);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }
}