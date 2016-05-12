package Logica;

import java.util.ArrayList;
import java.util.Iterator;

public class Modelo {

	private static ArrayList<Funciones> vistas=new ArrayList<Funciones>();
	private int numero;
	private int fizz_number=5;
	private int buzz_number=3;
	public int tiempo=30;
	

	public Modelo(){
		this(null);
	}

	public Modelo(Funciones vista) {
		if (vistas !=null){
			vistas.add(vista);
		}
		
	}
	

	
	public void preparar_juego(){
		numero=1;
		
		
		Iterator<Funciones> notificar = vistas.iterator();
		while (notificar.hasNext()){
			notificar.next().iniciar(numero,fizz_number,buzz_number,tiempo);
		}
	
		
		
	}
	
	public void controlar_tiempo(){
		if (tiempo>0){
			actualizar_cronometro();
		}
		else{
			terminar_juego();
		}
			
	}
	
	public void evaluar_respuesta(boolean fizz,boolean buzz){
		
		
		switch (divisibilidad()){
		case -1:
			if (!fizz && !buzz){
				continuar();
				break;
			}
			else{
				terminar_juego();
				break;
			}
		case 0:
			if (fizz && buzz){
				continuar();
				break;
			}
			else{
				terminar_juego();
				break;
			}
		case 1:
			if (fizz){
				continuar();
				break;
			}
			else{
				terminar_juego();
				break;
			}
			
		case 2:
			if (buzz){
				continuar();
				break;
			}
			else{
				terminar_juego();
				break;
			}
		}
	}
	
	 
	
	void actualizar_cronometro() {
		Iterator<Funciones> notificar = vistas.iterator();
		while (notificar.hasNext()){
			notificar.next().actualizar_tiempo(tiempo);
		}
		tiempo--;
		if (tiempo<0){
			terminar_juego();
		}
	}
		
	

	void terminar_juego() {
		
		Iterator<Funciones> notificar = vistas.iterator();
		while (notificar.hasNext()){
			notificar.next().terminar();
		}
	}

	private void continuar() {
		tiempo = 30;
		actualizar_cronometro();
		numero ++;
		
	
		Iterator<Funciones> notificar = vistas.iterator();
		while (notificar.hasNext()){
			notificar.next().continuar_jugando(numero);
		}
		
		
	}

	private int divisibilidad(){
		
		
		if (numero%fizz_number==0 && numero%buzz_number==0){
			return 0;
		}
		else{
		if (numero%fizz_number==0){
			return 1;
		}
		if (numero%buzz_number==0){
			return 2;
		}
		}
		return -1;
		
	}
	
	
	public void addContactView(Funciones view){
		if (!vistas.contains(view)){
			vistas.add(view);
		}
	}
	
	public void limpiar (){
		vistas.removeAll(vistas);
	}

	public void mostrar_opciones() {
		Iterator<Funciones> notificar = vistas.iterator();
		while (notificar.hasNext()){
			notificar.next().mostrar_configuración(fizz_number,buzz_number);
		}
		
	}

	public void guardar_cambios(String fizz, String buzz,String tiempo) {
		try{
			if (!fizz.isEmpty()){
				this.fizz_number= Integer.parseInt(fizz);
			}
			if (!buzz.isEmpty()){
				this.buzz_number=Integer.parseInt(buzz);
			}
			if (!buzz.isEmpty()){
				this.tiempo= Integer.parseInt(tiempo);
			}
			this.preparar_juego();
		}
		catch(Exception e){
			this.preparar_juego();
		}
		
	}
	
}
