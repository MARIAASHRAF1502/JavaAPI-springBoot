package com.example.demo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "ServerRecords")
public class ServerDetails {
	
	@Id
	private int id;
	private String name;
	private String language;
	private String framework;
	
	
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


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getFramework() {
		return framework;
	}


	public void setFramework(String framework) {
		this.framework = framework;
	}


	public ServerDetails(int id, String name, String language, String framework) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.framework = framework;
	}

}
