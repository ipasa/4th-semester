/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sundraw;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author nasir
 */
public class PainterClass extends JPanel {

    public PainterClass() {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.red);
        int x = 0, y = 0, r = 100;
        for (int th = 0; th <= 360; th++) {
            x = (int) (r * Math.cos(th) + 200);
            y = (int) (r * Math.sin(th) + 200);

            g.fillOval(x, y, 4, 4);
            
            g.drawLine((int) ((r+30) * Math.cos(th) + 200), (int) ((r+30) * Math.sin(th) + 200), x, y);

            for (int i = r; i >= 0; i--) {

                x = (int) (i * Math.cos(th) + 200);
                y = (int) (i * Math.sin(th) + 200);

                g.fillOval(x, y, 4, 4);

            }
            
        }
        
        g.setColor(Color.green);
        g.fillRect(10, 200, 400, 150);
        
        
        g.fillOval(600, 400, 20, 20);
    }
}
