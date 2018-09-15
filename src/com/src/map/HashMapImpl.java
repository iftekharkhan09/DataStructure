package com.src.map;

public class HashMapImpl<K, V> {
	public HashMapImpl(int capacity) {
		super();
		this.capacity = capacity;
		this.hashTable = new Entry[capacity];
	}

	private int capacity;
	private Entry<K, V> hashTable[];

	private static class Entry<K, V> {
		public Entry(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}

		public Entry(K key, V value, Entry<K, V> next) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
		}

		private K key;
		private V value;
		private int hashCode;
		private Entry<K, V> next;
	}

	private int hashCode(K key) {
		return key.hashCode();
	}

	private int getBucketIndex(K key) {
		return hashCode(key) & (capacity - 1);
	}

	private V remove(K key) {
		Entry<K, V> current = hashTable[getBucketIndex(key)];
		Entry<K, V> prev = null;
		if (null == current) {
			return null;
		} else {
			while (current != null && !current.key.equals(key)) {
				prev = current;
				current = current.next;
			}
			if (current.key.equals(key)) {
				if (prev == null) {
					hashTable[getBucketIndex(key)] = null;
				} else {
					prev.next = current.next;
				}

			}
		}
		return null;
	}

	private void put(K key, V value) {
		boolean duplicate = false;
		int bucketIndex = getBucketIndex(key);
		Entry<K, V> current = hashTable[bucketIndex];
		Entry<K, V> prev = current;
		if (current != null) {
			while (current != null) {
				if (current.key.equals(key)) {
					current.value = value;
					duplicate = true;
				}
				prev = current;
				current = current.next;
			}
			if (!duplicate)
				prev.next = new Entry<K, V>(key, value, null);
		} else {
			hashTable[bucketIndex] = new Entry<K, V>(key, value, null);
		}
	}

	private V get(K key) {
		int bucketIndex = getBucketIndex(key);
		Entry<K, V> current = hashTable[bucketIndex];
		if (current != null) {
			while (current != null) {
				if (current.key.equals(key)) {
					return current.value;
				}
				current = current.next;
			}
		}
		return null;
	}

	public void display() {
		for (int i = 0; i < hashTable.length; i++) {
			Entry<K, V> current = hashTable[i];
			while (current != null) {
				System.out.println(current.key + " " + current.value);
				current = current.next;
			}
		}
	}

	public static void main(String[] args) {
		HashMapImpl<Integer, String> hashMapImpl = new HashMapImpl<>(20);
		hashMapImpl.put(2, "B");
		hashMapImpl.put(1, "A");
		hashMapImpl.put(1, "AA");
		hashMapImpl.put(18, "C");
		hashMapImpl.remove(18);
		hashMapImpl.display();
	}
}
