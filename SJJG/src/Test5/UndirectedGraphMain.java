package Test5;

public class UndirectedGraphMain {

	public static void main(String[] args) {
		UndirectedGraph ug1 = new UndirectedGraph(6, 9);
		System.out.println("您输入的图的连接矩阵为 : ");
		ug1.print();
		System.out.println("深度优先搜索遍历图结果为: ");
		ug1.DFSG("v2");
		System.out.println("广度优先搜索遍历图结果为: ");
		ug1.BFSG("v0");
		System.out.println("最小生成树的连接矩阵为 :");
		ug1.MST();
/*
 * v0 v1 v2 v3
 *
v0 v3
v0 v1
v1 v3
v1 v2
 */
/*
v0 v1 v2 v3 v4 v5
v0 v1 34
v1 v4 12
v4 v3 38
v2 v3 17
v0 v2 46
v0 v5 19
v2 v5 25
v3 v5 25
v4 v5 26
*/
		
	}
}
