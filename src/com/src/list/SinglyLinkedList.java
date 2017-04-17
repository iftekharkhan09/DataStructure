package com.src.list;

public class SinglyLinkedList<T> {
	private Node<T> startNode;
	private int size;

	public static void main(String[] args) {
		SinglyLinkedList<Object> singlyLinkedListImpl = new SinglyLinkedList<>();
		singlyLinkedListImpl.add("iftekhar");
		singlyLinkedListImpl.add("khan");
		singlyLinkedListImpl.add(1, "ifte");
		singlyLinkedListImpl.addFirst("Sunny");
		singlyLinkedListImpl.addLast("Dummy");
		singlyLinkedListImpl.addFirst("Sunny");
		singlyLinkedListImpl.addFirst("Dummy");
		singlyLinkedListImpl.add(780);
		singlyLinkedListImpl.traverse();
		System.out.println("The Linked List Size is : " + singlyLinkedListImpl.size);
		System.out.println("---------------------------Removing the Data------------------------");
		singlyLinkedListImpl.remove(2);
		singlyLinkedListImpl.remove();
		singlyLinkedListImpl.removeFirstOccurence("Dummy");
		singlyLinkedListImpl.removeLastOccurence("Sunny");
		singlyLinkedListImpl.traverse();
		System.out.println("The Linked List Size is : " + singlyLinkedListImpl.size);
	}

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

	private void add(T data) {
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

	private void add(int index, T data) {
		Node<T> newNode = new Node<>();
		newNode.setData(data);
		Node<T> temp = startNode;
		Node<T> temp1;
		if (index == 0) {
			startNode = newNode;
			if (this.size == 0) {
				newNode.setNextNode(null);
			} else {
				newNode.setNextNode(temp);
			}
			this.size++;
		} else if (index == this.size) {
			add(data);
		} else {
			for (int i = 0; i < index - 1; i++) {
				temp = temp.getNextNode();
			}
			temp1 = temp.getNextNode();
			temp.setNextNode(newNode);
			newNode.setNextNode(temp1);
			this.size++;
		}
	}

	private void addFirst(T data) {
		add(0, data);
	}

	private void addLast(T data) {
		add(this.size, data);
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

	private T removeFirst() {
		return remove(0);
	}

	private boolean removeFirstOccurence(T data) {
		Node<T> temp = startNode;
		int pos = 0;
		boolean flag = false;
		if (startNode.getData().equals(data)) {
			removeFirst();
			return true;
		} else {
			while (temp != null) {
				if (temp.getData().equals(data)) {
					pos++;
					flag = true;
					break;
				}
				temp = temp.getNextNode();
			}
			if (pos == this.size - 1) {
				remove();
				return true;
			} else if (!flag) {
				System.out.println("The Element "+data+" cannot be found in the list!");
				return false;
			}
			else {
				remove(pos);
				return true;
			}
		}
	}

	private boolean removeLastOccurence(T data) {
		Node<T> temp = startNode;
		int pos = 0;
		int index = 0;
		boolean flag = false;
		while (temp != null) {
			if (temp.getData().equals(data)) {
				flag = true;
				index = pos;
			}
			pos++;
			temp = temp.getNextNode();
		}
		if (flag) {
			remove(index);
			return true;
		}
		else
			System.out.println("The Element "+data+" cannot be found in the list!!");
		return false;
	}

	private void remove(T data) {
		removeFirstOccurence(data);
	}

	private void traverse() {
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
}