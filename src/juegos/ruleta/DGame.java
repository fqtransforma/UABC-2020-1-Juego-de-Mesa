package juegos.ruleta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DGame extends JComponent {

    //Donde vamos a dibujar
    private Image image;
    //Graphics 2D object, usado para dibujar
    private Graphics2D g2;
    //Coordenadas para el mouse
    private  int currentX, currentY, oldX, oldY;

    public DGame() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //Guardar coordenadas de X y Y cuando el mouse es presionado
                oldX= e.getX();
                oldY= e.getY();
            }

        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e){
                //Coordenadas x y y cuando se jala el mouse
                currentX= e.getX();
                currentY= e.getY();

                if (g2 != null){
                    //Dibuja una linea si g2 no es null
                    g2.drawLine(oldX,oldY,currentX,currentY);
                    //refresca el area de dibujo para repintar
                    repaint();
                    //Guarda las coordenadas actuales x y y como las viejas x y y
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (image == null) {
            //imagen para crear null, la creamos
            image = createImage(getSize().width,getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            //Activamos Antianalising
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            //Limpiamos el area de Dibujo
            clear();
        }
        g.drawImage(image,0,0,null);
    }
    //Creamos los metodos expuestos

    public void clear () {
        g2.setPaint(Color.white);//Dibuja blanco toda el area a limpiar
        g2.fillRect(0,0,getSize().width,getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }

    public void red() {
        //aplicar color rojo en g2
        g2.setPaint(Color.red);

    }
    public void black() {
        //aplicar color negro en g2
        g2.setPaint(Color.black);

    }
    public void magenta() {
        //aplicar color magenta en g2
        g2.setPaint(Color.magenta);

    }
    public void green() {
        //aplicar color green en g2
        g2.setPaint(Color.green);

    }
    public void blue() {
        //aplicar color blue en g2
        g2.setPaint(Color.blue);

    }

    //Se creara la parte principal del programa para el uso de la zona de dibujo

}
