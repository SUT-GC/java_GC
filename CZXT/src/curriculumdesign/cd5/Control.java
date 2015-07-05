package curriculumdesign.cd5;

import java.util.Arrays;
import java.util.Scanner;

public class Control {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] pname = new String[]{"p0","p1","p2","p3","p4"};
		int[][] informations1 = new int[][]{
				{8,5,2,1,1,0,7,4,2,0},
				{3,2,2,2,0,0,1,2,2,0},
				{8,0,2,3,0,1,5,0,1,0},
				{2,2,3,2,1,1,0,1,2,0},
				{4,3,3,0,0,2,4,3,1,0}
		};
		int[][] informations2 = new int[][]{
				{8,5,2,1,1,0,7,4,2,0},
				{3,2,2,2,0,0,1,2,2,0},
				{8,0,2,3,0,1,5,0,1,0},
				{2,2,3,2,1,1,0,1,2,0},
				{4,3,3,0,0,2,4,3,1,0}
		};
		int[] res = new int[]{10,5,7};
		System.out.println("各种资源数量分别为  : "+Arrays.toString(res));
		Dispath dis = new Dispath(pname, informations1, res);
		dis.showInformation();
		if(dis.check()){
			System.out.println("安全......");
		}else{
			System.out.println("不安全......");
		}
		System.out.print("请输入对平p1的Reque:  ");
		int[] request = new int[] {1, 0, 2};
//		for(int i = 0; i < res.length; i++){
//			request[i] = sc.nextInt();
//		}
		System.out.println(Arrays.toString(request));
		Dispath dis2 = new Dispath(pname, informations2, res);
		if(dis2.checkRequest("p1", request)){
			System.out.println("安全......");
		}else{
			System.out.println("不安全......");
		}
		
	}

}
