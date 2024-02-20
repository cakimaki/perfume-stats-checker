package org.example.perfumestatschecker.models.perfume;


import jakarta.persistence.*;
import org.example.perfumestatschecker.models.perfume.Perfume;

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
	private List<Perfume> perfumes;
	
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
