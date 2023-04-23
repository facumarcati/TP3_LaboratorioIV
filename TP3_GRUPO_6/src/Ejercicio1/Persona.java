package Ejercicio1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
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
	
	public ArrayList<Persona> sacarDuplicados(ArrayList<Persona> lista){
		ArrayList<Persona> listaNueva = new ArrayList<>();
		
		int cantRepetido = 0;
		boolean repetido = false;
		
		for (int i = 0; i < lista.size(); i++) {
			cantRepetido = 0;
			for (int j = 0; j < lista.size(); j++) {
				if(lista.get(i).equals(lista.get(j))) {
					cantRepetido++;
				}
			}
			if(cantRepetido == 1) {
				listaNueva.add(lista.get(i)); // 10
			}
			if(cantRepetido > 1) {
				repetido = false;
				for (Persona item : listaNueva) {
					if(lista.get(i).equals(item)) {
						repetido = true;
					}
				}
				if(repetido == false) {
					listaNueva.add(lista.get(i));
				}
			}
		}
		//System.out.println(listaNueva.size());
		
		return listaNueva;
	}
	
	public ArrayList<Persona> ordenarLista(ArrayList<Persona> lista)
	{	
		Collections.sort(lista, (Persona p1, Persona p2) -> p1.getApellido().compareTo(p2.getApellido()));
		
		lista.removeIf(p -> {
			try
			{
			return verificarDniInvalido(p.dni);
			}
			catch(DniInvalido e) {				
				return true;
			}
		});
		
		
		return lista;
	}
	
	public ArrayList<Persona> sacarDuplicados2(ArrayList<Persona> lista)
	{
		ArrayList<Persona> listaNueva = new ArrayList<>();
		
		HashSet<Persona> listaAux = new HashSet<Persona>(lista);
		listaNueva.addAll(listaAux);
		System.out.println(listaNueva.size());
		
		return listaNueva;
	}
	
}
