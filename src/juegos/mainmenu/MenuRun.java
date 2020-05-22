/*
 * Autores Equipo D:
 *          Crisantos Uscanga Luis Alberto
 *          Cruz Sanchez Miriam
 *          Guerra Cervantes Sergio
 *          Soto Elenes Brian Ramiro
 *
 * Fecha: 07/05/2020
 * Descripcion: Clase que contiene lo necesario para que el menu corra
 */

package juegos.mainmenu;

import general.Objeto2D;
import general.Teclado;

import javax.swing.*;
import java.awt.*;

public class MenuRun extends  JPanel implements Runnable{

    private static final long serialVersionUID = 1L;

    static Teclado teclado;
    static JFrame frame;

    Objeto2D fondo = new Objeto2D("src/resources/mainmenu_src/graficos/Fondo.png", -6400/2 + 640, -3600/2 + 360, 1280, 720);
    Objeto2D personaje = new Objeto2D("src/resources/mainmenu_src/graficos/EcoMono.png", 640, 360);
    Objeto2D fondo1 = new Objeto2D("src/resources/mainmenu_src/graficos/primeraPantalla.png",0 ,-0, 1280, 720);
    Menu menu;

    private static volatile boolean onOff;
    private double fps = 0;
    private double aps = 0;

    public static Thread hilo;

    public MenuRun() {
        setPreferredSize(new Dimension(1280,720));

        frame = new JFrame();

        teclado = new Teclado();

        frame.addKeyListener(teclado);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Juego de Mesa -");
        boolean salir = false;
        JOptionPane jp = new JOptionPane();
        String name;
        do{
            name = jp.showInputDialog(frame, "¿Cual es un nombre?");
        }while(name == null);
        frame.setTitle("Juego de Mesa - Usuario:"+name);


    }
    @Override
    public void run() {
        final int nanos = 1000000000;
        final int nanoOb = 60;

        final double nanosAps = nanos/nanoOb;

        long refAct = System.nanoTime();
        long contador = System.nanoTime();

        double tiempo;
        double delta = 0;

        while(onOff) {

            final long bucle = System.nanoTime();

            tiempo = bucle - refAct;
            refAct = bucle;

            delta+= tiempo/nanosAps;

            while(delta >= 1) {
                actualizar();
                delta--;
            }

            mostrar();

            if(System.nanoTime() - contador > nanos) {

                fps = 0;
                aps = 0;

                contador = System.nanoTime();
            }
        }
    }

    private void mostrar() {
        fps++;
    }

    private void actualizar() {

        teclado.actualizar();

        if(teclado.abajo){
            fondo.setY(fondo.getY()-1);
        }
        else
            if(teclado.arriba)
                fondo.setY(fondo.getY()+1);
            else
                if(teclado.derecha)
                    fondo.setX(fondo.getX()-1);
                else
                    if(teclado.izquierda)
                        fondo.setX(fondo.getX()+1);


        aps++;
    }

    public synchronized void init() {

        onOff = true;
        hilo = new Thread(this, "Name");

        hilo.start();

    }

    private synchronized void end() {

        onOff = false;

        try {
            hilo.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void paintComponent(Graphics g){
        this.repaint();
        actualizar();
       if(teclado.enter == true){
           g.drawImage(fondo.getImage(), fondo.getX(), fondo.getY(), fondo.getSizex()*5, fondo.getSizey()*5, this);
           g.drawImage(personaje.getImage(), personaje.getX(), personaje.getY(), this);
       }
       else
           if(teclado.enter == false){
               g.drawImage(fondo1.getImage(), fondo1.getX(), fondo1.getY(), fondo1.getSizex(), fondo1.getSizey(), this);
           }


        setOpaque(false);
        super.paintComponent(g);

    }

}
/*
public class MenuRun {
    public MenuRun() {
        JFrame frame = new JFrame("Menu");
        frame.setSize(1280,720);
        frame.add(new Prueba());
        frame.add(new Menu());
        //frame.addKeyListener(teclado);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3); //EoC
    }
}*/
