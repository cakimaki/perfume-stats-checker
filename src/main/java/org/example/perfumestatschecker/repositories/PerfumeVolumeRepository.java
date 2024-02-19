package org.example.perfumestatschecker.repositories;

import org.example.perfumestatschecker.models.Perfume;
import org.example.perfumestatschecker.models.PerfumeVolume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfumeVolumeRepository extends JpaRepository<PerfumeVolume, Long> {
	Optional<PerfumeVolume> findByName(String volumename);
}
