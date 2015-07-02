package Test4;

public class BinaryTreeMain {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
//按照层次遍历建立二叉树
		bt.createBT("ABCD#EF####G###");
//		bt.createBT("");
//		bt.print();
//		bt.createBT("AB#C###");
//		bt.createBT("ABC#D####");
		System.out.println("递归中序遍历树:");
		bt.recursiveErgodic();
		System.out.println("非递归中序遍历树:");
		bt.notRecursiveErgodic();
		System.out.println("叶子节点的个数为: ");
		System.out.println(bt.countLeaf());
		System.out.println("树的深度为: ");
		System.out.println(bt.depthOfBT());
	}

}
