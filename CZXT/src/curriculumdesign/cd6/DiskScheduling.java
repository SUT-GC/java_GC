package curriculumdesign.cd6;

import java.util.Arrays;
import java.util.Vector;

public class DiskScheduling {
	private Vector<Integer> request = new Vector<Integer>();
	private Integer NOWSEAT;

	public Integer getNOWSEAT() {
		return NOWSEAT;
	}

	public void setNOWSEAT(Integer nOWSEAT) {
		NOWSEAT = nOWSEAT;
	}

	public void entryRequest(Integer request) {
		this.request.add(request);
	}

	public void FCFS(){
		double sum = 0;
		int n;
		n = request.size();
		for(int i = 0; i < request.size(); i++){
			System.out.print(request.get(i)+"  ");
			sum += Math.abs((request.get(i)-NOWSEAT)*1.0);
			NOWSEAT = request.get(i);
		}
		System.out.println();
		System.out.printf("平均寻道长度为: %.1f\n", (sum / n));
	}
	public void SSTF(){
		int maxl;
		double sum = 0.0;
		int n = request.size();
		int maxi = 0;
		for(int i = 0; i < n; i++){
			maxl = Integer.MAX_VALUE;
			for(int j = 0; j < n-i; j++){
				if(Math.abs((request.get(j)-NOWSEAT)) < maxl){
					maxi = j;
					maxl = Math.abs((request.get(j)-NOWSEAT));
				}
			}
			System.out.print(request.get(maxi)+" ");
			sum += Math.abs((request.get(maxi)-NOWSEAT)*1.0);
			NOWSEAT = request.get(maxi);
			request.remove(maxi);
		}
		System.out.println();
		System.out.printf("平均寻道长度为: %.1f\n", (sum / n));;
	}
	public void SCAN(){
		int[] a = new int[request.size()];
		for(int i = 0; i < request.size(); i++){
			a[i] = request.get(i);
		}
		double sum = 0;
		int n = request.size();
		int m = 0;
		Arrays.sort(a);
		for(int i = 0; i < n; i++){
			if(NOWSEAT < a[i]){
				m = i;
				break;
			}
		}
		for(int i = m; i < n; i++){
			System.out.print(a[i] + " ");
			sum += Math.abs(a[i]-NOWSEAT);
			NOWSEAT = a[i];
		}
		for(int i = m-1; i >= 0; i--){
			System.out.print(a[i] + " ");
			sum+= Math.abs(a[i]-NOWSEAT);
			NOWSEAT = a[i];
		}
		System.out.println();
		System.out.printf("平均寻道长度为: %.1f\n", (sum / n));
	}
	public void CSCAN(){
		int[] a = new int[request.size()];
		for(int i = 0; i < request.size(); i++){
			a[i] = request.get(i);
		}
		double sum = 0;
		int n = request.size();
		int m = 0;
		Arrays.sort(a);
		for(int i = 0; i < n; i++){
			if(NOWSEAT < a[i]){
				m = i;
				break;
			}
		}
		for(int i = m; i < n; i++){
			System.out.print(a[i] + " ");
			sum += Math.abs(a[i]-NOWSEAT);
			NOWSEAT = a[i];
		}
		for(int i = 0; i < m; i++){
			System.out.print(a[i] + " ");
			sum+= Math.abs(a[i]-NOWSEAT);
			NOWSEAT = a[i];
		}
		System.out.println();
		System.out.printf("平均寻道长度为: %.1f\n", (sum / n));
	}
}
