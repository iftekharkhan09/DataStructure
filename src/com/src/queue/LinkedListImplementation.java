package com.src.queue;
import java.util.Scanner;
public class LinkedListImplementation<T> {
	private Node<T> startNode;
	private int size;
	private class Node<T> {
		private T data;
		private Node<T> nextNode;

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node<T> nextNode) {
			this.nextNode = nextNode;
		}
	}
	private T deQueue() {
		T removedElement=remove(0);
		return removedElement;
	}
	private T remove() {
		Node<T> temp = startNode;
		Node<T> temp1;
		T removedData = null;
		if (this.size == 0)
			System.out.println("The Linked List is Empty!!");
		else {
			for (int i = 1; i < this.size - 1; i++)
				temp = temp.getNextNode();
			temp1 = temp.getNextNode();
			removedData = temp1.getData();
			temp.setNextNode(null);
			temp1 = null;
			this.size--;
		}
		return removedData;
	}

	private T remove(int index) {
		Node<T> temp = startNode;
		Node<T> temp1;
		T removedData = null;
		if (this.size == 0)
			System.out.println("The Linked List is Empty!!");
		else if (index > this.size) {
			System.out.println("The Index of the element to be removed cannot be greater then the size of the List!");
		} else {
			if (index == 0) {
				if (this.size == 1) {
					removedData = startNode.getData();
					startNode = null;
				} else {
					removedData = startNode.getData();
					startNode = temp.getNextNode();
					temp = null;
				}
				this.size--;
			} else if (index == this.size - 1)
				remove();
			else {
				for (int i = 1; i < index; i++)
					temp = temp.getNextNode();
				temp1 = temp.getNextNode();
				removedData = temp1.getData();
				temp.setNextNode(temp1.getNextNode());
				temp1 = null;
				this.size--;
			}
		}
		return removedData;
	}

	private void display() {
		if (this.size == 0)
			System.out.println("The Linked List is Empty!!");
		else {
			Node<T> temp = startNode;
			while (temp != null) {
				System.out.println(temp.getData());
				temp = temp.getNextNode();
			}
		}
	}

	private void enQue(T data) {
		Node<T> newNode = new Node<T>();
		newNode.setData(data);
		Node<T> temp = startNode;
		if (startNode == null) {
			startNode = newNode;
		} else {
			while (temp.nextNode != null) {
				temp = temp.getNextNode();
			}
			temp.setNextNode(newNode);
		}
		newNode.setNextNode(null);
		this.size++;
	}

	public static void main(String[] args) {
		int input;
		LinkedListImplementation<String> linkedListImplementation = new LinkedListImplementation<>();
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
				linkedListImplementation.enQue(data);
				break;
			case 2:
				System.out.println("The Dequeued Element is :" + linkedListImplementation.deQueue());
				break;
			case 3:
				System.out.println("The Elements of the Queue are :");
				linkedListImplementation.display();
				break;
			case 4:
				System.out.println("The Size of the Queue is : " + linkedListImplementation.size);
				break;
			default:
				break;
			}
		} while (input == 1 || input == 2 || input == 3 || input == 4);
	}
}