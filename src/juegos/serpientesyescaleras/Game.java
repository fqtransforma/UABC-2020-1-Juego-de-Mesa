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
    private Player p;

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
        JButton boton3= new JButton();


        ActionListener e = null;

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
                    System.out.println("JUGADOR 1 MUEVES: "+numero1);}
            }
        });

        //Boton 2 //Jugador 2

        boton2.repaint();
        boton2.setText("[PLAYER2]");
        boton2.setPreferredSize(new Dimension(100,100));
        boton2.setBounds(66,20,150,50);
        boton2.setVisible(true);

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==boton1) {
                    int numero2 = (int)(Math.random()*6+1);
                    System.out.println("JUGADOR 2 MUEVES: "+numero2);}
            }
        });

        //Boton 3

        boton3.repaint();
        boton3.setText("[STAR GAME]");
        boton3.setPreferredSize(new Dimension(100,100));
        boton3.setBounds(66,20,150,50);
        boton3.setVisible(true);

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==boton3) {
                    game.start();
                    System.out.println("STARGAME");}
            }
        });

        //Botones Player 1,player 2 && stargame
        frame.add(boton1,BorderLayout.WEST);
        frame.add(boton2,BorderLayout.EAST);
        frame.add(boton3,BorderLayout.CENTER);
        frame.setSize(800,600);

        game.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
