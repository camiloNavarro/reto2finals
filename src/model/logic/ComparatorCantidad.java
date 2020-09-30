package model.logic;

import java.util.Comparator;

public class ComparatorCantidad implements Comparator<Movie>{


	@Override
	public int compare(Movie arg0, Movie arg1) {
		// TODO Auto-generated method stub
		
		return arg0.getCount()-arg1.getCount();
	}

	public int compareTo(ComparatorCantidad w) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	}