package juegos.ruletaF;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//Clase para crear botones

public class GButton extends JButton {
    private JButton root;
    private String path;

    //Constructores la resolucion de la imagen y la ruta
    public GButton(Vector2 size, String pathImage) {
        root = this;
        path = pathImage;

        setSize(size.getX(), size.getY());
        setContentAreaFilled(false);
        setBorderPainted(false);

        setIcon(ImageTool.resizeImage(pathImage, getWidth(), getHeight()));

        //Transicion de imagen al pasar sobre la imagen
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!PopUp.isVisible) setIcon(ImageTool.resizeImage(path, getWidth() / 2, getHeight() / 2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!PopUp.isVisible) setIcon(ImageTool.resizeImage(path, getWidth(), getHeight()));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                setIcon(ImageTool.resizeImage(path, getWidth(), getHeight()));
            }
        });
    }
}