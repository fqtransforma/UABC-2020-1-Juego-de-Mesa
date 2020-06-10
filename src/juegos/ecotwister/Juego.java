package juegos.ecotwister;

import javax.swing.*;
import java.awt.*;

public class Juego extends JPanel{
    JFrame marco = new JFrame("EcoTwister");
    VisualManager vim;
    JButton ButtonJugar = new JButton("Jugar");
    JButton ButtonSalir = new JButton("Salir");
    JButton ButtonComenzar = new JButton("Comenzar");
    JButton ButtonGirar = new JButton("Girar");
    JButton ButtonTablero = new JButton("Tablero");
    JLabel etiqueta1 = new JLabel();
    JLabel etiqueta2 = new JLabel();
    JLabel etiqueta3 = new JLabel();
    JLabel etiqueta4 = new JLabel();
    JLabel etiqueta5 = new JLabel();
    JLabel etiqueta6 = new JLabel();
    public final static double DIVICION = 2*Math.PI/16;


    public Juego()
    {
       String filepath = "resources/ecotwister_src/audio/musica/musiquita.wav";
        Tablero GameTablero = new Tablero(0,0);
        Audio musica = new Audio();
        musica.Play(filepath);
        vim = new VisualManager();
        marco.getContentPane().setLayout(null);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(1200, 720);
        marco.getContentPane().setBackground(new Color(52, 185, 255));
        ButtonSalir.setBounds(1025, 550, 100, 40);
        ButtonJugar.setBounds(1025, 450, 100, 40);
        marco.add(vim);
        marco.add(ButtonSalir);
        marco.add(ButtonJugar);
        ButtonJugar.setVisible(true);
        marco.setVisible(true);
        ButtonJugar.addActionListener(e -> {
            ButtonComenzar.setBounds(1025, 350, 100, 40);
            ButtonTablero.setBounds(1025, 450, 100, 40);
            ButtonJugar.setVisible(false);
            marco.add(ButtonComenzar);
            marco.add(ButtonTablero);
            vim.setVisible(false);
            etiqueta1.setText("Reglas del juego: ");
            etiqueta1.setBounds(20,30,100,30);
            marco.add(etiqueta1);
            etiqueta2.setText("1. Crear un tapete con 6 imagenes de cada una de las 4 imágenes (ver en boton 'Tablero').");
            etiqueta2.setBounds(20,30,1100,100); // height=separacion de los labels
            marco.add(etiqueta2);
            etiqueta3.setText("2. Se necesita de un jugador que se encargue de girar la flecha del tablero " +
                    "y mencione la acción positiva que indique la flecha.");
            etiqueta3.setBounds(20,30,1100,150); //height=separacion de los labels
            marco.add(etiqueta3);
            etiqueta4.setText("3. Jugar de 2-3 personas. Todos los jugadores deben quitarse los zapatos.");
            etiqueta4.setBounds(20,30,1100,200); //height=separacion de los labels
            marco.add(etiqueta4);
            etiqueta5.setText("4. Todos los participantes deberán colocar el pie o la mano (según sea el caso) " +
                    "en el ícono correspondiente a dicha acción.");
            etiqueta5.setBounds(20,30,1100,250); //height=separacion de los labels
            marco.add(etiqueta5);
            etiqueta6.setText("5. Para iniciar, debe haber dos jugadores frente a frente, en las esquinas paralelas del tapete" +
                    " y deben colocar sus pies en la parte lateral de en medio.");
            etiqueta6.setBounds(20,30,1100,300); //height=separacion de los labels
            marco.add(etiqueta6);
            ButtonComenzar.addActionListener(event -> {
                ButtonGirar.setBounds(1025, 450, 100, 40);
                ButtonComenzar.setVisible(false);
                ButtonTablero.setVisible(false);
                marco.add(ButtonGirar);
                vim.setVisible(true);
                vim.graphicList.add(GameTablero);
                vim.repaint();
                ButtonGirar.addActionListener(ev -> {
                    int numero = (int)((Math.random() * 23) + 1);
                    if(((numero % 4) == 0) || (numero == 0)){
                        numero++;
                    }
                    for(int i = 0; i < numero ; i++){
                        GameTablero.updateFlecha(i * DIVICION);
                        vim.graphicList.add(GameTablero);
                        vim.repaint();
                        repaint();
                    }
                });
            });
            ButtonTablero.addActionListener(event -> {
                //vim.setVisible(true);
                //vim.graphicList.add(new Tapete(0, 0));
                //vim.repaint();
            });
        });

        ButtonSalir.addActionListener(e -> System.exit(1));
        repaint();
    }

    public static void run(){
        Juego m = new Juego();
    }
}
