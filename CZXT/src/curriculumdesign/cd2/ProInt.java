package curriculumdesign.cd2;

import java.util.Scanner;

class Thread1 extends Thread{
	private int i;
	public Thread1(){
		i = 0;
	}
	public void run(){
		System.out.println("Child Process 1 is startint......");
		while(true){
			i++;
		}
	}
	public int getI(){
		return i;
	}
	
}
class Thread2 extends Thread{
	private int i;
	public Thread2(){
		i = 0;
	}
	public void run(){
		System.out.println("Child Process 2 is startint......");
		while(true){
			i++;
		}
	}
	public int getI(){
		return i;
	}
}
class ThreadMain extends Thread{
	private String com;
	public ThreadMain(){
		com = "go";
	}
	public void run(){
		System.out.println("Parent Process is startint......");
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		thread1.start();
		thread2.start();
		Scanner sc = new Scanner(System.in);
		while(true){
			com = sc.next();
			if(com.equals("kill")){
				System.out.println("The Value of Child Process 1'i is : "+thread1.getI());
				thread1.stop();
				System.out.println("Child Process 1 is Killed by Parent......");
				System.out.println("The Value of Child Process 2'i is : "+thread2.getI());
				thread2.stop();
				System.out.println("Child Process 2 is Killed by Parent......");
				break;
			}
		}
		System.out.println("Parent Process is Killed...... ");
		Thread.currentThread().stop();
	}

}
public class ProInt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ThreadMain tm = new ThreadMain();
		tm.start();
	}

}
