package juegos.serpientesyescaleras;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Ventana {

    public static void Start(){
        Player p1 = new Player(700,430,"Naranja");
        Player p2 = new Player(700,450,"Morado");
        Game game=new Game(p1,p2);
        game.setBounds(0,0,800,500);

        MusicStaff music = new MusicStaff("src/resources/serpientesyescaleras_src/audio/musica/game.wav");
        music.PlayMusic();

        List<Icon> dados = new ArrayList<Icon>();
        dados.add(new ImageIcon((Ventana.class.getResource("/resources/serpientesyescaleras_src/graficos/dado.gif"))));
        dados.add(new ImageIcon((Ventana.class.getResource("/resources/serpientesyescaleras_src/graficos/1.png"))));
        dados.add(new ImageIcon((Ventana.class.getResource("/resources/serpientesyescaleras_src/graficos/2.png"))));
        dados.add(new ImageIcon((Ventana.class.getResource("/resources/serpientesyescaleras_src/graficos/3.png"))));
        dados.add(new ImageIcon((Ventana.class.getResource("/resources/serpientesyescaleras_src/graficos/4.png"))));
        dados.add(new ImageIcon((Ventana.class.getResource("/resources/serpientesyescaleras_src/graficos/5.png"))));
        dados.add(new ImageIcon((Ventana.class.getResource("/resources/serpientesyescaleras_src/graficos/6.png"))));

        JTextArea mensajes = new JTextArea();
        JScrollPane logs = new JScrollPane(mensajes);
        mensajes.append("Serpientes y Escaleras\n\n");
        mensajes.append("Turno 1: "+p1.getName()+"\n\n");

        JPanel panel = new JPanel();
        JFrame frame =new JFrame(game.TITLE);

        panel.setLayout(null);
        panel.setSize(800,500);

        //JButtons

        JButton boton1;
        JButton boton2= new JButton();
        JButton boton3= new JButton();
        JButton boton4= new JButton();

        //JTextArea
        logs.setBounds(100,500,600,75);
        mensajes.setEditable(false);
        mensajes.setAutoscrolls(true);

        //Boton 1 //Jugador 1
        boton1 = new JButton();
        boton1.setBounds(0,500,100,100);
        boton1.setIcon(dados.get(0));

        //Boton 2 //Jugador 2
        boton2.setText("[PLAYER2]");
        boton2.setBounds(700, 500, 100, 100);
        boton2.setVisible(true);

        if(p1.getX()==55 && p1.getY()==25)
        {
            mensajes.append("Felicidades Jugador: NARANJA LLEGASTE A META");
            mensajes.append(p1.META());
            game.setTurno(1);
            game.turnoCont=1;
        }

        if(p2.getX()==55 && p2.getY()==25)
        {
            mensajes.append("Felicidades Jugador: MORADO LLEGASTE A META");
            game.setTurno(0);
            game.turnoCont=1;
        }


        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == boton1 && game.getTurno()==1) {
                    int numero1 = (int) (Math.random() * 6 + 1);

                    mensajes.append("Jugador [NARANJA]" + " MUEVES: " + numero1 + "\n");
                    mensajes.append(game.msg(p1,numero1));
                    mensajes.append("Turno " + game.getTurnoCont() + ":" + p2.getName() + "\n\n");
                    game.setTurno(0);
                    game.turno_sig();
                    boton1.setIcon(dados.get(numero1));
                    boton2.setIcon(dados.get(0));

                }
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == boton2 && game.getTurno()==0) {
                    int numero2 = (int) (Math.random() * 6 + 1);
                    mensajes.append("Jugador [MORADO]" +" MUEVES: " + numero2 + "\n");
                    mensajes.append(game.msg(p2,numero2));
                    mensajes.append("Turno "+game.getTurnoCont()+":"+p1.getName()+"\n\n");

                    game.setTurno(1);
                    game.turno_sig();
                    boton2.setIcon(dados.get(numero2));
                    boton1.setIcon(dados.get(0));

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
                JOptionPane.showMessageDialog(frame,"CONTROLES\n\n" +
                        "Jugador 1: Teclas de direccion (flechas) \n\n" +
                        "Jugador 2: ASWD.\n\n");
            }
        });

        //Boton Instrucciones
        boton4.setText("REGLAS");
        boton4.setBounds(400,575,300,25);
        boton4.setVisible(true);

        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,"Reglas\n\n" +
                        "1. Cada jugador lanza por turnos el dado y avanza con su ficha tantas casillas como puntos saque.\n\n" +
                        "2. Si cae en una casilla situada al pie de las escaleras, avanza hasta el final de la misma.\n\n" +
                        "3. Si cae en la casilla ocupada por la cola de la serpiente, retrocede hasta la cabeza.\n\n" +
                        "4. Si va caer en la casilla ocupada por el otro jugador, deben intercambiar las casillas. \n\n" +
                        "5. Se debe llegar al casilla final con el puntaje justo, si no es el caso, retrocede la cantidad que sobrepasó la meta.\n");
            }
        });

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
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(null);
        game.start();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                music.stop();
                game.setRunning(false);
            }
        });
    }
}