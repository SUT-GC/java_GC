package Test2;

import java.util.Arrays;

public class ChaseMethod {
	private double[][] A;
	private double[] x;
	private double[] d;
	private double[] y;
	private double[] u;
	private double[] c;
	private double[] l;
	private double[] b;
	private double[] a;
	public ChaseMethod(double[][] AA, double[] dd, int numofx){
		this.A = AA;
		this.d = dd;
		x = new double[numofx];
		y = new double[d.length];
		c = new double[d.length];
		l = new double[d.length];
		u = new double[d.length];
		b = new double[d.length];
		a = new double[d.length];
		for(int i = 0; i < b.length; i++){
			b[i] = A[i][i];
		}
		for(int i = 1; i < a.length; i++){
			a[i] = A[i][i-1];
		}
		for(int i = 0; i < c.length-1; i++){
			c[i] = A[i][i+1];
		}
		
		u[0] = b[0];
		y[0] = d[0];
		
		for(int i = 1; i < numofx; i++){
			l[i] = (a[i] / u[i-1]);
			u[i] = b[i] - l[i]*c[i-1];
			y[i] = d[i] - l[i]*y[i-1];
		}
		
		x[x.length-1] = y[x.length-1]/u[x.length-1];
		for(int i = x.length-2; i >= 0; i--){
			x[i] = (y[i] - c[i]*x[i+1])/u[i];
		}
	}
	public void showAll(){
		System.out.println("======================showAll Begin======================");
		System.out.println("--------------------a-----b-----c--------------------");
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
		System.out.println("--------------------l-----u-----y--------------------");
		System.out.println(Arrays.toString(l));
		System.out.println(Arrays.toString(u));
		System.out.println(Arrays.toString(y));
		System.out.println("======================showAll End======================");
	}
	public double[] getX(){
		return x;
	}
}
