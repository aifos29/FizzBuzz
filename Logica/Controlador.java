
package Logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import View.Pantalla_Juego;

public class Controlador implements ActionListener {
	private Pantalla_Juego Juego;
	private Modelo modelo;

	

public Controlador(Modelo modelo){
	this.modelo=modelo;
}

public void setPantalla(Pantalla_Juego Interfaz){
	Juego=Interfaz;
}

public Pantalla_Juego getPantalla(){
	return Juego;
}


public void actionPerformed(ActionEvent evt) {
	  
	Object source = evt.getSource();
	if (source==Juego.Tiempo){
		modelo.actualizar_cronometro();
		
		
	}
	if (source==Juego.btnOk){
		boolean buzz=false;
		boolean fizz=false;
		if (Juego.chckbxBuzz.isSelected()){
			buzz=true;
		}
		if (Juego.chckbxFizz.isSelected()){
			fizz=true;
		}
		modelo.evaluar_respuesta(fizz, buzz);
	}
	
	if (source==Juego.mntmNuevoJuego){
		
		modelo.preparar_juego();
		
	}

	
	if (source==Juego.btnGuardarCambios){
		modelo.guardar_cambios(Juego.txtbuzz.getText(),Juego.txtfizz.getText(),Juego.txttiempo.getText());
	}
	
}


	
}



