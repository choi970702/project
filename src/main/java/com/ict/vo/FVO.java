package com.ict.vo;

import org.springframework.web.multipart.MultipartFile;

public class FVO {
	private String Food_name, restaurant, place, file_name;
	private MultipartFile f_name ;
	private float star;
	private boolean like;
	public String getFood_name() {
		return Food_name;
	}
	public void setFood_name(String food_name) {
		Food_name = food_name;
	}
	public String getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public float getStar() {
		return star;
	}
	public void setStar(float star) {
		this.star = star;
	}
	public boolean isLike() {
		return like;
	}
	public void setLike(boolean like) {
		this.like = like;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public MultipartFile getF_name() {
		return f_name;
	}
	public void setF_name(MultipartFile f_name) {
		this.f_name = f_name;
	}
	
	
}
