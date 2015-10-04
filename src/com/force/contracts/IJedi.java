package com.force.contracts;

import com.force.locations.Location;

public interface IJedi {

	public void travelTo(Location location);

	public int setLevel(int level);

	public int lightSaberSkill(int skillLevel);
}
