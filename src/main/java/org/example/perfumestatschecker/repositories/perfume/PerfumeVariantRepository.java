package org.example.perfumestatschecker.repositories.perfume;

import org.example.perfumestatschecker.models.perfume.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PerfumeVariantRepository extends JpaRepository<PerfumeVariant, Long> {
	
	@Query("SELECT pv FROM PerfumeVariant pv " +
			"WHERE pv.perfume = :perfumeName AND pv.type = :type AND pv.volume = :volume")
	Optional<PerfumeVariant> findByPerfumeAndVolumeAndType(@Param("perfumeName") Perfume perfume, @Param("type") PerfumeType type, @Param("volume") PerfumeVolume volume);
	
	@Query("SELECT pv FROM PerfumeVariant pv JOIN FETCH pv.type t JOIN FETCH pv.volume v")
	List<PerfumeVariant> findAllWithDetails();
}
