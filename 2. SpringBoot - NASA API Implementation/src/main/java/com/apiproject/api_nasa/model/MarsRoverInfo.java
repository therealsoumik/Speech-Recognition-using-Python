package com.apiproject.api_nasa.model;

public class MarsRoverInfo {
	
	private Integer id;
	private String name;
	private String landing_date;
	private String launch_date;
	private String status;
	
	public MarsRoverInfo() {}
	
	

	public MarsRoverInfo(Integer id, String name, String landing_date, String launch_date, String status) {
		super();
		this.id = id;
		this.name = name;
		this.landing_date = landing_date;
		this.launch_date = launch_date;
		this.status = status;
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

	public String getLanding_date() {
		return landing_date;
	}

	public void setLanding_date(String landing_date) {
		this.landing_date = landing_date;
	}

	public String getLaunch_date() {
		return launch_date;
	}

	public void setLaunch_date(String launch_date) {
		this.launch_date = launch_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MarsRoverInfo [id=" + id + ", name=" + name + ", landing_date=" + landing_date + ", launch_date="
				+ launch_date + ", status=" + status + "]";
	}
	
	
	
}
