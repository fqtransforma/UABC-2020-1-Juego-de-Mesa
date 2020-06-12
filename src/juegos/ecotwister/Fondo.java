package juegos.ecotwister;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Fondo extends Graficos {
    public Fondo(int x, int y) {
        super(x, y);
        try {
            img = ImageIO.read(new File("src/resources/ecotwister_src/fondo.PNG"));

        } catch (IOException e) {

            System.out.println("Error");
        }

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, 0, 0, 1000, 700, null);
    }
}
