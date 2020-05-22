package juegos.ecotwister.java.clases;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tablero extends Graficos{

private BufferedImage img2;
    public Tablero(int x, int y) {
        super(x, y);
        try {
            img = ImageIO.read(new File("src/juegos/ecotwister/java/Resources/Tablero.png"));
            img2 = ImageIO.read(new File("src/juegos/ecotwister/java/Resources/flecha2.png"));

        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    @Override
    public void draw(Graphics g) {
            g.drawImage(img, 0, 0, 1000,700, null);
            g.drawImage(img2, 505, 318, 85,65, null);
    }
}