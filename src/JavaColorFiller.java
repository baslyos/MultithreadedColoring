
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author baslyos
 */
public class JavaColorFiller {

	/**
	 * @param args
	 *            the command line arguments
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

class DrawingBoard2 extends JPanel {

	private BasicShape jerry[] = null;
	private BufferedImage bImage = null;
	private static final Color blankColor = Color.WHITE;
	private static final Color coloredColor = Color.RED;
	private static final Color boundaryColor = Color.BLACK;

	class BasicShape { // class for holding a basic shape's coordinates

		String type;
		double x1, y1, x2, y2, x, y, r;
	}

	public DrawingBoard2() {
		this.setPreferredSize(new Dimension(1000, 700));
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				new Thread(new FillColorThread(DrawingBoard2.this, evt.getPoint())).start();
			}
		});
		bImage = new BufferedImage(this.getPreferredSize().width, this.getPreferredSize().height,
				BufferedImage.TYPE_INT_ARGB);
		drawBasicShape(bImage.createGraphics());
	}

	private void setupBasicShape() {
		jerry = new BasicShape[30];
		for (int i = 0; i < jerry.length; i++) {
			jerry[i] = new BasicShape();
		}
		jerry[0].type = "elipse";
		jerry[0].x1 = 400;
		jerry[0].y1 = 200;
		jerry[0].x2 = 445;
		jerry[0].y2 = 245;
		jerry[0].x = 450;
		jerry[0].y = 250;
		jerry[0].r = 0;
		jerry[1].type = "elipse";
		jerry[1].x1 = 560;
		jerry[1].y1 = 200;
		jerry[1].x2 = 515;
		jerry[1].y2 = 245;
		jerry[1].x = 510;
		jerry[1].y = 250;
		jerry[1].r = 0;
		jerry[2].type = "circle";
		jerry[2].x1 = 0;
		jerry[2].y1 = 0;
		jerry[2].x2 = 0;
		jerry[2].y2 = 0;
		jerry[2].x = 480;
		jerry[2].y = 260;
		jerry[2].r = 30;
		jerry[26].type = "circle";
		jerry[26].x1 = 0;
		jerry[26].y1 = 0;
		jerry[26].x2 = 0;
		jerry[26].y2 = 0;
		jerry[26].x = 470;
		jerry[26].y = 250;
		jerry[26].r = 10;
		jerry[27].type = "circle";
		jerry[27].x1 = 0;
		jerry[27].y1 = 0;
		jerry[27].x2 = 0;
		jerry[27].y2 = 0;
		jerry[27].x = 490;
		jerry[27].y = 250;
		jerry[27].r = 10;
		jerry[28].type = "circle";
		jerry[28].x1 = 0;
		jerry[28].y1 = 0;
		jerry[28].x2 = 0;
		jerry[28].y2 = 0;
		jerry[28].x = 470;
		jerry[28].y = 250;
		jerry[28].r = 4;
		jerry[29].type = "circle";
		jerry[29].x1 = 0;
		jerry[29].y1 = 0;
		jerry[29].x2 = 0;
		jerry[29].y2 = 0;
		jerry[29].x = 490;
		jerry[29].y = 250;
		jerry[29].r = 4;
		jerry[3].type = "line";
		jerry[3].x1 = 480;
		jerry[3].y1 = 290;
		jerry[3].x2 = 480;
		jerry[3].y2 = 300;
		jerry[3].x = 0;
		jerry[3].y = 0;
		jerry[3].r = 0;
		jerry[4].type = "line";
		jerry[4].x1 = 480;
		jerry[4].y1 = 300;
		jerry[4].x2 = 440;
		jerry[4].y2 = 320;
		jerry[4].x = 0;
		jerry[4].y = 0;
		jerry[4].r = 0;
		jerry[5].type = "line";
		jerry[5].x1 = 440;
		jerry[5].y1 = 320;
		jerry[5].x2 = 440;
		jerry[5].y2 = 360;
		jerry[5].x = 0;
		jerry[5].y = 0;
		jerry[5].r = 0;
		jerry[6].type = "line";
		jerry[6].x1 = 440;
		jerry[6].y1 = 360;
		jerry[6].x2 = 450;
		jerry[6].y2 = 380;
		jerry[6].x = 0;
		jerry[6].y = 0;
		jerry[6].r = 0;
		jerry[7].type = "line";
		jerry[7].x1 = 450;
		jerry[7].y1 = 380;
		jerry[7].x2 = 510;
		jerry[7].y2 = 380;
		jerry[7].x = 0;
		jerry[7].y = 0;
		jerry[7].r = 0;
		jerry[8].type = "line";
		jerry[8].x1 = 510;
		jerry[8].y1 = 380;
		jerry[8].x2 = 520;
		jerry[8].y2 = 360;
		jerry[8].x = 0;
		jerry[8].y = 0;
		jerry[8].r = 0;
		jerry[9].type = "line";
		jerry[9].x1 = 520;
		jerry[9].y1 = 360;
		jerry[9].x2 = 520;
		jerry[9].y2 = 320;
		jerry[9].x = 0;
		jerry[9].y = 0;
		jerry[9].r = 0;
		jerry[10].type = "line";
		jerry[10].x1 = 520;
		jerry[10].y1 = 320;
		jerry[10].x2 = 480;
		jerry[10].y2 = 300;
		jerry[10].x = 0;
		jerry[10].y = 0;
		jerry[10].r = 0;
		jerry[11].type = "line";
		jerry[11].x1 = 440;
		jerry[11].y1 = 320;
		jerry[11].x2 = 410;
		jerry[11].y2 = 350;
		jerry[11].x = 0;
		jerry[11].y = 0;
		jerry[11].r = 0;
		jerry[12].type = "line";
		jerry[12].x1 = 410;
		jerry[12].y1 = 350;
		jerry[12].x2 = 420;
		jerry[12].y2 = 350;
		jerry[12].x = 0;
		jerry[12].y = 0;
		jerry[12].r = 0;
		jerry[13].type = "line";
		jerry[13].x1 = 410;
		jerry[13].y1 = 350;
		jerry[13].x2 = 420;
		jerry[13].y2 = 350;
		jerry[13].x = 0;
		jerry[13].y = 0;
		jerry[13].r = 0;
		jerry[14].type = "line";
		jerry[14].x1 = 420;
		jerry[14].y1 = 350;
		jerry[14].x2 = 440;
		jerry[14].y2 = 340;
		jerry[14].x = 0;
		jerry[14].y = 0;
		jerry[14].r = 0;
		jerry[15].type = "line";
		jerry[15].x1 = 410;
		jerry[15].y1 = 350;
		jerry[15].x2 = 420;
		jerry[15].y2 = 350;
		jerry[15].x = 0;
		jerry[15].y = 0;
		jerry[15].r = 0;
		jerry[16].type = "line";
		jerry[16].x1 = 520;
		jerry[16].y1 = 320;
		jerry[16].x2 = 550;
		jerry[16].y2 = 350;
		jerry[16].x = 0;
		jerry[16].y = 0;
		jerry[16].r = 0;
		jerry[17].type = "line";
		jerry[17].x1 = 550;
		jerry[17].y1 = 350;
		jerry[17].x2 = 540;
		jerry[17].y2 = 350;
		jerry[17].x = 0;
		jerry[17].y = 0;
		jerry[17].r = 0;
		jerry[18].type = "line";
		jerry[18].x1 = 540;
		jerry[18].y1 = 350;
		jerry[18].x2 = 520;
		jerry[18].y2 = 340;
		jerry[18].x = 0;
		jerry[18].y = 0;
		jerry[18].r = 0;
		jerry[19].type = "line";
		jerry[19].x1 = 450;
		jerry[19].y1 = 380;
		jerry[19].x2 = 460;
		jerry[19].y2 = 440;
		jerry[19].x = 0;
		jerry[19].y = 0;
		jerry[19].r = 0;
		jerry[20].type = "line";
		jerry[20].x1 = 480;
		jerry[20].y1 = 380;
		jerry[20].x2 = 470;
		jerry[20].y2 = 440;
		jerry[20].x = 0;
		jerry[20].y = 0;
		jerry[20].r = 0;
		jerry[21].type = "line";
		jerry[21].x1 = 480;
		jerry[21].y1 = 380;
		jerry[21].x2 = 490;
		jerry[21].y2 = 440;
		jerry[21].x = 0;
		jerry[21].y = 0;
		jerry[21].r = 0;
		jerry[22].type = "line";
		jerry[22].x1 = 510;
		jerry[22].y1 = 380;
		jerry[22].x2 = 500;
		jerry[22].y2 = 440;
		jerry[22].x = 0;
		jerry[22].y = 0;
		jerry[22].r = 0;
		jerry[23].type = "line";
		jerry[23].x1 = 460;
		jerry[23].y1 = 440;
		jerry[23].x2 = 470;
		jerry[23].y2 = 440;
		jerry[23].x = 0;
		jerry[23].y = 0;
		jerry[23].r = 0;
		jerry[24].type = "line";
		jerry[24].x1 = 490;
		jerry[24].y1 = 440;
		jerry[24].x2 = 500;
		jerry[24].y2 = 440;
		jerry[24].x = 0;
		jerry[24].y = 0;
		jerry[24].r = 0;
		jerry[25].type = "elipse";
		jerry[25].x1 = 480;
		jerry[25].y1 = 312;
		jerry[25].x2 = 480;
		jerry[25].y2 = 368;
		jerry[25].x = 480;
		jerry[25].y = 370;
		jerry[25].r = 0;
	}

	private void drawBasicShape(Graphics g) {
		setupBasicShape();
		g.setColor(blankColor);
		g.fillRect(0, 0, bImage.getWidth(), bImage.getHeight());
		g.setColor(boundaryColor);
		for (int i = 0; i < jerry.length; i++) {
			if (jerry[i].type.equalsIgnoreCase("elipse")) {
				double x1 = jerry[i].x1;
				double y1 = jerry[i].y1;
				double x2 = jerry[i].x2;
				double y2 = jerry[i].y2;
				double x = jerry[i].x;
				double y = jerry[i].y;
				double k = Math.sqrt(Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2))
						+ Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));
				double a = Math.pow(x1, 2) - (2 * x * x1) + Math.pow(y1, 2) - Math.pow(k, 2) - Math.pow(x2, 2)
						+ (2 * x * x2) - Math.pow(y2, 2);
				double A = (4 * Math.pow(y2, 2)) + (4 * Math.pow(y1, 2)) - (8 * y1 * y2) - (4 * Math.pow(k, 2));
				double B = (4 * a * y2) - (4 * a * y1) + (8 * Math.pow(k, 2) * y2);
				double C = Math.pow(a, 2) - (4 * Math.pow(k, 2) * Math.pow(x2, 2))
						- (4 * Math.pow(k, 2) * Math.pow(x, 2)) + (8 * Math.pow(k, 2) * x * x2)
						- (4 * Math.pow(k, 2) * Math.pow(y2, 2));
				Double Ya = (-B + Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
				Double Yb = (-B - Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
				if (Ya.equals(Yb)) {
					g.drawLine((int) x, (int) Math.round(Ya), (int) x, (int) Math.round(Ya));
					if (x < x1) {
						for (double xn = x + 1;; xn += 1) {
							a = Math.pow(x1, 2) - (2 * xn * x1) + Math.pow(y1, 2) - Math.pow(k, 2) - Math.pow(x2, 2)
									+ (2 * xn * x2) - Math.pow(y2, 2);
							A = (4 * Math.pow(y2, 2)) + (4 * Math.pow(y1, 2)) - (8 * y1 * y2) - (4 * Math.pow(k, 2));
							B = (4 * a * y2) - (4 * a * y1) + (8 * Math.pow(k, 2) * y2);
							C = Math.pow(a, 2) - (4 * Math.pow(k, 2) * Math.pow(x2, 2))
									- (4 * Math.pow(k, 2) * Math.pow(xn, 2)) + (8 * Math.pow(k, 2) * xn * x2)
									- (4 * Math.pow(k, 2) * Math.pow(y2, 2));
							Ya = (-B + Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
							if (Ya.isNaN()) {
								break;
							}
							Yb = (-B - Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
							g.drawLine((int) xn, (int) Math.round(Ya), (int) xn, (int) Math.round(Ya));
							g.drawLine((int) xn, (int) Math.round(Yb), (int) xn, (int) Math.round(Yb));
						}
					} else {
						for (double xn = x - 1;; xn -= 1) {
							a = Math.pow(x1, 2) - (2 * xn * x1) + Math.pow(y1, 2) - Math.pow(k, 2) - Math.pow(x2, 2)
									+ (2 * xn * x2) - Math.pow(y2, 2);
							A = (4 * Math.pow(y2, 2)) + (4 * Math.pow(y1, 2)) - (8 * y1 * y2) - (4 * Math.pow(k, 2));
							B = (4 * a * y2) - (4 * a * y1) + (8 * Math.pow(k, 2) * y2);
							C = Math.pow(a, 2) - (4 * Math.pow(k, 2) * Math.pow(x2, 2))
									- (4 * Math.pow(k, 2) * Math.pow(xn, 2)) + (8 * Math.pow(k, 2) * xn * x2)
									- (4 * Math.pow(k, 2) * Math.pow(y2, 2));
							Ya = (-B + Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
							if (Ya.isNaN()) {
								break;
							}
							Yb = (-B - Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
							g.drawLine((int) xn, (int) Math.round(Ya), (int) xn, (int) Math.round(Ya));
							g.drawLine((int) xn, (int) Math.round(Yb), (int) xn, (int) Math.round(Yb));
						}
					}
				} else {
					g.drawLine((int) x, (int) Math.round(Ya), (int) x, (int) Math.round(Ya));
					g.drawLine((int) x, (int) Math.round(Yb), (int) x, (int) Math.round(Yb));
					for (double xn = x - 1;; xn -= 1) {
						a = Math.pow(x1, 2) - (2 * xn * x1) + Math.pow(y1, 2) - Math.pow(k, 2) - Math.pow(x2, 2)
								+ (2 * xn * x2) - Math.pow(y2, 2);
						A = (4 * Math.pow(y2, 2)) + (4 * Math.pow(y1, 2)) - (8 * y1 * y2) - (4 * Math.pow(k, 2));
						B = (4 * a * y2) - (4 * a * y1) + (8 * Math.pow(k, 2) * y2);
						C = Math.pow(a, 2) - (4 * Math.pow(k, 2) * Math.pow(x2, 2))
								- (4 * Math.pow(k, 2) * Math.pow(xn, 2)) + (8 * Math.pow(k, 2) * xn * x2)
								- (4 * Math.pow(k, 2) * Math.pow(y2, 2));
						Ya = (-B + Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
						if (Ya.isNaN()) {
							break;
						}
						Yb = (-B - Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
						g.drawLine((int) xn, (int) Math.round(Ya), (int) xn, (int) Math.round(Ya));
						g.drawLine((int) xn, (int) Math.round(Yb), (int) xn, (int) Math.round(Yb));
					}
					for (double xn = x + 1;; xn += 1) {
						a = Math.pow(x1, 2) - (2 * xn * x1) + Math.pow(y1, 2) - Math.pow(k, 2) - Math.pow(x2, 2)
								+ (2 * xn * x2) - Math.pow(y2, 2);
						A = (4 * Math.pow(y2, 2)) + (4 * Math.pow(y1, 2)) - (8 * y1 * y2) - (4 * Math.pow(k, 2));
						B = (4 * a * y2) - (4 * a * y1) + (8 * Math.pow(k, 2) * y2);
						C = Math.pow(a, 2) - (4 * Math.pow(k, 2) * Math.pow(x2, 2))
								- (4 * Math.pow(k, 2) * Math.pow(xn, 2)) + (8 * Math.pow(k, 2) * xn * x2)
								- (4 * Math.pow(k, 2) * Math.pow(y2, 2));
						Ya = (-B + Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
						if (Ya.isNaN()) {
							break;
						}
						Yb = (-B - Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
						g.drawLine((int) xn, (int) Math.round(Ya), (int) xn, (int) Math.round(Ya));
						g.drawLine((int) xn, (int) Math.round(Yb), (int) xn, (int) Math.round(Yb));
					}
				}
				a = Math.pow(x1, 2) + Math.pow(y1, 2) - (2 * y * y1) - Math.pow(k, 2) - Math.pow(x2, 2)
						- Math.pow(y2, 2) + (2 * y * y2);
				A = (4 * Math.pow(x2, 2)) + (4 * Math.pow(x1, 2)) - (8 * x2 * x1) - (4 * Math.pow(k, 2));
				B = (4 * a * x2) - (4 * a * x1) + (8 * Math.pow(k, 2) * x2);
				C = Math.pow(a, 2) - (4 * Math.pow(k, 2) * Math.pow(x2, 2)) - (4 * Math.pow(k, 2) * Math.pow(y2, 2))
						- (4 * Math.pow(k, 2) * Math.pow(y, 2)) + (8 * Math.pow(k, 2) * y * y2);
				Double Xa = (-B + Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
				Double Xb = (-B - Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
				if (Xa.equals(Xb)) {
					g.drawLine((int) Math.round(Xa), (int) y, (int) Math.round(Xa), (int) y);
					if (y > y1) {
						for (double yn = y - 1;; yn -= 1) {
							a = Math.pow(x1, 2) + Math.pow(y1, 2) - (2 * yn * y1) - Math.pow(k, 2) - Math.pow(x2, 2)
									- Math.pow(y2, 2) + (2 * yn * y2);
							A = (4 * Math.pow(x2, 2)) + (4 * Math.pow(x1, 2)) - (8 * x2 * x1) - (4 * Math.pow(k, 2));
							B = (4 * a * x2) - (4 * a * x1) + (8 * Math.pow(k, 2) * x2);
							C = Math.pow(a, 2) - (4 * Math.pow(k, 2) * Math.pow(x2, 2))
									- (4 * Math.pow(k, 2) * Math.pow(y2, 2)) - (4 * Math.pow(k, 2) * Math.pow(yn, 2))
									+ (8 * Math.pow(k, 2) * yn * y2);
							Xa = (-B + Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
							if (Xa.isNaN()) {
								break;
							}
							Xb = (-B - Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
							g.drawLine((int) Math.round(Xa), (int) yn, (int) Math.round(Xa), (int) yn);
							g.drawLine((int) Math.round(Xb), (int) yn, (int) Math.round(Xb), (int) yn);
						}
					} else {
						for (double yn = y + 1;; yn += 1) {
							a = Math.pow(x1, 2) + Math.pow(y1, 2) - (2 * yn * y1) - Math.pow(k, 2) - Math.pow(x2, 2)
									- Math.pow(y2, 2) + (2 * yn * y2);
							A = (4 * Math.pow(x2, 2)) + (4 * Math.pow(x1, 2)) - (8 * x2 * x1) - (4 * Math.pow(k, 2));
							B = (4 * a * x2) - (4 * a * x1) + (8 * Math.pow(k, 2) * x2);
							C = Math.pow(a, 2) - (4 * Math.pow(k, 2) * Math.pow(x2, 2))
									- (4 * Math.pow(k, 2) * Math.pow(y2, 2)) - (4 * Math.pow(k, 2) * Math.pow(yn, 2))
									+ (8 * Math.pow(k, 2) * yn * y2);
							Xa = (-B + Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
							if (Xa.isNaN()) {
								break;
							}
							Xb = (-B - Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
							g.drawLine((int) Math.round(Xa), (int) yn, (int) Math.round(Xa), (int) yn);
							g.drawLine((int) Math.round(Xb), (int) yn, (int) Math.round(Xb), (int) yn);
						}
					}
				} else {
					g.drawLine((int) Math.round(Xa), (int) y, (int) Math.round(Xa), (int) y);
					g.drawLine((int) Math.round(Xb), (int) y, (int) Math.round(Xb), (int) y);
					for (double yn = y - 1;; yn -= 1) {
						a = Math.pow(x1, 2) + Math.pow(y1, 2) - (2 * yn * y1) - Math.pow(k, 2) - Math.pow(x2, 2)
								- Math.pow(y2, 2) + (2 * yn * y2);
						A = (4 * Math.pow(x2, 2)) + (4 * Math.pow(x1, 2)) - (8 * x2 * x1) - (4 * Math.pow(k, 2));
						B = (4 * a * x2) - (4 * a * x1) + (8 * Math.pow(k, 2) * x2);
						C = Math.pow(a, 2) - (4 * Math.pow(k, 2) * Math.pow(x2, 2))
								- (4 * Math.pow(k, 2) * Math.pow(y2, 2)) - (4 * Math.pow(k, 2) * Math.pow(yn, 2))
								+ (8 * Math.pow(k, 2) * yn * y2);
						Xa = (-B + Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
						if (Xa.isNaN()) {
							break;
						}
						Xb = (-B - Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
						g.drawLine((int) Math.round(Xa), (int) yn, (int) Math.round(Xa), (int) yn);
						g.drawLine((int) Math.round(Xb), (int) yn, (int) Math.round(Xb), (int) yn);
					}
					for (double yn = y + 1;; yn += 1) {
						a = Math.pow(x1, 2) + Math.pow(y1, 2) - (2 * yn * y1) - Math.pow(k, 2) - Math.pow(x2, 2)
								- Math.pow(y2, 2) + (2 * yn * y2);
						A = (4 * Math.pow(x2, 2)) + (4 * Math.pow(x1, 2)) - (8 * x2 * x1) - (4 * Math.pow(k, 2));
						B = (4 * a * x2) - (4 * a * x1) + (8 * Math.pow(k, 2) * x2);
						C = Math.pow(a, 2) - (4 * Math.pow(k, 2) * Math.pow(x2, 2))
								- (4 * Math.pow(k, 2) * Math.pow(y2, 2)) - (4 * Math.pow(k, 2) * Math.pow(yn, 2))
								+ (8 * Math.pow(k, 2) * yn * y2);
						Xa = (-B + Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
						if (Xa.isNaN()) {
							break;
						}
						Xb = (-B - Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
						g.drawLine((int) Math.round(Xa), (int) yn, (int) Math.round(Xa), (int) yn);
						g.drawLine((int) Math.round(Xb), (int) yn, (int) Math.round(Xb), (int) yn);
					}
				}
			} else if (jerry[i].type.equalsIgnoreCase("circle")) {
				double cx = jerry[i].x;
				double cy = jerry[i].y;
				double r = jerry[i].r;
				for (double x = cx - r; x <= cx + r; x += 1) {
					double z = Math.sqrt((Math.pow(r, 2)) - (Math.pow((cx - x), 2)));
					double y1 = cy + z;
					double y2 = cy - z;
					g.drawLine((int) Math.round(x), (int) Math.round(y1), (int) Math.round(x), (int) Math.round(y1));
					g.drawLine((int) Math.round(x), (int) Math.round(y2), (int) Math.round(x), (int) Math.round(y2));
				}
				for (double y = cy - r; y <= cy + r; y += 1) {
					double z = Math.sqrt((Math.pow(r, 2)) - (Math.pow((cy - y), 2)));
					double x1 = cx + z;
					double x2 = cx - z;
					g.drawLine((int) Math.round(x1), (int) Math.round(y), (int) Math.round(x1), (int) Math.round(y));
					g.drawLine((int) Math.round(x2), (int) Math.round(y), (int) Math.round(x2), (int) Math.round(y));
				}

			} else if (jerry[i].type.equalsIgnoreCase("line")) {
				g.drawLine((int) Math.round(jerry[i].x1), (int) Math.round(jerry[i].y1), (int) Math.round(jerry[i].x2),
						(int) Math.round(jerry[i].y2));
			}
		}
	}

	// public synchronized int getPixelRGB(Point pixelLocation) {
	// return bImage.getRGB(pixelLocation.x, pixelLocation.y);
	// }
	public synchronized boolean setPixelRGB(Point pixelLocation) {
		if (pixelLocation.x > -1 && pixelLocation.x < bImage.getWidth() && pixelLocation.y > -1
				&& pixelLocation.y < bImage.getHeight()
				&& bImage.getRGB(pixelLocation.x, pixelLocation.y) == blankColor.getRGB()) {
			bImage.setRGB(pixelLocation.x, pixelLocation.y, coloredColor.getRGB());
			return true;
		}
		return false;
	}

	public synchronized boolean clearPixelRGB(Point pixelLocation) {
		if (bImage.getRGB(pixelLocation.x, pixelLocation.y) == coloredColor.getRGB()) {
			bImage.setRGB(pixelLocation.x, pixelLocation.y, blankColor.getRGB());
			return true;
		}
		return false;
	}

	synchronized StartingFillInfo initFill(Point pixelLocation) {
		StartingFillInfo sfi = new StartingFillInfo();
		sfi.coordinates = new ArrayList<>();
		if (bImage.getRGB(pixelLocation.x, pixelLocation.y) == blankColor.getRGB()) {
			// bImage.setRGB(pixelLocation.x, pixelLocation.y, coloredColor.getRGB());
			// repaint(pixelLocation.x, pixelLocation.y,1,1)
			sfi.isBlank = true;
			int x = pixelLocation.x;
			int y = pixelLocation.y;
			while (true) {
				if (x > 0 && y > 0
						&& (bImage.getRGB(x - 1, y) == blankColor.getRGB()
								|| bImage.getRGB(x, y - 1) == blankColor.getRGB())
						&& bImage.getRGB(x - 1, y - 1) == blankColor.getRGB()) {
					// bImage.setRGB(--x, --y, coloredColor.getRGB());
					--x;
					--y;
				} else {
					break;
				}
			}
			sfi.coordinates.add(new Point(x, y));
			x = pixelLocation.x;
			y = pixelLocation.y;
			while (true) {
				if (x > 0 && y < bImage.getHeight() - 1
						&& (bImage.getRGB(x - 1, y) == blankColor.getRGB()
								|| bImage.getRGB(x, y + 1) == blankColor.getRGB())
						&& bImage.getRGB(x - 1, y + 1) == blankColor.getRGB()) {
					// bImage.setRGB(--x, ++y, coloredColor.getRGB());
					--x;
					++y;
				} else {
					break;
				}
			}
			sfi.coordinates.add(new Point(x, y));
			x = pixelLocation.x;
			y = pixelLocation.y;
			while (true) {
				if (x < bImage.getWidth() - 1 && y > 0
						&& (bImage.getRGB(x + 1, y) == blankColor.getRGB()
								|| bImage.getRGB(x, y - 1) == blankColor.getRGB())
						&& bImage.getRGB(x + 1, y - 1) == blankColor.getRGB()) {
					// bImage.setRGB(++x, --y, coloredColor.getRGB());
					++x;
					--y;
				} else {
					break;
				}
			}
			sfi.coordinates.add(new Point(x, y));
			x = pixelLocation.x;
			y = pixelLocation.y;
			while (true) {
				if (x < bImage.getWidth() - 1 && y < bImage.getHeight() - 1
						&& (bImage.getRGB(x + 1, y) == blankColor.getRGB()
								|| bImage.getRGB(x, y + 1) == blankColor.getRGB())
						&& bImage.getRGB(x + 1, y + 1) == blankColor.getRGB()) {
					// bImage.setRGB(++x, ++y, coloredColor.getRGB());
					++x;
					++y;
				} else {
					break;
				}
			}
			sfi.coordinates.add(new Point(x, y));
			x = pixelLocation.x;
			y = pixelLocation.y;
			while (true) {
				if (x > 0 && bImage.getRGB(x - 1, y) == blankColor.getRGB()) {
					// bImage.setRGB(--x, y, coloredColor.getRGB());
					--x;
				} else {
					break;
				}
			}
			sfi.coordinates.add(new Point(x, y));
			x = pixelLocation.x;
			y = pixelLocation.y;
			while (true) {
				if (y > 0 && bImage.getRGB(x, y - 1) == blankColor.getRGB()) {
					// bImage.setRGB(x, --y, coloredColor.getRGB());
					--y;
				} else {
					break;
				}
			}
			sfi.coordinates.add(new Point(x, y));
			x = pixelLocation.x;
			y = pixelLocation.y;
			while (true) {
				if (x < bImage.getWidth() - 1 && bImage.getRGB(x + 1, y) == blankColor.getRGB()) {
					// bImage.setRGB(++x, y, coloredColor.getRGB());
					++x;
				} else {
					break;
				}
			}
			sfi.coordinates.add(new Point(x, y));
			x = pixelLocation.x;
			y = pixelLocation.y;
			while (true) {
				if (y < bImage.getHeight() - 1 && bImage.getRGB(x, y + 1) == blankColor.getRGB()) {
					// bImage.setRGB(x, ++y, coloredColor.getRGB());
					++y;
				} else {
					break;
				}
			}
			sfi.coordinates.add(new Point(x, y));
		}
		return sfi;
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bImage, 0, 0, null);
	}
}

class StartingFillInfo {

	ArrayList<Point> coordinates = null;
	boolean isBlank;
}

class FillColorThread implements Runnable {

	DrawingBoard2 board = null;
	Point clickedAt = null;
	static int sleepTime; // use 50 or 25 or 17 or 16 or 0
	int colorFillingThreads;
	int threadsDone = 0;
	StartingFillInfo sfi = null;

	FillColorThread(DrawingBoard2 board, Point clickedAt) {
		this.board = board;
		this.clickedAt = clickedAt;
		sleepTime = 1;
	}

	@Override
	public void run() {
		sfi = board.initFill(clickedAt);
		if (sfi.isBlank == true) {
			// board.repaint();
			// board.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			for (Point pt : sfi.coordinates) {
				new Thread(new TraverseAndFillThread(this, pt, true)).start();
				// System.out.println("new thread");
			}
		}
	}

	public void tryRepaint() {
		threadsDone++;
		if (threadsDone == sfi.coordinates.size()) {
			// System.out.println(threadsDone + " " + sfi.coordinates.size() + " repaint
			// called");
			// threadSleep();
			board.repaint();
			// board.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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

class TraverseAndFillThread implements Runnable {

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
		// throw new UnsupportedOperationException("Not supported yet."); //To change
		// body of generated methods, choose Tools | Templates.
		traverseUpAndFill(pixelLocation, 0);
		fct.board.setPixelRGB(pixelLocation);
		if (stopMatters) {
			fct.tryRepaint();
		}
	}

	// private void traverseAndFill(Point pixelLocation, int iterations) {
	// // System.out.println(iterations++);
	// iterations++;
	// if (fct.board.setPixelRGB(new Point(pixelLocation.x, pixelLocation.y - 1)) ==
	// true) {
	// fct.board.repaint(pixelLocation.x, pixelLocation.y - 1, 1, 1);
	// threadSleep();
	// if (iterations < 2000) {
	// traverseAndFill(new Point(pixelLocation.x, pixelLocation.y - 1), iterations);
	// } else {
	// Thread thrd = null;
	// TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation,
	// false);
	// thrd = new Thread(taft);
	// thrd.start();
	// try {
	// thrd.join();
	// } catch (InterruptedException ex) {
	// System.out.println("Error " + ex.getMessage());
	// }
	//
	// }
	// }
	// if (fct.board.setPixelRGB(new Point(pixelLocation.x, pixelLocation.y + 1)) ==
	// true) {
	// fct.board.repaint(pixelLocation.x, pixelLocation.y + 1, 1, 1);
	// threadSleep();
	// if (iterations < 2000) {
	// traverseAndFill(new Point(pixelLocation.x, pixelLocation.y + 1), iterations);
	// } else {
	// Thread thrd = null;
	// TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation,
	// false);
	// thrd = new Thread(taft);
	// thrd.start();
	// try {
	// thrd.join();
	// } catch (InterruptedException ex) {
	// System.out.println("Error " + ex.getMessage());
	// }
	//
	// }
	// }
	// if (fct.board.setPixelRGB(new Point(pixelLocation.x - 1, pixelLocation.y)) ==
	// true) {
	// fct.board.repaint(pixelLocation.x - 1, pixelLocation.y, 1, 1);
	// threadSleep();
	// if (iterations < 2000) {
	// traverseAndFill(new Point(pixelLocation.x - 1, pixelLocation.y), iterations);
	// } else {
	// Thread thrd = null;
	// TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation,
	// false);
	// thrd = new Thread(taft);
	// thrd.start();
	// try {
	// thrd.join();
	// } catch (InterruptedException ex) {
	// System.out.println("Error " + ex.getMessage());
	// }
	//
	// }
	// }
	// if (fct.board.setPixelRGB(new Point(pixelLocation.x + 1, pixelLocation.y)) ==
	// true) {
	// fct.board.repaint(pixelLocation.x + 1, pixelLocation.y, 1, 1);
	// threadSleep();
	// if (iterations < 2000) {
	// traverseAndFill(new Point(pixelLocation.x + 1, pixelLocation.y), iterations);
	// } else {
	// Thread thrd = null;
	// TraverseAndFillThread taft = new TraverseAndFillThread(fct, pixelLocation,
	// false);
	// thrd = new Thread(taft);
	// thrd.start();
	// try {
	// thrd.join();
	// } catch (InterruptedException ex) {
	// System.out.println("Error " + ex.getMessage());
	// }
	//
	// }
	// }
	// }
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
			Thread.sleep(1);
		} catch (InterruptedException ex) {
			System.out.println("Sleep Error : " + ex.getMessage());
		}
	}
}
