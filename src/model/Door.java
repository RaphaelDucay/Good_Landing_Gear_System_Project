package model;

import java.util.Observable;

public class Door extends Observable{
	
	private String state;
	private int timeToChangeState;
	private int index;
	
	public Door(String state, int timeToChangeState, int index) {
		this.state = state;
		this.timeToChangeState = timeToChangeState;
		this.index = index;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
		 setChanged();
	     notifyObservers();
	}
	public int getTimeToChangeState() {
		return timeToChangeState;
	}
	public void setTimeToChangeState(int timeToChangeState) {
		this.timeToChangeState = timeToChangeState;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
		

}
