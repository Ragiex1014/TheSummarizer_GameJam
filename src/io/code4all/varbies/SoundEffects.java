package io.code4all.varbies;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import java.io.File;

public class SoundEffects {
    //Sound
    public static void playSound(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//loop
    public void loopSound(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
  /*
public class Main {
    public static void main(String[] args) {
        SoundEffects soundEffects = new SoundEffects();

        // Reproduza um efeito sonoro uma vez
        soundEffects.playSound("caminho/para/seu/efeitoSonoro.wav");

        // Reproduza um efeito sonoro em loop
        soundEffects.loopSound("caminho/para/seu/efeitoSonoro.wav");

        // Aguarde um tempo (por exemplo, usando Thread.sleep) para que o som toque em loop
        try {
            Thread.sleep(5000); // Aguarde 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Pare o efeito sonoro em loop quando você não precisar mais dele
        // clip.stop(); // Você pode adicionar um método na classe SoundEffects para parar o som em loop
    }*/








