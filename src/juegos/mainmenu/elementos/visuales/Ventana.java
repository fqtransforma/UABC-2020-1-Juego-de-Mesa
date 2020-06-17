package juegos.mainmenu.elementos.visuales;

import juegos.mainmenu.Control;
import javax.swing.*;
import java.awt.*;

public class Ventana extends JPanel {
    public Control controles;
    static JFrame frame;
    private double aps = 0;
    //agregado
    Objeto2D fondo = new Objeto2D("src/resources/mainmenu_src/graficos/Fondo.png", -90, -550, 1280, 720);
    Objeto2D personaje = new Objeto2D("src/resources/mainmenu_src/graficos/EcoMono.png", 640, 360);
    //Objeto2D fondo1 = new Objeto2D("src/resources/mainmenu_src/graficos/primeraPantalla.png", 0, 0, 1280, 720);


    public Ventana() {
        setPreferredSize(new Dimension(1280, 720));
        controles = new Control(fondo);
        frame = new JFrame();

        frame.addKeyListener(controles.teclado);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Juego de Mesa -");
    }

    public void paintComponent(Graphics g){
        this.repaint();
        controles.actualizar();
        g.drawImage(fondo.getImage(), fondo.getX(), fondo.getY(), fondo.getSizex()*3, fondo.getSizey()*3, this);
        g.drawImage(personaje.getImage(), personaje.getX(), personaje.getY(), this);
        setOpaque(false);
        super.paintComponent(g);

    }

  public void init(){
        controles.run();
  }

}
