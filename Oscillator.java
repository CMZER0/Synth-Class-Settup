public abstract class Oscillator {
    String type = "DEFAULT";
    byte[] samples;
    byte sample;
    int BUFFER_SIZE;
    final int DEFAULT_BUFFER = 1024;
    final int DefaultFileStreamBufferSize = 4096;
    int sampleRate = 44100;

    //////////////////
    // CONSTRUCTORS //
    //////////////////
    protected Oscillator() {
        setBufferSize(DEFAULT_BUFFER);
        setSamples(new byte[BUFFER_SIZE]);
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

    public int getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(int sampleRate) {
        this.sampleRate = sampleRate;
    }
}