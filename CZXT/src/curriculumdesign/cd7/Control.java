package curriculumdesign.cd7;

import java.util.concurrent.ThreadLocalRandom;

public class Control {

	public static void main(String[] args) {
		ThreadLocalRandom rand = ThreadLocalRandom.current();
		int[] seqs = new int[] { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2,
				0, 1, 7, 0, 1 };
		// for(int i = 0; i < 20; i++){
		// seqs[i] = rand.nextInt(0, 10);
		// }
		System.out
				.println("---------------------------------------产生的页面序列如下---------------------------------------");
		for (int num : seqs) {
			System.out.print(num + "  ");
		}
		System.out.println("\n物理块一共有 3 个......");
		System.out
				.println("-----------------------------------------------------------------------------------------------------------");
		System.out.println("先进先出页面置换结果如下......");
		PageRep rp = new PageRep(seqs, 3);
		rp.FIFO();
		System.out
		.println("---------------------------------------产生的页面序列如下---------------------------------------");
for (int num : seqs) {
	System.out.print(num + "  ");
}
System.out.println("\n物理块一共有 3 个......");
System.out
		.println("-----------------------------------------------------------------------------------------------------------");
		System.out.println("最近最久未使用页面置换算法结果如下......");
		rp.memSetInit();
		rp.LRU();
		System.out
		.println("---------------------------------------产生的页面序列如下---------------------------------------");
for (int num : seqs) {
	System.out.print(num + "  ");
}
System.out.println("\n物理块一共有 3 个......");
System.out
		.println("-----------------------------------------------------------------------------------------------------------");
		System.out.println("最佳页面置换算法结果如下......");
		rp.memSetInit();
		rp.Optimal();
	}

}
