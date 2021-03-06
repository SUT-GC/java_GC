package curriculumdesign.cd7;

import java.util.ArrayDeque;
import java.util.Vector;

public class PageRep {
	private int[] seqs;
	private int[] timefar;
	private int[] mem;
	private int[] timelong;

	public PageRep(int[] seqs, int memorysize) {
		this.seqs = seqs;
		timefar = new int[memorysize];
		timelong = new int[memorysize];
		mem = new int[memorysize];
		for (int i = 0; i < timefar.length; i++) {
			timefar[i] = 0;
			timelong[i] = 0;
		}
		for (int i = 0; i < memorysize; i++) {
			mem[i] = -1;
		}
	}

	private boolean find(int num, int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == num) {
				return true;
			}
		}
		return false;
	}

	private int findi(int num, int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == num) {
				return i;
			}
		}
		return -1;
	}

	private void showMem() {
		for (int i = 0; i < mem.length; i++) {
			if (mem[i] != -1) {
				System.out.print(mem[i] + " ");
			}
		}
		System.out.println();
	}

	public void FIFO() {
		int seat = 0;
		double sum = 0.0;
		for (int i = 0; i < seqs.length; i++) {
			if (!find(seqs[i], mem)) {
				mem[seat] = seqs[i];
				seat++;
				sum++;
				seat = seat % mem.length;
				showMem();
			}
		}
		System.out.printf("先进先出算法缺页率为 : %.2f\n", (sum / seqs.length));
	}

	private int findTimeLong() {
		int max = -1;
		int maxi = -1;
		for (int i = 0; i < timelong.length; i++) {
			if (timelong[i] > max) {
				max = timelong[i];
				maxi = i;
			}
		}
		return maxi;
	}

	public void memSetInit() {
		for (int i = 0; i < mem.length; i++) {
			mem[i] = -1;
		}
	}

	public void LRU() {
		for (int k = 0; k < timelong.length; k++) {
			timelong[k] = 0;
		}
		int seat = 0;
		double sum = 0;
		for (int i = 0; i < seqs.length; i++) {
			if (!find(seqs[i], mem)) {
				sum++;
				if (seat < mem.length) {
					mem[seat] = seqs[i];
					for (int w = 0; w < seat; w++)
						timelong[w]++;
					timelong[seat]++;
					seat++;
				} else {
					int j = findTimeLong();
					mem[j] = seqs[i];
					timelong[j] = 0;
					for (int k = 0; k < timelong.length; k++) {
						if (k != j) {
							timelong[k]++;
						}
					}
				}
				showMem();
			} else {
				int j = findi(seqs[i], mem);
				timelong[j] = 0;
				for (int k = 0; k < timelong.length; k++) {
					if (k != j) {
						timelong[k]++;
					}
				}
			}
		}
		System.out.printf("最近最久未使用算法缺页率为 : %.2f\n", (sum / seqs.length));
	}
	private int findfar(){
		int maxfar = -1;
		int maxi = -1;
		for(int i = 0; i < timefar.length; i++){
			if(maxfar < timefar[i]){
				maxfar = timefar[i];
				maxi = i;
			}
		}
		return maxi;
	}
	private void setTimeFar(int nowseat){

		for(int i = 0; i < mem.length; i++){
			for(int j = nowseat+1; j < seqs.length; j++){
				if(seqs[j] == mem[i]){
					timefar[i] = (j-nowseat);
					break;
				}
				if(j == seqs.length-1){
					timefar[i] = Integer.MAX_VALUE;
				}
			}
		}
	}
	public void Optimal(){
		double sum = 0.0;
		int seat = 0;
		for(int i = 0; i < seqs.length; i++){
			if(seat < mem.length){
				mem[seat] = seqs[i];
				sum++;
				seat++;
				showMem();
			}else if(!find(seqs[i], mem)){
				setTimeFar(i);
				int j = findfar();
				mem[j] = seqs[i];
				sum++;
				showMem();
			}
		}
		System.out.printf("最佳置换算法缺页率为 : %.2f\n", (sum / seqs.length));
	}
}
