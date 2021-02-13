import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.*;

public class OscillatorPanel extends JPanel implements ActionListener {
    final Dimension oscDimension = new Dimension(500, 350);
    Timer timer;
    Oscillator a = new Carrier();
    int xPos = 0;
    int velocity = 5;
    Color c;
    Image fader;

    OscillatorPanel(Color c) {
        // Init JPanel
        this.c = c;
        this.setVisible(true);
        this.setPreferredSize(oscDimension);
        this.setBackground(c);
        fader = new ImageIcon("OscScanner.png").getImage();
        timer = new Timer(25, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D Osc = (Graphics2D) g;
        Osc.setColor(c);
        Osc.fillRect(0, 0, oscDimension.width, oscDimension.height);
        Osc.setColor(Color.WHITE);
        Osc.setStroke(new BasicStroke(3));
        Osc.drawLine(0, oscDimension.height / 2, oscDimension.width, oscDimension.height / 2);
        Osc.drawImage(fader, xPos - 500, 0, null);
        Osc.drawRect(0, 0, oscDimension.width, oscDimension.height);

        // Osc.drawBytes(a.multiSample(a.samples), 0, (int) ((LFO) a).samplePeriod,
        // (int) oscDimension.getWidth() / 2,
        // int) oscDimension.getHeight() / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (xPos >= oscDimension.width + 500)
            xPos = 0;
        else
            xPos += velocity;
        this.repaint();
    }

}
