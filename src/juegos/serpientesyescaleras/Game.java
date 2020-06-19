package juegos.serpientesyescaleras;

import general.Objeto2D;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Game extends JPanel implements Runnable {

    //Hilo
    private static Thread thread;
    private boolean running = false;

    //Tablero y personajes
    private Objeto2D fondo = new Objeto2D("src/resources/serpientesyescaleras_src/graficos/tapete.png",0,0, 1024, 568);
    private BufferedImage image1;
    private BufferedImage image2;
    private SpriteSheet s1;
    private SpriteSheet s2;
    private BufferedImageLoader loader = new BufferedImageLoader();

    //Jugadores
    private Player p1;
    private Player p2;

    //Botones
    private JButton boton_dado;
    private JButton boton_reiniciar;
    private JButton boton_reglas;

    //Mensajes
    private JTextArea mensajes;
    private JScrollPane logs;

    //Dado
    private final Toolkit tk = Toolkit.getDefaultToolkit();
    private List<URL> dados = new ArrayList<URL>();

    //Turno
    private int turno_contador=1; // contador para contar numero de turno
    private boolean turno = true; // si turno=true es turno del jugador 1 , caso contrario turno del jugador 2

    public Game(){

        try {
            image1 = loader.loadImage("/serpientesyescaleras_src/graficos/player1.png");
            image2 = loader.loadImage("/serpientesyescaleras_src/graficos/player2.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        s1 = new SpriteSheet(image1);
        s2 = new SpriteSheet(image2);
        image1 = s1.grabImage(1,1,64,64);
        image2 = s2.grabImage(1,1,64,64);
        p1 = new Player("Naranja",890,490,image1);
        p2 = new Player("Morado",950,490,image2);

        dados.add(Game.class.getResource("/resources/serpientesyescaleras_src/graficos/dado.gif"));
        dados.add(Game.class.getResource("/resources/serpientesyescaleras_src/graficos/1.gif"));
        dados.add(Game.class.getResource("/resources/serpientesyescaleras_src/graficos/2.gif"));
        dados.add(Game.class.getResource("/resources/serpientesyescaleras_src/graficos/3.gif"));
        dados.add(Game.class.getResource("/resources/serpientesyescaleras_src/graficos/4.gif"));
        dados.add(Game.class.getResource("/resources/serpientesyescaleras_src/graficos/5.gif"));
        dados.add(Game.class.getResource("/resources/serpientesyescaleras_src/graficos/6.gif"));
        start();
    }

    public void init(){

        //boton dado
        boton_dado = new JButton();
        boton_dado.setBounds(13,588,120,120);
        boton_dado.setIcon(new ImageIcon(dados.get(0)));
        boton_dado.setBorder(null);
        boton_dado.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int num = (int) (Math.random() * 6 + 1); // numero aleatorio 1-6
                new Thread(()->{
                    boton_dado.setIcon(new ImageIcon(tk.createImage(dados.get(num)))); //reproduce un gif de la lista dependiendo el numero aleatorio que genera
                    try {
                        thread.sleep(5000); // pausa de 5 segundos para ver el resultado
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    if(turno==true){
                        mensajes.append("Jugador 1 ["+p1.getName()+"] : Mueves "+num+" -> Cuadro "+(p1.getPosicion()+num)+"\n");
                        mover(turno,num); // invocar metodo mover para mover el personaje
                        turno_contador++; // incrementar turno
                        mensajes.append("Turno "+turno_contador+" -> Jugador ["+p2.getName()+"]\n");
                    }
                    else{
                        mensajes.append("Jugador 2 ["+p2.getName()+"] : Mueves "+num+" -> Cuadro "+(p2.getPosicion()+num)+"\n");
                        mover(turno,num); // invocar metodo mover para mover el personaje
                        turno_contador++; // incrementar turno
                        mensajes.append("Turno "+turno_contador+" -> Jugador ["+p1.getName()+"]\n");
                    }
                    boton_dado.setIcon(new ImageIcon(dados.get(0))); // regresa al gif que hace loop
                }).start();
            }
        });
        this.add(boton_dado);

        //boton reiniciar
        boton_reiniciar = new JButton("Reiniciar");
        boton_reiniciar.setBounds(585,698,440,30);
        boton_reiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
                mensajes.setText(null); // limpiar mensajes
                mensajes.append("\n\nJuego Reseteado...\n\n"+"Turno "+turno_contador+" -> Jugador ["+p1.getName()+"]\n");
            }
        });
        this.add(boton_reiniciar);

        //boton reglas
        boton_reglas = new JButton("Reglas");
        boton_reglas.setBounds(145,698,440,30);
        boton_reglas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getParent(),"Reglas\n\n" +
                        "1. Cada jugador lanza por turnos el dado y avanza con su ficha tantas casillas como puntos saque.\n\n" +
                        "2. Si cae en una casilla situada al pie de las escaleras, avanza hasta el final de la misma.\n\n" +
                        "3. Si cae en la casilla ocupada por la cola de la serpiente, retrocede hasta la cabeza.\n\n" +
                        "4. Si va caer en la casilla ocupada por el otro jugador, deben intercambiar las casillas. \n\n" +
                        "5. Se debe llegar al casilla final con el puntaje justo, si no es el caso, retrocede la cantidad que sobrepasó la meta.\n");
            }
        });
        this.add(boton_reglas);

        //mensajes
        mensajes = new JTextArea();
        mensajes.setEditable(false);
        mensajes.setFont(getFont().deriveFont(18.0f));
        logs = new JScrollPane(mensajes);
        logs.setBounds(145,568,879,130);
        mensajes.append("  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Serpientes y Escaleras~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
        mensajes.append("Turno "+turno_contador+" -> Jugador ["+p1.getName()+"]\n");
        this.add(logs);

        start();
    }

    public synchronized void start()
    {
        if(running)
            return;

        running=true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if(!running)
            return;

        running=false;
        try {
            thread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.getGraphics().dispose();
    }

    public void reset(){ // metodo para reiniciar el juego
        p1.setPosicion(1);
        p1.setX(890);
        p1.setY(490);
        p1.setRenglon(1);
        p2.setPosicion(1);
        p2.setX(950);
        p2.setY(490);
        p2.setRenglon(1);
        turno_contador=1;
        turno=true;
    }

    public void validarMeta(Player p){ // metodo para verificar si algun jugador llega a la meta
        if(p.getPosicion()>=49){
            JOptionPane.showMessageDialog(getParent(),"Ganador : "+p.getName());
            reset();
            mensajes.setText(null);
            mensajes.append("  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Serpientes y Escaleras~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
            mensajes.append("Turno "+turno_contador+" -> Jugador ["+p1.getName()+"]\n");
        }
    }

    @Override
    public void run() {
        init();
    }

    public void paintComponent(Graphics g){
        this.repaint();
        Graphics2D gp1 = (Graphics2D) g;
        Graphics2D gp2 = (Graphics2D) g;
        g.drawImage(fondo.getImage(), fondo.getX(), fondo.getY(),fondo.getSizex(),fondo.getSizey(), this); // dibujar tablero
        gp1.drawImage(p1.getImage(),p1.getX(),p1.getY(),this); // dibujar jugador 1
        gp2.drawImage(p2.getImage(),p2.getX(),p2.getY(),this); // dibujar jugador 2
        setOpaque(false);
        super.paintComponent(g);
    }

    public void mover(boolean turno,int cuadros){ // metodo para mover el personaje
        new Thread(()->{
            if(turno==true){ // jugador 1
                for(int i=0;i<cuadros;i++) {
                    if(p1.getPosicion() % 7 ==0){ //si llega a un cuadro de un numero multiplo de 7 se sube 1 cuadro
                        p1.setY(p1.getY()-80);
                        p1.subirRenglon();
                    }
                    else{ // si no es multiplo de 7 mueve al cuadro derecha o izquierda dependiendo del renglon que esta
                        p1.mover();
                    }
                    try {
                        thread.sleep(1000); // pausa de 1 segundo cada movimiento
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    p1.incPosicion();
                }
                saltos(p1,mensajes); // terminando de mover verificamos si hay saltos en ese cuadro
                validarMeta(p1); // terminando de mover verificamos si llego a la meta
                this.turno=false; // cambio de turno
            }
            else{
                for(int i=0;i<cuadros;i++) {
                    if(p2.getPosicion() % 7 ==0){ //si llega a un cuadro de un numero multiplo de 7 se sube 1 cuadro
                        p2.setY(p2.getY()-80);
                        p2.subirRenglon();
                    }
                    else{ // si no es multiplo de 7 mueve al cuadro derecha o izquierda dependiendo del renglon que esta
                        p2.mover();
                    }
                    try {
                        thread.sleep(1000); // pausa de 1 segundo cada movimiento
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    p2.incPosicion();
                }
                saltos(p2,mensajes); // terminando de mover verificamos si hay saltos en ese cuadro
                validarMeta(p2); // terminando de mover verificamos si llego a la meta
                this.turno=true; // cambio de turno
            }
        }).start();
    }

    public void saltos(Player p,JTextArea m){ // metodo para verificar si hay saltos y imprimir mensajes
        if(p.getPosicion()==3) // CUADRO 3
        {
            m.append ("Jugador ["+p.getName()+"] : Coma Frutas y Verduras - Subes a cuadro 17\n");
            p.setY(p.getY()-160);
            p.setPosicion(17);
            p.setRenglon(3);
        }

        if(p.getPosicion()==6) // CUADRO 6
        {
            m.append ("Jugador ["+p.getName()+"] : Secaste tus prendas al sol - Subes a cuadro 20\n");
            p.setY(p.getY()-160);
            p.setPosicion(20);
            p.setRenglon(3);
        }

        if(p.getPosicion()==10) // CUADRO 10
        {
            m.append ("Jugador ["+p.getName()+"] : Plante arboles y cuida el ambiente - Subes a cuadro 19\n");
            p.setY(p.getY()-80);
            p.setPosicion(19);
            p.setRenglon(3);
        }

        if(p.getPosicion()==11) // CUADRO 11
        {
            m.append ("Jugador ["+p.getName()+"] : No tires basura - Bajas a cuadro 4\n");
            p.setY(p.getY()+80);
            p.setPosicion(4);
            p.setRenglon(1);
        }

        if(p.getPosicion()==16) // CUADRO 16
        {
            m.append ("Jugador ["+p.getName()+"] : Desperdiciaste mucha agua - Bajas a cuadro 2\n");
            p.setY(p.getY()+160);
            p.setPosicion(2);
            p.setRenglon(1);
        }

        if(p.getPosicion()==18) // CUADRO 18
        {
            m.append ("Jugador ["+p.getName()+"] : Usaste Bicicleta muy bien - Subes a cuadro 30\n");
            p.setY(p.getY()-160);
            p.setX(p.getX()+290);
            p.setPosicion(30);
            p.setRenglon(5);
        }

        if(p.getPosicion()==21) // CUADRO 21
        {
            m.append ("Jugador ["+p.getName()+"] : Compraste Fruta empacada - Bajas a cuadro 8\n");
            p.setY(p.getY()+80);
            p.setPosicion(21);
            p.setRenglon(2);
        }

        if(p.getPosicion()==22) // CUADRO 22
        {
            m.append ("Jugador ["+p.getName()+"] : Sacaste a pasear al perro - Subes a cuadro 36\n");
            p.setY(p.getY()-160);
            p.setPosicion(36);
            p.setRenglon(6);
        }

        if(p.getPosicion()==23) // CUADRO 23
        {
            m.append ("Jugador ["+p.getName()+"] : Desperdisiaste Agua - Bajas al cuadro 9\n");
            p.setY(p.getY()+160);
            p.setPosicion(9);
            p.setRenglon(2);
        }

        if(p.getPosicion()==28) // CUADRO 28
        {
            m.append ("Jugador ["+p.getName()+"] : Reutilizaste hojas usadas - Subes a cuadro 43\n");
            p.setY(p.getY()-240);
            p.setPosicion(43);
            p.setRenglon(7);
        }

        if(p.getPosicion()==31) // CUADRO 31
        {
            m.append ("Jugador ["+p.getName()+"] : Reciclaste muy bien - Subes a cuadro 40\n");
            p.setY(p.getY()-80);
            p.setPosicion(40);
            p.setRenglon(6);
        }

        if(p.getPosicion()==33) // CUADRO 33
        {
            m.append ("Jugador ["+p.getName()+"] : Desperdisiaste mucha agua bañandote - Bajas a cuadro 25\n");
            p.setY(p.getY()+80);
            p.setX(p.getX()+145);
            p.setPosicion(25);
            p.setRenglon(4);
        }

        if(p.getPosicion()==38) // CUADRO 38
        {
            m.append ("Jugador ["+p.getName()+"] : Desperdiciaste mucha electricidad - Bajas cuadro 32\n");
            p.setY(p.getY()+80);
            p.setX(p.getX()+145);
            p.setPosicion(32);
            p.setRenglon(5);
        }

        if(p.getPosicion()==39) // CUADRO 39
        {
            m.append ("Jugador ["+p.getName()+"] : Reciclaste muy bien - Subes cuadro 45\n");
            p.setY(p.getY()-80);
            p.setX(p.getX()+145);
            p.setPosicion(45);
            p.setRenglon(7);
        }

        if(p.getPosicion()==41) // CUADRO 41
        {
            m.append ("Jugador ["+p.getName()+"] : Desperdisiaste mucho los botes de plastico - Bajas cuadro 27\n");
            p.setY(p.getY()+160);
            p.setPosicion(41);
            p.setRenglon(4);
        }

        if(p.getPosicion()==44) // CUADRO 44
        {
            m.append ("Jugador ["+p.getName()+"] : Contaminaste aguas - Bajas cuadro 42\n");
            p.setY(p.getY()+80);
            p.setX(p.getX()+145);
            p.setPosicion(42);
            p.setRenglon(6);
        }

        if(p.getPosicion()==47) // CUADRO 47
        {
            m.append ("Jugador ["+p.getName()+"] : Usaste tenedor de plastico - Bajas cuadro 37\n");
            p.setY(p.getY()+80);
            p.setX(p.getX()-145);
            p.setPosicion(37);
            p.setRenglon(6);
        }

    }
}