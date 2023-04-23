package Ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

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
	
	public ArrayList<Persona> leeArchivo() 
	{
		BufferedReader miBuffer = null;
		String linea = "";
		ArrayList<Persona> personasList = new ArrayList<Persona>();
		
		try
		{
			miBuffer = new BufferedReader(new FileReader(ruta));
			
			while(linea != null) 
			{
				linea = miBuffer.readLine();
				
				if(linea != null && linea.length() > 0)
				{
					StringTokenizer atributosPersona = new StringTokenizer(linea, "-");
					personasList.add(new Persona(String.valueOf(atributosPersona.nextToken()), 
							String.valueOf(atributosPersona.nextToken()), String.valueOf(atributosPersona.nextToken())));
				}
			}
			
			if(!personasList.isEmpty()){
				ListIterator<Persona> it = personasList.listIterator();
				while (it.hasNext()) {
					Persona obj = it.next();			
					//System.out.println(obj.toString());
				}
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
		
		return personasList;
	}
	
	public boolean crearNuevoArchivo(ArrayList<Persona> lista) {
		
		FileWriter escritura;
		
		try {
			escritura = new FileWriter("Resultado.txt", false);
			BufferedWriter bufferEscritura = new BufferedWriter(escritura);
			
			
			for (int i = 0; i < lista.size(); i++)
			{
				bufferEscritura.write(lista.get(i).toString() + "\n");
			}			
			
			bufferEscritura.close();
			escritura.close();
			
			
			return true;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
