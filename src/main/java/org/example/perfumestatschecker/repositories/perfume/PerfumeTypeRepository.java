package org.example.perfumestatschecker.repositories.perfume;

import org.example.perfumestatschecker.models.perfume.PerfumeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfumeTypeRepository extends JpaRepository<PerfumeType, Long>{
	Optional<PerfumeType> findByName(String name);
}
