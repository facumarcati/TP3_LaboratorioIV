package Ejercicio1;

public class Persona {

	public Persona() {
		
	}
	
	public static boolean verificarDniInvalido(String dni) throws DniInvalido {
		
		Boolean auxLetra = false;
		
		for(int i = 0; i < dni.length() ; i++) {
			if(Character.isLetter(dni.charAt(i))) {
				auxLetra = true;
			}
		}
		
		if(auxLetra) {
			DniInvalido exception = new DniInvalido();
			throw exception;
		}
		else {
			return false;
		}
		
	}
}
