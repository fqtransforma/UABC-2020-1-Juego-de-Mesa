package juegos.ruletaF;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.*;			// para random


public class Juego extends JFrame{

    private JPanel panelArriba;
    private JPanel panelCentral;
    private JPanel panelIzquierdo;
    private JPanel panelIzquierdoarriba;
    private JPanel panelIzquierdoabajo;
    private JPanel panelDerecho;
    private JPanel panelDerechoarriba;
    private JPanel panelDerechoabajo;

    private JLabel label;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;

    private ImageIcon labelImageP;
    private ImageIcon labelImage2P;
    private ImageIcon labelImage3P;
    private ImageIcon labelImage4P;

    private JButton Regresar;

    public PlayMusic MCaricaturas = new PlayMusic();



    public Juego (){

        super("Juego");
        this.getContentPane().setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //////
        MCaricaturas.MFCaricaturas();
        MCaricaturas.play();



        /////
        panelArriba = new JPanel();
        panelArriba.setLayout(new BoxLayout(panelArriba,BoxLayout.X_AXIS));

        Regresar = new JButton("Regresar");
        Regresar.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        Regresar.setBackground(new Color(187,179,175));
        Regresar.setForeground(Color.BLACK);

        panelArriba.add(Regresar);
        panelArriba.add(Box.createHorizontalGlue());

        panelArriba.setBackground(new Color(114,217,224));
        this.getContentPane().add(panelArriba,BorderLayout.NORTH);
/////////
        panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(1,2));
        panelIzquierdo =  new JPanel();
        panelIzquierdo.setLayout(new BorderLayout());

        panelIzquierdoarriba= new JPanel();
        panelIzquierdoarriba.setLayout(new GridLayout(3,3));
        JButton[][] buttons = new JButton[3][3];
        for (int i=0; i < buttons.length; i++) {
            for (int j=0; j < buttons[i].length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBackground(new Color(19,173,173));
                panelIzquierdoarriba.add(buttons[i][j]);
                ImageIcon icono1 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Caricaturas.PNG");
                buttons[i][j].setIcon(icono1);
            }
        }
        panelIzquierdo.add(panelIzquierdoarriba,BorderLayout.CENTER);

        panelIzquierdoabajo= new JPanel();
        panelIzquierdoabajo.setLayout(new BoxLayout(panelIzquierdoabajo,BoxLayout.X_AXIS));
        panelIzquierdoabajo.setBackground(new Color(65,65,67));

        label=new JLabel();
        labelImageP = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Escoje.png");
        label.setIcon(labelImageP);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelIzquierdoabajo.add(Box.createHorizontalGlue());
        panelIzquierdoabajo.add(label);
        panelIzquierdoabajo.add(Box.createHorizontalGlue());
        panelIzquierdo.add(panelIzquierdoabajo,BorderLayout.SOUTH);

        panelCentral.add(panelIzquierdo);
//////////////
        panelDerecho =  new JPanel();
        panelDerecho.setLayout(new BorderLayout());

        panelDerechoarriba= new JPanel();
        panelDerechoarriba.setLayout(new BoxLayout(panelDerechoarriba,BoxLayout.Y_AXIS));
        panelDerechoarriba.setBackground(new Color(110,211,223));

        label2=new JLabel();
        labelImage2P = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/fondoArriba.jpg");
        label2.setIcon(labelImage2P);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);

        label3=new JLabel();
        labelImage3P = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/fondoAbajo.jpg");
        label3.setIcon(labelImage3P);
        label3.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelDerechoarriba.add(label2);
        panelDerechoarriba.add(Box.createVerticalGlue());
        panelDerechoarriba.add(label3);

        panelDerecho.add(panelDerechoarriba,BorderLayout.CENTER);

        panelDerechoabajo= new JPanel();
        panelDerechoabajo.setLayout(new BoxLayout(panelDerechoabajo,BoxLayout.X_AXIS));
        panelDerechoabajo.setBackground(new Color(65,65,67));

        label4=new JLabel();
        labelImage4P = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/carretera.png");
        label4.setIcon(labelImage4P);
        label4.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelDerechoabajo.add(Box.createHorizontalGlue());
        panelDerechoabajo.add(label4);
        panelDerechoabajo.add(Box.createHorizontalGlue());
        panelDerecho.add(panelDerechoabajo,BorderLayout.SOUTH);

        panelCentral.add(panelDerecho);
        this.getContentPane().add(panelCentral,BorderLayout.CENTER);

        Regresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                dispose();new RuletaGui();
                MCaricaturas.cerrar();
            }
        });

        buttons[0][0].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){

                SeresVivos seres1 = new SeresVivos();
                seres1.Seres();

            }
        });
        ////
        buttons[0][1].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                Animales animal1 = new Animales();
                animal1.Animal();
            }
        });
        ////
        buttons[0][2].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                Minerales mineral = new Minerales();
                mineral.Mineral();

            }
        });
        ////
        buttons[1][0].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                RecursosNat recurso = new RecursosNat();
                recurso.Recursos();

            }
        });
        ////
        buttons[1][1].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                RecursosNoRenov recurso = new RecursosNoRenov();
                recurso.NoRenovable();

            }
        });
        ////
        buttons[1][2].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                RecursosOrg recurso=new RecursosOrg();
                recurso.Organico();

            }
        });
        ////
        buttons[2][0].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                RecursosRenov recurso=new RecursosRenov();
                recurso.Renovable();

            }
        });
        ////
        buttons[2][1].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                SeresNoVivos seres =new SeresNoVivos();
                seres.NoVivo();

            }
        });
        ////
        buttons[2][2].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                Plantas planta = new Plantas();
                planta.Planta();

            }
        });

    }//fin constructor

}//fin clase