package com.force.person;

import com.force.contracts.ISith;
import com.force.items.Item;
import com.force.locations.LocationType;

public class Sith extends Person implements ISith {

	public Sith(String name, int attackPoints, int defencePoints, int health, int money, String locationName,
			LocationType locationType, PersonType personType) {
		super(name, attackPoints, defencePoints, health, money, locationName, locationType, personType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int damagePerHit(int damage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setLevel(int level) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lightningDamage(int lightningDamage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addToInventory(Item item) {
		// TODO Auto-generated method stub
		
	}

}
