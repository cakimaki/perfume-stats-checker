package org.example.perfumestatschecker.repositories.perfume;

import org.example.perfumestatschecker.models.perfume.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PerfumeRepository extends JpaRepository<Perfume, Long> {
	
	@Query("SELECT p FROM Perfume p WHERE p.name = :name AND p.brand = :brand AND p.type = :type AND p.volume = :volume")
	Optional<Perfume> findByNameAndVolumeAndType(@Param("name") PerfumeName perfumeName, @Param("brand") Brand brand, @Param("type") PerfumeType type, @Param("volume") PerfumeVolume volume);
	
	@Query("SELECT p FROM Perfume p JOIN FETCH p.brand b JOIN FETCH p.type t JOIN FETCH p.volume v")
	List<Perfume> findAllWithDetails();
}
