package com.force.person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.force.items.Item;
import com.force.locations.Location;
import com.force.locations.LocationType;

public abstract class Person extends Location {

	HashSet<Item> inventoryItems;

	private String name;
	private Location location;
	private int health;
	private int attackPoints;
	private int defencePoints;
	private int money;
	private PersonType personType;

	public Person(String name, int attackPoints, int defencePoints, int health, int money, String locationName,
			LocationType locationType, PersonType personType) {
		super(locationName, locationType);
		this.name = name;
		this.health = health;
		this.money = money;
		this.attackPoints = attackPoints;
		this.defencePoints = defencePoints;
		this.personType = personType;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getAttackPoints() {
		return attackPoints;
	}

	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}

	public int getDefencePoints() {
		return defencePoints;
	}

	public void setDefencePoints(int defencePoints) {
		this.defencePoints = defencePoints;
	}

	public PersonType getPersonType() {
		return personType;
	}

	public void setPersonType(PersonType personType) {
		this.personType = personType;
	}

	public void addToInventory(Item item) {
		this.inventoryItems.add(item);
	}

	public void removeFromInventory(Item item) {
		this.inventoryItems.remove(item);
	}

	public List<Item> listInventory() {
		List<Item> items = new ArrayList<Item>();
		for (Item item : this.inventoryItems) {
			items.add(item);
		}
		return items;
	}
}
