package org.example.perfumestatschecker.repositories;

import org.example.perfumestatschecker.models.TimeChecked;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeCheckedRepository extends JpaRepository<TimeChecked, Long> {



}