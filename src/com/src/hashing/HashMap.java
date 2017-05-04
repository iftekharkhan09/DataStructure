package com.src.hashing;

import javax.print.attribute.standard.RequestingUserName;

public class HashMap<K, V> {
	private class HashNode<K, V> {
		public HashNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

		private K key;
		private V value;
		private HashNode<K, V> nextNode;

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public HashNode<K, V> getNextNode() {
			return nextNode;
		}

		public void setNextNode(HashNode<K, V> nextNode) {
			this.nextNode = nextNode;
		}
	}

	private HashNode[] table;
	private static final int TABLE_SIZE = 25;

	public HashMap() {
		table = new HashNode[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
	}

	private void put(K key, V value) {
		int bucketIndex = (key.hashCode()) % TABLE_SIZE;
		if (table[bucketIndex] == null) {
			table[bucketIndex] = new HashNode<K, V>(key, value);
		} else {
			HashNode entry = table[bucketIndex];
			while (entry != null) {
				if (entry.getKey() == key)
					entry.setValue(value);
				entry = entry.getNextNode();
			}
			entry.setNextNode(new HashNode<K, V>(key, value));
		}
	}

	private V get(K key) {
		int bucketIndex = (key.hashCode()) % TABLE_SIZE;
		HashNode entry = table[bucketIndex];
		if (entry != null) {
			while (entry != null) {
				if (entry.getKey() == key)
					return (V) entry.getValue();
				entry = entry.getNextNode();
			}
		} else {
			return null;
		}
		return null;
	}

	private void remove(K key) {
		int bucketIndex = (key.hashCode()) % TABLE_SIZE;
		HashNode entry = table[bucketIndex];
		if (entry == null) {
			System.out.println("The Key " + key + "Does not exist!");
			return;
		} else {
			HashNode<K, V> prevNode = null;
			while (entry != null && entry.getKey() != key) {
				prevNode = entry;
				entry = entry.getNextNode();
			}
			if (entry.getKey() == key) {
				if (prevNode == null)
					table[bucketIndex] = entry.getNextNode();
				else
					prevNode.setNextNode(entry.getNextNode());
			}
		}
	}

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 3);
		map.put(2, 4);
		map.put(5, 7);
		map.remove(2);
		map.put(2, 7);
		Integer value = map.get(2);
		if (value != null) {
			System.out.println(value);
		}
	}
}
