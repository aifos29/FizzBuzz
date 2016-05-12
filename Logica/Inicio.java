package Logica;

public class Inicio {

	public static void main (String [] args){
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(modelo);
		
		View.Pantalla_Juego Juego = new View.Pantalla_Juego(controlador);
		modelo.limpiar();
		modelo.addContactView(Juego);
		modelo.mostrar_opciones();
		
		
	}
}
