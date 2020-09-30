package model.data_structures.Ayuda;



import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Iterator;

import javax.swing.JOptionPane;



public class Cola <T>  implements ListCola<T>{
	private Nodo<T> primero;
	private Nodo<T> ultimo;
	private int tamaño;

	public Cola(){
		primero=null;
		ultimo=null;
	}
	public Cola(T item){
		primero =new Nodo<T>(item);
		ultimo=primero;
		tamaño=1;
	}
	public void enqueue (T elem) {
		Nodo <T> newNode = new Nodo<> (elem);
		if (tamaño == 0) {
			primero = newNode;
			ultimo = newNode;
		}
		else {
			Nodo <T> oldLast = ultimo;
			oldLast.cambiarSiguiente(newNode);
			ultimo = newNode;
		}
		tamaño++;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	public T dequeue () {
		if (tamaño == 0){
		}

		Nodo <T> oldFirst = primero;
		T elem = primero.obtenerItem();
		primero = oldFirst.darSiguiente();
		oldFirst.cambiarSiguiente(null);
		tamaño--;
		return elem;
	}

	public T get(int pos) {
		Nodo<T> actual=primero;
		if(primero!=null){
			int i=0;

			while(actual.darSiguiente()!=null && i!=pos){
				actual=actual.darSiguiente();
				i++;
			}
		}
		return actual.obtenerItem();
	}

	@Override
	public int size() {

		// TODO Auto-generated method stub
		return tamaño;
	}
	@Override
	public boolean isEmpty() {

		return (primero==null);
	}
}