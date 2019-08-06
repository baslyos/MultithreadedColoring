/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacolorfiller;

import java.awt.Cursor;
import java.awt.Point;

/**
 *
 * @author baslyos
 */
public class FillColorThread implements Runnable {

    DrawingBoard2 board = null;
    Point clickedAt = null;
    static int sleepTime; // use 50 or 25 or 17 or 16 or 0
    int colorFillingThreads;
    int threadsDone = 0;
    StartingFillInfo sfi = null;

    FillColorThread(DrawingBoard2 board, Point clickedAt) {
        this.board = board;
        this.clickedAt = clickedAt;
        sleepTime = 4;
    }

    @Override
    public void run() {
        sfi = board.initFill(clickedAt);
        if (sfi.isBlank == true) {
            //board.repaint();
            //    board.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            for (Point pt : sfi.coordinates) {
                new Thread(new TraverseAndFillThread(this, pt, true)).start();
                //System.out.println("new thread");
            }
        }
    }

    public void tryRepaint() {
        threadsDone++;
        if (threadsDone == sfi.coordinates.size()) {
//            System.out.println(threadsDone + " " + sfi.coordinates.size() + " repaint called");
//            threadSleep();
            board.repaint();
            //  board.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    private void threadSleep() {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException ex) {
            System.out.println("Sleep Error : " + ex.getMessage());
        }
    }
}
