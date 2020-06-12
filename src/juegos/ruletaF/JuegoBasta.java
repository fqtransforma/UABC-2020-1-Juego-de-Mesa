package juegos.ruletaF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;			// para random
import java.lang.*;         //para  java.lang.System.currentTimeMillis
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JuegoBasta extends JFrame implements Runnable{
    private JPanel panelArriba;
    private JPanel panelAbajo;
    private JPanel panelIzquierdo;
    private JPanel panelDerecho;
    private JPanel panelCentral;

    private JButton Iniciar;
    private JButton Reiniciar;
    private JButton Ayuda;
    private JButton Salir;
    private JButton Regresar;
    private JButton Sacar;
    private JButton Letra;

    private JPanel panelsubDerecho;
    private JPanel panelsubIzquierda;
    private JPanel panelsubArriba;
    private JPanel panelsubAbajo;
    private JPanel panelsubCentral;

    private JLabel label;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel tiempo;
    private JLabel labelAciertos;

    private ImageIcon labelImageP;
    private ImageIcon labelImage;
    private ImageIcon labelImage2P;
    private ImageIcon labelImage2;
    private ImageIcon labelImage3P;

    private Random r1= new Random(System.currentTimeMillis());
    private PlayMusic fondo= new PlayMusic();
    private PlayMusic fondo2= new PlayMusic();
    private PlayMusic sonido1= new PlayMusic();
    private PlayMusic sonido2= new PlayMusic();
    private PlayMusic sonido3= new PlayMusic();
    private PlayMusic sonido4= new PlayMusic();
    private JTextArea cajaTexto = new JTextArea(25,58);

    private String [] verduras ={"acedera","alcachofa","apio","arroz","berenjena","berro","brocoli","betabel","calabaza","calabacin","cardillo","cebolla","cereal","col","camote","champiñon","coliflor","esparrago","espinaca","girasol","guisante","hinojo","habichuela","judia","lechuga","maiz","nabo","ortiga","papa","patata","puerro","pepino","pimiento","rabano","remolacha","repollo","salsifi","soja","topinambur","zanahoria"};
    private String [] frutas ={"albaricoque","aguacate","arándano","banana","baya","caqui","coco","chirimoya","clementina","ceraza","cantalupo","ciruela","caña","dátil","durazno","frambueza","fresa","granadilla","grosella","guayaba","guanabana","higo","jicama","kiwi","limon","lima","manzana","melon","membrillo","mango","maracuya","mora","mamey","naranja","nectarina","pera","papaya","pomelo","pasa","panapen","piña","platano","pitaya","sandia","tuna","toronja","tangerina","tamarindo","tomate","tejocote","uva"};
    private String [] minerales ={"actinolita","ágata","aguamarina","alabastro","amazonita","ámbar","ambligonita","anatasa","andalucita","anhidrita","apatito","apofilita","aragonito","arsénico","aventurina","azabache","azufre","azurita","barita","bauxita","benitoíta","berilo","bismuto","calcedonia","calcita","calcopirita","casiterita","celestina","cerusita","cinabrio","cobre","cordierita","corindón","crisoberilo","crisocola","crisoprasa","crocoíta","cromita","cuarzo","cuprita","damburita","datolita","demantoide","diamante","diópsido","dioptasa","dolomita","epidota","escapolita","esfalerita","esmeralda","espinela","estaurolita","euclasa","fluorita","fosgenita","goethita","grafito","grosularia","hanksita","hematites","hemimorfita","hiddenita","hierro","ilmenita","jadeíta","jaspe","kunzita","labradorita","lapislázuli","lazulita","leucita","magnesita","malaquita","marcasita","mispíquel","obsidiana","ópalo","oro","oropimente","ortosa","peridoto","pirita","pirolusita","plata","prehnita","proustita","psilomelana","rejalgar","rodocrosita","rodonita","rubí","rutilo","sanidina","serpentina","sheelita","siderita","sillimanita","smithsonita","sodalita","talco","titanita","topacio","tremolita","turmalina","turquesa","ulexita","uvarovita","variscita","vesubiana","vivianita","willemita","wulfenita","xilópalo","zafiro","zincita","zircón"};
    private String [] animales ={"abeja","abejorro","acara","ajolote","albatros","alce","almeja","anguila","antílope","ardilla","armadillo","armiño","ascidias","avestruz","avispa","avispón","avoceta","águila","babuino","ballena","barbo","barracuda","bisonte","buitre","burro","busardo","búfalo","búho","caballo","cabra","cachalote","caimán","calamar","camaleón","camarón","camello","cangrejo","canguro","capibara","caracol","castor","casuario","cebra","cebú","cerdo","chacal","chimpancé","chinchilla","ciempiés","ciervo","cigüeña","cisne","cobaya","cocodrilo","codorniz","colibrí","comadreja","conejo","coral","coyote","delfín","dingo","dodo","elefante","erizo","escarabajo","escorpión","faetón","faisán","flamenco","foca","frailecillo","fregata","gallina","gallo","gamba","ganso","garza","gato","glotón","gorila","gorrión","grulla","guacamayo","guepardo","halcón","hiena","hipopótamo","hormiga","hurón","hámster","ibis","iguana","impala","indri","jabalí","jaguar","jirafa","kakapo","kiwi","koala","lagarto","langosta","lechuza","leopardo","león","león marino","libélula","liebre","lince","llama","lobo","loro","luciérnaga","lémur","manatí","mandril","mangosta","mantarraya","mapache","mariposa","mariquita","medusa","mofeta","mono","morsa","mosca","mula","murciélago","numbat","nutria","ocelote","orangután","orca","ornitorrinco","oropéndola","oso","ostra","oveja","pantera","pato","pavo","pelícano","percebe","perezoso","perro","pez","pingüino","piraña","polilla","pollo","proteo","puercoespín","pulpo","puma","pájaro","quetzal","rana","rata","ratón","raya","reno","rinoceronte","rorcual","ruiseñor","salamandra","saltamontes","sapo","sepia","serpiente","suricato","tejón","termita","tiburón","tigre","topo","tortuga","tucán","urraca","vaca","vaca marina","viuda negra","wombat","xifóforo","yarará","zapatero","zarigüeya","zorro"};
    private String [] rNaturales ={"agua","viento","cuero","biocombustible","madera","petróleo","carbón","gas","uranio","mineral","agricultura","bosque","luz solar","tierra","energía geotérmica","energía hidráulica","energía eólica"};
    private String [] plantas ={"abedul","abeto","acacia","acanto","acebo","acedera","acepo","achicoria","aconito","adelfa","aguileña","agrimonia","ajenjo","albahaca","alhelí","alerce","alfalfa","aliso","almendro","almizcle","aloe","altramuz","amarilis","amapola","amaranto","ambrosía","anémona","angélica","anomone","aquilea","argentina","azafrán","azucena","balsamina","bálsamo","bardana","begonia","belladona","borraja","cactus","caléndula","camelia","capuchina","cardo","cesped","ciclamen","cilantro","clavel","crisantemo","dalia","damasco","diamela","diente de león","ébano","eglantina","enredadera","escabiosa","escorzonera","espliego","farfara","farolillo","fucsia","gardenia","genciana","geranio","girasol","hiedra","hinojo","hisopo","hortensia","iris","jacinto","laurel","lila","lirio","loto","magnolia","margarita","membrillo","menta","muérdago","nenúfar","olivo","orquídea","ortiga","petunia","pino","romero","rosa","salvia","tomillo","trébol","tulipán","ulmaria","valeriana","violeta","zarza","zinnia"};
    private String [] rOrganicos ={"resto de comida","cascara de fruta","verdura","hortaliza","cascaron de huevo","pelo","resto de cafe","resto de te","pan","tortilla","bagazo de fruta","producto lacteo","servilleta","residuo de jardin","pasto","ramas","ceniza","aserrin","huesos","leche","yogurt","corcho","flores","palillos","palos","espinas","pescado","carne"};
    private String [] rInorganicos ={"frasco de vidrio","botella de vidrio","lampara","microprocesador","pila","bateria de celular","bateria de carro","placa radiografica","lata de conserva","bolsa de nylon","fibra acrilica","acrilico","poliestireno","cartucho de impresora","aguja","jeringa","cable","neumatico","llanta","plastico","bolsa de plastico","pvc","celofan","envoltura de celofan"};
    private String [] rRenovables ={"energía eólica","hortaliza","fruta","verdura","energía hidroeléctrica","energía hidráulica","recurso forestal","cultivo de cereal","cultivo de flor","cultivo de hongo","recurso pesquero","animal","planta","agua","energía solar","producto agrícola","producto ganadero","hongo","ganado","viento","energía geotérmica","madera","cuero"};
    private String [] rNorenovables ={"petróleo","carbón","gas natural","oro","plata","uranio","zinc","estaño","yeso","mercurio","esmeralda","rubí","diamante","aluminio","acuifero","actinolita","ágata","aguamarina","alabastro","amazonita","ámbar","ambligonita","anatasa","andalucita","anhidrita","apatito","apofilita","aragonito","arsénico","aventurina","azabache","azufre","azurita","barita","bauxita","benitoíta","berilo","bismuto","calcedonia","calcita","calcopirita","casiterita","celestina","cerusita","cinabrio","cobre","cordierita","corindón","crisoberilo","crisocola","crisoprasa","crocoíta","cromita","cuarzo","cuprita","damburita","datolita","demantoide","diamante","diópsido","dioptasa","dolomita","epidota","escapolita","esfalerita","esmeralda","espinela","estaurolita","euclasa","fluorita","fosgenita","goethita","grafito","grosularia","hanksita","hematites","hemimorfita","hiddenita","hierro","ilmenita","jadeíta","jaspe","kunzita","labradorita","lapislázuli","lazulita","leucita","magnesita","malaquita","marcasita","mispíquel","obsidiana","ópalo","oro","oropimente","ortosa","peridoto","pirita","pirolusita","plata","prehnita","proustita","psilomelana","rejalgar","rodocrosita","rodonita","rubí","rutilo","sanidina","serpentina","sheelita","siderita","sillimanita","smithsonita","sodalita","talco","titanita","topacio","tremolita","turmalina","turquesa","ulexita","uvarovita","variscita","vesubiana","vivianita","willemita","wulfenita","xilópalo","zafiro","zincita","zircón"};

    private ArrayList<String> nombres;
    private List<String> respuestaUsuario;
    private Stream <String> tokenStream ;
    private String cadena ="";

    private int valor;//valor imagen de letra
    private int aux;//auxiliar imagen letra
    private int valor2;//valor imagen de letra
    private int aux2;//auxiliar imagen letra
    private boolean reiniciar=false;
    private boolean temporal=false;
    private boolean cronometroActivo;
    private Thread hilo;

    public JuegoBasta (){
        this.getContentPane().setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fondo.efectoFondo1();
        fondo.play();
        fondo.loop();

        sonido2.efectoCampana();
        sonido4.efectoTiempo();

        panelsubDerecho=new JPanel();
        panelsubDerecho.setLayout(new BoxLayout(panelsubDerecho,BoxLayout.Y_AXIS));
        panelsubIzquierda=new JPanel();
        panelsubIzquierda.setLayout(new BoxLayout(panelsubIzquierda,BoxLayout.Y_AXIS));
        panelsubArriba=new JPanel();
        panelsubArriba.setLayout(new FlowLayout());
        panelsubAbajo=new JPanel();
        panelsubAbajo.setLayout(new FlowLayout());
        panelsubCentral=new JPanel();

        panelsubDerecho.setBackground(Color.CYAN);//derecha
        panelsubIzquierda.setBackground(Color.CYAN);//izquierda
        panelsubArriba.setBackground(Color.CYAN);//arriba
        panelsubAbajo.setBackground(Color.CYAN);//abajo
        panelsubCentral.setBackground(Color.CYAN);//centro

////par
        panelArriba = new JPanel();
        panelArriba.setLayout(new BoxLayout(panelArriba,BoxLayout.X_AXIS));

        Regresar = new JButton("");
        Regresar.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        labelImage3P = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/try6.png");
        Regresar.setIcon(labelImage3P);
        Regresar.setBorder(null);
        Regresar.setBorderPainted(false);
        Regresar.setBackground(Color.CYAN);
        Regresar.setForeground(Color.BLACK);

        Salir=new JButton("");
        labelImage3P = new ImageIcon("src/resources/ruletaF_src/graficos/ruletaGui/try5.png");
        Salir.setIcon(labelImage3P);
        Salir.setBorder(null);
        Salir.setBorderPainted(false);
        Salir.setAlignmentX(Component.RIGHT_ALIGNMENT);
        Salir.setBackground(Color.CYAN);

        panelArriba.add(Regresar);
        panelArriba.add(Box.createHorizontalGlue());
        panelArriba.add(Salir);

        panelArriba.setBackground(Color.CYAN);
        this.getContentPane().add(panelArriba,BorderLayout.NORTH);
//////pab
        panelAbajo = new JPanel();
        panelAbajo.setLayout(new BoxLayout(panelAbajo,BoxLayout.X_AXIS));

        Iniciar = new JButton("Iniciar");
        Iniciar.setFont(new Font("Arial",Font.CENTER_BASELINE,23));
        Iniciar.setBackground(new Color(249,94,0));
        Iniciar.setForeground(Color.BLACK);

        Reiniciar = new JButton("Reiniciar");
        Reiniciar.setFont(new Font("Arial",Font.CENTER_BASELINE,23));
        Reiniciar.setBackground(new Color(249,94,0));
        Reiniciar.setForeground(Color.BLACK);

        panelAbajo.add(Box.createHorizontalGlue());
        panelAbajo.add(Iniciar);
        panelAbajo.add(Box.createHorizontalGlue());
        panelAbajo.add(Reiniciar);
        panelAbajo.add(Box.createHorizontalGlue());

        panelAbajo.setBackground(Color.CYAN);
        this.getContentPane().add(panelAbajo,BorderLayout.SOUTH);
////pai
        panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo,BoxLayout.Y_AXIS));

        label= new JLabel();
        labelImageP = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/logoBasta.png");
        label.setIcon(labelImageP);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        label2=new JLabel();
        labelImage2P = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/logoLetras.png");
        label2.setIcon(labelImage2P);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);

        Sacar=new JButton("");
        Sacar.setFont(new Font("Arial",Font.CENTER_BASELINE,22));
        Sacar.setIcon(labelImageP);
        Sacar.setBorder(null);
        Sacar.setBorderPainted(false);
        Sacar.setAlignmentX(Component.CENTER_ALIGNMENT);
        Sacar.setBackground(new Color(64,164,155));
        Sacar.setForeground(Color.BLACK);

        Letra=new JButton("");
        Letra.setFont(new Font("Arial",Font.CENTER_BASELINE,22));
        Letra.setIcon(labelImage2P);
        Letra.setBorder(null);
        Letra.setBorderPainted(false);
        Letra.setAlignmentX(Component.CENTER_ALIGNMENT);
        Letra.setBackground(new Color(64,164,155));
        Letra.setForeground(Color.BLACK);

        panelIzquierdo.add(Box.createVerticalGlue());

        panelIzquierdo.add(Sacar);
        panelIzquierdo.add(Box.createVerticalGlue());
        panelIzquierdo.add(Letra);
        panelIzquierdo.add(Box.createVerticalGlue());

        panelIzquierdo.setBackground(Color.CYAN);
        this.getContentPane().add(panelIzquierdo,BorderLayout.WEST);
