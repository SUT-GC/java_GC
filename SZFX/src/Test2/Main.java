package Test2;

import java.util.Arrays;

public class Main {
	public static void main(String[] args){
		double[] x = new double[]{0.25, 0.30, 0.39, 0.45, 0.53};
		double[] y = new double[]{0.5000, 0.5477, 0.6245, 0.6708, 0.7280};
		double[][] p1;
		double[][] p2;
		System.out.println("--------------------------------------------------------");
		ThreeSpline ts = new ThreeSpline(x, y, 5);
		ts.Calculate1(1.0000, 0.6868);
		ts.Calculate2();
		p1 = ts.getP1();
		p2 = ts.getP2();
		TSWin tsw = new TSWin(p1, p2, x);
		tsw.init();
		System.out.println("--------------------------------------------------------");
		
	}
}
