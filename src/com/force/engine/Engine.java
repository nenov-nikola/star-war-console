package com.force.engine;

import java.util.Map.Entry;
import java.util.Scanner;

import com.force.items.Item;
import com.force.locations.Location;
import com.force.person.Person;

public class Engine {

	protected Dispatcher dispatcher;
	Scanner input = new Scanner(System.in);

	public Engine(Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	public void parseAndDispatch(String command) {
		this.dispatcher.handleInteraction(command.split("[ ]", -1));
	}

	public void start() {
		Boolean endCommandReached = true;

		while (endCommandReached) {
			System.out.println("Enter command: ");
			String command = input.nextLine();
			if (command.equals("end")) {
				endCommandReached = false;
				System.out.println("Game Over");
				input.close();
			} else {
				this.parseAndDispatch(command);
			}
		}
		/*for (Entry<String, Person> i : dispatcher.personByName.entrySet()) {
			System.out.printf("Jedi`s name: " + i.getKey() + ", " + i.getValue());
		}
		
		for (Entry<String, Item> i : dispatcher.itemByName.entrySet()) {
			System.out.printf("Item`s name: " + i.getKey() + ", " + i.getValue());
		}
		
		for (Entry<String, Location> i : dispatcher.locationByName.entrySet()) {
			System.out.printf("Location`s name: " + i.getKey() + ", " + i.getValue());
		}*/
	}
}
