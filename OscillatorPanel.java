import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.*;

public class OscillatorPanel extends JPanel implements ActionListener {
    Dimension oscDimension = new Dimension(500, 350);
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
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(c);
        g2D.fillRect(0, 0, oscDimension.width, oscDimension.height);
        g2D.setColor(Color.WHITE);
        g2D.setStroke(new BasicStroke(3));
        g2D.drawLine(0, oscDimension.height / 2, oscDimension.width, oscDimension.height / 2);
        g2D.drawImage(fader, xPos - 500, 0, null);
        g2D.drawRect(0, 0, oscDimension.width, oscDimension.height);

        // g2D.drawBytes(a.multiSample(a.samples), 0, (int) ((LFO) a).samplePeriod,
        // (int) oscDimension.getWidth() / 2,
        // int) oscDimension.getHeight() / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (xPos >= oscDimension.width)
            xPos = 0;
        else
            xPos += velocity;
        this.repaint();
    }
}
