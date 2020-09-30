package model.data_structures;

import java.util.Iterator;
import java.util.Queue;

import model.data_structures.Ayuda.Nodo3;
import model.data_structures.Ayuda.Queue1;




public class RedBlack1<K extends Comparable<K>, V> {

	private static final boolean RED   = true;
	private static final boolean BLACK = false;
	public Nodo3 principal;
	 private int n;   
	private boolean isRed(Nodo3 x)
	{
		if (x == null)
			return false;
		return x.color == RED;
	}
	public int size(){
		return n;
	}
	  private int size(Nodo3 x) {
	        if (x == null) return 0;
	        return x.size;
	    } 

	public Nodo3 rotateLeft(Nodo3 h)
	{
		Nodo3 x = h.siguiente;
		h.siguiente = x.anterior;
		x.anterior = h;
		x.color = h.color;
		h.color = RED;
		x.size = h.size;

		return x;
	}

	public Nodo3 rotateRight(Nodo3 h)
	{
		Nodo3 x = h.anterior;
		h.anterior = x.siguiente;
		x.siguiente = h;
		x.color = h.color;
		h.color = RED;
		x.size = h.size;
	
		return x;
	}	
	public void flipColors(Nodo3 h)
	{
		h.color = RED;
		h.anterior.color = BLACK;
		h.siguiente.color = BLACK;
	}
	  public void put(K key, V val) {
	        principal = insert(principal, key, val);
	        principal.color = BLACK;
	       
	    }
	 
	private Nodo3 insert(Nodo3 h, K key, V val) { 
        
		if (h == null){
			
			n++;
			return new Nodo3(key, val, RED, 1);

		}
        	
        int cmp = key.compareTo((K) h.item);
        if      (cmp < 0) h.anterior  = insert(h.anterior,  key, val); 
        else if (cmp > 0) h.siguiente = insert(h.siguiente, key, val); 
        else              h.value   = val;

        // fix-up any right-leaning links
        if (isRed(h.siguiente) && !isRed(h.anterior))      h = rotateLeft(h);
        if (isRed(h.anterior)  &&  isRed(h.anterior.anterior)) h = rotateRight(h);
        if (isRed(h.anterior)  &&  isRed(h.siguiente))     flipColors(h);


        return h;
    }
	 public boolean isEmpty() {
	        return n == 0;
	    }
	 
	public V get(K key){
		return get(principal,key);
	}
	 private V get(Nodo3 x, K key) {
	        while (x != null) {
	            int cmp = key.compareTo((K) x.item);
	            if      (cmp < 0) x = x.anterior;
	            else if (cmp > 0) x = x.siguiente;
	            else              return (V) x.value;
	        }
	        return null;
	    }
	 public boolean contains(K key){
		 return contains(principal,key);
	 }
	   private boolean contains(Nodo3 x,K key) {
	        return get(x,key) != null;
	    }
	  public int height(){
		  return height(principal);
	  }
	   	
	  private int height(Nodo3 x) {
		  
	        if (x == null)
	        	return -1;
	        return (1 + Math.max(height(x.anterior), height(x.siguiente)));
	    }
	  public int getHeight(K key){
		  return getHeight(principal,key);
	  }
	  private int getHeight(Nodo3 x,K key) {
	        if (contains(x,key)==false) return -1;
	        int a=0;
	        int cmp = key.compareTo((K) x.item);
            if      (cmp < 0){
            	a=1+getHeight(x.anterior,key);
            }
            else if (cmp > 0){
            	a=1+getHeight(x.siguiente,key);
            }else if(cmp==0){
            	a=1;
            }
	        return a ;
	    }
	  public Nodo3 min(){
		  return min(principal);
	  }
	  public Nodo3 max(){
		  return max(principal);
	  }
	   private Nodo3 min(Nodo3 x) {
	        if (x.anterior == null) return x; 
	        else                return min(x.anterior); 
	    }
	   private Nodo3 max(Nodo3 x) {
	        if (x.siguiente == null) return x; 
	        else                return max(x.siguiente); 
	    } 
	public RedBlack1() {
	principal=null;
	}
    public Iterable<K> keys() {
        Queue1<K> queue = new Queue1<K>();
        keys(principal, queue);
        return queue;
    }
    
