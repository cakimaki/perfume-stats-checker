package org.example.perfumestatschecker.models.perfume;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "perfume_type")
public class PerfumeType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "type")
	private String name;
	
	@OneToMany(mappedBy = "type")
	private List<PerfumeVariant> perfumesVariants;
	
	public PerfumeType() {
	}
	
	public PerfumeType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String type) {
		this.name = type;
	}
	
}
