public class Main {
    public static void main(String args[]) {
        // Runner class
        PluginWindow window = new PluginWindow();
        QuantumAudioDevice audio = new QuantumAudioDevice();
        // Start Threads
        new Thread(window).start();
        new Thread(audio).start();
    }
}
