package curriculumdesign.cd8;

public class ProAndCus {
	public static void main(String[] args){
		Case cases = new Case(5);
		Customer cus1 = new Customer("消费者1", cases);
		Customer cus2 = new Customer("消费者2", cases);
		Customer cus3 = new Customer("消费者3", cases);
		Producer pro1 = new Producer("生产者1", cases);
//		Producer pro2 = new Producer("生产者2", cases);
		cus1.start();
		cus2.start();
		cus3.start();
		pro1.start();
//		pro2.start();
	}
}
