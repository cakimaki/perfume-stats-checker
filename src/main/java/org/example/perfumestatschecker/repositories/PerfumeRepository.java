package org.example.perfumestatschecker.repositories;

import org.example.perfumestatschecker.models.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfumeRepository extends JpaRepository<Perfume, Long> {

}
