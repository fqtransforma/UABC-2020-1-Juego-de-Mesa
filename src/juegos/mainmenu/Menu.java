package juegos.mainmenu;

import general.Objeto2D;
import general.Teclado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.lang.Character.toUpperCase;

public class Menu extends JPanel{

   public Objeto2D fondo;
    private JLabel prueba;

    public Menu() {

        prueba = new JLabel();
        setFocusable(true);
        prueba.setSize(1280,720);
        prueba.setVisible(true);

        fondo = new Objeto2D("src/kirby.jpg", 1, 1);
    }

    public void paintAux(Graphics g, int x, int y, MenuRun menuRun){
        g.drawImage(fondo.getImage(), x, y, 500, 500,  menuRun);
    }
/*
    public  void paintComponent(Graphics g){
        g.drawImage(fondo.getImage(), fondo.getX(), fondo.getY(), this);
        System.out.println(fondo.getY());
        setOpaque(false);
        super.paintComponent(g);

    }*/
}
/*
public class Menu extends JPanel implements KeyListener {

    private JLabel prueba = new JLabel("");
    public Menu(){
       // addKeyListener(this);
        setFocusable(true);
        prueba.setSize(300,300);
        prueba.setIcon(new ImageIcon("src/kirby.jpg"));
        prueba.setVisible(true);
        add(prueba);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())){
            case KeyEvent.VK_W:
                prueba.setLocation(prueba.getX(),prueba.getY()-10);
                break;
            case KeyEvent.VK_A:
                prueba.setLocation(prueba.getX()-10,prueba.getY());
                break;
            case KeyEvent.VK_S:
                prueba.setLocation(prueba.getX(),prueba.getY()+10);
                System.out.println("si");
                break;
            case KeyEvent.VK_D:
                prueba.setLocation(prueba.getX()+10,prueba.getY());
                break;
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}*/