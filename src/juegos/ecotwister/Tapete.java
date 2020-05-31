package juegos.ecotwister;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Tapete extends Graficos {
    public Tapete(int x, int y) {
        super(x, y);
        try {
            img = ImageIO.read(new File("src/resources/ecotwister_src/tapete-eco-twister-02.jpg"));

        } catch (IOException e) {

            System.out.println("Error");
        }

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, 0, 0, 1000,700, null);
    }
}
