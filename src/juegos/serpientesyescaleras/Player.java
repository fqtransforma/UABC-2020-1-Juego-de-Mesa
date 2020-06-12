package juegos.serpientesyescaleras;

public class Player{

    public double x;
    public double y;

    private double velX=0;
    private double velY=0;

    private int posicion=1;

    public int getPosicion() {
        return posicion;
    }

    public void avanzar(int posicion) {
        this.posicion = this.posicion+posicion;
    }


    private String name;

    public Player(double x,double y,String nombre)
    {
        this.x=x;
        this.y=y;
        this.name=nombre;
    }

    public String getName() {
        return name;
    }

    public double getVelX() {
        return velX;
    }

    public double getVelY() {
        return velY;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public void setX(double x)
    {
        this.x=x;
    }

    public void setY(double y)
    {
        this.y=y;
    }

    public void setVelX(double velX)
    {
     this.velX=velX;
    }

    public void setVelY(double velY)
    {
        this.velY=velY;
    }

    public void tick() {
        int limSuperiorX = 800;
        int limInferiorX = 0;
        int limSuperiorY = 600;
        int limInferiorY = 10;

        x += velX;
        y += velY;

        ////////////////////////////////////////////////////

        if(getPosicion()==49)
        {
            x=700;
            y=400;
        }

        //Limitar los bordes de la pantalla para el movimiento

        if (x <= limInferiorX)
            x = limInferiorX;

        if (x >= limSuperiorX)
            x = limSuperiorX;

        if (y <= limInferiorY)
            y = limInferiorY;

        if (y >= limSuperiorY)
            y = limSuperiorY;

        if (y > 500) // validar abajo corregir
            y = 450;

        if (y < 30)//reset posicion una vez llega tope
            y = 25;

        if (x == 800)//valida derecha corregir
            x = 750;

        if (x < 1) //valida izquierda
            x = 10;
    }
}
