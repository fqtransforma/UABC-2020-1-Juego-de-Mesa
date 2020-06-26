package general;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sonido
{

    // to store current position
    Long currentFrame;
    Clip clip;

    // current status of clip
    String status;

    AudioInputStream audioInputStream;
    private String filePath;

    // constructor to initialize streams and clip
    public Sonido(String filePath, boolean loop)
    {
        try {
            this.filePath = filePath;
            // create AudioInputStream object
            audioInputStream =
                    AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

            // create clip reference
            clip = AudioSystem.getClip();

            // open audioInputStream to the clip
            clip.open(audioInputStream);
            if(loop)
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            else
                clip.loop(0);
        }catch (Exception Ex){
            System.out.print(Ex);
        }

    }
    public Sonido(String filePath)
    {
        try {
            this.filePath = filePath;
            // create AudioInputStream object
            audioInputStream =
                    AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

            // create clip reference
            clip = AudioSystem.getClip();

            // open audioInputStream to the clip
            clip.open(audioInputStream);
        }catch (Exception Ex){
            System.out.print(Ex);
        }

    }

    // Method to play the audio
    public void play()
    {
        //start the clip
        clip.start();

        status = "play";
    }

    // Method to pause the audio
    public void pause()
    {
        if (status.equals("paused"))
        {
            System.out.println("audio is already paused");
            return;
        }
        this.currentFrame =
                this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    // Method to resume the audio
    public void resumeAudio()
    {
        try {
            if (status.equals("play")) {
                System.out.println("Audio is already " +
                        "being played");
                return;
            }
            clip.close();
            resetAudioStream();
            clip.setMicrosecondPosition(currentFrame);
            this.play();
        }catch (Exception Ex){
            System.out.print("Error de Audio");
        }
    }

    // Method to restart the audio
    public void restart()
    {
        try{
            clip.stop();
            clip.close();
            resetAudioStream();
            currentFrame = 0L;
            clip.setMicrosecondPosition(0);
            this.play();
        }catch (Exception Ex){
            System.out.print(Ex);
        }
    }

    // Method to stop the audio
    public void stop() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    // Method to jump over a specific part
    public void jump(long c) throws UnsupportedAudioFileException, IOException,
            LineUnavailableException
    {
        if (c > 0 && c < clip.getMicrosecondLength())
        {
            clip.stop();
            clip.close();
            resetAudioStream();
            currentFrame = c;
            clip.setMicrosecondPosition(c);
            this.play();
        }
    }

    // Method to reset audio stream
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException,
            LineUnavailableException
    {
        audioInputStream = AudioSystem.getAudioInputStream(
                new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
    }
}