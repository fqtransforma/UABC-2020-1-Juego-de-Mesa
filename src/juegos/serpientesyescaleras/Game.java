package juegos.serpientesyescaleras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game extends Canvas implements Runnable, ActionListener {

    public static final int WIDTH = 320;
    public static final int HEIGHT= 240; //240
    public static final int SCALE=2;
    public final String TITLE="Tablero: Serpientes y Escaleras";

    private  boolean running =false;
    private  Thread thread;

    private BufferedImage image= new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
    private BufferedImage spriteSheet = null;
    private BufferedImage fondo = null;

    //temp
    private BufferedImage player;
    private static Player p;

    private static JTextArea mensajes = new JTextArea();
    private static JScrollPane logs = new JScrollPane(mensajes);

    public void init()
    {
        requestFocus();
        BufferedImageLoader loader=new BufferedImageLoader();

        try{
            fondo = loader.loadImage("/serpientesyescaleras_src/tapete.png");
            spriteSheet=loader.loadImage("/serpientesyescaleras_src/player.png");
        }catch (IOException e)
        {
            e.printStackTrace();
        }

        addKeyListener(new KeyInput(this));

        p =new Player(700,420,this);
        SpriteSheet ss=new SpriteSheet(spriteSheet);
    }


    public synchronized void start()
    {
        if(running)
            return;

        running=true;
        thread=new Thread(this);
        thread.start();
    }

    private synchronized void stop()
    {
        if(!running)
            return;

        running=false;
        try { thread.join();
        }catch(InterruptedException e)
        {e.printStackTrace();}//Si por alguna razon falla nos comenta error

        System.exit(1);
    }

    public void run() // runnable game loop
    {
        init();
        long lastTime = System.nanoTime(); //variables de timpo para fps
        final double amountOfTicks=60.0;
        double ns= 1000000000/amountOfTicks;
        double delta=0;
        int updates=0;
        int frames=0;
        long timer=System.currentTimeMillis();

        while(running)
        {
            // Game loop
            long now = System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime=now;

            if(delta >=1)
            {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis()-timer>1000)
            {
                timer+=1000;
                System.out.println(updates+"Ticks , FPS "+frames);
                updates=0;
                frames=0;
            }
        }
        stop();
    }

    private void tick()
    {
       p.tick();

    }

    private void render()
    {
        BufferStrategy bs= this.getBufferStrategy();

        if(bs==null)
        {
            createBufferStrategy(3);// 3 buffer
            return;

        }

        Graphics g = bs.getDrawGraphics();
        //dibujar

        g.drawImage(image,0,0,getWidth(),getHeight(),this);
        g.drawImage(fondo,0,0,getWidth(),getHeight(), this);
        p.render(g); //Jugador 1
        //dibujar
        g.dispose();
        bs.show();

    }

    public void keyPressed(KeyEvent e) {

        int key=e.getKeyCode();

        if(key == KeyEvent.VK_RIGHT)
        {
            p.setVelX(5);
        }else if(key == KeyEvent.VK_LEFT)
        {
            p.setVelX(-5);
        }else if(key == KeyEvent.VK_DOWN)
        {
            p.setVelY(5);
        }else if(key == KeyEvent.VK_UP)
        {
            p.setVelY(-5);
        }
    }


    public void keyReleased(KeyEvent e) {

        int key=e.getKeyCode();

        if(key == KeyEvent.VK_RIGHT)
        {
            p.setVelX(0);
        }else if(key == KeyEvent.VK_LEFT)
        {
            p.setVelX(0);
        }else if(key == KeyEvent.VK_DOWN)
        {
            p.setVelY(0);
        }else if(key == KeyEvent.VK_UP)
        {
            p.setVelY(0);
        }

    }

    public BufferedImage getSpriteSheet(){
    return spriteSheet;

    }

    public static void StartSerpientesYEscaleras(){
        final int WIDTH = 320;
        final int HEIGHT= 240; //240
        final int SCALE=2;

        String filepath= "resources/serpientesyescaleras_src/game.wav";

        MusicStaff music=new MusicStaff();
        music.PlayMusic(filepath);

        Game game=new Game();

        //creando dimensiones
        game.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
        game.setMaximumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
        game.setMinimumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));


        JFrame frame =new JFrame(game.TITLE);
        frame.add(game,BorderLayout.NORTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        //JButtons

        JButton boton1= new JButton();
        JButton boton2= new JButton();
        //
        //JTextArea
        mensajes.setEditable(false);
        mensajes.setAutoscrolls(true);


        //Boton 1 //Jugador 1
        boton1.repaint();
        boton1.setText("[PLAYER1]");
        boton1.setPreferredSize(new Dimension(100,100));
        boton1.setBounds(66,20,150,50);
        boton1.setVisible(true);

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==boton1) {
                    int numero1 = (int)(Math.random()*6+1);
                    mensajes.append("JUGADOR 1 MUEVES: "+numero1+"\n");
                    msg(numero1);
                }
            }
        });

        //Boton 2 //Jugador 2

        boton2.repaint();
        boton2.setText("[PLAYER2]");
        boton2.setPreferredSize(new Dimension(100,100));
        boton2.setBounds(66,20,150,50);
        boton2.setVisible(true);

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==boton2) {
                    int numero2 = (int)(Math.random()*6+1);
                    mensajes.append("JUGADOR 2 MUEVES: "+numero2+"\n");
                    msg(numero2);
                }
            }
        });

        //Botones Player 1,player 2 && stargame
        frame.add(boton1,BorderLayout.WEST);
        frame.add(boton2,BorderLayout.EAST);
        frame.add(logs,BorderLayout.CENTER);
        frame.setSize(800,600);

        game.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void msg(int valor){
        p.avanzar(valor);
        if(p.getPosicion()==3){
            p.setPosicion(17);
            mensajes.append(""+"\n");
        }
        if(p.getPosicion()==6){
            p.setPosicion(20);
            mensajes.append(""+"\n");
        }
        if(p.getPosicion()==10){
            p.setPosicion(19);
            mensajes.append(""+"\n");
        }
        if(p.getPosicion()==11){
            p.setPosicion(4);
            mensajes.append(""+"\n");
        }
        if(p.getPosicion()==16){
            p.setPosicion(2);
            mensajes.append(""+"\n");
        }
        if(p.getPosicion()==18){
            p.setPosicion(30);
            mensajes.append(""+"\n");
        }
        if(p.getPosicion()==21){
            p.setPosicion(8);
            mensajes.append(""+"\n");
        }
        if(p.getPosicion()==22){
            p.setPosicion(36);
            mensajes.append(""+"\n");
        }
        if(p.getPosicion()==23){
            p.setPosicion(9);
            mensajes.append("Desperdiciaste agua, Bajas al 9"+"\n");
        }
        if(p.getPosicion()==28){
            p.setPosicion(43);
            mensajes.append(""+"\n");
        }
        if(p.getPosicion()==31){
            p.setPosicion(40);
            mensajes.append(""+"\n");
        }
        if(p.getPosicion()==33){
            p.setPosicion(25);
            mensajes.append(""+"\n");
        }
        if(p.getPosicion()==38){
            p.setPosicion(32);
            mensajes.append(""+"\n");
        }
        if(p.getPosicion()==39){
            p.setPosicion(45);
            mensajes.append(""+"\n");
        }
        if(p.getPosicion()==41){
            p.setPosicion(27);
            mensajes.append(""+"\n");
        }
        if(p.getPosicion()==44){
            p.setPosicion(42);
            mensajes.append(""+"\n");
        }
        if(p.getPosicion()==47){
            p.setPosicion(37);
            mensajes.append(""+"\n");
        }
    }
}
