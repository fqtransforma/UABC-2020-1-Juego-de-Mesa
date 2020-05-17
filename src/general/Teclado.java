package general;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Teclado implements KeyListener {

    private final static int numeroTeclas = 120;
    private final boolean [] teclas = new boolean[numeroTeclas];
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;

    public void actualizar(){
        arriba = teclas[KeyEvent.VK_W];
        izquierda = teclas[KeyEvent.VK_A];
        abajo = teclas[KeyEvent.VK_S];
        derecha = teclas[KeyEvent.VK_D];
    }

    @Override
    public void keyTyped(KeyEvent e) {
       /* if(e.getKeyCode() == KeyEvent.VK_DOWN)
            System.out.println("1");*/
    }

    @Override
    public void keyPressed(KeyEvent e) {

        teclas[e.getKeyCode()] = true;
        System.out.println("actualizando");
    }

    @Override
    public void keyReleased(KeyEvent e) {

        teclas[e.getKeyCode()] = false;
    }
}
