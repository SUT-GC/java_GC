package Terminal.Simulation;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostnameTest {
	public static void main(String[] args){
		InetAddress hostip;
		try {
			hostip = InetAddress.getLocalHost();
			System.out.println(hostip.getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
