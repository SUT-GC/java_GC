	package secret;
	
	import java.security.NoSuchAlgorithmException;
	
	import javax.crypto.Cipher;
	import javax.crypto.KeyGenerator;
	import javax.crypto.SecretKey;
	import javax.crypto.SecretKeyFactory;
	import javax.crypto.spec.DESKeySpec;
	
	import org.apache.commons.codec.binary.Hex;
	
	public class DESTest {
	
		public static String src ="i am gc DES";
		
		public static void main(String[] args) {
			System.out.println("====jdkDES实现====");
			jdkDES();
			System.out.println("=================");
			
			//运行结果
			/*
			 ====jdkDES实现====
			生成的DES秘钥:e5312a52d93b8325
			加密之后的结果0b980d14f67e7e2dbf3bf45e5edc5c11
			解密之后的结果:i am gc DES
			=================
			 */
		}
		
		public static void jdkDES(){
			try {
				//由DES算法生成算法生成器KeyGenerator
				KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
				//由算法生成器生成秘钥
				SecretKey secretKey =  keyGenerator.generateKey();
				//将秘钥转成byte数组
				byte[] byteKey = secretKey.getEncoded();
				//将byte数组十六进制转换成字符串
				System.out.println("生成的DES秘钥:"+Hex.encodeHexString(byteKey));
				
				//加密
				Cipher cipher = Cipher.getInstance("DES");
				//加密初始化,传入加密模式和秘钥
				cipher.init(Cipher.ENCRYPT_MODE, secretKey);
				byte[] result = cipher.doFinal(src.getBytes());
				System.out.println("加密之后的结果"+Hex.encodeHexString(result));
				
				//进行byteKey的转换
				//先将byteKey生成DESKeySpec
			    DESKeySpec desKeySpec = new DESKeySpec(byteKey);
			    //再制造DES秘钥工厂
			    SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
			    //由秘钥工厂将deskeyspec加工成SecretKey
			    //此时的secreteKey2与secreteKey是相等的
			    SecretKey secretKey2 = secretKeyFactory.generateSecret(desKeySpec);
			    
			    //解密
			    //初始化cipher,解密模式,传入秘钥
			    cipher.init(Cipher.DECRYPT_MODE, secretKey2);
			    //开始解密
			    result = cipher.doFinal(result);
			    //输出
			    System.out.println("解密之后的结果:"+new String(result));
			    
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
