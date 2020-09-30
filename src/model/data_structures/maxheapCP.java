package model.data_structures;

import java.util.Comparator;
import java.util.Iterator;

public class maxheapCP<T> implements Iterable<T> {
	T [] datos;
	int tamaño;
	private Comparator<T> comparator;
	

	public maxheapCP(int initCapacity ){
		datos = (T[]) new Object[initCapacity + 1];
		tamaño = 0;
		

	}
	public int darNumElementos(){
		return tamaño;
	}
	public boolean isEmpty() {
		return tamaño == 0;
	}
	public void agregar(T elemento){
		if(tamaño == datos.length){
			resize(datos.length*2);
		}
		datos[++tamaño]	 = elemento;
		swim(tamaño);
	}

	public T EliminarMax ()
	{
		T max = datos[1];
		exch(1, tamaño--);
		sink(1);
		datos[tamaño+1] = null;
		return max;
	}

	public T darMaximo(){
		return datos[1];
	}
	private void sink (int k)
	{
		while (2*k <= tamaño)
		{
			int j = 2*k;
			if (j < tamaño && less(j, j+1))
				j++;
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}
	public void resize(int capacity) {
		assert capacity > tamaño;
		T[] temp = (T[]) new Object[capacity];
		for (int i = 1; i <= tamaño; i++) {
			temp[i] = datos[i];
		}
		datos = temp;
	}

	private void swim(int k) {

		{
			while (k > 1 && less(k/2, k))
			{
				exch(k, k/2);
				k = k/2;
			}
		}

	}
	private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<T>) datos[i]).compareTo(datos[j]) < 0;
        }
        else {
            return comparator.compare(datos[i], datos[j]) < 0;
        }
    }


	private void exch (int i, int j)
	{
		T t = datos[i];
		datos[i] = datos[j];
		datos[j] = t;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}

