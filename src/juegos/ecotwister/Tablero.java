package juegos.ecotwister;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tablero extends Graficos{
    Flecha aguja = new Flecha();
    private BufferedImage img2;

    public Tablero(int x, int y) {
        super(x, y);
        try {
            img = ImageIO.read(new File("src/resources/ecotwister_src/Tablero.png"));
            //img2 = ImageIO.read(new File("src/resources/ecotwister_src/flecha2.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        int radio = Math.min(1006,524)/2;
        aguja.setParametros(512,350,radio*8/10,radio*2/15,Color.orange);

    }

    @Override
    public void draw(Graphics g) {
            g.drawImage(img, 0, 0, 1000,700, null);
            //g.drawImage(img2, 503, 312, 100,80, null);
            aguja.paint(g);
    }
}
