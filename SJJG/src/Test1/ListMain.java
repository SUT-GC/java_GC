package Test1;
import java.util.Scanner;


public class ListMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("请输入您想输入数列的长度");
		n = sc.nextInt();
		System.out.println("请输入您想输入的数列各个元素5");
		List l = new List(n);
		System.out.println("您输入的数列是");
		l.Print();
		if(l.find(3) == 1){
			System.out.println("您输入的数列里存在 3");
		}else{
			System.out.println("您输入的数列里不存在 3");
		}
		if(l.isSym() == 1){
			System.out.println("您输入的数列是对称数列");
		}else{
			System.out.println("您输入的数列不是对称数列");
		}
		System.out.println("您输入的数列变换成奇数在前偶数在后的结果是");
		l.oddAndEven();
		l.Print();
		System.out.println("您输入的数列经过插入排序之后得到的结果是");
		l.insertSort();
		l.Print();
		System.out.println("==========下面是两个有序数列=========");
		int[] a = {1,3,4,5,6,7,8,9};
		int[] b = {1,2,3,4,5,6};
		for(int num:a){
			System.out.print(num+" ");
		}
		System.out.println();
		for(int num:b){
			System.out.print(num+" ");
		}
		System.out.println();
		System.out.println("经合并之后的数列为");
		for(int num: List.combine(a, b)){
			System.out.print(num + " ");
		}
		System.out.println();
		sc.close();
	}
	
}