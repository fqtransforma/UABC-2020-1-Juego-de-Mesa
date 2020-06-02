package juegos.ruletaF;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Animales extends JFrame implements ActionListener {
    private JButton boton1,boton2;
    public void Animal(){
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);

        setVisible(true);

        setContentPane(new JLabel(new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Animales.png")));
        setBounds(750,80,600,800);

        boton1=new JButton("Ayuda");
        ImageIcon icono1 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Help.png");
        boton1.setIcon(icono1);
        boton1.setBorder(null);
        boton1.setBounds(550,750,35,25);
        add(boton1);
        boton1.addActionListener(this);

        boton2=new JButton("Back");
        ImageIcon icono5 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Cerrar.png");
        boton2.setIcon(icono5);
        boton2.setBorder(null);
        boton2.setBounds(550,10,35,35);
        add(boton2);
        boton2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1) {

            try {
                Clip sonido = AudioSystem.getClip();
                File a= new File("src/resources/ruletaF_src/audio/musica/Mhelp.wav");
                sonido.open(AudioSystem.getAudioInputStream(a));
                sonido.start();
                JOptionPane.showMessageDialog(null, "El usuario debe mencionar Animales \n"+"ejemplo\n"+"Perro\nLeon");
                sonido.close();
            } catch (Exception tipoError) {
                System.out.println("" + tipoError);
            }

        }
        if (e.getSource() == boton2) {

            try {
                Clip sonido = AudioSystem.getClip();
                File a= new File("src/resources/ruletaF_src/audio/musica/Mback.wav");
                sonido.open(AudioSystem.getAudioInputStream(a));
                sonido.start();
                Thread.sleep(100);
                this.toBack();
                setVisible(false);
                sonido.close();

            } catch (Exception tipoError) {
                System.out.println("" + tipoError);
            }
        }
    }
}