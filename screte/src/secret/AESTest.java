	package secret;
	
	import java.security.Key;
	import java.security.NoSuchAlgorithmException;
	import java.security.SecureRandom;
	
	import javax.crypto.Cipher;
	import javax.crypto.KeyGenerator;
	import javax.crypto.SecretKey;
	import javax.crypto.spec.SecretKeySpec;
	
	import org.apache.commons.codec.binary.Hex;
	
	public class AESTest {
		public static String src = "i am AES";
		
		public static void main(String[] args) {
			jdkAES();
			//运行结果
			/*
			     生成的秘钥为:4a4cb6b6cffc650cc4f7010d939a64f8
				加密后的结果:740bc2b2535a401eec755326a25ca134
				解密后的结果:i am AES
			 */
		}
		
		public static void jdkAES(){
			try {
				//生成秘钥
				KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			    //初始化KeyGenerator,密钥长度默认
				keyGenerator.init(new SecureRandom());
				//生成秘钥
				SecretKey secretKey = keyGenerator.generateKey();
				//生成byte数组
				byte[] byteKey = secretKey.getEncoded();
				//输出
				System.out.println("生成的秘钥为:"+Hex.encodeHexString(byteKey));
				
				//加密
				Cipher cipher = Cipher.getInstance("AES");
				cipher.init(Cipher.ENCRYPT_MODE, secretKey);
				byte[] result = cipher.doFinal(src.getBytes());
				System.out.println("加密后的结果:"+Hex.encodeHexString(result));
				
				//byteKey转换
				//AES的Key转换与DES有点区别
				Key key = new SecretKeySpec(byteKey, "AES");
				
				//解密
				cipher.init(Cipher.DECRYPT_MODE, key);
				result = cipher.doFinal(result);
				System.out.println("解密后的结果:"+new String(result));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
