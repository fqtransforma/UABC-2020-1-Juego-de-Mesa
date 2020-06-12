package juegos.ruletaF;

import javax.swing.*;
import java.awt.*;

public class Tarjetas {

    private  int seleccion;
    public PlayMusic sonido1 = new PlayMusic();
    public PlayMusic sonido2 = new PlayMusic();

    public void seleccion(int random) {
        switch (random) {
            case 0: Icon icon = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/SeresV.png");
               seleccion = JOptionPane.showOptionDialog(null, "", "Tarjeta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, icon, new Object[] { "Ayuda", "Salir"}, "opcion 1");
                if (seleccion==0) {
                    sonido2.efectoBcaricaturas2();
                    sonido2.play();
                    JOptionPane.showMessageDialog(null, "El usuario debe mencionar Seres Vivos \n"+"ejemplo\n"+"Diversos Animales\nPlantas","Ayuda",JOptionPane.INFORMATION_MESSAGE);
                }
                if(seleccion==1){
                    sonido1.efectoBcaricaturas();
                    sonido1.play();
                }
                break;
            case 1: Icon icon2 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Nvivos.png");
               seleccion = JOptionPane.showOptionDialog(null, "", "Tarjeta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, icon2, new Object[] { "Ayuda", "Salir"}, "opcion 1");
                if (seleccion==0) {
                    sonido2.efectoBcaricaturas2();
                    sonido2.play();
                    JOptionPane.showMessageDialog(null, "El usuario debe mencionar Seres No Vivos \n" + "ejemplo\n" + "Objetos inertes\nSilla");
                }
                if(seleccion==1){
                    sonido1.efectoBcaricaturas();
                    sonido1.play();
                }
                break;
            case 2: Icon icon3 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Renovables.png");
               seleccion = JOptionPane.showOptionDialog(null, "", "Tarjeta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, icon3, new Object[] { "Ayuda", "Salir"}, "opcion 1");
                if (seleccion==0) {
                    sonido2.efectoBcaricaturas2();
                    sonido2.play();
                    JOptionPane.showMessageDialog(null, "El usuario debe mencionar Recursos Renovables \n" + "ejemplo\n" + "Agua\nMadera");
                }
                if(seleccion==1){
                    sonido1.efectoBcaricaturas();
                    sonido1.play();
                }
                break;
            case 3: Icon icon4 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Nrenovables.png");
                seleccion = JOptionPane.showOptionDialog(null, "", "Tarjeta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon4,new Object[] { "Ayuda", "Salir"}, "opcion 1");
                if (seleccion==0) {
                    sonido2.efectoBcaricaturas2();
                    sonido2.play();
                    JOptionPane.showMessageDialog(null, "El usuario debe mencionar Recursos no Renovables \n"+"ejemplo\n"+"residuos fosiles\nDerivados del  petroleo");
                }
                if(seleccion==1){
                    sonido1.efectoBcaricaturas();
                    sonido1.play();
                }
                break;
            case 4: Icon icon5 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Organicos.png");
                seleccion = JOptionPane.showOptionDialog(null, "", "Tarjeta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon5,new Object[] { "Ayuda", "Salir"}, "opcion 1");
                if (seleccion==0) {
                    sonido2.efectoBcaricaturas2();
                    sonido2.play();
                    JOptionPane.showMessageDialog(null, "El usuario debe mencionar Recursos Organicos \n"+"ejemplo:\n"+"Desechos de comida\n");
                }
                if(seleccion==1){
                    sonido1.efectoBcaricaturas();
                    sonido1.play();
                }
                break;
            case 5: Icon icon6 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Naturales.png");
               seleccion = JOptionPane.showOptionDialog(null, "", "Tarjeta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, icon6, new Object[] { "Ayuda", "Salir"}, "opcion 1");
                if (seleccion==0) {
                    sonido2.efectoBcaricaturas2();
                    sonido2.play();
                    JOptionPane.showMessageDialog(null, "El usuario debe mencionar Recursos Naturales \n"+"ejemplo:\n"+"agua\nviento");
                }
                if(seleccion==1){
                    sonido1.efectoBcaricaturas();
                    sonido1.play();
                }
                break;
            case 6: Icon icon7 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Plantas.png");
               seleccion = JOptionPane.showOptionDialog(null, "", "Tarjeta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, icon7, new Object[] { "Ayuda", "Salir"}, "opcion 1");
                if (seleccion==0) {
                    sonido2.efectoBcaricaturas2();
                    sonido2.play();
                    JOptionPane.showMessageDialog(null, "El usuario debe mencionar Plantas \n"+"ejemplo\n"+"Diversas Flores\nDiversos Arboles");
                }
                if(seleccion==1){
                    sonido1.efectoBcaricaturas();
                    sonido1.play();
                }
                break;
            case 7: Icon icon8 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Minerales.png");
               seleccion = JOptionPane.showOptionDialog(null, "", "Tarjeta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, icon8, new Object[] { "Ayuda", "Salir"}, "opcion 1");
                if (seleccion==0) {
                    sonido2.efectoBcaricaturas2();
                    sonido2.play();
                    JOptionPane.showMessageDialog(null, "El usuario debe mencionar Minerales \n"+"ejemplo\n"+"Oro\nbronce");
                }
                if(seleccion==1){
                    sonido1.efectoBcaricaturas();
                    sonido1.play();
                }
                break;
            case 8: Icon icon9 = new ImageIcon("src/resources/ruletaF_src/graficos/caricaturas/Animales.png");
               seleccion = JOptionPane.showOptionDialog(null, "", "Tarjeta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, icon9, new Object[] { "Ayuda", "Salir"}, "opcion 1");
                if (seleccion==0) {
                    sonido2.efectoBcaricaturas2();
                    sonido2.play();
                    JOptionPane.showMessageDialog(null, "El usuario debe mencionar Animales \n"+"ejemplo\n"+"Perro\nLeon");
                }
                if(seleccion==1){
                    sonido1.efectoBcaricaturas();
                    sonido1.play();
                }
                break;
        }
    }
}
