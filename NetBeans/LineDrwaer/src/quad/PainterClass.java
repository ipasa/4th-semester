/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quad;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author nasir
 */
public class PainterClass extends JPanel {

    public int radious = 50;

    public int constant = 200;

    public boolean numGo = true;

    public PainterClass() {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int r = radious;
        int j = 1 + constant;
        int i = 1 + constant;
        int time = 1;
        while (time < 5) {

            int num = 0;
            if (time % 2 == 0) {
                g.setColor(Color.red);
                num = j;
            } else {
                g.setColor(Color.green);
                num = i;
            }

            if (num >= 300) {
                numGo = false;
            } else {
                numGo = true;
            }

            int point = 0;
            while (point < 100) {
                
                if (time % 2 == 0) {
                    g.fillOval(i, num, 4, 4);
                    j = num;
                } else {
                    g.fillOval(num, j, 4, 4);
                    i = num;
                }
                if (numGo) {
                    num++;
                } else {
                    num--;
                }
                point++;
                
            }
            time++;
        }
    }
}
