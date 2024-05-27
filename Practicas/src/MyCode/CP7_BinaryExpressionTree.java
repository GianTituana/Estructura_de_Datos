package MyCode;

import ADT.LinkedBinaryTree;
import ADT.Position;

public class CP7_BinaryExpressionTree extends LinkedBinaryTree<String> {
	
	public CP7_BinaryExpressionTree() { 
	}
	public double evaluarPolinomio(Position<String> node, double x) { 
		if (this.isExternal(node)) { 
            if (node.getElement().equals("x")) {
                return x; 
            } else {
                return Double.parseDouble(node.getElement()); 
            }
        } else {
            double leftValue = evaluarPolinomio(this.left(node), x);
            double rightValue = evaluarPolinomio(this.right(node), x);
            switch (node.getElement()) {
            	case "/":
            		return leftValue / rightValue;
                case "+":
                    return leftValue + rightValue;
                case "-":
                    return leftValue - rightValue;
                case "*":
                    return leftValue * rightValue;
                default:
                    throw new IllegalArgumentException("no se puede realizar la operacion: " + node.getElement());
            }
        }
	}
	public void imprimirPolinomio() {
		
	}
}
