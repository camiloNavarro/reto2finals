package model.logic;

import model.logic.Actor.Gender;

public class Editor implements Comparable <Editor> {
	
	private String name;
	
	

	
	public Editor (String actorOne) {
		this.setActorOne(actorOne);
	
	}  
	
	
	
	@Override
	public int compareTo(Editor editor) {
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
