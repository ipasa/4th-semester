/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hermit.sorce;

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

		float x, y, t;

		float p1x = 10, p4x = 430, p1y = 30, p4y = 100, r1 = 80, r4 = 165;

		g.setColor(Color.red);
		for (t = 0; t <= 1.0; t += .001) {
			x = (2 * t * t * t - 3 * t * t + 1) * p1x
					+ (-2 * t * t * t + 3 * t * t) * p4x
					+ (t * t * t - 2 * t * t + t) * r1 + (t * t * t - t * t)
					* r4;
			y = (2 * t * t * t - 3 * t * t + 1) * p1y
					+ (-2 * t * t * t + 3 * t * t) * p4y
					+ (t * t * t - 2 * t * t + 1) * r1 + (t * t * t - t * t)
					* r4;
			g.fillOval((int) x + 100, (int) y + 100, 4, 4);
		}
	}
}
