package MyCode;
import ADT.LinkedStack;

public class CP3_Funciones {

	public static void transfer(LinkedStack S, LinkedStack T){
		int Ssize=S.size();
		for(int i=0;i<Ssize;i++) T.push(S.pop()); //elimino el elemento de S
		}
}
