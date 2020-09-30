package model.data_structures.Ayuda;




public class Nodo3 <K,V>
{

	public Nodo3<K,V> siguiente;
	public Nodo3<K,V> anterior;
	public K item;
	public V value;
	public boolean color;
	public int size;
	
	public Nodo3(K Pitem,V pValue,boolean pCOlor,int pSize){
		siguiente=null;
		item=Pitem;
		value=pValue;
		color=pCOlor;
		size=pSize;
	}

	public Nodo3<K,V> darSiguiente(){
		return siguiente;
	}

	public void cambiarSiguiente(Nodo3<K,V> pSiguiente){
		siguiente=pSiguiente;
	}

	public K obtenerItem(){
		return item;
	}
	public void cambiarItem(K pItem){
		item=pItem;
	}
}

