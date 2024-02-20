package org.example.perfumestatschecker.repositories.perfume;

import org.example.perfumestatschecker.models.perfume.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {
	Optional<Brand> findByName(String name);
}
