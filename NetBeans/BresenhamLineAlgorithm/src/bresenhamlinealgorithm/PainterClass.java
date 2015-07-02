/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bresenhamlinealgorithm;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author nasir
 */
public class PainterClass extends JPanel {

    int x0 = 100;
    int x1 = 300;
    int y0 = 100;
    int y1 = 300;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /*
        
         plotLine(x0,y0, x1,y1)
         dx=x1-x0
         dy=y1-y0

         D = 2*dy - dx
         plot(x0,y0)
         y=y0

         for x from x0+1 to x1
         if D > 0
         y = y+1
         plot(x,y)
         D = D + (2*dy-2*dx)
         else
         plot(x,y)
         D = D + (2*dy)
        
         */
        int dx = x1 - x0;
        int dy = y1 - y0;
        int D = 2 * dy - dx;

        g.fillOval(x0, y0, 10, 10);

        int y = y0;
        for (int x = x0 + 1; x < x1; x++) {

            if (D > 0) {
                y++;
                g.fillOval(x, y, 10, 10);
                D = D + (2 * dy - 2 * dx);
            } else {
                g.fillOval(x, y, 10, 10);
                D=D+2*dy;
            }

        }

    }
}
