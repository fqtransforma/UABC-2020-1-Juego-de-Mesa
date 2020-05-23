package juegos.ruletaF;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

public class SeresVivos extends JFrame implements ActionListener {

    private JButton boton1,boton2;

    public boolean Seres(){
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);



        setContentPane(new JLabel(new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/perro.png")));


        setBounds(800,80,645,800);
        boton1=new JButton("Ayuda");
        ImageIcon icono1 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Caricturas.PNG");
        boton1.setIcon(icono1);
        boton1.setBounds(30,80,130,50);
        add(boton1);
        boton1.addActionListener(this);

        boton2=new JButton("Back");
        ImageIcon icono5 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/back.png");
        boton2.setIcon(icono5);
        boton2.setBounds(20,20,130,50);
        add(boton2);
        boton2.addActionListener(this);
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1) {
            JOptionPane.showMessageDialog(null, "El usuario debe mencionar seres vivos \n"+"ejemplo\n"+"animales\nplantas");

        }
        if (e.getSource() == boton2) {

            this.toBack();
            setVisible(false);


        }
    }
}
