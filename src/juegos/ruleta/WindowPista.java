package juegos.ruleta;

import javax.swing.*;
import java.awt.*;

public class WindowPista extends JPanel{
    JFrame marco = new JFrame("EcoPistas");
    Window vim;
    JButton b1 = new JButton("Pista");
    JButton b2 = new JButton("Salir");


    public WindowPista()
    {
        vim = new Window();
        marco.getContentPane().setLayout(null);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(700, 600);
        b2.setBounds(450, 400, 200, 40);
        b2.setForeground(Color.orange);
        b2.setFont(new Font("cooper black", 0,30));
        b1.setBounds(450, 100, 200, 40);
        b1.setForeground(Color.orange);
        b1.setFont(new Font("cooper black", 0,30));
        marco.add(vim);
        marco.add(b2);
        marco.add(b1);

        marco.setVisible(true);
        b1.addActionListener(e -> {
            vim.graphicList.add(new Pistas(0, 0));
            vim.repaint();
        });

        b2.addActionListener(e -> System.exit(1));
        repaint();
    }
}
