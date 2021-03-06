package Test2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TSWin {

	private double[][] p1;
	private double[][] p2;
	private double[] x;
	private int MAXLIMITW = 800;
	private int MAXLIMITH = 800;
	private int ZEROX = 300;
	private int ZEROY = 300;
	private JFrame f = new JFrame("GC");
	private JFrame ff = new JFrame("GC2");
	private MyCanvas drawArea = new MyCanvas();
	private MyCanvas2 drawArea2 = new MyCanvas2();
	public TSWin(double[][] pp1, double[][] pp2, double[] xx){
		this.p1 = pp1;
		this.p2 = pp2;
		this.x= xx;
	}
	public void init() {
		drawArea.setPreferredSize(new Dimension(MAXLIMITW, MAXLIMITH));
		drawArea.repaint();
		drawArea2.setPreferredSize(new Dimension(MAXLIMITW, MAXLIMITH));
		drawArea2.repaint();
		f.add(drawArea);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		ff.add(drawArea2);
		ff.pack();
		ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ff.setVisible(true);
	}
	class MyCanvas extends JPanel {
		public void paint(Graphics g) {
			System.out.println(Arrays.toString(p1[0]));
			g.setColor(Color.BLACK);
			int y1 = 0;
			int y2 = 0;
			int x1 = 0;
			int x2 = 0;
			int count = 0;
			g.drawLine(50, 50, 50, 800);
			g.drawLine(0,650,750,650);
			g.setColor(Color.RED);
			for(double i = x[0]; i < x[1]; i = i + 0.01){
				y1 =(int) ((p1[0][0]*i*i*i + p1[0][1]*i*i+p1[0][2]*i+p1[0][3])*1000);
				y2 =(int) ((p1[0][0]*(i+0.01)*(i+0.01)*(i+0.01) + p1[0][1]*(i+0.01)*(i+0.01)+p1[0][2]*(i+0.01)+p1[0][3])*1000);
				x1 =  (int) ((i)*1000);
				x2 =  (int) ((i+0.01)*1000);
				y1 = MAXLIMITH-y1;
				y2 = MAXLIMITH-y2;
				System.out.println(x1+" "+y1+" "+x2+" "+y2);
				g.drawLine(x1, y1, x2, y2);
			}
			for(double i = x[1]; i < x[2]; i = i + 0.01){
				y1 =(int) ((p1[1][0]*i*i*i + p1[1][1]*i*i+p1[1][2]*i+p1[1][3])*1000);
				y2 =(int) ((p1[1][0]*(i+0.01)*(i+0.01)*(i+0.01) + p1[1][1]*(i+0.01)*(i+0.01)+p1[1][2]*(i+0.01)+p1[1][3])*1000);
				x1 =  (int) ((i)*1000);
				x2 =  (int) ((i+0.01)*1000);
				y1 = MAXLIMITH-y1;
				y2 = MAXLIMITH-y2;
				System.out.println(x1+" "+y1+" "+x2+" "+y2);
				g.drawLine(x1, y1, x2, y2);
			}
			for(double i = x[2]; i < x[3]; i = i + 0.01){
				y1 =(int) ((p1[2][0]*i*i*i + p1[2][1]*i*i+p1[2][2]*i+p1[2][3])*1000);
				y2 =(int) ((p1[2][0]*(i+0.01)*(i+0.01)*(i+0.01) + p1[2][1]*(i+0.01)*(i+0.01)+p1[2][2]*(i+0.01)+p1[2][3])*1000);
				x1 =  (int) ((i)*1000);
				x2 =  (int) ((i+0.01)*1000);
				y1 = MAXLIMITH-y1;
				y2 = MAXLIMITH-y2;
				System.out.println(x1+" "+y1+" "+x2+" "+y2);
				g.drawLine(x1, y1, x2, y2);
			}
			for(double i = x[3]; i < x[4]; i = i + 0.01){
				y1 =(int) ((p1[3][0]*i*i*i + p1[3][1]*i*i+p1[3][2]*i+p1[3][3])*1000);
				y2 =(int) ((p1[3][0]*(i+0.01)*(i+0.01)*(i+0.01) + p1[3][1]*(i+0.01)*(i+0.01)+p1[3][2]*(i+0.01)+p1[3][3])*1000);
				x1 =  (int) ((i)*1000);
				x2 =  (int) ((i+0.01)*1000);
				y1 = MAXLIMITH-y1;
				y2 = MAXLIMITH-y2;
				System.out.println(x1+" "+y1+" "+x2+" "+y2);
				g.drawLine(x1, y1, x2, y2);
			}
//			for(double i = x[0]; i < x[1]; i = i + 0.01){
//				y1 =(int) ((p2[0][0]*i*i*i + p2[0][1]*i*i+p2[0][2]*i+p2[0][3])*1000);
//				y2 =(int) ((p2[0][0]*(i+0.01)*(i+0.01)*(i+0.01) + p2[0][1]*(i+0.01)*(i+0.01)+p2[0][2]*(i+0.01)+p2[0][3])*1000);
//				x1 =  (int) ((i)*1000);
//				count++;
//				x2 =  (int) ((i+0.01)*1000);
//				y1 = MAXLIMITH-y1;
//				y2 = MAXLIMITH-y2;
//				System.out.println(x1+" "+y1+" "+x2+" "+y2);
//				g.drawLine(x1, y1, x2, y2);
//			}
		}
	}
	class MyCanvas2 extends JPanel {
		public void paint(Graphics g) {
			System.out.println(Arrays.toString(p1[0]));
			g.setColor(Color.BLACK);
			int y1 = 0;
			int y2 = 0;
			int x1 = 0;
			int x2 = 0;
			int count = 0;
			g.drawLine(50, 50, 50, 800);
			g.drawLine(0,650,750,650);
			g.setColor(Color.RED);
			for(double i = x[0]; i < x[1]; i = i + 0.01){
				y1 =(int) ((p2[0][0]*i*i*i + p2[0][1]*i*i+p2[0][2]*i+p2[0][3])*1000);
				y2 =(int) ((p2[0][0]*(i+0.01)*(i+0.01)*(i+0.01) + p2[0][1]*(i+0.01)*(i+0.01)+p2[0][2]*(i+0.01)+p2[0][3])*1000);
				x1 =  (int) ((i)*1000);
				count++;
				x2 =  (int) ((i+0.01)*1000);
				y1 = MAXLIMITH-y1;
				y2 = MAXLIMITH-y2;
				System.out.println(x1+" "+y1+" "+x2+" "+y2);
				g.drawLine(x1, y1, x2, y2);
			}
			for(double i = x[1]; i < x[2];    i = i + 0.01){
				y1 =(int) ((p2[1][0]*i*i*i + p2[1][1]*i*i+p2[1][2]*i+p2[1][3])*1000);
				y2 =(int) ((p2[1][0]*(i+0.01)*(i+0.01)*(i+0.01) + p2[1][1]*(i+0.01)*(i+0.01)+p2[1][2]*(i+0.01)+p2[1][3])*1000);
				x1 =  (int) ((i)*1000);
				count++;
				x2 =  (int) ((i+0.01)*1000);
				y1 = MAXLIMITH-y1;
				y2 = MAXLIMITH-y2;
				System.out.println(x1+" "+y1+" "+x2+" "+y2);
				g.drawLine(x1, y1, x2, y2);
			}
			for(double i = x[2]; i < x[3]; i = i + 0.01){
				y1 =(int) ((p2[2][0]*i*i*i + p2[2][1]*i*i+p2[2][2]*i+p2[2][3])*1000);
				y2 =(int) ((p2[2][0]*(i+0.01)*(i+0.01)*(i+0.01) + p2[2][1]*(i+0.01)*(i+0.01)+p2[2][2]*(i+0.01)+p2[2][3])*1000);
				x1 =  (int) ((i)*1000);
				count++;
				x2 =  (int) ((i+0.01)*1000);
				y1 = MAXLIMITH-y1;
				y2 = MAXLIMITH-y2;
				System.out.println(x1+" "+y1+" "+x2+" "+y2);
				g.drawLine(x1, y1, x2, y2);
			}
			for(double i = x[3]; i < x[4]; i = i + 0.01){
				y1 =(int) ((p2[3][0]*i*i*i + p2[3][1]*i*i+p2[3][2]*i+p2[3][3])*1000);
				y2 =(int) ((p2[3][0]*(i+0.01)*(i+0.01)*(i+0.01) + p2[3][1]*(i+0.01)*(i+0.01)+p2[3][2]*(i+0.01)+p2[3][3])*1000);
				x1 =  (int) ((i)*1000);
				count++;
				x2 =  (int) ((i+0.01)*1000);
				y1 = MAXLIMITH-y1;
				y2 = MAXLIMITH-y2;
				System.out.println(x1+" "+y1+" "+x2+" "+y2);
				g.drawLine(x1, y1, x2, y2);
			}
//			for(double i = x[0]; i < x[1]; i = i + 0.01){
//				y1 =(int) ((p2[0][0]*i*i*i + p2[0][1]*i*i+p2[0][2]*i+p2[0][3])*1000);
//				y2 =(int) ((p2[0][0]*(i+0.01)*(i+0.01)*(i+0.01) + p2[0][1]*(i+0.01)*(i+0.01)+p2[0][2]*(i+0.01)+p2[0][3])*1000);
//				x1 =  (int) ((i)*1000);
//				count++;
//				x2 =  (int) ((i+0.01)*1000);
//				y1 = MAXLIMITH-y1;
//				y2 = MAXLIMITH-y2;
//				System.out.println(x1+" "+y1+" "+x2+" "+y2);
//				g.drawLine(x1, y1, x2, y2);
//			}
		}
	}
}
