package juegos.serpientesyescaleras;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Serializacion{

    public int dado;
    public int turno;
    public int posicionAnt;
    public int posicionSig;
    public String jugador;


    public Serializacion(String jugador,int turno,int dado,int posicionAnt,int posicionSig)
    {
        this.dado=dado;
        this.turno=turno;
        this.jugador=jugador;
        this.posicionAnt=posicionAnt;
        this.posicionSig=posicionSig;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getPosicionAnt() {
        return posicionAnt;
    }

    public void setPosicionAnt(int posicionAnt) {
        this.posicionAnt = posicionAnt;
    }

    public int getPosicionSig() {
        return posicionSig;
    }

    public void setPosicionSig(int posicionSig) {
        this.posicionSig = posicionSig;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public void Escrbir(String file){

        String turn=Integer.toString(turno);
        String dice=Integer.toString(dado);

        File archivo; // manipular archivo
        FileWriter escribir; // para escribir en el archivo
        PrintWriter linea; // escribir en el archivo
        archivo=new File(file);// preparando archivo

        if(!archivo.exists()) {
            try {
                archivo.createNewFile();
                escribir = new FileWriter(archivo, true);// Escribe al final del archivo
                linea = new PrintWriter(escribir);
                //Escribir archivo
                linea.println(" Turno: " + turn + " Jugador: " + jugador + " Posicion Actual: " +posicionAnt+ " Numero Dado: "+dice+ " Poscicion Siguiente: "+posicionSig);
                linea.close();
                escribir.close();

            } catch (IOException ex) {
                Logger.getLogger(Serializacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try{

                escribir=new FileWriter(archivo,true);//true escribe al final del archivo
                linea=new PrintWriter(escribir);
                //Escribir archivo
                linea.println(" Turno: " + turn + " Jugador: " + jugador + " Posicion Actual: " +posicionAnt+ " Numero Dado: "+dice+ " Poscicion Siguiente: "+posicionSig);
                linea.close();
                escribir.close();

            }catch (IOException exe){
                Logger.getLogger(Serializacion.class.getName()).log(Level.SEVERE, null, exe);
            }
        }


    }

}
