package Ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Archivo {

	private String ruta;

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	public boolean existe() {
		File archivo = new File(ruta);
		if(archivo.exists()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public ArrayList<String> leeArchivo() {
		FileReader entrada;
		ArrayList<String> personas = new ArrayList<>();
		
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
			
			String linea = "";
			while(linea != null) {
				//System.out.println(linea);
				linea = miBuffer.readLine();
				personas.add(linea);
				
			}
			miBuffer.close();
			entrada.close();
			
			return personas;
			
		} catch (Exception e) {
			System.out.println("No se encontro archivo");
		}
		
		return null;
	}
	
}
