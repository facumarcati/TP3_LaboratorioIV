package Ejercicio1;

public class Principal {

	public static void main(String[] args) {
		
		String ruta = "Personas.txt";
		
		Archivo archivo = new Archivo();
		archivo.setRuta(ruta);

		if(archivo.existe()){
			System.out.println("entró!");
			archivo.leeArchivo();
		}
		else
			System.out.println("no entró");

	}

}
