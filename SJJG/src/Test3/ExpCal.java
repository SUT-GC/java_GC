package Test3;

import java.util.Stack;

public class ExpCal {
	private String Infix;
	private String Suffix;
	private StringBuffer buff = new StringBuffer();
	private Stack stack = new Stack();
	private Stack<Double> calStack = new Stack<>();

	public void getInfix(String infix) {
		this.Infix = infix;
	}

	public void infixToSuffix() {
		for (int i = 0; i < Infix.length(); i++) {
			char c = Infix.charAt(i);
			if (c >= '0' && c <= '9') {
				buff.append(c);
			}
			if (c == '(') {
				stack.push(c);
			}
			if (c == '+' || c == '-') {
				while (!stack.isEmpty() && (char) stack.peek() != '(') {
					buff.append(stack.peek());
					stack.pop();
				}
				stack.push(c);
			}
			if (c == '*' || c == '/') {
				while (!stack.isEmpty()
						&& ((char) stack.peek() == '/' || (char) stack.peek() == '*')) {
					buff.append(stack.peek());
					stack.pop();
				}
				stack.push(c);
			}
			if (c == ')') {
				while ((char) stack.peek() != '(') {
					buff.append(stack.peek());
					stack.pop();
				}
				stack.pop();
			}
		}
		while (!stack.isEmpty()) {
			buff.append(stack.peek());
			stack.pop();
		}
		Suffix = new String(buff);
	}

	public double Calculate() {
		calStack.clear();
		for (int i = 0; i < Suffix.length(); i++) {
			char c = Suffix.charAt(i);
			if (c >= '0' && c <= '9') {
				calStack.push(Double.valueOf(c - '0'));
			}
			if (c == '+') {
				double a = calStack.peek();
				calStack.pop();
				double b = calStack.peek();
				calStack.pop();
				calStack.push(a + b);
			}
			if (c == '-') {
				double a = calStack.peek();
				calStack.pop();
				double b = calStack.peek();
				calStack.pop();
				calStack.push(b - a);
			}
			if (c == '*') {
				double a = calStack.peek();
				calStack.pop();
				double b = calStack.peek();
				calStack.pop();
				calStack.push(a * b);
			}
			if (c == '/') {
				double a = calStack.peek();
				calStack.pop();
				double b = calStack.peek();
				calStack.pop();
				calStack.push(b / a);
			}
		}
		return calStack.peek();
	}

	public String getSuffix() {
		return Suffix;
	}
	public String getInfix(){
		return Infix;
	}
}
