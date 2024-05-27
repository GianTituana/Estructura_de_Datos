package ADT;

import java.util.ArrayList;

public class Double2HashMap<K,V> {
	 public int capacity;
	    private int size;
	    public Map<K, V>[] table;

	    public Double2HashMap(int capacity) {
	        this.capacity = capacity;
	        this.size = 0;
	        this.table = new Map[capacity];
	    }
	    public Double2HashMap() {
	        this.capacity=13;
	        this.size=0;
	        this.table=new Map[capacity];
	        
	    }
	    public int size() {
	        return size;
	    }

	    public boolean isEmpty() {
	        return size() == 0;
	    }

	    public boolean containsKey(K key) {
	        int index = getHash(key);
	        int jump = getJump(key);
	        int count = 0;
	        while (table[index] != null && !table[index].containsKey(key) && count < capacity) {
	            index = (index + jump) % capacity;
	            count++;
	        }
	        return table[index] != null && table[index].containsKey(key);
	    }

	    public V get(K key) {
	        int index = getHash(key);
	        int jump = getJump(key);
	        int count = 0;
	        while (table[index] != null && !table[index].containsKey(key) && count < capacity) {
	            index = (index + jump) % capacity;
	            count++;
	        }
	        return table[index] != null ? table[index].get(key) : null;
	    }

	    public void put(K key, V value) {
	        if (size == capacity) {
	            throw new RuntimeException("Map is full");
	        }
	        int index = getHash(key);
	        int jump = getJump(key);
	        int count = 0;
	        while (table[index] != null && !table[index].containsKey(key) && count < capacity) {
	            index = (index + jump) % capacity;
	            count++;
	        }
	        if (table[index] == null) {
	            table[index] = new ChainHashMap<K, V>();
	        }
	        table[index].put(key, value);
	        size++;
	    }

	    public V remove(K key) {
	        int index = getHash(key);
	        int jump = getJump(key);
	        int count = 0;
	        while (table[index] != null && !table[index].containsKey(key) && count < capacity) {
	            index = (index + jump) % capacity;
	            count++;
	        }
	        if (table[index] != null && table[index].containsKey(key)) {
	            V value = table[index].remove(key);
	            if (table[index].isEmpty()) {
	                table[index] = null;
	            }
	            size--;
	            return value;
	        }
	        return null;
	    }

	    private int getHash(K key) {
	        return Math.abs(key.hashCode() % capacity);
	    }
	    private int getJump(K key) {
	        return 7 - (Math.abs(key.hashCode()) % 7);
	    }
	    public void printTable() {
	        for (int i = 0; i < capacity; i++) {
	            if (table[i] != null) {
	                for (Entry<K, V> entry : table[i].entrySet()) {
	                    System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
	                }
	            }
	        }
	    }
}

