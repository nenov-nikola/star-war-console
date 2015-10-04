package com.force.players;

public abstract class Player {

	private String name;
	private int bonusPoints;
	private int frags;

	public Player(String name, int bonusPoints, int frags) {
		super();
		this.name = name;
		this.bonusPoints = bonusPoints;
		this.frags = frags;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBonusPoints() {
		return bonusPoints;
	}

	public void setBonusPoints(int bonusPoints) {
		this.bonusPoints = bonusPoints;
	}

	public int getFrags() {
		return frags;
	}

	public void setFrags(int frags) {
		this.frags = frags;
	}

}
