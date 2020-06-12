package juegos.ruletaF;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;

public class PlayMusic{
    private Clip clip;
///// YO
public void efectoWheel(){
    try{
        clip = AudioSystem.getClip();
        File a = new File("src/resources/ruletaF_src/audio/musica/rueda.wav");
        clip.open(AudioSystem.getAudioInputStream(a));
    }catch (Exception tipoError) {
        System.out.println("" + tipoError);
    }
}
    public void efectoBye(){
        try{
            clip = AudioSystem.getClip();
            File a = new File("src/resources/ruletaF_src/audio/musica/bye.wav");
            clip.open(AudioSystem.getAudioInputStream(a));
        }catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }
    public void efectoCampana(){
        try{
            clip = AudioSystem.getClip();
            File a = new File("src/resources/ruletaF_src/audio/musica/campana.wav");
            clip.open(AudioSystem.getAudioInputStream(a));
        }catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }
    public void efectoTictac(){
        try{
            clip = AudioSystem.getClip();
            File a = new File("src/resources/ruletaF_src/audio/musica/tictac.wav");
            clip.open(AudioSystem.getAudioInputStream(a));
        }catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }

    public void efectoTiempo(){
        try{
            clip = AudioSystem.getClip();
            File a = new File("src/resources/ruletaF_src/audio/musica/tiempo.wav");
            clip.open(AudioSystem.getAudioInputStream(a));
        }catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }
    public void efectoBotonB(){
        try{
            clip = AudioSystem.getClip();
            File a = new File("src/resources/ruletaF_src/audio/musica/boton.wav");
            clip.open(AudioSystem.getAudioInputStream(a));
        }catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }
    public void efectoFondo1(){
        try{
            clip = AudioSystem.getClip();
            File a = new File("src/resources/ruletaF_src/audio/musica/fondo1.wav");
            clip.open(AudioSystem.getAudioInputStream(a));
        }catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }
    public void efectoFondo2(){
        try{
            clip = AudioSystem.getClip();
            File a = new File("src/resources/ruletaF_src/audio/musica/fondo2.wav");
            clip.open(AudioSystem.getAudioInputStream(a));
        }catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }

//////////Antonio
    public void musicaFondoreto(){
        try{
            clip = AudioSystem.getClip();
            File a = new File("src/resources/ruletaF_src/audio/musica/MusicaFondo.wav");
            clip.open(AudioSystem.getAudioInputStream(a));
        }catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }

    public void efectoYeah(){
        try{
            clip = AudioSystem.getClip();
            File a = new File("src/resources/ruletaF_src/audio/musica/yeahEcoreto.wav");
            clip.open(AudioSystem.getAudioInputStream(a));
        }catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }

    public void efectoBoton(){
        try{
            clip = AudioSystem.getClip();
            File a = new File("src/resources/ruletaF_src/audio/musica/efectoBoton.wav");
            clip.open(AudioSystem.getAudioInputStream(a));
        }catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }
/////////Osbaldo
    public void musicaFondocaricaturas(){
        try{
            clip = AudioSystem.getClip();
            File a = new File("src/resources/ruletaF_src/audio/musica/Mfondo.wav");
            clip.open(AudioSystem.getAudioInputStream(a));
            clip.loop(10);
        }catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }

    public void efectoBcaricaturas(){
        try{
            clip = AudioSystem.getClip();
            File a = new File("src/resources/ruletaF_src/audio/musica/Mback.wav");
            clip.open(AudioSystem.getAudioInputStream(a));
        }catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }

    public void efectoBcaricaturas2(){
        try{
            clip = AudioSystem.getClip();
            File a = new File("src/resources/ruletaF_src/audio/musica/Mhelp.wav");
            clip.open(AudioSystem.getAudioInputStream(a));
        }catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }
///////

    public void play(){
        clip.start();
    }
    public void loop(){ clip.loop(Clip.LOOP_CONTINUOUSLY);}
    public void cerrar(){ clip.close(); }
}



