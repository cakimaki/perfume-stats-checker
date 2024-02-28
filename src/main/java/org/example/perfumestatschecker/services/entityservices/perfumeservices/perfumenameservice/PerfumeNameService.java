package org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumenameservice;

import org.example.perfumestatschecker.models.perfume.PerfumeName;
import org.springframework.transaction.annotation.Transactional;

public interface PerfumeNameService {
	@Transactional
	PerfumeName findOrCreatePerfumeName(String name);
}
