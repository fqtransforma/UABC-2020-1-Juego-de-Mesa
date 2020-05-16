/*
 * Autores Equipo D:
 *          Crisantos Uscanga Luis Alberto
 *          Cruz Sanchez Miriam
 *          Guerra Cervantes Sergio
 *          Soto Elenes Brian Ramiro
 *
 * Fecha: 07/05/2020
 * Descripcion: Clase que contiene lo necesario para que el menu corra
 */

package juegos.mainmenu;

import javax.swing.*;

public class MenuRun {
    public MenuRun() {
        JFrame frame = new JFrame("Menu");
        frame.setSize(1280,720);
        frame.add(new Menu());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3); //EoC
    }
}
