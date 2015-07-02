package Test4;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BinaryTree {
	private char[] BT = new char[9999];
	private ArrayDeque<Integer> queue = new ArrayDeque<>();
	private ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
	private String s;
	private char endChar;
	public BinaryTree() {
		for (int i = 0; i < 9999; i++) {
			BT[i] = '*';
		}
	}

	public void createBT(String s) {
		this.s = s;
		if (s.equals(""))
			return;
		BT[1] = s.charAt(0);
		queue.offerLast(1);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '#') {
				if (BT[2 * queue.peekFirst()] == '*') {
					BT[2 * queue.peekFirst()] = '#';
				} else {
					BT[2 * queue.peekFirst() + 1] = '#';
					queue.removeFirst();
				}
			} else {
				if (BT[2 * queue.peekFirst()] == '*') {
					BT[2 * queue.peekFirst()] = s.charAt(i);
					queue.offerLast(2 * queue.peekFirst());
				} else {
					BT[2 * queue.peekFirst() + 1] = s.charAt(i);
					queue.offerLast(2 * queue.peekFirst() + 1);
					queue.removeFirst();
				}
			}
		}
	}

	private void orderTraversal(int n) {
		if (BT[n] == '#')
			return;
		else {
			orderTraversal(2 * n);
			System.out.print(BT[n]);
			orderTraversal(2 * n + 1);
		}
	}

	public void recursiveErgodic() {
		if (BT[1] == '*') {
			System.out.println("树为空树!");
			return;
		} else {
			orderTraversal(1);
			System.out.println();
		}
	}

	public void notRecursiveErgodic() {
		char[] BTC = Arrays.copyOf(BT, BT.length);
		if (BTC[1] == '*') {
			System.out.println("树为空树!");
			return;
		} else {
			stack.offerFirst(1);
			while (!stack.isEmpty()) {
				if (BTC[2 * stack.peekFirst()] == '#') {
					if (BTC[stack.peekFirst()] != '#')
						System.out.print(BTC[stack.peekFirst()]);
					BTC[stack.peekFirst()] = '#';
					if (BTC[2 * stack.peekFirst() + 1] != '#') {
						stack.offerFirst(2 * stack.peekFirst() + 1);
					} else {
						stack.removeFirst();
					}
				} else {
					stack.offerFirst(2 * stack.peekFirst());
				}
			}
		}
		System.out.println();
	}

	private int orderTraversalCount(int n) {
		if (BT[2 * n] == '#' && BT[2 * n + 1] == '#') {
			return 1;
		} else if (BT[n] == '#') {
			return 0;
		} else {
			return orderTraversalCount(2 * n) + orderTraversalCount(2 * n + 1);
		}
	}

	public int countLeaf() {
		int count = 0;
		if (BT[1] == '*') {
			count = 0;
		} else {
			count = orderTraversalCount(1);
		}
		return count;
	}
	public int depthOfBT(){
		for(int i = s.length()-1; i >= 0; i--){
			if(s.charAt(i) != '#'){
				endChar = s.charAt(i);
				break;
			}
		}
		int d = findEndCharIndex();
		if(d == 0){
			System.out.println("未找到最后的字符");
			return 0;
		}else{
			return  (int)Math.sqrt(1.0*d)+1;
		}
	}
	private int findEndCharIndex(){
		for(int i = 0; i < 9999; i++){
			if(BT[i] == endChar){
				return i;
			}
		}
		return 0;
	}
	public void print() {
		for (int i = 0; i < 40; i++) {
			System.out.println(BT[i]);
		}
	}
}
