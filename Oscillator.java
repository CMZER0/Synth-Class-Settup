import java.io.*;
import javax.sound.sampled.*;
import javax.sound.midi.*;

public abstract class Oscillator {
    String type = "DEFAULT";
    public byte[] samples;
    byte sample;
    int BUFFER_SIZE;
    final int DEFAULT_BUFFER = 1024;
    final int DefaultFileStreamBufferSize = 4096;

    static int sampleRate = 44100;
    static int sampleSize = 16;
    static int numberOfChannels = 2;
    static int frameSizeInBytes = 4;
    // JAVA SOUND COMPONENTS //
    public static Mixer mixer;
    public static Clip clip;

    //////////////////
    // CONSTRUCTORS //
    //////////////////
    protected Oscillator() {
        setBufferSize(DEFAULT_BUFFER);
        setSamples(new byte[BUFFER_SIZE]);
    }

    /////////////
    // METHODS //
    /////////////
    protected void gerateAudioData() throws LineUnavailableException {
        File fileOut = new File("output");
        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, sampleRate, sampleSize, numberOfChannels,
                frameSizeInBytes, sampleRate, false);
                DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
                if (!AudioSystem.isLineSupported(info)) {
                    System.out.println("Line Not Supported");
                    System.exit(0);
                }
               f
    }

    protected static void readAudioFile() {
        try {
            Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
            mixer = AudioSystem.getMixer(mixInfos[0]);
            DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
            clip = (Clip) mixer.getLine(dataInfo);
            File file = new File("Test.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip.open(audioInputStream);
        } catch (LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    protected static void recordAudioFile() {
        try {
            AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, sampleRate, sampleSize,
                    numberOfChannels, frameSizeInBytes, sampleRate, false);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line Not Supported");
                System.exit(0);
            }
            TargetDataLine targetLine = (TargetDataLine) AudioSystem.getLine(info);
            targetLine.open();
            targetLine.start();
            Thread thread = new Thread() {
                @Override
                public void run() {
                    AudioInputStream audioStream = new AudioInputStream(targetLine);
                    File audioFile = new File("record.wav");
                    try {
                        AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE, audioFile);
                    } catch (IOException e) {

                    }
                }
            };
            thread.start();
            Thread.sleep(5000);
            targetLine.stop();
            targetLine.close();
        } catch (LineUnavailableException e) {

        } catch (InterruptedException e) {

        }

    }

    ///////////////
    // ABSTRACTS //
    ///////////////
    public abstract byte singleSample(byte in);

    public abstract byte[] multiSample(byte[] in);

    ///////////////////////
    // GETTERS & SETTERS //
    ///////////////////////
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getSamples() {
        return samples;
    }

    public void setSamples(byte[] samples) {
        this.samples = samples;
    }

    public byte getSample() {
        return sample;
    }

    public void setSample(byte sample) {
        this.sample = sample;
    }

    public int getBufferSize() {
        return BUFFER_SIZE;
    }

    public void setBufferSize(int BUFFER_SIZE) {
        this.BUFFER_SIZE = BUFFER_SIZE;
    }

}