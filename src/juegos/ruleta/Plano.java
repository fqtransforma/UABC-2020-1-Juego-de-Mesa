package juegos.ruleta;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Plano  {
    protected BufferedImage img;
    protected Image imgGraphic;
    protected ImageIcon icon;
    protected ImageIcon icon2;
    protected Image imgGraphic2;
    public int xCoord;
    public int yCoord;

    public Plano(int x, int y) {
        xCoord = x;
        yCoord = y;
    }

    public void draw(Graphics g){
        if(img != null){
            g.drawImage(img, xCoord, yCoord, 30, 30, null);
        }
    }

}