    public Iterable<V> valuesInRange(K init, K end) {
    	Iterator<K> it2=KeysInRange(init,end).iterator();
    	Queue1<V> queue3 = new Queue1<V>();
    	while (it2.hasNext() ) {
    		queue3.enqueue(get(it2.next()));
    	}
    	return queue3;
    }
    public Iterable<K> KeysInRange(K init, K end) {
    	Iterator<K> it=keys().iterator();
    	Queue1 <K> queue2 = new Queue1<K>();
    	boolean inicio=false;
    	boolean fin=false;
    	while (it.hasNext() && fin==false) {
    		K ke=it.next();
    		if(!inicio){
    			
    			if(ke.compareTo(init)>=0){
    				inicio=true;
    				queue2.enqueue(ke);
    				
    			}
    		}else{
    			if(ke.compareTo(end)>=0){
    				fin=true;
    			}else{
    				queue2.enqueue(ke);
    			}
    		}
    	
    	
    }
    	return queue2;
    	}
    private void keys(Nodo3 x, Queue1<K> queue) { 
        if (x == null) return; 
        keys(x.anterior, queue); 
        queue.enqueue((K) x.item); 
        keys(x.siguiente, queue); 
    } 
    private void Ks(Nodo3 x, Queue1<K> queue) { 
        if (x == null) return; 
        Ks(x.anterior, queue); 
        queue.enqueue((K) x.item); 
        Ks(x.siguiente, queue); 
    }
    public Iterable<K> Ks() {
        Queue1<K> queue = new Queue1<K>();
        Ks(principal, queue);
        return queue;
    }
    private boolean check() {
        if (!isBST())            System.out.println("Not in symmetric order");
        if (!isSizeConsistent()) System.out.println("Subtree counts not consistent");
        if (!isRankConsistent()) System.out.println("Ranks not consistent");
        if (!is23())             System.out.println("Not a 2-3 tree");
        if (!isBalanced())       System.out.println("Not balanced");
        return isBST() && isSizeConsistent() && isRankConsistent() && is23() && isBalanced();
    }

    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict
    private boolean isBST() {
        return isBST(principal, null, null);
    }

    // is the tree principaled at x a BST with all Ks strictly between min and max
    // (if min or max is null, treat as empty constraint)
    // Credit: Bob Dondero's elegant solution
    private boolean isBST(Nodo3<K,V> x, K min, K max) {
        if (x == null) return true;
        if (min != null && x.item.compareTo(min) <= 0) return false;
        if (max != null && x.item.compareTo(max) >= 0) return false;
        return isBST(x.anterior, min, x.item) && isBST(x.siguiente, x.item, max);
    } 

    // are the size fields correct?
    private boolean isSizeConsistent() { return isSizeConsistent(principal); }
    private boolean isSizeConsistent(Nodo3 x) {
        if (x == null) return true;
        if (x.size != size(x.anterior) + size(x.siguiente) + 1) return false;
        return isSizeConsistent(x.anterior) && isSizeConsistent(x.siguiente);
    } 

    // check that ranks are consistent
    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (K K : Ks())
            if (K.compareTo(select(rank(K))) != 0) return false;
        return true;
    }

    // Does the tree have no red siguiente links, and at most one (anterior)
    // red links in a row on any path?
    private boolean is23() { return is23(principal); }
    private boolean is23(Nodo3 x) {
        if (x == null) return true;
        if (isRed(x.siguiente)) return false;
        if (x != principal && isRed(x) && isRed(x.anterior))
            return false;
        return is23(x.anterior) && is23(x.siguiente);
    } 

    // do all paths from principal to leaf have same number of black edges?
    private boolean isBalanced() { 
        int black = 0;     // number of black links on path from principal to min
        Nodo3 x = principal;
        while (x != null) {
            if (!isRed(x)) black++;
            x = x.anterior;
        }
        return isBalanced(principal, black);
    }

    // does every path from the principal to a leaf have the given number of black links?
    private boolean isBalanced(Nodo3 x, int black) {
        if (x == null) return black == 0;
        if (!isRed(x)) black--;
        return isBalanced(x.anterior, black) && isBalanced(x.siguiente, black);
    } 

    public int size(K lo, K hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to size() is null");

        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else              return rank(hi) - rank(lo);
    }
    public int rank(K key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, principal);
    } 
    private int rank(K key, Nodo3 x) {
        if (x == null) return 0; 
        int cmp = key.compareTo((K) x.item); 
        if      (cmp < 0) return rank(key, x.anterior); 
        else if (cmp > 0) return 1 + size(x.anterior) + rank(key, x.siguiente); 
        else              return size(x.anterior); 
    }  
    public K select(int rank) {
        if (rank < 0 || rank >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + rank);
        }
        return select(principal, rank);
    }
    private K select(Nodo3 x, int rank) {
        if (x == null) return null;
        int leftSize = size(x.anterior);
        if      (leftSize > rank) return select(x.anterior,  rank);
        else if (leftSize < rank) return select(x.siguiente, rank - leftSize - 1); 
        else                      return (K) x.item;
    }
}

