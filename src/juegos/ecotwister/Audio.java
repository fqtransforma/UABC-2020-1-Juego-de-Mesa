package juegos.ecotwister;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Audio {

    public void Play(String filepath){

        try{
            File musicPath = new File(filepath);
            if(musicPath.exists()){

                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip c = AudioSystem.getClip();
                c.open(audioInput);
                c.start();
                c.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else{
                System.out.println("No se encontro archivo");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
