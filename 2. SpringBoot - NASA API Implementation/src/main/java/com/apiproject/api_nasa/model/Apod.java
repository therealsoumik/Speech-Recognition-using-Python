
package com.apiproject.api_nasa.model;

import java.util.Date;

public class Apod {
	
	private String apodDate;
	private String apodExplation;
	private String apodHdUrl;
	private String apodMedia_type;
	private String apodTitle;
	private String apodUrl;
	
	public Apod() {}

	public Apod(String apoddt, String apodExplation, String apodHdUrl, String apodMedia_type, String apodTitle,
			String apodUrl) {
		super();
		this.apodDate = apoddt;
		this.apodExplation = apodExplation;
		this.apodHdUrl = apodHdUrl;
		this.apodMedia_type = apodMedia_type;
		this.apodTitle = apodTitle;
		this.apodUrl = apodUrl;
	}

	public String getApoddt() {
		return apodDate;
	}

	public void setApoddt(String apodDate) {
		this.apodDate = apodDate;
	}

	public String getApodExplation() {
		return apodExplation;
	}

	public void setApodExplation(String apodExplation) {
		this.apodExplation = apodExplation;
	}

	public String getApodHdUrl() {
		return apodHdUrl;
	}

	public void setApodHdUrl(String apodHdUrl) {
		this.apodHdUrl = apodHdUrl;
	}

	public String getApodMedia_type() {
		return apodMedia_type;
	}

	public void setApodMedia_type(String apodMedia_type) {
		this.apodMedia_type = apodMedia_type;
	}

	public String getApodTitle() {
		return apodTitle;
	}

	public void setApodTitle(String apodTitle) {
		this.apodTitle = apodTitle;
	}

	public String getApodUrl() {
		return apodUrl;
	}

	public void setApodUrl(String apodUrl) {
		this.apodUrl = apodUrl;
	}

	@Override
	public String toString() {
		return "Apod [apoddate=" + apodDate + ", apodExplation=" + apodExplation + ", apodHdUrl=" + apodHdUrl
				+ ", apodMedia_type=" + apodMedia_type + ", apodTitle=" + apodTitle + ", apodUrl=" + apodUrl + "]";
	}
	
	
	
	

}
