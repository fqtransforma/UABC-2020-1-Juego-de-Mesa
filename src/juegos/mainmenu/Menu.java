package juegos.mainmenu;

import general.Objeto2D;

import javax.swing.*;
import java.awt.*;

import static java.lang.Character.toUpperCase;

public class Menu extends JPanel {

    Objeto2D fondo;

    public Menu() {

        JLabel prueba = new JLabel();
        setFocusable(true);
        prueba.setSize(300,300);
        prueba.setVisible(true);
        add(prueba);

        fondo = new Objeto2D("src/adobado-pork.png", 0, 0);


    }

    public  void paintComponent(Graphics g){
        g.drawImage(fondo.getImage(), fondo.getX(), fondo.getY(), this);

    }


}