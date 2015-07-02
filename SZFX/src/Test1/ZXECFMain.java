package Test1;

public class ZXECFMain {
	public static void main(String[] args) {
		double[] ax = new double[] { 2, 4, 4, 4.6, 5, 5.2, 5.6, 6, 6.6, 7 };
		double[] ay = new double[] { 5, 3.5, 3, 2.7, 2.4, 2.5, 2, 1.5, 1.2, 1.2 };
		// double[] ax = new double[]{100,100,100,100,100,100,100};
		// double[] ay = new double[]{1,2,3,4,5,6,7};
		ZXECF t = new ZXECF(ax, ay);
		t.toAandB();
		// System.out.println(t.getA() + "   " + t.getB());
		t.init();
	}
}
