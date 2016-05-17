import java.util.Arrays;

public class SinglyLinkedList<V extends Comparable<V>> implements MyList<V> {

	private int size;
	Node head;

	public SinglyLinkedList() {
		size = 0;
		head = new Node(null);
	}

	public int size() {
		return size;
	}

	public void add(V value) {

		if (size == 0) {
			head = new Node(value);
		} else {
			Node itterate = head;
			for (int i = 0; i < size - 1; i++) {
				itterate = itterate.next;
			}
			itterate.next = new Node(value);
		}

		size++;
	}

	public void add(int index, V value) {
		Node temp = new Node(value);

		if (index == 0) {
			temp.next = head;
			head = temp;
			size++;
			return;
		}
		if (index == 1) {
			temp.next = head.next;
			head.next = temp;
			size++;
			return;
		}

		Node itterate1 = head;
		Node itterate2 = head.next;

		for (int i = 0; i < index - 1; i++) {
			itterate1 = itterate1.next;
			itterate2 = itterate2.next;
		}

		temp.next = itterate2;
		itterate1.next = temp;

		size++;

	}

	public V[] toArray(V[] a) {
		V[] array = (V[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);

		for (int i = 0; i < size; i++) {
			array[i] = get(i);
		}
		return array;

	}

	public V remove() {
		V removed;

		if (size == 0) {
			return null;
		}

		if (size == 1) {
			removed = head.value;
			head = null;
			size--;
			return removed;
		}

		Node itterate = head;

		for (int i = 0; i < size - 2; i++) {
			itterate = itterate.next;
		}

		removed = itterate.next.value;
		itterate.next = null;
		size--;
		return removed;
	}

	public V get(int i) {
		V value = null;
		Node itterate = head;

		if (size < i + 1) {
			return null;
		}
		for (int j = 0; j < i; j++) {
			itterate = itterate.next;
		}
		return itterate.value;
	}

	public V remove(int i) {
		V removed;

		if ((size - 1) < i)
			return null;

		if (i == 0) {

			removed = removeFirst();
			return removed;
		}
		
		Node itterate = head;

		for (int j = 0; j < i - 1; j++) {
			itterate = itterate.next;
		}

		removed = itterate.next.value;
		itterate.next = itterate.next.next;
		size--;
		return removed;
	}

	public V removeFirst() {
		V removed;
		if (size == 0)
			return null;
		removed = head.value;
		head = head.next;
		size--;
		return removed;
	}

	public boolean removeVal(V value, int dummyType) {
		int index;
		boolean removed = false;
		Node itterate = head;
		for (int i = 0; i < size - 1; i++) {
			if (value.equals(itterate.value)) {
				removed = true;
				remove(i);
				return removed;
			}
			itterate = itterate.next;
		}

		return removed;
	}

	public void show() {
		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.print(" " + get(i) + " ");
		}
		System.out.println();
	}

	private class Node {

		protected Node next;
		protected V value;

		Node(V val) {
			value = val;
			next = null;
		}

	}

}
