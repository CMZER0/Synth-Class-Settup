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
import java.awt.geom.AffineTransform;

public class KnobPanel extends JPanel {
    final Dimension knobDimension = new Dimension(60, 60);
    AffineTransform identity = new AffineTransform();
    Image knobImage;
    Point imageCorner;
    Point imageCenter;
    Point clickPoint;
    Double value;

    KnobPanel() {
        this.setVisible(true);
        knobImage = new ImageIcon("PotKnob.png").getImage();

        ClickListener click = new ClickListener();
        DragListener drag = new DragListener();
        this.addMouseListener(click);
        this.addMouseMotionListener(drag);
        this.setPreferredSize(knobDimension);

        imageCorner = (new Point(0, 0));
        imageCenter = new Point((int) imageCorner.getX() + (knobDimension.width / 2),
                (int) imageCorner.getY() + (knobDimension.height / 2));

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(knobImage, identity, this);
    }

    public class ClickListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent m) {
            clickPoint = m.getPoint();
        }
    }

    private class DragListener extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent m) {

            AffineTransform trans = new AffineTransform();
            value = (m.getY() - clickPoint.getY()) / ((800) / (double) 25);
            trans.rotate(value, imageCenter.getX(), imageCenter.getY());
            trans.setTransform(identity);
            repaint();
        }
    }
}