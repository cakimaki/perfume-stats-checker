package org.example.perfumestatschecker.models.account;


import jakarta.persistence.*;

@Entity
@Table(name= "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
}
