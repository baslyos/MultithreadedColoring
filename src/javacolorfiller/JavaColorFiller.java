/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacolorfiller;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author baslyos
 */
public class JavaColorFiller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Coloring Board");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new DrawingBoard2());
                frame.pack();
                frame.setResizable(false);
                frame.setVisible(true);
            }
        });
    }
}
