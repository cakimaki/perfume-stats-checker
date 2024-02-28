package org.example.perfumestatschecker.repositories.perfume;

import org.example.perfumestatschecker.models.perfume.PerfumeName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfumeNameRepository extends JpaRepository<PerfumeName,Long> {
	Optional<PerfumeName> findByName(String name);
}
