package org.example.perfumestatschecker.models.perfume;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "perfume_volume")
public class PerfumeVolume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "volume")
	private String name;
	
	@OneToMany(mappedBy = "volume")
	private List<PerfumeVariant> perfumeVariant;
	
	public PerfumeVolume(){}
	public PerfumeVolume(String name, List<PerfumeVariant> perfumeVariant) {
		this.name = name;
		this.perfumeVariant = perfumeVariant;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<PerfumeVariant> getPerfumeVariant() {
		return perfumeVariant;
	}
	
	public void setPerfumeVariant(List<PerfumeVariant> perfumeVariant) {
		this.perfumeVariant = perfumeVariant;
	}
}
