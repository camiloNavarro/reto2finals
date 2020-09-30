package model.data_structures.Ayuda;

public class Nodo2<E> {
	private Nodo2<E> siguiente;
	private Nodo2<E> anterior;
	private E item;

	public Nodo2(E item){
		this(item, null, null);
	}
	public Nodo2(E item, Nodo2<E> siguiente, Nodo2<E> anterior){
		this.siguiente = siguiente;
		this.anterior = anterior;
		this.item = item;
		
	}

	public Nodo2<E> darSiguiente(){
		return siguiente;
	}

	public void cambiarSiguiente(Nodo2<E> pSiguiente){
		siguiente=pSiguiente;
	}

	public E obtenerItem(){
		return item;
	}
	public void cambiarItem(E pItem){
		item=pItem;
	}
	public Nodo2<E> darAnterior() {
		return anterior;
	}
	public void CambiarAnterior(Nodo2<E> pAnterior) {
		anterior = pAnterior;
	}
	public Nodo2<E> getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Nodo2<E> siguiente) {
		this.siguiente = siguiente;
	}
	public Nodo2<E> getAnterior() {
		return anterior;
	}
	public void setAnterior(Nodo2<E> anterior) {
		this.anterior = anterior;
	}
	public E getItem() {
		return item;
	}
	public void setItem(E item) {
		this.item = item;
	}
}