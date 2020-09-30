package model.data_structures.Ayuda;

public class Nodo1<E> {
	private Nodo1<E> siguiente;
	private Nodo1<E> anterior;
	private E item;

	public Nodo1(E item){
		this(item, null, null);
	}
	public Nodo1(E item, Nodo1<E> siguiente, Nodo1<E> anterior){
		this.siguiente = siguiente;
		this.anterior = anterior;
		this.item = item;
		
	}

	public Nodo1<E> darSiguiente(){
		return siguiente;
	}

	public void cambiarSiguiente(Nodo1<E> pSiguiente){
		siguiente=pSiguiente;
	}

	public E obtenerItem(){
		return item;
	}
	public void cambiarItem(E pItem){
		item=pItem;
	}
	public Nodo1<E> darAnterior() {
		return anterior;
	}
	public void CambiarAnterior(Nodo1<E> pAnterior) {
		anterior = pAnterior;
	}
	public Nodo1<E> getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Nodo1<E> siguiente) {
		this.siguiente = siguiente;
	}
	public Nodo1<E> getAnterior() {
		return anterior;
	}
	public void setAnterior(Nodo1<E> anterior) {
		this.anterior = anterior;
	}
	public E getItem() {
		return item;
	}
	public void setItem(E item) {
		this.item = item;
	}
}