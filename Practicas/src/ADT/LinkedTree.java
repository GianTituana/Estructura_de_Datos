package ADT;

import java.util.ArrayList;
import java.util.List;

import ADT.LinkedBinaryTree.Node;

public class LinkedTree<E> extends AbstractTree<E> {
	 protected static class Node<E> implements Position<E> {
		    private E element;          // an element stored at this node
		    private Node<E> parent;     // a reference to the parent node (if any)
		    private DoublyLinkedList<Node<E>> childr=new DoublyLinkedList<>();      // a reference to the right child (if any)
		    /**
		     * Constructs a node with the given element and neighbors.
		     *
		     * @param e  the element to be stored
		     * @param above       reference to a parent node
		     * @param leftChild   reference to a left child node
		     * @param rightChild  reference to a right child node
		     */
		    public Node(E e, Node<E> above) {
		      element = e;
		      parent = above;
		     // childr=c;
		    }

		    // accessor methods
		    public E getElement() { return element; }
		    public Node<E> getParent() { return parent; }
		    public DoublyLinkedList<Node<E>>  getChildren() { return childr; }

		    // update methods
		    public void setElement(E e) { element = e; }
		    public void setParent(Node<E> parentNode) { parent = parentNode; }
		    public void setChildren(DoublyLinkedList<Node<E>>c) {childr=c; }
		  } //----------- end of nested Node class -----------
	 		protected Node<E> createNode(E e, Node<E> parent) {
		 		return new Node<E>(e, parent);
	 		}
	 		protected Node<E> root = null;
	 		private int size = 0; 
	 		public LinkedTree() { } 
	 		  protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
	 			    if (!(p instanceof Node))
	 			      throw new IllegalArgumentException("Not valid position type");
	 			    Node<E> node = (Node<E>) p;       // safe cast
	 			    if (node.getParent() == node)     // our convention for defunct node
	 			      throw new IllegalArgumentException("p is no longer in the tree");
	 			    return node;
	 			  }
	 		 @Override
	 		  public int size() {
	 		    return size;
	 		  }
	 		@Override
	 		 public Position<E> root() {
	 		    return root;
	 		  }
	 		 @Override
	 		  public Position<E> parent(Position<E> p) throws IllegalArgumentException {
	 		    Node<E> node = validate(p);
	 		    return node.getParent();
	 		  }
	 		 public E set(Position<E> p, E e) throws IllegalArgumentException {
	 		    Node<E> node = validate(p);
	 		    E temp = node.getElement();
	 		    node.setElement(e);
	 		    return temp;
	 		  }
			@Override
			public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
				 Node<E> node = validate(p);
				 ADT.Node<Node<E>> temp=node.getChildren().getHeader().getNext();
				 int list_size=node.getChildren().size();
				 List<Position<E>> childrenPositions = new ArrayList<>();
				 for (int i = 0; i <list_size ; i++) {
					childrenPositions.add(temp.getElement());
					temp=temp.getNext();
				}
				  return childrenPositions;
			}
			  public Position<E> addRoot(E e) throws IllegalStateException {
				    if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
				    root = createNode(e, null);
				    size = 1;
				    return root;
			  }
			  public Position<E> addChild(Position<E> p, E e) 
                      throws IllegalArgumentException {
				  		Node<E> parent = validate(p);
				  		Node<E> child = createNode(e, parent);
				  		parent.getChildren().addLast(child); //lo añado al arregoo de hijos
				  		size++;
				  		return child;
			  	}
			  public boolean hasChildren(Node<E>p) {
				  if(p.getChildren()!=null) {
					  return true;
				  }
				  return false;
			  }
}
