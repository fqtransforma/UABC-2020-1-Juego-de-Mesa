/*
 * @author Grupo de ingenieria en computacion UABC (2020)
 * Fecha: 07/05/2020
 * Descripcion: Clase de arranque del proyecto
 */
import juegos.mainmenu.*;

public class Main {
    public static void main(String args[]){
        testMainMenu();
        //testEcotwister();
        //testResiduos();
        //testSerpientesyescaleras();
        //testRuleta();
    }

    /*
     * ESTOS METODOS SON SOLO PARA HACER PRUEBAS DE CADA MODULO
     * POR FAVOR NO PONER NADA EN EL METODO MAIN
     */
    static void testEcoTwister(){
        System.out.println("Nada... por ahora");
    }

    static void testMainMenu(){
        MenuRun menu = new MenuRun();
        menu.correr();
    }

    static void testSerpientesYEscaleras(){
        System.out.println("Nada... por ahora");
    }

    static void testResiduos(){
        System.out.println("Nada... por ahora");
    }

    static void testRuleta(){
        System.out.println("Nada... por ahora");
    }
}