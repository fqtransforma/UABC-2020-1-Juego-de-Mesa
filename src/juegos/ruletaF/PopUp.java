package juegos.ruletaF;


import juegos.ruletaF.GButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PopUp extends JPanel {
    public static boolean isVisible = false;


    private GButton btnTarjeta;
    private GButton back;
    private JPanel _root;

    public PopUp(JPanel root) {

        _root = this;
        setLayout(null);
        setDefaultLocale(null);
        setBounds(0, 0, root.getWidth(), root.getHeight());
        setBackground(Color.GREEN);//Color del fondo

        init();
        addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
        setVisible(false);


    }


    private void init() {

        btnTarjeta = new GButton(new Vector2(150, 200), "resources/ruletaF_src/graficos/ecoReto/TarjetaECORETO.png");
        btnTarjeta.setBounds(900,500, btnTarjeta.getWidth(), btnTarjeta.getHeight());
        btnTarjeta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (PopUp.isVisible) JOptionPane.showMessageDialog(_root,"Vuelvo en 20 minutos ");

            }
        });

        back = new GButton(new Vector2(250, 50), "");
        back.setText("Regresar al menu principal");
        back.setBackground(Color.LIGHT_GRAY);
        back.setContentAreaFilled(true);
        back.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e) {
                if (PopUp.isVisible) {
                    back.setBackground(Color.WHITE);
                    _root.setVisible(false);
                    PopUp.isVisible = false;

                }
            }
            //Color predefinido del regresar verde cuando pasa el mouse en el
            @Override
            public void mouseEntered(MouseEvent e) {
                if (PopUp.isVisible) back.setBackground(Color.GREEN);
            }

            //Color predefinido del boton regresar en gris
            @Override
            public void mouseExited(MouseEvent e) {
                if (PopUp.isVisible) back.setBackground(Color.LIGHT_GRAY);
            }
        });

        add(btnTarjeta);
        add(back);
    }

}