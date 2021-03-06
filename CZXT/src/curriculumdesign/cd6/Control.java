package curriculumdesign.cd6;

import java.util.Arrays;

public class Control {
	public static void main(String[] args) {
		Integer[] seq = new Integer[]{98, 183, 37, 122, 14, 124, 65, 67};
		DiskScheduling ds1 = new DiskScheduling();
		DiskScheduling ds2 = new DiskScheduling();
		DiskScheduling ds3 = new DiskScheduling();
		DiskScheduling ds4 = new DiskScheduling();
		ds1.setNOWSEAT(53);
		ds2.setNOWSEAT(53);
		ds3.setNOWSEAT(53);
		ds4.setNOWSEAT(53);
		for(Integer num: seq){
			ds1.entryRequest(num);
			ds2.entryRequest(num);
			ds3.entryRequest(num);
			ds4.entryRequest(num);
		}
		System.out.print("产生的请求队列为: ");
		System.out.println(Arrays.toString(seq));
		System.out.println("当前磁头所在位置 :  53");
		System.out.println("------------------------------------------------------------");
		System.out.println("先到先服务磁盘调度算法......");
		ds1.FCFS();
		System.out.println("------------------------------------------------------------");
		System.out.println("最短寻道时间磁盘调度算法......");
		ds2.SSTF();
		System.out.println("------------------------------------------------------------");
		System.out.println("扫描磁盘调度算法......");
		ds3.SCAN();
		System.out.println("------------------------------------------------------------");
		System.out.println("循环扫描磁盘调度算法......");
		ds4.CSCAN();
		System.out.println("------------------------------------------------------------");
	}

}
