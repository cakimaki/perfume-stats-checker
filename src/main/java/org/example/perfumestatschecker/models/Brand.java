package org.example.perfumestatschecker.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "brand")
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "brand_name")
	private String brandName;
	
	@OneToMany(mappedBy = "brand")
	private List<Perfume> perfumes;
	
	public Brand() {
	}
	
	public Brand(String brandName, List<Perfume> perfumes) {
		this.brandName = brandName;
		this.perfumes = perfumes;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public void setPerfumes(List<Perfume> perfumes) {
		this.perfumes = perfumes;
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	public List<Perfume> getPerfumes() {
		return perfumes;
	}
}
