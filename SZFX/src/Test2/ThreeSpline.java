package Test2;

import java.util.Arrays;

public class ThreeSpline {
	private double[] x;
	private double[] y;
	private double[] h;
	private double[] u;
	private double[] r;
	private double[][] A;
	private double[] b;
	private double[][] dvtable;
	public ThreeSpline(double[] xx, double[] yy){
		this.x = xx;
		this.y = yy;
		h = new double[x.length-1];
		u = new double[h.length];
		r = new double[h.length];
		A = new double[x.length][x.length];
		b = new double[x.length];
		dvtable = new double[x.length+2][3];
		for(int i = 0; i < h.length; i++){
			h[i] = x[i+1] - x[i];
		}
		for(int i = 1; i < u.length; i++){
			u[i-1] = h[i-1]/(h[i-1]+h[i]);
			r[i] = h[i]/(h[i-1]+h[i]);
		}
		u[u.length-1] = 1;
		r[0] = 1;
		for(int i = 0; i < x.length; i++ ){
			A[i][i] = 2;
		}
		for(int i = 0; i < x.length-1; i++){
			A[i][i+1] = r[i];
			A[i+1][i] = u[i];
		}
		dvtable[0][0] = y[0];
		dvtable[0][y.length] = y[y.length-1];
		
		for(int i = 0; i < y.length; i++){
			dvtable[0][i+1] = y[i];
		}
		for(int i = 1; i <= 2; i++){
			for(int j = i+1; j < y.length+2; j++){
				
			}
		}
		System.out.println(Arrays.toString(u)+" ----- "+Arrays.toString(r));
		System.out.println("------------------------------------------------------------------");
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < A[0].length; j++){
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}
}	
