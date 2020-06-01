package juegos.ruleta;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class EcoPista {
    public static void InitEcopista(){
        cent win = new cent();

        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// al presionar la X del frame se cerrara el programa

        win.setVisible(true);//que sea visible la ventana

    }

}

class cent extends JFrame{ //posicion del frame

    public cent(){

        Toolkit window = Toolkit.getDefaultToolkit();

        setSize(700,600);
        setLocationRelativeTo(null);
        setTitle("EcoPista");//titulo del frame

        /*Image icono = window.getImage("Ruleta-1.png"); // icono de la ventana
        setIconImage(icono);
        */
        ponerImagen img = new ponerImagen();
        botton();

        add(img);
    }

    private void botton() {

        /**/
        JButton boton1 = new JButton("Pista!");
        boton1.setBounds(450,100, 200,40);
        boton1.setForeground(Color.orange);//color letra
        //boton.setBackground(Color.green);//color boton
        boton1.setFont(new Font("cooper black",0,30 ));
        add(boton1);
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==boton1){
                    Random r = new Random();
                    int val = r.nextInt(10);
                    //CambioImg sw = new CambioImg(val);
                    if(val == 1){
                        JOptionPane.showInternalMessageDialog(null, "Pista 1");}
                    else if(val == 2){
                        JOptionPane.showInternalMessageDialog(null, "Pista 2");}
                    else if(val == 3){
                        JOptionPane.showInternalMessageDialog(null, "Pista 3");}
                    else if(val == 4){
                        JOptionPane.showInternalMessageDialog(null, "Pista 4");}
                    else if(val == 5){
                        JOptionPane.showInternalMessageDialog(null, "Pista 5");}
                    else{
                        JOptionPane.showInternalMessageDialog(null, "Pista 6");}
                }
            }

        });


        /*BOTON DE SALIDA*/
        JButton boton = new JButton("Salir");
        boton.setBounds(450,400, 200,40);
        boton.setForeground(Color.orange);//color letra
        //boton.setBackground(Color.green);//color boton
        boton.setFont(new Font("cooper black",0,30 ));
        add(boton);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==boton){
                    System.exit(0);//Este boton se cambia por volver al menu principal

                }
            }
        });
    }/**/

}

/* //texto dentro del frame
    class text extends JPanel{
        public void paintComponent(Graphics g){

            super.paintComponent(g);
            g.drawString("PRUEBA" ,100,100 );//texto en el panel         }
    }
    }
*/
class ponerImagen extends JPanel{

    public void paintComponent(Graphics g){//poner la imagen

        super.paintComponent(g);
        File miimage = new File("src/resources/ruleta_src/graficos/ecopista/EcopistasPrin.png");//coloco la direccion de la imagen en un FILE

        try {//si no pongo el try catch, el IMAGEIO.read marca error por si acaso el FILE no esta bien escrito
            image = ImageIO.read(miimage).getScaledInstance(300,500,Image.SCALE_SMOOTH);//coloca la imagen

        }catch (IOException e){
            System.out.println("NO IMAGEN");
        }


        g.drawImage(image,35,30,null);//dibuja la imagen en el siguiente orden
        //IMAGEN, posicion en x, posicion en y, null obligatorio(no recuerdo la razon)

    }

    private Image image; //inicialiso la imagen
}


