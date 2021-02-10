import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class PluginWindow extends JFrame implements Runnable {
    protected OscillatorPanel oscOne;
    protected OscillatorPanel oscTwo;
    ImageIcon icon;
    JLabel label;
    Dimension windowDimension = new Dimension(1045, 800);
    // Dimension toolBarDimension = new Dimension(1000, 450);

    public PluginWindow() {
        // Set Icon
        icon = new ImageIcon("ZNH.png");
        label = new JLabel();
        label.setIcon(icon);
        this.setTitle("QUANTUM Z3R0");
        // Init OscillatorPanels
        oscOne = new OscillatorPanel(Color.red);
        oscOne.setBackground(Color.red);
        oscTwo = new OscillatorPanel(Color.blue);
        oscTwo.setBackground(Color.blue);
        // Init Jframe Properties
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(windowDimension);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.setVisible(true);
        // Add to Jframe
        this.setIconImage(icon.getImage());
        this.add(oscOne);
        this.add(oscTwo);
        // Pack Frame
        this.pack();
        // Jframe Execute Properties
        this.setLocationRelativeTo(null);
    }

    @Override
    public void run() {
        while (this.isActive()) {
            // Create Graphics
            Graphics gOne = oscOne.getGraphics();
            Graphics gTwo = oscTwo.getGraphics();
            // Run Paint Menthods Here
            oscOne.paint(gOne);
            oscTwo.paint(gTwo);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}