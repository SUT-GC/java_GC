enum Season{
	RED,GREEN;
	
}

class FinalTest{
	public static final int a = 2;
	private int in;
	public void set(int i){
		this.in = i;
	}
	public int  get(){
		return in;
	}
}

public class EnumTest {
	public static void main(String[] args) {
		Season s = Season.RED;
		FinalTest tf = new FinalTest();
		tf.set(3);
		FinalTest tf2 = tf;
		tf2.set(4);
		FinalTest tf3 = new FinalTest();
		System.out.println(tf.get());
		System.out.println(tf3.get());
	}
}
