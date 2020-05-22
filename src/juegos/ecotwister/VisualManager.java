package juegos.ecotwister;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class VisualManager extends JPanel {

    public ArrayList<Graficos> graphicList = new ArrayList<>();
    public VisualManager()
    {

        setSize(1000,720);
        setBackground(Color.white);

        graphicList.add(new Menu(0,0));

        repaint();


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Graficos graphic : graphicList){
            graphic.draw(g);
        }
        

    }
}
