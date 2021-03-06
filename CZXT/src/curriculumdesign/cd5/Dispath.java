package curriculumdesign.cd5;

import java.util.Arrays;

public class Dispath {
	private int[][] informations;
	private String[] pname;
	private int[] res;

	public Dispath(String[] name, int[][] informations, int[] res) {
		this.informations = informations;
		this.pname = name;
		this.res = res;
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < pname.length; j++) {
				res[i] -= informations[j][res.length + i];
			}
		}

	}
	public boolean checkRequest(String name, int[] request){
		int seat = 0;
		for(int i = 0; i < pname.length; i++){
			if(pname[i].equals(name)){
				seat = i;
			}
		}
		int count = 0;
		for(int i = 0; i < request.length; i++){
			if((request[i] <= informations[seat][2*res.length+i]) && (request[i] <= res[i])){
				count++;
			}
		}
		if(count == res.length){
			for(int i = 0; i < res.length; i++){
				res[i] -= request[i];
			}
			if(check()){
				return true;
			}
		}
		return false;
	}
	public boolean check() {
		
		for (int i = 0; i < res.length; i++) {
			if (res[i] < 0) {
				return false;
			}
		}
		for (int i = 0; i < pname.length; i++) {
			for (int i1 = 0; i1 < pname.length; i1++) {
				if (informations[i1][3 * res.length] != 1) {
					int count = 0;
					for (int j = 0; j < res.length; j++) {
						if (informations[i1][2 * res.length + j] <= res[j]) {
							count++;
						}
					}
					if (count == res.length) {
						informations[i1][3 * res.length] = 1;
						System.out.print(Arrays.toString(res));
						System.out.println("  "+pname[i1]+"  ");
						for (int k = 0; k < res.length; k++) {
							res[k] += informations[i1][res.length + k];
						}
						break;
					}
				}
			}
		}
		int count = 0;
		for (int i = 0; i < pname.length; i++) {
			if (informations[i][3 * res.length] == 1) {
				count++;
			}
		}
		if (count == pname.length) {
			System.out.println();
			return true;
		} else {
			return false;
		}
	}

	public void showInformation() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("进程名 * Max * Allocation * Need * isOK");
		for (int i = 0; i < pname.length; i++) {
			int count = 0;
			System.out.print(pname[i] + "  *  ");
			for (int j = 0; j < informations[i].length; j++) {
				System.out.print(" " + informations[i][j] + " ");
				count++;
				if (count % 3 == 0) {
					System.out.print("  *  ");
				}
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------------------------");
	}
}
