package com.content;

public class Animal {
	private int animalId;
	private String name;
	private String gender;
	private int year;
	private int speciesId;
	private int dietId;
	private int enclosureId;
	private int keeperId;
	private String keepername;
	private int totalanimals;
	
	public int getTotalanimals() {
		return totalanimals;
	}
	public void setTotalanimals(int totalanimals) {
		this.totalanimals = totalanimals;
	}
	public String getKeepername() {
		return keepername;
	}
	public void setKeepername(String keepername) {
		this.keepername = keepername;
	}
	
	public int getAnimalId() {
		return animalId;
	}
	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSpeciesId() {
		return speciesId;
	}
	public void setSpeciesId(int speciesId) {
		this.speciesId = speciesId;
	}
	public int getDietId() {
		return dietId;
	}
	public void setDietId(int dietId) {
		this.dietId = dietId;
	}
	public int getEnclosureId() {
		return enclosureId;
	}
	public void setEnclosureId(int enclosureId) {
		this.enclosureId = enclosureId;
	}
	public int getKeeperId() {
		return keeperId;
	}
	public void setKeeperId(int keeperId) {
		this.keeperId = keeperId;
	}
	public Animal (int _animalId,String _name,String _gender,int _year,int _speciesId, int _dietId, int _enclosureId,int _keeperId) {
		this.animalId=_animalId;
		this.name=_name;
		this.gender=_gender;
		this.year=_year;
		this.speciesId=_speciesId;
		this.dietId=_dietId;
		this.enclosureId=_enclosureId;
		this.keeperId=_keeperId;
	}
	public Animal (String _name,String _gender,int _year,int _speciesId, int _dietId, int _enclosureId,int _keeperId) {
		this.name=_name;
		this.gender=_gender;
		this.year=_year;
		this.speciesId=_speciesId;
		this.dietId=_dietId;
		this.enclosureId=_enclosureId;
		this.keeperId=_keeperId;
	}
	public Animal (int _animalId,String _name,String _gender,int _year,int _keeperId,String _keepername) {
		this.animalId=_animalId;
		this.name=_name;
		this.gender=_gender;
		this.year=_year;
		this.keeperId=_keeperId;
		this.keepername=_keepername;
	}
	public Animal (String _keepername, int _totalanimals) {
		this.keepername=_keepername;
		this.totalanimals=_totalanimals;
	}
}
