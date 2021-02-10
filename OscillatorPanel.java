import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.BasicStroke;

public class OscillatorPanel extends JPanel {
    Dimension oscDimension = new Dimension(500, 350);
    Oscillator a = new Carrier();
    Color c;

    OscillatorPanel(Color c) {
        //
        ImageIcon icon = new ImageIcon("ZNH.png");
        //
        JLabel label = new JLabel();
        label.setText(a.type);
        label.setIcon(icon);
        // Init JPanel
        this.setPreferredSize(oscDimension);
        this.setBackground(Color.GRAY);
        // Add Label
        this.add(label);
        this.c = c;
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(c);
        g2D.fillRect(0, 0, oscDimension.width, oscDimension.height);
        // g2D.drawBytes(a.multiSample(a.samples), 0, (int) ((LFO) a).samplePeriod,
        // (int) oscDimension.getWidth() / 2,
        // (int) oscDimension.getHeight() / 2);
    }
}
