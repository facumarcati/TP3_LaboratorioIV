package Ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	
	public ArrayList<String> leeArchivo() 
	{
		BufferedReader miBuffer = null;
		String linea = "";
		ArrayList<String> personas = new ArrayList<>();
		
		try
		{
			miBuffer = new BufferedReader(new FileReader(ruta));
			
			while(linea != null) 
			{
				linea = miBuffer.readLine();
				
				if(linea != null)
					personas.add(linea);		
			}
			
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(ruta + " no existe");
			return null;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			if(miBuffer != null)
			{
				try 
				{
					miBuffer.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
		return personas;
	}
	
}
