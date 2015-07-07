package Test2;

import java.util.Arrays;

public class Main {
	public static void main(String[] args){
		double[][] A = new double[][]{
				{2,1,0,0},
				{1,3,1,0},
				{0,1,1,1},
				{0,0,2,1}
		};
		double[] d = new double[]{1,2,2,0};
		double[] x = new double[]{0.25, 0.30, 0.39, 0.45, 0.53};
		double[] y = new double[]{0.5000, 0.5477, 0.6245, 0.6708, 0.7280};
		ChaseMethod cm1 = new ChaseMethod(A, d, 4);
		cm1.showAll();
		System.out.println(Arrays.toString(cm1.getX()));
		System.out.println("--------------------------------------------------------");
		ThreeSpline ts1 = new ThreeSpline(x, y);
		System.out.println("--------------------------------------------------------");
		
	}
}
