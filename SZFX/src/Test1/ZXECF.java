package Test1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ZXECF {
	private double[] ax;
	private double[] ay;
	private double b;
	private double a;
	private int MAXLIMITW = 600;
	private int MAXLIMITH = 600;
	private int ZEROX = 300;
	private int ZEROY = 300;
	private JFrame f = new JFrame("GC");
	private MyCanvas drawArea = new MyCanvas();

	public ZXECF(double[] ax, double[] ay) {
		this.ax = ax;
		this.ay = ay;
	}

	public void toAandB() {
		double xb = 0;
		double yb = 0;
		double lxx = 0;
		double lxy = 0;
		for (int i = 0; i < ax.length; i++) {
			xb += ax[i];
		}
		xb = xb / ax.length;
		for (int i = 0; i < ay.length; i++) {
			yb += ay[i];
		}
		yb = yb / ay.length;
		for (int i = 0; i < ax.length; i++) {
			lxx += ax[i] * ay[i];
		}
		lxx = lxx - ax.length * xb * yb;
		for (int i = 0; i < ay.length; i++) {
			lxy += ax[i] * ax[i];
		}
		lxy = lxy - ax.length * xb * xb;
		a = lxx / lxy;
		b = yb - a * xb;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public void init() {
		drawArea.setPreferredSize(new Dimension(MAXLIMITW, MAXLIMITH));
		drawArea.repaint();
		f.add(drawArea);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	class MyCanvas extends JPanel {
		public void paint(Graphics g) {
			g.setColor(Color.BLACK);
			// 画作标轴
			g.drawLine(0, ZEROY, 600, ZEROY);// X轴
			g.drawLine(ZEROX, 0, ZEROX, 600);// Y轴
			// 画出每条锯齿线
			// 画Y轴的
			for (int i = 0; i < 600; i += 10) {
				g.drawLine(298, i, 302, i);
			}
			// 画X轴的
			for (int i = 0; i < 600; i += 10) {
				g.drawLine(i, 298, i, 302);
			}
			// 表明坐标轴的坐标
			for (int i = 300; i <= 600; i++) {
				if (i % 100 == 0) {
					g.drawString("-" + (i - 300) + "", 303, i);
				}
			}
			for (int i = 300; i > 0; i--) {
				if (i % 100 == 0) {
					g.drawString(i + "", 303, 300 - i);
				}
			}
			for (int i = 299; i >= 0; i--) {
				if (i % 100 == 0) {
					g.drawString("-" + (300 - i) + "", i - 5, 295);
				}
			}
			for (int i = 301; i <= 600; i++) {
				if (i % 100 == 0) {
					g.drawString(i - 300 + "", i - 20, 295);
				}
			}
			g.setFont(new Font(null, Font.BOLD, 15));
			g.setColor(Color.BLACK);
			g.drawString("作者 : GC", 450, 500);
			// 写出相关的变量的值
			g.setFont(new Font(null, Font.BOLD, 20));
			g.drawString("最小二乘法拟合曲线程序", 180, 30);
			g.setFont(new Font(null, Font.PLAIN, 12));
			g.drawString("X坐标集合 : " + Arrays.toString(ax), 50, 60);
			g.drawString("Y坐标集合 : " + Arrays.toString(ay), 50, 80);
			g.drawString("斜率 k = " + a, 50, 100);
			g.drawString("截距 b = " + b, 50, 120);
			g.drawString("函数方程为:  " + " Y = " + a + " X + " + b, 50, 140);
			// 用递推法画出线段
			g.setColor(Color.RED);
			for (int i = -300; i < 300; i += 10) {
				int x1 = i + ZEROX;
				// System.out.println(((int) (a*i + b)+ZEROY) +" "+(i+ZEROX)) ;
				int y1 = MAXLIMITH - ((int) (a * i + b) + ZEROY);
				int x2 = i + 10 + ZEROX;
				int y2 = MAXLIMITH - ((int) (a * (i + 10) + b) + ZEROY);
				g.drawLine(x1, y1, x2, y2);
			}
		}
	}
}
