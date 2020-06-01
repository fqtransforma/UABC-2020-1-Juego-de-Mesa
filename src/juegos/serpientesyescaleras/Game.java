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
    private BufferedImage spriteSheet2 = null;
    private BufferedImage fondo = null;

    private static Player p1;
    private static Player p2;

    private static JTextArea mensajes = new JTextArea();
    private static JScrollPane logs = new JScrollPane(mensajes);
    private static JPanel panel = new JPanel();

    public void init()
    {
        requestFocus();
        BufferedImageLoader loader=new BufferedImageLoader();

        try{
            fondo = loader.loadImage("/serpientesyescaleras_src/graficos/tapete.png");
            spriteSheet=loader.loadImage("/serpientesyescaleras_src/graficos/player.png");
            spriteSheet2=loader.loadImage("/serpientesyescaleras_src/graficos/player.png");

        }catch (IOException e)
        {
            e.printStackTrace();
        }

        addKeyListener(new KeyInput(this));

        p1 =new Player(700,420,this);
        p2 =new Player(700,450,this);


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
        p1.tick();
        p2.tick();

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
        p1.render(g); //Jugador 1
        p2.render(g);
        //dibujar
        g.dispose();
        bs.show();
    }

    public void keyPressed(KeyEvent e) {

        int key=e.getKeyCode();

        if(key == KeyEvent.VK_RIGHT)
        {
            p1.setVelX(5);
        }else if(key == KeyEvent.VK_LEFT)
        {
            p1.setVelX(-5);
        }else if(key == KeyEvent.VK_DOWN)
        {
            p1.setVelY(5);
        }else if(key == KeyEvent.VK_UP)
        {
            p1.setVelY(-5);
        }

        //Player 2

        if(key == KeyEvent.VK_D)
        {
            p2.setVelX(5);
        }else if(key == KeyEvent.VK_A)
        {
            p2.setVelX(-5);
        }else if(key == KeyEvent.VK_S)
        {
            p2.setVelY(5);
        }else if(key == KeyEvent.VK_W)
        {
            p2.setVelY(-5);
        }
    }


    public void keyReleased(KeyEvent e) {

        int key=e.getKeyCode();

        if(key == KeyEvent.VK_RIGHT)
        {
            p1.setVelX(0);
        }else if(key == KeyEvent.VK_LEFT)
        {
            p1.setVelX(0);
        }else if(key == KeyEvent.VK_DOWN)
        {
            p1.setVelY(0);
        }else if(key == KeyEvent.VK_UP)
        {
            p1.setVelY(0);
        }

        //Player 2

        if(key == KeyEvent.VK_D)
        {
            p2.setVelX(0);
        }else if(key == KeyEvent.VK_A)
        {
            p2.setVelX(0);
        }else if(key == KeyEvent.VK_S)
        {
            p2.setVelY(0);
        }else if(key == KeyEvent.VK_W)
        {
            p2.setVelY(0);
        }


    }

    public BufferedImage getSpriteSheet(){
        return spriteSheet;

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void msg(int valor){
        p1.avanzar(valor);
        if(p1.getPosicion()==3){
            p1.setPosicion(17);
            mensajes.append(""+"\n");
        }
        if(p1.getPosicion()==6){
            p1.setPosicion(20);
            mensajes.append(""+"\n");
        }
        if(p1.getPosicion()==10){
            p1.setPosicion(19);
            mensajes.append(""+"\n");
        }
        if(p1.getPosicion()==11){
            p1.setPosicion(4);
            mensajes.append(""+"\n");
        }
        if(p1.getPosicion()==16){
            p1.setPosicion(2);
            mensajes.append(""+"\n");
        }
        if(p1.getPosicion()==18){
            p1.setPosicion(30);
            mensajes.append(""+"\n");
        }
        if(p1.getPosicion()==21){
            p1.setPosicion(8);
            mensajes.append(""+"\n");
        }
        if(p1.getPosicion()==22){
            p1.setPosicion(36);
            mensajes.append(""+"\n");
        }
        if(p1.getPosicion()==23){
            p1.setPosicion(9);
            mensajes.append("Desperdiciaste agua, Bajas al 9"+"\n");
        }
        if(p1.getPosicion()==28){
            p1.setPosicion(43);
            mensajes.append(""+"\n");
        }
        if(p1.getPosicion()==31){
            p1.setPosicion(40);
            mensajes.append(""+"\n");
        }
        if(p1.getPosicion()==33){
            p1.setPosicion(25);
            mensajes.append(""+"\n");
        }
        if(p1.getPosicion()==38){
            p1.setPosicion(32);
            mensajes.append(""+"\n");
        }
        if(p1.getPosicion()==39){
            p1.setPosicion(45);
            mensajes.append(""+"\n");
        }
        if(p1.getPosicion()==41){
            p1.setPosicion(27);
            mensajes.append(""+"\n");
        }
        if(p1.getPosicion()==44){
            p1.setPosicion(42);
            mensajes.append(""+"\n");
        }
        if(p1.getPosicion()==47){
            p1.setPosicion(37);
            mensajes.append(""+"\n");
        }
    }
}
