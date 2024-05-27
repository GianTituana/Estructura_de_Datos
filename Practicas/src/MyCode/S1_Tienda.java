package MyCode;

import ADT.SplayTreeMap;

public class S1_Tienda extends SplayTreeMap<Integer, S1_Articulo>{
	public S1_Tienda() {
		
	}
	public S1_Articulo putArticulo(S1_Articulo a) {
		return put(a.getPrecio(), a);
	}
	public S1_Articulo getArticulo(Integer key) {
		return get(key);
	}
	public S1_Articulo removeArticulo(Integer key) {
		return remove(key);
	}
	public void articulosMasVendidos() {
		
	}
}
