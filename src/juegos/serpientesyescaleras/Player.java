package juegos.serpientesyescaleras;

import java.awt.image.BufferedImage;

public class Player{

    public int x;
    public int y;
    private int posicion=1;
    private int renglon=1;
    private String name;
    private BufferedImage image;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Player(String nombre, int x, int y, BufferedImage n){
        this.name=nombre;
        this.x = x;
        this.y = y;
        this.image = n;
    }

    public void subirRenglon() {
        this.renglon += 1;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int n){
        this.posicion=n;
    }

    public void setRenglon(int renglon) {
        this.renglon = renglon;
    }

    public void incPosicion(){
        this.posicion +=1;
    }

    public String getName() {
        return name;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public BufferedImage getImage(){
        return image;
    }

    public void mover(){
        if(this.renglon % 2 !=0){ // si el jugador esta en un renglon de numero impar se mueve hacia izquierda , caso contrario se mueve hacia derecha
            x += -145;
        }
        else{
            x += 145;
        }
    }

}
