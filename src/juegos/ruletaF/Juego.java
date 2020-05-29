package juegos.ruletaF;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
/*  try {
                Clip sonido = AudioSystem.getClip();
                File a= new File("src/Musica/Mfondo.wav");
                sonido.open(AudioSystem.getAudioInputStream(a));
                sonido.start();
                //Contenido de opcion
                sonido.close();
            } catch (Exception tipoError) {
                System.out.println("" + tipoError);
            }*/

public class Juego extends JFrame implements ActionListener {

    private JButton escoje,boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8,boton9,boton10;
    private JPanel panel;
      Clip  fondo ;
    public Juego(){
        super("Caricaturas");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/fondo.jpg")));
        setExtendedState(JFrame.MAXIMIZED_BOTH);

       /* panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setVisible(true);
        panel.setBounds(800,80,645,800);
        add(panel);*/
        try {
            fondo=AudioSystem.getClip();
            File a= new File("src/resources/ruletaF_src/audio/musica/Mfondo.wav");
            fondo.open(AudioSystem.getAudioInputStream(a));
            fondo.start();


        escoje=new JButton("Escoje");
        ImageIcon icone = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Escoje.png");
        escoje.setIcon( icone);
        escoje.setBorder(null);
        escoje.setBounds(30,850,638,150);
        add(escoje);

        boton1=new JButton("SeresVivos");
        ImageIcon icono1 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Caricaturas.PNG");
        boton1.setIcon(icono1);
        boton1.setBounds(30,80,140,230);
        add(boton1);
        boton1.addActionListener(this);

        boton2=new JButton("Animales");
        ImageIcon icono2 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Caricaturas.PNG");
        boton2.setIcon(icono2);
        boton2.setBounds(30,340,140,230);
        add(boton2);
        boton2.addActionListener(this);

        boton3=new JButton("Minerales");
        ImageIcon icono3 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Caricaturas.PNG");
        boton3.setIcon(icono3);
        boton3.setBounds(30,600,140,230);
        add(boton3);
        boton3.addActionListener(this);

        boton4=new JButton("RecursosNat");
        ImageIcon icono4 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Caricaturas.PNG");
        boton4.setIcon(icono4);
        boton4.setBounds(235,80,140,230);
        add(boton4);
        boton4.addActionListener(this);

        boton5=new JButton("Plantas");
        ImageIcon icono5 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Caricaturas.PNG");
        boton5.setIcon(icono5);
        boton5.setBounds(235,340,140,230);
        add(boton5);
        boton5.addActionListener(this);
        setVisible(true);

        boton6=new JButton("RecursosOrg");
        ImageIcon icono6 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Caricaturas.PNG");
        boton6.setIcon(icono5);
        boton6.setBounds(235,600,140,230);
        add(boton6);
        boton6.addActionListener(this);
        setVisible(true);

        boton7=new JButton("RecursosReno");
        ImageIcon icono7 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Caricaturas.PNG");
        boton7.setIcon(icono7);
        boton7.setBounds(450,80,140,230);
        add(boton7);
        boton7.addActionListener(this);
        setVisible(true);

        boton8=new JButton("RecursosNorenov");
        ImageIcon icono8 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Caricaturas.PNG");
        boton8.setIcon(icono8);
        boton8.setBounds(450,340,140,230);
        add(boton8);
        boton8.addActionListener(this);
        setVisible(true);

        boton9=new JButton("SeresNoVivo");
        ImageIcon icono9 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Caricaturas.PNG");
        boton9.setIcon(icono9);
        boton9.setBounds(450,600,140,230);
        add(boton9);
        boton9.addActionListener(this);
        setVisible(true);

        boton10=new JButton("Back");
        ImageIcon icono10 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/back.png");
        boton10.setIcon(icono10);
        boton10.setBounds(10,10,130,50);
        add(boton10);
        boton10.addActionListener(this);

        setVisible(true);

        fondo.loop(5);


    } catch (Exception tipoError) {
        System.out.println("" + tipoError);
    }

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==boton1) {

            try {
                Clip sonido = AudioSystem.getClip();
                File a= new File("src/resources/ruletaF_src/audio/musica/Escojer.wav");
                sonido.open(AudioSystem.getAudioInputStream(a));
                SeresVivos seres1=new SeresVivos();
                sonido.start();
                seres1.Seres();
                Thread.sleep(1000);
                sonido.close();
            } catch (Exception tipoError) {
                System.out.println("" + tipoError);
            }

        }
        if (e.getSource()==boton2) {
            try {
                Clip sonido = AudioSystem.getClip();
                File a= new File("src/resources/ruletaF_src/audio/musica/Escojer.wav");
                sonido.open(AudioSystem.getAudioInputStream(a));
                sonido.start();
                Animales animal1=new Animales();
                animal1.Animal();
                Thread.sleep(1000);
                sonido.close();
            } catch (Exception tipoError) {
                System.out.println("" + tipoError);
            }


        }
        if (e.getSource()==boton3) {
            try {
                Clip sonido = AudioSystem.getClip();
                File a= new File("src/resources/ruletaF_src/audio/musica/Escojer.wav");
                sonido.open(AudioSystem.getAudioInputStream(a));
                sonido.start();
                Minerales mineral =new Minerales();
                mineral.Mineral();
                Thread.sleep(1000);
                sonido.close();
            } catch (Exception tipoError) {
                System.out.println("" + tipoError);
            }

        }
        if (e.getSource()==boton4) {
            try {
                Clip sonido = AudioSystem.getClip();
                File a= new File("src/resources/ruletaF_src/audio/musica/Escojer.wav");
                sonido.open(AudioSystem.getAudioInputStream(a));
                RecursosNat recurso =new RecursosNat();
                recurso.Recursos();
                sonido.start();
                Thread.sleep(1000);
                sonido.close();
            } catch (Exception tipoError) {
                System.out.println("" + tipoError);
            }

        }
        if (e.getSource()==boton5) {
            try {
                Clip sonido = AudioSystem.getClip();
                File a= new File("src/resources/ruletaF_src/audio/musica/Escojer.wav");
                sonido.open(AudioSystem.getAudioInputStream(a));
                Plantas planta =new Plantas();
                planta.Planta();
                sonido.start();
                Thread.sleep(1000);
                sonido.close();
            } catch (Exception tipoError) {
                System.out.println("" + tipoError);
            }

        }
        if (e.getSource()==boton6) {
            try {
                Clip sonido = AudioSystem.getClip();
                File a= new File("src/resources/ruletaF_src/audio/musica/Escojer.wav");
                sonido.open(AudioSystem.getAudioInputStream(a));
                RecursosOrg recurso =new RecursosOrg();
                recurso.Organico();
                sonido.start();
                Thread.sleep(1000);
                sonido.close();
            } catch (Exception tipoError) {
                System.out.println("" + tipoError);
            }

        }
        if (e.getSource()==boton7) {
            try {
                Clip sonido = AudioSystem.getClip();
                File a= new File("src/resources/ruletaF_src/audio/musica/Escojer.wav");
                sonido.open(AudioSystem.getAudioInputStream(a));
                RecursosRenov recurso =new RecursosRenov();
                recurso.Renovable();
                sonido.start();
                Thread.sleep(1000);
                sonido.close();
            } catch (Exception tipoError) {
                System.out.println("" + tipoError);
            }

        }
        if (e.getSource()==boton8) {
            try {
                Clip sonido = AudioSystem.getClip();
                File a= new File("src/resources/ruletaF_src/audio/musica/Escojer.wav");
                sonido.open(AudioSystem.getAudioInputStream(a));
                RecursosNoRenov recurso =new RecursosNoRenov();
                recurso.NoRenovable();
                sonido.start();
                Thread.sleep(1000);
                sonido.close();
            } catch (Exception tipoError) {
                System.out.println("" + tipoError);
            }

        }
        if (e.getSource()==boton9) {
            try {
                Clip sonido = AudioSystem.getClip();
                File a= new File("src/resources/ruletaF_src/audio/musica/Escojer.wav");
                sonido.open(AudioSystem.getAudioInputStream(a));
                SeresNoVivos seres1=new SeresNoVivos();
                seres1.NoVivo();
                sonido.start();
                Thread.sleep(1000);
                sonido.close();
            } catch (Exception tipoError) {
                System.out.println("" + tipoError);
            }
        }
        if (e.getSource()==boton10)
        {
            fondo.close();
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
