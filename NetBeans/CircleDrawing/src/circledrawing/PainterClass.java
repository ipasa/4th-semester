/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circledrawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author nasir
 */
public class PainterClass extends JPanel {

    public int radious = 50;
    public int constant = 350;

    public PainterClass() {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int x = 0;
        int y = 0;

        for (double theta = 0; theta <= 360; theta++) {

            double temp = radious * Math.cos(theta);
            temp += .5;
            x = (int) temp;
            temp = radious * Math.sin(theta);
            temp += .5;
            y = (int) temp;

            g2d.fillOval(x + constant, y + constant, 2, 2);
            System.out.println("x="+(x)+", y="+(y));
            
            /*
            g2d.translate(100, 100);

            g2d.fillOval(x + constant, y + constant, 2, 2);

            g2d.translate(-100, -100);*/

        }
        
        

    }
}
