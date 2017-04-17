package com.src.list;

public class DoubleLinkedList<T> {
	Node<T> startNode;
	Node<T> lastNode;
	int size;

	public static void main(String[] args) {
		DoubleLinkedList<Object> doubleLinkedList = new DoubleLinkedList<>();
		doubleLinkedList.add("iftekhar");
		doubleLinkedList.add("Khan");
		doubleLinkedList.add(1, "Ahmed");
		doubleLinkedList.add("Khan");
		doubleLinkedList.add("iftekhar");
		doubleLinkedList.add("iftekhar");
		doubleLinkedList.addFirst("Sunny");
		doubleLinkedList.add("Khan");
		doubleLinkedList.addLast("Babau");
		doubleLinkedList.add("iftekhar");
		doubleLinkedList.add("Khan");
		doubleLinkedList.traverse();
		System.out.println("---------------Traversing from Last---------------");
		System.out.println("The Size of the Linked List is : " + doubleLinkedList.size);
		doubleLinkedList.traverseFromLast();
		System.out.println("---------------Removing the Element----------------");
		doubleLinkedList.remove();
		doubleLinkedList.removeLast();
		doubleLinkedList.remove();
		doubleLinkedList.remove();
		doubleLinkedList.removeFirstOccurence("iftekhar");
		doubleLinkedList.removeLastoccurence("Khan");
		doubleLinkedList.traverse();
	}

	public void add(T item) {
		Node<T> newNode = new Node<T>();
		Node<T> temp = startNode;
		newNode.setItem(item);
		if (this.size == 0) {
			newNode.setNextNode(null);
			startNode = newNode;
			lastNode = newNode;
			this.size++;
		} else {
			for (int i = 0; i < this.size - 1; i++)
				temp = temp.getNextNode();
			temp.setNextNode(newNode);
			newNode.setPrevNode(temp);
			newNode.setNextNode(null);
			lastNode = newNode;
			this.size++;
		}
	}

	private void add(int index, T item) {
		Node<T> temp = startNode;
		Node<T> temp1;
		if (index == this.size)
			add(item);
		else if (index == 0) {
			Node<T> newNode = new Node<>();
			newNode.setItem(item);
			newNode.setNextNode(temp);
			temp.setPrevNode(newNode);
			startNode = newNode;
			this.size++;
		} else if (index > this.size)
			System.out.println("The index cannot be greater than the Linked List Size!");
		else {
			Node<T> newNode = new Node<>();
			newNode.setItem(item);
			for (int i = 1; i < index - 1; i++)
				temp = temp.getNextNode();
			temp1 = temp.getNextNode();
			temp.setNextNode(newNode);
			newNode.setPrevNode(temp);
			newNode.setNextNode(temp1);
			temp1.setPrevNode(newNode);
			this.size++;
		}
	}

	private void addFirst(T item) {
		add(0, item);
	}

	private void addLast(T item) {
		add(this.size, item);
	}

	private void traverse() {
		Node<T> temp = startNode;
		while (temp != null) {
			System.out.println(temp.getItem());
			temp = temp.getNextNode();
		}
	}

	private void traverseFromLast() {
		Node<T> temp = lastNode;
		while (temp != null) {
			System.out.println(temp.getItem());
			temp = temp.getPrevNode();
		}
	}

	private T remove() {
		Node<T> temp = lastNode;
		Node<T> temp1;
		T removeditem = null;
		if (this.size == 0)
			System.out.println("The Linked List is Empty");
		else if (this.size == 1) {
			removeditem = temp.getItem();
			temp = null;
			startNode = null;
			lastNode = null;
			this.size--;
		} else {
			temp1 = temp.getPrevNode();
			temp1.setNextNode(null);
			lastNode = temp1;
			removeditem = temp.getItem();
			temp = null;
			this.size--;
		}
		return removeditem;
	}

	private T remove(int index) {
		Node<T> temp = startNode;
		Node<T> temp1, temp2;
		T removedItem = null;
		if (this.size == 0)
			System.out.println("The Linked List is Empty!!");
		else if (index == this.size)
			remove();
		else if (index > this.size)
			System.out.println(
					"The Index of the Element to be removed cannot be greater than the Size of the Linked List!!");
		else if (index == 0) {
			startNode = temp.getNextNode();
			temp = null;
			this.size--;
		} else {
			for (int i = 1; i < index; i++) {
				temp = temp.getNextNode();
			}
			temp2 = temp.getNextNode();
			removedItem = temp2.getItem();
			temp1 = temp.getNextNode().getNextNode();
			temp.setNextNode(temp1);
			temp1.setPrevNode(temp);
			temp2 = null;
			this.size--;
		}
		return removedItem;
	}

	private T removeFirst() {
		return remove(0);
	}

	private T removeLast() {
		return remove();
	}
	private boolean removeFirstOccurence(T item) {
		Node<T> temp = startNode;
		int pos = 0;
		boolean flag = false;
		int index = 0;
		while (temp != null) {
			if (temp.getItem().equals(item)) {
				index = pos;
				flag = true;
				break;
			}
			pos++;
			temp = temp.getNextNode();
		}
		if (flag)
			remove(index);
		else
			System.out.println("The Item " + item + " Cannot be found in the Linked List!!");
		return flag;
	}
	private boolean removeLastoccurence(T item) {
		Node<T> temp = startNode;
		Node<T> temp1=lastNode;
		int pos = this.size-1;
		boolean flag = false;
		int index = 0;
		while (temp1 != temp) {
			if (temp.getItem().equals(item)) {
				index = pos;
				flag = true;
				break;
			}
			pos--;
			temp = temp.getNextNode();
		}
		if (flag) 
			remove(index);
		else
			System.out.println("The Item " + item + " Cannot be found in the Linked List!!");
		return flag;
	}
	private class Node<T> {
		private T item;
		private Node<T> nextNode;
		private Node<T> prevNode;

		public Node<T> getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node<T> nextNode) {
			this.nextNode = nextNode;
		}

		public T getItem() {
			return item;
		}

		public void setItem(T item) {
			this.item = item;
		}

		public Node<T> getPrevNode() {
			return prevNode;
		}

		public void setPrevNode(Node<T> prevNode) {
			this.prevNode = prevNode;
		}
	}
}