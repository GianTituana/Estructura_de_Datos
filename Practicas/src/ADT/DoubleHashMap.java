package ADT;

import java.util.ArrayList;
import ADT.AbstractMap.MapEntry;

public class DoubleHashMap<K,V>{
	 private MapEntry<K,V>[] table;       // a fixed array of entries (all initially null)
	 public int capacity;
	 private int n; //numero de entradas 
	 private MapEntry<K,V> DEFUNCT = new MapEntry<>(null, null); 
	  // provide same constructors as base class
	  /** Creates a hash table with capacity 17 and prime factor 109345121. */
	  @SuppressWarnings({"unchecked"})
	  public DoubleHashMap() {
		  capacity=13; //default capacity
		  table=(MapEntry<K,V>[])new MapEntry[capacity];
		  n=0;
	  }
	  @SuppressWarnings({"unchecked"})
	  public DoubleHashMap(int cap) {
		capacity=cap;
		table=(MapEntry<K,V>[])new MapEntry[cap];
		n=0;
	  }
	  @SuppressWarnings({"unchecked"})
	  protected void createTable() {
	    table = (MapEntry<K,V>[]) new MapEntry[capacity];   // safe cast
	  }
	  private boolean isAvailable(int j) {
		    return (table[j] == null || table[j] == DEFUNCT);
		  }
	  public V put(K k,V v) {
		  return bucketPut(k.hashCode()%capacity, k, v);
	  }
	  public V get(K k) {
		  return bucketGet(k.hashCode()%capacity, k);
	  }
	  public V remove(K k) {
		  return bucketRemove(k.hashCode()%capacity, k);
	  }
	  protected int findSlot(int primaryHash, K key, int j) {
		    int secondaryHash = 7 - (key.hashCode() % 7);
		    int temp = (primaryHash + j * secondaryHash) % capacity;
		    if (isAvailable(temp)) {
		        return temp;  // Se encontró una ranura disponible
		    } else if (table[temp] != null && table[temp].getKey().equals(key)) {
		        return temp; // Se encontró una coincidencia
		    } else {
		        // Continuar la búsqueda recursiva con j incrementado
		        return findSlot(primaryHash, key, j + 1);
		    }
		}

	  protected V bucketPut(int h, K k, V v) {
		    int index = findSlot(h, k, 0);
		    if (isAvailable(index)) { // si está disponible el índice encontrado
		        n++;
		        table[index] = new MapEntry<>(k, v);
		        return null; // no hay un valor anterior
		    } else { // el índice no está disponible es que se ha encontrado una coincidencia
		        V oldValue = table[index].getValue();
		        table[index].setValue(v); // sobrescribir el valor existente
		        return oldValue; // devolver el valor anterior
		    }
		}
	  protected V bucketGet(int h, K k) {
		  int index = findSlot(h, k, 0);
		  if (isAvailable(index)) { //si está disponible significa que me está dando una ranura sin nada es decir, no hubo coincidencia
			 return null; //no encontrado  
		  }else{ //si no está disponible significa que me da la posición donde hubo una coincidencia
				return table[index].getValue();  
			}
	  }
	  protected V bucketRemove(int h,K k) {
		  int index = findSlot(h, k, 0);
		  if (isAvailable(index)) { //si está disponible significa que me está dando una ranura sin nada es decir, no hubo coincidencia
				 return null; //no hay nada que remover
			  }else{ //si no está disponible significa que me da la posición donde hubo una coincidencia
				  V oldValue = table[index].getValue();  
				    table[index] = DEFUNCT;  
				    n--;  
				    return oldValue;
				}
	  }
	  public Iterable<Entry<K,V>> entrySet() {
		  ArrayList<Entry<K,V>> buffer = new ArrayList<>();
		    for (int h=0; h < capacity; h++)
		      if (!isAvailable(h)) buffer.add(table[h]); //si esta ocupado lo añado al buffer
		    return buffer;
	  }
	  
//	  protected V bucketRemove(int h,K k) {
//		  if (!isAvailable(h)) { //si está ocupado comparo llaves
//			  if(table[h].getKey()==k) {
//				  V oldValue = table[h].getValue();  
//				    table[h] = DEFUNCT;  
//				    n--;  
//				    return oldValue;
//			  }
//		  }else{
//				  for(int i=1;i<capacity;i++) {
//					  if(!isAvailable(hashValue(k,i))) {
//							  if(table[hashValue(k,i)].getKey()==k) {
//								  V oldValue = table[hashValue(k,i)].getValue();  
//								    table[hashValue(k,i)] = DEFUNCT;  
//								    n--;  
//								    return oldValue;
//							  }
//					  }
//					}
//				 }
//		  return null; //no encontre o no hay nada que eliminar
//		  }
//	  protected int hashValue(K key,int j) { 
//	  int primaryHash=key.hashCode()%capacity;
//	  int secondaryHash = 7 - (key.hashCode() % 7);
//	  return (primaryHash + j * secondaryHash) % capacity;
//  }
//  protected V bucketPut(int h, K k, V v) {
//	  if (isAvailable(h)) { //h será el hashValue con j=0 pasado por put
//	        n++;  
//	        table[h] = new MapEntry<>(k, v); 
//	        return table[h].getValue(); 
//	    }
//	  else { //si no está disponible verifico si la llave es la misma para sobreescribir el valor o busco otra posición
//	   	if(table[h].getKey()==k) {
//	   		V oldValue = table[h].getValue(); 
//	   		table[h].setValue(v);
//	   		return oldValue; 
//	   	}
//	   	else {
//	   		for(int i=1;i<capacity;i++) {
//				  if(isAvailable(hashValue(k,i))) {
//					  table[i] = new MapEntry<>(k, v); 
//					  return null; //antiguo valor  
//				  }
//			  }
//	   	}
//	 }  
//	  return null;
//  }
//	  protected V bucketGet(int h, K k) {
//	  if (isAvailable(h)) return null; //no hay elemento  
//	  return table[h].getValue(); 
//  }
//  protected V bucketPut(int h, K k, V v) {
//	  if (isAvailable(h)) { 
//	        n++;  
//	        table[h] = new MapEntry<>(k, v); 
//	        return table[h].getValue(); 
//	    }
//	    V oldValue = table[h].getValue(); //sobreescribo el valor
//	    table[h].setValue(v);  
//	    return oldValue;  
//  }
//  protected V bucketRemove(int h,K k) {
//	  if (isAvailable(h)) return null;  //o sea no hay un elemento ahí
//	    V oldValue = table[h].getValue();  
//	    table[h] = DEFUNCT;  
//	    n--;  
//	    return oldValue;
//	  }
//	  protected int findSlot(int primaryHash, K key, int j) {
//	    int secondaryHash = 7 - (key.hashCode() % 7);
//	    int temp = (primaryHash + j * secondaryHash) % capacity;
//	    if (isAvailable(temp)) {
//	        return temp;  // Se encontró una ranura disponible
//	    } if(!isAvailable(temp) && table[temp].getKey()==key) {
//	    	return temp; //significa que hay una concidencia y debería sobreescribir
//	    }
//	    else {
//	        // Continuar la búsqueda recursiva con j incrementado
//	        return findSlot(primaryHash, key, j + 1);
//	    }
//	}
}
