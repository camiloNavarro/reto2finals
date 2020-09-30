package model.logic;

import model.logic.Actor.Gender;

public class Director implements Comparable <Director> {
	
	private String name;
	
	public enum Gender { 
		NONE,
		MALE,
		FEMALE
	}
	
	private Gender gender;
	
	public Director(String actorOne, int gender) {
		this.setDirectorName(actorOne);
	if (gender == 0 ) {
		setDirectorGender(Gender.NONE);
		}
	else if ( gender ==1) {
		setDirectorGender(Gender.FEMALE);
		}
	else  {
		setDirectorGender(Gender.MALE);
		}
	}  
	
	
	@Override
	public int compareTo(Director director) {
		// TODO Auto-generated method stub
		return 0;
	}


	public Gender getDirectorGender() {
		return gender;
	}



	public void setDirectorGender(Gender directorGender) {
		this.gender = directorGender;
	}



	public String getDirectorName() {
		return name;
	}



	public void setDirectorName(String directorName) {
		this.name = directorName;
	}
}
