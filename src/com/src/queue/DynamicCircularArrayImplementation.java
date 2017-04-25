package com.src.queue;

import java.util.Scanner;

public class DynamicCircularArrayImplementation<T> {
	private int front, rear, size;
	private String queue[];
	private static final int defaultCapacity = 4;
	private static int capacity = defaultCapacity;

	public DynamicCircularArrayImplementation() {
		this.size = 0;
		this.front = -1;
		this.rear = -1;
		this.queue = new String[capacity];
	}

	public DynamicCircularArrayImplementation(int capacity) {
		this.size = 0;
		this.front = -1;
		this.rear = -1;
		this.capacity = capacity;
		this.queue = new String[capacity];
	}

	private void ensureCapacity() {
		int queueCapacity = Math.max(this.capacity, defaultCapacity);
		int newCapacity = queueCapacity + (queueCapacity >> 1);
		String newQueue[] = new String[newCapacity];
		int j = 1, i = front + 1, k = 0;
		while (j <= this.size) {
			newQueue[k] = queue[i % capacity];
			i++;
			k++;
			j++;
		}
		queue = new String[newCapacity];
		queue = newQueue;
		front = -1;
		rear = this.size - 1;
		this.capacity = newCapacity;
	}

	private void enQueue(String data) {
		if (size >= capacity)
			ensureCapacity();
		rear = (rear + 1) % capacity;
		queue[rear] = data;
		this.size++;
	}

	private void display() {
		int j = 1, i = front + 1;
		while (j <= this.size) {
			System.out.println(queue[i % capacity]);
			j++;
			i++;
		}
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

	/*private void trimToSize() {
		int newCapacity = this.size+1;
		String[] newQueue = new String[newCapacity];
		int j = 1, i = front + 1, k = 0;
		while (j <= this.size) {
			newQueue[k] = queue[i % capacity];
			i++;
			k++;
			j++;
		}
		String[] queue = new String[newCapacity];
		queue = newQueue;
		front = -1;
		rear = this.size - 1;
		this.capacity=newCapacity;
	}*/

	public static void main(String[] args) {
		int input;
		DynamicCircularArrayImplementation<String> dynamicCircularArrayImplementation = new DynamicCircularArrayImplementation<>();
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
				dynamicCircularArrayImplementation.enQueue(data);
				break;
			case 2:
				System.out.println("The Dequeued Element is :" + dynamicCircularArrayImplementation.deQueue());
				break;
			case 3:
				System.out.println("The Elements of the Queue are :");
				dynamicCircularArrayImplementation.display();
				break;
			case 4:
				System.out.println("The Size of the Queue is : " + dynamicCircularArrayImplementation.getSize());
				break;
			default:
				System.out.println("Invalid Choice!!");
			}
		} while (input == 1 || input == 2 || input == 3 || input == 4);
	}

}
