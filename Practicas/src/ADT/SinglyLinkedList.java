package ADT;

public class SinglyLinkedList<E>{
	private Node<E> head = null; // head Node of the list (or null if empty)
	 private Node<E> tail = null; // last Node of the list (or null if empty)
	 private int size = 0; // number of Nodes in the list
	 public SinglyLinkedList( ) { } // constructs an initially empty list
	 // access methods
	 public int size( ) { return size; }
	 public boolean isEmpty( ) { return size == 0; }
	 public E first( ) { // returns (but does not remove) the first element
	 if (isEmpty( )) return null;
	 return head.getElement( );
	 }
	 public E last( ) { // returns (but does not remove) the last element
	 if (isEmpty( )) return null;
	 return tail.getElement( );
	 }
	 // update methods
	 public void addFirst(E e) { // adds element e to the front of the list
	 head = new Node<>(e, head); // create and link a new Node
	 if (size == 0)
	 tail = head; // special case: new Node becomes tail also
	 size++;
	 }
	 public void addLast(E e) { // adds element e to the end of the list
	 Node<E> newest = new Node<>(e, null); // Node will eventually be the tail
	 if (isEmpty( ))
	 head = newest; // special case: previously empty list
	 else
	 tail.setNext(newest); // new Node after existing tail
	 tail = newest; // new Node becomes the tail
	 size++;
	 }
	 public E removeFirst( ) { // removes and returns the first element
	 if (isEmpty( )) return null; // nothing to remove
	 E answer = head.getElement( );
	 head = head.getNext( ); // will become null if list had only one Node
	 size--;
	 if (size == 0)
	 tail = null; // special case as list is now empty
	 return answer;
	 }
	 public Node<E> getHead() {
			return head;
	}
	 public Node<E> getTail() {
			return tail;
	}
}
