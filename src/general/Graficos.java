package general;

import javax.swing.*;
import java.awt.*;

public class Graficos extends JPanel {

    private JLabel prueba = new JLabel("");

    public Graficos(){
        setFocusable(true);
        prueba.setSize(300,300);
        //prueba.setIcon(new ImageIcon("src/adobado-pork.png"));
        prueba.setVisible(true);
        add(prueba);
    }
/*
    public  void paintComponent(Graphics g){
        ImageIcon a = new ImageIcon("src/adobado-pork.png");
        //a.getImage();

        g.drawImage(a.getImage(), 0, 0, this);

    }*/
}