import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer {
    public void playSounds(char reason){
        String path = "sounds/background.wav";
        switch (reason){//m=movement,l=levelcomplete,o=gameover
            case 'm':
                path = "sounds/move.wav";
                break;
            case 'l':
                path = "sounds/levelcomplete.wav";
                break;
            case 'o':
                path = "sounds/gameover.wav";
                break;
            case 'b':
                path = "sounds/background.wav";
            case 'c':
                path = "sounds/click.wav";
            default:

        }
        File sound = new File(path);
        PlaySound(sound);
    }
    public void PlaySound(File sound){
        // Wrapping the logic in a Thread so it runs in the background
        new Thread(() -> {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(sound));
                clip.start();

                // This sleep now only freezes the background thread,
                // leaving your Main thread (and Scanner) free!
                Thread.sleep(clip.getMicrosecondLength()/1000);
            } catch (Exception e){
                e.printStackTrace();
            }
        }).start();
    }
}