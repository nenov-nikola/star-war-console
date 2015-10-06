package com.force.engine;

public class GameStart {

	public static void main(String[] args) {
		
		Engine engine = new Engine(new Dispatcher());
		engine.start();
		
	}
}
