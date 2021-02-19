import java.io.*;
import javax.sound.sampled.*;
import javax.sound.midi.*;

public class QuantumAudioDevice implements Runnable {

    @Override
    public void run() {
        System.out.println("Quantum is running!");
        Oscillator a = new LFO();
        a.recordAudioFile();
        System.out.println("Audio has been recorded");
    }

}
