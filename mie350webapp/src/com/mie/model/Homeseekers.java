package com.mie.model;



public class Homeseekers {
	/**
	 * This class contains all of the relevant information, and getter/setter
	 * methods for the Homeseekers object.
	 */

	private String sUserName;
	private String Password;
	private String Email;
	private String Gender;
	private String Occupation;
	private boolean valid;

	
	private String Long;

	public String getLongURL() {
		return Long;
	}

	public void setLongURL(String long_URL) {
		this.Long = long_URL;
	}

	
	public String getsUserName() {
		return sUserName;
	}

	public void setsUserName(String id) {
		this.sUserName = id;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String Email() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String Gender() {
		return Gender;
	}

	public void setGender(String gender) {
		this.Gender = gender;
	}

	public String Occupation() {
		return Occupation;
	}

	public void setOccupation(String oc) {
		this.Occupation = oc;
	}
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean newValid) {
		valid = newValid;
	}
	
	@Override
	public String toString() {
		return "Homeseeker [sUserName=" + sUserName + ", Email=" + Email + ", Gender=" + Gender + ", Occupation="
				+ Occupation + "]";
	}
}
