package juegos.ruletaF;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class PopUp extends JPanel {

    public static boolean isVisible = false;

    private GButton btnInformacion;
    private GButton btnTarjeta;
    private GButton back;

    public PlayMusic efecto = new PlayMusic();

    private JPanel _root;

    private int numR;
    private String [] nombre;


    public PopUp(JPanel root) {

        _root = this;
        setLayout(null);
        setDefaultLocale(null);
        setBounds(0, 0, root.getWidth(), root.getHeight());
        setBackground(Color.decode("#32fd61"));//Color del fondo

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
        String reto[] = new String[20];
        reto[0]="src/resources/ruletaF_src/graficos/ecoReto/Reto_1.png";
        reto[1]="src/resources/ruletaF_src/graficos/ecoReto/Reto_2.png";
        reto[2]="src/resources/ruletaF_src/graficos/ecoReto/Reto_3.png";
        reto[3]="src/resources/ruletaF_src/graficos/ecoReto/Reto_4.png";
        reto[4]="src/resources/ruletaF_src/graficos/ecoReto/Reto_5.png";
        reto[5]="src/resources/ruletaF_src/graficos/ecoReto/Reto_6.png";
        reto[6]="src/resources/ruletaF_src/graficos/ecoReto/Reto_7.png";
        reto[7]="src/resources/ruletaF_src/graficos/ecoReto/Reto_8.png";
        reto[8]="src/resources/ruletaF_src/graficos/ecoReto/Reto_9.png";
        reto[9]="src/resources/ruletaF_src/graficos/ecoReto/Reto_10.png";
        reto[10]="src/resources/ruletaF_src/graficos/ecoReto/Reto_11.png";
        reto[11]="src/resources/ruletaF_src/graficos/ecoReto/Reto_12.png";
        reto[12]="src/resources/ruletaF_src/graficos/ecoReto/Reto_13.png";
        reto[13]="src/resources/ruletaF_src/graficos/ecoReto/Reto_14.png";
        reto[14]="src/resources/ruletaF_src/graficos/ecoReto/Reto_15.png";
        reto[15]="src/resources/ruletaF_src/graficos/ecoReto/Reto_16.png";
        reto[16]="src/resources/ruletaF_src/graficos/ecoReto/Reto_17.png";
        reto[17]="src/resources/ruletaF_src/graficos/ecoReto/Reto_18.png";
        reto[18]="src/resources/ruletaF_src/graficos/ecoReto/Reto_19.png";
        reto[19]="src/resources/ruletaF_src/graficos/ecoReto/Reto_20.png";

        
        btnTarjeta = new GButton(new Vector2(200, 350), "resources/ruletaF_src/graficos/ecoReto/TarjetaECORETO1.png");
        btnTarjeta.setBounds((int) (getWidth() - btnTarjeta.getWidth()) / 2, (int) (getHeight() - 370), btnTarjeta.getWidth(), btnTarjeta.getHeight());
        btnTarjeta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                efecto.efectoYeah();
                efecto.play();
                int numR = (int) Math.floor(Math.random()*20);
                Icon icon = new ImageIcon(reto[numR]);
                JOptionPane.showMessageDialog(_root,"","Reto",JOptionPane.INFORMATION_MESSAGE,icon);
            }
        });

        btnInformacion = new GButton(new Vector2(650, 550), "resources/ruletaF_src/graficos/ecoReto/jugarins.png");
        btnInformacion.setBounds((int) (getWidth() - btnInformacion.getWidth()) / 2, (int) (getHeight() - 830), btnInformacion.getWidth(), btnInformacion.getHeight());


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
                if (PopUp.isVisible) back.setBackground(Color.decode("#32fd61"));
            }

            //Color predefinido del boton regresar en gris
            @Override
            public void mouseExited(MouseEvent e) {
                if (PopUp.isVisible) back.setBackground(Color.LIGHT_GRAY);
            }
        });


        add(btnTarjeta);
        add(btnInformacion);
        add(back);

    }



}