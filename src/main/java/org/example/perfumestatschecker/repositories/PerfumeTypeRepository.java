package org.example.perfumestatschecker.repositories;

import org.example.perfumestatschecker.models.PerfumeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfumeTypeRepository extends JpaRepository<PerfumeType, Long>{
	Optional<PerfumeType> findByName(String name);
}
