package org.example.perfumestatschecker.dtos;

public class PerfumeDto {
	private Long id;
	private String perfumeName;
	private String brandName;
	public String getPerfumeName() {
		return perfumeName;
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	public void setBrandName(String brandName) {
		this.brandName = brandName;
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
