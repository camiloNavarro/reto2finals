package model.logic;


public class Shell {
	public Shell(){

	}
	public static void sort(Movie[]a, ComparatorCantidad cantidad){
		int N=a.length;
		int h=1;
		while(h < N/3){
			h=3*h+1;
		}
		while(h>=1){
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
					exch(a, j, j-h);
			}
			h = h/3;
		}
	}
	private static boolean less(Movie a, Movie a2)
	{
		return a.compareTo(a2) < 0;
	}
	private static void exch(Movie[] a, int i, int j)
	{
		Movie t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
