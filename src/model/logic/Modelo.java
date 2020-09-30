package model.logic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.SeparateChainingHashST;

/**
 * Definicion del modelo del mundo
 *
 */


public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */

	private IArregloDinamico <Integer> datos;

	public static String ARCHIVO_CASTING = "./data/MoviesCastingRaw-small.csv";

	public static String ARCHIVO_DETAILS = "./data/SmallMoviesDetailsCleaned.csv";

	private Catalog catalogo;
	private Catalog catalogo2;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos = new ArregloDinamico <Integer> (7);
		catalogo = new Catalog();
		catalogo2 = new Catalog();
	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		datos = new ArregloDinamico <Integer> (capacidad);
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Integer dato)
	{	
		datos.agregar(dato);
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public Integer buscar(Integer dato)
	{
		return datos.buscar(dato);
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public Integer eliminar(Integer dato)
	{
		return datos.eliminar(dato);
	}


	 public void cargaDatos() {
	        Integer idPeliculaAct = -1;
	        final File archivo1 = new File(Modelo.ARCHIVO_DETAILS);
	        final File archivo2 = new File(Modelo.ARCHIVO_CASTING);
	        FileReader fr1 = null;
	        FileReader fr2 = null;
	        Label_0852: {
	            try {
	                fr1 = new FileReader(archivo1);
	                fr2 = new FileReader(archivo2);
	                final BufferedReader br1 = new BufferedReader(fr1);
	                final BufferedReader br2 = new BufferedReader(fr2);
	                String lineaActual = br1.readLine();
	                while ((lineaActual = br1.readLine()) != null) {
	                    final String[] atributos = lineaActual.split(";");
	                    final Movie peliculaAct = new Movie(Integer.parseInt(atributos[0]));
	                    idPeliculaAct = Integer.parseInt(atributos[0]);
	                    peliculaAct.setBudget(Double.parseDouble(atributos[1]));
	                    final String[] generos = atributos[2].split("|");
	                    final ArregloDinamico<String> arregloGeneros = (ArregloDinamico<String>)new ArregloDinamico();
	                    for (int i = 0; i < generos.length; ++i) {
	                        arregloGeneros.agregar((Comparable)generos[i]);
	                    }
	                    try{
	                    peliculaAct.setGenre((ArregloDinamico)arregloGeneros);
	                    peliculaAct.setImbdID(atributos[3]);
	                    peliculaAct.setLanguage(atributos[4]);
	                    peliculaAct.setoriginalTitle(atributos[5]);
	                    peliculaAct.setOverview(atributos[6]);
	                    peliculaAct.setPopularity(atributos[7]);
	                    peliculaAct.setProductionCompany(atributos[8]);
	                    peliculaAct.setProductionCountry(atributos[9]);
	                    peliculaAct.setReleaseDate(atributos[10]);
	                    peliculaAct.setRevenue(Double.parseDouble(atributos[11]));
	                    peliculaAct.setRunTime(Double.parseDouble(atributos[12]));
	                    peliculaAct.setSpokenLanguage(atributos[13]);
	                    peliculaAct.setStatus(atributos[14]);
	                    peliculaAct.setTagLine(atributos[15]);
	                    peliculaAct.setTitle(atributos[16]);
	                    peliculaAct.setVoteAverage(Double.parseDouble(atributos[17]));
	                    peliculaAct.setProductionCompanies(Integer.valueOf(Integer.parseInt(atributos[18])));
	                    peliculaAct.setProductionCountries(Integer.valueOf(Integer.parseInt(atributos[19])));
	                    peliculaAct.setSpokenLanguages(Integer.valueOf(Integer.parseInt(atributos[20])));
	                    this.catalogo.peliculas.agregar((Comparable)peliculaAct);
	                    }catch(Exception e){
	                    	
	                    }
	                }
	                lineaActual = br2.readLine();
	                final ArregloDinamico<Movie> peliculasCatalogo = (ArregloDinamico<Movie>)this.catalogo.peliculas;
	                while ((lineaActual = br2.readLine()) != null) {
	                    final String[] atributos2 = lineaActual.split(";");
	                    for (int j = 0; j < peliculasCatalogo.darTamano(); ++j) {
	                        final Movie peliculaAct2 = (Movie)peliculasCatalogo.darElemento(j);
	                        if (peliculaAct2.getId() == Integer.parseInt(atributos2[0])) {
	                            final ArregloDinamico<Actor> actores = (ArregloDinamico<Actor>)peliculaAct2.getActores();
	                            for (int k = 1; k < 11; ++k) {
	                                final Actor actorAct = new Actor(atributos2[k], Integer.parseInt(atributos2[k + 1]));
	                                ++k;
	                                actores.agregar((Comparable)actorAct);
	                            }
	                            peliculaAct2.setActores((ArregloDinamico)actores);
	                            peliculaAct2.setNumberActors(Integer.valueOf(Integer.parseInt(atributos2[11])));
	                            final Director director = new Director(atributos2[12], Integer.parseInt(atributos2[13]));
	                            peliculaAct2.setDirectores(director);
	                            peliculaAct2.setNumberDirectors(Integer.valueOf(Integer.parseInt(atributos2[14])));
	                            final Producer productor = new Producer(atributos2[15]);
	                            peliculaAct2.setProductor(productor);
	                            peliculaAct2.setNumberProducers(Integer.valueOf(Integer.parseInt(atributos2[16])));
	                            final ScreenPlay screenplay = new ScreenPlay(atributos2[17]);
	                            peliculaAct2.setScreenplay(screenplay);
	                            final Editor editor = new Editor(atributos2[18]);
	                            peliculaAct2.setEditor(editor);
	                        }
	                    }
	                }
	            }
	            catch (Exception e) {
	                System.out.println("error fatal: en pelicula " + idPeliculaAct + " descripci\u00c3³n error: " + e.getMessage());
	                try {
	                    if (fr1 != null) {
	                        fr1.close();
	                    }
	                    if (fr2 != null) {
	                        fr2.close();
	                    }
	                }
	                catch (Exception e2) {
	                    e2.printStackTrace();
	                }
	                break Label_0852;
	            }
	            finally {
	                try {
	                    if (fr1 != null) {
	                        fr1.close();
	                    }
	                    if (fr2 != null) {
	                        fr2.close();
	                    }
	                }
	                catch (Exception e2) {
	                    e2.printStackTrace();
	                }
	            }
	            try {
	                if (fr1 != null) {
	                    fr1.close();
	                }
	                if (fr2 != null) {
	                    fr2.close();
	                }
	            }
	            catch (Exception e2) {
	                e2.printStackTrace();
	            }
	        }
	        System.out.println("catalogo tamano:" + this.catalogo.peliculas.darTamano());
	    }

	public void setCatalogo(Catalog catalogo) {
		this.catalogo = catalogo;
	}
	
	public void requerimiento1(String p)
	{
		SeparateChainingHashST hasht = new SeparateChainingHashST();
		for(int i =0; i<catalogo.peliculas.darTamano();i++)
		{
			ArregloDinamico pelis = new ArregloDinamico <Integer> ();
			if(hasht.contains(catalogo.peliculas.darElemento(i).getProductionCompany())==false)
			{
				for(int j =i; j<catalogo.peliculas.darTamano();j++)
				{
					if(catalogo.peliculas.darElemento(j).getProductionCompany().compareToIgnoreCase(catalogo.peliculas.darElemento(i).getProductionCompany())==0)
							{
					    pelis.agregar(catalogo.peliculas.darElemento(j));
					}
				}
				hasht.put(catalogo.peliculas.darElemento(i).getProductionCompany(), pelis);
			}				
		}
		int c =0;
		double prom =0;
		ArregloDinamico r=(ArregloDinamico) hasht.get(p);
		for(int i =0; i<r.darTamano();i++){
		 Movie x =(Movie)r.darElemento(i);
		 prom+=x.getVoteAverage();
		 System.out.println(x.getoriginalTitle());
		}
		System.out.println("\n");
		c=r.darTamano();
		System.out.println("la compañia ha producido: "+c );
		System.out.println("\n");
		prom = prom/c;
		System.out.println("el promedio de la compañia es: "+prom );
		System.out.println("\n");
	}
	
	public void requerimiento2(String d)
	{
		SeparateChainingHashST hasht = new SeparateChainingHashST();
		for(int i =0; i<catalogo.peliculas.darTamano();i++)
		{
			ArregloDinamico pelis = new ArregloDinamico <Integer> ();
			if(hasht.contains(catalogo.peliculas.darElemento(i).getDirectores().getDirectorName())==false)
			{
				for(int j =i; j<catalogo.peliculas.darTamano();j++)
				{
					if(catalogo.peliculas.darElemento(j).getDirectores().getDirectorName().compareToIgnoreCase(catalogo.peliculas.darElemento(i).getDirectores().getDirectorName())==0)
							{
					    pelis.agregar(catalogo.peliculas.darElemento(j));
					}
				}
				hasht.put(catalogo.peliculas.darElemento(i).getDirectores().getDirectorName(), pelis);
			}				
		}
		int c =0;
		double prom =0;
		ArregloDinamico r=(ArregloDinamico) hasht.get(d);
		for(int i =0; i<r.darTamano();i++){
		 Movie x =(Movie)r.darElemento(i);
		 prom+=x.getVoteAverage();
		 System.out.println(x.getoriginalTitle());
		}
		System.out.println("\n");
		c=r.darTamano();
		System.out.println("el director ha dirigido: "+c+" peliculas" );
		System.out.println("\n");
		prom = prom/c;
		System.out.println("el promedio del director es: "+prom );
		System.out.println("\n");
	}
	
	public void requerimiento3(String a)
	{
		SeparateChainingHashST hasht = new SeparateChainingHashST();
		for(int i =0; i<catalogo.peliculas.darTamano();i++)
		{
			
			for(int j=0; j<catalogo.peliculas.darElemento(i).getActores().darTamano(); j++)
			{
				ArregloDinamico pelis = new ArregloDinamico <Integer> ();
				boolean agregado=false;
				if(hasht.contains(catalogo.peliculas.darElemento(i).getActores().darElemento(j).getActorOne())==false && agregado==false){
					for(int x=i; x<catalogo.peliculas.darTamano(); x++){
						for(int y =0; y < catalogo.peliculas.darElemento(x).getActores().darTamano(); y++){
							if(catalogo.peliculas.darElemento(i).getActores().darElemento(j).getActorOne().compareToIgnoreCase(catalogo.peliculas.darElemento(x).getActores().darElemento(y).getActorOne())==0){
								pelis.agregar(catalogo.peliculas.darElemento(x));
								agregado=true;
							}
						}
					}
					hasht.put(catalogo.peliculas.darElemento(i).getActores().darElemento(j).getActorOne(), pelis);
				}
			}
		}
		int c =0;
		double prom =0;
		ArregloDinamico r=(ArregloDinamico) hasht.get(a);
		for(int i =0; i<r.darTamano();i++){
		 Movie x =(Movie)r.darElemento(i);
		 prom+=x.getVoteAverage();
		 System.out.println(x.getoriginalTitle());
		}
		System.out.println("\n");
		c=r.darTamano();
		System.out.println("el actor participo en: "+c +" peliculas");
		System.out.println("\n");
		prom = prom/c;
		System.out.println("el promedio del actor es: "+prom );
		System.out.println("\n");
	}
	
	public void requerimiento4(String g)
	{
		SeparateChainingHashST hasht = new SeparateChainingHashST();
		for(int i =0; i<catalogo.peliculas.darTamano();i++)
		{
			
			for(int j=0; j<catalogo.peliculas.darElemento(i).getGenre().darTamano(); j++)
			{
				ArregloDinamico pelis = new ArregloDinamico <Integer> ();
				boolean agregado=false;
				if(hasht.contains(catalogo.peliculas.darElemento(i).getGenre().darElemento(j))==false && agregado==false){
					for(int x=i; x<catalogo.peliculas.darTamano(); x++){
						for(int y =0; y < catalogo.peliculas.darElemento(x).getGenre().darTamano(); y++){
							if(catalogo.peliculas.darElemento(i).getGenre().darElemento(j).compareToIgnoreCase(catalogo.peliculas.darElemento(x).getGenre().darElemento(y))==0){
								pelis.agregar(catalogo.peliculas.darElemento(x));
								agregado=true;
							}
						}
					}
					hasht.put(catalogo.peliculas.darElemento(i).getGenre().darElemento(j), pelis);
				}
			}
		}
		int c =0;
		double prom =0;
		ArregloDinamico r=(ArregloDinamico) hasht.get(g);
		for(int i =0; i<r.darTamano();i++){
		 Movie x =(Movie)r.darElemento(i);
		 prom+=x.getVoteAverage();
		 System.out.println(x.getoriginalTitle());
		}
		System.out.println("\n");
		c=r.darTamano();
		System.out.println("el actor participo en: "+c +" peliculas");
		System.out.println("\n");
		prom = prom/c;
		System.out.println("el promedio del actor es: "+prom );
		System.out.println("\n");
	}
	
	public void requerimiento5(String p)
	{
		SeparateChainingHashST hasht = new SeparateChainingHashST();
		for(int i =0; i<catalogo.peliculas.darTamano();i++)
		{
			ArregloDinamico pelis = new ArregloDinamico <Integer> ();
			if(hasht.contains(catalogo.peliculas.darElemento(i).getProductionCountry())==false)
			{
				for(int j =i; j<catalogo.peliculas.darTamano();j++)
				{
					if(catalogo.peliculas.darElemento(j).getProductionCountry().compareToIgnoreCase(catalogo.peliculas.darElemento(i).getProductionCountry())==0)
							{
					    pelis.agregar(catalogo.peliculas.darElemento(j));
					}
				}
				hasht.put(catalogo.peliculas.darElemento(i).getProductionCountry(), pelis);
			}				
		}
		int c =0;
		double prom =0;
		ArregloDinamico r=(ArregloDinamico) hasht.get(p);
		for(int i =0; i<r.darTamano();i++){
		 Movie x =(Movie)r.darElemento(i);
		 prom+=x.getVoteAverage();
		 System.out.println(i+"- "+"titulo: "+x.getoriginalTitle()+ " producida en: "+ x.getReleaseDate()+ " dirigida por: "+x.getDirectores().getDirectorName());
		}
		System.out.println("\n");
	}
}
