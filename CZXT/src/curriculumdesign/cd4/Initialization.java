package curriculumdesign.cd4;

import java.util.concurrent.ThreadLocalRandom;

public class Initialization {

	public static void main(String[] args) {
		Despath de = new Despath();
		ThreadLocalRandom random = ThreadLocalRandom.current();
		System.out.println("\n产生的进程信息如下 :  ");
		for (int i = 0; i < 20; i++) {
			PCB pcb = new PCB();
			pcb.setPid(i);
			pcb.setPriority(random.nextInt(0, 8));
			pcb.setTimeneed(random.nextInt(10, 1000));
			System.out.println(pcb);
			de.entryQueue(pcb);
		}
		System.out.println("\n进程进入队列情况如下 :   ");
		de.showAllQueue();
		System.out.println("\n进程调度顺序如下 :  ");
		de.despathProcess();
	}
}
