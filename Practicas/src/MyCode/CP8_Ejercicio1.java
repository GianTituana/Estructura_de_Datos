package MyCode;
import java.util.ArrayList;

import ADT.ChainHashMap;
import ADT.Double2HashMap;
import ADT.DoubleHashMap;
import ADT.LinkedQueue;
import ADT.ProbeHashMap;
import ADT.Entry;

public class CP8_Ejercicio1 {
	DoubleHashMap<Integer,String> d_hashing=new DoubleHashMap<>();
	ProbeHashMap<Integer,String> l_probing=new ProbeHashMap<>();
	ChainHashMap<Integer,String> s_chaining=new ChainHashMap<>();
	LinkedQueue<Integer> original=new LinkedQueue<>();
	public CP8_Ejercicio1(){
		
	}
	public void addElement(Integer k,String v) {
		original.enqueue(k);
		d_hashing.put(k, v);
		l_probing.put(k, v);
		s_chaining.put(k, v);
	}
	public void printOriginal() {
		for (int i = 0; i < original.size(); i++) {
			int temp=original.dequeue();
			System.out.print(temp+" ");
			original.enqueue(temp);
		}
	}
	public void printResultante(){
		System.out.println("Impresión separated chaining");
		for (Entry<Integer,String> i :s_chaining.entrySet() ) {
			System.out.println(i.getKey()+" "+"value: "+i.getValue());
		}
		System.out.println();
		System.out.println("Impresión linear probing");
		for (Entry<Integer,String> i :l_probing.entrySet() ) {
			System.out.println(i.getKey()+" "+"value: "+i.getValue());
		}
		System.out.println();
		System.out.println("Impresión double hashing");
		for (Entry<Integer,String> i :d_hashing.entrySet() ) {
			System.out.println(i.getKey()+" "+"value: "+i.getValue());
		}
	}
}
