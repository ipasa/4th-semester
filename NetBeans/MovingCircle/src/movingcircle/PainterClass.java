/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingcircle;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author nasir
 */
public class PainterClass extends JPanel implements Runnable {

    public PainterClass() {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

    }

    @Override
    public void run() {

        Graphics g = getGraphics();

        setBackground(new Color(100, 155, 210));

        g.setColor(Color.BLACK);
        try {
            Thread.sleep(100);
        } catch (Exception ex) {
        }

        g.fillOval(225, 225, 15, 15);

        try {
            Thread.sleep(100);
        } catch (Exception ex) {
        }

        g.setColor(Color.red);

        int x = 1000, y = 1000;

        while (true) {
            for (int i = 1; i <= 360; i++) {
                try {
                    Thread.sleep(100);
                } catch (Exception ex) {
                }

                g.setColor(new Color(100, 155, 210));
                g.fillOval(x + 200, y + 200, 50, 50);

                x = (int) (100 * Math.cos((i * Math.PI) / 180) + 0.5);
                y = (int) (100 * Math.sin((i * Math.PI) / 180) + 0.5);

                g.setColor(Color.red);
                g.fillOval(x + 200, y + 200, 50, 50);
            }
        }

    }
}
