package org.example.perfumestatschecker.services.perfumetypeservice;

import org.example.perfumestatschecker.models.PerfumeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfumeTypeService extends JpaRepository<PerfumeType,Long> {

}
