package Test5;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class UndirectedGraph {
	private int numOfVertex;
	private int numOfEdge;
	private int[][] arc;
	private String[] v;
	private Scanner sc = new Scanner(System.in);
	private ArrayDeque<Integer> queue = new ArrayDeque<>();
	private Vector<String> ve = new Vector();
	private Set set = new HashSet();
	private int[][] mst;
	private int[][] pow;

	public UndirectedGraph(int n, int e) {
		this.numOfVertex = n;
		this.numOfEdge = e;
		arc = new int[n][n];
		pow = new int[n][n];
		v = new String[n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				pow[i][j] = -1;
		System.out.println("请输入" + n + "个顶点 :");
		for (int i = 0; i < n; i++) {
			v[i] = sc.next();
		}
		System.out.println("请输入" + e + "条边 和 每条边的权值:");
		for (int j = 0; j < e; j++) {
			String s1 = sc.next();
			String s2 = sc.next();
			int p = sc.nextInt();
			int a = 0;
			int b = 0;
			for (int i = 0; i < n; i++) {
				if (v[i].equals(s1)) {
					a = i;
				}
				if (v[i].equals(s2)) {
					b = i;
				}
			}
			arc[a][b] = 1;
			arc[b][a] = 1;
			pow[a][b] = p;
			pow[b][a] = p;
		}
		mst = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				mst[i][j] = arc[i][j];
	}

	private void DFS(int w) {
		for (int i = 0; i < numOfVertex; i++) {
			if (arc[w][i] == 1) {
				if (!set.contains(v[i])) {
					System.out.print(v[i] + " ");
					set.add(v[i]);
					DFS(i);
				}
			}
		}
	}

	private int findW(String s) {
		int w = 0;
		for (int i = 0; i < numOfVertex; i++) {
			if (v[i].equals(s)) {
				w = i;
			}
		}
		return w;
	}

	public void DFSG(String first) {
		set.add(first);
		System.out.print(first + " ");
		int w = findW(first);
		DFS(w);
		System.out.println();
	}

	private void BFS(int w) {
		for (int i = 0; i < numOfVertex; i++) {
			if (arc[w][i] == 1) {
				if (!set.contains(v[i])) {
					set.add(v[i]);
					System.out.print(v[i] + " ");
					queue.offerLast(i);
				}
			}
		}
		if (!queue.isEmpty()) {
			BFS(queue.pollFirst());
		}
	}

	public void BFSG(String first) {
		set.clear();
		set.add(first);
		System.out.print(first + " ");
		int w = findW(first);
		BFS(w);
		System.out.println();
	}

	public void MST() {
		Vector<String> vea = new Vector();
		for (int i = 0; i < v.length; i++) {
			vea.add(v[i]);
		}
		ve.clear();
		ve.add("v0");
		int min;
		int minx;
		int miny;

		while (!ve.containsAll(vea)) {
			min = Integer.MAX_VALUE;
			minx = 0;
			miny = 0;

			for (String s : ve) {
				int w = findW(s);
				for (int i = 0; i < numOfVertex; i++) {
					if (mst[w][i] == 1 && pow[w][i] < min) {
						min = pow[w][i];
						miny = w;
						minx = i;
					}
				}
			}
			mst[miny][minx] = 2;
			mst[minx][miny] = 2;

			for (int i = 0; i < ve.size() ; i++) {
				if(findW(ve.get(i)) != miny){
					mst[findW(ve.get(i))][minx] = 0;
					mst[minx][findW(ve.get(i))] = 0;
				}
			}
			ve.add(v[minx]);
		}
		for (int[] a : mst) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void print() {
		for (int[] a : arc) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (int[] a : pow) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
