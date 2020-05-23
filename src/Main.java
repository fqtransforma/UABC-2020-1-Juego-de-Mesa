/*
 * @author Grupo de ingenieria en computacion UABC (2020)
 * Fecha: 07/05/2020
 * Descripcion: Clase de arranque del proyecto
 */
import juegos.ecotwister.Juego;
import juegos.mainmenu.*;
import juegos.ruleta.EcoPregunta;
import juegos.ruletaF.RuletaGui;
import juegos.serpientesyescaleras.Game;
import juegos.serpientesyescaleras.MusicStaff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String []args){
        //testMainMenu();
        //testEcoTwister();
        //testResiduos();
        //testSerpientesYEscaleras();
        //testRuleta();
        testRuletaF();
    }

    static void testEcoTwister(){
        Juego.run();
    }

    static void testMainMenu(){
        MenuRun menu = new MenuRun();
    }


    static void testResiduos(){
        System.out.println("Nada... por ahora");
    }

    static void testRuleta(){
        EcoPregunta.run();
    }

    static void testSerpientesYEscaleras(){
        Game.StartSerpientesYEscaleras();
    }

    static void testRuletaF(){ RuletaGui.run(); }
}