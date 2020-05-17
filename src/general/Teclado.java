package general;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.lang.Character.LETTER_NUMBER;
import static java.lang.Character.toUpperCase;

public class Teclado implements KeyListener {

    private boolean UP = false;
    private boolean DOWN = false;
    private boolean LEFT = false;
    private boolean RIGHT = false;

    @Override
    public void keyTyped(KeyEvent e) {

        switch (toUpperCase(e.getKeyChar())) {
            /*
            case KeyEvent.VK_W:
                //prueba.setLocation(prueba.getX(),prueba.getY()-10);
                break;
            case KeyEvent.VK_A:
                //prueba.setLocation(prueba.getX()-10,prueba.getY());
                break;
            case KeyEvent.VK_S:
                //prueba.setLocation(prueba.getX(),prueba.getY()+10);
                break;
            case KeyEvent.VK_D:
                //prueba.setLocation(prueba.getX()+10,prueba.getY());
                break;
                */
            case KeyEvent.VK_DOWN:
                DOWN = true;
                break;

            case KeyEvent.VK_UP:
                UP = true;
                break;

            case KeyEvent.VK_RIGHT:
                RIGHT = true;
                break;

            case KeyEvent.VK_LEFT:
                LEFT = true;
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public boolean isUP() {
        boolean res = UP;
        UP = false;

        return res;
    }

    public boolean isDOWN() {
        boolean res = DOWN;
        DOWN = false;

        return res;
    }

    public boolean isLEFT() {
        boolean res = LEFT;
        LEFT = false;

        return res;
    }

    public boolean isRIGHT() {
        boolean res = RIGHT;
        RIGHT = false;

        return res;
    }
}
