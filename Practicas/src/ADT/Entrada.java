package ADT;

public class Entrada<K,V> implements Entry<K,V> {
	K key;
	V value;
	public Entrada(K key, V value) {
		this.key=key;
		this.value=value;
	}
	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	
	public V setValue(V newValue) {
		V old = value;
		value = newValue;
		return old;
	}

}
