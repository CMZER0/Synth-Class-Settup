import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.*;

public class PluginWindow extends JFrame implements Runnable {
    protected OscillatorPanel oscOne;
    protected OscillatorPanel oscTwo;
    protected KnobPanel knobOne;
    ImageIcon icon;
    Image backGround;
    JLabel label;
    Dimension windowDimension = new Dimension(1045, 800);

    public PluginWindow() {
        // Set Icon
        icon = new ImageIcon("ZNH.png");
        label = new JLabel();
        label.setIcon(icon);
        this.setTitle("QUANTUM Z3R0");
        // Set Background
        backGround = new ImageIcon("BackGround.png").getImage();
        // Init OscillatorPanels
        oscOne = new OscillatorPanel(Color.black);
        oscTwo = new OscillatorPanel(Color.black);
        // Init KnobPanels
        knobOne = new KnobPanel();
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
        this.add(knobOne);
        // Pack Frame
        this.pack();
        // Jframe Execute Properties
        this.setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(backGround, 0, 0, null);
        knobOne.paint(knobOne.getGraphics());
    }

    @Override
    public void run() {
        while (this.isActive()) {
            try {

                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}