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

    private JPanel panelAbajo;

    private JPanel panelIzquierdo;
    private JPanel panelIzquierdoarriba;
    private JPanel panelIzquierdoabajo;
    private JPanel panelDerecho;
    private JPanel panelDerechoarriba;
    private JPanel panelDerechoabajo;
    private JPanel panelCentral;
    private JLabel label;
    private JLabel label2;
    private JLabel label3;

    private ImageIcon labelImageP;
    private ImageIcon labelImage2P;
    private ImageIcon labelImage3P;

    private JButton Regresar;
    public Juego (){
        super("Juego");
        this.getContentPane().setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
//////////////////////////////////////////////////////////////////////////////////////////
        panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(1,2));
        //setContentPane(new JLabel(new ImageIcon("src/main/resources/fondoCaricaturas.jpg")));
        panelIzquierdo =  new JPanel();
        //panelIzquierdo.setLayout(new GridLayout(2,1));
        panelIzquierdo.setLayout(new BorderLayout());

        panelIzquierdoarriba= new JPanel();
        panelIzquierdoarriba.setLayout(new GridLayout(3,3));
        JButton[][] buttons = new JButton[3][3];
        for (int i=0; i < buttons.length; i++) {
            for (int j=0; j < buttons[i].length; j++) {
                buttons[i][j] = new JButton("Button [" + i + "][" + j + "]");
                panelIzquierdoarriba.add(buttons[i][j]);
            }
        }
        //panelIzquierdo.add(panelIzquierdoarriba);
        panelIzquierdo.add(panelIzquierdoarriba,BorderLayout.CENTER);


        panelIzquierdoabajo= new JPanel();
        panelIzquierdoabajo.setLayout(new BoxLayout(panelIzquierdoabajo,BoxLayout.X_AXIS));

        label2=new JLabel();
        labelImage2P = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/escoge.png");
        label2.setIcon(labelImage2P);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelIzquierdoabajo.add(label2);
        panelIzquierdo.add(panelIzquierdoabajo,BorderLayout.SOUTH);

        panelCentral.add(panelIzquierdo);

//////////////
        panelDerecho =  new JPanel();
        //panelDerecho.setLayout(new GridLayout(2,1));
        panelDerecho.setLayout(new BorderLayout());

        panelDerechoarriba= new JPanel();
        panelDerechoarriba.setBackground(new Color(114,217,224));

        label=new JLabel();

        label.setIcon(new ImageIcon(new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/fondoCaricaturas.jpg").getImage().getScaledInstance(800,900, Image.SCALE_SMOOTH)));
        panelDerechoarriba.add(label);
        panelDerecho.add(panelDerechoarriba,BorderLayout.CENTER);


        panelDerechoabajo= new JPanel();
        panelDerechoabajo.setLayout(new BoxLayout(panelDerechoabajo,BoxLayout.X_AXIS));

        label2=new JLabel();
        labelImage2P = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/carretera.png");
        label2.setIcon(labelImage2P);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelDerechoabajo.add(label2);
        panelDerecho.add(panelDerechoabajo,BorderLayout.SOUTH);

        panelCentral.add(panelDerecho);

        this.getContentPane().add(panelCentral,BorderLayout.CENTER);

        Regresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();new RuletaGui();
            }
        });
    }//fin constructor

}//fin clase