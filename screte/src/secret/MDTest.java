package secret;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MDTest {
	public static String src = "i am gc MD";
	public static void main(String[] args) {
		System.out.println("=====jdk提供的MD5=====");
		jdkMD5();
		System.out.println("=====================");
	}
	public static void jdkMD5(){
		try {
			//jdk提供的MessageDegest类 创建对象时候需要传入参数,可以是MD5, MD2
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] result = md.digest(src.getBytes());
			//因为digest方法返回的使一个byte数组,如果想输出字符串,必须将byte数组转化成16进制等,但是jdk并没有提供这样的方法,所以你可以选择自己写或者使用bc或cc提供的方法
			System.out.println("信息摘要之后的src: "+new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
