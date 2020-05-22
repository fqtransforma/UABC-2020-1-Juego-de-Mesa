/*
 * @author Grupo de ingenieria en computacion UABC (2020)
 * Fecha: 07/05/2020
 * Descripcion: Clase de arranque del proyecto
 */
import juegos.ecotwister.Juego;
import juegos.mainmenu.*;
import juegos.ruleta.EcoPregunta;
import juegos.serpientesyescaleras.Game;
import juegos.serpientesyescaleras.MusicStaff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String args[]){
        //testMainMenu();

        testEcoTwister();
        //testResiduos();
        //testSerpientesYEscaleras();
        //testRuleta();

        //Gracias profe ya pude :D
    }

    /*
     * ESTOS METODOS SON SOLO PARA HACER PRUEBAS DE CADA MODULO
     * POR FAVOR NO PONER NADA EN EL METODO MAIN
     */
    static void testEcoTwister(){
        Juego.run();
    }

    static void testMainMenu(){
        MenuRun menu = new MenuRun();
        //menu.init();
    }


    static void testResiduos(){
        System.out.println("Nada... por ahora");
    }

    static void testRuleta(){
        EcoPregunta.run();
    }

    static void testSerpientesYEscaleras(){
        final int WIDTH = 320;
        final int HEIGHT= 240; //240
        final int SCALE=2;

        String filepath= "resources/serpientesyescaleras_src/game.wav";

        MusicStaff music=new MusicStaff();
        music.PlayMusic(filepath);

        Game game=new Game();

        //creando dimensiones
        game.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
        game.setMaximumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
        game.setMinimumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));


        JFrame frame =new JFrame(game.TITLE);
        frame.add(game,BorderLayout.NORTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        //JButtons

        JButton boton1= new JButton();
        JButton boton2= new JButton();
        JButton boton3= new JButton();


        ActionListener e = null;

        //Boton 1 //Jugador 1
        boton1.repaint();
        boton1.setText("[PLAYER1]");
        boton1.setPreferredSize(new Dimension(100,100));
        boton1.setBounds(66,20,150,50);
        boton1.setVisible(true);

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==boton1) {
                    int numero1 = (int)(Math.random()*6+1);
                    System.out.println("JUGADOR 1 MUEVES: "+numero1);}
            }
        });

        //Boton 2 //Jugador 2

        boton2.repaint();
        boton2.setText("[PLAYER2]");
        boton2.setPreferredSize(new Dimension(100,100));
        boton2.setBounds(66,20,150,50);
        boton2.setVisible(true);

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==boton1) {
                    int numero2 = (int)(Math.random()*6+1);
                    System.out.println("JUGADOR 2 MUEVES: "+numero2);}
            }
        });

        //Boton 3

        boton3.repaint();
        boton3.setText("[STAR GAME]");
        boton3.setPreferredSize(new Dimension(100,100));
        boton3.setBounds(66,20,150,50);
        boton3.setVisible(true);

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==boton3) {
                    game.start();
                    System.out.println("STARGAME");}
            }
        });

        //Botones Player 1,player 2 && stargame
        frame.add(boton1,BorderLayout.WEST);
        frame.add(boton2,BorderLayout.EAST);
        frame.add(boton3,BorderLayout.CENTER);
        frame.setSize(800,600);

        game.start();
    }
}