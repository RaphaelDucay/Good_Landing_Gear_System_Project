package model;

import java.util.Observable;

public class Light extends Observable{
	private String state;

	public Light(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		setChanged();
	    notifyObservers();
	}
	
	
	
}
