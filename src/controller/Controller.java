package controller;

import java.text.ParseException;
import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		Integer dato = 0;
		Integer respuesta = 0;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			Scanner entradaEscaner = new Scanner (System.in);
			switch(option){
			
			
				case 1:
					try{
					view.printMessage("---------\nCargando...");
					long startTime =System.currentTimeMillis();
					modelo.cargaDatos();
					long endTime =System.currentTimeMillis();
					long delta = endTime-startTime;
					view.printMessage("---------\nArchivo Cargado tiempo de carga: " + delta + " milisegundo");
					break;
					}catch(Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				case 2: 
					try{
						view.printMessage("diga nombre de la compañia"); 
						String nombreCompa=entradaEscaner.nextLine();
						modelo.requerimiento1(nombreCompa);;
						break;
						}catch(Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				case 3: 
					try{
						view.printMessage("diga nombre del director"); 
						String nombreDirector=entradaEscaner.nextLine();
						modelo.requerimiento2(nombreDirector);;;
						break;
						}catch(Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
				case 4: 
					try{
						view.printMessage("diga nombre del actor"); 
						String nombreDirector=entradaEscaner.nextLine();
						modelo.requerimiento3(nombreDirector);;;
						break;
						}catch(Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
				case 5: 
					try{
						view.printMessage("diga nombre del genero"); 
						String nombreDirector=entradaEscaner.nextLine();
						modelo.requerimiento4(nombreDirector);;;
						break;
						}catch(Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
				case 6: 
					try{
						view.printMessage("diga nombre del pais"); 
						String nombreDirector=entradaEscaner.nextLine();
						modelo.requerimiento5(nombreDirector);;;
						break;
						}catch(Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
				
				case 7: 
					fin=true;
					break;
				
				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
