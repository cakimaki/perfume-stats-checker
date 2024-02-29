package org.example.perfumestatschecker.models.perfume;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "perfume_name")
public class PerfumeName {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "perfume_name")
	private String name;
	
	@OneToMany(mappedBy = "name")
	private List<Perfume> perfumes;
	
	public PerfumeName(){
	
	}
	public PerfumeName(String name, List<Perfume> perfumes) {
		this.name = name;
		this.perfumes = perfumes;
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
