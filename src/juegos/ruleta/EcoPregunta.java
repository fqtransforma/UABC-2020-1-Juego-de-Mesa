package juegos.ruleta;
import javax.swing.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EcoPregunta extends JPanel implements ActionListener{
    private Image fondo;

    static JFrame ventana = new JFrame();

    JButton boton1;
    JButton boton2;

    static int numero;

    public static void pintar(){

        ventana.setSize(500, 550);
        numero= (int)(Math.random()*40+1);
        System.out.println(numero);
        if(numero == 1)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/1e.png"));
        if(numero == 2)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/2e.png"));
        if(numero == 3)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/3e.png"));
        if(numero == 4)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/4e.png"));
        if(numero == 5)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/5e.png"));
        if(numero == 6)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/6e.png"));
        if(numero == 7)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/7e.png"));
        if(numero == 8)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/8e.png"));
        if(numero == 9)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/9e.png"));
        if(numero == 10)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/10e.png"));
        if(numero == 11)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/11e.png"));
        if(numero == 12)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/12.png"));
        if(numero == 13)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/13.png"));
        if(numero == 14)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/14.png"));
        if(numero == 15)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/15.png"));
        if(numero == 16)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/16.png"));
        if(numero == 17)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/17.png"));
        if(numero == 18)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/18.png"));
        if(numero == 19)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/19.png"));
        if(numero == 20)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/20.png"));
        if(numero == 21)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/21.png"));
        if(numero == 22)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/22.png"));
        if(numero == 23)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/23.png"));
        if(numero == 24)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/24.png"));
        if(numero == 25)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/25.png"));
        if(numero == 26)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/26.png"));
        if(numero == 27)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/27.png"));
        if(numero == 28)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/28.png"));
        if(numero == 29)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/29.png"));
        if(numero == 30)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/30.png"));
        if(numero == 31)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/31.png"));
        if(numero == 32)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/32.png"));
        if(numero == 33)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/33.png"));
        if(numero == 34)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/34.png"));
        if(numero == 35)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/35.png"));
        if(numero == 36)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/36.png"));
        if(numero == 37)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/37.png"));
        if(numero == 38)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/38.png"));
        if(numero == 39)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/39.png"));
        if(numero == 40)
            ventana.add(new EcoPregunta("/ruleta_src/graficos/ecopregunta/40.png"));


        ventana.setTitle("Ecopreguntas");
        ventana.setVisible(true);
    }



    public EcoPregunta(String name) {

        setBackground(Color.white);
        ImageIcon fo = new ImageIcon(getClass().getResource(name));
        fondo = fo.getImage();
        boton1 = new JButton("Correcto");
        boton1.addActionListener(this);
        boton2 = new JButton("Incorrecto");
        boton2.addActionListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        boton1.setBounds(100, 250, 120, 40);
        add(boton1);
        boton2.setBounds(300,250,150,40);
        add(boton2);
    }


    public void actionPerformed( ActionEvent e)  {
        if (e.getSource() == boton1) {
            new audioEcoPregunta("/ruleta_src/audio/efectos/ecopregunta/a1.wav");
            ventana.dispose();

        }
        if(e.getSource() == boton2){
            new audioEcoPregunta("/ruleta_src/audio/efectos/ecopregunta/a2.wav");
            ventana.dispose();
        }

    }


    public static void run() {

        pintar();

    }

}


