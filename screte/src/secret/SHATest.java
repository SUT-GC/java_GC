package secret;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;

public class SHATest {
	public static String src = "i am gc SHA";

	public static void main(String[] args) {
		System.out.println("=====jdk提供的SHA1=====");
		jdkSHA1();
		System.out.println("=====================");
		System.out.println("=====bc提供的SHA1=====");
		bcSHA1();
		System.out.println("=====================");
		System.out.println("=====cc提供的SHA1=====");
		ccSHA1();
		System.out.println("=====================");
		System.out.println("=====bc提供的SHA-256=====");
		jdkSHA256();
		System.out.println("=====================");
		System.out.println("=====bc提供的SHA224=====");
		bcSHA224();
		System.out.println("=====================");
		
		/*
		    =====jdk提供的SHA1=====
			消息摘要之后:02470457fc2738acb459ee266dd66976324ee5b8
			=====================
			=====bc提供的SHA1=====
			消息摘要之后:02470457fc2738acb459ee266dd66976324ee5b8
			=====================
			=====cc提供的SHA1=====
			消息摘要之后:02470457fc2738acb459ee266dd66976324ee5b8
			=====================
			=====bc提供的SHA-256=====
			消息摘要之后:dd855bed3dce767ad1ce3f051b8d6fba12a0c00fe2feaa142ca37f2ae88fbca3
			=====================
			=====bc提供的SHA224=====
			消息摘要之后:f2a63bc30d2d8fcebc9b5aa4f660b6f422328731588346dbd55a1a2f
			=====================
		 */
	}

	/*
	 * jdk对SHA算法实现
	 */
	public static void jdkSHA1() {
		try {
			byte[] result;
			MessageDigest digest = MessageDigest.getInstance("SHA1");
			result = digest.digest(src.getBytes());
			System.out.println("消息摘要之后:" + Hex.encodeHexString(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * bc实现SHA1
	 */
	public static void bcSHA1() {
		// 因为都是用Digest接口里的方法,在MD代码里已经注释了,这里就不再叙述
		Digest digest = new SHA1Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] result = new byte[digest.getDigestSize()];
		digest.doFinal(result, 0);
		System.out.println("消息摘要之后:" + Hex.encodeHexString(result));
	}

	/*
	 * jdk对SHA-256的支持
	 */
	public static void jdkSHA256() {
		try {
			byte[] result;
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			result = digest.digest(src.getBytes());
			System.out.println("消息摘要之后:" + Hex.encodeHexString(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * bc实现SHA224
	 */
	public static void bcSHA224() {
		// 因为都是用Digest接口里的方法,在MD代码里已经注释了,这里就不再叙述
		Digest digest = new SHA224Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] result = new byte[digest.getDigestSize()];
		digest.doFinal(result, 0);
		System.out.println("消息摘要之后:" + Hex.encodeHexString(result));
	}
	
	/*
	 * cc对SHA1的实现
	 * 其实也是对jdk的包装
	 */
	public static void ccSHA1(){
		String result = DigestUtils.sha1Hex(src.getBytes());
		System.out.println("消息摘要之后:" +result);
	}
	/*
	 * 其余的SHA实现都与上面的方法相同
	 */
}
