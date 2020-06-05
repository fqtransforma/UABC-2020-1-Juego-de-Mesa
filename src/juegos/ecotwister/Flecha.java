package juegos.ecotwister;

import javax.swing.*;
import java.awt.*;

public class Flecha extends JPanel {

    int xF, yF, radio, grosor;
    Color color;
    double angulo;
    protected Graphics gOff;

    public Flecha() {
        xF = yF = 0;
        radio = 1;
        angulo = 0d;
    }

    public void setParametros (int xF, int yF, int radio, int grosor, Color color){
        this.xF = xF;
        this.yF = yF;
        this.radio = radio;
        this.grosor = grosor;
        this.color = color;
        calcular();
    }

    public  void setAngulo (double angulo){
        this.angulo = angulo;
        calcular();
    }

    public final static double Cuarto = Math.PI/2;
    public final static double Medio = Math.PI;

    int[] xpuntos = new int[4];
    int[] ypuntos = new int[4];

    public void calcular (){
        int radio2 = (int) (grosor/2);
        double angulo = -this.angulo + Cuarto;

        xpuntos[0] = (int)(xF + radio * Math.cos(angulo));
        ypuntos[0] = (int)(yF - radio * Math.sin(angulo));

        for(int i=1; i<4; ++i){
            angulo += Cuarto;
            xpuntos[i] = (int)(xF + radio2 * Math.cos(angulo));
            ypuntos[i] = (int)(yF - radio2 * Math.sin(angulo));
        }
    }

    public void paint (Graphics g){
        g.setColor(color);
        g.fillPolygon(xpuntos,ypuntos,4);
        g.setColor(color.brighter());
        g.drawPolygon(xpuntos,ypuntos,4);
    }
}
