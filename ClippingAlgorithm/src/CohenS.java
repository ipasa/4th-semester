/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pasha
 */

/*
 COHEN-SUTHERLAND ALGORITHM
 */
import java.applet.*;
import java.awt.*;
import java.util.*;

public class CohenS extends Applet {

    Scanner sc = new Scanner(System.in);
    int xmax, ymax, xmin, ymin;

    public int[] set(int x, int y) {
        int a[] = new int[4];
        if (x < xmin) {
            a[3] = 1;
        } else {
            a[3] = 0;
        }
        if (x > xmax) {
            a[2] = 1;
        } else {
            a[2] = 0;
        }
        if (y < ymin) {
            a[0] = 1;
        } else {
            a[0] = 0;
        }
        if (y > ymax) {
            a[1] = 1;
        } else {
            a[1] = 0;
        }
        return a;
    }

    void setminmax() {
        System.out.println("Enter xmax of the Rectangle");
        xmax = sc.nextInt();
        System.out.println("Enter ymax of the Rectangle");
        ymax = sc.nextInt();
        System.out.println("Enter xmin of the Rectangle");
        xmin = sc.nextInt();
        System.out.println("Enter ymin of the Rectangle");
        ymin = sc.nextInt();

    }

    boolean check(int a[]) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                return false;
            }
        }
        return true;
    }

    int[] produceXY(int i, int x1, int y1, float m) {
        int a[] = new int[2];
        float x = 0, y = 0;
        switch (i) {
            case 0:
                x = xmin;
                y = y1 + m * (x - x1);
                break;

            case 1:
                x = xmax;
                y = y1 + m * (x - x1);
                break;
            case 3:
                y = ymin;
                x = x1 + (y - y1) / m;
                break;
            case 2:
                y = ymax;
                x = x1 + (y - y1) / m;
                break;
        }
        a[0] = (int) x;
        a[1] = (int) y;
        return a;
    }

    boolean doAnd(int a[], int b[]) {
        for (int i = 0; i < a.length; i++) {
            int k = a[i] & b[i];
            if (k == 1) {
                return false;
            }
        }
        return true;
    }

    public void paint(Graphics g) {
        setminmax();
        g.drawRect(xmin, ymin, xmax - xmin, ymax - ymin);
        g.drawRect(xmin + 100, ymin, xmax - xmin, ymax - ymin);
        int a[][] = new int[2][4];
        int b[][] = new int[2][4];
        int c[] = new int[2];
        int c1 = 20;
        int x1, y1, x2, y2;
        System.out.println("Enter x1 of the line");
        x1 = sc.nextInt();
        System.out.println("Enter y1");
        y1 = sc.nextInt();
        System.out.println("Enter x2");
        x2 = sc.nextInt();
        System.out.println("Enter y2");
        y2 = sc.nextInt();

        float m = (y2 - y1) * 1.0f / (x2 - x1);

        g.drawLine(x1, y1, x2, y2);
        a[0] = set(x1, y1);
        a[1] = set(x2, y2);
        if (check(a[0]) && check(a[1])) {
            g.drawLine(x1, y1, x2, y2);
        } else {
            if (doAnd(a[0], b[1])) {
                for (int i = a[0].length - 1; i >= 0; i--) {
                    if (a[0][i] == 1) {
                        c = produceXY(a[0].length - 1 - i, x1, y1, m);
                        b[0] = set(c[0], c[1]);

                        if (check(b[0])) {
                            x1 = c[0];
                            y1 = c[1];
                            break;
                        }
                        c1 += 20;
                    }
                }
                for (int i = a[0].length - 1; i >= 0; i--) {
                    if (a[1][i] == 1) {
                        c = produceXY(a[0].length - 1 - i, x1, y1, m);
                        b[1] = set(c[0], c[1]);

                        if (check(b[1])) {
                            x2 = c[0];
                            y2 = c[1];
                            break;
                        }
                        c1 += 20;
                    }
                }
                g.drawLine(x1 + 100, y1, x2 + 100, y2);
            }
        }
    }

}
