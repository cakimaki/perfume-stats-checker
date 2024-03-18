package org.example.perfumestatschecker.models.perfume;


import jakarta.persistence.*;

import java.util.List;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name = "brand")
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
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
	
	public void setPerfumeNames(List<Perfume> perfumes) {
		this.perfumes = perfumes;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Perfume> getPerfumeNames() {
		return perfumes;
	}
}
