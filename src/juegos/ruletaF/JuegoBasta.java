package juegos.ruletaF;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;			// para random
import java.lang.*;         //para  java.lang.System.currentTimeMillis

public class JuegoBasta extends JFrame implements Runnable{

    private JPanel panelCentral;
    private JPanel panelArriba;
    private JPanel panelIzquierdo;
    private JPanel panelDerecho;

    private JButton Iniciar;
    private JButton Reiniciar;
    private JButton Ayuda;
    private JButton Salir;
    private JButton Regresar;
    private JButton Sacar;
    private JButton Letra;

    //inicio paneles auxiliares
    private JPanel auxiliar1;
    private JPanel auxiliar2;
    private JPanel auxiliar3;
    private JPanel auxiliar4;
    private JPanel auxiliar5;
    //fin paneles auxiliares

    private JLabel label;
    private JLabel label2;
    private JLabel tiempo; //para reloj

    private ImageIcon labelImageP;
    private ImageIcon labelImage;
    private ImageIcon labelImage2P;
    private ImageIcon labelImage2;

    private Random r1= new Random(System.currentTimeMillis());
    private PlayMusic musica= new PlayMusic();

    private int valor;//valor imagen de letra
    private int aux;//auxiliar imagen letra
    private int valor2;//valor imagen de letra
    private int aux2;//auxiliar imagen letra
    private boolean cronometroActivo;
    private Thread hilo;

