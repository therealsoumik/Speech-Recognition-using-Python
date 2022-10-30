package com.apiproject.api_nasa.model;

public class MarsRoverPhotos {
	
	private Integer id;
	private String sol;
	private String img_src;
	private String earth_date;
	private MarsRoverCamera marsRoverCamera;
	private MarsRoverInfo marsRoverInfo;
	
	public MarsRoverPhotos() {}

	public Integer getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}

	public String getSol() {
		return sol;
	}

	public void setSol(String sol) {
		this.sol = sol;
	}

	public String getImg_src() {
		return img_src;
	}

	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}

	public String getEarth_date() {
		return earth_date;
	}

	public void setEarth_date(String earth_date) {
		this.earth_date = earth_date;
	}

	public MarsRoverCamera getMarsRoverCamera() {
		return marsRoverCamera;
	}

	public void setMarsRoverCamera(MarsRoverCamera marsRoverCamera) {
		this.marsRoverCamera = marsRoverCamera;
	}

	public MarsRoverInfo getMarsRoverInfo() {
		return marsRoverInfo;
	}

	public void setMarsRoverInfo(MarsRoverInfo marsRoverInfo) {
		this.marsRoverInfo = marsRoverInfo;
	}

	@Override
	public String toString() {
		return "MarsRoverPhotos [id=" + id + ", sol=" + sol + ", img_src=" + img_src + ", earth_date=" + earth_date
				+ ", marsRoverCamera=" + marsRoverCamera + ", marsRoverInfo=" + marsRoverInfo + "]";
	}

		
}
