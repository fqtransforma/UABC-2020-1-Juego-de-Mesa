package juegos.serpientesyescaleras;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game extends Canvas implements Runnable, ActionListener {

    public static final int WIDTH = 320;
    public static final int HEIGHT= 240;
    public final String TITLE="Tablero: Serpientes y Escaleras";

    private  boolean running =false;
    private  Thread thread;

    private BufferedImage image= new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
    private BufferedImage spriteSheet = null;
    private BufferedImage spriteSheet2 = null;
    private BufferedImage fondo = null;

    //Dados

    private  BufferedImage dado1 = null;
    private  BufferedImage dado2 = null;
    private  BufferedImage dado3 = null;
    private  BufferedImage dado4 = null;
    private  BufferedImage dado5 = null;
    private  BufferedImage dado6 = null;

    //

    private static Player p1;
    private static Player p2;
    private int turnoCont=2;
    private int turno=1;

    private int nume;

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getTurnoCont() {
        return turnoCont;
    }

    public void turno_sig() {
        turnoCont = turnoCont+1;
    }

////////////////////////////////////////////////////////////////////

    public int getTurn(){ return nume;}
    public void setTurn(int nume){this.nume=nume;}

///////////////////////////////////////////////////////////////////

    public Game(Player p1, Player p2){
        this.p1=p1;
        this.p2=p2;
    }

    public void init()
    {
        requestFocus();
        BufferedImageLoader loader=new BufferedImageLoader();

        try{
            fondo = loader.loadImage("/serpientesyescaleras_src/graficos/tapete.png");
            spriteSheet=loader.loadImage("/serpientesyescaleras_src/graficos/player2.png");
            spriteSheet2=loader.loadImage("/serpientesyescaleras_src/graficos/player2.png");

            //Dados

            dado1=loader.loadImage("/serpientesyescaleras_src/graficos/1.png");
            dado2=loader.loadImage("/serpientesyescaleras_src/graficos/2.png");
            dado3=loader.loadImage("/serpientesyescaleras_src/graficos/3.png");
            dado4=loader.loadImage("/serpientesyescaleras_src/graficos/4.png");
            dado5=loader.loadImage("/serpientesyescaleras_src/graficos/5.png");
            dado6=loader.loadImage("/serpientesyescaleras_src/graficos/6.png");

            //

        }catch (IOException e)
        {
            e.printStackTrace();
        }

        addKeyListener(new KeyInput(this));
        SpriteSheet s1 = new SpriteSheet(spriteSheet);
        SpriteSheet s2 = new SpriteSheet(spriteSheet);
        spriteSheet = s1.grabImage(2,2,32,32);
        spriteSheet2 = s2.grabImage(2,2,32,32);
        System.out.println("X= "+p1.x+ "Y= "+p1.y);
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
                //System.out.println(updates+"Ticks , FPS "+frames);
                updates=0;
                frames=0;
            }
        }
        stop();
    }

    public void tick()
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
        g.drawImage(spriteSheet,(int)p1.getX(),(int)p1.getY(),null); //Jugador 1
        g.drawImage(spriteSheet2,(int)p2.getX(),(int)p2.getY(),null); //Jugador 2

        renderDados(getTurn());

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

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public String msg(Player p,int num){
        p.avanzar(num);
        if(p.getPosicion()==3) // CUADRO 3
        {
            return ("Coma Frutas y Verduras - Subes a cuadro 17\n\n");
        }

        if(p.getPosicion()==6) // CUADRO 6
        {
            return ("Secaste tus prendas al sol - Subes a cuadro 20\n\n");
        }

        if(p.getPosicion()==10) // CUADRO 10
        {
            return ("Plante arboles y cuida el ambiente - Subes a cuadro 19\n\n");
        }

        if(p.getPosicion()==11) // CUADRO 11
        {
            return ("No tires basura - Bajas a cuadro 4\n\n");
        }

        if(p.getPosicion()==16) // CUADRO 16
        {
            return ("Desperdiciaste mucha agua - Bajas a cuadro 2\n\n");
        }

        if(p.getPosicion()==18) // CUADRO 18
        {
            return ("Usaste Bicicleta muy bien - Subes a cuadro 30\n\n");
        }

        if(p.getPosicion()==21) // CUADRO 21
        {
            return ("Compraste Fruta empacada - Bajas a cuadro 8\n\n");
        }

        if(p.getPosicion()==22) // CUADRO 22
        {
            return ("Sacaste a pasear al perro - Subes a cuadro 36\n\n");
        }

        if(p.getPosicion()==23) // CUADRO 23
        {
            return ("Desperdisiaste Agua - Bajas al cuadro 9\n\n");
        }

        if(p.getPosicion()==28) // CUADRO 28
        {
            return ("Reutilizaste hojas usadas - Subes a cuadro 43\n\n");
        }

        if(p.getPosicion()==31) // CUADRO 31
        {
            return ("Reciclaste muy bien - Subes a cuadro 40\n\n");
        }

        if(p.getPosicion()==33) // CUADRO 33
        {
            return ("Desperdisiaste mucha agua bañandote - Bajas a cuadro 25\n\n");
        }

        if(p.getPosicion()==38) // CUADRO 38
        {
            return ("Desperdiciaste mucha electricidad - Bajas cuadro 32\n\n");
        }

        if(p.getPosicion()==39) // CUADRO 39
        {
            return ("Reciclaste muy bien - Subes cuadro 45\n\n");
        }

        if(p.getPosicion()==41) // CUADRO 41
        {
            return ("Desperdisiaste mucho los botes de plastico - Bajas cuadro 27\n\n");
        }

        if(p.getPosicion()==44) // CUADRO 44
        {
            return ("Contaminaste aguas - Bajas cuadro 42\n\n");
        }

        if(p.getPosicion()==47) // CUADRO 47
        {
            return ("Usaste tenedor de plastico - Bajas cuadro 37\n\n");
        }
        return "";
    }

    public void renderDados(int num)
    {
        BufferStrategy bs= this.getBufferStrategy();
        Graphics g = bs.getDrawGraphics();

        if(num==1) { g.drawImage(dado1, 155, 10, 60, 60, this);}
        if(num==2) { g.drawImage(dado2, 155, 10, 60, 60, this);}
        if(num==3) { g.drawImage(dado3, 155, 10, 60, 60, this);}
        if(num==4) { g.drawImage(dado4, 155, 10, 60, 60, this);}
        if(num==5) { g.drawImage(dado1, 155, 10, 60, 60, this);}
        if(num==6) { g.drawImage(dado6, 155, 10, 60, 60, this);}

    }
}
