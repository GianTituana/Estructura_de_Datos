package MyCode;

import ADT.LinkedBinaryTree;
import ADT.LinkedStack;
import ADT.Node;

public class CP6_BinaryExpressionTree{
	
}



//else {
//	switch(caracterEvaluado) {
//	case '(':
//		pilaOperadores.push(token);
//		break;
//	case ')':
//		while(!pilaOperadores.isEmpty() && !pilaOperadores.top().getElement().equals('(')) {
//			op2=pilaExpresiones.pop();
//			op1=pilaExpresiones.pop();
//			op=pilaOperadores.pop();
//			op=this.createNode(null, op,op1,op2);
//			pilaExpresiones.push(op);
//		}
//		pilaOperadores.pop(); //quito los paréntesis de mi pila de operadores
//		break;
//	default:
//		while(!pilaOperadores.isEmpty() && prioridad(caracterEvaluado)<=prioridad(pilaOperadores.top().getElement())) {
//			op2=pilaExpresiones.pop();
//			op1=pilaExpresiones.pop();
//			op=pilaOperadores.pop();
//			op=this.createNode(null, op,op1,op2);
//			pilaExpresiones.push(op);
//		}
//		pilaOperadores.push(token);
//	}
//}
//}
//while(!pilaOperadores.isEmpty()) { //todavía quedan elementos
//op2=pilaExpresiones.pop();
//op1=pilaExpresiones.pop();
//op=pilaOperadores.pop();
//op=this.createNode(null, op,op1,op2);
//pilaExpresiones.push(op);
//}
//op=pilaExpresiones.pop();
//return op;
//}