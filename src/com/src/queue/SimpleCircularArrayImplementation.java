package com.src.queue;

import java.util.Scanner;

public class SimpleCircularArrayImplementation<T> {
	private int front, rear, size;
	private String queue[];
	private static int capacity = 5;

	public SimpleCircularArrayImplementation() {
		this.size = 0;
		this.front = -1;
		this.rear = -1;
		this.queue = new String[capacity];
	}

	public SimpleCircularArrayImplementation(int capacity) {
		this.size = 0;
		this.front = -1;
		this.rear = -1;
		this.capacity = capacity;
		this.queue = new String[capacity];
	}

	private void enQue(String data) {
		if (size == capacity - 1)
			throw new IllegalStateException("Queue : Stack Full Exception");
		else {
			rear = (rear + 1) % capacity;
			queue[rear] = data;
			this.size++;
		}
	}

	private void display() {
		for (int i = front + 1; i <= rear; i++)
			System.out.println(queue[i]);
	}

	private String deQueue() {
		if (size == 0)
			throw new IllegalStateException("Queue : Empty Queue Exception");
		else {
			front = (front + 1) % capacity;
			String data = queue[front];
			queue[front] = "null";
			this.size--;
			return data;
		}
	}

	private int getSize() {
		return this.size;
	}

	public static void main(String[] args) {
		int input;
		SimpleCircularArrayImplementation<String> simpleCircularArrayImplementation = new SimpleCircularArrayImplementation<>();
		do {
			System.out.println("------------------Queue Implementation---------------");
			System.out.println("Enter Your Choice :");
			System.out.println("1. Enque");
			System.out.println("2. Deque");
			System.out.println("3. Display Elements of the Queue");
			System.out.println("4. Size of the Queue");
			Scanner sc = new Scanner(System.in);
			input = sc.nextInt();
			switch (input) {
			case 1:
				System.out.println("Enter the Element to insert into the queue");
				String data = new Scanner(System.in).next();
				simpleCircularArrayImplementation.enQue(data);
				break;
			case 2:
				System.out.println("The Dequeued Element is :" + simpleCircularArrayImplementation.deQueue());
				break;
			case 3:
				System.out.println("The Elements of the Queue are :");
				simpleCircularArrayImplementation.display();
				break;
			case 4:
				System.out.println("The Size of the Queue is : " + simpleCircularArrayImplementation.getSize());
				break;
			default:
				break;
			}
		} while (input == 1 || input == 2 || input == 3 || input == 4);
	}
}
