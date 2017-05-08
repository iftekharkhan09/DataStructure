package com.src.tree;

class Node<T> {
	public Node(T data) {
		this.data = data;
		this.leftNode = null;
		this.rightNode = null;
	}

	T data;
	Node<T> leftNode;
	Node<T> rightNode;
}

public class BinaryTreeTraversal<T> {
	Node<T> root;

	public BinaryTreeTraversal() {
		root = null;
	}

	private void inOrderTraversal(Node<T> root) {
		if (root == null)
			return;
		inOrderTraversal(root.leftNode);
		System.out.println(root.data);
		inOrderTraversal(root.rightNode);
	}
	private void preOrderTraversal(Node<T> root) {
		if (root == null)
			return;
		System.out.println(root.data);
		preOrderTraversal(root.leftNode);
		preOrderTraversal(root.rightNode);
	}
	void printInorder() {
		inOrderTraversal(root);
	}
	private void postOrderTraversal(Node<T> root) {
		if (root == null)
			return;
		postOrderTraversal(root.leftNode);
		postOrderTraversal(root.rightNode);
		System.out.println(root.data);
	}

	public static void main(String[] args) {
		BinaryTreeTraversal<Integer> binaryTreeTraversal = new BinaryTreeTraversal<>();
		binaryTreeTraversal.root = new Node(1);
		binaryTreeTraversal.root.leftNode = new Node(2);
		binaryTreeTraversal.root.rightNode = new Node(3);
		binaryTreeTraversal.root.leftNode.leftNode = new Node(4);
		binaryTreeTraversal.root.leftNode.rightNode = new Node(5);
		System.out.println("Inorder Traversal---------");
		binaryTreeTraversal.printInorder();
		System.out.println("Preorder Traversal---------");
		binaryTreeTraversal.preOrderTraversal(binaryTreeTraversal.root);
		System.out.println("PostOrder Traversal---------");
		binaryTreeTraversal.postOrderTraversal(binaryTreeTraversal.root);
	}

}
