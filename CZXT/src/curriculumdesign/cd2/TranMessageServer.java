package curriculumdesign.cd2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TranMessageServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(30000);
		System.out.println("服务器启动.........");
		while(true){
			Socket s = ss.accept();
			File file = new File("a");
			FileInputStream fis = new FileInputStream(file);
			PrintStream ps = new PrintStream(s.getOutputStream());
			String str = " =================这是来自服务器端的消息 ===================\n";
			int count = 0;
			byte[] bytes = new byte[1024];
			while((count = fis.read(bytes)) > 0 ){
				str+= new String(bytes, 0, count);
			}
			ps.print(str);
		}
	}

}
