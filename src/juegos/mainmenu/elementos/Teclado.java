package juegos.mainmenu.elementos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Teclado implements KeyListener {

    private final static int numeroTeclas = 120;
    private final boolean [] teclas = new boolean[numeroTeclas];
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    public boolean enter = false;

    public void actualizar(){
        arriba = teclas[KeyEvent.VK_W];
        izquierda = teclas[KeyEvent.VK_A];
        abajo = teclas[KeyEvent.VK_S];
        derecha = teclas[KeyEvent.VK_D];
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {

        teclas[e.getKeyCode()] = true;
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
            enter = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {

        teclas[e.getKeyCode()] = false;
    }
}
