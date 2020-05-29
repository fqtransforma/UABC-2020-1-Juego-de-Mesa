package juegos.serpientesyescaleras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {

    public static void Start(){
        Game game=new Game();
        game.setBounds(0,0,800,500);

        JTextArea mensajes = new JTextArea();
        JScrollPane logs = new JScrollPane(mensajes);
        JPanel panel = new JPanel();
        JFrame frame =new JFrame(game.TITLE);
        panel.setLayout(null);
        panel.setSize(800,500);

        String filepath= "src/resources/serpientesyescaleras_src/audio/musica/game.wav";
        MusicStaff music=new MusicStaff();
        music.PlayMusic(filepath);

        //JButtons

        JButton boton1= new JButton();
        JButton boton2= new JButton();
        JButton boton3= new JButton();
        JButton boton4= new JButton();

        //JTextArea
        logs.setBounds(100,500,600,75);
        mensajes.setEditable(false);
        mensajes.setAutoscrolls(true);



        //Boton 1 //Jugador 1
        boton1.setText("[PLAYER1]");
        boton1.setSize(200,200);
        boton1.setBounds(0,500,100,100);
        boton1.setVisible(true);

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==boton1) {
                    int numero1 = (int)(Math.random()*6+1);
                    mensajes.append("JUGADOR 1 MUEVES: "+numero1+"\n");
                    game.msg(numero1);
                }
            }
        });

        //Boton 2 //Jugador 2

        boton2.setText("[PLAYER2]");
        boton2.setBounds(700,500,100,100);
        boton2.setVisible(true);

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==boton2) {
                    int numero2 = (int)(Math.random()*6+1);
                    mensajes.append("JUGADOR 2 MUEVES: "+numero2+"\n");
                    game.msg(numero2);
                }
            }
        });


        //Boton Controles
        boton3.setText("CONTROLES");
        boton3.setBounds(100,575,300,25);
        boton3.setVisible(true);

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //Boton Instrucciones
        boton4.setText("INSTRUCCIONES");
        boton4.setBounds(400,575,300,25);
        boton4.setVisible(true);

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //Botones Player 1,player 2 && stargame
        panel.add(game);
        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(boton4);
        panel.add(logs);
        panel.setLayout(null);
        //panel.setSize(800,600);
        frame.setContentPane(panel);
        frame.setSize(815,640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(null);
        game.start();
    }
}
