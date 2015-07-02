package Test1;
import java.util.Scanner;

public class List {
	private Scanner sc = new Scanner(System.in);
	private int[] elemInt;
	private int size;

	public List(int size) {
		this.size = size;
		elemInt = new int[size];
		for (int i = 0; i < size; i++) {
			elemInt[i] = sc.nextInt();
		}
	}

	public void Print() {
		for (int i = 0; i < size; i++) {
			System.out.print(elemInt[i] + " ");
		}
		System.out.println();
	}

	public int find(int num) {
		for (int i = 0; i < size; i++) {
			if (elemInt[i] == num) {
				return 1;
			}
		}
		return 0;
	}

	public int isSym() {
		for (int i = 0, j = size - 1; i != j; i++, j--) {
			if (elemInt[i] != elemInt[j]) {
				return 0;
			}
		}
		return 1;
	}

	public int getSize() {
		return size;
	}

	public void oddAndEven() {
		int[] add = new int[size];
		int[] even = new int[size];
		int j = 0;
		int k = 0;
		for (int i = 0; i < size; i++) {
			if (elemInt[i] % 2 == 1) {
				add[j] = elemInt[i];
				j++;
			}
			if (elemInt[i] % 2 == 0) {
				even[k] = elemInt[i];
				k++;
			}
		}

		for (int i = 0; i < j; i++) {
			elemInt[i] = add[i];
		}
		for (int i = j; i < size; i++) {
			elemInt[i] = even[i - j];
		}
	}

	public void insertSort() {
		int i, j;
		int key;
		for (i = 1; i < size; i++) {
			key = elemInt[i];
			j = i - 1;
			while (j >= 0 && key < elemInt[j]) {
				elemInt[j + 1] = elemInt[j];
				j--;
			}
			elemInt[j + 1] = key;
		}
	}

	static int[] combine(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int i = 0;
		int j = 0;
		for (int k = 0; k < a.length + b.length; k++) {
			if (i == a.length) {
				c[k] = b[j];
				j++;
			} else if (j == b.length) {
				c[k] = a[i];
				i++;
			} else if (a[i] <= b[j]) {
				c[k] = a[i];
				i++;
			} else {
				c[k] = b[j];
				j++;
			}
		}
		return c;
	}

}