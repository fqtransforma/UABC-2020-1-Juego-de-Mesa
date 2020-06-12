package juegos.ruletaF;

import juegos.ruleta.Actuacion;
import juegos.ruleta.EcoPregunta;
import juegos.ruleta.SwingPaint;
import juegos.ruleta.WindowPista;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.*;
import java.lang.*;

public class RuletaGui extends JFrame{

    private JPanel panelIzquierdo;
    private JPanel panelDerecho;
    private JPanel panelCentral;
    private JPanel panelsubCentral;

    private JButton Salir;
    private JButton Jugar;
    private JButton Ayuda;
    private JButton Girar;

    private JLabel label;
    private ImageIcon labelImageP;
    private ImageIcon labelImage;
    private ImageIcon labelImage3P;

    private Random r1= new Random(System.currentTimeMillis());
    private PlayMusic fondo= new PlayMusic();
    private PlayMusic sonido1= new PlayMusic();
    private PlayMusic sonido2= new PlayMusic();
    private PlayMusic sonido3= new PlayMusic();

    private int valor;
    private int aux;

    public RuletaGui (){
        this.getContentPane().setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fondo.efectoFondo2();
        fondo.play();
        fondo.loop();
        sonido2.efectoWheel();

        panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo,BoxLayout.Y_AXIS));
        panelIzquierdo.setBackground(new Color(102, 191, 27));

        Jugar=new JButton("");
        labelImage3P = new ImageIcon("src/resources/ruletaF_src/graficos/ruletaGui/conqui.png");
        Jugar.setIcon(labelImage3P);
        Jugar.setBorder(null);
        Jugar.setBorderPainted(false);
        Jugar.setAlignmentX(Component.RIGHT_ALIGNMENT);
        Jugar.setBackground(new Color(102, 191, 27));

        panelIzquierdo.add(Box.createVerticalGlue());
        panelIzquierdo.add(Jugar);
        panelIzquierdo.add(Box.createVerticalGlue());
        this.getContentPane().add(panelIzquierdo,BorderLayout.WEST);
//////
        panelDerecho = new JPanel();
        panelDerecho.setLayout(new BoxLayout(panelDerecho,BoxLayout.Y_AXIS));
        panelDerecho.setBackground(new Color(102, 191, 27));

        Salir=new JButton("");
        labelImage3P = new ImageIcon("src/resources/ruletaF_src/graficos/ruletaGui/try5.png");
        Salir.setIcon(labelImage3P);
        Salir.setBorder(null);
        Salir.setBorderPainted(false);
        Salir.setAlignmentX(Component.RIGHT_ALIGNMENT);
        Salir.setBackground(new Color(102, 191, 27));

        Ayuda=new JButton("");
        labelImage3P = new ImageIcon("src/resources/ruletaF_src/graficos/ruletaGui/help.png");
        Ayuda.setIcon(labelImage3P);
        Ayuda.setBorder(null);
        Ayuda.setBorderPainted(false);
        Ayuda.setAlignmentX(Component.RIGHT_ALIGNMENT);
        Ayuda.setBackground(new Color(102, 191, 27));

        panelDerecho.add(Salir);
        panelDerecho.add(Box.createVerticalGlue());
        panelDerecho.add(Ayuda);

        this.getContentPane().add(panelDerecho,BorderLayout.EAST);
/////////
        panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());

        panelsubCentral=new JPanel();
        panelsubCentral.setLayout(new BoxLayout(panelsubCentral,BoxLayout.Y_AXIS));
        panelsubCentral.setBackground(new Color(102, 191, 27));

        label= new JLabel();
        labelImageP = new ImageIcon("src/resources/ruletaF_src/graficos/ruletaGui/copia1.png");
        label.setIcon(labelImageP);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        Girar=new JButton("");
        Girar.setFont(new Font("Arial",Font.CENTER_BASELINE,22));
        labelImage3P = new ImageIcon("src/resources/ruletaF_src/graficos/ruletaGui/push.png");
        Girar.setIcon(labelImage3P);
        Girar.setBorder(null);
        Girar.setBorderPainted(false);
        Girar.setAlignmentX(Component.CENTER_ALIGNMENT);
        Girar.setBackground(new Color(102, 191, 27));
        Girar.setForeground(Color.BLACK);

        panelsubCentral.add(Box.createVerticalGlue());
        panelsubCentral.add(label);
        panelsubCentral.add(Box.createVerticalGlue());
        panelsubCentral.add(Girar);

        panelCentral.add(panelsubCentral,BorderLayout.CENTER);
        this.getContentPane().add(panelCentral,BorderLayout.CENTER);
/////////////

        Salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                fondo.cerrar();
                sonido1.efectoBye();
                sonido3.efectoBotonB();
                sonido1.play();
                sonido3.play();
                sonido2.cerrar();
                dispose();
            }
        });

        Jugar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if(valor==0){
                    sonido3.efectoBotonB();
                    sonido3.play();
                    JOptionPane.showMessageDialog(null,"Necesitas girar la ruleta ");
                }else{
                    sonido3.efectoBotonB();
                    sonido3.play();
                    sonido2.cerrar();
                    fondo.cerrar();
                    switch(valor){

                        //Ruleta F
                        case 1:dispose();new JuegoBasta();break;
                        case 2:dispose(); new Juego();break;
                        case 3:dispose();new WindowApp("EcoReto");break;

                        //Ruleta A
                        case 4: dispose();new SwingPaint().show(); break;
                        case 5: dispose();new Actuacion().setVisible(true);break;
                    }
                }
            }
        });

        Ayuda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                sonido3.efectoBotonB();
                sonido3.play();
                JOptionPane.showMessageDialog(null,"Para poder jugar presiona el boton GIRAR,\nla ruleta girara y te mostrara que minijuego \npodras jugar ,despues solo presiona el boton\nJUGAR");
            }
        });

        Girar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if(aux!=0){
                    do {

                        valor = r1.nextInt(3) + 1;  //para calificar a Ruleta F

                     //   valor = r1.nextInt(5) + 1;  //para unir los juegos de equipo A

                    } while (aux == valor);
                    aux = valor;
                }else{

                    valor = r1.nextInt(3) + 1;  //para calificar a Ruleta F

                 //   valor = r1.nextInt(5) + 1;  //para unir los juegos de equipo A

                    aux=valor;
                }
                switch(valor){

                    //      Ruleta F
                    case 1: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/ruletaGui/basta3.gif");break;
                    case 2: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/ruletaGui/caricaturas3.gif");break;
                    case 3: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/ruletaGui/ecoreto3.gif");break;

                    //      Ruleta A
                    case 4: labelImage = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/dibujar.gif");break;
                    case 5: labelImage = new ImageIcon("src/resources/ruleta_src/graficos/Actuacion/actuacion.gif");break;
                }
                sonido2.efectoWheel();
                sonido2.play();
                label.setIcon(labelImage);
                label.repaint();
                label.validate();
            }
        });
    }
    public static void run(){
        JFrame interfaz = new RuletaGui();
    }
}