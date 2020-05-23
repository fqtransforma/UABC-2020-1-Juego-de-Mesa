package juegos.ruletaF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

public class Home extends JPanel {
    private WindowApp app;

    private JLabel centerIcon;
    private PopUp popUp;

    private GButton btnInicio;
    private GButton btnRedesSociales;
    private GButton btnAyuda;
    private GButton btnClose;


    public Home(final WindowApp app, int width, int height) throws IOException, ClassNotFoundException {
        final Home root = this;
        this.app = app;
        app.audio.run();

        setLayout(null);
        setSize(width, height);
        popUp = new PopUp(root);

        centerIcon = new JLabel();
        centerIcon.setSize((int) (width * 0.75), (int) (height * 0.70));
        centerIcon.setBounds((int) (((getWidth() - centerIcon.getWidth()) / 2) * 1.25), (getHeight() - centerIcon.getHeight()) / 2, centerIcon.getWidth(), centerIcon.getHeight());
        centerIcon.setIcon(ImageTool.resizeImage("Images/iconHome.png", centerIcon.getWidth(), centerIcon.getHeight()));

        btnInicio = new GButton(new Vector2(150, 150), "Images/icons/Inicio.png");
        btnInicio.setBounds((int) (getWidth() - btnInicio.getWidth()) / 2, (int) (getHeight() - 200), btnInicio.getWidth(), btnInicio.getHeight());
        btnInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!popUp.isVisible()) {
                    popUp.setVisible(true);
                    PopUp.isVisible = true;
                    popUp.repaint();

                } else {
                    popUp.setVisible(false);
                    PopUp.isVisible = false;
                }
                repaint();
            }
        });



        btnRedesSociales = new GButton(new Vector2(100, 100), "Images/icons/FQT.png");
        btnRedesSociales.setBounds(30, (int) (getHeight() - 30 - btnRedesSociales.getHeight()), btnRedesSociales.getWidth(),btnRedesSociales.getHeight());
        btnRedesSociales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!PopUp.isVisible) JOptionPane.showMessageDialog(root, "Siguenos en nuestras redes sociales \n\n Facebook: Fundacion Que Transforma \n Instagram:@ fqtransforma \nSitio Web: www.fqt.org.mx");
            }
        });


        btnAyuda = new GButton(new Vector2(100, 100), "Images/icons/News.png");
        btnAyuda.setBounds(getWidth() - btnInicio.getWidth() - 30, (int) (getHeight() - 30 - btnAyuda.getHeight()), btnAyuda.getWidth(), btnAyuda.getHeight());
        btnAyuda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!PopUp.isVisible) JOptionPane.showMessageDialog(root, "Ayuda \n\n Como se juega \n Cumple con los retos que se te mostrara en la pantalla");
            }
        });


        btnClose = new GButton(new Vector2(150, 150), "Images/icons/Close.png");
        btnClose.setBounds(getWidth() - btnClose.getWidth() - 30, 30, btnClose.getWidth(), btnClose.getHeight());
        btnClose.setToolTipText("Cerrar juego");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!PopUp.isVisible) {
                    app.audio.stop();
                    app.setVisible(false);
                    app.dispose();
                }
            }
        });


        add(btnClose);
        add(btnAyuda);
        add(btnRedesSociales);
        add(centerIcon);
        add(btnInicio);
        add(popUp);
        repaint();
        eventMoveLogoCenter();
    }

    private void eventMoveLogoCenter() {
        addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
            }

            public void mouseMoved(MouseEvent e) {
                final Point point = MouseInfo.getPointerInfo().getLocation();
                final Dimension screen = app.getSize();
                final int x = ((screen.width - point.x / 20) - centerIcon.getWidth() / 2) / 4;
                final int y = ((screen.height - point.y / 20) - centerIcon.getHeight() / 2) / 4;

                centerIcon.setBounds(x, y, centerIcon.getWidth(), centerIcon.getHeight());
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(new ImageIcon(ImageTool.getImage("Images/background.jpg")).getImage(), 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        if (PopUp.isVisible) {
            for (Component x : getComponents()) x.setVisible(false);
            popUp.setVisible(true);
        } else {
            for (Component x : getComponents()) x.setVisible(true);
            popUp.setVisible(false);
        }
        popUp.repaint();
        super.paint(g);
    }
}