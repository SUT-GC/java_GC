package secret;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;

public class MDTest {
	public static String src = "i am gc MD";
	public static void main(String[] args) {
		System.out.println("=====jdk提供的MD5=====");
		jdkMD5();
		System.out.println("=====================");
		System.out.println("=====jdk提供的MD2=====");
		jdkMD2();
		System.out.println("=====================");
		System.out.println("=====BC提供的MD4=====");
		bcMD4();
		System.out.println("=====================");
		System.out.println("=====BC提供的MD5=====");
		bcMD5();
		System.out.println("=====================");
		System.out.println("=====CC提供的MD5=====");
		ccMD5();
		System.out.println("=====================");
		System.out.println("=====CC提供的MD2=====");
		ccMD2();
		System.out.println("=====================");
		
		
		//运行结果
		/*=====jdk提供的MD5=====
			信息摘要之后的src: 8a63f68d49d7acfa716602e9ab620394
			=====================
			=====jdk提供的MD2=====
			信息摘要之后的src: 2d2df5c04ceeaac31bdffb019ccd03c8
			=====================
			=====BC提供的MD4=====
			信息摘要之后的src: 5ff5d77df559660ed4ff19ac2f5e2e2a
			=====================
			=====BC提供的MD5=====
			信息摘要之后的src: 8a63f68d49d7acfa716602e9ab620394
			=====================
			=====CC提供的MD5=====
			信息摘要之后的src: 8a63f68d49d7acfa716602e9ab620394
			=====================
			=====CC提供的MD2=====
			信息摘要之后的src: 2d2df5c04ceeaac31bdffb019ccd03c8
			=====================
		 */
	}
	/*
	 * jdkMD5方法
	 */
	public static void jdkMD5(){
		try {
			//jdk提供的MessageDegest类 创建对象时候需要传入参数,可以是MD5, MD2
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] result = md.digest(src.getBytes());
			//因为digest方法返回的使一个byte数组,如果想输出字符串,必须将byte数组转化成16进制等,但是jdk并没有提供这样的方法,所以你可以选择自己写或者使用bc或cc提供的方法
			//现在我们借助cc提供的方法
			//输出32位16进制数
			System.out.println("信息摘要之后的src: "+Hex.encodeHexString(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * jdkMD2信息摘要
	 */
	public static void jdkMD2(){
		try {
			//jdk提供的MessageDegest类 创建对象时候需要传入参数,可以是MD5, MD2
			MessageDigest md = MessageDigest.getInstance("MD2");
			byte[] result = md.digest(src.getBytes());
			//因为digest方法返回的使一个byte数组,如果想输出字符串,必须将byte数组转化成16进制等,但是jdk并没有提供这样的方法,所以你可以选择自己写或者使用bc或cc提供的方法
			//现在我们借助cc提供的方法
			//输出32位16进制数
			System.out.println("信息摘要之后的src: "+Hex.encodeHexString(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//bc实现MD4
	public static void bcMD4(){
		//Digest是一个借口,MD4Degist仅仅是一个实现类
		Digest digest = new MD4Digest();
		//进行摘要
		digest.update(src.getBytes(), 0 , src.getBytes().length);
		//获取算法摘要出来的长度
		byte[] result = new byte[digest.getDigestSize()];
		//摘要的输出到变量里
		digest.doFinal(result, 0);
		//进行转换输出
		System.out.println("信息摘要之后的src: "+Hex.encodeHexString(result));
	}
	
	/*
	 * bc实现MD5
	 * 跟bc实现MD4相似,在此不再加注释
	 */
	public static void bcMD5(){
		Digest digest = new MD5Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] result = new byte[digest.getDigestSize()];
		digest.doFinal(result, 0);
		System.out.println("信息摘要之后的src: "+Hex.encodeHexString(result));
	}
	
	/*
	 * cc对MD5的实现
	 */
	public static void ccMD5(){
		//说实话.CC提供的DegistUtils工具类对信息摘要的实现真的是简单至极
		String result = DigestUtils.md5Hex(src.getBytes());
		System.out.println("信息摘要之后的src: "+result);
	}
	/*
	 * cc对MD2的实现
	 */
	public static void ccMD2(){
		//说实话.CC提供的DegistUtils工具类对信息摘要的实现真的是简单至极
		//但是CC做了个偷工减料的地方,CC仅仅是对jdk中MessageDegist的简单包装,所以CC中支持md4的实现
		String result = DigestUtils.md2Hex(src.getBytes());
		System.out.println("信息摘要之后的src: "+result);
	}
}
