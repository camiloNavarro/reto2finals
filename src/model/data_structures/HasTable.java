package model.data_structures;

public class HasTable<T> {
	
	private final Integer tam = 1033;
	
	private T[] ht;
	
	public HasTable(){
		
		ht = (T[]) new Comparable [tam];
		for(int i=0; i<ht.length;ht[i]=null);
	}
	
	public Integer hash(Integer k)
	{
		Integer key = k % tam;
		return key;
	}
	
	public void agregar(Integer k, T dato){
		
		int key =k;
		if(ht[key]==null){
			ht[key]=dato;
		}
		else{
			k++;
			agregar(key, dato);
		}
		
	}
	
    public void eliminar(Integer k){
		
    	ht[k]=null;
    	
	}
    
    public T buscar(Integer k){
		
    	return ht[k];
    	
	}
	
	

}
