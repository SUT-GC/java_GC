import java.util.HashMap;
import java.util.Scanner;

public class Main {
	private static HashMap hash = new HashMap();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String key;
		String val;
		while(sc.hasNext()){
			key = sc.next();
			if(key.charAt(0) != '\0'){
				System.out.println(key);
			}else{
				System.out.println(1);
			}
		}
	}
}
