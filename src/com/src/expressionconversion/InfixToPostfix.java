package com.src.expressionconversion;

public class InfixToPostfix {
	char stack[] = new char[100];
	static int top = 0;

	public static void main(String[] args) {
		InfixToPostfix infixToPostfix = new InfixToPostfix();
		System.out.println("The Postfix Expression is : " + infixToPostfix.convert("a+b*c+d"));
		System.out.println("The Postfix Expression is : " + infixToPostfix.convert("a+b*c*d/f-g"));
	}

	private StringBuffer convert(String expression) {
		StringBuffer output = new StringBuffer();
		int stackElementValue;
		for (int i = 0; i < expression.length(); i++) {
			int operatorPrecedenceValue = getPrecedence(expression.charAt(i));
			if (top == 0)
				stackElementValue = getPrecedence(stack[top]);
			else
				stackElementValue = getPrecedence(stack[top - 1]);
			if (expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '*'
					&& expression.charAt(i) != '/') {
				output.append(expression.charAt(i));
			} else if (stackElementValue < operatorPrecedenceValue || top == 0) {
				stack[top++] = expression.charAt(i);
			} else {
				StringBuffer stringBuffer = popedString(stack, top - 1, expression.charAt(i));
				output.append(stringBuffer);
			}
		}
		for (int i = top; i >= 0; i--) {
			output.append(stack[i]);
		}
		return output;
	}

	private StringBuffer popedString(char stack[], int j, char c) {
		StringBuffer popedString = new StringBuffer();
		int characterPrecedence = getPrecedence(c);
		while (j >= 0 && characterPrecedence <= getPrecedence(stack[j])) {
			popedString.append(stack[j]);
			stack[top--] = '\n';
			j--;
		}
		System.out.println("Poped String is " + popedString);
		stack[top + 1] = c;
		return popedString;
	}

	private int getPrecedence(char ch) {
		switch (ch) {
		case '-':
			return 1;
		case '+':
			return 2;
		case '*':
			return 3;
		case '/':
			return 4;
		default:
			break;
		}
		return 0;
	}
}
