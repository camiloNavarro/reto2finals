package model.logic;

import model.logic.Actor.Gender;

public class ScreenPlay implements Comparable <ScreenPlay> {
	
	private String name;
	

	
	public ScreenPlay (String actorOne) {
		this.setActorOne(actorOne);
	
	}  
	
	
	
	@Override
	public int compareTo(ScreenPlay screenPlay) {
		// TODO Auto-generated method stub
		return 0;
	}




	public String getActorOne() {
		return name;
	}



	public void setActorOne(String actorOne) {
		this.name = actorOne;
	}
}
