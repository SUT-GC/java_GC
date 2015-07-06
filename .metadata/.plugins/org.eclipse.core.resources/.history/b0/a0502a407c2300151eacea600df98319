package curriculumdesign.cd2;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TreanMessageClient {

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Socket socket = new Socket("127.0.0.1", 30000);
		System.out.println("客户端启动......");
		System.setIn(socket.getInputStream());
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			System.out.println(sc.nextLine());
		}
	}

}