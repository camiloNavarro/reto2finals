package model.data_structures.Ayuda;



import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;




public class Queue1 <T>  implements ListCola<T>{
	private Nodo1<T> primero;
	private Nodo1<T> ultimo;
	private int tamaño;

	public Queue1(){
		primero=null;
		ultimo=null;
	}
	public Queue1(T item){
		primero =new Nodo1<T>(item);
		ultimo=primero;
		tamaño=1;
	}
	public void enqueue (T elem) {
		Nodo1 <T> newNode = new Nodo1<> (elem);
		if (tamaño == 0) {
			primero = newNode;
			ultimo = newNode;
		}
		else {
			Nodo1 <T> oldLast = ultimo;
			oldLast.cambiarSiguiente(newNode);
			ultimo = newNode;
		}
		tamaño++;
	}

	
	   public Iterator<T> iterator()  {
	        return new LinkedIterator(primero);  
	    }

	    // an iterator, doesn't implement remove() since it's optional
	    private class LinkedIterator implements Iterator<T> {
	        private Nodo1<T> current;

	        public LinkedIterator(Nodo1<T> first) {
	            current = first;
	        }

	        public boolean hasNext()  { return current != null;                     }
	        public void remove()      { throw new UnsupportedOperationException();  }

	        public T next() {
	            if (!hasNext()) throw new NoSuchElementException();
	            T item = current.obtenerItem();
	            current = current.darSiguiente(); 
	            return item;
	        }
	    }

	public T dequeue () {
		if (tamaño == 0){
		}

		Nodo1 <T> oldFirst = primero;
		T elem = primero.obtenerItem();
		primero = oldFirst.darSiguiente();
		oldFirst.cambiarSiguiente(null);
		tamaño--;
		return elem;
	}

	public T get(int pos) {
		Nodo1<T> actual=primero;
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
	}}
