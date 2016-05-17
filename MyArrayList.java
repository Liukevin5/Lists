
public class MyArrayList<V extends Comparable<V>> implements MyList<V> {
	private int size;
	private int capacity;
	private Object[] array;

	public MyArrayList() {
		size = 0;
		capacity = 100;
		array = new Object[capacity];
	}

	public int size() {
		return size;
	}

	public void add(V value) {

		if (size + 1 == capacity) {
			int tempCap = capacity + capacity;
			Object[] temp = new Object[tempCap];

			for (int i = 0; i < size; i++) {
				temp[i] = array[i];
			}

			temp[size] = value;
			array = temp;
			capacity = tempCap;
		} else {
			array[size] = value;
		}

		size++;
	}

	public void add(int i, V value) {
		MyArrayList<V> temp = new MyArrayList<V>();
		if (i == 0) {

			temp.add(value);

			for (int j = 0; j < size; j++) {
				temp.add((V) array[j]);
				array = temp.array;
				capacity = temp.capacity;
			}

		} else {
			for (int j = 0; j < size; j++) {
				if (j == i) {
					temp.add(value);
				}
				temp.add((V) (array[j]));
			}
			array = temp.array;
			capacity = temp.capacity;
		}
		size++;
	}

	public void show() {
		System.out.println();
		for (int i = 0; i < size; i++) {
		
			System.out.print(" " + (V) array[i] + " ");
		}
		System.out.println();
	}

	public V[] toArray(V[] arr) {
		V[] temp = (V[]) java.lang.reflect.Array.newInstance(arr.getClass().getComponentType(), size);
		temp = (V[]) array;
		return temp;
	}

	public V remove() {
		V removed;

		if (size == 0) {
			return null;
		}

		array[size - 1] = null;
		removed = (V) array[size - 1];
		size--;

		return removed;
	}


	public V removeFirst() {
		V removed;
		MyArrayList<V> temp = new MyArrayList<V>();

		if (size == 0) {
			return null;
		}
		if (size == 1) {
			array[0] = null;
			return (V) array[0];
		}
		removed = (V) array[0];
		for (int i = 1; i <= size; i++) {
			temp.add((V) array[i]);
		}

		array = temp.array;
		size--;

		return removed;
	}


	public V remove(int i) {
		if( i == 0){
			return removeFirst();
		}
		
		V removed;
		MyArrayList<V> temp = new MyArrayList<V>();
		removed = (V) array[i];
		for (int j = 0; j < size; j++) {
			if (j == i) {
				continue;
			}
			temp.add((V) array[j]);
		}

		array = temp.array;
		size--;
		return removed;
	}

	
	public boolean removeVal(V value, int dummyType) {
		boolean removed = false;
		MyArrayList<V> temp = new MyArrayList<V>();
		
		for(int i = 0 ; i < size; i++){
			
			if(value.equals((V) array[i])){
				remove(i);
				return true;
			}
			
		}
		
		return removed;	
	}

	public V get(int i) {

		return (V) array[i];
	}

}
