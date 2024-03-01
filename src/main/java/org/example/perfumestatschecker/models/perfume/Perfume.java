package org.example.perfumestatschecker.models.perfume;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "perfume_name")
public class Perfume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "perfume_name")
	private String name;
	
	@OneToMany(mappedBy = "name")
	private List<Perfume> perfumes;
	
	//brand name of perfume
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	public Perfume(){
	
	}
	public Perfume(String name, List<Perfume> perfumes) {
		this.name = name;
		this.perfumes = perfumes;
	}
	
	public Brand getBrand() {
		return brand;
	}
	
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Perfume> getPerfumes() {
		return perfumes;
	}
	
	public void setPerfumes(List<Perfume> perfumes) {
		this.perfumes = perfumes;
	}
	
}
