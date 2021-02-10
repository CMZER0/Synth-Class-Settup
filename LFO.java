public class LFO extends Modulator {
    int frequency;
    double samplePeriod = 1.0 / sampleRate;
    double duration = 0.002;
    double durationInSamples = Math.ceil(duration * sampleRate);
    double[] rawOutput;

    // CONSTRUCTORS //
    public LFO() {
        setType("LFO");
        setFrequency(440);
        super.setSamples(multiSample(samples));
    }

    public LFO(int HZ) {
        setType("LFO");
        setFrequency(HZ);
        super.setSamples(multiSample(samples));
    }

    // ABSTRACTS //
    @Override
    public byte[] multiSample(byte[] samples) {

        rawOutput = new double[BUFFER_SIZE];
        int time = 0;

        for (int i = 0; i < durationInSamples; i++) {
            // sample a sine wave at 440 hertz at each time tick
            // substitute a function that generates a sawtooth as a function of time / freq
            // rawOutput[i] = function_of_time(other_relevant_info, time);
            rawOutput[i] = Math.sin(2 * Math.PI * frequency * time);
            // System.out.println(rawOutput[i] + ", " + Math.sin(2 * Math.PI * frequency *
            // time));
            time += samplePeriod;
        }

        return samples;
    }

    // GETTERS & SETTERS //
    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

}