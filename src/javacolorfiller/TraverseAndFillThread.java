/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacolorfiller;

import java.awt.Point;

/**
 *
 * @author baslyos
 */
public class TraverseAndFillThread implements Runnable {

    Point pixelLocation;
    FillColorThread fct;
    boolean stopMatters;

    public TraverseAndFillThread(FillColorThread fct, Point pixelLocation, boolean stopCounts) {
        this.pixelLocation = pixelLocation;
        this.fct = fct;
        this.stopMatters = stopCounts;
    }

    @Override
    public void run() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        traverseUpAndFill(pixelLocation, 0);
        fct.board.setPixelRGB(pixelLocation);
        if (stopMatters) {
            fct.tryRepaint();
        }
    }

//    private void traverseAndFill(Point pixelLocation, int iterations) {
//        // System.out.println(iterations++);
//        iterations++;
//        if (fct.board.setPixelRGB(new Point(pixelLocation.x, pixelLocation.y - 1)) == true) {
//            fct.board.repaint(pixelLocation.x, pixelLocation.y - 1, 1, 1);
//            threadSleep();
//            if (iterations < 2000) {
//                traverseAndFill(new Point(pixelLocation.x, pixelLocation.y - 1), iterations);
//            } else {
//                Thread thrd = null;
//                TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation, false);
//                thrd = new Thread(taft);
//                thrd.start();
//                try {
//                    thrd.join();
//                } catch (InterruptedException ex) {
//                    System.out.println("Error " + ex.getMessage());
//                }
//
//            }
//        }
//        if (fct.board.setPixelRGB(new Point(pixelLocation.x, pixelLocation.y + 1)) == true) {
//            fct.board.repaint(pixelLocation.x, pixelLocation.y + 1, 1, 1);
//            threadSleep();
//            if (iterations < 2000) {
//                traverseAndFill(new Point(pixelLocation.x, pixelLocation.y + 1), iterations);
//            } else {
//                Thread thrd = null;
//                TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation, false);
//                thrd = new Thread(taft);
//                thrd.start();
//                try {
//                    thrd.join();
//                } catch (InterruptedException ex) {
//                    System.out.println("Error " + ex.getMessage());
//                }
//
//            }
//        }
//        if (fct.board.setPixelRGB(new Point(pixelLocation.x - 1, pixelLocation.y)) == true) {
//            fct.board.repaint(pixelLocation.x - 1, pixelLocation.y, 1, 1);
//            threadSleep();
//            if (iterations < 2000) {
//                traverseAndFill(new Point(pixelLocation.x - 1, pixelLocation.y), iterations);
//            } else {
//                Thread thrd = null;
//                TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation, false);
//                thrd = new Thread(taft);
//                thrd.start();
//                try {
//                    thrd.join();
//                } catch (InterruptedException ex) {
//                    System.out.println("Error " + ex.getMessage());
//                }
//
//            }
//        }
//        if (fct.board.setPixelRGB(new Point(pixelLocation.x + 1, pixelLocation.y)) == true) {
//            fct.board.repaint(pixelLocation.x + 1, pixelLocation.y, 1, 1);
//            threadSleep();
//            if (iterations < 2000) {
//                traverseAndFill(new Point(pixelLocation.x + 1, pixelLocation.y), iterations);
//            } else {
//                Thread thrd = null;
//                TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation, false);
//                thrd = new Thread(taft);
//                thrd.start();
//                try {
//                    thrd.join();
//                } catch (InterruptedException ex) {
//                    System.out.println("Error " + ex.getMessage());
//                }
//
//            }
//        }
//    }
    private void traverseUpAndFill(Point pixelLocation, int iterations) {
        iterations++;
        if (fct.board.setPixelRGB(new Point(pixelLocation.x, pixelLocation.y - 1)) == true) {
            fct.board.repaint(pixelLocation.x, pixelLocation.y - 1, 1, 1);
            threadSleep();
            if (iterations < 2000) {
                traverseUpAndFill(new Point(pixelLocation.x, pixelLocation.y - 1), iterations);
            } else {
                Thread thrd = null;
                TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation, false);
                thrd = new Thread(taft);
                thrd.start();
                try {
                    thrd.join();
                } catch (InterruptedException ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
        }
        if (fct.board.setPixelRGB(new Point(pixelLocation.x - 1, pixelLocation.y)) == true) {
            fct.board.repaint(pixelLocation.x - 1, pixelLocation.y, 1, 1);
            threadSleep();
            if (iterations < 2000) {
                traverseLeftAndFill(new Point(pixelLocation.x - 1, pixelLocation.y), iterations);
            } else {
                Thread thrd = null;
                TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation, false);
                thrd = new Thread(taft);
                thrd.start();
                try {
                    thrd.join();
                } catch (InterruptedException ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
        }
        if (fct.board.setPixelRGB(new Point(pixelLocation.x + 1, pixelLocation.y)) == true) {
            fct.board.repaint(pixelLocation.x + 1, pixelLocation.y, 1, 1);
            threadSleep();
            if (iterations < 2000) {
                traverseRightAndFill(new Point(pixelLocation.x + 1, pixelLocation.y), iterations);
            } else {
                Thread thrd = null;
                TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation, false);
                thrd = new Thread(taft);
                thrd.start();
                try {
                    thrd.join();
                } catch (InterruptedException ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
        }
    }

    private void traverseLeftAndFill(Point pixelLocation, int iterations) {
        iterations++;
        if (fct.board.setPixelRGB(new Point(pixelLocation.x - 1, pixelLocation.y)) == true) {
            fct.board.repaint(pixelLocation.x - 1, pixelLocation.y, 1, 1);
            threadSleep();
            if (iterations < 2000) {
                traverseLeftAndFill(new Point(pixelLocation.x - 1, pixelLocation.y), iterations);
            } else {
                Thread thrd = null;
                TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation, false);
                thrd = new Thread(taft);
                thrd.start();
                try {
                    thrd.join();
                } catch (InterruptedException ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
        }
        if (fct.board.setPixelRGB(new Point(pixelLocation.x, pixelLocation.y + 1)) == true) {
            fct.board.repaint(pixelLocation.x, pixelLocation.y + 1, 1, 1);
            threadSleep();
            if (iterations < 2000) {
                traverseDownAndFill(new Point(pixelLocation.x, pixelLocation.y + 1), iterations);
            } else {
                Thread thrd = null;
                TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation, false);
                thrd = new Thread(taft);
                thrd.start();
                try {
                    thrd.join();
                } catch (InterruptedException ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
        }
        if (fct.board.setPixelRGB(new Point(pixelLocation.x, pixelLocation.y - 1)) == true) {
            fct.board.repaint(pixelLocation.x, pixelLocation.y - 1, 1, 1);
            threadSleep();
            if (iterations < 2000) {
                traverseUpAndFill(new Point(pixelLocation.x, pixelLocation.y - 1), iterations);
            } else {
                Thread thrd = null;
                TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation, false);
                thrd = new Thread(taft);
                thrd.start();
                try {
                    thrd.join();
                } catch (InterruptedException ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
        }
    }

    private void traverseDownAndFill(Point pixelLocation, int iterations) {
        iterations++;
        if (fct.board.setPixelRGB(new Point(pixelLocation.x, pixelLocation.y + 1)) == true) {
            fct.board.repaint(pixelLocation.x, pixelLocation.y + 1, 1, 1);
            threadSleep();
            if (iterations < 2000) {
                traverseDownAndFill(new Point(pixelLocation.x, pixelLocation.y + 1), iterations);
            } else {
                Thread thrd = null;
                TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation, false);
                thrd = new Thread(taft);
                thrd.start();
                try {
                    thrd.join();
                } catch (InterruptedException ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
        }
        if (fct.board.setPixelRGB(new Point(pixelLocation.x + 1, pixelLocation.y)) == true) {
            fct.board.repaint(pixelLocation.x + 1, pixelLocation.y, 1, 1);
            threadSleep();
            if (iterations < 2000) {
                traverseRightAndFill(new Point(pixelLocation.x + 1, pixelLocation.y), iterations);
            } else {
                Thread thrd = null;
                TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation, false);
                thrd = new Thread(taft);
                thrd.start();
                try {
                    thrd.join();
                } catch (InterruptedException ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
        }
        if (fct.board.setPixelRGB(new Point(pixelLocation.x - 1, pixelLocation.y)) == true) {
            fct.board.repaint(pixelLocation.x - 1, pixelLocation.y, 1, 1);
            threadSleep();
            if (iterations < 2000) {
                traverseLeftAndFill(new Point(pixelLocation.x - 1, pixelLocation.y), iterations);
            } else {
                Thread thrd = null;
                TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation, false);
                thrd = new Thread(taft);
                thrd.start();
                try {
                    thrd.join();
                } catch (InterruptedException ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
        }
    }

    private void traverseRightAndFill(Point pixelLocation, int iterations) {
        iterations++;
        if (fct.board.setPixelRGB(new Point(pixelLocation.x + 1, pixelLocation.y)) == true) {
            fct.board.repaint(pixelLocation.x + 1, pixelLocation.y, 1, 1);
            threadSleep();
            if (iterations < 2000) {
                traverseRightAndFill(new Point(pixelLocation.x + 1, pixelLocation.y), iterations);
            } else {
                Thread thrd = null;
                TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation, false);
                thrd = new Thread(taft);
                thrd.start();
                try {
                    thrd.join();
                } catch (InterruptedException ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
        }
        if (fct.board.setPixelRGB(new Point(pixelLocation.x, pixelLocation.y - 1)) == true) {
            fct.board.repaint(pixelLocation.x, pixelLocation.y - 1, 1, 1);
            threadSleep();
            if (iterations < 2000) {
                traverseUpAndFill(new Point(pixelLocation.x, pixelLocation.y - 1), iterations);
            } else {
                Thread thrd = null;
                TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation, false);
                thrd = new Thread(taft);
                thrd.start();
                try {
                    thrd.join();
                } catch (InterruptedException ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
        }
        if (fct.board.setPixelRGB(new Point(pixelLocation.x, pixelLocation.y + 1)) == true) {
            fct.board.repaint(pixelLocation.x, pixelLocation.y + 1, 1, 1);
            threadSleep();
            if (iterations < 2000) {
                traverseDownAndFill(new Point(pixelLocation.x, pixelLocation.y + 1), iterations);
            } else {
                Thread thrd = null;
                TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation, false);
                thrd = new Thread(taft);
                thrd.start();
                try {
                    thrd.join();
                } catch (InterruptedException ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
        }
    }

    private void threadSleep() {
        try {
            Thread.sleep(4);
        } catch (InterruptedException ex) {
            System.out.println("Sleep Error : " + ex.getMessage());
        }
    }
}
