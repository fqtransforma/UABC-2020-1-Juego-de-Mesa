/*
 * @author Grupo de ingenieria en computacion UABC (2020)
 * Fecha: 07/05/2020
 * Descripcion: Clase de arranque del proyecto
 */
import juegos.mainmenu.*;
import juegos.mainmenu.elementos.visuales.Ventana;

public class Main {
    public static void main(String []args){
        Ventana ventana = new Ventana();
        ventana.init();
    }
}