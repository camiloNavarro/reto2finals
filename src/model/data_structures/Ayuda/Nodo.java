package model.data_structures.Ayuda;


public class Nodo <E>
{
	private Nodo<E> siguiente;
	private E item;

	public Nodo(E Pitem){
		siguiente=null;
		item=Pitem;
	}

	public Nodo<E> darSiguiente(){
		return siguiente;
	}

	public void cambiarSiguiente(Nodo<E> pSiguiente){
		siguiente=pSiguiente;
	}

	public E obtenerItem(){
		return item;
	}
	public void cambiarItem(E pItem){
		item=pItem;
	}
}

