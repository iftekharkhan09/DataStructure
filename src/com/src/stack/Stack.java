package com.src.stack;

import java.util.Scanner;

public class Stack {
	public static void main(String[] args) {
		String stack[] = new String[20];
		int userInput;
		int j = 0;
		do {
			System.out.println("------------------- Stack Implementation -----------------");
			System.out.println("Please enter your choice");
			System.out.println("1. Push Element into the Stack");
			System.out.println("2. Pop Element out of the Stack");
			System.out.println("3. Show the Element of the Stack");
			String input = new Scanner(System.in).next();
			userInput = new Integer(input);
			switch (userInput) {
			case 1:
				System.out.println("Please enter the element to push");
				String pushedElement = new Scanner(System.in).next();
				stack[j] = pushedElement;
				j++;
				break;
			case 2:
				if (j == 0)
					System.out.println("The Stack is Empty");
				else {
					System.out.println("The Poped Out Element is :" + stack[j - 1]);
					stack[j - 1] = null;
					j--;
				}
				break;
			case 3:
				System.out.println("The Element of the Stack is :");
				StringBuffer stackElements = new StringBuffer();
				for (String s : stack) {
					if (s != null)
						stackElements.append(s);
				}
				System.out.println(stackElements.reverse());
			}
		} while (userInput == 1 || userInput == 2 || userInput == 3);
	}
}