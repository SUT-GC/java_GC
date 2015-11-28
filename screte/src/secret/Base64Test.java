package secret;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Base64Test {
	public static String src = "i am gc base64";
	
	public static void main(String[] args) {
		//jdk对Base64编码的支持
		System.out.println("=====jdkBase64编码测试=====");
		jdkBase64();
		System.out.println("==========================");
		System.out.println("=====CommonsCodec的Base64实现=====");
		commonsCodecBase64();
		System.out.println("==========================");
		System.out.println("=====BouncyCastle的Base64实现=====");
		bouncyCastleBase64();
		System.out.println("==========================");
		
		//运行结果
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
	public static void jdkBase64(){
		//加密
		//获取Encoder对象
		Encoder encoder = Base64.getEncoder(); 
		//用Encoder对象对字符串进行加密
		byte[] result = encoder.encode(src.getBytes());
		System.out.println("Base64编码之后::"+new String(result));
		
		//解密
		//获取Decoder对象
		Decoder decoder = Base64.getDecoder();
		//用Decoder对象对加密之后的文件进行解密
		result = decoder.decode(result);
		System.out.println("将result解码之后:"+new String(result));
	}
	public static void commonsCodecBase64(){
		//commonscodec的方便之处在于直接用Base64.encoderBase64和Base64.decoderBase64进行加解密
		//加密
		byte[] result = org.apache.commons.codec.binary.Base64.encodeBase64(src.getBytes());
		System.out.println("Base64编码之后:"+new String(result));
		//解密
		result = org.apache.commons.codec.binary.Base64.decodeBase64(result);
		System.out.println("Base64解密之后:"+new String(result));
	}
	public static void bouncyCastleBase64(){
		 //加密
		byte[] result = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
		System.out.println("Base64编码之后:"+new String(result));
		//解密
		result = org.bouncycastle.util.encoders.Base64.decode(result);
		System.out.println("Base64解密之后:"+new String(result));
	}
	
	//运行结果如下
	/*
			=====jdkBase64编码测试=====
			Base64编码之后::aSBhbSBnYyBiYXNlNjQ=
			将result解码之后:i am gc base64
			==========================
			=====CommonsCodec的Base64实现=====
			Base64编码之后:aSBhbSBnYyBiYXNlNjQ=
			Base64解密之后:i am gc base64
			==========================
			=====BouncyCastle的Base64实现=====
			Base64编码之后:aSBhbSBnYyBiYXNlNjQ=
			Base64解密之后:i am gc base64
			==========================
	 */
}
