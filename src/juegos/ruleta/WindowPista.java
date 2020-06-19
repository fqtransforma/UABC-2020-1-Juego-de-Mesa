package juegos.ruleta;

import juegos.mainmenu.elementos.multimedia.Sonido;

import javax.swing.*;
import java.awt.*;

public class WindowPista extends JPanel{
    JFrame marco = new JFrame("EcoPistas");
    Window vim;
    JButton b1 = new JButton();
    JButton b2 = new JButton("Salir");
    JButton b3 = new JButton("?");


    public WindowPista()
    {
        Sonido OST = new Sonido("src/resources/ruleta_src/audio/musica/London_Bridge_instrumental.wav",true);
        vim = new Window();
        marco.getContentPane().setLayout(null);
        //marco.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //marco.setUndecorated(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(400, 680);

        b2.setBounds(0, 600, 400, 40);
        b2.setBackground(Color.RED);
        b2.setForeground(Color.orange);
        b2.setAlignmentX(Component.RIGHT_ALIGNMENT);
        b2.setFont(new Font("cooper black", 0,30));

        b1.setBounds(0, 0, 400, 600);
        b1.setForeground(Color.orange);
        b1.setFont(new Font("cooper black", 0,30));
        marco.add(vim);
        marco.add(b2);
        marco.add(b1);

        marco.setVisible(true);

        /*Boton invisible pero clickeable*/
        b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);


        b1.addActionListener(e -> {
            vim.graphicList.add(new Pistas(0, 0));
            vim.repaint();
        });

        b2.addActionListener(e -> marco.setVisible(false));
        repaint();

    }
}