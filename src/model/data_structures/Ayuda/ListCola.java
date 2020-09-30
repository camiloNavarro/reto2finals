package model.data_structures.Ayuda;


public interface ListCola<E> extends Iterable<E>
{


public void enqueue(E elem);

public E dequeue( );
public E get (int pos);
public int size();
public boolean isEmpty();
}
