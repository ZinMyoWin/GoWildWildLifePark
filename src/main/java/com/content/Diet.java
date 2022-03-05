package com.content;

public class Diet {
	private int dietId;
	private String dietType;
	private int noOfFeed;
	
	public int getDietId() {
		return dietId;
	}
	public void setDietId(int dietId) {
		this.dietId = dietId;
	}
	public String getDietType() {
		return dietType;
	}
	public void setDietType(String dietType) {
		this.dietType = dietType;
	}
	public int getNoOfFeed() {
		return noOfFeed;
	}
	public void setNoOfFeed(int noOfFeed) {
		this.noOfFeed = noOfFeed;
	}
	public Diet (int _dietId, String _dietType, int _noOfFeed) {
		this.dietId=_dietId;
		this.dietType=_dietType;
		this.noOfFeed=_noOfFeed;
	}
	public Diet (String _dietType, int _noOfFeed) {
		this.dietType=_dietType;
		this.noOfFeed=_noOfFeed;
	}
}
