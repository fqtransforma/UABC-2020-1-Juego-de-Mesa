package juegos.serpientesyescaleras;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Serializacion{

    public int dado;
    public int turno;
    public String jugador;
    public String mensaje;

    public Serializacion(String jugador,String mensaje,int turno,int dado)
    {
        this.dado=dado;
        this.turno=turno;
        this.jugador=jugador;
        this.mensaje=mensaje;
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

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
                linea.println("Turno: " + turn + "Jugador: " + jugador + "Num dado: " + dice + "Mensaje: " + mensaje);
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
                linea.println("Turno: " + turn + "Jugador: " + jugador + "Num dado: " + dice + "Mensaje: " + mensaje);
                linea.close();
                escribir.close();

            }catch (IOException exe){
                Logger.getLogger(Serializacion.class.getName()).log(Level.SEVERE, null, exe);
            }
        }


    }


    @Override
    public String toString() {
        return "Serializacion{" +
                "dado=" + dado +
                ", turno=" + turno +
                ", jugador='" + jugador + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
