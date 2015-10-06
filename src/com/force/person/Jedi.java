package com.force.person;

import com.force.contracts.IJedi;
import com.force.items.Item;
import com.force.locations.Location;
import com.force.locations.LocationType;

public class Jedi extends Person implements IJedi {

	public Jedi(String name, int attackPoints, int defencePoints, int health, int money, String locationName,
			LocationType locationType, PersonType personType) {
		super(name, attackPoints, defencePoints, health, money, locationName, locationType, personType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void travelTo(Location location) {
		// TODO Auto-generated method stub

	}

	@Override
	public int setLevel(int level) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lightSaberSkill(int skillLevel) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addToInventory(Item item) {
		// TODO Auto-generated method stub

	}

	/*@Override
	public String toString() {
		// Test Jedi`s creation
		return String.format(
				"Jedi`s location: %s, Jedi`s locationName: %s, Jedi`s attackPoints: %s, Jedi`s type: %s",
				this.getLocationType(), this.getLocationName(), this.getAttackPoints(),
				this.getPersonType());
	}*/

}
