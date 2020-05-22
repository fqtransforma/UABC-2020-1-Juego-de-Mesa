package juegos.ecotwister;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Menu extends Graficos {


    public Menu(int x, int y) {
        super(x, y);
        try {
            img = ImageIO.read(new File("src/resources/ecotwister_src/logo1.png"));

        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    @Override
    public void draw(Graphics g) {

            g.drawImage(img, 200, 250, 600, 150, null);

    }
    }

