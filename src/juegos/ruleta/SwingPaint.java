package juegos.ruleta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingPaint {

    JButton clearBtn,blackBtn,blueBtn,greenBtn,redBtn,magentaBtn;
    DGame dGame;
    ActionListener actionListener =  new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()== clearBtn){
                dGame.clear();
            }else if(e.getSource()==blackBtn){
                dGame.black();
            }else if(e.getSource()==blueBtn){
                dGame.blue();
            }else if(e.getSource()==greenBtn){
                dGame.green();
            }else if(e.getSource()==redBtn){
                dGame.red();
            }else if(e.getSource()==magentaBtn){
                dGame.magenta();
            }
        }
    };

    public static void InitPaint() {
        new SwingPaint().show();
    }

    public void show() {
        //Creamos el frame principal
        JFrame frame = new JFrame("Swing Paint");
        Container content =  frame.getContentPane();
        //Creamos el Layout del contenido
        content.setLayout(new BorderLayout());
        //Creamos el are de dibujo
        dGame = new DGame();
        //Agregamos al contenido
        content.add(dGame, BorderLayout.CENTER);
        //Creamos controles para aplicar colores y de limpia
        JPanel controls = new JPanel();

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(actionListener);
        blackBtn = new JButton("Black");
        blackBtn.addActionListener(actionListener);
        blueBtn = new JButton("Blue");
        blueBtn.addActionListener(actionListener);
        greenBtn = new JButton("Green");
        greenBtn.addActionListener(actionListener);
        redBtn = new JButton("Red");
        redBtn.addActionListener(actionListener);
        magentaBtn = new JButton("Magenta");
        magentaBtn.addActionListener(actionListener);

        //Agregar Panel
        controls.add(greenBtn);
        controls.add(blueBtn);
        controls.add(blackBtn);
        controls.add(redBtn);
        controls.add(magentaBtn);
        controls.add(clearBtn);

        //Agregar al contenido
        content.add(controls, BorderLayout.NORTH);

        frame.setSize(600, 600);
        //Puede cerrar el Frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Mostrar el panel a pintar
        frame.setVisible(true);
    }
}


