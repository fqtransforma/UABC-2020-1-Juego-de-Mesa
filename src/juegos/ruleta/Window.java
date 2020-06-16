package juegos.ruleta;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Window extends JPanel {

    public ArrayList<Plano> graphicList = new ArrayList<>();
    public Window()
    {
        // Sonido OST = new Sonido("src/resources/mainmenu_src/audio/musica/London_Bridge_instrumental.wav",true);

        setSize(700,600);

        graphicList.add(new Principal(0,0));

        repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Plano graphic : graphicList){
            graphic.draw(g);
        }


    }
}
