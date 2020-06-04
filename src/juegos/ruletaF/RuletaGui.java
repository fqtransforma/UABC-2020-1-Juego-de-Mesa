package juegos.ruletaF;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.*;			// para random
import java.lang.*;         //para  java.lang.System.currentTimeMillis

import java.io.IOException; //para antonio
public class RuletaGui extends JFrame {

    private JPanel Raiz;
    private JButton Jugar;
    private JButton Ayuda;
    private JPanel panelIzquierdo;
    private JButton Salir;
    private JButton Girar;
    private JLabel label;
    private JLabel label2;
    private Random r1= new Random(System.currentTimeMillis());
    private ImageIcon labelImage;
   // private PlayMusic musica= new PlayMusic();
    private int valor;
    private int aux;

    public RuletaGui (){
        super("Ruleta");
        setContentPane(Raiz);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Salir.setPreferredSize(new Dimension(50, 50));
        Salir.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        Jugar.setPreferredSize(new Dimension(120, 50));
        Jugar.setFont(new Font("Arial",Font.CENTER_BASELINE,22));
        Ayuda.setPreferredSize(new Dimension(120, 50));
        Ayuda.setFont(new Font("Arial",Font.CENTER_BASELINE,22));
        Girar.setPreferredSize(new Dimension(130, 50));
        Girar.setFont(new Font("Arial",Font.CENTER_BASELINE,22));

        Salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
              dispose();
              //musica.cerrar();
              System.exit(0);

            }
        });

        Jugar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if(valor==0){
                    JOptionPane.showMessageDialog(null,"Necesitas girar la ruleta ");
                }else{
                    switch(valor){
                        //oara pruebas basta
                      /* case 1:dispose();new JuegoBasta();break;
                        case 2:dispose();new JuegoBasta();break;
                        case 3:dispose();new JuegoBasta();break;*/

                      //para pruebas caricaturas
                      /*  case 1:dispose();new Juego();break;
                        case 2:dispose();new Juego();break;
                        case 3:dispose();new Juego();break;*/

                        //para pruebas ecoreto
                        case 1:dispose();new WindowApp("EcoReto");break;
                        case 2:dispose();new WindowApp("EcoReto");break;
                        case 3:dispose();new WindowApp("EcoReto");break;

                        //para pruebas de los 3
                       /*case 1:dispose();new JuegoBasta();break;
                       case 2:dispose(); new Juego();break;
                       case 3:dispose();new WindowApp("EcoReto");break;*/

                    }
                }
            }
        });

        Ayuda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"En construccion");
            }
        });

        Girar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //valor=r1.nextInt(3);//entre 0 y 2
                if(aux!=0){
                    do {
                        valor = r1.nextInt(3) + 1;    //entre 1 y 3
                    } while (aux == valor);
                    aux = valor;
                }else{
                    valor = r1.nextInt(3)+1;	//entre 1 y 3
                    aux=valor;
                }
                switch(valor){
                    case 1: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/ruletaGui/basta3.gif");break;
                    case 2: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/ruletaGui/caricaturas3.gif");break;
                    case 3: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/ruletaGui/ecoreto3.gif");break;
                }
                /////////////////////////////////////////////////
                //      Sonido de ruleta silenciado para las pruebas
                  /*  musica.spiningWheel();
                    musica.play();*/
                ////////////////////////////////////////////////
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