import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class KnobPanel extends JPanel {
    final Dimension knobDimension = new Dimension(900, 300);
    Image knobImage;
    Point imageCorner;
    Point prevPoint;

    KnobPanel() {
        this.setVisible(true);
        imageCorner = new Point(0, 0);
        knobImage = new ImageIcon("PotKnob.png").getImage();
        ClickListener click = new ClickListener();
        DragListener drag = new DragListener();
        this.addMouseListener(click);
        this.addMouseMotionListener(drag);
        this.setPreferredSize(knobDimension);

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        // super.paintComponent(g);
        // knobOne.paintIcon(this, g, (int) imageCorner.getX(), (int)
        // imageCorner.getY());
        g2D.setColor(Color.WHITE);
        g2D.drawRect(0, 0, knobDimension.width, knobDimension.height);
        g2D.drawImage(knobImage, (int) imageCorner.getX(), (int) imageCorner.getY(), null);
    }

    public class ClickListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent m) {
            prevPoint = m.getPoint();
        }
    }

    private class DragListener extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent m) {
            Point currentPoint = m.getPoint();
            imageCorner.translate((int) (currentPoint.getX() - prevPoint.getX()),
                    (int) (currentPoint.getY() - prevPoint.getY()));
            prevPoint = currentPoint;
            repaint();
        }
    }
}