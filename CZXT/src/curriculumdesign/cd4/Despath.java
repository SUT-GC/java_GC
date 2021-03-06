package curriculumdesign.cd4;

import java.util.ArrayDeque;
import java.util.Vector;

public class Despath {
	private Vector<ArrayDeque> queues = new Vector<ArrayDeque>();
	private int[] cputime = new int[9];

	public void showAllQueue() {
		System.out.println("==================================");
		System.out.println(" 队列权值/cpu时间片:   进程队列");
		for (int i = 8; i >= 0; i--) {
			Object[] pcbs = queues.get(i).toArray();
			System.out.print(i+"/"+cputime[i]+"  :  ");
			for(int j = 0; j < pcbs.length; j++){
				PCB p = (PCB) pcbs[j];
				System.out.print(p+" ");
			}
			if(queues.get(i).isEmpty()){
				System.out.println("-------------------------------------------");
			}else{
				System.out.println();
			}
		}
		System.out.println("==================================");
	}

	public Despath() {
		for (int i = 0; i <= 8; i++) {
			ArrayDeque<PCB> queue = new ArrayDeque<PCB>();
			queues.add(queue);
		}
		cputime[8] = 25;
		for (int i = 7; i >= 0; i--) {
			cputime[i] = cputime[i+1] * 2;
		}
	}

	public void entryQueue(PCB pcb) {
		queues.get(pcb.getPriority()).addLast(pcb);
	}

	public void despathProcess() {
		for (int i = 7; i > 0; i--) {
			while (!queues.get(i).isEmpty()) {
				PCB pcb = (PCB) queues.get(i).getFirst();
				queues.get(i).removeFirst();
				System.out.println("进程 ID : "+pcb.getPid());
				pcb.setTimeneed(pcb.getTimeneed() - cputime[i]);
				if (pcb.getTimeneed() > 0) {
					queues.get(i - 1).addLast(pcb);
				}
			}
		}
		while (!queues.get(0).isEmpty()) {
			PCB pcb = (PCB) queues.get(0).getFirst();
			queues.get(0).removeFirst();
			System.out.println("进程 ID : "+pcb.getPid());
			pcb.setTimeneed(pcb.getTimeneed() - cputime[0]);
			if (pcb.getTimeneed() > 0) {
				queues.get(0).addLast(pcb);
			}
		}
	}
}
