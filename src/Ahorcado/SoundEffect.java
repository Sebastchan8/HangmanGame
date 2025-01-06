
package Ahorcado;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundEffect {
    Clip clip;
    
    public SoundEffect(String fileName){
        try {
            File file = new File(fileName+".wav");
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            this.clip = AudioSystem.getClip();
            this.clip.open(sound);
        } catch (Exception e) {
        }
    }
    
    public void play(boolean loop){
        clip.setFramePosition(0);
        clip.start();
        if(loop)
            clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void stop(){
        clip.stop();
    }
}
