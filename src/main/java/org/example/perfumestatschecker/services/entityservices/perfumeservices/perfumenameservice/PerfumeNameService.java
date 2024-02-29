package org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumenameservice;

import org.example.perfumestatschecker.dtos.PerfumeNameDto;
import org.example.perfumestatschecker.models.perfume.PerfumeName;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface PerfumeNameService {
	@Transactional
	PerfumeName findOrCreatePerfumeName(String name);
	
	@Transactional
	List<PerfumeNameDto> getAllPerfumeNames();
}
