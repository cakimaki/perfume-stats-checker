package org.example.perfumestatschecker.models.app;

import jakarta.persistence.*;

@Entity
@Table(name = "exceptions_thrown")
public class Exceptions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
}
