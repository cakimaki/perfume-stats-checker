package org.example.perfumestatschecker.dtos;

public class PerfumeNameDto {
	private Long id;
	private String perfumeName;
	
	public String getPerfumeName() {
		return perfumeName;
	}
	
	public void setPerfumeName(String perfumeName) {
		this.perfumeName = perfumeName;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
