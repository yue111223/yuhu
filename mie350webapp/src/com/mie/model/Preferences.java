package com.mie.model;

public class Preferences {
	private String sUserName;
	private String Smoke;
	private String Pets;
	private String Price;
	private String Districts;
	
	public String getsUserName() {
		return sUserName;
	}

	public void setsUserName(String id) {
		this.sUserName = id;
	}

	public String Smoke() {
		return Smoke;
	}

	public void setSmoke(String smoke) {
		this.Smoke = smoke;
	}

	public String Pets() {
		return Pets;
	}

	public void setPets(String pets) {
		this.Pets = pets;
	}
	
	public String Price() {
		return Price;
	}

	public void setPrice(String price) {
		this.Price = price;
	}
	
	public String Districts() {
		return Districts;
	}

	public void setDistricts(String districts) {
		this.Districts = districts;
	}

	
	@Override
	public String toString() {
		return "seekerPreferences [sUserName=" + sUserName + ", Smoke=" + Smoke
				+ ", Pets=" + Pets + ", Price=" + Price + ", Districts=" + Districts + "]";
	}
}
