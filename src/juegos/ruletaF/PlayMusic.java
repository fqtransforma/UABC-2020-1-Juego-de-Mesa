package juegos.ruletaF;


import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;

public class PlayMusic{
    private Clip clip;
    public void spiningWheel(){				// sonido menu principal
        try{
            clip = AudioSystem.getClip();
            File a = new File("src/main/resources/recortado.wav");
            clip.open(AudioSystem.getAudioInputStream(a));
        }catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }

    public void play(){
        clip.start();
    }
    /* public void loop(){
         clip.loop(Clip.LOOP_CONTINUOUSLY);
     }*/
    public void cerrar(){
        clip.close();
    }
}
