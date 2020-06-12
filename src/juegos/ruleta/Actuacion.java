package juegos.ruleta;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.lang.*;

public class Actuacion extends JFrame{

    public JPanel panel = new JPanel();
    public JButton botonCorrecto = new JButton("Correcto");
    public JButton botonIncorrecto = new JButton("Incorrecto");
   // public JButton iniciarTime = new JButton("Iniciar");
   // public JLabel time = new JLabel("00");
    //private Random r1= new Random(System.currentTimeMillis());
   // private boolean cronometro;
    static int numero;
    //private Thread hilo;


    public Actuacion(){
        this.setSize(500,640);
        this.setLocationRelativeTo(null);
        setTitle("Actuacion");//titulo del juego

        IniciarComponentes();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void IniciarComponentes(){
        this.getContentPane().add(panel);
        //poner la imagen en el panel
        numero= (int)(Math.random()*16+1);
        //System.out.println(" "+numero);
        if (numero == 1){
            ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Actuacion/Actuacion1.png");
            JLabel imagen1 = new JLabel();//creo la etiqueta
            imagen1.setBounds(0,10,500,550);
            //aqui estoy redimensionando la imagen, para que quepa en el panel
            imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
            panel.add(imagen1);
        }
        if (numero == 2){
            ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Actuacion/Actuacion2.png");
            JLabel imagen1 = new JLabel();//creo la etiqueta
            imagen1.setBounds(0,10,500,550);
            //aqui estoy redimensionando la imagen, para que quepa en el panel
            imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
            panel.add(imagen1);
        }
        if (numero == 3){
            ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Actuacion/Actuacion3.png");
            JLabel imagen1 = new JLabel();//creo la etiqueta
            imagen1.setBounds(0,10,500,550);
            //aqui estoy redimensionando la imagen, para que quepa en el panel
            imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
            panel.add(imagen1);
        }
        if (numero == 4){
            ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Actuacion/Actuacion4.png");
            JLabel imagen1 = new JLabel();//creo la etiqueta
            imagen1.setBounds(0,10,500,550);
            //aqui estoy redimensionando la imagen, para que quepa en el panel
            imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
            panel.add(imagen1);
        }
        if (numero == 5){
            ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Actuacion/Actuacion5.png");
            JLabel imagen1 = new JLabel();//creo la etiqueta
            imagen1.setBounds(0,10,500,550);
            //aqui estoy redimensionando la imagen, para que quepa en el panel
            imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
            panel.add(imagen1);
        }
        if (numero == 6){
            ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Actuacion/Actuacion6.png");
            JLabel imagen1 = new JLabel();//creo la etiqueta
            imagen1.setBounds(0,10,500,550);
            //aqui estoy redimensionando la imagen, para que quepa en el panel
            imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
            panel.add(imagen1);
        }
        if (numero == 7){
            ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Actuacion/Actuacion7.png");
            JLabel imagen1 = new JLabel();//creo la etiqueta
            imagen1.setBounds(0,0,500,550);
            //aqui estoy redimensionando la imagen, para que quepa en el panel
            imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
            panel.add(imagen1);
        }
        if (numero == 8){
            ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Actuacion/Actuacion8.png");
            JLabel imagen1 = new JLabel();//creo la etiqueta
            imagen1.setBounds(0,10,500,550);
            //aqui estoy redimensionando la imagen, para que quepa en el panel
            imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
            panel.add(imagen1);
        }
        if (numero == 9){
            ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Actuacion/Actuacion9.png");
            JLabel imagen1 = new JLabel();//creo la etiqueta
            imagen1.setBounds(0,0,500,550);
            //aqui estoy redimensionando la imagen, para que quepa en el panel
            imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
            panel.add(imagen1);
        }
        if (numero == 10){
            ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Actuacion/Actuacion10.png");
            JLabel imagen1 = new JLabel();//creo la etiqueta
            imagen1.setBounds(0,10,500,550);
            //aqui estoy redimensionando la imagen, para que quepa en el panel
            imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
            panel.add(imagen1);
        }
        if (numero == 11){
            ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Actuacion/Actuacion11.png");
            JLabel imagen1 = new JLabel();//creo la etiqueta
            imagen1.setBounds(0,10,500,550);
            //aqui estoy redimensionando la imagen, para que quepa en el panel
            imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
            panel.add(imagen1);
        }
        if (numero == 12){
            ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Actuacion/Actuacion12.png");
            JLabel imagen1 = new JLabel();//creo la etiqueta
            imagen1.setBounds(0,10,500,550);
            //aqui estoy redimensionando la imagen, para que quepa en el panel
            imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
            panel.add(imagen1);
        }
        if (numero == 13){
            ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Actuacion/Actuacion13.png");
            JLabel imagen1 = new JLabel();//creo la etiqueta
            imagen1.setBounds(0,10,500,550);
            //aqui estoy redimensionando la imagen, para que quepa en el panel
            imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
            panel.add(imagen1);
        }
        if (numero == 14){
            ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Actuacion/Actuacion14.png");
            JLabel imagen1 = new JLabel();//creo la etiqueta
            imagen1.setBounds(0,10,500,550);
            //aqui estoy redimensionando la imagen, para que quepa en el panel
            imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
            panel.add(imagen1);
        }
        if (numero == 15){
            ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Actuacion/Actuacion15.png");
            JLabel imagen1 = new JLabel();//creo la etiqueta
            imagen1.setBounds(0,10,500,550);
            //aqui estoy redimensionando la imagen, para que quepa en el panel
            imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
            panel.add(imagen1);
        }
        if (numero == 16){
            ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Actuacion/Actuacion16.png");
            JLabel imagen1 = new JLabel();//creo la etiqueta
            imagen1.setBounds(0,10,500,550);
            //aqui estoy redimensionando la imagen, para que quepa en el panel
            imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
            panel.add(imagen1);
        }
        colocarBotones();
    }
    private void colocarBotones(){
        botonCorrecto.setBounds(100,400,100,40);
        botonCorrecto.setFont(new Font("comic san",Font.BOLD,16));
        botonIncorrecto.setBounds(400,400,100,40);
        botonIncorrecto.setFont(new Font("comic san",Font.BOLD,16));
       // iniciarTime.setBounds(0,0,200,40);
        //iniciarTime.setFont(new Font("cooper black",0,20));
       // time.setFont( new Font( "cooper black", Font.BOLD, 40) );
       // time.setHorizontalAlignment( JLabel.CENTER );
      //  time.setBackground( Color.CYAN);
      //  panel.add(time);
       // panel.add(iniciarTime);
        panel.add(botonCorrecto);
        panel.add(botonIncorrecto);


    }
    public void actionPerformed( ActionEvent e)  {
        if (e.getSource() == botonCorrecto) {
            new audioEcoPregunta("src/resources/ruleta_src/audio/efectos/ecopregunta/a1.wav");

        }
        if(e.getSource() == botonIncorrecto){
            new audioEcoPregunta("src/resources/ruleta_src/audio/efectos/ecopregunta/a2.wav");
        }

    }

    public static void Iniciar() {
        new Actuacion();
    }



}
