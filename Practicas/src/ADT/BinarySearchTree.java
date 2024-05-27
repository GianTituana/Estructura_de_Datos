package ADT;

public class BinarySearchTree<V> extends LinkedBinaryTree<Entrada<Integer,V>> implements Map<Integer,V> {
	
	public V getVal(int key, Position<Entrada<Integer,V>> p) {
		Node<Entrada<Integer,V>> auxNode= validate(p);
		
		if(auxNode.getElement().getKey()==key) {
			return auxNode.getElement().getValue();
		} else if(key<auxNode.getElement().getKey() && auxNode.getLeft()!=null) {
			return getVal(key, auxNode.getLeft());
		} else if(key>auxNode.getElement().getKey() && auxNode.getRight()!=null) {
			return getVal(key, auxNode.getRight());
		}
		return null;
	}
	public Node<Entrada<Integer,V>> getNode(int key, Position<Entrada<Integer,V>> p) {
		Node<Entrada<Integer,V>> auxNode= validate(p);
		if(size()==0) return null;
		if(auxNode.getElement().getKey()==key) {
			return auxNode;
		} else if(key<auxNode.getElement().getKey() && auxNode.getLeft()!=null) {
			return getNode(key, auxNode.getLeft());
		} else if(key>auxNode.getElement().getKey() && auxNode.getRight()!=null) {
			return getNode(key, auxNode.getRight());
		}
		return null;
	}
	
	public V put(int key, V value, Position<Entrada<Integer,V>> p) {
		Node<Entrada<Integer,V>> auxNode= validate(p);
		
		if(size()==0) {
			root= createNode(new Entrada<Integer,V>(key,value),null,null,null);
			
			size++;
			return null;
		}
		
		if(getVal(key,root)==null) {
			
			if(key<auxNode.getElement().getKey()&& auxNode.getLeft()!=null) put(key, value,auxNode.getLeft());
			else if(key<auxNode.getElement().getKey()&& auxNode.getLeft()==null) {
				auxNode.setLeft(createNode(new Entrada<Integer,V>(key,value),auxNode,null,null));
				size++;
			}
			
			if(key>auxNode.getElement().getKey()&& auxNode.getRight()!=null) put(key, value,auxNode.getRight());
			else if(key>auxNode.getElement().getKey()&& auxNode.getRight()==null) {
				auxNode.setRight(createNode(new Entrada<Integer,V>(key,value),auxNode,null,null));
				size++;
				
			}
			return null;
		}
		else {
			return auxNode.getElement().setValue(value);
		}
		
	}
	@Override
	public V get(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(Integer key, V value0) {
		// TODO Auto-generated method stub
		return null;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	private Node<Entrada<Integer,V>> removeNoChild(int key) {
		Node<Entrada<Integer,V>> auxNode = getNode(key, root());
		if(auxNode==null) return null;
		if(auxNode.getParent().getLeft()==auxNode) {
			auxNode.getParent().setLeft(null);
			auxNode.setParent(null);
			return auxNode;
		} else {
			auxNode.getParent().setRight(null);
			auxNode.setParent(null);
			return auxNode;
		}
	}
	private Node<Entrada<Integer,V>> removeOneChild(int key) {
		Node<Entrada<Integer,V>> auxNode = getNode(key, root());
		if(auxNode==null) return null;
		if(auxNode.getParent().getLeft()==auxNode) {
			if(auxNode.getRight()==null) {
				auxNode.getLeft().setParent(auxNode.getParent());
				auxNode.getParent().setLeft(auxNode.getLeft());
				auxNode.setLeft(null);
				auxNode.setParent(null);
				return auxNode;
			} else {
				auxNode.getRight().setParent(auxNode.getParent());
				auxNode.getParent().setLeft(auxNode.getRight());
				auxNode.setRight(null);
				auxNode.setParent(null);
				return auxNode;
			}
		}else {
			if(auxNode.getRight()==null) {
				auxNode.getLeft().setParent(auxNode.getParent());
				auxNode.getParent().setRight(auxNode.getLeft());
				auxNode.setLeft(null);
				auxNode.setParent(null);
				return auxNode;
			} else {
				auxNode.getRight().setParent(auxNode.getParent());
				auxNode.getParent().setRight(auxNode.getRight());
				auxNode.setRight(null);
				auxNode.setParent(null);
				return auxNode;
			}
		}
	}
	private Node<Entrada<Integer,V>> Maximo(Position<Entrada<Integer, V>> p){
		Node<Entrada<Integer,V>> maxNode = validate(p);
		maxNode = maxNode.getLeft();
		while(maxNode.getRight()!= null) {
			maxNode=maxNode.getRight();
		}
		return maxNode;
		
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public V remove(Integer key) {
		Node<Entrada<Integer,V>> auxNode = getNode(key, root());
		if(auxNode==null) {
			return null;
		}
		size++;
		if(auxNode.getLeft()==null && auxNode.getRight()==null) return removeNoChild(key).getElement().getValue();
		else if((auxNode.getLeft()==null && auxNode.getRight()!=null) ||(auxNode.getLeft()!=null && auxNode.getRight()==null) ) return removeOneChild(key).getElement().getValue();
		else {	
			Node<Entrada<Integer,V>> izquierdo = auxNode.getLeft();
			Node<Entrada<Integer,V>> derecho = auxNode.getRight();
			Node<Entrada<Integer,V>> padre = auxNode.getParent();
			Node<Entrada<Integer,V>> max = Maximo(auxNode);
			if(auxNode==root) {
				max.setRight(derecho);
				derecho.setParent(max);
				max.setParent(null);
				root=max;
				auxNode.setParent(null);
				auxNode.setLeft(null);
				auxNode.setRight(null);
				return auxNode.getElement().getValue();
			}
				if(auxNode.getParent().getLeft()==auxNode) {
					auxNode.getParent().setLeft(max);
				}else {
					auxNode.getParent().setRight(max);
				}
				
				max.setRight(derecho);
				derecho.setParent(max);
				
				auxNode.setParent(null);
				auxNode.setLeft(null);
				auxNode.setRight(null);
				return auxNode.getElement().getValue();
				
			 
		}
		
	}
	@Override
	public Iterable<Integer> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Entry<Integer, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean containsKey(Integer key) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
