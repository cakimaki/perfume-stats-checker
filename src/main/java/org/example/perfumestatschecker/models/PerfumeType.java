package org.example.perfumestatschecker.models;

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
	private List<Perfume> perfumes;
	
	public String getName() {
		return name;
	}
	
	public void setName(String type) {
		this.name = type;
	}
	
}
