package MyCode;

import java.text.Normalizer;

public class CP5_Funciones {
	 public static double armonico(int n)
	  {
	    if (n == 1) {
	        return 1.0;
	    }
	    else {
	        return armonico(n-1)+(1.0/n);
	    }
	}
	 //eliminar los espacios, eliminar las comas se puede hacer antes de la llamada
	public static boolean esPalindromo(String p) {
		p=normalizarString(p);
		if(p.length()==0 || p.length()==1) return true;//caso base ava
		else 
			if(p.charAt(0)==p.charAt(p.length()-1)) 
				return esPalindromo(p.substring(1,p.length()-1)); //quito la primera2 y la última, p.substring(1, 1).lenght es 0 p.substring(1, 2).length es 1
		return false;
	}
	public static String eliminarDiacriticos(String source){ //quitar tildes
	    source = Normalizer.normalize(source, Normalizer.Form.NFD);
	    return source.replaceAll("[^\\p{ASCII}]", "");
	}
	public static String normalizarString(String p) {
		p=p.toLowerCase().replaceAll("\\s+", "").replaceAll("\\p{Punct}", "");
		return eliminarDiacriticos(p);
	}
	public static void towerOfHanoi(int n, char from_rod, char aux_rod, char to_rod) { 
		if (n == 0) { 
		return; 
		} 
		towerOfHanoi(n - 1, from_rod, to_rod, aux_rod);  //hasta que no sea 1 no le deja pasar
		System.out.println("Move disk " + n + " from rod "
		          + from_rod + " to rod "
		          + to_rod); 
		towerOfHanoi(n - 1, aux_rod, from_rod, to_rod); 
		} 
} 
