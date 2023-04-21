package Ejercicio1;

public class Persona {
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}

	private String nombre;
	private String apellido;
	private String dni;
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Persona() {
		
	}
	
	public Persona(String nombre, String apellido, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
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
