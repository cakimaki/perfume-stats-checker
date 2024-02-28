package org.example.perfumestatschecker.models.account;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<UserRole> userRoles = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<Account> accounts = new ArrayList<>();
}
