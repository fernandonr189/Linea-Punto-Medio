import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Canvas extends JFrame {

    private final JPanel panel;
    private final BufferedImage buffer;

    public Canvas() {
        setTitle("LineaPuntoMedio");
        setSize(600, 600);
        panel = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setSize(600, 600);
        setLocationRelativeTo(null);
        buffer = new BufferedImage(panel.getWidth(),panel.getHeight(),BufferedImage.TYPE_INT_ARGB);
        add(panel);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        lineaPuntoMedio(100, 100, 500, 500, Color.red);
        getGraphics().drawImage(buffer,0,0,panel);
    }

    public void lineaPuntoMedio(int x1, int y1, int x2, int y2, Color a){
        int dy = y2 - y1;
        int dx = x2 - x1;
        int x = x1;
        int y = y1;
        int p;
        int mX = 1;
        int mY = 1;
        double m = (double) dy /dx;
        System.out.println("Pendiente: " + m);

        if (dy < 0){
            dy = -dy;
            mY = -1;
        }
        if (dx < 0){
            dx = -dx;
            mX = -1;
        }

        if (dx > dy){
            p = dy - (dx/2);
            for (int i = 0; i <= dx; i++){
                if (p >= 0){
                    y += mY;
                    p += dy - dx;
                }
                else {
                    p += dy;
                }
                x += mX;
                buffer.setRGB(x, y, a.getRGB());
            }
        }
        else {
            p = dx - dy;
            for (int i = 0; i <= dy; i++){
                if (p >= 0){
                    x += mX;
                    p += dx - dy;
                }
                else {
                    p += dx;
                }
                y += mY;
                buffer.setRGB(x, y, a.getRGB());
            }
        }
    }
}
