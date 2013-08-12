package list;

import java.util.Iterator;

/**
 * @author Andrei Petraru
 * Aug 11, 2013
 */
public class Queue<T> implements Iterable<T> {
	private Node first;
	private Node last;
	private int size;

	/**
	 * Adds an item to the queue
	 * @param item - item added to the queue
	 * @return item added to the queue
	 * @throws IllegalArgumentException on null parameter
	 */
	public T enqueue(T item) {
		if (item == null) {
			throw new IllegalArgumentException("Argument cannot be null");
		}
		Node newLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		}
		else {
			newLast.next = last;
		}
		size++;
		return last.item;
	}

	/**
	 * Removes an item from the queue
	 * @return removed item
	 */
	public T dequeue() {
		if (!isEmpty()) {
			T item = first.item;
			first = first.next;
			size--;
			return item;
		} else {
			return null;
		}
	}

	/**
	 * Finds a key in a queue
	 * @param key - key to be found in the queue
	 * @return true if found, false otherwise
	 */
	public boolean find(T key) {
		if (key == null) {
			return false;
		}
		Node node = first;
		while (node != null) {
			if (node.item.equals(key)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	/**
	 * Size of the queue
	 * @return current size of the queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Checks to see if the queue is empty
	 * @return true if the queue is empty, false otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Removes all elements from the queue	
	 */
	public void clear() {
		first = null;
		last = null;
	}

	/**
	 * Queue iterator
	 * @return an iterator for the queue
	 */
	@Override
	public Iterator<T> iterator() {
		return new QueueInterator();
	}

	private class Node {
		private T item;
		private Node next;
	}

	private class QueueInterator implements Iterator<T> {
		private Node iterNode = first;

		@Override
		public boolean hasNext() {
			return iterNode != null;
		}

		@Override
		public T next() {
			T item = iterNode.item;
			iterNode = iterNode.next;
			return item;
		}

		@Override
		public void remove() {
		}
	}

	public static void main(String[] args) {
		Queue<String> q = new Queue<>();
		q.enqueue("vasile");
		q.enqueue("gigi");
		q.enqueue("ion");
		for (String s : q) {
			System.out.println(s);
			System.out.println(q.dequeue());
		}
	}
}
