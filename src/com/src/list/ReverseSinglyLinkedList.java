package com.src.list;

public class ReverseSinglyLinkedList<E> {
	private Node<E> head = null;

	private static class Node<E> {
		public Node(E e, Node next) {
			super();
			this.e = e;
			this.next = next;
		}

		private E e;
		private Node next;
	}

	private Node<E> reverseRecursively(Node<E> current, Node<E> prev) {
		if (current.next == null) {
			head = current;
			current.next = prev;
			return head;
		}
		Node<E> next = current.next;
		current.next = prev;
		reverseRecursively(next, current);
		return head;
	}

	private Node<E> reverseList(Node<E> head) {
		Node<E> prev = null;
		Node<E> current = head;
		Node<E> next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}

	private void addElement(E e) {
		if (getHead() == null) {
			setHead(new Node<E>(e, null));
		} else {
			Node<E> current = getHead();
			Node<E> prev = null;
			while (current != null) {
				prev = current;
				current = current.next;
			}
			prev.next = new Node<E>(e, null);
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
		ReverseSinglyLinkedList<Integer> reverseSinglyLinkedList = new ReverseSinglyLinkedList<>();
		reverseSinglyLinkedList.addElement(1);
		reverseSinglyLinkedList.addElement(2);
		reverseSinglyLinkedList.addElement(3);
		reverseSinglyLinkedList.addElement(4);
		// reverseSinglyLinkedList.display();
		// Node head1 = reverseSinglyLinkedList.reverseList(reverseSinglyLinkedList.getHead());
		// reverseSinglyLinkedList.display(head1);

		Node node1 = reverseSinglyLinkedList.reverseRecursively(reverseSinglyLinkedList.getHead(), null);
		reverseSinglyLinkedList.display(node1);

	}

	public Node<E> getHead() {
		return head;
	}

	public void setHead(Node<E> head) {
		this.head = head;
	}
}
