package org.example.perfumestatschecker.repositories.perfume;

import org.example.perfumestatschecker.models.perfume.Brand;
import org.example.perfumestatschecker.models.perfume.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PerfumeRepository extends JpaRepository<Perfume,Long> {
	
	@Query("SELECT p from Perfume p WHERE p.name = :perfumeName AND p.brand = :brand")
	Optional<Perfume> findByNameAndBrand(@Param("perfumeName")String name,@Param("brand") Brand brand);
	
}