/////pad
        panelDerecho = new JPanel();
        panelDerecho.setLayout(new BoxLayout(panelDerecho,BoxLayout.Y_AXIS));

        Ayuda=new JButton("");
        Ayuda.setFont(new Font("Arial",Font.CENTER_BASELINE,22));
        labelImage3P = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/try4.png");
        Ayuda.setIcon(labelImage3P);
        Ayuda.setBorder(null);
        Ayuda.setBorderPainted(false);
        Ayuda.setAlignmentX(Component.RIGHT_ALIGNMENT);
        Ayuda.setBackground(Color.CYAN);
        Ayuda.setForeground(Color.BLACK);

        panelDerecho.add(Box.createVerticalGlue());
        panelDerecho.add(Ayuda);

        panelDerecho.setBackground(Color.CYAN);
        this.getContentPane().add(panelDerecho,BorderLayout.EAST);
////pac
        panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());
////
        tiempo = new JLabel( "00:00:000" );
        tiempo.setFont( new Font( Font.SERIF, Font.BOLD, 80) );
        tiempo.setHorizontalAlignment( JLabel.CENTER );
        tiempo.setForeground( Color.BLUE );
        tiempo.setBackground( Color.CYAN);
        tiempo.setOpaque( true );
        panelsubArriba.add(tiempo);
