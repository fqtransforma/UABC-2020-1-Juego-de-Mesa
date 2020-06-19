package juegos.serpientesyescaleras;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ventana{

    private static Game juego = new Game();
    private static Music musica = new Music("src/resources/serpientesyescaleras_src/audio/musica/game.wav");

    public static void Start(){

        JFrame ventana = new JFrame("Serpientes y Escaleras");
        ventana.setContentPane(juego);
        ventana.setSize(1040,768);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        musica.play();
        ventana.setLayout(null);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                juego.stop();
                musica.stop();
                ventana.dispose();
            }
        });
    }

}