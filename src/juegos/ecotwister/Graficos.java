package juegos.ecotwister;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Graficos  {
    protected BufferedImage img;
    protected Image imgGraphic;
    protected ImageIcon icon;
    protected ImageIcon icon2;
    protected Image imgGraphic2;
    public int xCoord;
    public int yCoord;

    public Graficos(int x, int y) {
        xCoord = x;
        yCoord = y;
    }

    public void draw(Graphics g){
        if(img != null){
            g.drawImage(img, xCoord, yCoord, 30, 30, null);
        }
    }


}
