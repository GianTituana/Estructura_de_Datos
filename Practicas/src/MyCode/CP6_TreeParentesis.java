package MyCode;

import ADT.LinkedTree;
import ADT.Position;

public class CP6_TreeParentesis<E>extends LinkedTree<E> {
	public String preOrder(Position<E> p, int indent) {
		String s="";
		for (int i = 0; i < indent; i++) s+="\t";
		if(this.isInternal(p)) { //es decir tiene nodos hijos
			s+=p.getElement().toString()+"(\n"; //solo si tiene nodos hijos abro paréntesis
			indent++; //porque los proximos hijos deberán tener indentación
			for(Object o:this.children(p)) { //llamo a sus hijos
				s+=preOrder((Position<E>)o,indent);  //uso recursividad para hacer lo mismo
			}
			indent--; //si no pongo esto se imprimen al último un tab más a la derecha
			for (int i = 0; i < indent; i++) s+="\t"; //para tener el mismo número de tabs del padre
			s+=")\n";
		}else
			s+=p.getElement().toString()+"\n"; //nodo externo no pongo ( solo \n
		return s;
	}
}
