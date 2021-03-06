package Test2;

import java.util.Arrays;

public class ThreeSpline {
	private double[] x;
	private double[] y;
	private double[] m;
	private double[] d;
	private double[] u;
	private double[] w;
	private double[] l;
	private double[] z;
	private double[] r;
	private double[] h;
	private double[][] p1;
	private double[][] p2;
	private int n;;

	public ThreeSpline(double[] xx, double[] yy, int nn){
		h=new double[100];
		x=xx;
		y=yy;
		n = nn;
		m=new double[100];
		d=new double[100];
		u=new double[100];
		r=new double[100];
		w=new double[100];
		z=new double[100];
		l=new double[100];
		p1 = new double[4][4];
		p2 = new double[4][4];
	}
	
	public void Calculate1(double s0,double sn)
	{
		int i;
		for(i=0;i<n-1;i++)
			h[i]=x[i+1]-x[i];
		for(i=1;i<n-1;i++)
			u[i]=h[i-1]/(h[i-1]+h[i]);
		u[n-1]=1;
		for(i=1;i<n-1;i++)
			r[i]=h[i]/(h[i-1]+h[i]);
		r[0]=1;
		d[0]=(6*((y[0]-y[1])/(x[0]-x[1])-s0))/h[0];
		d[n-1]=(6*(sn-(y[n-2]-y[n-1])/(x[n-2]-x[n-1])))/h[n-2];
		for(i=1;i<n-1;i++){
			d[i]=(6*((y[i]-y[i+1])/(x[i]-x[i+1])-(y[i-1]-y[i])/(x[i-1]-x[i])))/(h[i-1]+h[i]);
		}
	
		w[0]=2;z[0]=d[0];
		for(i=1;i<n;i++){
			l[i]=u[i]/w[i-1];
			w[i]=2-l[i]*r[i-1];
			z[i]=d[i]-l[i]*z[i-1];
		}
		m[n-1]=z[n-1]/w[n-1];
		for(i=n-2;i>=0;i--){
			m[i]=(z[i]-r[i]*m[i+1])/w[i];
		}
		for(i=0;i<n-1;i++){
			p1[i][0]=m[i+1]/(6*h[i])-m[i]/(6*h[i]);
			p1[i][1]=m[i]*x[i+1]*3/(6*h[i])-m[i+1]*3*x[i]/(6*h[i]);
			p1[i][2]=m[i+1]*3*x[i]*x[i]/(6*h[i])-m[i]*(3*x[i+1]*x[i+1])/(6*h[i])-(y[i]-m[i]*h[i]*h[i]/6)/h[i]+(y[i+1]-m[i+1]*h[i]*h[i]/6)/h[i];
			p1[i][3]=m[i]*x[i+1]*x[i+1]*x[i+1]/(6*h[i])-m[i+1]*x[i]*x[i]*x[i]/(6*h[i])+(y[i]-m[i]*h[i]*h[i]/6)*x[i+1]/h[i]-(y[i+1]-m[i+1]*h[i]*h[i]/6)*x[i]/h[i];
			System.out.println(Arrays.toString(p1[i]));
		}
	}
	public void Calculate2()
	{
		int i;
		for(i=0;i<n-1;i++)
			h[i]=x[i+1]-x[i];
		for(i=1;i<n-1;i++)
			u[i]=h[i-1]/(h[i-1]+h[i]);
		u[n-1]=0;
		for(i=1;i<n-1;i++)
			r[i]=h[i]/(h[i-1]+h[i]);
		r[0]=0;
		d[0]=0;
		d[n-1]=0;
		for(i=1;i<n-1;i++){
			d[i]=(6*((y[i]-y[i+1])/(x[i]-x[i+1])-(y[i-1]-y[i])/(x[i-1]-x[i])))/(h[i-1]+h[i]);
		}
		w[0]=2;z[0]=d[0];
		for(i=1;i<n;i++){
			l[i]=u[i]/w[i-1];
			w[i]=2-l[i]*r[i-1];
			z[i]=d[i]-l[i]*z[i-1];
		}
		m[n-1]=0;
		m[0]=0;
		for(i=n-2;i>0;i--){
			m[i]=(z[i]-r[i]*m[i+1])/w[i];
		}
		for(i=0;i<n-1;i++){
			p2[i][0]=m[i+1]/(6*h[i])-m[i]/(6*h[i]);
			p2[i][1]=m[i]*x[i+1]*3/(6*h[i])-m[i+1]*3*x[i]/(6*h[i]);
			p2[i][2]=m[i+1]*3*x[i]*x[i]/(6*h[i])-m[i]*(3*x[i+1]*x[i+1])/(6*h[i])-(y[i]-m[i]*h[i]*h[i]/6)/h[i]+(y[i+1]-m[i+1]*h[i]*h[i]/6)/h[i];
			p2[i][3]=m[i]*x[i+1]*x[i+1]*x[i+1]/(6*h[i])-m[i+1]*x[i]*x[i]*x[i]/(6*h[i])+(y[i]-m[i]*h[i]*h[i]/6)*x[i+1]/h[i]-(y[i+1]-m[i+1]*h[i]*h[i]/6)*x[i]/h[i];
			System.out.println(Arrays.toString(p2[i]));
		}
	}
	public double[][] getP1(){
		return p1;
	}
	public double[][] getP2(){
		return p2;
	}
}	
