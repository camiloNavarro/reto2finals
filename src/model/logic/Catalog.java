package model.logic;

import model.data_structures.ArregloDinamico;

public class Catalog {
	
	public ArregloDinamico<Movie> peliculas;
	
	
	public Catalog () {
		peliculas = new ArregloDinamico<Movie>();
	}
	
}
