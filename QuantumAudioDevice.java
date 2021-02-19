import java.io.*;
import javax.sound.sampled.*;
import javax.sound.midi.*;

public class QuantumAudioDevice implements Runnable {
    Oscillator a;

    @Override
    public void run() {
        System.out.println("Quantum is running!");
        a = new LFO();
        // a.recordAudioFile();
        a.gerateAudioData();

        // System.out.println("Audio has been recorded");
    }

}
