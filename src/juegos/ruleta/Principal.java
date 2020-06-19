package juegos.ruleta;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Principal extends Plano {


    public Principal(int x, int y) {
        super(x, y);
        try {
            img = ImageIO.read(new File("src/resources/ruleta_src/graficos/ecopista/EcopistasPrin.png"));

        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    @Override
    public void draw(Graphics g) {

        g.drawImage(img, 0, 0, 400, 600, null);

    }
}
