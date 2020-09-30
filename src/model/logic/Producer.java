package model.logic;

import model.logic.Actor.Gender;

public class Producer implements Comparable <Producer> {
	
	private String name;
	
	
	public Producer (String actorOne) {
		this.setActorOne(actorOne);
	
	}  
	
	
	
	@Override
	public int compareTo(Producer producer) {
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
