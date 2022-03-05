package com.content;

public class Enclosure {
	private int enclosureid;
	private String type;
	private String location;
	
	public int getEnclosureid() {
		return enclosureid;
	}
	public void setEnclosureid(int enclosureid) {
		this.enclosureid = enclosureid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Enclosure (int _enclosureid, String _type, String _location) {
		this.enclosureid=_enclosureid;
		this.type=_type;
		this.location=_location;
	}
	public Enclosure (String _type, String _location) {
		this.type=_type;
		this.location=_location;
	}

}
