package com.force.items;

public class Item {

	private String name;
	private ItemType itemTpe;

	public Item(String name, ItemType itemTpe) {
		super();
		this.name = name;
		this.itemTpe = itemTpe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItemType getItemTpe() {
		return itemTpe;
	}

	public void setItemTpe(ItemType itemTpe) {
		this.itemTpe = itemTpe;
	}

}
