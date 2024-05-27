package MyCode;

import ADT.Entrada;
import ADT.TreeMap;
import ADT.LinkedBinaryTree;
import ADT.Map;
import ADT.Position;

public class Ex2_Usfq  extends TreeMap<Integer,Ex2_Estudiante>{
	public Ex2_Usfq() {
	}
	public Ex2_Estudiante searchEstudiante(int codigo) { //treesearch es en logn por eso es eficiente para este caso
		return get(codigo);
	}
	public Ex2_Estudiante putEstudiante(Ex2_Estudiante p) {
		return put(p.getCodigo(),p);//retorna el antiguo estudiante en esa posición
	}
	public Ex2_Estudiante removeEstudiante(int codigo) {
		return remove(codigo);//retorna el antiguo estudiante en esa posición
	}
}
