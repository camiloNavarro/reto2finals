package model.logic;

import model.data_structures.ArregloDinamico;

public class Movie implements Comparable <Movie> {

	private Integer id;
	private double budget;
	private String language;
	private String originalTitle;
	private String overview;
	private String popularity;
	private String productionCompany;
	private String imbdID;
	private String productionCountry;
	private ArregloDinamico<Actor> actores;
	private Director director;
	private Producer productor;
	private ScreenPlay screenplay;
	private Editor editor;
	private ArregloDinamico <String> genre;
	private String releaseDate;
	private double revenue;
	private double runTime;
	private String spokenLanguage;
	private String status;
	private String tagLine;
	private String title;
	private double voteAverage;
	private Integer count;
	private Integer productionCompanies;
	private Integer productionCountries;
	private Integer spokenLanguages;
	private Integer numberActors;
	private Integer numberDirectors;
	private Integer numberProducers;
	private Movie next;
	

	public Movie (int id) {
		this.id = id;
		actores = new ArregloDinamico<Actor>();
		genre = new ArregloDinamico<String> ();
		next = null;
	}
	
	

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getoriginalTitle() {
		return originalTitle;
	}

	public void setoriginalTitle(String title) {
		this.originalTitle = title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getPopularity() {
		return popularity;
	}

	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}

	public String getProductionCompany() {
		return productionCompany;
	}

	public void setProductionCompany(String productionCompany) {
		this.productionCompany = productionCompany;
	}

	public String getImbdID() {
		return imbdID;
	}

	public void setImbdID(String imbdID) {
		this.imbdID = imbdID;
	}

	public ArregloDinamico <String> getGenre() {
		return genre;
	}

	public void setGenre(ArregloDinamico <String> genre) {
		this.genre = genre;
	}
	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public int compareTo(Movie o) {
		return (int) (this.getVoteAverage()-o.getVoteAverage());
	}

	public String getProductionCountry() {
		return productionCountry;
	}

	public void setProductionCountry(String productionCountry) {
		this.productionCountry = productionCountry;
	}

	public ArregloDinamico<Actor> getActores() {
		return actores;
	}

	public void setActores(ArregloDinamico<Actor> actores) {
		this.actores = actores;
	}


	public String getReleaseDate() {
		return releaseDate;
	}



	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}



	public Double getRevenue() {
		return revenue;
	}



	public void setRevenue(double d) {
		this.revenue = d;
	}



	public String getSpokenLanguage() {
		return spokenLanguage;
	}



	public void setSpokenLanguage(String spokenLanguage) {
		this.spokenLanguage = spokenLanguage;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Double getRunTime() {
		return runTime;
	}



	public void setRunTime(double d) {
		this.runTime = d;
	}



	public String getTagLine() {
		return tagLine;
	}



	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}



	public double getVoteAverage() {
		return voteAverage;
	}



	public void setVoteAverage(double voteAverage) {
		this.voteAverage = voteAverage;
	}



	public Integer getCount() {
		return count;
	}



	public void setCount(Integer count) {
		this.count = count;
	}



	public Integer getProductionCompanies() {
		return productionCompanies;
	}



	public void setProductionCompanies(Integer productionCompanies) {
		this.productionCompanies = productionCompanies;
	}



	public Integer getProductionCountries() {
		return productionCountries;
	}



	public void setProductionCountries(Integer productionCountries) {
		this.productionCountries = productionCountries;
	}



	public Integer getSpokenLanguages() {
		return spokenLanguages;
	}



	public void setSpokenLanguages(Integer spokenLanguages) {
		this.spokenLanguages = spokenLanguages;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Integer getNumberActors() {
		return numberActors;
	}



	public void setNumberActors(Integer numberActors) {
		this.numberActors = numberActors;
	}



	public Director getDirectores() {
		return director;
	}



	public void setDirectores(Director directores) {
		this.director = directores;
	}



	public Producer getProductor() {
		return productor;
	}



	public void setProductor(Producer productor) {
		this.productor = productor;
	}



	public Editor getEditor() {
		return editor;
	}



	public void setEditor(Editor editor) {
		this.editor = editor;
	}



	public ScreenPlay getScreenplay() {
		return screenplay;
	}



	public void setScreenplay(ScreenPlay screenplay) {
		this.screenplay = screenplay;
	}



	public Integer getNumberDirectors() {
		return numberDirectors;
	}



	public void setNumberDirectors(Integer numberDirectors) {
		this.numberDirectors = numberDirectors;
	}



	public Integer getNumberProducers() {
		return numberProducers;
	}



	public void setNumberProducers(Integer numberProducers) {
		this.numberProducers = numberProducers;
	}
	
	public Movie darSiguiente()
	{
		return next;
	}
	
	public void cambiarSiguiente(Movie m)
	{
		next = m;
	}
	
 }