    public JuegoBasta (){
        super("Basta en construccion");
        this.getContentPane().setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        auxiliar1=new JPanel();
        auxiliar2=new JPanel();
        auxiliar3=new JPanel();
        auxiliar3.setLayout(new FlowLayout());
        auxiliar4=new JPanel();
        auxiliar4.setLayout(new FlowLayout());
        auxiliar5=new JPanel();
        // auxiliar5.setLayout(new FlowLayout());
        //auxiliar5.setLayout(new BoxLayout(auxiliar5,BoxLayout.Y_AXIS));
        auxiliar5.setLayout(new BoxLayout(auxiliar5,BoxLayout.X_AXIS));

        auxiliar1.setBackground(Color.yellow);//derecha
        auxiliar2.setBackground(Color.orange.darker());//izquierda
        auxiliar3.setBackground(Color.white);//arriba
        auxiliar4.setBackground(Color.CYAN);//abajo
        auxiliar5.setBackground(Color.black);//centro


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// inicio panel Arriba
        panelArriba = new JPanel();
        panelArriba.setLayout(new BoxLayout(panelArriba,BoxLayout.X_AXIS));

        Regresar = new JButton("Regresar");
        Regresar.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        Regresar.setBackground(new Color(187,179,175));
        Regresar.setForeground(Color.BLACK);

        Salir=new JButton("Salir");
        Salir.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        Salir.setBackground(Color.RED);
        Salir.setForeground(Color.BLACK);

        panelArriba.add(Regresar);
        panelArriba.add(Box.createHorizontalGlue());
        panelArriba.add(Salir);

        panelArriba.setBackground(Color.CYAN);
        this.getContentPane().add(panelArriba,BorderLayout.NORTH);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// fin panel Arriba
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// inicio panel izquierdo
        panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo,BoxLayout.Y_AXIS));

        label= new JLabel();
        labelImageP = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/logoBasta.png");
        label.setIcon(labelImageP);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        label2=new JLabel();
        labelImage2P = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/logoLetras.png");
        label2.setIcon(labelImage2P);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);

        Sacar=new JButton("Sacar Carta");
        Sacar.setFont(new Font("Arial",Font.CENTER_BASELINE,22));
        Sacar.setAlignmentX(Component.CENTER_ALIGNMENT);
        Sacar.setBackground(new Color(249,94,0));
        Sacar.setForeground(Color.BLACK);

        Letra=new JButton("Sacar Letra");
        Letra.setFont(new Font("Arial",Font.CENTER_BASELINE,22));
        Letra.setAlignmentX(Component.CENTER_ALIGNMENT);
        Letra.setBackground(new Color(249,94,0));
        Letra.setForeground(Color.BLACK);

        panelIzquierdo.add(Box.createVerticalGlue());
        panelIzquierdo.add(label);
        panelIzquierdo.add(Sacar);
        panelIzquierdo.add(Box.createVerticalGlue());
        panelIzquierdo.add(label2);
        panelIzquierdo.add(Letra);
        panelIzquierdo.add(Box.createVerticalGlue());

        panelIzquierdo.setBackground(Color.CYAN);
        this.getContentPane().add(panelIzquierdo,BorderLayout.WEST);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// fin panel izquierdo
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// inicio panel derecho
        panelDerecho = new JPanel();
        panelDerecho.setLayout(new BoxLayout(panelDerecho,BoxLayout.Y_AXIS));

        Ayuda=new JButton("AYUDA");
        Ayuda.setFont(new Font("Arial",Font.CENTER_BASELINE,22));
        Ayuda.setAlignmentX(Component.RIGHT_ALIGNMENT);
        Ayuda.setBackground(new Color(249,94,0));
        Ayuda.setForeground(Color.BLACK);

        panelDerecho.add(Box.createVerticalGlue());
        panelDerecho.add(Ayuda);
        panelDerecho.add(Box.createVerticalGlue());

        panelDerecho.setBackground(Color.CYAN);
        this.getContentPane().add(panelDerecho,BorderLayout.EAST);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// fin panel derecho
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// inicio panel Central
        panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());


        ///////////////////////////////////////////////////////////////////////////////////////// para reloj
        tiempo = new JLabel( "00:00:000" );
        tiempo.setFont( new Font( Font.SERIF, Font.BOLD, 80) );
        tiempo.setHorizontalAlignment( JLabel.CENTER );
        tiempo.setForeground( Color.BLUE );
        tiempo.setBackground( Color.CYAN);
        tiempo.setOpaque( true );
        auxiliar3.add(tiempo);

        auxiliar3.setBackground(Color.CYAN);//Temporal desde aqui

        Iniciar = new JButton("Iniciar");
        Iniciar.setFont(new Font("Arial",Font.CENTER_BASELINE,22));
        Iniciar.setBackground(new Color(249,94,0));
        Iniciar.setForeground(Color.BLACK);

        Reiniciar = new JButton("Reiniciar");
        Reiniciar.setFont(new Font("Arial",Font.CENTER_BASELINE,22));
        Reiniciar.setBackground(new Color(249,94,0));
        Reiniciar.setForeground(Color.BLACK);

        auxiliar4.add(Iniciar);
        auxiliar4.add(Reiniciar);
        ///////////////////////////////////////////////////////////////////////////////////////// termina reloj

        JTextArea cajaTexto = new JTextArea();
        cajaTexto.setSize(new Dimension(100,110));
        cajaTexto.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(cajaTexto,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        auxiliar5.add(Box.createVerticalGlue());
        auxiliar5.add(Box.createHorizontalGlue());
        auxiliar5.add(scrollPane);
        auxiliar5.add(Box.createHorizontalGlue());
        auxiliar5.add(Box.createVerticalGlue());

        auxiliar5.setBackground(Color.CYAN);//Temporal desde aqui

        // panelCentral.add(auxiliar1,BorderLayout.EAST);
        // panelCentral.add(auxiliar2,BorderLayout.WEST);
        panelCentral.add(auxiliar3,BorderLayout.NORTH);
        panelCentral.add(auxiliar4,BorderLayout.SOUTH);
        panelCentral.add(auxiliar5,BorderLayout.CENTER);
        this.getContentPane().add(panelCentral,BorderLayout.CENTER);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// fin panel Central

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// inicio listener de botones
        Regresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();new RuletaGui();
            }
        });

        Salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                //musica.cerrar();
                System.exit(0);
            }
        });

        Ayuda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"En construccion");
            }
        });

        Iniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if(valor==0){
                    JOptionPane.showMessageDialog(null,"Necesitas sacar una carta ");
                }
                else
                if(valor2==0){
                    JOptionPane.showMessageDialog(null,"Necesitas sacar una letra ");
                }else{
                    cajaTexto.setEnabled(true);
                    while(!cronometroActivo){
                        iniciarCronometro();
                    }

                }

            }
        });
        Reiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                valor=valor2=0;
                label.setIcon(labelImageP);
                label.repaint();
                label.validate();
                label2.setIcon(labelImage2P);
                label2.repaint();
                label2.validate();

                pararCronometro();
            }
        });

        Sacar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if(aux!=0){
                    do {
                        valor = r1.nextInt(10) + 1;    //entre 1 y 10
                    } while (aux == valor);
                    aux = valor;
                }else{
                    valor = r1.nextInt(10)+1;	//entre 1 y 10
                    aux=valor;
                }
                switch(valor){
                    case 1: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/animales.png");break;
                    case 2: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/frutas.png");break;
                    case 3: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/minerales.png");break;
                    case 4: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/plantas.png");break;
                    case 5: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/recursosNaturales.png");break;
                    case 6: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/recursosRenovables.png");break;
                    case 7: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/recursosNorenovables.png");break;
                    case 8: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/residuosInorganicos.png");break;
                    case 9: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/residuosOrganicos.png");break;
                    case 10: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/verduras.png");break;
                }
                //musica.spiningWheel();
                //musica.play();
                label.setIcon(labelImage);
                label.repaint();
                label.validate();
            }
        });
        Letra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (valor == 0) {
                    JOptionPane.showMessageDialog(null, "Necesitas sacar una Carta ");
                } else {
                    if (aux2 != 0) {
                        do {
                            valor2 = r1.nextInt(26) + 1;    //entre 1 y 26
                        } while (aux2 == valor2);
                        aux2 = valor2;
                    } else {
                        valor2 = r1.nextInt(26) + 1;    //entre 1 y 26
                        aux2 = valor2;
                    }
                    switch (valor2) {
                        case 1: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/A.png");break;
                        case 2: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/B.png");break;
                        case 3: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/C.png");break;
                        case 4: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/D.png");break;
                        case 5: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/E.png");break;
                        case 6: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/F.png");break;
                        case 7: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/G.png");break;
                        case 8: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/H.png");break;
                        case 9: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/I.png");break;
                        case 10: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/J.png");break;
                        case 11: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/K.png");break;
                        case 12: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/L.png");break;
                        case 13: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/M.png");break;
                        case 14: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/N.png");break;
                        case 15: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/O.png");break;
                        case 16: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/P.png");break;
                        case 17: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/Q.png");break;
                        case 18: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/R.png");break;
                        case 19: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/S.png");break;
                        case 20: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/T.png");break;
                        case 21: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/U.png");break;
                        case 22: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/V.png");break;
                        case 23: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/W.png");break;
                        case 24: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/X.png");break;
                        case 25: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/Y.png");break;
                        case 26: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/Z.png");break;
                    }
                    label2.setIcon(labelImage2);
                    label2.repaint();
                    label2.validate();
                }
            }
        });
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// fin listener de botones
    }//fin constructor


    public void run(){
        Integer minutos = 0 , segundos = 0, milesimas = 0;
        //min es minutos, seg es segundos y mil es milesimas de segundo
        String min="", seg="", mil="";
        try
        {
            //Mientras cronometroActivo sea verdadero entonces seguira
            //aumentando el tiempo
            while( cronometroActivo )
            {
                Thread.sleep( 4 );
                //Incrementamos 4 milesimas de segundo
                milesimas += 4;

                //Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
                //y las milesimas de segundo de nuevo a 0
                if( milesimas == 1000 )
                {
                    milesimas = 0;
                    segundos += 1;
                    //Si los segundos llegan a 60 entonces aumenta 1 los minutos
                    //y los segundos vuelven a 0
                    if( segundos == 60 )
                    {
                        segundos = 0;
                        minutos++;
                    }
                }

                //Esto solamente es estetica para que siempre este en formato
                //00:00:000
                if( minutos < 10 ) min = "0" + minutos;
                else min = minutos.toString();
                if( segundos < 10 ) seg = "0" + segundos;
                else seg = segundos.toString();

                if( milesimas < 10 ) mil = "00" + milesimas;
                else if( milesimas < 100 ) mil = "0" + milesimas;
                else mil = milesimas.toString();

                //Colocamos en la etiqueta la informacion
                tiempo.setText( min + ":" + seg + ":" + mil );
            }
        }catch(Exception e){}
        //Cuando se reincie se coloca nuevamente en 00:00:000
        tiempo.setText( "00:00:000" );
    }
    public void iniciarCronometro() {
        cronometroActivo = true;
        hilo = new Thread( this );
        hilo.start();
    }
    public void pararCronometro(){
        cronometroActivo = false;
    }

}//fin clase
