public class LFO extends Carrier {
    int frequency;
    Sine wave;

    // CONSTRUCTORS //
    public LFO() {
        setType("SINE");
        setFrequency(440);
        setWave(new Sine());
        setSamples(wave.getByteArray());
    }

    public LFO(int HZ) {
        setType("SINE");
        setFrequency(HZ);
        setWave(new Sine());
    }

    // METHODS //

    // ABSTRACTS //
    @Override
    public byte[] multiSample(byte[] samples) {
        return samples;
    }

    // GETTERS & SETTERS //
    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Sine getWave() {
        return wave;
    }

    public void setWave(Sine wave) {
        this.wave = wave;
    }

}