package juegos.mainmenu.elementos.visuales;

import javax.swing.*;
import java.awt.*;

public class Objeto2D {

    private ImageIcon icon;
    private int x;
    private int y;
    private int sizex;
    private int sizey;

    public Objeto2D(String name, int x, int y){
        icon = new ImageIcon(name);
        this.setX(x);
        this.setY(y);
    }

    public Objeto2D(String name, int x, int y, int sizex, int sizey){
        icon = new ImageIcon(name);
        this.setX(x);
        this.setY(y);
        this.setSizex(sizex);
        this.setSizey(sizey);
    }

    public Image getImage(){
        return icon.getImage();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSizex() {
        return sizex;
    }

    public void setSizex(int sizex) {
        this.sizex = sizex;
    }

    public int getSizey() {
        return sizey;
    }

    public void setSizey(int sizey) {
        this.sizey = sizey;
    }
}
