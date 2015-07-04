package curriculumdesign.cd8;

public class Producer  extends Thread{
	private Case cases;
	public Producer(String name, Case cases){
		super(name);
		this.cases = cases;
	}
	public void run(){
//		System.out.println(this.getName());
		for(int i = 0; i < 100; i++){
			cases.product();
//			try {
//				this.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
//			System.out.println("product  "+i);
	}
}	
