package org.example.perfumestatschecker.repositories.offer;

import org.example.perfumestatschecker.models.offer.Site;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SiteRepository extends JpaRepository<Site,Long> {
	Optional<Site> findByName(String name);
}
