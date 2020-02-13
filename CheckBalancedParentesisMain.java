package stack;

import java.util.Stack;

public class CheckBalancedParentesisMain {

	public static void main(String[] args) {
		String checkBalancedExpr1 = checkBalancedParentesis("{()[]}");
		System.out.println("{()[]} : " + checkBalancedExpr1);
		String checkBalancedExpr2 = checkBalancedParentesis("{([)]}");
		System.out.println("{([)]} : " + checkBalancedExpr2);
	}

	public static String checkBalancedParentesis(String expr) {
		if (expr.isEmpty())
			return "Balanced";

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < expr.length(); i++) {
			char current = expr.charAt(i);
			if (current == '{' || current == '(' || current == '[') {
				System.out.println("Pushing " + current);
				stack.push(current);
			}
			if (current == '}' || current == ')' || current == ']') {
				if (stack.isEmpty())
					return "Not Balanced";
				char last = stack.peek();
				if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[') {
					System.out.println("Popping " + current);
					stack.pop();
				} else
					return "Not Balanced";
			}
		}
		return stack.isEmpty() ? "Balanced" : "Not Balanced";
	}

}
