package curriculumdesign.cd3;

import java.util.Vector;

public class test {

	public static void main(String[] args) {
		Vector <Integer> v = new Vector<>();
		v.add(2);
		v.add(3);
		v.add(4);
		v.remove(0);
		System.out.println(v.get(0));
	}

}
