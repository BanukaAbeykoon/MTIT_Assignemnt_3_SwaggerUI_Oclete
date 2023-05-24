package Bartender.model;

public class Bartender {
	public String barname;
	public int noOfliqours;
	public String barId;
	public int Capacity;
	
	
	public Bartender (String barname, String barId, int noOfliqours, int Capacity) {
		
		this.barname= barname;
		this.barId = barId;
		this.noOfliqours= noOfliqours;
		this.Capacity = Capacity;
		
	}


	public String getBarname() {
		return barname;
	}


	public void setBarname(String barname) {
		this.barname = barname;
	}


	public int getNoOfliqours() {
		return noOfliqours;
	}


	public void setNoOfliqours(int noOfliqours) {
		this.noOfliqours = noOfliqours;
	}


	public String getBarId() {
		return barId;
	}


	public void setBarId(String barId) {
		this.barId = barId;
	}


	public int getCapacity() {
		return Capacity;
	}


	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
}
