package juegos.ruletaF;

import java.io.Serializable;

//Clase para hacer devoluciones de la resolucion que tendra la imagen que vaya agregando

public class Vector2 implements Serializable {
    private int x = 0;
    private int y = 0;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}