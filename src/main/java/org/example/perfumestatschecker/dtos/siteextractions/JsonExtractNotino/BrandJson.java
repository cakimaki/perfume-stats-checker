package org.example.perfumestatschecker.dtos.siteextractions.JsonExtractNotino;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class BrandJson {
	private String Name;
	
	public BrandJson() {
	}
	
	public BrandJson(String name) {
		Name = name;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
}
