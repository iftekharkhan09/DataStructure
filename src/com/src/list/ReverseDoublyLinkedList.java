package com.src.list;

public class ReverseDoublyLinkedList<E> {
	private Node<E> head;

	private static class Node<E> {
		public Node(E e, Node<E> next, Node<E> prev) {
			super();
			this.e = e;
			this.next = next;
			this.prev = prev;
		}

		private E e;
		private Node<E> next;
		private Node<E> prev;
	}

	public Node<E> reverse() {
		Node<E> current = head;
		Node<E> prev = null;
		Node<E> next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			current.prev = next;
			prev = current;
			current = next;
		}
		head = prev;
		return head;

	}

	public void swapNode() {
		Node<E> current = head;
		Node<E> next;
		while (current.next != null) {
			Node<E> temp = current;
			next = current.next;
			current.e = next.e;
			next.e = temp.e;
			current = current.next;
		}
	}

	public Node<E> recursivelyReverse(Node<E> current, Node<E> next) {
		Node<E> prev = null;
		if (current.next == null) {
			head = current;
			return head;
		}
		current.next = prev;
		current.prev = next;
		recursivelyReverse(current.next, current.next.next);
		return head;
	}

	public void add(E e) {
		if (head == null) {
			Node<E> current = new Node<E>(e, null, null);
			head = current;
		} else {
			Node<E> current = head;
			Node<E> prev = null;
			while (current != null) {
				prev = current;
				current = current.next;
			}
			Node<E> newNode = new Node<E>(e, null, null);
			prev.next = newNode;
			newNode.prev = prev;
			newNode.next = null;
		}
	}

	private void display(Node<E> head1) {
		Node<E> current = head1;
		while (current != null) {
			System.out.println(current.e);
			current = current.next;
		}
	}

	public static void main(String[] args) {
		ReverseDoublyLinkedList<Integer> reverseDoublyLinkedList = new ReverseDoublyLinkedList<>();
		reverseDoublyLinkedList.add(1);
		reverseDoublyLinkedList.add(2);
		reverseDoublyLinkedList.add(3);
		reverseDoublyLinkedList.add(4);
		// reverseDoublyLinkedList.reverse();
		// Node<Integer> head = reverseDoublyLinkedList.reverse();
		// reverseDoublyLinkedList.swapNode();
		Node<Integer> node = reverseDoublyLinkedList.recursivelyReverse(reverseDoublyLinkedList.getHead(),
				reverseDoublyLinkedList.getHead().next);
		reverseDoublyLinkedList.display(node);
	}

	public Node<E> getHead() {
		return head;
	}

	public void setHead(Node<E> head) {
		this.head = head;
	}
}
