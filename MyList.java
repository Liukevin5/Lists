
public interface MyList<V extends Comparable<V>> {

	int size();

	void add(V value);

	void add(int i, V value);

	V[] toArray(V[] array);

	V remove();

	V removeFirst();

	V remove(int i);

	boolean removeVal(V value, int dummyType);

	V get(int i);

}