////
        cajaTexto.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(cajaTexto,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelImage3P = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/try3.png");
        labelAciertos = new JLabel(" ");
        labelAciertos.setFont( new Font( Font.SERIF, Font.BOLD, 80) );
        labelAciertos.setHorizontalAlignment( JLabel.CENTER );
        labelAciertos.setForeground( Color.BLUE );
        labelAciertos.setBackground( Color.CYAN);
        labelAciertos.setOpaque( true );
        panelsubAbajo.add(labelAciertos);
        panelsubCentral.add(scrollPane);

        label3=new JLabel();
        labelImage3P = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/try1.png");
        label3.setIcon(labelImage3P);
        label3.setAlignmentX(Component.CENTER_ALIGNMENT);

        label4=new JLabel();
        labelImage3P = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/try2.png");
        label4.setIcon(labelImage3P);
        label4.setAlignmentX(Component.CENTER_ALIGNMENT);

        label5=new JLabel();
        labelImage3P = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/try3.png");
        label5.setIcon(labelImage3P);
        label5.setAlignmentX(Component.CENTER_ALIGNMENT);
        label5.setVisible(false);

        panelsubIzquierda.add(Box.createVerticalGlue());
        panelsubIzquierda.add(label3);
        panelsubIzquierda.add(Box.createVerticalGlue());
        panelsubDerecho.add(label4);
        panelsubDerecho.add(Box.createVerticalGlue());
        panelsubAbajo.add(label5);

        panelCentral.add(panelsubDerecho,BorderLayout.EAST);
        panelCentral.add(panelsubIzquierda,BorderLayout.WEST);
        panelCentral.add(panelsubArriba,BorderLayout.NORTH);
        panelCentral.add(panelsubAbajo,BorderLayout.SOUTH);
        panelCentral.add(panelsubCentral,BorderLayout.CENTER);
        this.getContentPane().add(panelCentral,BorderLayout.CENTER);
////lb
        JOptionPane.showMessageDialog(null,"Para jugar primero presiona el boton sacar una carta,despues presiona\nel boton sacar una letra ahora solo necesitas presionar el boton iniciar\n\nPor ultimo solo necesitas escribir la palabra con la letra que te toco\n\nAcontinuacion se muestra como ingresar la respuesta");
        Icon icon = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/ejemplo.png");
        JOptionPane.showMessageDialog(null,"","",JOptionPane.INFORMATION_MESSAGE,icon);

        Regresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                fondo.cerrar();
                if(temporal){
                    fondo2.cerrar();
                }
                sonido3.efectoBotonB();
                sonido3.play();
                sonido2.cerrar();
                sonido4.cerrar();
                dispose();new RuletaGui();
                reiniciarTodo();
            }
        });

        Salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                fondo.cerrar();
                if(temporal){
                    fondo2.cerrar();
                }
                sonido1.efectoBye();
                sonido3.efectoBotonB();
                sonido1.play();
                sonido3.play();
                sonido2.cerrar();
                sonido4.cerrar();
                dispose();
                reiniciarTodo();
            }
        });

        Ayuda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                sonido3.efectoBotonB();
                sonido3.play();
                JOptionPane.showMessageDialog(null,"Para jugar primero presiona el boton sacar una carta,despues presiona\nel boton sacar una letra ahora solo necesitas presionar el boton iniciar\n\nPor ultimo solo necesitas escribir la palabra con la letra que te toco\n\nAcontinuacion se muestra como ingresar la respuesta");
                JOptionPane.showMessageDialog(null,"","",JOptionPane.INFORMATION_MESSAGE,icon);
            }
        });

        Iniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if(valor==0){
                    sonido3.efectoBotonB();
                    sonido3.play();
                    JOptionPane.showMessageDialog(null,"Necesitas sacar una carta ");
                }
                else
                if(valor2==0){
                    sonido3.efectoBotonB();
                    sonido3.play();
                    JOptionPane.showMessageDialog(null,"Necesitas sacar una letra ");
                }else
                if(reiniciar){
                    sonido3.efectoBotonB();
                    sonido3.play();
                    JOptionPane.showMessageDialog(null,"Necesitas reiniciar");
                }
                else
                if(!cronometroActivo){
                    sonido3.efectoBotonB();
                    sonido3.play();
                    reiniciar=true;
                    JOptionPane.showMessageDialog(null,"Preparate para jugar");
                    fondo.cerrar();
                    fondo2.efectoTictac();
                    fondo2.play();
                    fondo2.loop();
                    temporal=true;
                    label5.setVisible(true);
                    cajaTexto.setEnabled(true);
                    while(!cronometroActivo){
                        iniciarCronometro();
                    }
                }
            }
        });

        Reiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                sonido3.efectoBotonB();
                sonido3.play();
                reiniciarTodo();
            }
        });

        Sacar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if(reiniciar){
                    sonido3.efectoBotonB();
                    sonido3.play();
                    JOptionPane.showMessageDialog(null,"Necesitas terminar el juego o reiniciar el juego");
                }else{
                    if (aux != 0) {
                        do {
                            valor = r1.nextInt(10) + 1;
                        } while (aux == valor);
                        aux = valor;
                    } else {
                        valor = r1.nextInt(10) + 1;
                        aux = valor;
                    }
                    switch (valor) {
                        case 1: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/animales.png");break;
                        case 2: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/frutas.png");break;
                        case 3: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/minerales.png");break;
                        case 4: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/plantas.png");break;
                        case 5: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/recursosNaturales.png");break;
                        case 6: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/recursosRenovables.png");break;
                        case 7: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/recursosNorenovables.png");break;
                        case 8: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/residuosInorganicos.png");break;
                        case 9: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/residuosOrganicos.png");break;
                        case 10: labelImage = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/verduras.png");break;
                    }
                    sonido3.efectoBotonB();
                    sonido3.play();

                    Sacar.setIcon(labelImage);
                    Sacar.repaint();
                    Sacar.validate();
                }
            }
        });

        Letra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if(reiniciar){
                    sonido3.efectoBotonB();
                    sonido3.play();
                    JOptionPane.showMessageDialog(null,"Necesitas terminar el juego o reiniciar el juego");
                }else{
                    if (valor == 0) {
                        JOptionPane.showMessageDialog(null, "Necesitas sacar una Carta ");
                    } else {
                        if (aux2 != 0) {
                            do {
                                valor2 = r1.nextInt(26) + 1;
                            } while (aux2 == valor2);
                            aux2 = valor2;
                        } else {
                            valor2 = r1.nextInt(26) + 1;
                            aux2 = valor2;
                        }
                        switch (valor2) {
                            case 1: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/A.png");break;
                            case 2: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/B.png");break;
                            case 3: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/C.png");break;
                            case 4: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/D.png");break;
                            case 5: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/E.png");break;
                            case 6: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/F.png");break;
                            case 7: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/G.png");break;
                            case 8: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/H.png");break;
                            case 9: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/I.png");break;
                            case 10: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/J.png");break;
                            case 11: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/K.png");break;
                            case 12: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/L.png");break;
                            case 13: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/M.png");break;
                            case 14: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/N.png");break;
                            case 15: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/O.png");break;
                            case 16: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/P.png");break;
                            case 17: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/Q.png");break;
                            case 18: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/R.png");break;
                            case 19: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/S.png");break;
                            case 20: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/T.png");break;
                            case 21: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/U.png");break;
                            case 22: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/V.png");break;
                            case 23: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/W.png");break;
                            case 24: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/X.png");break;
                            case 25: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/Y.png");break;
                            case 26: labelImage2 = new ImageIcon("src/resources/ruletaF_src/graficos/juegaBasta/Z.png");break;
                        }
                        sonido3.efectoBotonB();
                        sonido3.play();

                        Letra.setIcon(labelImage2);
                        Letra.repaint();
                        Letra.validate();
                    }
                }
            }
        });
    }//fin constructor

    public void run(){
        Integer minutos = 0 , segundos = 0, milesimas = 0;
        String min="", seg="", mil="";
        try
        {
            while( cronometroActivo )
            {
                Thread.sleep( 4 );
                //Incrementamos 4 milesimas de segundo
                milesimas += 4;

                if( milesimas == 1000 ){
                    milesimas = 0;
                    segundos += 1;

                    if( segundos == 60 ){
                        segundos = 0;
                        minutos++;
                    }
                    if(minutos==1 && segundos==0 && milesimas==0){
                        pararCronometro();
                        tiempo.setText( "01:00:000" );
                        fondo2.cerrar();
                        temporal=false;
                        sonido2.efectoCampana();
                        sonido4.efectoTiempo();
                        sonido2.play();
                        JOptionPane.showMessageDialog(null, "Se acabo el tiempo");
                        sonido4.play();
                        label5.setVisible(false);
                        obtenerResultados();
                        try {
                            Thread.sleep(1*1000);
                        }
                        catch (Exception e) {
                            System.out.println(e);
                        }

                    }
                }

                if( minutos < 10 ) min = "0" + minutos;
                else min = minutos.toString();
                if( segundos < 10 ) seg = "0" + segundos;
                else seg = segundos.toString();

                if( milesimas < 10 ) mil = "00" + milesimas;
                else if( milesimas < 100 ) mil = "0" + milesimas;
                else mil = milesimas.toString();

                //Colocamos en la etiqueta la informacion
                tiempo.setText( min + ":" + seg + ":" + mil );
            }
        }catch(Exception e){}
        //Cuando se reincie se coloca nuevamente en 00:00:000
        tiempo.setText( "00:00:000" );
        fondo.efectoFondo1();
        fondo.play();
        fondo.loop();
    }
    public void iniciarCronometro() {
        cronometroActivo = true;
        hilo = new Thread( this );
        hilo.start();
    }
    public void pararCronometro(){
        cronometroActivo = false;
    }

    public void reiniciarTodo(){
        valor=valor2=0;
        reiniciar=false;
        cadena="";
        labelAciertos.setText(" ");
        cajaTexto.setText("");
        cajaTexto.setEnabled(false);
        Sacar.setIcon(labelImageP);
        Sacar.repaint();
        Sacar.validate();
        Letra.setIcon(labelImage2P);
        Letra.repaint();
        Letra.validate();
        label5.setVisible(false);

        pararCronometro();
    }

    public void obtenerResultados(){
        cajaTexto.setEnabled(false);
        String textoUsuario[] = cajaTexto.getText().split("\n");
        seleccionarLista();
        tokenStream = Stream.of(textoUsuario);
        respuestaUsuario = tokenStream.map(s -> s.toLowerCase()).filter(x -> x.startsWith(cadena)).collect(Collectors.toList());    //list
        int aciertos=0;

        if(valor==0){
            JOptionPane.showMessageDialog(null,"Necesitas sacar una carta ");
        }
        else
        if(valor2==0){
            JOptionPane.showMessageDialog(null,"Necesitas sacar una letra ");
        }else{
            for(String elemento : respuestaUsuario){
                if(nombres.contains(elemento)){
                    respuestaUsuario.stream().filter(x -> x.startsWith(cadena));
                    aciertos++;
                }
            }
            labelAciertos.setText("Aciertos: "+aciertos);
        }
    }

    public void seleccionarLista(){

        switch(valor){
            case 1: nombres = new ArrayList<>(Arrays.asList(animales));break;
            case 2: nombres = new ArrayList<>(Arrays.asList(frutas));break;
            case 3: nombres = new ArrayList<>(Arrays.asList(minerales));break;
            case 4: nombres = new ArrayList<>(Arrays.asList(plantas));break;
            case 5: nombres = new ArrayList<>(Arrays.asList(rNaturales));break;
            case 6: nombres = new ArrayList<>(Arrays.asList(rRenovables));break;
            case 7: nombres = new ArrayList<>(Arrays.asList(rNorenovables));break;
            case 8: nombres = new ArrayList<>(Arrays.asList(rInorganicos));break;
            case 9: nombres = new ArrayList<>(Arrays.asList(rOrganicos));break;
            case 10: nombres = new ArrayList<>(Arrays.asList(verduras));break;
        }

        switch (valor2) {
            case 1: cadena="a";break;
            case 2: cadena="b";break;
            case 3: cadena="c";break;
            case 4: cadena="d";break;
            case 5: cadena="e";break;
            case 6: cadena="f";break;
            case 7: cadena="g";break;
            case 8: cadena="h";break;
            case 9: cadena="i";break;
            case 10: cadena="j";break;
            case 11: cadena="k";break;
            case 12: cadena="l";break;
            case 13: cadena="m";break;
            case 14: cadena="n";break;
            case 15: cadena="o";break;
            case 16: cadena="p";break;
            case 17: cadena="q";break;
            case 18: cadena="r";break;
            case 19: cadena="s";break;
            case 20: cadena="t";break;
            case 21: cadena="u";break;
            case 22: cadena="v";break;
            case 23: cadena="w";break;
            case 24: cadena="x";break;
            case 25: cadena="y";break;
            case 26: cadena="z";break;
        }
    }

}//fin clase

