package juegos.ruleta;

import javax.swing.*;
import java.awt.*;

public class Carta extends JFrame {
    public JPanel panel = new JPanel();
    
    static int numero;
    public Carta(){
        this.setSize(500,640);
        this.setLocationRelativeTo(null);
        setTitle("Carta");//titulo del juego

        IniciarComponentes();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    private void IniciarComponentes(){
        this.getContentPane().add(panel);
        //poner la imagen en el panel
        numero= (int)(Math.random()*29+1);
        //System.out.println(" "+numero);
            if (numero == 1){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/1.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 2){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/2.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 3){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/3.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 4){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/4.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 5){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/5.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 6){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/6.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 7){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/7.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 8){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/8.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 9){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/9.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 10){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/10.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 11){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/11.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 12){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/12.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 13){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/13.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 14){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/14.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 15){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/15.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 16) {
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/16.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0, 0, 500, 550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500, 550, Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 17){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/17.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 18){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/18.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 19){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/19.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 20){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/20.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 21){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/21.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 22){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/22.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 23){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/23.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 24){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/24.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 25){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/25.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 26){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/26.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 27){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/27.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 28){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/28.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);
            }
            if (numero == 29){
                ImageIcon imagen = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/29.png");
                JLabel imagen1 = new JLabel();//creo la etiqueta
                imagen1.setBounds(0,0,500,550);
                //aqui estoy redimensionando la imagen, para que quepa en el panel
                imagen1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(500,550,Image.SCALE_SMOOTH)));
                panel.add(imagen1);

            }

    }



}
