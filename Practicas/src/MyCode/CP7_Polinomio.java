package MyCode;

import ADT.LinkedBinaryTree;
import ADT.Position;

public class CP7_Polinomio { 
	LinkedBinaryTree<Double> arbol=new LinkedBinaryTree<>() ;
	LinkedBinaryTree<String> arbol2=new LinkedBinaryTree<>() ;
	double a,b,c;

	public CP7_Polinomio() {
		
	}
	public CP7_Polinomio(double a,double b,double c) {
		Position<Double> root=arbol.addRoot(b);
		arbol.addLeft(root, a);
		arbol.addRight(root, c);
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public double evaluarPolinomio(double x) {
		double a,b,c;
		a=arbol.left(arbol.root()).getElement();
		b=arbol.root().getElement();
		c=arbol.right(arbol.root()).getElement();
		return a*x*x+b*x+c;
	}
	public void imprimirPolinomio() {
		Position<String> root;
		if(Math.signum(b)==1.0) {
			root=arbol2.addRoot("+("+String.valueOf(b)+"*x)");
		}
		else root=arbol2.addRoot("-("+String.valueOf(Math.abs(b))+"*x)");
		if(Math.signum(c)==1.0) {
			arbol2.addRight(root, "+"+String.valueOf(c));
		}
		else arbol2.addRight(root, "-"+String.valueOf(Math.abs(c)));
		arbol2.addLeft(root,"("+String.valueOf(a)+"*x*x)");
		for(Position<String> i:arbol2.inorder()) {
			System.out.print(i.getElement());
		}
	}
}
