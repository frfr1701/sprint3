package sprint3;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class Sound {

    private final File winsoundPath = new File("src\\sprint3\\winsound.wav");
    private final File movesoundPath = new File("src\\sprint3\\movesound.wav");

    void movesound() {
        if (movesoundPath.exists()) {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(movesoundPath));
                clip.start();
            } catch (LineUnavailableException e) {
                System.out.println("null!");
            } catch (IOException e) {
                System.out.println("filen hittas inte!");
            } catch (UnsupportedAudioFileException e) {
                System.out.println("filen stöds inte!");
            }
        }
    }

    void winsound() {
        if (winsoundPath.exists()) {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(winsoundPath));
                clip.start();
            } catch (LineUnavailableException e) {
                System.out.println("null!");
            } catch (IOException e) {
                System.out.println("filen hittas inte!");
            } catch (UnsupportedAudioFileException e) {
                System.out.println("filen stöds inte!");
            }
        }
    }
}
