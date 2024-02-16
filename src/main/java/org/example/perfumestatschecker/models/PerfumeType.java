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
	private String type;
	
	@OneToMany(mappedBy = "type")
	private List<Perfume> perfumes;
}
