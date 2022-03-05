package com.content;

public class Species {
	private int speciesId;
	private String sType;
	private String sGroup;
	private String lifeStyle;
	private String status;
	
	public int getSpeciesId() {
		return speciesId;
	}
	public void setSpeciesId(int speciesId) {
		this.speciesId = speciesId;
	}
	public String getsType() {
		return sType;
	}
	public void setsType(String sType) {
		this.sType = sType;
	}
	public String getsGroup() {
		return sGroup;
	}
	public void setsGroup(String sGroup) {
		this.sGroup = sGroup;
	}
	public String getLifeStyle() {
		return lifeStyle;
	}
	public void setLifeStyle(String lifeStyle) {
		this.lifeStyle = lifeStyle;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Species (int _speciesId,String _sType,String _sGroup,String _lifeStyle,String _status) {
		this.speciesId=_speciesId;
		this.sType=_sType;
		this.sGroup=_sGroup;
		this.lifeStyle=_lifeStyle;
		this.status=_status;
	}
	public Species (String _sType,String _sGroup,String _lifeStyle,String _status) {
		this.sType=_sType;
		this.sGroup=_sGroup;
		this.lifeStyle=_lifeStyle;
		this.status=_status;
	}
}
