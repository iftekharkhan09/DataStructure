package com.src.hashing;

public class HashTableImpl {
	class NodeList {
		private NodeList nextNode;
		private int key;
		private Object value;

		public NodeList getNextNode() {
			return nextNode;
		}

		public void setNextNode(NodeList nextNode) {
			this.nextNode = nextNode;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}
	}

	public class HashTableEntry {
		private NodeList startNode;
		private int blockcount;

		public NodeList getNodeList() {
			return startNode;
		}

		public void setNodeList(NodeList startNode) {
			this.startNode = startNode;
		}

		public int getBlockcount() {
			return blockcount;
		}

		public void setBlockcount(int blockcount) {
			this.blockcount = blockcount;
		}
	}

	public class hashtable {
		private int tSize;
		private HashTableEntry[] hashTableEntries;
		public int gettSize() {
			return tSize;
		}
		public void settSize(int tSize) {
			this.tSize = tSize;
		}
		public HashTableEntry[] getHashTableEntries() {
			return hashTableEntries;
		}

		public void setHashTableEntries(HashTableEntry[] hashTableEntries) {
			this.hashTableEntries = hashTableEntries;
		}
	}
	public static void main(String[] args) {
	}

}
