package com.force.items;

import com.force.locations.Location;
import com.force.locations.LocationType;

public class Item extends Location {

	private String name;
	private ItemType itemTpe;

	public Item(String name, ItemType itemTpe, String locationName, LocationType locationType) {
		super(locationName, locationType);
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
