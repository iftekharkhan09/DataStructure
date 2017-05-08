package com.src.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTraversal<T> {
	Node<T> root;

	public BreadthFirstTraversal() {
		root = null;
	}

	private void breadthFirstTraversal(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.print(tempNode.data + " ");
			if (tempNode.leftNode != null)
				queue.add(tempNode.leftNode);
			if (tempNode.rightNode != null)
				queue.add(tempNode.rightNode);
		}
	}

	public static void main(String[] args) {
		BreadthFirstTraversal<Integer> breadthFirstTraversal = new BreadthFirstTraversal<>();
		breadthFirstTraversal.root = new Node(1);
		breadthFirstTraversal.root.leftNode = new Node(2);
		breadthFirstTraversal.root.rightNode = new Node(3);
		breadthFirstTraversal.root.leftNode.leftNode = new Node(4);
		breadthFirstTraversal.root.leftNode.rightNode = new Node(5);
		System.out.println("BreadthFirts Traversal---------");
		breadthFirstTraversal.breadthFirstTraversal(breadthFirstTraversal.root);
	}

}
