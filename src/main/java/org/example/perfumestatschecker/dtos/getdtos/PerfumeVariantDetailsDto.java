package org.example.perfumestatschecker.dtos.getdtos;

public class PerfumeVariantDetailsDto {
	private String perfumeName;
	private String brandName;
	private String volume;
	private String type;
	
	public PerfumeVariantDetailsDto() {
	}
	
	public String getPerfumeName() {
		return perfumeName;
	}
	
	public void setPerfumeName(String perfumeName) {
		this.perfumeName = perfumeName;
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public String getVolume() {
		return volume;
	}
	
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "PerfumeVariantDetailsDto{" +
				"perfumeName='" + perfumeName + '\'' +
				", brandName='" + brandName + '\'' +
				", volume='" + volume + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}
