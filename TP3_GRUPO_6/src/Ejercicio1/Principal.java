package Ejercicio1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Principal {

	public static void main(String[] args) {
		
		String ruta = "Personas.txt";
		
		Archivo archivo = new Archivo();
		archivo.setRuta(ruta);
		
		if(archivo.existe())
			System.out.println("Existe el archivo");

		
		Persona persona = new Persona();
		
		ArrayList<Persona> lista = archivo.leeArchivo();
		
		System.out.println("--------------------");
		
		ArrayList<Persona> listaNueva = persona.sacarDuplicados2(lista);
		listaNueva = persona.ordenarLista(listaNueva);
		
		for (Persona item : listaNueva) {
			System.out.println(item);
		}
		
	}

}
