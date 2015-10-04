package com.force.engine;

import com.force.locations.LocationType;
import com.force.person.Jedi;
import com.force.person.Person;
import com.force.person.PersonType;

public class GameStart {

	public static void main(String[] args) {
		
		/*Person yoda = new Jedi("Yoda", 5, 4, 9, 7, "planet", LocationType.Kamino, PersonType.Jedi);
		System.out.println(yoda);*/
		
		Engine engine = new Engine(new Dispatcher());
		engine.start();
		
	}
}
