package juegos.ruleta;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Principal extends Plano {


    public Principal(int x, int y) {
        super(x, y);
        try {
            img = ImageIO.read(new File("resources/ruleta_src/graficos/ecopista/EcopistasPrin.png"));

        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    @Override
    public void draw(Graphics g) {

        g.drawImage(img, 35, 30, 300, 500, null);

    }
}
