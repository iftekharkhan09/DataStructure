package com.src.queue;
import java.util.Comparator;
import java.util.PriorityQueue;
public class PriorityQueueImpl<E> {
	private PriorityQueue<E> queue;
	private int size;
	public PriorityQueueImpl() {
		this.queue = new PriorityQueue<E>(new QueueComparator<E>());
	}
	public static void main(String[] args) {
		PriorityQueueImpl<Integer> priorityQueueImpl = new PriorityQueueImpl<>();
		priorityQueueImpl.add(2);
		priorityQueueImpl.add(1);
		priorityQueueImpl.add(6);
		// show the elements in the queue
		priorityQueueImpl.show();
		priorityQueueImpl.remove();
		priorityQueueImpl.show();
	}
	private boolean add(E e) {
		queue.add(e);
		this.size++;
		return true;
	}
	private boolean remove() {
		queue.remove();
		this.size--;
		return true;
	}

	private void show() {
		System.out.println(queue);
	}
}
class QueueComparator<E> implements Comparator<E> {
	@Override
	public int compare(E arg0, E arg1) {
		if (new Integer((int) arg0) > new Integer((int) arg1))
			return -1;
		else if (new Integer((int) arg0) < new Integer((int) arg1))
			return 1;
		else
			return 0;
	}
}
