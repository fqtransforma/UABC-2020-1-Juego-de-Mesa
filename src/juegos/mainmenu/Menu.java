package juegos.mainmenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.lang.Character.toUpperCase;

public class Menu extends JPanel implements KeyListener {

    private JLabel prueba = new JLabel("");
    public Menu(){
        addKeyListener(this);
        setFocusable(true);
        prueba.setSize(300,300);
        prueba.setIcon(new ImageIcon("src/img/peon.png"));
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
}
