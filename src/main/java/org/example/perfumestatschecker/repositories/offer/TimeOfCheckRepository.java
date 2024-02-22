package org.example.perfumestatschecker.repositories.offer;

import org.example.perfumestatschecker.models.offer.TimeOfCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TimeOfCheckRepository extends JpaRepository<TimeOfCheck, Long> {



}