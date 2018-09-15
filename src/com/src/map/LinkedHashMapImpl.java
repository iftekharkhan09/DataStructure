package com.src.map;

public class LinkedHashMapImpl<K, V> {
	public LinkedHashMapImpl(int capacity) {
		super();
		this.capacity = capacity;
		this.hashTable = new Entry[capacity];
	}

	private int capacity;
	private Entry<K, V> header;
	private Entry<K, V> hashTable[];

	private static class Entry<K, V> {
		public Entry(K key, V value, Entry<K, V> next, Entry<K, V> prev) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
			this.prev = prev;
		}

		private K key;
		private V value;
		private int hashCode;
		private Entry<K, V> next;
		private Entry<K, V> prev;
	}

	private int hashCode(K key) {
		return key.hashCode();
	}

	private int getBucketIndex(K key) {
		return hashCode(key) & (capacity - 1);
	}

	public void put(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		Entry<K, V> current = hashTable[bucketIndex];
		Entry<K, V> prev = null;
		Entry<K, V> current1 = null;
		if (null == current) {
			hashTable[bucketIndex] = new Entry<K, V>(key, value, null, null);
			current = hashTable[bucketIndex];
		} else {
			if (current.key.equals(key)) {
				current.value = value;
			} else {
				while (current != null) {
					prev = current;
					current = current.next;
				}
				current.next = new Entry<K, V>(key, value, null, null);
			}
		}
		if (header == null) {
			header = current;
			current.prev = null;
		} else {
			current1 = current;
			current = header;
			while (current != null) {
				prev = current;
				current = current.next;
			}
			prev.next = current1;
			current1.prev = prev;
			current1.next = null;
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
		Entry<K, V> headerEntry = header;
		while (headerEntry != null) {
			System.out.println(headerEntry.key + " " + headerEntry.value);
			headerEntry = headerEntry.next;
		}

	}

	public static void main(String[] args) {
		LinkedHashMapImpl<Integer, String> hashMapImpl = new LinkedHashMapImpl<>(20);
		hashMapImpl.put(2, "B");
		hashMapImpl.put(1, "A");
		hashMapImpl.put(1, "AA");
		hashMapImpl.put(18, "C");
		hashMapImpl.remove(18);
		System.out.println(hashMapImpl.get(1));
		hashMapImpl.display();
	}
}
