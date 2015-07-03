package curriculumdesign.cd2;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class Sender1 extends Thread{
	private PipedOutputStream out = new PipedOutputStream();
	public PipedOutputStream getOut(){
		return out;
	}
	public void run(){
		String str = "Message from Child 1 !  ";
		try {
			out.write(str.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
class Sender2 extends Thread{
	private PipedOutputStream out = new PipedOutputStream();
	public PipedOutputStream getOut(){
		return out;
	}
	public void run(){
		String str = "Message from Child 2 !";
		try {
			out.write(str.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
class Reader extends Thread{
	private PipedInputStream in1 = new PipedInputStream();
	private byte[] bytes1 = new byte[1024];
	private PipedInputStream in2 = new PipedInputStream();
	private byte[] bytes2 = new byte[1024];
	public PipedInputStream getIn1(){
		return in1;
	}
	public PipedInputStream getIn2(){
		return in2;
	}
	public void run(){
		try {
			in1.read(bytes1);
			in2.read(bytes2);
			System.out.println(new String(bytes1));
			System.out.println(new String(bytes2));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
public class PipedCom {

	public static void main(String[] args) {
		Sender1 send1 = new Sender1();
		Sender2 send2= new Sender2();
		Reader read = new Reader();
		PipedInputStream in1 = read.getIn1();
		PipedInputStream in2= read.getIn2();
		PipedOutputStream out1 = send1.getOut();
		PipedOutputStream out2 = send2.getOut();
		try {
			in1.connect(out1);
			in2.connect(out2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		send1.start();
		send2.start();
		read.start();
	}

}
