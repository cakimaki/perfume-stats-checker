package org.example.perfumestatschecker.models;

import jakarta.persistence.*;

@Entity
@Table(name = "perfume")
public class Perfume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
}