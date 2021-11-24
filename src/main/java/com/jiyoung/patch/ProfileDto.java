package com.jiyoung.patch;

public class ProfileDto {
	
	private String name;
	private String school;
	private int power;
	private int popularity;
	private String image_one;
	private String image_two;
	
	public ProfileDto() {}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	public String getImage_one() {
		return image_one;
	}
	public void setImage_one(String image_one) {
		this.image_one = image_one;
	}
	public String getImage_two() {
		return image_two;
	}
	public void setImage_two(String image_two) {
		this.image_two = image_two;
	}

}
