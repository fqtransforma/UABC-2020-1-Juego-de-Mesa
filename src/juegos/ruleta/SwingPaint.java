package juegos.ruleta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingPaint {

    JButton clearBtn,blackBtn,blueBtn,greenBtn,redBtn,magentaBtn,jugarBtn;
    JFrame panel = new JFrame();

    static int num;
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
        frame.setLocation(10,10);
        Container content =  frame.getContentPane();
        //Creamos el Layout del contenido
        content.setLayout(new BorderLayout());
        //Creamos el are de dibujo
        dGame = new DGame();
        //Agregamos al contenido
        content.add(dGame, BorderLayout.CENTER);
        //Creamos controles para aplicar colores y de limpia
        JPanel controls = new JPanel();
        ImageIcon carta = new ImageIcon("src/resources/ruleta_src/graficos/Adibujar/01.png");
        //carta.getImage().getScaledInstance(200,50,Image.SCALE_SMOOTH);
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(actionListener);
        clearBtn.setFont(new Font("cooper black",0,30));
        blackBtn = new JButton("Black");
        blackBtn.setFont(new Font("cooper black",0,30));
        blackBtn.addActionListener(actionListener);
        blueBtn = new JButton("Blue");
        blueBtn.setForeground(Color.BLUE);
        blueBtn.setFont(new Font("cooper black",0,30));
        blueBtn.addActionListener(actionListener);
        greenBtn = new JButton("Green");
        greenBtn.setForeground(Color.GREEN);
        greenBtn.setFont(new Font("cooper black",0,30));
        greenBtn.addActionListener(actionListener);
        redBtn = new JButton("Red");
        redBtn.setForeground(Color.RED);
        redBtn.setFont(new Font("cooper black",0,30));
        redBtn.addActionListener(actionListener);
        magentaBtn = new JButton("Magenta");
        magentaBtn.setForeground(Color.MAGENTA);
        magentaBtn.setFont(new Font("cooper black",0,30));
        magentaBtn.addActionListener(actionListener);
        jugarBtn = new JButton("");
        //jugarBtn.setFont(new Font("cooper black",0,30 ));

        jugarBtn.setIcon(carta);
        //evento para que cuando presione Jugar aparezaca lo que dibujara
        ActionListener act = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                juego();
            }
        };
        jugarBtn.addActionListener(act);

        //Agregar Panel
        controls.add(greenBtn);
        controls.add(blueBtn);
        controls.add(blackBtn);
        controls.add(redBtn);
        controls.add(magentaBtn);
        controls.add(clearBtn);
        //este boton al presionarse muestra la carta con lo que se dibujara
        controls.add(jugarBtn);

        //Agregar al contenido
        content.add(controls, BorderLayout.NORTH);

        frame.setSize(1200, 700);
        //Puede cerrar el Frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Mostrar el panel a pintar
        frame.setVisible(true);
    }
    public void juego(){
        Carta c = new Carta();
        c.setVisible(true);
    }


}


