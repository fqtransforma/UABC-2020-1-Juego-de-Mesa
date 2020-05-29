package juegos.ecotwister;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Archivo {

    public void cargarArchivo(){
        abrir();
    }

    private void abrir(){

        String fileLocal = new String("src/resources/ecotwister_src/Tapete.ecotwister.pdf");

        try{

            File path = new File(fileLocal);
            Desktop.getDesktop().open(path);

        }catch (IOException e){
            e.printStackTrace();
        }catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(null,"No se encontro el archivo","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
