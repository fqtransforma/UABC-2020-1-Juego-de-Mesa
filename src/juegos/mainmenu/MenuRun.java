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
import general.Sonido;
import general.Teclado;
import juegos.ecotwister.Juego;
import juegos.ruleta.EcoPregunta;
import juegos.ruletaF.RuletaGui;
import juegos.serpientesyescaleras.Game;
import juegos.serpientesyescaleras.Ventana;

import javax.swing.*;
import java.awt.*;

public class MenuRun extends  JPanel implements Runnable{

    static Teclado teclado;
    static JFrame frame;
    //agregado
    Objeto2D fondo = new Objeto2D("src/resources/mainmenu_src/graficos/Fondo.png", -90, -550, 1280, 720);
    Objeto2D personaje = new Objeto2D("src/resources/mainmenu_src/graficos/EcoMono.png", 640, 360);
    Objeto2D fondo1 = new Objeto2D("src/resources/mainmenu_src/graficos/primeraPantalla.png",0 ,0, 1280, 720);

    public static Sonido OST = new Sonido("src/resources/mainmenu_src/audio/musica/TownTheme.wav",true);
    public static Sonido selectSound = new Sonido("src/resources/mainmenu_src/audio/efectos/gmae.wav",false);

    boolean sesion=false;

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
        OST.play();
        /*
        JOptionPane jp = new JOptionPane();
        String name;
        do{
            name = jp.showInputDialog(frame, "¿Cual es un nombre?");
        }while(name == null);
        frame.setTitle("Juego de Mesa - Usuario:"+name);*/
        sesion=true;
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
            if(this.isFocusOwner()){
                OST.play();
            }
        }
    }

    private void mostrar() {
        fps++;
    }

    private void actualizar() {

        teclado.actualizar();

        if(teclado.abajo && fondo.getY() > -620){
            fondo.setY(fondo.getY()-1);
            System.out.println("X:"+fondo.getX()+" Y:"+fondo.getY());
        }
        else if(teclado.arriba && fondo.getY() < -530){
            fondo.setY(fondo.getY()+1);
            System.out.println("X:"+fondo.getX()+" Y:"+fondo.getY());

        }
        else if(teclado.derecha && fondo.getX() > -2550){
            fondo.setX(fondo.getX()-1);
            System.out.println("X:"+fondo.getX()+" Y:"+fondo.getY());
        }
        else if(teclado.izquierda && fondo.getX() < 0){
            System.out.println("X:"+fondo.getX()+" Y:"+fondo.getY());
            fondo.setX(fondo.getX()+1);

        } else if(teclado.enter){
            menu(-fondo.getX(),-fondo.getY());
        }
        aps++;
    }

    private void menu(int coorX, int coorY){
        if(coorY >= 530 && coorY <= 550){
            if(coorX > 345 && coorX < 600) {
                selectSound.restart();
                Juego.run();
                OST.pause();
            }
            else if(coorX > 760 && coorX < 1020) {
                selectSound.restart();
                EcoPregunta.run();
                OST.pause();
            }
            else if(coorX > 1170 && coorX < 1420) {
                selectSound.restart();
                RuletaGui.run();
                OST.pause();
            }
            else if(coorX > 1570 && coorX < 1815){
                selectSound.restart();
                System.out.println("Aqui va lo de clasificacion");
                OST.pause();
            }
            else if(coorX > 2035 && coorX < 2250) {
                selectSound.restart();
                Ventana.Start();
                OST.pause();
            }
        }
        teclado.enter = false;

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

    public void paintComponent(Graphics g){
        this.repaint();
        actualizar();
        if(sesion){
            g.drawImage(fondo.getImage(), fondo.getX(), fondo.getY(), fondo.getSizex()*3, fondo.getSizey()*3, this);
            g.drawImage(personaje.getImage(), personaje.getX(), personaje.getY(), this);
        }
        else
            g.drawImage(fondo1.getImage(), fondo1.getX(), fondo1.getY(), fondo1.getSizex(), fondo1.getSizey(), this);
        setOpaque(false);
        super.paintComponent(g);

    }
}
