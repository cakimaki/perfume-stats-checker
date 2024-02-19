package org.example.perfumestatschecker.repositories;

import org.example.perfumestatschecker.models.Brand;
import org.example.perfumestatschecker.models.Perfume;
import org.example.perfumestatschecker.models.PerfumeType;
import org.example.perfumestatschecker.models.PerfumeVolume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PerfumeRepository extends JpaRepository<Perfume, Long> {
	
	@Query("SELECT p FROM Perfume p WHERE p.name = :name AND p.brand = :brand AND p.type = :type AND p.volume = :volume")
	Optional<Perfume> findByNameAndVolumeAndType(@Param("name") String name, @Param("brand") Brand brand, @Param("type") PerfumeType type, @Param("volume") PerfumeVolume volume);
	
}
