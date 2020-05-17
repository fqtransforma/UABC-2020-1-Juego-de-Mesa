package general;

import javax.swing.*;
import java.awt.*;

public class Objeto2D {

    private ImageIcon icon;
    private int x;
    private int y;

    public Objeto2D(String name, int x, int y){
        icon = new ImageIcon(name);
        this.setX(x);
        this.setY(y);
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
}
