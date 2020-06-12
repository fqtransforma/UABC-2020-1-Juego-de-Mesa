package juegos.ruleta;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pistas extends Plano{
    private Image fondo;
    private BufferedImage img2;
    private File name;
    private int num;

    public Pistas(int x, int y) {
        super(x, y);

        num = (int)(Math.random()*25);

        if(num == 1)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-01.jpg");
        if(num == 2)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-02.jpg");
        if(num == 3)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-03.jpg");
        if(num == 4)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-04.jpg");
        if(num == 5)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-05.jpg");
        if(num == 6)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-06.jpg");
        if(num == 7)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-07.jpg");
        if(num == 8)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-08.jpg");
        if(num == 9)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-09.jpg");
        if(num == 10)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-10.jpg");
        if(num == 11)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-11.jpg");
        if(num == 12)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-12.jpg");
        if(num == 13)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-13.jpg");
        if(num == 14)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-14.jpg");
        if(num == 15)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-15.jpg");
        if(num == 16)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-16.jpg");
        if(num == 17)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-17.jpg");
        if(num == 18)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-18.jpg");
        if(num == 19)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-19.jpg");
        if(num == 20)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-20.jpg");
        if(num == 21)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-21.jpg");
        if(num == 22)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-22.jpg");
        if(num == 23)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-23.jpg");
        if(num == 24)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-24.jpg");
        if(num == 25)
            name = new File("resources/ruleta_src/graficos/ecopista/Pistas-25.jpg");

        try {
            img = ImageIO.read(name);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img,35, 30, 300, 500, null);
    }
}