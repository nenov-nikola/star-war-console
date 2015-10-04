package com.force.engine;

import java.util.HashMap;
import java.util.Map;

import com.force.items.Item;
import com.force.items.ItemType;
import com.force.locations.Location;
import com.force.locations.LocationType;
import com.force.person.Jedi;
import com.force.person.Person;
import com.force.person.PersonType;
import com.force.person.Sith;

public class Dispatcher {

	protected Map<String, Person> personByName = new HashMap<String, Person>();
	protected Map<String, Item> itemByName = new HashMap<String, Item>();
	protected Map<String, Location> locationByName = new HashMap<String, Location>();

	public void handleInteraction(String[] commandWords) {
		if (commandWords[0].equals("create")) {
			this.handleCreationCommand(commandWords);
		} else {
			System.out.println("You mean ....");
		}
	}

	private void handleCreationCommand(String[] commandWords) {
		if (commandWords[1].equals("item")) {
			String name = commandWords[2];
			ItemType itemType = ItemType.valueOf(commandWords[3]);
			this.handleItemCreation(name, itemType);
		} else if (commandWords[1].equals("jedi")) {
			String jediName = commandWords[2];
			int attackPoints = Integer.parseInt(commandWords[3]);
			int defencePoints = Integer.parseInt(commandWords[4]);
			int jediHealth = Integer.parseInt(commandWords[5]);
			int jediMoney = Integer.parseInt(commandWords[6]);
			String locationName = commandWords[7];
			LocationType locationType = LocationType.valueOf(commandWords[8]);
			PersonType personType = PersonType.valueOf(commandWords[9]);
			this.handleJediCreation(jediName, attackPoints, defencePoints, jediHealth, jediMoney, locationName,
					locationType, personType);
		} else if (commandWords[1].equals("sith")) {
			String sithName = commandWords[2];
			int attackPoints = Integer.parseInt(commandWords[3]);
			int defencePoints = Integer.parseInt(commandWords[4]);
			int sithHealth = Integer.parseInt(commandWords[5]);
			int sithMoney = Integer.parseInt(commandWords[6]);
			String locationName = commandWords[7];
			LocationType locationType = LocationType.valueOf(commandWords[8]);
			PersonType personType = PersonType.valueOf(commandWords[9]);
			this.handleSithCreation(sithName, attackPoints, defencePoints, sithHealth, sithMoney, locationName,
					locationType, personType);
		} else {
			commandWords[1].equals("location");
			String locationName = commandWords[2];
			LocationType locationType = LocationType.valueOf(commandWords[3]);
			this.handleLocationCreation(locationName, locationType);
		}
	}

	private Item handleItemCreation(String name, ItemType itemType) {
		Item item = createItem(name, itemType);
		itemByName.put(name, item);
		return item;
	}

	private Location handleLocationCreation(String locationName, LocationType locationType) {
		Location location = createLocation(locationName, locationType);
		locationByName.put(locationName, location);
		return location;
	}

	private Item createItem(String name, ItemType itemType) {
		Item item = new Item(name, itemType);
		return item;
	}

	private Location createLocation(String locationName, LocationType locationType) {
		Location location = new Location(locationName, locationType);
		return location;
	}

	private Jedi handleJediCreation(String jediName, int attackPoints, int defencePoints, int jediHealth, int jediMoney,
			String locationName, LocationType locationType, PersonType personType) {

		Person jedi = createJedi(jediName, attackPoints, defencePoints, jediHealth, jediMoney, locationName,
				locationType, personType);
		personByName.put(jediName, jedi);
		return (Jedi) jedi;
	}

	private Person handleSithCreation(String sithName, int attackPoints, int defencePoints, int sithHealth,
			int sithMoney, String locationName, LocationType locationType, PersonType personType) {
		Person sith = createSith(sithName, attackPoints, defencePoints, sithHealth, sithMoney, locationName,
				locationType, personType);
		personByName.put(sithName, sith);
		return (Sith) sith;
	}

	private Person createJedi(String name, int attackPoints, int defencePoints, int health, int money,
			String locationName, LocationType locationType, PersonType personType) {
		Person jedi = new Jedi(name, attackPoints, defencePoints, health, money, locationName, locationType,
				personType);
		return jedi;
	}

	private Person createSith(String sithName, int attackPoints, int defencePoints, int sithHealth, int sithMoney,
			String locationName, LocationType locationType, PersonType personType) {
		Person sith = new Sith(sithName, attackPoints, defencePoints, sithHealth, sithMoney, locationName, locationType,
				personType);
		return sith;
	}
}
