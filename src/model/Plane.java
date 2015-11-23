package model;

import java.util.Observable;

public class Plane extends Observable{
	
	private String state;
	private Gear gear1, gear2, gear3;
	private Door door1, door2, door3;
	private Light light;
	private Boolean lockcontrols;
	
	public Plane(String state, Gear gear1, Gear gear2, Gear gear3,Door door1, Door door2, Door door3, Light light) {
		this.state = state;
		this.gear1 = gear1;
		this.gear2 = gear2;
		this.gear3 = gear3;
		this.door1 = door1;
		this.door2 = door2;
		this.door3 = door3;
		this.light = light;
		this.lockcontrols=false;
	}
		

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Gear getGear1() {
		return gear1;
	}

	public void setGear1(Gear gear1) {
		this.gear1 = gear1;
	}

	public Gear getGear2() {
		return gear2;
	}

	public void setGear2(Gear gear2) {
		this.gear2 = gear2;
	}

	public Gear getGear3() {
		return gear3;
	}

	public void setGear3(Gear gear3) {
		this.gear3 = gear3;
	}

	public Door getDoor1() {
		return door1;
	}

	public void setDoor1(Door door1) {
		this.door1 = door1;
	}

	public Door getDoor2() {
		return door2;
	}

	public void setDoor2(Door door2) {
		this.door2 = door2;
	}

	public Door getDoor3() {
		return door3;
	}

	public void setDoor3(Door door3) {
		this.door3 = door3;
	}

	public Light getLight() {
		return light;
	}

	public void setLight(Light light) {
		this.light = light;
	}


	public Boolean getLockcontrols() {
		return lockcontrols;
	}


	public void setLockcontrols(Boolean lockcontrols) {
		this.lockcontrols = lockcontrols;
		setChanged();
	    notifyObservers();
	}
	
	
	
}
