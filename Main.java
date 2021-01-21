public class Main {
    public static void main(String args[]) {
        // Runner class
        Oscillator a = new LFO();
        ((LFO) a).multiSample(a.samples);
        // printSamples(a);

    }

    public static void returnInfo(Oscillator o) {
        System.out.println("Buffer Size is: " + o.getBufferSize());
        System.out.println("Type is: " + o.getType());
    }

    public static void printSamples(Oscillator a) {
        for (byte b : a.samples) {
            // a.samples[b] = (byte) System.currentTimeMillis();
            System.out.print(a.samples[b] + " ");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}

// a UML-like diagram that illustrates the part of your program you’re
// demonstrating (see example below)
// a paragraph describing the greater program, how this piece fits into the
// larger whole, and the features you’d like to add someday
// the abstraction of ALL common items ← Important!
// at least one abstract class
// the use of polymorphism
// the use of casting and/or the super( ) method