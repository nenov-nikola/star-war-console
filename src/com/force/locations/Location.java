package com.force.locations;

public class Location {

	private String locationName;
	private LocationType locationType;

	public Location(String locationName, LocationType locationType) {
		this.locationName = locationName;
		this.locationType = locationType;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public LocationType getLocationType() {
		return locationType;
	}

	public void setLocationType(LocationType locationType) {
		this.locationType = locationType;
	}

}
