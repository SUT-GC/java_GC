package curriculumdesign.cd3;

import java.util.Scanner;

public class MemoryManagement {

	public static void main(String[] args) {
		Tables table = new Tables(64);
		Scanner sc = new Scanner(System.in);
		Job job1;
		String com;
		String name;
		while (true) {
			try {
				System.out.println("0:退出,   1.1:首次适应申请内存,   1.2循环首次适应申请内存,   1.3 最佳适应算法,   2:回收内存");
				com = sc.next();
				if (com.equals("0")) {
					break;
				} else if (com.equals("1.1")) {
					job1 = new Job();
					System.out.println("请输入job的名称 : ");
					job1.setName(sc.next());
					System.out.println("请输入job的大小 : ");
					job1.setSize(sc.nextInt());
					table.distributionJobFF(job1);
					table.showDistribution();
					table.showFree();
				}else if(com.equals("1.2")){
					job1 = new Job();
					System.out.println("请输入job的名称 : ");
					job1.setName(sc.next());
					System.out.println("请输入job的大小 : ");
					job1.setSize(sc.nextInt());
					table.distributionJobNF(job1);
					table.showDistribution();
					table.showFree();
				} else if(com.equals("1.3")){
					job1 = new Job();
					System.out.println("请输入job的名称 : ");
					job1.setName(sc.next());
					System.out.println("请输入job的大小 : ");
					job1.setSize(sc.nextInt());
					table.distributionJobBF(job1);
					table.showDistribution();
					table.showFree();
				}else if (com.equals("2")) {
					System.out.println("请输入要删除job的名字 : ");
					name = sc.next();
					table.recoveryMemory(name);
					table.showDistribution();
					table.showFree();
				}else{
					System.out.println("命令出错......");
				}
			} catch (Exception e) {
				System.out.println("命令出错......");
				e.printStackTrace();
				break;
			}
		}
		System.out.println("退出程序成功......");
	}
}
