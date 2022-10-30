package com.apiproject.api_nasa.model;

public class TechPort {
	
	private String title;
	private String description;
	private String benefits;
	private String startYear;
	
	public TechPort() {}

	public TechPort(String title, String description, String benefits, String startYear) {
		super();
		this.title = title;
		this.description = description;
		this.benefits = benefits;
		this.startYear = startYear;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	@Override
	public String toString() {
		return "TechPort [title=" + title + ", description=" + description + ", benefits=" + benefits + ", startYear="
				+ startYear + "]";
	}
	
	

}
