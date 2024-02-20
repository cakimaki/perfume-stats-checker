package org.example.perfumestatschecker.repositories.perfume;

import org.example.perfumestatschecker.models.perfume.PerfumeVolume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfumeVolumeRepository extends JpaRepository<PerfumeVolume, Long> {
	Optional<PerfumeVolume> findByName(String volumename);
}
