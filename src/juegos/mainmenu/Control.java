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
import juegos.mainmenu.elementos.multimedia.Sonido;
import juegos.mainmenu.elementos.Teclado;
import juegos.ecotwister.Juego;
import juegos.mainmenu.elementos.visuales.Objeto2D;
import juegos.ruletaF.RuletaGui;
import juegos.serpientesyescaleras.Ventana;

import javax.swing.*;


public class Control extends JPanel implements Runnable{


    public static Sonido OST = new Sonido("src/resources/mainmenu_src/audio/musica/TownTheme.wav",true);
    public static Sonido selectSound = new Sonido("src/resources/mainmenu_src/audio/efectos/gmae.wav",false);
    public Teclado teclado;
    public Objeto2D fondo;
    boolean creditos=false;
    boolean clasifica=false;

    private static volatile boolean onOff;
    private double fps = 0;
    private double aps = 0;

    public static Thread hilo;

    public Control(Objeto2D fondo) {
        this.fondo= fondo;
        teclado = new Teclado();
        OST.play();
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

    public void actualizar() {

        teclado.actualizar();

        if (teclado.abajo && fondo.getY() > -620) {
            fondo.setY(fondo.getY() - 1);
            System.out.println("X:" + fondo.getX() + " Y:" + fondo.getY());
        } else if (teclado.arriba && fondo.getY() < -530) {
            fondo.setY(fondo.getY() + 1);
            System.out.println("X:" + fondo.getX() + " Y:" + fondo.getY());

        } else if (teclado.derecha && fondo.getX() > -2550) {
            fondo.setX(fondo.getX() - 1);
            System.out.println("X:" + fondo.getX() + " Y:" + fondo.getY());
        } else if (teclado.izquierda && fondo.getX() < 0) {
            System.out.println("X:" + fondo.getX() + " Y:" + fondo.getY());
            fondo.setX(fondo.getX() + 1);

        } else if (teclado.enter) {
            menu(-fondo.getX(), -fondo.getY());
        }
        aps++;
    }

    public void menu(int coorX, int coorY){
        if(coorY >= 530 && coorY <= 550){
            if(coorX > 345 && coorX < 600) {
                selectSound.restart();
                //Juego.run();
                OST.pause();
            }
            else if(coorX > 760 && coorX < 1020) {
                selectSound.restart();
                RuletaGui.run();
                OST.pause();
            }
            else if(coorX > 1170 && coorX < 1420) {
                selectSound.restart();
                if(!creditos){
                    creditos=true;
                    JOptionPane.showMessageDialog(null,"Este proyecto fue posible gracias a la participación de: \n1 Bastida Gastelum Axel Fernando \n2 Gaytan Carballo Melissa \n3 Rodriguez Gonzalez Enola Carely \n4 Preciado Gudiño Guillermina Alejandra \n5 Cruz Terrazas Claudia Araceli \n6 Perez Luna Maria Del Carmen \n7 Rojero Martinez Jezreel Antonio \n8 Corrales Quintero Erick Roberto \n9 Cota Robledo Benjamin \n10 Rocha Castro Jacinto \n11 Crisantos Uscanga Luis Alberto \n12 Cruz Sanchez Miriam Fernanda \n13 Guerra Cervantes Sergio Enrique \n14 Soto Elenes Brian Ramiro \n15 Espinoza Andrade Angel Fernando \n16 Hong Lang Haolin \n17 Jimenez Bustillos Angel \n18 Vazquez Colin Antonio Guadalupe \n19 Losoya Gutierrez Luis Fernando \n20 Navarrete Solano Cristian Osbaldo\nEn conjunto con Fundacion Que Transforma");
                }
            }
            else if(coorX > 1570 && coorX < 1815) {
                selectSound.restart();
                if(!clasifica){
                    clasifica=true;
                    JOptionPane.showMessageDialog(null, "Trabajo en proceso :(");
                }
                OST.pause();
            }
            else if(coorX > 2035 && coorX < 2250) {
                selectSound.restart();
                Ventana.Start();
                OST.pause();
            }
        }
        teclado.enter = false;
        creditos = false;
        OST.play();

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


}
