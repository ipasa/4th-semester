/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicshouse;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author nasir
 */
public class PainterClass extends JPanel implements Runnable {

    int constant = 100;
    Graphics g;

    public PainterClass() {

    }

    @Override
    public void run() {

        Graphics g = getGraphics();

        try {
            Thread.sleep(3000);
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
        
        int x[] = {100 + constant, 200 + constant, 150 + constant};
        int y[] = {100 + constant, 100 + constant, 50 + constant};

        g.fillPolygon(x, y, 3);
        
        g.setColor(Color.red);
        g.fillRect(105 + constant, 100 + constant, 90, 100);

        g.setColor(Color.CYAN);
        g.fillRect(195 + constant, 100 + constant, 100, 100);
        
        int x1[] = {150 + constant, 200 + constant, 305 + constant, 250 + constant};
        int y1[] = {50 + constant, 100 + constant, 100 + constant, 50 + constant};
        g.setColor(Color.DARK_GRAY);

        
        g.fillPolygon(x1, y1, 4);
        
        g.setColor(Color.YELLOW);
        g.fillRect(135 + constant, 130 + constant, 30, 30);

        g.setColor(Color.YELLOW);
        g.fillRect(230 + constant, 120 + constant, 30, 80);

        
        g.setColor(Color.BLACK);
        g.fillRect(242 + constant, 120 + constant, 5, 80);

        
        g.setColor(Color.GRAY);
        g.fillRect(100 + constant, 200 + constant, 200, 10);

        g.setColor(Color.red);
        int x2 = 0, y2 = 0, r = 30;
        for (int th = 0; th <= 360; th++) {
            x2 = (int) (r * Math.cos(th) + 80);
            y2 = (int) (r * Math.sin(th) + 80);

            g.fillOval(x2, y2, 4, 4);

            if (th % 6 == 0) {
                g.drawLine((int) ((r + 20) * Math.cos(th) + 80), (int) ((r + 20) * Math.sin(th) + 80), x2, y2);
            }

            for (int i = r; i >= 0; i--) {

                x2 = (int) (i * Math.cos(th) + 80);
                y2 = (int) (i * Math.sin(th) + 80);

                g.fillOval(x2, y2, 4, 4);

            }

        }
        

    }
}
