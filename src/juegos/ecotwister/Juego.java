package juegos.ecotwister;

import javax.swing.*;
import java.awt.*;



public class Juego extends JPanel{
    JFrame marco = new JFrame("EcoTwister");
    VisualManager vim;
    JButton b1 = new JButton("Iniciar");
    JButton b2 = new JButton("Salir");


    public Juego()
    {
        String filepath = "src/resources/ecotwister_src/audio/musica/musica.wav";

        Audio musica = new Audio();
        musica.Play(filepath);

        vim = new VisualManager();
        marco.getContentPane().setLayout(null);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(1200, 720);
        marco.getContentPane().setBackground(new Color(52, 185, 255));
        b2.setBounds(1025, 550, 100, 40);
        b1.setBounds(1025, 450, 100, 40);
        marco.add(vim);
        marco.add(b2);
        marco.add(b1);

        marco.setVisible(true);
        b1.addActionListener(e -> {
            vim.graphicList.add(new Tablero(0, 0));
            vim.repaint();
        });

        b2.addActionListener(e -> System.exit(1));
        repaint();



    }

    public static void run(){
        Juego m = new Juego();
    }
}
