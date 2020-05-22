package juegos.ecotwister.java.clases;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Menu extends Graficos {


    public Menu(int x, int y) {
        super(x, y);
        try {
            img = ImageIO.read(new File("src/juegos/ecotwister/java/Resources/logo2.png"));

        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    @Override
    public void draw(Graphics g) {

            g.drawImage(img, 200, 250, 600, 150, null);

    }
    }

