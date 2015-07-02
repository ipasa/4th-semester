/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingcircle;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author nasir
 */
public class MovingCircle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        JFrame frame=new JFrame("Simple Paint Program");
        PainterClass pc=new PainterClass();
        frame.add(pc, BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setVisible(true);
        
        Thread t1 = new Thread(pc);
        t1.start();
        try {
            t1.join();
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
    }
    
}
