package com.vamos.spring.test.ajax.domain;

import java.time.LocalDateTime;

public class Favorite {

	private int id;
	private String name;
	private String url;
	private LocalDateTime createdAt;
	private LocalDateTime updateAe;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdateAe() {
		return updateAe;
	}
	public void setUpdateAe(LocalDateTime updateAe) {
		this.updateAe = updateAe;
	}
	
	
}
