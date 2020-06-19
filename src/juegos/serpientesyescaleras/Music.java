package juegos.serpientesyescaleras;

import javax.sound.sampled.*;
import java.io.File;

public class Music {

    File musicPath;
    AudioInputStream audioInput;
    Clip clip;

    public Music(String s) {
        File music = new File(s);
        musicPath = music;
    }

    public  void play(){

        try{
            if(musicPath.exists())
            {
                audioInput=AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);

            }else{
                System.out.println("No encontro archivo");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void stop()
    {
        try{
            if(musicPath.exists())
            {
                clip.stop();
                clip.close();

            }else{
                System.out.println("No encontro archivo");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
