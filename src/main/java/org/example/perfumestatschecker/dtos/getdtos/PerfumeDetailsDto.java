package org.example.perfumestatschecker.dtos.getdtos;

public class PerfumeDetailsDto {
	private String perfumeName;
	private String brandName;
	private String volume;
	private String type;
	
	public String getPerfumeName() {
		return perfumeName;
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	public String getVolume() {
		return volume;
	}
	
	public String getType() {
		return type;
	}
	
	public void setPerfumeName(String perfumeName) {
		this.perfumeName = perfumeName;
	}
	
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "PerfumeDetailsDto{" +
				"perfumeName='" + perfumeName + '\'' +
				", brandName='" + brandName + '\'' +
				", volume='" + volume + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}
