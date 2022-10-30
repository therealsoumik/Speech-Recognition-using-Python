package com.apiproject.api_nasa.model;

public class MarsRoverCamera {
	
	private Integer id;
	private String name;
	private String fullName;
	
	public MarsRoverCamera() {}
	
	public MarsRoverCamera(Integer id, String name, String fullName) {
		super();
		this.id = id;
		this.name = name;
		this.fullName = fullName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Override
	public String toString() {
		return "MarsRoverCamera [id=" + id + ", name=" + name + ", fullName=" + fullName + "]";
	}
	
	

}
