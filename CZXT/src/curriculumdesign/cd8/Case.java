package curriculumdesign.cd8;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Case {
	private final Lock lock = new ReentrantLock();
	private final Condition cond = lock.newCondition();

	private String[] cases;
	private int MAXSIZE;
	private int NOWSIZE;
	public Case(int size) {
		this.MAXSIZE = size;
		cases = new String[size];
		this.NOWSIZE = 0;
	}
	public void printCases(){
		System.out.print("现在炉子里的面包为  :  [ ");
		for(int i = 0; i < NOWSIZE; i++){
			System.out.print(cases[i]+"  ");
		}
		System.out.println("] ");
	}
	public void product(){
		lock.lock();
//		System.out.println(Thread.currentThread().getName()+"product....lock..");
		try{
			if(MAXSIZE <= NOWSIZE){
				cond.await();
//				System.out.println(Thread.currentThread().getName()+"await......");
			}else{
				System.out.println("生产者生产......");
				cases[NOWSIZE] = "面包";
				NOWSIZE++;
				printCases();
//				System.out.println(Thread.currentThread().getName()+ "signal......");
				cond.signalAll();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
//			System.out.println(Thread.currentThread().getName()+"product....unlock..");
			lock.unlock();
		}
	}
	public void customer(){
		lock.lock();
//		System.out.println(Thread.currentThread().getName()+"customer....lock..");
		try{
			if(NOWSIZE <= 0){
//				System.out.println(Thread.currentThread().getName()+"await......");
				cond.await();
			}else{
				NOWSIZE--;
				System.out.println("消费者消费......");
				printCases();
				cond.signalAll();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
//			System.out.println(Thread.currentThread().getName()+"customer....unlock..");
			lock.unlock();
			
		}
	}
}
