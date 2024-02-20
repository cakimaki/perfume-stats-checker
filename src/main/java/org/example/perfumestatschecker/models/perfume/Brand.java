package org.example.perfumestatschecker.models.perfume;


import jakarta.persistence.*;
import org.example.perfumestatschecker.models.perfume.Perfume;

import java.util.List;

@Entity
@Table(name = "brand")
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "brand_name")
	private String name;
	
	@OneToMany(mappedBy = "brand")
	private List<Perfume> perfumes;
	
	public Brand() {
	}
	
	public Brand(String brandName, List<Perfume> perfumes) {
		this.name = brandName;
		this.perfumes = perfumes;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String brandName) {
		this.name = brandName;
	}
	
	public void setPerfumes(List<Perfume> perfumes) {
		this.perfumes = perfumes;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Perfume> getPerfumes() {
		return perfumes;
	}
}
