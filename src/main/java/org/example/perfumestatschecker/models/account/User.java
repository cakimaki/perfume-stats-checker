package org.example.perfumestatschecker.models.account;

import com.google.j2objc.annotations.OnDealloc;
import jakarta.persistence.*;

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
	
}
