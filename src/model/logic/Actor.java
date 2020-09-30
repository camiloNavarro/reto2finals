package model.logic;


public class Actor  implements Comparable <Actor> {

	private String name;
	
	public enum Gender { 
		NONE,
		MALE,
		FEMALE
	}
	
	private Gender gender;
	
	public Actor (String actorOne, int gender) {
		this.setActorOne(actorOne);
	if (gender == 0 ) {
		setActorOneGender(Gender.NONE);
		}
	else if ( gender ==1) {
		setActorOneGender(Gender.FEMALE);
		}
	else  {
		setActorOneGender(Gender.MALE);
		}
	}  
	
	
	
	@Override
	public int compareTo(Actor actor) {
		// TODO Auto-generated method stub
		return 0;
	}



	public Gender getActorOneGender() {
		return gender;
	}



	public void setActorOneGender(Gender actorOneGender) {
		this.gender = actorOneGender;
	}



	public String getActorOne() {
		return name;
	}



	public void setActorOne(String actorOne) {
		this.name = actorOne;
	}
}
	
