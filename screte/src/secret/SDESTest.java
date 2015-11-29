package secret;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Hex;

public class SDESTest {

	public static String src = "i am 3DES";
	public static void main(String[] args) {
		System.out.println("====jdk3DES实现====");
		jdk3DES();
		System.out.println("=================");
		
		//运行结果
		/*====jdk3DES实现====
		生成的秘钥为:e37616b6d920151637927c5ecb10abf2c46262bf34522abf
		加密之后的结果:75e21263547078139f0953e45e5aa683
		解密之后的结果:i am 3DES
		=================
		*/
	}
	public static void jdk3DES(){
		//生成Key
		try {
			//用DESede来实例化三重DES
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
			//生成秘钥
			SecretKey secretKey = keyGenerator.generateKey();
			//获取秘钥到byte数组里
			byte[] byteKey = secretKey.getEncoded();
			//输出秘钥
			System.out.println("生成的秘钥为:"+Hex.encodeHexString(byteKey));
			
			//加密
			Cipher cipher = Cipher.getInstance("DESede");
			//根据秘钥进行加密
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			//输出加密之后的密文
			byte[] result = cipher.doFinal(src.getBytes());
			//输出加密结果
			System.out.println("加密之后的结果:"+Hex.encodeHexString(result));
			
			//将byteKey转换成秘钥
			//根据byteKey生成3DES秘钥规范
			DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(byteKey);
			//创建3DES秘钥工厂
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DESede");
			//生产秘钥
			SecretKey secretKey2 = secretKeyFactory.generateSecret(deSedeKeySpec);
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, secretKey2);
			result = cipher.doFinal(result);
			System.out.println("解密之后的结果:"+new String(result));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
