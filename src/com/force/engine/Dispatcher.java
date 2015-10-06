package com.force.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.force.items.Item;
import com.force.items.ItemType;
import com.force.locations.Location;
import com.force.locations.LocationType;
import com.force.person.Jedi;
import com.force.person.Person;
import com.force.person.PersonType;
import com.force.person.Sith;

public class Dispatcher {

	protected List<Item> items = new ArrayList<>();

	protected Map<Person, Integer> moneyByPerson = new HashMap<Person, Integer>();
	protected Map<String, ArrayList<Item>> itemsByLocation = new HashMap<String, ArrayList<Item>>();
	protected Map<String, Person> peopleByLocation = new HashMap<String, Person>();
	protected Map<Person, List<Item>> peopleItems = new HashMap<Person, List<Item>>();

	protected Map<String, Person> personByName = new HashMap<String, Person>();
	protected Map<String, Item> itemByName = new HashMap<String, Item>();
	protected Map<String, Location> locationByName = new HashMap<String, Location>();

	public void handleInteraction(String[] commandWords) {
		if (commandWords[0].equals("create")) {
			this.handleCreationCommand(commandWords);
		} else {
			Person actor = this.personByName.get(commandWords[0]);
			this.handlePersonCommand(commandWords, actor);
		}
	}

	private void handlePersonCommand(String[] commandWords, Person actor) {

		switch (commandWords[1]) {
		case "drop":
			handleDropInteraction(actor);
			break;
		case "showItems":
			handleShowItemsInteraction(actor);
			break;
		case "pickup":
			handlePickUpInteraction(actor);
			break;
		case "sell":
			this.handleSellInteraction(commandWords, actor);
			break;
		case "buy":
			handleBuyInteraction(commandWords, actor);
			break;
		case "inventory":
			handleListInventoryInteraction(actor);
			break;
		case "money":
			System.out.println(actor.getPersonType() + "/" + actor.getName() + ": " + moneyByPerson.get(actor));
			break;
		case "travel":
			handleTravelInteraction(commandWords, actor);
			break;
		default:
			break;
		}
	}

	private void handleShowItemsInteraction(Person actor) {
		for (Entry<String, ArrayList<Item>> entry : itemsByLocation.entrySet()) {
			for (Item item : items) {
				if (actor.getLocationName().equals(entry.getKey())
						&& actor.getLocationName().equals(item.getLocationName())) {
					System.out.printf("On location " + entry.getKey() + " located: " + item.getName() + ". ");
					System.out.println();
				}
			}
		}
	}

	private void handleTravelInteraction(String[] commandWords, Person actor) {
		if (actor != null) {
			String newLocation = commandWords[2];
			for (Entry<String, Person> i : peopleByLocation.entrySet()) {
				if (i.getValue().getName().equals(actor.getName())) {
					peopleByLocation.remove(i.getKey());
					peopleByLocation.put(newLocation, actor);
				}
			}
			System.out.println(actor.getName() + " has new location - " + newLocation);
		}
	}

	private void handleListInventoryInteraction(Person actor) {
		for (Entry<Person, List<Item>> entry : peopleItems.entrySet()) {
			System.out.println(entry.getKey().getName() + " has: " + entry.getValue());
		}
	}

	private void handleBuyInteraction(String[] commandWords, Person actor) {
		// TODO Auto-generated method stub

	}

	private void handleSellInteraction(String[] commandWords, Person actor) {
		// TODO Auto-generated method stub

	}

	private void handlePickUpInteraction(Person actor) {

	}

	private void handleDropInteraction(Person actor) {
		// TODO Auto-generated method stub
	}

	private void handleCreationCommand(String[] commandWords) {
		if (commandWords[1].equals("item")) {
			String name = commandWords[2];
			ItemType itemType = ItemType.valueOf(commandWords[3]);
			String itemLocationName = commandWords[4];
			LocationType locationType = LocationType.valueOf(commandWords[5]);
			this.handleItemCreation(name, itemType, itemLocationName, locationType);
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

	private Item handleItemCreation(String name, ItemType itemType, String itemLocationName,
			LocationType locationType) {
		Item item = createItem(name, itemType, itemLocationName, locationType);
		itemByName.put(name, item);
		items.add(item);
		itemsByLocation.put(itemLocationName, (ArrayList<Item>) items);
		return item;
	}

	private Location handleLocationCreation(String locationName, LocationType locationType) {
		Location location = createLocation(locationName, locationType);
		locationByName.put(locationName, location);
		return location;
	}

	private Item createItem(String name, ItemType itemType, String itemLocationName, LocationType locationType) {
		Item item = new Item(name, itemType, itemLocationName, locationType);
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
		moneyByPerson.put(jedi, jediMoney);
		peopleByLocation.put(locationName, jedi);
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
