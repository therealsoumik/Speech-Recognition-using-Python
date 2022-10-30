package com.apiproject.api_nasa.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apiproject.api_nasa.model.Apod;
import com.apiproject.api_nasa.model.MarsRoverCamera;
import com.apiproject.api_nasa.model.MarsRoverInfo;
import com.apiproject.api_nasa.model.MarsRoverPhotos;
import com.apiproject.api_nasa.model.TechPort;
import com.apiproject.api_nasa.util.ApiCalls;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class HomeController {
	
	ApiCalls apiCallObj = new ApiCalls();
	Logger log = LoggerFactory.getLogger(HomeController.class);
	
	
	
	/*---------------- 1. APOD -----------------*/
	@RequestMapping(value = "/api_nasa")
	public ModelAndView apod() throws JsonMappingException, JsonProcessingException, JSONException, ParseException
	{
		ModelAndView mav = null;
		double requestID =  Math.floor((Math.random() * 1000)*100) / 100;
		mav = new ModelAndView("home");
		log.info("RequestID: {} - APOD REQUEST - STARTED", requestID);	
		
		/* -- 2. CALLING APOD API --*/
		Apod apodResponse = apiCallObj.apod_ApiCall(requestID);
		
		log.info("RequestID: {} - APOD REQUEST - Response - {}", requestID, apodResponse.toString());
		mav.addObject("apodResponse",apodResponse);
		
		
		/* -- 2. CALLING EPIC API --*/
		//---- NOT USING THIS API
		//String epicResponse = apiCallObj.epic_ApiCall(requestID);
		//log.info("RequestID: {} - EPIC REQUEST - Response - {}", requestID, epicResponse.toString());
		
		
		/* -- 3. CALLING MARS_ROVER API --*/
		String marsRoverResponse = apiCallObj.marsrover_ApiCall(requestID);
		//log.info("RequestID: {} - MARS_ROVER REQUEST - Response - {}", requestID, marsRoverResponse);
		
		List<MarsRoverPhotos> marsRoverPhotos = new ArrayList<>();
		
		JSONObject obj = new JSONObject(marsRoverResponse);
		
		JSONArray arr = obj.getJSONArray("photos");
		//Limiting the array size to 10 as the original size if big
		for (int j = 0; j < /*arr.length()*/ 10; j++) {
			//String post_id = arr.getJSONObject(i).getString("id");
			//int post_id = arr.getJSONObject(i).getInt("id");
			int i = new Random().nextInt(arr.length());
			
			MarsRoverPhotos mrp_Temp = new MarsRoverPhotos();
			mrp_Temp.setId(arr.getJSONObject(i).getInt("id"));
			//mrp_Temp.setSol((String) arr.getJSONObject(i).getInt("sol"));
			mrp_Temp.setSol(Integer.toString(arr.getJSONObject(i).getInt("sol")));
			mrp_Temp.setImg_src(arr.getJSONObject(i).getString("img_src"));
			mrp_Temp.setEarth_date(arr.getJSONObject(i).getString("earth_date"));
			mrp_Temp.setMarsRoverCamera(new MarsRoverCamera(arr.getJSONObject(i).getJSONObject("camera").getInt("id"), 
					arr.getJSONObject(i).getJSONObject("camera").getString("name"), arr.getJSONObject(i).getJSONObject("camera").getString("full_name")));
			mrp_Temp.setMarsRoverInfo(new MarsRoverInfo(arr.getJSONObject(i).getJSONObject("rover").getInt("id"),
					arr.getJSONObject(i).getJSONObject("rover").getString("name"), 
					arr.getJSONObject(i).getJSONObject("rover").getString("landing_date"),
					arr.getJSONObject(i).getJSONObject("rover").getString("launch_date"),
					arr.getJSONObject(i).getJSONObject("rover").getString("status")));
			
			marsRoverPhotos.add(mrp_Temp);
			
			
		}
		log.info("RequestID: {} - MARS_ROVER REQUEST - Response - {}", requestID, Arrays.toString(marsRoverPhotos.toArray()));
		mav.addObject("marsRoverPhotos",marsRoverPhotos);
		
		
		
		/* -- 3. CALLING TECHPORT API --*/
		String techportResponse = apiCallObj.techport_ApiCall(requestID);
		JSONObject techportObj = new JSONObject(techportResponse);

		JSONObject projectInfo = techportObj.getJSONObject("project");
		//System.out.println(projectInfo.getString("title"));
		
		
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		//Date date  = formatter.parse(projectInfo.get("startYear"));
		//System.out.println(date);
		
		TechPort techPortValue = new TechPort(projectInfo.getString("title"), projectInfo.getString("description"), projectInfo.getString("benefits"), Integer.toString(projectInfo.getInt("startYear")));
		
		log.info("RequestID: {} - TECHPORT REQUEST - Response - {}", requestID, techPortValue.toString());
		mav.addObject("techPortValue",techPortValue);
		return mav;
	}
	

}
